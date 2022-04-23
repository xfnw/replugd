package d.f0.i;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f3608a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f3609b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return this.f3609b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f3609b;
            if (i < iArr.length) {
                this.f3608a = (1 << i) | this.f3608a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f3608a = 0;
        Arrays.fill(this.f3609b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(m mVar) {
        for (int i = 0; i < 10; i++) {
            if (mVar.d(i)) {
                a(i, mVar.a(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if ((this.f3608a & 2) != 0) {
            return this.f3609b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return (this.f3608a & 16) != 0 ? this.f3609b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.f3608a & 128) != 0) {
            return this.f3609b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (this.f3608a & 32) != 0 ? this.f3609b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return Integer.bitCount(this.f3608a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i) {
        return ((1 << i) & this.f3608a) != 0;
    }
}
