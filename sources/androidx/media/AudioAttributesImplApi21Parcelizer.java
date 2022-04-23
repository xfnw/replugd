package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static b read(a aVar) {
        b bVar = new b();
        bVar.f1299a = (AudioAttributes) aVar.a((a) bVar.f1299a, 1);
        bVar.f1300b = aVar.a(bVar.f1300b, 2);
        return bVar;
    }

    public static void write(b bVar, a aVar) {
        aVar.a(false, false);
        aVar.b(bVar.f1299a, 1);
        aVar.b(bVar.f1300b, 2);
    }
}
