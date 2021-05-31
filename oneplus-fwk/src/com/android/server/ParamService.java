package com.android.server;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Slog;
import com.oneplus.os.IParamService;
import vendor.oneplus.hardware.param.V1_0.IOneplusParam;

public final class ParamService extends IParamService.Stub {
    public static final int CACHED_DEFAULT_VALUE = -1;
    private static final boolean DEBUG_ONEPLUS = false;
    public static final int PARAM_ABNORMAL_REBOOT_COUNT = 7;
    public static final int PARAM_BACKCOVER_COLOR = 2;
    public static final int PARAM_BOOT_TYPE = 16;
    public static final int PARAM_CAL_REBOOT_COUNT = 5;
    public static final int PARAM_CUST_FLAG = 4;
    public static final int PARAM_ENC_CARRIER_ID = 23;
    public static final int PARAM_ENC_IMEI_SET_FLAG = 18;
    public static final int PARAM_ENC_MEID_SET_FLAG = 22;
    public static final int PARAM_ENC_SALE_CHANNEL_ID = 25;
    public static final int PARAM_ENC_TARGET_SW_ID = 24;
    public static final int PARAM_FASTBOOT_COUNT = 9;
    public static final int PARAM_HDCP_STATUS = 15;
    public static final int PARAM_INDEX_TIME_CREATE_KEY = 12;
    public static final int PARAM_INDEX_TIME_FAIL_KEY = 14;
    public static final int PARAM_INDEX_TIME_PASS_KEY = 13;
    public static final int PARAM_INTRANET = 1;
    public static final int PARAM_NORMAL_REBOOT_COUNT = 6;
    public static final int PARAM_ONLINE_CFG_TEST_ENV = 17;
    public static final int PARAM_RECONDITION_FLAG = 21;
    public static final int PARAM_RESTART_08_COUNT = 10;
    public static final int PARAM_RESTART_OTHER_COUNT = 11;
    public static final String PARAM_SERVICE = "ParamService";
    public static final int PARAM_SMT_DOWNLOAD_STATE = 19;
    public static final int PARAM_UNLOCK_COUNT = 3;
    public static final int PARAM_UPDATE_COUNT = 8;
    public static final int PARAM_UPGRADE_DOWNLOAD_STATE = 20;
    public static final String TAG = "ParamService";
    private int mCachedBackCoverColor = -1;
    private int mCachedCustType = -1;
    private int mCachedTargetSwId = -1;
    private Context mContext;

    public IOneplusParam getOneplusParamService() {
        try {
            return IOneplusParam.getService();
        } catch (RemoteException e) {
            Slog.e("ParamService", "Exception getting OnePlus param service: " + e);
            return null;
        }
    }

    public int getParamIntSYNC(int i) {
        int i2;
        Exception e;
        if (i == 4 && mCachedCustType != -1) {
            if (DEBUG_ONEPLUS) {
                Slog.v("ParamService", "return cached cust type value = " + mCachedCustType);
            }
            return mCachedCustType;
        } else if (i == 2 && mCachedBackCoverColor != -1) {
            if (DEBUG_ONEPLUS) {
                Slog.v("ParamService", "return cached back cover color value = " + mCachedBackCoverColor);
            }
            return mCachedBackCoverColor;
        } else if (i != 24 || mCachedTargetSwId == -1) {
            IOneplusParam oneplusParamService = getOneplusParamService();
            if (oneplusParamService == null) {
                Slog.e("ParamService", "Can't get IOneplusParam");
                return -1;
            }
            try {
                i2 = oneplusParamService.getParamIntSYNC(i);
                try {
                    if (DEBUG_ONEPLUS) {
                        Slog.v("ParamService", "getParamIntSYNC = " + i2);
                    }
                } catch (Exception e2) {
                    e = e2;
                    Slog.e("ParamService", "getParamIntSYNC throws exception: " + e);
                    mCachedCustType = i2;
                    mCachedBackCoverColor = i2;
                    mCachedTargetSwId = i2;
                    return i2;
                }
            } catch (Exception e3) {
                e = e3;
                i2 = -1;
                Slog.e("ParamService", "getParamIntSYNC throws exception: " + e);
                mCachedCustType = i2;
                mCachedBackCoverColor = i2;
                mCachedTargetSwId = i2;
                return i2;
            }
            if (i == 4 && mCachedCustType == -1) {
                mCachedCustType = i2;
            }
            if (i == 2 && mCachedBackCoverColor == -1) {
                mCachedBackCoverColor = i2;
            }
            if (i == 24 && mCachedTargetSwId == -1) {
                mCachedTargetSwId = i2;
            }
            return i2;
        } else {
            if (DEBUG_ONEPLUS) {
                Slog.v("ParamService", "return cached sw id value = " + mCachedTargetSwId);
            }
            return mCachedTargetSwId;
        }
    }

    public void publish(Context context) {
        if (DEBUG_ONEPLUS) {
            Slog.d("ParamService", "publish context=" + context);
        }
        mContext = context;
        ServiceManager.addService("ParamService", asBinder());
    }
}
