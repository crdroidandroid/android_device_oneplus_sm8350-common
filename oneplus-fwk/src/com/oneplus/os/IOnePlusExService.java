package com.oneplus.os;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

public interface IOnePlusExService extends IInterface {
    void dumpLightBugreport(String str) throws RemoteException;

    int getUserVibratorSceneId(Uri uri, int i) throws RemoteException;

    void monitorSceneChanging(boolean z) throws RemoteException;

    void shutdown() throws RemoteException;

    void startApkInstall(String str) throws RemoteException;

    void updateUserVibratorSceneIds(Map map, int i) throws RemoteException;

    public static class Default implements IOnePlusExService {
        @Override
        public void updateUserVibratorSceneIds(Map scendIdMaps, int userId) throws RemoteException {
        }

        @Override
        public int getUserVibratorSceneId(Uri ringtoneUri, int userId) throws RemoteException {
            return 0;
        }

        @Override
        public void startApkInstall(String apkPath) throws RemoteException {
        }

        @Override
        public void dumpLightBugreport(String tag) throws RemoteException {
        }

        @Override
        public void monitorSceneChanging(boolean enabled) throws RemoteException {
        }

        @Override
        public void shutdown() throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOnePlusExService {
        private static final String DESCRIPTOR = "com.oneplus.os.IOnePlusExService";
        static final int TRANSACTION_dumpLightBugreport = 4;
        static final int TRANSACTION_getUserVibratorSceneId = 2;
        static final int TRANSACTION_monitorSceneChanging = 5;
        static final int TRANSACTION_shutdown = 6;
        static final int TRANSACTION_startApkInstall = 3;
        static final int TRANSACTION_updateUserVibratorSceneIds = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IOnePlusExService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin == null || !(iin instanceof IOnePlusExService)) {
                return new Proxy(obj);
            }
            return (IOnePlusExService) iin;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "updateUserVibratorSceneIds";
                case 2:
                    return "getUserVibratorSceneId";
                case 3:
                    return "startApkInstall";
                case 4:
                    return "dumpLightBugreport";
                case 5:
                    return "monitorSceneChanging";
                case 6:
                    return "shutdown";
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
            Uri _arg0;
            if (code != 1598968902) {
                switch (code) {
                    case 1:
                        data.enforceInterface(DESCRIPTOR);
                        updateUserVibratorSceneIds(data.readHashMap(getClass().getClassLoader()), data.readInt());
                        reply.writeNoException();
                        return true;
                    case 2:
                        data.enforceInterface(DESCRIPTOR);
                        if (data.readInt() != 0) {
                            _arg0 = Uri.CREATOR.createFromParcel(data);
                        } else {
                            _arg0 = null;
                        }
                        int _result = getUserVibratorSceneId(_arg0, data.readInt());
                        reply.writeNoException();
                        reply.writeInt(_result);
                        return true;
                    case 3:
                        data.enforceInterface(DESCRIPTOR);
                        startApkInstall(data.readString());
                        reply.writeNoException();
                        return true;
                    case 4:
                        data.enforceInterface(DESCRIPTOR);
                        dumpLightBugreport(data.readString());
                        reply.writeNoException();
                        return true;
                    case 5:
                        data.enforceInterface(DESCRIPTOR);
                        monitorSceneChanging(data.readInt() != 0);
                        reply.writeNoException();
                        return true;
                    case 6:
                        data.enforceInterface(DESCRIPTOR);
                        shutdown();
                        reply.writeNoException();
                        return true;
                    default:
                        return super.onTransact(code, data, reply, flags);
                }
            } else {
                reply.writeString(DESCRIPTOR);
                return true;
            }
        }

        private static class Proxy implements IOnePlusExService {
            public static IOnePlusExService sDefaultImpl;
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
            public void updateUserVibratorSceneIds(Map scendIdMaps, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeMap(scendIdMaps);
                    _data.writeInt(userId);
                    if (this.mRemote.transact(1, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().updateUserVibratorSceneIds(scendIdMaps, userId);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public int getUserVibratorSceneId(Uri ringtoneUri, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (ringtoneUri != null) {
                        _data.writeInt(1);
                        ringtoneUri.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(userId);
                    if (!this.mRemote.transact(2, _data, _reply, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getUserVibratorSceneId(ringtoneUri, userId);
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
            public void startApkInstall(String apkPath) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(apkPath);
                    if (this.mRemote.transact(3, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().startApkInstall(apkPath);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void dumpLightBugreport(String tag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeString(tag);
                    if (this.mRemote.transact(4, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().dumpLightBugreport(tag);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void monitorSceneChanging(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enabled ? 1 : 0);
                    if (this.mRemote.transact(5, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().monitorSceneChanging(enabled);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void shutdown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, _data, _reply, 0) || Stub.getDefaultImpl() == null) {
                        _reply.readException();
                        _reply.recycle();
                        _data.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().shutdown();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IOnePlusExService impl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (impl == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = impl;
                return true;
            }
        }

        public static IOnePlusExService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
