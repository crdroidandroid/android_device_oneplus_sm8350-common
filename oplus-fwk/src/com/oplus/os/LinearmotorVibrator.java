package com.oplus.os;

import android.content.Context;
import android.os.RemoteException;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Slog;

/**
 * @hide
 */
public class LinearmotorVibrator {

    private static final String TAG = "LinearmotorVibrator";

    private static final VibrationEffect EFFECT_CLICK =
            VibrationEffect.createPredefined(VibrationEffect.EFFECT_CLICK);

    private final Vibrator mVibrator;

    public LinearmotorVibrator(Context context, ILinearmotorVibratorService service) {
        mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    /**
     * @hide
     */
    public void vibrate(WaveformEffect effect) {
        if (mVibrator == null || effect == null) {
            Slog.d(TAG, "ignore vibrate in favor of invalid params.");
            return;
        }
        mVibrator.vibrate(EFFECT_CLICK);
    }
}
