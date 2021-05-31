package com.oneplus.os;

import android.os.Build;
import android.util.Log;
import com.oneplus.android.context.IOneplusContext;
import com.oneplus.android.context.OneplusContext;

public class OpCompatibilityManagerInjector {
    private static final boolean DEBUG_ONEPLUS = false;
    private static final String TAG = "OpCompatibilityManagerInjector";
    private static IOnePlusServiceManager opServiceManager;

    public static boolean isInConfigList(int type, String verifyStr) {
        if (opServiceManager == null) {
            opServiceManager = (IOnePlusServiceManager) OneplusContext.queryInterface(IOneplusContext.EType.ONEPLUS_OPSERVICE);
        }
        IOnePlusServiceManager iOnePlusServiceManager = opServiceManager;
        if (iOnePlusServiceManager != null) {
            return iOnePlusServiceManager.isInConfigList(type, verifyStr);
        }
        Log.d(TAG, "opServiceManager is still null on isInConfigList");
        return false;
    }
}
