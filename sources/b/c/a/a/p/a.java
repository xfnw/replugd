package b.c.a.a.p;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f1749a;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f1750b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f1751c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f1752d;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1753e;
    private static final int[] f;
    private static final int[] g;
    private static final int[] h;
    private static final int[] i;
    private static final int[] j;

    static {
        f1749a = Build.VERSION.SDK_INT >= 21;
        f1750b = new int[]{16842919};
        f1751c = new int[]{16843623, 16842908};
        f1752d = new int[]{16842908};
        f1753e = new int[]{16843623};
        f = new int[]{16842913, 16842919};
        g = new int[]{16842913, 16843623, 16842908};
        h = new int[]{16842913, 16842908};
        i = new int[]{16842913, 16843623};
        j = new int[]{16842913};
    }

    @TargetApi(21)
    private static int a(int i2) {
        return a.g.e.a.c(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    private static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f1749a ? a(colorForState) : colorForState;
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f1749a) {
            return new ColorStateList(new int[][]{j, StateSet.NOTHING}, new int[]{a(colorStateList, f), a(colorStateList, f1750b)});
        }
        int[] iArr = f;
        int[] iArr2 = g;
        int[] iArr3 = h;
        int[] iArr4 = i;
        int[] iArr5 = f1750b;
        int[] iArr6 = f1751c;
        int[] iArr7 = f1752d;
        int[] iArr8 = f1753e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{a(colorStateList, iArr), a(colorStateList, iArr2), a(colorStateList, iArr3), a(colorStateList, iArr4), 0, a(colorStateList, iArr5), a(colorStateList, iArr6), a(colorStateList, iArr7), a(colorStateList, iArr8), 0});
    }
}
