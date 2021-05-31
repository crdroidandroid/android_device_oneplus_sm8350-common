package com.oneplus.os;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.oneplus.appboot.AppControlMode;
import com.oneplus.frontmonitor.IFrontListener;
import com.oneplus.highpower.HighPowerApp;
import java.util.List;

public interface IOnePlusService extends IInterface {
    void changeFont(int i, int i2) throws RemoteException;

    boolean checkPreLoadCacheEnable(String str) throws RemoteException;

    void disableTheme(String str) throws RemoteException;

    void enableTheme(String str) throws RemoteException;

    void flingEvent(String str, int i) throws RemoteException;

    List<AppControlMode> getAllAppControlModes(int i) throws RemoteException;

    int getAppControlMode(String str, int i) throws RemoteException;

    int getAppControlState(int i) throws RemoteException;

    List<HighPowerApp> getBgPowerHungryList() throws RemoteException;

    List<String> getBlackList() throws RemoteException;

    int getDynamicVsyncConfig(String str) throws RemoteException;

    List<String> getGameMultiTouchList() throws RemoteException;

    String getGameShakeConfig(String str) throws RemoteException;

    List<String> getWhiteList() throws RemoteException;

    boolean isFullscreenScene() throws RemoteException;

    boolean isInConfigList(int i, String str) throws RemoteException;

    boolean isInSpecialTesting() throws RemoteException;

    void noteBluetoothConnectedChanged(String str, boolean z) throws RemoteException;

    void noteRfcommSocketToServiceRecord(int i, int i2) throws RemoteException;

    void noteStartAudio(int i, int i2) throws RemoteException;

    void noteStartVideo(int i, int i2) throws RemoteException;

    void noteStopAudio(int i, int i2) throws RemoteException;

    void noteStopVideo(int i, int i2) throws RemoteException;

    void notifySurfaceFlingerUpdate() throws RemoteException;

    void processDisableThemeCategory(String str, String str2) throws RemoteException;

    void processEnableThemeCategory(String str, String str2) throws RemoteException;

    void registerFrontActivityListener(IFrontListener iFrontListener) throws RemoteException;

    void reportSyspropChanged() throws RemoteException;

    void resume(String str) throws RemoteException;

    int setAppControlMode(String str, int i, int i2) throws RemoteException;

    int setAppControlState(int i, int i2) throws RemoteException;

    void stopBgPowerHungryApp(String str, int i) throws RemoteException;

    void unregisterFrontActivityListener(IFrontListener iFrontListener) throws RemoteException;

    void updateVelocity(String str, float f, double d) throws RemoteException;

    public static class Default implements IOnePlusService {
        @Override
        public void enableTheme(String category) throws RemoteException {
        }

        @Override
        public void disableTheme(String category) throws RemoteException {
        }

        @Override
        public void processEnableThemeCategory(String category, String secondaryCategory) throws RemoteException {
        }

        @Override
        public void processDisableThemeCategory(String category, String secondaryCategory) throws RemoteException {
        }

        @Override
        public List<AppControlMode> getAllAppControlModes(int mode) throws RemoteException {
            return null;
        }

        @Override
        public int getAppControlMode(String packageName, int mode) throws RemoteException {
            return 0;
        }

        @Override
        public int setAppControlMode(String packageName, int mode, int value) throws RemoteException {
            return 0;
        }

        @Override
        public int getAppControlState(int mode) throws RemoteException {
            return 0;
        }

        @Override
        public int setAppControlState(int mode, int on) throws RemoteException {
            return 0;
        }

        @Override
        public List<HighPowerApp> getBgPowerHungryList() throws RemoteException {
            return null;
        }

        @Override
        public void stopBgPowerHungryApp(String pkg, int powerLevel) throws RemoteException {
        }

        @Override
        public void notifySurfaceFlingerUpdate() throws RemoteException {
        }

        @Override
        public boolean isInConfigList(int type, String verifyStr) throws RemoteException {
            return false;
        }

        @Override
        public boolean isInSpecialTesting() throws RemoteException {
            return false;
        }

        @Override
        public String getGameShakeConfig(String pkgName) throws RemoteException {
            return null;
        }

        @Override
        public List<String> getGameMultiTouchList() throws RemoteException {
            return null;
        }

        @Override
        public void flingEvent(String pkgName, int duration) throws RemoteException {
        }

        @Override
        public void resume(String reason) throws RemoteException {
        }

        @Override
        public void updateVelocity(String pkgName, float currVelocity, double distance) throws RemoteException {
        }

        @Override
        public int getDynamicVsyncConfig(String pkgName) throws RemoteException {
            return 0;
        }

        @Override
        public void noteStartAudio(int uid, int pid) throws RemoteException {
        }

        @Override
        public void noteStopAudio(int uid, int pid) throws RemoteException {
        }

        @Override
        public void noteStartVideo(int uid, int pid) throws RemoteException {
        }

        @Override
        public void noteStopVideo(int uid, int pid) throws RemoteException {
        }

        @Override
        public void noteBluetoothConnectedChanged(String pkg, boolean using) throws RemoteException {
        }

        @Override
        public void noteRfcommSocketToServiceRecord(int uid, int pid) throws RemoteException {
        }

        @Override
        public void reportSyspropChanged() throws RemoteException {
        }

        @Override
        public boolean checkPreLoadCacheEnable(String pkg) throws RemoteException {
            return false;
        }

        @Override
        public List<String> getWhiteList() throws RemoteException {
            return null;
        }

        @Override
        public List<String> getBlackList() throws RemoteException {
            return null;
        }

        @Override
        public void registerFrontActivityListener(IFrontListener listener) throws RemoteException {
        }

        @Override
        public void unregisterFrontActivityListener(IFrontListener listener) throws RemoteException {
        }

        @Override
        public void changeFont(int userID, int fontID) throws RemoteException {
        }

        @Override
        public boolean isFullscreenScene() throws RemoteException {
            return false;
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOnePlusService {
        private static final String DESCRIPTOR = "com.oneplus.os.IOnePlusService";
        static final int TRANSACTION_changeFont = 33;
        static final int TRANSACTION_checkPreLoadCacheEnable = 28;
        static final int TRANSACTION_disableTheme = 2;
        static final int TRANSACTION_enableTheme = 1;
        static final int TRANSACTION_flingEvent = 17;
        static final int TRANSACTION_getAllAppControlModes = 5;
        static final int TRANSACTION_getAppControlMode = 6;
        static final int TRANSACTION_getAppControlState = 8;
        static final int TRANSACTION_getBgPowerHungryList = 10;
        static final int TRANSACTION_getBlackList = 30;
        static final int TRANSACTION_getDynamicVsyncConfig = 20;
        static final int TRANSACTION_getGameMultiTouchList = 16;
        static final int TRANSACTION_getGameShakeConfig = 15;
        static final int TRANSACTION_getWhiteList = 29;
        static final int TRANSACTION_isFullscreenScene = 34;
        static final int TRANSACTION_isInConfigList = 13;
        static final int TRANSACTION_isInSpecialTesting = 14;
        static final int TRANSACTION_noteBluetoothConnectedChanged = 25;
        static final int TRANSACTION_noteRfcommSocketToServiceRecord = 26;
        static final int TRANSACTION_noteStartAudio = 21;
        static final int TRANSACTION_noteStartVideo = 23;
        static final int TRANSACTION_noteStopAudio = 22;
        static final int TRANSACTION_noteStopVideo = 24;
        static final int TRANSACTION_notifySurfaceFlingerUpdate = 12;
        static final int TRANSACTION_processDisableThemeCategory = 4;
        static final int TRANSACTION_processEnableThemeCategory = 3;
        static final int TRANSACTION_registerFrontActivityListener = 31;
        static final int TRANSACTION_reportSyspropChanged = 27;
        static final int TRANSACTION_resume = 18;
        static final int TRANSACTION_setAppControlMode = 7;
        static final int TRANSACTION_setAppControlState = 9;
        static final int TRANSACTION_stopBgPowerHungryApp = 11;
        static final int TRANSACTION_unregisterFrontActivityListener = 32;
        static final int TRANSACTION_updateVelocity = 19;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOnePlusService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IOnePlusService)) {
                return new Proxy(obj);
            }
            return (IOnePlusService) iin;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "enableTheme";
                case 2:
                    return "disableTheme";
                case 3:
                    return "processEnableThemeCategory";
                case 4:
                    return "processDisableThemeCategory";
                case 5:
                    return "getAllAppControlModes";
                case 6:
                    return "getAppControlMode";
                case 7:
                    return "setAppControlMode";
                case 8:
                    return "getAppControlState";
                case 9:
                    return "setAppControlState";
                case 10:
                    return "getBgPowerHungryList";
                case 11:
                    return "stopBgPowerHungryApp";
                case 12:
                    return "notifySurfaceFlingerUpdate";
                case 13:
                    return "isInConfigList";
                case 14:
                    return "isInSpecialTesting";
                case 15:
                    return "getGameShakeConfig";
                case 16:
                    return "getGameMultiTouchList";
                case 17:
                    return "flingEvent";
                case 18:
                    return "resume";
                case 19:
                    return "updateVelocity";
                case 20:
                    return "getDynamicVsyncConfig";
                case 21:
                    return "noteStartAudio";
                case 22:
                    return "noteStopAudio";
                case 23:
                    return "noteStartVideo";
                case 24:
                    return "noteStopVideo";
                case 25:
                    return "noteBluetoothConnectedChanged";
                case 26:
                    return "noteRfcommSocketToServiceRecord";
                case 27:
                    return "reportSyspropChanged";
                case 28:
                    return "checkPreLoadCacheEnable";
                case 29:
                    return "getWhiteList";
                case 30:
                    return "getBlackList";
                case 31:
                    return "registerFrontActivityListener";
                case 32:
                    return "unregisterFrontActivityListener";
                case 33:
                    return "changeFont";
                case 34:
                    return "isFullscreenScene";
                default:
                    return null;
            }
        }

        @Override
        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code != 1598968902) {
                switch (code) {
                    case 1:
                        data.enforceInterface(DESCRIPTOR);
                        enableTheme(data.readString());
                        reply.writeNoException();
                        return true;
                    case 2:
                        data.enforceInterface(DESCRIPTOR);
                        disableTheme(data.readString());
                        reply.writeNoException();
                        return true;
                    case 3:
                        data.enforceInterface(DESCRIPTOR);
                        processEnableThemeCategory(data.readString(), data.readString());
                        reply.writeNoException();
                        return true;
                    case 4:
                        data.enforceInterface(DESCRIPTOR);
                        processDisableThemeCategory(data.readString(), data.readString());
                        reply.writeNoException();
                        return true;
                    case 5:
                        data.enforceInterface(DESCRIPTOR);
                        List<AppControlMode> _result = getAllAppControlModes(data.readInt());
                        reply.writeNoException();
                        reply.writeTypedList(_result);
                        return true;
                    case 6:
                        data.enforceInterface(DESCRIPTOR);
                        int _result2 = getAppControlMode(data.readString(), data.readInt());
                        reply.writeNoException();
                        reply.writeInt(_result2);
                        return true;
                    case 7:
                        data.enforceInterface(DESCRIPTOR);
                        int _result3 = setAppControlMode(data.readString(), data.readInt(), data.readInt());
                        reply.writeNoException();
                        reply.writeInt(_result3);
                        return true;
                    case 8:
                        data.enforceInterface(DESCRIPTOR);
                        int _result4 = getAppControlState(data.readInt());
                        reply.writeNoException();
                        reply.writeInt(_result4);
                        return true;
                    case 9:
                        data.enforceInterface(DESCRIPTOR);
                        int _result5 = setAppControlState(data.readInt(), data.readInt());
                        reply.writeNoException();
                        reply.writeInt(_result5);
                        return true;
                    case 10:
                        data.enforceInterface(DESCRIPTOR);
                        List<HighPowerApp> _result6 = getBgPowerHungryList();
                        reply.writeNoException();
                        reply.writeTypedList(_result6);
                        return true;
                    case 11:
                        data.enforceInterface(DESCRIPTOR);
                        stopBgPowerHungryApp(data.readString(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 12:
                        data.enforceInterface(DESCRIPTOR);
                        notifySurfaceFlingerUpdate();
                        return true;
                    case 13:
                        data.enforceInterface(DESCRIPTOR);
                        boolean isInConfigList = isInConfigList(data.readInt(), data.readString());
                        reply.writeNoException();
                        reply.writeInt(isInConfigList ? 1 : 0);
                        return true;
                    case 14:
                        data.enforceInterface(DESCRIPTOR);
                        boolean isInSpecialTesting = isInSpecialTesting();
                        reply.writeNoException();
                        reply.writeInt(isInSpecialTesting ? 1 : 0);
                        return true;
                    case 15:
                        data.enforceInterface(DESCRIPTOR);
                        String _result7 = getGameShakeConfig(data.readString());
                        reply.writeNoException();
                        reply.writeString(_result7);
                        return true;
                    case 16:
                        data.enforceInterface(DESCRIPTOR);
                        List<String> _result8 = getGameMultiTouchList();
                        reply.writeNoException();
                        reply.writeStringList(_result8);
                        return true;
                    case 17:
                        data.enforceInterface(DESCRIPTOR);
                        flingEvent(data.readString(), data.readInt());
                        return true;
                    case 18:
                        data.enforceInterface(DESCRIPTOR);
                        resume(data.readString());
                        return true;
                    case 19:
                        data.enforceInterface(DESCRIPTOR);
                        updateVelocity(data.readString(), data.readFloat(), data.readDouble());
                        return true;
                    case 20:
                        data.enforceInterface(DESCRIPTOR);
                        int _result9 = getDynamicVsyncConfig(data.readString());
                        reply.writeNoException();
                        reply.writeInt(_result9);
                        return true;
                    case 21:
                        data.enforceInterface(DESCRIPTOR);
                        noteStartAudio(data.readInt(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 22:
                        data.enforceInterface(DESCRIPTOR);
                        noteStopAudio(data.readInt(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 23:
                        data.enforceInterface(DESCRIPTOR);
                        noteStartVideo(data.readInt(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 24:
                        data.enforceInterface(DESCRIPTOR);
                        noteStopVideo(data.readInt(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 25:
                        data.enforceInterface(DESCRIPTOR);
                        noteBluetoothConnectedChanged(data.readString(), data.readInt() != 0);
                        reply.writeNoException();
                        return true;
                    case 26:
                        data.enforceInterface(DESCRIPTOR);
                        noteRfcommSocketToServiceRecord(data.readInt(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 27:
                        data.enforceInterface(DESCRIPTOR);
                        reportSyspropChanged();
                        reply.writeNoException();
                        return true;
                    case 28:
                        data.enforceInterface(DESCRIPTOR);
                        boolean checkPreLoadCacheEnable = checkPreLoadCacheEnable(data.readString());
                        reply.writeNoException();
                        reply.writeInt(checkPreLoadCacheEnable ? 1 : 0);
                        return true;
                    case 29:
                        data.enforceInterface(DESCRIPTOR);
                        List<String> _result10 = getWhiteList();
                        reply.writeNoException();
                        reply.writeStringList(_result10);
                        return true;
                    case 30:
                        data.enforceInterface(DESCRIPTOR);
                        List<String> _result11 = getBlackList();
                        reply.writeNoException();
                        reply.writeStringList(_result11);
                        return true;
                    case 31:
                        data.enforceInterface(DESCRIPTOR);
                        registerFrontActivityListener(IFrontListener.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 32:
                        data.enforceInterface(DESCRIPTOR);
                        unregisterFrontActivityListener(IFrontListener.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    case 33:
                        data.enforceInterface(DESCRIPTOR);
                        changeFont(data.readInt(), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 34:
                        data.enforceInterface(DESCRIPTOR);
                        boolean isFullscreenScene = isFullscreenScene();
                        reply.writeNoException();
                        reply.writeInt(isFullscreenScene ? 1 : 0);
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            } else {
                reply.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IOnePlusService {
            public static IOnePlusService sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override
            public void enableTheme(String category) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(category);
                    if (this.mRemote.transact(1, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().enableTheme(category);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void disableTheme(String category) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(category);
                    if (this.mRemote.transact(2, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().disableTheme(category);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void processEnableThemeCategory(String category, String secondaryCategory) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(category);
                    _data.writeString(secondaryCategory);
                    if (this.mRemote.transact(3, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().processEnableThemeCategory(category, secondaryCategory);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void processDisableThemeCategory(String category, String secondaryCategory) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(category);
                    _data.writeString(secondaryCategory);
                    if (this.mRemote.transact(4, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().processDisableThemeCategory(category, secondaryCategory);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public List<AppControlMode> getAllAppControlModes(int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode);
                    if (!this.mRemote.transact(5, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAllAppControlModes(mode);
                    }
                    _reply.readException();
                    List<AppControlMode> _result = _reply.createTypedArrayList(AppControlMode.CREATOR);
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getAppControlMode(String packageName, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(mode);
                    if (!this.mRemote.transact(6, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppControlMode(packageName, mode);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int setAppControlMode(String packageName, int mode, int value) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(mode);
                    _data.writeInt(value);
                    if (!this.mRemote.transact(7, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAppControlMode(packageName, mode, value);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getAppControlState(int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode);
                    if (!this.mRemote.transact(8, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getAppControlState(mode);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int setAppControlState(int mode, int on) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(mode);
                    _data.writeInt(on);
                    if (!this.mRemote.transact(9, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().setAppControlState(mode, on);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public List<HighPowerApp> getBgPowerHungryList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(10, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBgPowerHungryList();
                    }
                    _reply.readException();
                    List<HighPowerApp> _result = _reply.createTypedArrayList(HighPowerApp.CREATOR);
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void stopBgPowerHungryApp(String pkg, int powerLevel) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(powerLevel);
                    if (this.mRemote.transact(11, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().stopBgPowerHungryApp(pkg, powerLevel);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void notifySurfaceFlingerUpdate() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(12, _data, null, 1) || Stub.getDefaultImpl() == null) {
                        _data.recycle();
                    } else {
                        Stub.getDefaultImpl().notifySurfaceFlingerUpdate();
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public boolean isInConfigList(int type, String verifyStr) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(verifyStr);
                    boolean _result = false;
                    if (!this.mRemote.transact(13, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isInConfigList(type, verifyStr);
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isInSpecialTesting() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _result = false;
                    if (!this.mRemote.transact(14, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isInSpecialTesting();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String getGameShakeConfig(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    if (!this.mRemote.transact(15, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGameShakeConfig(pkgName);
                    }
                    _reply.readException();
                    String _result = _reply.readString();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public List<String> getGameMultiTouchList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(16, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getGameMultiTouchList();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void flingEvent(String pkgName, int duration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(duration);
                    if (this.mRemote.transact(17, _data, null, 1) || Stub.getDefaultImpl() == null) {
                        _data.recycle();
                    } else {
                        Stub.getDefaultImpl().flingEvent(pkgName, duration);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void resume(String reason) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(reason);
                    if (this.mRemote.transact(18, _data, null, 1) || Stub.getDefaultImpl() == null) {
                        _data.recycle();
                    } else {
                        Stub.getDefaultImpl().resume(reason);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void updateVelocity(String pkgName, float currVelocity, double distance) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeFloat(currVelocity);
                    _data.writeDouble(distance);
                    if (this.mRemote.transact(19, _data, null, 1) || Stub.getDefaultImpl() == null) {
                        _data.recycle();
                    } else {
                        Stub.getDefaultImpl().updateVelocity(pkgName, currVelocity, distance);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public int getDynamicVsyncConfig(String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkgName);
                    if (!this.mRemote.transact(20, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getDynamicVsyncConfig(pkgName);
                    }
                    _reply.readException();
                    int _result = _reply.readInt();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteStartAudio(int uid, int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    if (this.mRemote.transact(21, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().noteStartAudio(uid, pid);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteStopAudio(int uid, int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    if (this.mRemote.transact(22, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().noteStopAudio(uid, pid);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteStartVideo(int uid, int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    if (this.mRemote.transact(23, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().noteStartVideo(uid, pid);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteStopVideo(int uid, int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    if (this.mRemote.transact(24, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().noteStopVideo(uid, pid);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteBluetoothConnectedChanged(String pkg, boolean using) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(using ? 1 : 0);
                    if (this.mRemote.transact(25, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().noteBluetoothConnectedChanged(pkg, using);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void noteRfcommSocketToServiceRecord(int uid, int pid) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(uid);
                    _data.writeInt(pid);
                    if (this.mRemote.transact(26, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().noteRfcommSocketToServiceRecord(uid, pid);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void reportSyspropChanged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(27, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().reportSyspropChanged();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean checkPreLoadCacheEnable(String pkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(pkg);
                    boolean _result = false;
                    if (!this.mRemote.transact(28, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().checkPreLoadCacheEnable(pkg);
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public List<String> getWhiteList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(29, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getWhiteList();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public List<String> getBlackList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(30, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBlackList();
                    }
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void registerFrontActivityListener(IFrontListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    if (this.mRemote.transact(31, _data, null, 1) || Stub.getDefaultImpl() == null) {
                        _data.recycle();
                    } else {
                        Stub.getDefaultImpl().registerFrontActivityListener(listener);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void unregisterFrontActivityListener(IFrontListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    if (this.mRemote.transact(32, _data, null, 1) || Stub.getDefaultImpl() == null) {
                        _data.recycle();
                    } else {
                        Stub.getDefaultImpl().unregisterFrontActivityListener(listener);
                    }
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void changeFont(int userID, int fontID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(userID);
                    _data.writeInt(fontID);
                    if (this.mRemote.transact(33, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().changeFont(userID, fontID);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isFullscreenScene() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean _result = false;
                    if (!this.mRemote.transact(34, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isFullscreenScene();
                    }
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = true;
                    }
                    _reply.recycle();
                    _data.recycle();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOnePlusService impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (impl == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = impl;
                return true;
            }
        }

        public static IOnePlusService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
