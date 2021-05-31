package com.oneplus.android.context;

import com.oneplus.android.context.IOneplusContext;

public final class OneplusContext {
    private static IOneplusContext mContext = null;

    public static final IOneplusContext getInstance() {
        return mContext;
    }

    public static final void attach(IOneplusContext context) {
        mContext = context;
    }

    public static final Object queryInterface(IOneplusContext.EType type) {
        IOneplusContext iOneplusContext = mContext;
        if (iOneplusContext == null) {
            return null;
        }
        return iOneplusContext.queryInterface(type);
    }
}
