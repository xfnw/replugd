package com.airbnb.lottie.w;

import android.graphics.Color;
import com.airbnb.lottie.u.k.c;
import com.airbnb.lottie.w.k0.c;
import com.airbnb.lottie.x.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class l implements j0<c> {

    /* renamed from: a  reason: collision with root package name */
    private int f2466a;

    public l(int i) {
        this.f2466a = i;
    }

    private int a(double d2, double[] dArr, double[] dArr2) {
        double d3;
        int i = 1;
        while (true) {
            if (i >= dArr.length) {
                d3 = dArr2[dArr2.length - 1];
                break;
            }
            int i2 = i - 1;
            double d4 = dArr[i2];
            double d5 = dArr[i];
            if (dArr[i] >= d2) {
                d3 = g.a(dArr2[i2], dArr2[i], (d2 - d4) / (d5 - d4));
                break;
            }
            i++;
        }
        return (int) (d3 * 255.0d);
    }

    private void a(c cVar, List<Float> list) {
        int i = this.f2466a * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = list.get(i).floatValue();
                } else {
                    dArr2[i2] = list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < cVar.c(); i3++) {
                int i4 = cVar.a()[i3];
                cVar.a()[i3] = Color.argb(a(cVar.b()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.w.j0
    public c a(com.airbnb.lottie.w.k0.c cVar, float f) {
        ArrayList arrayList = new ArrayList();
        boolean z = cVar.x() == c.b.BEGIN_ARRAY;
        if (z) {
            cVar.m();
        }
        while (cVar.r()) {
            arrayList.add(Float.valueOf((float) cVar.t()));
        }
        if (z) {
            cVar.o();
        }
        if (this.f2466a == -1) {
            this.f2466a = arrayList.size() / 4;
        }
        int i = this.f2466a;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f2466a * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = arrayList.get(i4).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                Double.isNaN(floatValue);
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                Double.isNaN(floatValue);
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                Double.isNaN(floatValue);
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        com.airbnb.lottie.u.k.c cVar2 = new com.airbnb.lottie.u.k.c(fArr, iArr);
        a(cVar2, arrayList);
        return cVar2;
    }
}
