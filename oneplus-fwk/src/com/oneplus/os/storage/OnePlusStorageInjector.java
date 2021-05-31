package com.oneplus.os.storage;

import android.app.AppGlobals;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.os.storage.VolumeInfo;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;

public class OnePlusStorageInjector {
    private static final boolean DEBUG_ONEPLUS = false;
    private static final String TAG = "OnePlusStorageInjector";

    public static boolean isUsbStorage(VolumeInfo vol) {
        if (vol.getDisk() == null || !vol.getDisk().isUsb()) {
            return false;
        }
        if (!DEBUG_ONEPLUS) {
            return true;
        }
        Log.d(TAG, "Vol is usb: " + vol.toString());
        return true;
    }

    public static ArrayList<File> getAttachedUsbStorageDisks() {
        File path;
        ArrayList<File> list = new ArrayList<>();
        for (VolumeInfo vi : ((StorageManager) AppGlobals.getInitialApplication().getSystemService(StorageManager.class)).getVolumes()) {
            if (isUsbStorage(vi) && vi.isVisible() && (path = vi.getPathForUser(UserHandle.myUserId())) != null) {
                try {
                    list.add(path.getCanonicalFile());
                } catch (Exception ex) {
                    if (DEBUG_ONEPLUS) {
                        Log.w(TAG, "Failed to resolve " + path + ": " + ex);
                    }
                    list.add(path);
                }
            }
        }
        return list;
    }

    public static void broadcastForUnmountedMediaStorage(Context context, VolumeInfo vol, int userId) {
        if (vol != null && vol.getState() == 0) {
            StorageVolume userVol = vol.buildStorageVolume(context, userId, false);
            if (vol.getPath() != null && userVol != null) {
                String strPath = vol.getPath().getPath();
                Intent mediaIntent = new Intent(Intent.ACTION_MEDIA_EJECT, Uri.parse("file://" + strPath));
                mediaIntent.putExtra(StorageVolume.EXTRA_STORAGE_VOLUME, userVol);
                if (DEBUG_ONEPLUS) {
                    Log.d(TAG, "broadcastForUnmountedMediaStorage: [" + mediaIntent + "] to " + userId);
                }
                context.sendBroadcastAsUser(mediaIntent, userVol.getOwner());
            }
        }
    }
}
