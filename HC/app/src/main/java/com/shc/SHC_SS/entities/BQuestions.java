package com.shc.SHC_SS.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Hassan on 4/23/2017.
 */

public class BQuestions implements Parcelable {

    @SerializedName("Q0991")
    @Expose
    public int q0991 ;
    @SerializedName("Q0992")
    @Expose
    public int q0992 ;

    @SerializedName("Q0993")
    @Expose
    public List<Q0993> q0993List = new ArrayList<>();
    @SerializedName("Q0994")
    @Expose
    public int q0994 ;
    @Expose
    @SerializedName("Q0995")
    public int q0995 ;

    @Expose
    @SerializedName("Q0995a")
    public String q0995a;
    @Expose
    @SerializedName("Q0995b")
    public String q0995b;
    @Expose
    @SerializedName("Q0996")
    public String q0996;
    @Expose
    @SerializedName("Q0997")
    public String q0997;

    public BQuestions() {
    }

    protected BQuestions(Parcel in) {
        q0991 = in.readInt();
        q0992 = in.readInt();
        q0993List = in.createTypedArrayList(Q0993.CREATOR);
        q0994 = in.readInt();
        q0995 = in.readInt();
        q0995a = in.readString();
        q0995b = in.readString();
        q0996 = in.readString();
        q0997 = in.readString();
    }

    public static final Creator<BQuestions> CREATOR = new Creator<BQuestions>() {
        @Override
        public BQuestions createFromParcel(Parcel in) {
            return new BQuestions(in);
        }

        @Override
        public BQuestions[] newArray(int size) {
            return new BQuestions[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(q0991);
        dest.writeInt(q0992);
        dest.writeTypedList(q0993List);
        dest.writeInt(q0994);
        dest.writeInt(q0995);
        dest.writeString(q0995a);
        dest.writeString(q0995b);
        dest.writeString(q0996);
        dest.writeString(q0997);
    }
}
