package android.hardware.camera2;

import android.content.Context;
import android.os.IBinder;

public interface IOplusCameraManager {
    default void addAuthResultInfo(Context context, int uid, int pid, int permBits, String packageName) {
    }

    default void setDeathRecipient(IBinder client) {
    }

    default void setCallInfo() {
    }
}
