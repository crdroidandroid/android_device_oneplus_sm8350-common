package com.oneplus.inner.os;

import android.os.RemoteException;
import android.os.ServiceManager;
import com.oneplus.os.IParamService;

public class ParamServiceWrapper {
    private static IParamService getParamService() {
        return IParamService.Stub.asInterface(ServiceManager.getService("ParamService"));
    }

    public static int getParamIntSYNC(int id) throws RemoteException {
        return getParamService().getParamIntSYNC(id);
    }
}
