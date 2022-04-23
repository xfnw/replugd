package com.ecloud.eshare.bean;

/* loaded from: classes.dex */
public class AppItem {
    private byte[] appIcon;
    private String appName;
    private String packageName;
    private int versionCode;
    private String versionName;

    public byte[] getAppIcon() {
        return this.appIcon;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppIcon(byte[] bArr) {
        this.appIcon = bArr;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setVersionCode(int i) {
        this.versionCode = i;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        return "AppItem{appName='" + this.appName + "', packageName='" + this.packageName + "', versionName='" + this.versionName + "', versionCode=" + this.versionCode + '}';
    }
}
