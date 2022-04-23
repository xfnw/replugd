package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1210a = aVar.a(iconCompat.f1210a, 1);
        iconCompat.f1212c = aVar.a(iconCompat.f1212c, 2);
        iconCompat.f1213d = aVar.a((a) iconCompat.f1213d, 3);
        iconCompat.f1214e = aVar.a(iconCompat.f1214e, 4);
        iconCompat.f = aVar.a(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.a((a) iconCompat.g, 6);
        iconCompat.i = aVar.a(iconCompat.i, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.a(true, true);
        iconCompat.a(aVar.c());
        aVar.b(iconCompat.f1210a, 1);
        aVar.b(iconCompat.f1212c, 2);
        aVar.b(iconCompat.f1213d, 3);
        aVar.b(iconCompat.f1214e, 4);
        aVar.b(iconCompat.f, 5);
        aVar.b(iconCompat.g, 6);
        aVar.b(iconCompat.i, 7);
    }
}
