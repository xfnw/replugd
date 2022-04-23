package androidx.appcompat.widget;

import a.a.ActionBar;
import a.a.j;
import a.g.l.s;
import a.g.l.w;
import a.g.l.x;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    protected final C0032a f912b;

    /* renamed from: c  reason: collision with root package name */
    protected final Context f913c;

    /* renamed from: d  reason: collision with root package name */
    protected ActionMenuView f914d;

    /* renamed from: e  reason: collision with root package name */
    protected c f915e;
    protected int f;
    protected w g;
    private boolean h;
    private boolean i;

    /* renamed from: androidx.appcompat.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    protected class C0032a implements x {

        /* renamed from: a  reason: collision with root package name */
        private boolean f916a = false;

        /* renamed from: b  reason: collision with root package name */
        int f917b;

        protected C0032a() {
        }

        public C0032a a(w wVar, int i) {
            a.this.g = wVar;
            this.f917b = i;
            return this;
        }

        @Override // a.g.l.x
        public void a(View view) {
            if (!this.f916a) {
                a aVar = a.this;
                aVar.g = null;
                a.super.setVisibility(this.f917b);
            }
        }

        @Override // a.g.l.x
        public void b(View view) {
            a.super.setVisibility(0);
            this.f916a = false;
        }

        @Override // a.g.l.x
        public void c(View view) {
            this.f916a = true;
        }
    }

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.f912b = new C0032a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(ActionBar.actionBarPopupTheme, typedValue, true) || (i2 = typedValue.resourceId) == 0) {
            this.f913c = context;
        } else {
            this.f913c = new ContextThemeWrapper(context, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public w a(int i, long j) {
        w wVar = this.g;
        if (wVar != null) {
            wVar.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            w a2 = s.a(this);
            a2.a(1.0f);
            a2.a(j);
            C0032a aVar = this.f912b;
            aVar.a(a2, i);
            a2.a(aVar);
            return a2;
        }
        w a3 = s.a(this);
        a3.a(0.0f);
        a3.a(j);
        C0032a aVar2 = this.f912b;
        aVar2.a(a3, i);
        a3.a(aVar2);
        return a3;
    }

    public int getAnimatedVisibility() {
        return this.g != null ? this.f912b.f917b : getVisibility();
    }

    public int getContentHeight() {
        return this.f;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.ActionBar, ActionBar.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.f915e;
        if (cVar != null) {
            cVar.a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            w wVar = this.g;
            if (wVar != null) {
                wVar.a();
            }
            super.setVisibility(i);
        }
    }
}
