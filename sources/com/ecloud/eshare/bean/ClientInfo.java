package com.ecloud.eshare.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class ClientInfo implements Parcelable {
    public static final Parcelable.Creator<ClientInfo> CREATOR = new Parcelable.Creator<ClientInfo>() { // from class: com.ecloud.eshare.bean.ClientInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClientInfo createFromParcel(Parcel parcel) {
            return new ClientInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ClientInfo[] newArray(int i) {
            return new ClientInfo[i];
        }
    };
    public static final int NEGATIVE_VALUE = -1;
    public static final int NETURAL_VALUE = 0;
    public static final int OS_ANDROID = 1;
    public static final int OS_CHROME = 4;
    public static final int OS_DONGLE = 3;
    public static final int OS_IOS = 2;
    public static final int OS_MACOSX = 5;
    public static final int OS_WINDOW = 0;
    public static final int POSITIVE_VALUE = 1;
    @SerializedName("ClientIp")
    public String ClientIp;
    @SerializedName("ClientModel")
    public String ClientModel;
    @SerializedName("device_os")
    public int device_os;
    @SerializedName("fullScreen")
    public int fullScreen;
    @SerializedName("mastercontrol")
    public int mastercontrol;
    @SerializedName("requestCasting")
    public int requestCasting;
    @SerializedName("screening")
    public int screening;

    public ClientInfo() {
    }

    protected ClientInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public ClientInfo(ClientInfo clientInfo) {
        this.device_os = clientInfo.device_os;
        this.ClientModel = clientInfo.ClientModel;
        this.ClientIp = clientInfo.ClientIp;
        this.mastercontrol = clientInfo.mastercontrol;
        this.fullScreen = clientInfo.fullScreen;
        this.screening = clientInfo.screening;
        this.requestCasting = clientInfo.requestCasting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(ClientInfo clientInfo) {
        return this.ClientIp.equals(clientInfo.ClientIp);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ClientInfo.class != obj.getClass()) {
            return false;
        }
        String str = this.ClientIp;
        String str2 = ((ClientInfo) obj).ClientIp;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public String getClientIp() {
        return this.ClientIp;
    }

    public String getClientModel() {
        return this.ClientModel;
    }

    public int getDevice_os() {
        return this.device_os;
    }

    public int getFullScreen() {
        return this.fullScreen;
    }

    public int getMastercontrol() {
        return this.mastercontrol;
    }

    public int getRequestCasting() {
        return this.requestCasting;
    }

    public int getScreening() {
        return this.screening;
    }

    public int hashCode() {
        String str = this.ClientIp;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.device_os = parcel.readInt();
            this.ClientModel = parcel.readString();
            this.ClientIp = parcel.readString();
            this.mastercontrol = parcel.readInt();
            this.fullScreen = parcel.readInt();
            this.screening = parcel.readInt();
            this.requestCasting = parcel.readInt();
        } catch (Throwable th) {
            Log.e("Lee", "readFromParcel Crash----" + Log.getStackTraceString(th));
        }
    }

    public void setClientIp(String str) {
        this.ClientIp = str;
    }

    public void setClientModel(String str) {
        this.ClientModel = str;
    }

    public void setDevice_os(int i) {
        this.device_os = i;
    }

    public void setFullScreen(int i) {
        this.fullScreen = i;
    }

    public void setMastercontrol(int i) {
        this.mastercontrol = i;
    }

    public void setRequestCasting(int i) {
        this.requestCasting = i;
    }

    public void setScreening(int i) {
        this.screening = i;
    }

    public String toString() {
        return "ClientInfo [device_os=" + this.device_os + ", ClientModel=" + this.ClientModel + ", ClientIp=" + this.ClientIp + ", mastercontrol=" + this.mastercontrol + ", fullScreen=" + this.fullScreen + ", screening=" + this.screening + ", requestCasting=" + this.requestCasting + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.device_os);
        parcel.writeString(this.ClientModel);
        parcel.writeString(this.ClientIp);
        parcel.writeInt(this.mastercontrol);
        parcel.writeInt(this.fullScreen);
        parcel.writeInt(this.screening);
        parcel.writeInt(this.requestCasting);
    }
}
