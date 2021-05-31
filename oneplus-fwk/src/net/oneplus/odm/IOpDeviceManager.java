package net.oneplus.odm;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;

public interface IOpDeviceManager {
    String decryptWithAES(Context context, String str);

    String decryptWithBasha64(char[] cArr);

    String encryptWithAES(Context context, String str);

    String encryptWithBasha64(char[] cArr);

    String encryptWithCRC32(byte[] bArr);

    byte[] encryptWithCRC64(byte[] bArr, int i);

    String encryptWithSHA1(String str);

    String encryptWithSHA256(String str);

    void initAppUsageCollector(Context context);

    void preserveAddApptoAutoGameModeList(Context context, String str, int i);

    void preserveAppData(Context context, String str, Map<String, String> map, Map<String, String> map2);

    void preserveAppDataWithoutTimestamp(Context context, String str, Map<String, String> map, Map<String, String> map2);

    void preserveAppFocusData(Context context, String str, int i, Intent intent, boolean z);

    String preserveAppIssueData(Context context, String str, byte[] bArr);

    void preserveAppUsageAppDied(Context context, String str);

    void preserveAppUsageShutDown(Context context);

    void preserveAssistantData(Context context, int i);

    void preserveCopyData(Context context, ClipData clipData);

    void preserveData(Context context, String str, String str2, String str3);

    void preserveHeadPhoneEvent(Context context, int i, String str, String str2);

    void preserveInstallInfoData(Context context, String str, String str2, String str3, boolean z, String str4);

    void preserveMusicData(Context context, String str, String str2);

    void preserveNotificationData(Context context, String str);

    void preserveOsBatchData(Context context, String str, HashMap<String, String> hashMap, Map<String, String> map);

    void preserveOsData(Context context, String str, Map<String, String> map, Map<String, String> map2);

    void preservePowerData(Context context, int i, boolean z);

    void preserveRebootReason(Context context);

    void preserveSensorData(Context context, int i, int i2);

    void preserveStartActivity(Context context, String str);

    void preserveStartForegroundService(Context context, String str, String str2);

    void preserveStopActivity(Context context, String str, long j);

    void preserveStopForegroundService(Context context, String str, String str2);

    void preserveSystemErrorData(Context context, String str);

    void preserveUninstallInfoData(Context context, String str, String str2, String str3);

    void preserveUrgentAppData(Context context, String str, Map<String, String> map, Map<String, String> map2);

    void preserveUrgentOsData(Context context, String str, Map<String, String> map, Map<String, String> map2);

    void preserveUsbContaminantData(Context context);
}
