package a.l.a.a;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f497a;

    /* renamed from: b  reason: collision with root package name */
    private final float f498b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f497a = fArr;
        this.f498b = 1.0f / (this.f497a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f497a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f498b;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.f497a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
