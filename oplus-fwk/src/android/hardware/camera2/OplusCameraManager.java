package android.hardware.camera2;

import android.content.Context;
import android.os.IBinder;

public class OplusCameraManager implements IOplusCameraManager {
    private static OplusCameraManager mInstance = new OplusCameraManager();
    private OplusCameraManager() {
    }

    public static synchronized OplusCameraManager getInstance() {
        OplusCameraManager oplusCameraManager;
        synchronized (OplusCameraManager.class) {
            oplusCameraManager = mInstance;
        }
        return oplusCameraManager;
    }

    @Override
    public void addAuthResultInfo(Context context, int uid, int pid, int permBits, String packageName) {
    }

    @Override
    public void setDeathRecipient(IBinder client) {
    }

    @Override
    public void setCallInfo() {
    }
}
