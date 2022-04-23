package d;

import d.f0.c;
import e.d;

/* loaded from: classes.dex */
public abstract class z {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u f3725a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f3726b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f3727c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f3728d;

        a(u uVar, int i, byte[] bArr, int i2) {
            this.f3725a = uVar;
            this.f3726b = i;
            this.f3727c = bArr;
            this.f3728d = i2;
        }

        @Override // d.z
        public long a() {
            return this.f3726b;
        }

        @Override // d.z
        public void a(d dVar) {
            dVar.write(this.f3727c, this.f3728d, this.f3726b);
        }

        @Override // d.z
        public u b() {
            return this.f3725a;
        }
    }

    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static z a(u uVar, byte[] bArr, int i, int i2) {
        if (bArr != null) {
            c.a(bArr.length, i, i2);
            return new a(uVar, i2, bArr, i);
        }
        throw new NullPointerException("content == null");
    }

    public abstract long a();

    public abstract void a(d dVar);

    public abstract u b();
}
