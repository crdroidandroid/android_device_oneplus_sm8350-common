package com.oneplus.inner.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;

public class ContextWrapper {
    public static final String COUNTRY_DETECTOR = "country_detector";
    public static final String OVERLAY_SERVICE = "overlay";
    public static final String STATUS_BAR_SERVICE = "statusbar";

    public static ComponentName startServiceAsUser(Context context, Intent service, UserHandle user) {
        return context.startServiceAsUser(service, user);
    }

    public static boolean stopServiceAsUser(Context context, Intent service, UserHandle user) {
        return context.stopServiceAsUser(service, user);
    }
}
