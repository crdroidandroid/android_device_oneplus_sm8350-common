/*
 * Copyright (C) 2018-2021 crDroid Android Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.device.DeviceSettings;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.FileObserver;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.KeyEvent;

import com.android.internal.os.DeviceKeyHandler;

import java.util.Arrays;

import org.lineageos.device.DeviceSettings.Constants;
import org.lineageos.device.DeviceSettings.SliderControllerBase;
import org.lineageos.device.DeviceSettings.slider.NotificationController;
import org.lineageos.device.DeviceSettings.slider.FlashlightController;
import org.lineageos.device.DeviceSettings.slider.BrightnessController;
import org.lineageos.device.DeviceSettings.slider.RotationController;
import org.lineageos.device.DeviceSettings.slider.RingerController;
import org.lineageos.device.DeviceSettings.slider.NotificationRingerController;

public class KeyHandler implements DeviceKeyHandler {
    private static final String TAG = KeyHandler.class.getSimpleName();
    private static final boolean DEBUG = false;

    private final Context mContext;
    private final NotificationController mNotificationController;
    private final FlashlightController mFlashlightController;
    private final BrightnessController mBrightnessController;
    private final RotationController mRotationController;
    private final RingerController mRingerController;
    private final NotificationRingerController mNotificationRingerController;

    private SliderControllerBase mSliderController;

    private final BroadcastReceiver mSliderUpdateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int usage = intent.getIntExtra(Constants.EXTRA_SLIDER_USAGE, 0);
            int[] actions = intent.getIntArrayExtra(Constants.EXTRA_SLIDER_ACTIONS);

            Log.d(TAG, "update usage " + usage + " with actions " +
                    Arrays.toString(actions));

            if (mSliderController != null) {
                mSliderController.reset();
            }

            switch (usage) {
                case NotificationController.ID:
                    mSliderController = mNotificationController;
                    mSliderController.update(actions);
                    break;
                case FlashlightController.ID:
                    mSliderController = mFlashlightController;
                    mSliderController.update(actions);
                    break;
                case BrightnessController.ID:
                    mSliderController = mBrightnessController;
                    mSliderController.update(actions);
                    break;
                case RotationController.ID:
                    mSliderController = mRotationController;
                    mSliderController.update(actions);
                    break;
                case RingerController.ID:
                    mSliderController = mRingerController;
                    mSliderController.update(actions);
                    break;
                case NotificationRingerController.ID:
                    mSliderController = mNotificationRingerController;
                    mSliderController.update(actions);
                    break;
            }

            mSliderController.restoreState();
        }
    };

    public KeyHandler(Context context) {
        mContext = context;

        mNotificationController = new NotificationController(mContext);
        mFlashlightController = new FlashlightController(mContext);
        mBrightnessController = new BrightnessController(mContext);
        mRotationController = new RotationController(mContext);
        mRingerController = new RingerController(mContext);
        mNotificationRingerController = new NotificationRingerController(mContext);

        mContext.registerReceiver(mSliderUpdateReceiver,
                new IntentFilter(Constants.ACTION_UPDATE_SLIDER_SETTINGS));
    }

    private boolean hasSetupCompleted() {
        return Settings.Secure.getInt(mContext.getContentResolver(),
                Settings.Secure.USER_SETUP_COMPLETE, 0) != 0;
    }

    public KeyEvent handleKeyEvent(KeyEvent event) {
        int scanCode = event.getScanCode();
        boolean isSliderControllerSupported = mSliderController != null &&
                mSliderController.isSupported(scanCode);
        if (!isSliderControllerSupported) {
            return event;
        }

        if (!hasSetupCompleted()) {
            return event;
        }

        // We only want ACTION_UP event
        if (event.getAction() != KeyEvent.ACTION_UP) {
            return null;
        }

        mSliderController.processEvent(mContext, scanCode);

        return null;
    }
}
