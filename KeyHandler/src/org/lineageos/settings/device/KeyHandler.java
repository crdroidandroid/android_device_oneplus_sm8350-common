/*
 * Copyright (C) 2018 The LineageOS Project
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

package org.lineageos.settings.device;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.UserHandle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.KeyEvent;

import com.android.internal.os.DeviceKeyHandler;

public class KeyHandler implements DeviceKeyHandler {
    private static final String TAG = KeyHandler.class.getSimpleName();

    // Slider key codes
    private static final int POSITION_BOTTOM = 601;
    private static final int POSITION_MIDDLE = 602;
    private static final int POSITION_TOP = 603;

    // TriStateUI Modes
    public static final int MODE_VIBRATE = 604;
    public static final int MODE_RING = 605;
    public static final int MODE_SILENT = 620;

    // Vibration effects
    private static final VibrationEffect MODE_NORMAL_EFFECT =
            VibrationEffect.get(VibrationEffect.EFFECT_HEAVY_CLICK);
    private static final VibrationEffect MODE_VIBRATION_EFFECT =
            VibrationEffect.get(VibrationEffect.EFFECT_DOUBLE_CLICK);

    public static final String ACTION_UPDATE_SLIDER_POSITION
            = "org.lineageos.device.UPDATE_SLIDER_POSITION";
    public static final String EXTRA_SLIDER_POSITION = "position";
    public static final String EXTRA_SLIDER_POSITION_VALUE = "position_value";

    private final Context mContext;
    private final AudioManager mAudioManager;
    private final Vibrator mVibrator;

    public KeyHandler(Context context) {
        mContext = context;

        mAudioManager = mContext.getSystemService(AudioManager.class);
        mVibrator = mContext.getSystemService(Vibrator.class);
    }

    public KeyEvent handleKeyEvent(KeyEvent event) {
        if (event.getAction() != KeyEvent.ACTION_DOWN) {
            return event;
        }

        int scanCode = event.getScanCode();

        int position = 0;
        int positionValue = 0;

        switch (scanCode) {
            case POSITION_BOTTOM:
                mAudioManager.setRingerModeInternal(AudioManager.RINGER_MODE_NORMAL);
                position = 2;
                positionValue = MODE_RING;
                doHapticFeedback(MODE_NORMAL_EFFECT);
                break;
            case POSITION_MIDDLE:
                mAudioManager.setRingerModeInternal(AudioManager.RINGER_MODE_VIBRATE);
                position = 1;
                positionValue = MODE_VIBRATE;
                doHapticFeedback(MODE_VIBRATION_EFFECT);
                break;
            case POSITION_TOP:
                mAudioManager.setRingerModeInternal(AudioManager.RINGER_MODE_SILENT);
                position = 0;
                positionValue = MODE_SILENT;
                break;
            default:
                return event;
        }

        sendUpdateBroadcast(position, positionValue);

        return null;
    }

    private void doHapticFeedback(VibrationEffect effect) {
        if (mVibrator != null && mVibrator.hasVibrator()) {
            mVibrator.vibrate(effect);
        }
    }

    private void sendUpdateBroadcast(int position, int position_value) {
        Intent intent = new Intent(ACTION_UPDATE_SLIDER_POSITION);
        intent.putExtra(EXTRA_SLIDER_POSITION, position);
        intent.putExtra(EXTRA_SLIDER_POSITION_VALUE, position_value);
        mContext.sendBroadcastAsUser(intent, UserHandle.CURRENT);
        intent.setFlags(Intent.FLAG_RECEIVER_REGISTERED_ONLY);
    }
}
