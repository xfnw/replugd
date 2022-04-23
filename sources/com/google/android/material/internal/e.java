package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.c.a.a.b;
import b.c.a.a.i;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f3208a = {b.colorPrimary};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f3209b = {b.colorSecondary};

    public static void a(Context context) {
        a(context, f3208a, "Theme.AppCompat");
    }

    private static void a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ThemeEnforcement, i, i2);
        boolean z = obtainStyledAttributes.getBoolean(i.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z) {
            b(context);
        }
        a(context);
    }

    private static void a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.ThemeEnforcement, i, i2);
        if (!obtainStyledAttributes.getBoolean(i.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        boolean b2 = (iArr2 == null || iArr2.length == 0) ? obtainStyledAttributes.getResourceId(i.ThemeEnforcement_android_textAppearance, -1) != -1 : b(context, attributeSet, iArr, i, i2, iArr2);
        obtainStyledAttributes.recycle();
        if (!b2) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void a(Context context, int[] iArr, String str) {
        if (!a(context, iArr)) {
            throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
        }
    }

    private static boolean a(Context context, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean hasValue = obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        return hasValue;
    }

    public static void b(Context context) {
        a(context, f3209b, "Theme.MaterialComponents");
    }

    private static boolean b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i3, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray c(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        a(context, attributeSet, i, i2);
        a(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }
}
