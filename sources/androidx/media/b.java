package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* loaded from: classes.dex */
class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f1299a;

    /* renamed from: b  reason: collision with root package name */
    int f1300b = -1;

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f1299a.equals(((b) obj).f1299a);
    }

    public int hashCode() {
        return this.f1299a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1299a;
    }
}
