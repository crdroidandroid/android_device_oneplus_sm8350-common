package com.oneplus.frontmonitor;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.Singleton;
import android.util.Slog;
import com.oneplus.frontmonitor.IFrontListener;
import com.oneplus.os.IOnePlusService;

public class FrontMonitorManager {
    private static final Singleton<IOnePlusService> IOnePlusServiceSingleton = new Singleton<IOnePlusService>() {
        @Override
        protected IOnePlusService create() {
            IBinder b = ServiceManager.getService("opservice");
            if (b == null) {
                Slog.e(FrontMonitorManager.TAG, "can't get service binder: FrontMonitorManager");
                return null;
            }
            IOnePlusService ret = IOnePlusService.Stub.asInterface(b);
            if (ret == null) {
                Slog.e(FrontMonitorManager.TAG, "can't get service interface: FrontMonitorManager");
            }
            return ret;
        }
    };
    private static final String OPSERVICE = "opservice";
    private static final String TAG = "FrontMonitorManager";
    private static IOnePlusService sOpService;
    private static ArrayMap<FrontActivityListener, ListenerWrapper> sWrappers;

    public boolean registerListener(FrontActivityListener listener) {
        return registerListenerImpl(listener);
    }

    public boolean unregisterListener(FrontActivityListener listener) {
        return unregisterListenerImpl(listener);
    }

    private boolean registerListenerImpl(FrontActivityListener listener) {
        if (listener == null) {
            Slog.e(TAG, "null listener in register!");
            return false;
        }
        synchronized (FrontMonitorManager.class) {
            if (sWrappers == null) {
                sWrappers = new ArrayMap<>();
            }
            if (sWrappers.get(listener) == null) {
                ListenerWrapper wrapper = new ListenerWrapper(listener);
                sWrappers.put(listener, wrapper);
                try {
                    getOpService().registerFrontActivityListener(wrapper);
                    return true;
                } catch (RemoteException ex) {
                    ex.printStackTrace();
                    synchronized (FrontMonitorManager.class) {
                        if (sWrappers != null) {
                            sWrappers.remove(listener);
                        }
                        return false;
                    }
                }
            } else {
                Slog.i(TAG, "duplicate register " + listener);
                return false;
            }
        }
    }

    public boolean unregisterListenerImpl(FrontActivityListener listener) {
        ListenerWrapper wrapper;
        if (listener == null) {
            Slog.e(TAG, "null listener in unregister!");
            return false;
        }
        synchronized (FrontMonitorManager.class) {
            if (sWrappers == null) {
                sWrappers = new ArrayMap<>();
            }
            wrapper = sWrappers.get(listener);
            if (wrapper == null) {
                Slog.i(TAG, "not register yet " + listener);
                return false;
            }
        }
        try {
            getOpService().unregisterFrontActivityListener(wrapper);
            synchronized (FrontMonitorManager.class) {
                if (sWrappers != null) {
                    sWrappers.remove(listener);
                }
            }
            return true;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public final class ListenerWrapper extends IFrontListener.Stub {
        final FrontActivityListener mListener;

        public ListenerWrapper(FrontActivityListener listener) {
            this.mListener = listener;
        }

        @Override
        public void frontActivityChange(String activityName, String packageName, int uid, int pid) {
            FrontActivityListener frontActivityListener = this.mListener;
            if (frontActivityListener != null) {
                frontActivityListener.frontActivityChange(activityName, packageName, uid, pid);
            }
        }
    }

    private static IOnePlusService getOpService() {
        return IOnePlusServiceSingleton.get();
    }
}
