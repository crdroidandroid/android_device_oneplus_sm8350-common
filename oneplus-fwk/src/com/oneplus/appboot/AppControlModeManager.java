package com.oneplus.appboot;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Singleton;
import android.util.Slog;
import com.oneplus.os.IOnePlusService;
import java.util.List;

public class AppControlModeManager {
    public static final String OPSERVICE = "opservice";
    private static final String TAG = "AppControlModeManager";
    private static final Singleton<IOnePlusService> sCREATOR = new Singleton<IOnePlusService>() {
        @Override
        protected IOnePlusService create() {
            IBinder b = ServiceManager.getService("opservice");
            if (b == null) {
                Slog.e(AppControlModeManager.TAG, "can't get service binder: AppControlModeManager");
                return null;
            }
            IOnePlusService ret = IOnePlusService.Stub.asInterface(b);
            if (ret == null) {
                Slog.e(AppControlModeManager.TAG, "can't get service interface: AppControlModeManager");
            }
            return ret;
        }
    };
    private static IOnePlusService sService;

    public static IOnePlusService getDefault() {
        return sCREATOR.get();
    }

    public AppControlModeManager(Context context) {
    }

    public static List<AppControlMode> getAllAppControlModes(int mode) {
        try {
            return getService().getAllAppControlModes(mode);
        } catch (RemoteException e) {
            return null;
        }
    }

    public static int getAppControlMode(String packageName, int mode) {
        try {
            return getService().getAppControlMode(packageName, mode);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int setAppControlMode(String packageName, int mode, int value) {
        try {
            return getService().setAppControlMode(packageName, mode, value);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int getAppControlState(int mode) {
        try {
            return getService().getAppControlState(mode);
        } catch (RemoteException e) {
            return -1;
        }
    }

    public static int setAppControlState(int mode, int on) {
        try {
            return getService().setAppControlState(mode, on);
        } catch (RemoteException e) {
            return -1;
        }
    }

    private static IOnePlusService getService() {
        IOnePlusService iOnePlusService = sService;
        if (iOnePlusService != null) {
            return iOnePlusService;
        }
        IOnePlusService iOnePlusService2 = getDefault();
        sService = iOnePlusService2;
        return iOnePlusService2;
    }
}
