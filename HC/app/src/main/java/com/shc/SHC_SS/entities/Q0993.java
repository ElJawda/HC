package com.shc.SHC_SS.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Hassan on 4/23/2017.
 */

public class Q0993 implements Parcelable {
    @SerializedName("id")
    @Expose
    public int no;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("status")
    @Expose
    public int state = 0;

    public Q0993() {
    }

    protected Q0993(Parcel in) {
        no = in.readInt();
        name = in.readString();
        state = in.readInt();
    }

    public static final Creator<Q0993> CREATOR = new Creator<Q0993>() {
        @Override
        public Q0993 createFromParcel(Parcel in) {
            return new Q0993(in);
        }

        @Override
        public Q0993[] newArray(int size) {
            return new Q0993[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(no);
        dest.writeString(name);
        dest.writeInt(state);
    }
}
