package b.c.a.a.j;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1720a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1721b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f1722c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f1720a);
        matrix2.getValues(this.f1721b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f1721b;
            float f2 = fArr[i];
            float[] fArr2 = this.f1720a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.f1722c.setValues(this.f1721b);
        return this.f1722c;
    }
}
