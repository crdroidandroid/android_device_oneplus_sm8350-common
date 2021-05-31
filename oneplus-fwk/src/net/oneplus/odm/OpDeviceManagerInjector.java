package net.oneplus.odm;

import android.annotation.SystemApi;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.oneplus.android.context.IOneplusContext;
import com.oneplus.android.context.OneplusContext;
import java.util.HashMap;
import java.util.Map;

public class OpDeviceManagerInjector {
    private static final String TAG = OpDeviceManagerInjector.class.getSimpleName();
    private static OpDeviceManagerInjector mOpDeviceManagerInjector;
    private IOpDeviceManager sOpDeviceManager;

    public void preserveAppData(Context context, String tag, Map<String, String> eventData, Map<String, String> extraData) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAppData(context, tag, eventData, extraData);
    }

    @SystemApi
    public void preserveUrgentAppData(Context context, String tag, Map<String, String> eventData, Map<String, String> extraData) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveUrgentAppData(context, tag, eventData, extraData);
    }

    public void preserveAppDataWithoutTimestamp(Context context, String tag, Map<String, String> eventData, Map<String, String> extraData) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAppDataWithoutTimestamp(context, tag, eventData, extraData);
    }

    @SystemApi
    public void preserveOsData(Context context, String tag, Map<String, String> eventData, Map<String, String> extraData) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveOsData(context, tag, eventData, extraData);
    }

    public void preserveUrgentOsData(Context context, String tag, Map<String, String> eventData, Map<String, String> extraData) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveUrgentOsData(context, tag, eventData, extraData);
    }

    public void preserveOsBatchData(Context context, String tag, HashMap<String, String> eventData, Map<String, String> extraData) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveOsBatchData(context, tag, eventData, extraData);
    }

    public void preserveAssistantData(Context context, int method) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAssistantData(context, method);
    }

    public void preserveHeadPhoneEvent(Context context, int type, String address, String deviceName) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveHeadPhoneEvent(context, type, address, deviceName);
    }

    public void preserveMusicData(Context context, String type, String packageName) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveMusicData(context, type, packageName);
    }

    public void preservePowerData(Context context, int chargedType, boolean isFastCharged) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preservePowerData(context, chargedType, isFastCharged);
    }

    public void preserveCopyData(Context context, ClipData clip) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveCopyData(context, clip);
    }

    public void preserveAppFocusData(Context context, String packageName, int userId, Intent intent, boolean firstLaunch) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAppFocusData(context, packageName, userId, intent, firstLaunch);
    }

    public void preserveNotificationData(Context context, String packageName) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveNotificationData(context, packageName);
    }

    public void preserveSensorData(Context context, int sensorId, int event) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveSensorData(context, sensorId, event);
    }

    public void preserveInstallInfoData(Context context, String ts, String pn, String pvc, boolean iug, String src) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveInstallInfoData(context, ts, pn, pvc, iug, src);
    }

    public void preserveUninstallInfoData(Context context, String ts, String pn, String pvc) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveUninstallInfoData(context, ts, pn, pvc);
    }

    public void preserveSystemErrorData(Context context, String tag) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveSystemErrorData(context, tag);
    }

    public void preserveRebootReason(Context context) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveRebootReason(context);
    }

    public String preserveAppIssueData(Context context, String tag, byte[] buffer) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.preserveAppIssueData(context, tag, buffer);
    }

    public void preserveAddApptoAutoGameModeList(Context context, String packageName, int mode) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAddApptoAutoGameModeList(context, packageName, mode);
    }

    public void initAppUsageCollector(Context context) {
        makeSureInstanceInitialized();
        sOpDeviceManager.initAppUsageCollector(context);
    }

    public void preserveStartForegroundService(Context context, String packageName, String className) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveStartForegroundService(context, packageName, className);
    }

    public void preserveStopForegroundService(Context context, String packageName, String className) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveStopForegroundService(context, packageName, className);
    }

    public void preserveStartActivity(Context context, String packageName) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveStartActivity(context, packageName);
    }

    public void preserveStopActivity(Context context, String packageName, long activityFinishTime) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveStopActivity(context, packageName, activityFinishTime);
    }

    public void preserveAppUsageAppDied(Context context, String packageName) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAppUsageAppDied(context, packageName);
    }

    public void preserveAppUsageShutDown(Context context) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveAppUsageShutDown(context);
    }

    public void preserveUsbContaminantData(Context context) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveUsbContaminantData(context);
    }

    public String encryptWithSHA256(String src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.encryptWithSHA256(src);
    }

    public String encryptWithSHA1(String src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.encryptWithSHA1(src);
    }

    public String encryptWithAES(Context context, String src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.encryptWithAES(context, src);
    }

    public String decryptWithAES(Context context, String src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.decryptWithAES(context, src);
    }

    public String encryptWithCRC32(byte[] src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.encryptWithCRC32(src);
    }

    public byte[] encryptWithCRC64(byte[] src, int textSize) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.encryptWithCRC64(src, textSize);
    }

    public String encryptWithBasha64(char[] src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.encryptWithBasha64(src);
    }

    public String decryptWithBasha64(char[] src) {
        makeSureInstanceInitialized();
        return sOpDeviceManager.decryptWithBasha64(src);
    }

    private void makeSureInstanceInitialized() {
        if (sOpDeviceManager == null) {
            sOpDeviceManager = (IOpDeviceManager) OneplusContext.queryInterface(IOneplusContext.EType.ONEPLUS_DEVICE_MANAGER);
        }
    }

    public static OpDeviceManagerInjector getInstance() {
        if (mOpDeviceManagerInjector == null) {
            mOpDeviceManagerInjector = new OpDeviceManagerInjector();
        }
        return mOpDeviceManagerInjector;
    }

    public void preserveData(Context context, String data, String appid, String eventName) {
        makeSureInstanceInitialized();
        sOpDeviceManager.preserveData(context, data, appid, eventName);
    }
}
