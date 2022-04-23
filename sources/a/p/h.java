package a.p;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f557a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f558b;

    /* renamed from: c  reason: collision with root package name */
    private final float f559c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f560d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    private final PointF f561e = new PointF();
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f557a = property;
        this.f558b = new PathMeasure(path, false);
        this.f559c = this.f558b.getLength();
    }

    /* renamed from: a */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.f558b.getPosTan(this.f559c * f.floatValue(), this.f560d, null);
        PointF pointF = this.f561e;
        float[] fArr = this.f560d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f557a.set(t, pointF);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.util.Property
    public Float get(T t) {
        return Float.valueOf(this.f);
    }
}
