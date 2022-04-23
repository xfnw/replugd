package androidx.constraintlayout.widget;

import a.e.a.j.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: c  reason: collision with root package name */
    protected int f1120c;

    /* renamed from: d  reason: collision with root package name */
    protected Context f1121d;

    /* renamed from: e  reason: collision with root package name */
    protected j f1122e;
    private String g;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f1119b = new int[32];
    protected boolean f = false;

    public b(Context context) {
        super(context);
        this.f1121d = context;
        a((AttributeSet) null);
    }

    private void a(String str) {
        int i;
        Object a2;
        if (str != null && this.f1121d != null) {
            String trim = str.trim();
            try {
                i = g.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = this.f1121d.getResources().getIdentifier(trim, "id", this.f1121d.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
                i = ((Integer) a2).intValue();
            }
            if (i != 0) {
                setTag(i, null);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    a(str.substring(i));
                    return;
                } else {
                    a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    public void a() {
        if (this.f1122e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).k0 = this.f1122e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.g = obtainStyledAttributes.getString(index);
                    setIds(this.g);
                }
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.g);
        }
        j jVar = this.f1122e;
        if (jVar != null) {
            jVar.J();
            for (int i = 0; i < this.f1120c; i++) {
                View a2 = constraintLayout.a(this.f1119b[i]);
                if (a2 != null) {
                    this.f1122e.b(constraintLayout.a(a2));
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1119b, this.f1120c);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1120c = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.f1120c + 1;
        int[] iArr = this.f1119b;
        if (i2 > iArr.length) {
            this.f1119b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1119b;
        int i3 = this.f1120c;
        iArr2[i3] = i;
        this.f1120c = i3 + 1;
    }
}
