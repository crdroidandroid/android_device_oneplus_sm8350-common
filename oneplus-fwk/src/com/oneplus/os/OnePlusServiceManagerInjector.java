package com.oneplus.os;

import android.os.Build;
import android.util.Log;
import com.oneplus.android.context.IOneplusContext;
import com.oneplus.android.context.OneplusContext;
import com.oneplus.highpower.HighPowerApp;
import java.util.ArrayList;
import java.util.List;

public class OnePlusServiceManagerInjector {
    private static final boolean DEBUG_ONEPLUS = false;
    private static final String TAG = "OnePlusServiceManagerInjector";
    private static IOnePlusServiceManager opServiceManager;

    public static List<HighPowerApp> getBgPowerHungryList() {
        if (opServiceManager == null) {
            opServiceManager = (IOnePlusServiceManager) OneplusContext.queryInterface(IOneplusContext.EType.ONEPLUS_OPSERVICE);
        }
        IOnePlusServiceManager iOnePlusServiceManager = opServiceManager;
        if (iOnePlusServiceManager != null) {
            return iOnePlusServiceManager.getBgPowerHungryList();
        }
        Log.d(TAG, "opServiceManager is still null, just return new ArrayList");
        return new ArrayList();
    }

    public static void stopBgPowerHungryApp(String pkg, int powerLevel) {
        if (opServiceManager == null) {
            opServiceManager = (IOnePlusServiceManager) OneplusContext.queryInterface(IOneplusContext.EType.ONEPLUS_OPSERVICE);
        }
        IOnePlusServiceManager iOnePlusServiceManager = opServiceManager;
        if (iOnePlusServiceManager != null) {
            iOnePlusServiceManager.stopBgPowerHungryApp(pkg, powerLevel);
        } else {
            Log.d(TAG, "opServiceManager is still null on stopBgPowerHungryApp");
        }
    }

    public static boolean checkPreLoadCacheEnable(String packageName) {
        if (opServiceManager == null) {
            opServiceManager = (IOnePlusServiceManager) OneplusContext.queryInterface(IOneplusContext.EType.ONEPLUS_OPSERVICE);
        }
        IOnePlusServiceManager iOnePlusServiceManager = opServiceManager;
        if (iOnePlusServiceManager != null) {
            return iOnePlusServiceManager.checkPreLoadCacheEnable(packageName);
        }
        Log.d(TAG, "opServiceManager is still null, checkPreLoadCacheEnable return null");
        return false;
    }
}
