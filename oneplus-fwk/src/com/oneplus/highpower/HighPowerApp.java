package com.oneplus.highpower;

import android.os.Parcel;
import android.os.Parcelable;

public class HighPowerApp implements Parcelable {
    public static final Parcelable.Creator<HighPowerApp> CREATOR = new Parcelable.Creator<HighPowerApp>() {
        @Override
        public HighPowerApp createFromParcel(Parcel in) {
            return new HighPowerApp(in);
        }

        @Override
        public HighPowerApp[] newArray(int size) {
            return new HighPowerApp[size];
        }
    };
    public boolean isLocked;
    public boolean isStopped;
    public String pkgName;
    public int powerLevel;
    public long timeStamp;
    public int uid;

    public HighPowerApp(String pkg, int level, boolean locked, boolean stopped, long time, int _uid) {
        this.pkgName = pkg;
        this.powerLevel = level;
        this.isLocked = locked;
        this.isStopped = stopped;
        this.timeStamp = time;
        this.uid = _uid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public HighPowerApp(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.pkgName);
        out.writeInt(this.powerLevel);
        out.writeInt(this.isLocked ? 1 : 0);
        out.writeInt(this.isStopped ? 1 : 0);
        out.writeLong(this.timeStamp);
        out.writeInt(this.uid);
    }

    public void readFromParcel(Parcel in) {
        this.pkgName = in.readString();
        this.powerLevel = in.readInt();
        boolean z = false;
        this.isLocked = in.readInt() == 1;
        if (in.readInt() == 1) {
            z = true;
        }
        this.isStopped = z;
        this.timeStamp = in.readLong();
        this.uid = in.readInt();
    }
}
