package com.ecloud.eshare.bean;

/* loaded from: classes.dex */
public class EventCollections {

    /* loaded from: classes.dex */
    public static class CastRequestEvent {
        int ret;

        public CastRequestEvent(int i) {
            this.ret = i;
        }

        public int getRet() {
            return this.ret;
        }

        public void setRet(int i) {
            this.ret = i;
        }
    }

    /* loaded from: classes.dex */
    public static class FinishActivityEvent {
        public static int FINISH_CAST = 1;
        public static int FINISH_DEFAULT = 0;
        public static int FINISH_MIRROR = 2;
        int type;

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes.dex */
    public static class HeartbeatInfo {
        int castMode;
        int castState;
        int mirrorMode;
        int multiScreen;
        int rotation;

        public int getCastMode() {
            return this.castMode;
        }

        public int getCastState() {
            return this.castState;
        }

        public int getMirrorMode() {
            return this.mirrorMode;
        }

        public int getMultiScreen() {
            return this.multiScreen;
        }

        public int getRotation() {
            return this.rotation;
        }

        public void setCastMode(int i) {
            this.castMode = i;
        }

        public void setCastState(int i) {
            this.castState = i;
        }

        public void setMirrorMode(int i) {
            this.mirrorMode = i;
        }

        public void setMultiScreen(int i) {
            this.multiScreen = i;
        }

        public void setRotation(int i) {
            this.rotation = i;
        }
    }

    /* loaded from: classes.dex */
    public static class PeerCastRequestEvent {
        public int castType;
        public String deviceName;
        public String ip;

        public PeerCastRequestEvent(String str, String str2) {
            this.deviceName = str;
            this.ip = str2;
        }

        public PeerCastRequestEvent(String str, String str2, int i) {
            this.deviceName = str;
            this.ip = str2;
            this.castType = i;
        }

        public int getCastType() {
            return this.castType;
        }

        public String getDeviceName() {
            return this.deviceName;
        }

        public String getIp() {
            return this.ip;
        }
    }

    /* loaded from: classes.dex */
    public static class PeerDeviceDealtEvent {
    }

    /* loaded from: classes.dex */
    public static class ScanFinishEvent {
    }

    /* loaded from: classes.dex */
    public static class ServerInfoChangedEvent {
        private String deviceName;
        private String feature;

        public String getDeviceName() {
            return this.deviceName;
        }

        public String getFeature() {
            return this.feature;
        }

        public void setDeviceName(String str) {
            this.deviceName = str;
        }

        public void setFeature(String str) {
            this.feature = str;
        }
    }
}
