package com.oneplus.os;

import com.oneplus.appboot.AppControlMode;
import com.oneplus.frontmonitor.IFrontListener;
import com.oneplus.highpower.HighPowerApp;
import java.util.List;

public interface IOnePlusServiceManager {
    boolean checkPreLoadCacheEnable(String str);

    void flingEvent(String str, int i);

    List<AppControlMode> getAllAppControlModes(int i);

    int getAppControlMode(String str, int i);

    int getAppControlState(int i);

    List<HighPowerApp> getBgPowerHungryList();

    int getDynamicVsyncConfig(String str);

    boolean isInConfigList(int i, String str);

    boolean isInSpecialTesting();

    void noteBluetoothConnectedChanged(String str, boolean z);

    void noteRfcommSocketToServiceRecord(int i, int i2);

    void noteStartAudio(int i, int i2);

    void noteStartVideo(int i, int i2);

    void noteStopAudio(int i, int i2);

    void noteStopVideo(int i, int i2);

    void registerFrontActivityListener(IFrontListener iFrontListener);

    void resume(String str);

    int setAppControlMode(String str, int i, int i2);

    int setAppControlState(int i, int i2);

    void stopBgPowerHungryApp(String str, int i);

    void unregisterFrontActivityListener(IFrontListener iFrontListener);

    void updateVelocity(String str, float f, double d);
}
