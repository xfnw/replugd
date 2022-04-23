package b.a.a;

import java.util.Arrays;

/* loaded from: classes.dex */
public class e extends i {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f1612a;

    public e(String str) {
        this.f1612a = a.a(str.replaceAll("\\s+", ""));
    }

    public e(byte[] bArr) {
        this.f1612a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void b(c cVar) {
        cVar.a(4, this.f1612a.length);
        cVar.a(this.f1612a);
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(e.class) && Arrays.equals(((e) obj).f1612a, this.f1612a);
    }

    public int hashCode() {
        return 335 + Arrays.hashCode(this.f1612a);
    }
}
