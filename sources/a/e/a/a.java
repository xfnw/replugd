package a.e.a;

import a.e.a.i;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private final b f124b;

    /* renamed from: c  reason: collision with root package name */
    private final c f125c;
    private int[] f;
    private int[] g;
    private float[] h;

    /* renamed from: a  reason: collision with root package name */
    int f123a = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f126d = 8;

    /* renamed from: e  reason: collision with root package name */
    private i f127e = null;
    private int i = -1;
    private int j = -1;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        int i = this.f126d;
        this.f = new int[i];
        this.g = new int[i];
        this.h = new float[i];
        this.f124b = bVar;
        this.f125c = cVar;
    }

    private boolean a(i iVar, e eVar) {
        return iVar.j <= 1;
    }

    public final float a(i iVar, boolean z) {
        if (this.f127e == iVar) {
            this.f127e = null;
        }
        int i = this.i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f123a) {
            if (this.f[i] == iVar.f149b) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    int[] iArr = this.g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    iVar.b(this.f124b);
                }
                iVar.j--;
                this.f123a--;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i = this.g[i];
            i2++;
            i3 = i;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final i a(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f123a; i3++) {
            if (i3 == i) {
                return this.f125c.f135c[this.f[i2]];
            }
            i2 = this.g[i2];
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a.e.a.i a(a.e.a.e r15) {
        /*
            r14 = this;
            int r0 = r14.i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x000a:
            r9 = -1
            if (r0 == r9) goto L_0x0089
            int r9 = r14.f123a
            if (r2 >= r9) goto L_0x0089
            float[] r9 = r14.h
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            a.e.a.c r12 = r14.f125c
            a.e.a.i[] r12 = r12.f135c
            int[] r13 = r14.f
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0030
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L_0x003c
            r9[r0] = r3
            goto L_0x0036
        L_0x0030:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L_0x003c
            r9[r0] = r3
        L_0x0036:
            a.e.a.b r9 = r14.f124b
            r12.b(r9)
            r10 = 0
        L_0x003c:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L_0x0082
            a.e.a.i$a r11 = r12.g
            a.e.a.i$a r13 = a.e.a.i.a.UNRESTRICTED
            if (r11 != r13) goto L_0x0062
            if (r4 != 0) goto L_0x0051
        L_0x0049:
            boolean r4 = r14.a(r12, r15)
            r6 = r4
            r5 = r10
            r4 = r12
            goto L_0x0082
        L_0x0051:
            int r11 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x0056
            goto L_0x0049
        L_0x0056:
            if (r6 != 0) goto L_0x0082
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L_0x0082
            r5 = r10
            r4 = r12
            r6 = 1
            goto L_0x0082
        L_0x0062:
            if (r4 != 0) goto L_0x0082
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0082
            if (r1 != 0) goto L_0x0072
        L_0x006a:
            boolean r1 = r14.a(r12, r15)
            r8 = r1
            r7 = r10
            r1 = r12
            goto L_0x0082
        L_0x0072:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x0077
            goto L_0x006a
        L_0x0077:
            if (r8 != 0) goto L_0x0082
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L_0x0082
            r7 = r10
            r1 = r12
            r8 = 1
        L_0x0082:
            int[] r9 = r14.g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0089:
            if (r4 == 0) goto L_0x008c
            return r4
        L_0x008c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.a.a(a.e.a.e):a.e.a.i");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i a(boolean[] zArr, i iVar) {
        i.a aVar;
        int i = this.i;
        i iVar2 = null;
        float f = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            if (this.h[i] < 0.0f) {
                i iVar3 = this.f125c.f135c[this.f[i]];
                if ((zArr == null || !zArr[iVar3.f149b]) && iVar3 != iVar && ((aVar = iVar3.g) == i.a.SLACK || aVar == i.a.ERROR)) {
                    float f2 = this.h[i];
                    if (f2 < f) {
                        iVar2 = iVar3;
                        f = f2;
                    }
                }
            }
            i = this.g[i];
        }
        return iVar2;
    }

    public final void a() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            i iVar = this.f125c.f135c[this.f[i]];
            if (iVar != null) {
                iVar.b(this.f124b);
            }
            i = this.g[i];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f123a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f;
            i = this.g[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(b bVar, b bVar2, boolean z) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
                int i3 = this.f[i];
                i iVar = bVar2.f128a;
                if (i3 == iVar.f149b) {
                    float f = this.h[i];
                    a(iVar, z);
                    a aVar = bVar2.f131d;
                    int i4 = aVar.i;
                    for (int i5 = 0; i4 != -1 && i5 < aVar.f123a; i5++) {
                        a(this.f125c.f135c[aVar.f[i4]], aVar.h[i4] * f, z);
                        i4 = aVar.g[i4];
                    }
                    bVar.f129b += bVar2.f129b * f;
                    if (z) {
                        bVar2.f128a.b(bVar);
                    }
                    i = this.i;
                } else {
                    i = this.g[i];
                }
            }
            return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar, b[] bVarArr) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
                i iVar = this.f125c.f135c[this.f[i]];
                if (iVar.f150c != -1) {
                    float f = this.h[i];
                    a(iVar, true);
                    b bVar2 = bVarArr[iVar.f150c];
                    if (!bVar2.f132e) {
                        a aVar = bVar2.f131d;
                        int i3 = aVar.i;
                        for (int i4 = 0; i3 != -1 && i4 < aVar.f123a; i4++) {
                            a(this.f125c.f135c[aVar.f[i3]], aVar.h[i3] * f, true);
                            i3 = aVar.g[i3];
                        }
                    }
                    bVar.f129b += bVar2.f129b * f;
                    bVar2.f128a.b(bVar);
                    i = this.i;
                } else {
                    i = this.g[i];
                }
            }
            return;
        }
    }

    public final void a(i iVar, float f) {
        if (f == 0.0f) {
            a(iVar, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.h;
            int i2 = this.i;
            fArr[i2] = f;
            this.f[i2] = iVar.f149b;
            this.g[i2] = -1;
            iVar.j++;
            iVar.a(this.f124b);
            this.f123a++;
            if (!this.k) {
                this.j++;
                int i3 = this.j;
                int[] iArr = this.f;
                if (i3 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f123a; i5++) {
            int[] iArr2 = this.f;
            int i6 = iArr2[i];
            int i7 = iVar.f149b;
            if (i6 == i7) {
                this.h[i] = f;
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.g[i];
        }
        int i8 = this.j;
        i8++;
        if (this.k) {
            int[] iArr3 = this.f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        }
        int[] iArr4 = this.f;
        if (i8 >= iArr4.length && this.f123a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f;
                if (i9 >= iArr5.length) {
                    break;
                } else if (iArr5[i9] == -1) {
                    i8 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr6 = this.f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            this.f126d *= 2;
            this.k = false;
            this.j = i8 - 1;
            this.h = Arrays.copyOf(this.h, this.f126d);
            this.f = Arrays.copyOf(this.f, this.f126d);
            this.g = Arrays.copyOf(this.g, this.f126d);
        }
        this.f[i8] = iVar.f149b;
        this.h[i8] = f;
        int[] iArr7 = this.g;
        if (i4 != -1) {
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            iArr7[i8] = this.i;
            this.i = i8;
        }
        iVar.j++;
        iVar.a(this.f124b);
        this.f123a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f123a >= this.f.length) {
            this.k = true;
        }
        int i10 = this.j;
        int[] iArr8 = this.f;
        if (i10 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(i iVar, float f, boolean z) {
        if (f != 0.0f) {
            int i = this.i;
            if (i == -1) {
                this.i = 0;
                float[] fArr = this.h;
                int i2 = this.i;
                fArr[i2] = f;
                this.f[i2] = iVar.f149b;
                this.g[i2] = -1;
                iVar.j++;
                iVar.a(this.f124b);
                this.f123a++;
                if (!this.k) {
                    this.j++;
                    int i3 = this.j;
                    int[] iArr = this.f;
                    if (i3 >= iArr.length) {
                        this.k = true;
                        this.j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i4 = -1;
            for (int i5 = 0; i != -1 && i5 < this.f123a; i5++) {
                int[] iArr2 = this.f;
                int i6 = iArr2[i];
                int i7 = iVar.f149b;
                if (i6 == i7) {
                    float[] fArr2 = this.h;
                    fArr2[i] = fArr2[i] + f;
                    if (fArr2[i] == 0.0f) {
                        if (i == this.i) {
                            this.i = this.g[i];
                        } else {
                            int[] iArr3 = this.g;
                            iArr3[i4] = iArr3[i];
                        }
                        if (z) {
                            iVar.b(this.f124b);
                        }
                        if (this.k) {
                            this.j = i;
                        }
                        iVar.j--;
                        this.f123a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i] < i7) {
                    i4 = i;
                }
                i = this.g[i];
            }
            int i8 = this.j;
            i8++;
            if (this.k) {
                int[] iArr4 = this.f;
                if (iArr4[i8] != -1) {
                    i8 = iArr4.length;
                }
            }
            int[] iArr5 = this.f;
            if (i8 >= iArr5.length && this.f123a < iArr5.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr6 = this.f;
                    if (i9 >= iArr6.length) {
                        break;
                    } else if (iArr6[i9] == -1) {
                        i8 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr7 = this.f;
            if (i8 >= iArr7.length) {
                i8 = iArr7.length;
                this.f126d *= 2;
                this.k = false;
                this.j = i8 - 1;
                this.h = Arrays.copyOf(this.h, this.f126d);
                this.f = Arrays.copyOf(this.f, this.f126d);
                this.g = Arrays.copyOf(this.g, this.f126d);
            }
            this.f[i8] = iVar.f149b;
            this.h[i8] = f;
            int[] iArr8 = this.g;
            if (i4 != -1) {
                iArr8[i8] = iArr8[i4];
                iArr8[i4] = i8;
            } else {
                iArr8[i8] = this.i;
                this.i = i8;
            }
            iVar.j++;
            iVar.a(this.f124b);
            this.f123a++;
            if (!this.k) {
                this.j++;
            }
            int i10 = this.j;
            int[] iArr9 = this.f;
            if (i10 >= iArr9.length) {
                this.k = true;
                this.j = iArr9.length - 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(i iVar) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            if (this.f[i] == iVar.f149b) {
                return true;
            }
            i = this.g[i];
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final float b(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f123a; i3++) {
            if (i3 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
        }
        return 0.0f;
    }

    public final float b(i iVar) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            if (this.f[i] == iVar.f149b) {
                return this.h[i];
            }
            i = this.g[i];
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            float[] fArr = this.h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.g[i];
        }
    }

    public String toString() {
        int i = this.i;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f123a; i2++) {
            str = ((str + " -> ") + this.h[i] + " : ") + this.f125c.f135c[this.f[i]];
            i = this.g[i];
        }
        return str;
    }
}
