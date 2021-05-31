package com.oneplus.config;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import org.json.JSONArray;

public class ConfigObserver extends ContentObserver {
    private static String TAG = "Config:Observer:";
    private String CONFIG_URI;
    private final String OPCONFIG_URI = "content://com.oneplus.config.ConfigProvider/";
    private String mConfigName;
    private ConfigUpdater mConfigUpdater;
    private Context mContext;

    public interface ConfigUpdater {
        void updateConfig(JSONArray jSONArray);
    }

    public ConfigObserver(Context context, Handler handler, ConfigUpdater configUpdater, String configName) {
        super(handler);
        mContext = context;
        mConfigUpdater = configUpdater;
        TAG += configName;
        CONFIG_URI = "content://com.oneplus.config.ConfigProvider/" + configName;
        mConfigName = configName;
    }

    public void register() {
        try {
            mContext.getContentResolver().registerContentObserver(Uri.parse(CONFIG_URI), true, this);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void unregister() {
        mContext.getContentResolver().unregisterContentObserver(this);
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        JSONArray json = new ConfigGrabber(mContext, mConfigName).grabConfig();
        if (json == null) {
            Log.e(TAG, "Get null json from db.");
        } else {
            mConfigUpdater.updateConfig(json);
        }
    }
}
