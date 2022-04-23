package androidx.appcompat.widget;

import a.g.e.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1011a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f1012b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f1013c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f1014d = {16842919};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f1015e = {16842912};
    static final int[] f = new int[0];
    private static final int[] g = new int[1];

    static {
        new int[1][0] = 16843518;
        new int[1][0] = 16842913;
    }

    public static int a(Context context, int i) {
        ColorStateList c2 = c(context, i);
        if (c2 != null && c2.isStateful()) {
            return c2.getColorForState(f1012b, c2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return a(context, i, a2.getFloat());
    }

    static int a(Context context, int i, float f2) {
        int b2 = b(context, i);
        return a.c(b2, Math.round(Color.alpha(b2) * f2));
    }

    private static TypedValue a() {
        TypedValue typedValue = f1011a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1011a.set(typedValue2);
        return typedValue2;
    }

    public static int b(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        s0 a2 = s0.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0, 0);
        } finally {
            a2.a();
        }
    }

    public static ColorStateList c(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        s0 a2 = s0.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0);
        } finally {
            a2.a();
        }
    }
}
