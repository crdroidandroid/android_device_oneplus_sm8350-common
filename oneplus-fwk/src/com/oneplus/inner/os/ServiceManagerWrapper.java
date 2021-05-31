package com.oneplus.inner.os;

import android.os.IBinder;
import android.os.ServiceManager;

public class ServiceManagerWrapper {
    public static IBinder getService(String name) {
        return ServiceManager.getService(name);
    }
}
