package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.c;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements c {

    /* renamed from: b  reason: collision with root package name */
    private static final SparseIntArray f1297b = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    a f1298a;

    static {
        f1297b.put(5, 1);
        f1297b.put(6, 2);
        f1297b.put(7, 2);
        f1297b.put(8, 1);
        f1297b.put(9, 1);
        f1297b.put(10, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(boolean z, int i, int i2) {
        if ((i & 1) == 1) {
            return z ? 1 : 7;
        }
        if ((i & 4) == 4) {
            return z ? 0 : 6;
        }
        switch (i2) {
            case 0:
                return z ? Integer.MIN_VALUE : 3;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            case 15:
            default:
                if (!z) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i2 + " in audio attributes");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        switch (i) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 15:
            default:
                return "unknown usage " + i;
            case 16:
                return "USAGE_ASSISTANT";
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        a aVar = this.f1298a;
        a aVar2 = ((AudioAttributesCompat) obj).f1298a;
        return aVar == null ? aVar2 == null : aVar.equals(aVar2);
    }

    public int hashCode() {
        return this.f1298a.hashCode();
    }

    public String toString() {
        return this.f1298a.toString();
    }
}
