package com.oneplus.inner.os;

import android.os.SystemProperties;

public class SystemPropertiesWrapper {
    public static String get(String key) {
        return SystemProperties.get(key);
    }

    public static String get(String key, String def) {
        return SystemProperties.get(key, def);
    }

    public static void set(String key, String val) {
        SystemProperties.set(key, val);
    }

    public static int getInt(String key, int def) {
        return SystemProperties.getInt(key, def);
    }

    public static boolean getBoolean(String key, boolean def) {
        return SystemProperties.getBoolean(key, def);
    }

    public static long getLong(String key, long def) {
        return SystemProperties.getLong(key, def);
    }
}
