package b.a.a;

/* loaded from: classes.dex */
public class m extends i {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f1626a;

    public m(String str, byte[] bArr) {
        this.f1626a = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void b(c cVar) {
        cVar.a((this.f1626a.length + 128) - 1);
        cVar.a(this.f1626a);
    }
}
