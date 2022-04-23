package androidx.media;

import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static c read(a aVar) {
        c cVar = new c();
        cVar.f1301a = aVar.a(cVar.f1301a, 1);
        cVar.f1302b = aVar.a(cVar.f1302b, 2);
        cVar.f1303c = aVar.a(cVar.f1303c, 3);
        cVar.f1304d = aVar.a(cVar.f1304d, 4);
        return cVar;
    }

    public static void write(c cVar, a aVar) {
        aVar.a(false, false);
        aVar.b(cVar.f1301a, 1);
        aVar.b(cVar.f1302b, 2);
        aVar.b(cVar.f1303c, 3);
        aVar.b(cVar.f1304d, 4);
    }
}
