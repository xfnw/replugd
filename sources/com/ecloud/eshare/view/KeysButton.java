package com.ecloud.eshare.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class KeysButton extends ImageView {

    /* renamed from: e  reason: collision with root package name */
    private a f2955e;
    private Long g;
    private long h;

    /* renamed from: b  reason: collision with root package name */
    private int f2952b = 427;

    /* renamed from: c  reason: collision with root package name */
    private int f2953c = 53;

    /* renamed from: d  reason: collision with root package name */
    private int f2954d = 213;
    private int f = 0;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void b(int i);
    }

    public KeysButton(Context context) {
        super(context);
    }

    public KeysButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KeysButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private boolean a(float f, float f2) {
        float abs = Math.abs(f - (this.f2952b / 2));
        float abs2 = Math.abs(f2 - (this.f2952b / 2));
        return Math.sqrt((double) ((abs * abs) + (abs2 * abs2))) <= ((double) this.f2954d);
    }

    private boolean b(float f, float f2) {
        float abs = Math.abs(f - (this.f2952b / 2));
        float abs2 = Math.abs(f2 - (this.f2952b / 2));
        return Math.sqrt((double) ((abs * abs) + (abs2 * abs2))) <= ((double) this.f2953c);
    }

    private Boolean c(float f, float f2) {
        int i = this.f2952b;
        return Boolean.valueOf(f2 > ((float) (i / 2)) && f2 < ((float) i) && f < ((float) (i / 2)) && f2 > f + ((float) (i / 2)));
    }

    private boolean d(float f, float f2) {
        return f + f2 <= ((float) this.f2952b);
    }

    private Boolean e(float f, float f2) {
        int i = this.f2952b;
        return Boolean.valueOf(f < ((float) (i / 2)) && f2 < ((float) (i / 2)) && f2 < ((float) (i / 2)) - f);
    }

    private Boolean f(float f, float f2) {
        int i = this.f2952b;
        return Boolean.valueOf(f > ((float) (i / 2)) && f < ((float) i) && f2 > ((float) (i / 2)) && f2 < ((float) i) && f2 > ((float) ((i * 3) / 2)) - f);
    }

    private boolean g(float f, float f2) {
        return f >= f2;
    }

    private Boolean h(float f, float f2) {
        int i = this.f2952b;
        return Boolean.valueOf(f < ((float) i) && f > ((float) (i / 2)) && f2 < ((float) (i / 2)) && f2 < f - ((float) (i / 2)));
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f2952b = getMeasuredWidth();
        this.f2954d = (this.f2952b * 213) / 427;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean d2 = d(x, y);
        boolean g = g(x, y);
        int i2 = c(x, y).booleanValue() ? 8 : f(x, y).booleanValue() ? 9 : e(x, y).booleanValue() ? 6 : h(x, y).booleanValue() ? 7 : (!d2 || !g) ? d2 ? 3 : g ? 4 : b(x, y) ? 5 : !a(x, y) ? 0 : 2 : 1;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f = i2;
            setImageLevel(this.f);
            this.g = Long.valueOf(motionEvent.getDownTime());
        } else if (action == 1) {
            setImageLevel(0);
            this.h = motionEvent.getEventTime();
            if (this.h - this.g.longValue() > 1500) {
                this.f2955e.a(this.f);
            } else {
                a aVar = this.f2955e;
                if (!(aVar == null || (i = this.f) == 0)) {
                    aVar.b(i);
                }
            }
        } else if (action != 2) {
            if (action == 3) {
                setImageLevel(0);
            }
        } else if (this.f != i2) {
            setImageLevel(0);
            this.f = 0;
        }
        return true;
    }

    public void setButtonClickListener(a aVar) {
        this.f2955e = aVar;
    }
}
