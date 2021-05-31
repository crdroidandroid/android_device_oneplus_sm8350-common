package com.oneplus.inner.os;

import android.os.UserHandle;

public class UserHandleWrapper {
    public static final UserHandle ALL = UserHandle.ALL;
    public static final UserHandle CURRENT = UserHandle.CURRENT;
    public static final boolean MU_ENABLED = true;
    public static final UserHandle SYSTEM = UserHandle.SYSTEM;
    public static final int USER_ALL = -1;
    public static final int USER_CURRENT = -2;
    public static final int USER_OWNER = 0;
    public static final int USER_SYSTEM = 0;

    public static int myUserId() {
        return UserHandle.myUserId();
    }

    public static int getUserId(int uid) {
        return UserHandle.getUserId(uid);
    }

    public static int getIdentifier(UserHandle userhandle) {
        return userhandle.getIdentifier();
    }

    public static UserHandle of(int userId) {
        return UserHandle.of(userId);
    }

    public static boolean isSystem(UserHandle userhandle) {
        return userhandle.isSystem();
    }
}
