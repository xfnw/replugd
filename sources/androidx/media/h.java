package androidx.media;

import a.g.k.c;
import android.text.TextUtils;

/* loaded from: classes.dex */
class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private String f1307a;

    /* renamed from: b  reason: collision with root package name */
    private int f1308b;

    /* renamed from: c  reason: collision with root package name */
    private int f1309c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, int i, int i2) {
        this.f1307a = str;
        this.f1308b = i;
        this.f1309c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return TextUtils.equals(this.f1307a, hVar.f1307a) && this.f1308b == hVar.f1308b && this.f1309c == hVar.f1309c;
    }

    public int hashCode() {
        return c.a(this.f1307a, Integer.valueOf(this.f1308b), Integer.valueOf(this.f1309c));
    }
}
