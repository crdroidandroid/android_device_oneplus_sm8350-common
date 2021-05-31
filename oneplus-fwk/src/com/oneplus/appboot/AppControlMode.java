package com.oneplus.appboot;

import android.os.Parcel;
import android.os.Parcelable;

public class AppControlMode implements Parcelable {
    public static final int APP_CONTROL_MODE_APPBOOT = 1;
    public static final int APP_CONTROL_MODE_CGROUP = 2;
    public static final int APP_CONTROL_MODE_DEFAULT = 0;
    public static final int APP_CONTROL_MODE_DOZE = 3;
    public static final Parcelable.Creator<AppControlMode> CREATOR = new Parcelable.Creator<AppControlMode>() {
        @Override
        public AppControlMode createFromParcel(Parcel source) {
            return new AppControlMode(source);
        }

        @Override
        public AppControlMode[] newArray(int size) {
            return new AppControlMode[size];
        }
    };
    public int mode;
    public String packageName;
    public int value;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.packageName);
        dest.writeInt(this.mode);
        dest.writeInt(this.value);
    }

    public void readFromParcel(Parcel source) {
        this.packageName = source.readString();
        this.mode = source.readInt();
        this.value = source.readInt();
    }

    public AppControlMode(String packageName2, int mode2, int value2) {
        this.packageName = packageName2;
        this.mode = mode2;
        this.value = value2;
    }

    private AppControlMode(Parcel source) {
        readFromParcel(source);
    }

    public String toString(String prefix) {
        return prefix + " packageName=" + this.packageName + " mode=" + this.mode + " value=" + this.value;
    }

    public String toString() {
        return toString("");
    }
}
