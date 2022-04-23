package androidx.media;

import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f1298a = (a) aVar.a((a) audioAttributesCompat.f1298a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, a aVar) {
        aVar.a(false, false);
        aVar.b(audioAttributesCompat.f1298a, 1);
    }
}
