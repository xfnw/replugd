package androidx.appcompat.widget;

import a.a.k.a.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.c.f;

/* loaded from: classes.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1036a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1037b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1038c;

    private s0(Context context, TypedArray typedArray) {
        this.f1036a = context;
        this.f1037b = typedArray;
    }

    public static s0 a(Context context, int i, int[] iArr) {
        return new s0(context, context.obtainStyledAttributes(i, iArr));
    }

    public static s0 a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new s0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static s0 a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new s0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float a(int i, float f) {
        return this.f1037b.getFloat(i, f);
    }

    public int a(int i, int i2) {
        return this.f1037b.getColor(i, i2);
    }

    public ColorStateList a(int i) {
        int resourceId;
        ColorStateList b2;
        return (!this.f1037b.hasValue(i) || (resourceId = this.f1037b.getResourceId(i, 0)) == 0 || (b2 = a.b(this.f1036a, resourceId)) == null) ? this.f1037b.getColorStateList(i) : b2;
    }

    public Typeface a(int i, int i2, f.a aVar) {
        int resourceId = this.f1037b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1038c == null) {
            this.f1038c = new TypedValue();
        }
        return f.a(this.f1036a, resourceId, this.f1038c, i2, aVar);
    }

    public void a() {
        this.f1037b.recycle();
    }

    public boolean a(int i, boolean z) {
        return this.f1037b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f1037b.getDimensionPixelOffset(i, i2);
    }

    public Drawable b(int i) {
        int resourceId;
        return (!this.f1037b.hasValue(i) || (resourceId = this.f1037b.getResourceId(i, 0)) == 0) ? this.f1037b.getDrawable(i) : a.c(this.f1036a, resourceId);
    }

    public int c(int i, int i2) {
        return this.f1037b.getDimensionPixelSize(i, i2);
    }

    public Drawable c(int i) {
        int resourceId;
        if (!this.f1037b.hasValue(i) || (resourceId = this.f1037b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return j.a().a(this.f1036a, resourceId, true);
    }

    public int d(int i, int i2) {
        return this.f1037b.getInt(i, i2);
    }

    public String d(int i) {
        return this.f1037b.getString(i);
    }

    public int e(int i, int i2) {
        return this.f1037b.getInteger(i, i2);
    }

    public CharSequence e(int i) {
        return this.f1037b.getText(i);
    }

    public int f(int i, int i2) {
        return this.f1037b.getLayoutDimension(i, i2);
    }

    public CharSequence[] f(int i) {
        return this.f1037b.getTextArray(i);
    }

    public int g(int i, int i2) {
        return this.f1037b.getResourceId(i, i2);
    }

    public boolean g(int i) {
        return this.f1037b.hasValue(i);
    }
}
