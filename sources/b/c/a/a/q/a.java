package b.c.a.a.q;

import a.a.l.a.c;
import android.graphics.Rect;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    static final double f1754c = Math.cos(Math.toRadians(45.0d));

    public static float a(float f, float f2, boolean z) {
        if (!z) {
            return f;
        }
        double d2 = f;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - f1754c) * d3));
    }

    public static float b(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        if (!z) {
            return f3;
        }
        double d2 = f3;
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) (d2 + ((1.0d - f1754c) * d3));
    }

    public final void a(float f) {
        throw null;
    }

    public void a(float f, float f2) {
        throw null;
    }

    public float b() {
        throw null;
    }

    public void b(float f) {
        throw null;
    }

    @Override // a.a.l.a.c, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        throw null;
    }
}
