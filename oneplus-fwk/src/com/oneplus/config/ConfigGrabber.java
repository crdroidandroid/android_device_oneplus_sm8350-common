package com.oneplus.config;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.util.Log;
import net.oneplus.odm.OpDeviceManagerInjector;
import org.json.JSONArray;

public class ConfigGrabber {
    private final String OPCONFIG_URI = "content://com.oneplus.config.ConfigProvider/";
    private String TAG = "Config:Grabber:";
    private String mConfigName;
    private Context mContext;
    private OpDeviceManagerInjector mOpDeviceManagerInjector;

    public ConfigGrabber(Context context, String configName) {
        mContext = context;
        mConfigName = configName;
        TAG += configName;
        mOpDeviceManagerInjector = OpDeviceManagerInjector.getInstance();
    }

    public JSONArray grabConfig() {
        ContentResolver resolver = mContext.getContentResolver();
        Cursor cursor = null;
        JSONArray json = null;
        try {
            cursor = resolver.query(Uri.parse("content://com.oneplus.config.ConfigProvider/" + mConfigName), new String[]{"config_content"}, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                json = new JSONArray(mOpDeviceManagerInjector.decryptWithAES(mContext, cursor.getString(0)));
            }
        } catch (IllegalArgumentException e) {
            Log.e(TAG, e.getMessage());
        } catch (CursorIndexOutOfBoundsException e2) {
            Log.e(TAG, e2.getMessage());
        } catch (NullPointerException e3) {
            if (cursor != null) {
                try {
                    json = new JSONArray(cursor.getString(0));
                } catch (Exception exception) {
                    Log.e(TAG, "Exception:" + exception.getMessage());
                }
            }
        } catch (Exception e4) {
            Log.e(TAG, "Exception:" + e4.getMessage());
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }

        return json;
    }
}
