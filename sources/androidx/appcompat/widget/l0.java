package androidx.appcompat.widget;

import a.a.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.f0;

/* loaded from: classes.dex */
public class l0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    Runnable f988b;

    /* renamed from: c  reason: collision with root package name */
    private c f989c;

    /* renamed from: d  reason: collision with root package name */
    f0 f990d;

    /* renamed from: e  reason: collision with root package name */
    private Spinner f991e;
    private boolean f;
    int g;
    int h;
    private int i;
    private int j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f992b;

        a(View view) {
            this.f992b = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.smoothScrollTo(this.f992b.getLeft() - ((l0.this.getWidth() - this.f992b.getWidth()) / 2), 0);
            l0.this.f988b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BaseAdapter {
        b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return l0.this.f990d.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((d) l0.this.f990d.getChildAt(i)).a();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return l0.this.a((a.c) getItem(i), true);
            }
            ((d) view).a((a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).a().e();
            int childCount = l0.this.f990d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = l0.this.f990d.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private final int[] f996b = {16842964};

        /* renamed from: c  reason: collision with root package name */
        private a.c f997c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f998d;

        /* renamed from: e  reason: collision with root package name */
        private ImageView f999e;
        private View f;

        public d(Context context, a.c cVar, boolean z) {
            super(context, null, ActionBar.actionBarTabStyle);
            this.f997c = cVar;
            s0 a2 = s0.a(context, null, this.f996b, ActionBar.actionBarTabStyle, 0);
            if (a2.g(0)) {
                setBackgroundDrawable(a2.b(0));
            }
            a2.a();
            if (z) {
                setGravity(8388627);
            }
            b();
        }

        public a.c a() {
            return this.f997c;
        }

        public void a(a.c cVar) {
            this.f997c = cVar;
            b();
        }

        public void b() {
            a.c cVar = this.f997c;
            View b2 = cVar.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.f = b2;
                TextView textView = this.f998d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f999e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f999e.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f;
            if (view != null) {
                removeView(view);
                this.f = null;
            }
            Drawable c2 = cVar.c();
            CharSequence d2 = cVar.d();
            if (c2 != null) {
                if (this.f999e == null) {
                    n nVar = new n(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    nVar.setLayoutParams(layoutParams);
                    addView(nVar, 0);
                    this.f999e = nVar;
                }
                this.f999e.setImageDrawable(c2);
                this.f999e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f999e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f999e.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(d2);
            if (z) {
                if (this.f998d == null) {
                    x xVar = new x(getContext(), null, ActionBar.actionBarTabTextStyle);
                    xVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    xVar.setLayoutParams(layoutParams2);
                    addView(xVar);
                    this.f998d = xVar;
                }
                this.f998d.setText(d2);
                this.f998d.setVisibility(0);
            } else {
                TextView textView2 = this.f998d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f998d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f999e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.a());
            }
            if (!z) {
                charSequence = cVar.a();
            }
            u0.a(this, charSequence);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (l0.this.g > 0) {
                int measuredWidth = getMeasuredWidth();
                int i3 = l0.this.g;
                if (measuredWidth > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    static {
        new DecelerateInterpolator();
    }

    private Spinner a() {
        v vVar = new v(getContext(), null, ActionBar.actionDropDownStyle);
        vVar.setLayoutParams(new f0.a(-2, -1));
        vVar.setOnItemSelectedListener(this);
        return vVar;
    }

    private boolean b() {
        Spinner spinner = this.f991e;
        return spinner != null && spinner.getParent() == this;
    }

    private void c() {
        if (!b()) {
            if (this.f991e == null) {
                this.f991e = a();
            }
            removeView(this.f990d);
            addView(this.f991e, new ViewGroup.LayoutParams(-2, -1));
            if (this.f991e.getAdapter() == null) {
                this.f991e.setAdapter((SpinnerAdapter) new b());
            }
            Runnable runnable = this.f988b;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f988b = null;
            }
            this.f991e.setSelection(this.j);
        }
    }

    private boolean d() {
        if (!b()) {
            return false;
        }
        removeView(this.f991e);
        addView(this.f990d, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f991e.getSelectedItemPosition());
        return false;
    }

    d a(a.c cVar, boolean z) {
        d dVar = new d(getContext(), cVar, z);
        if (z) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.i));
        } else {
            dVar.setFocusable(true);
            if (this.f989c == null) {
                this.f989c = new c();
            }
            dVar.setOnClickListener(this.f989c);
        }
        return dVar;
    }

    public void a(int i) {
        View childAt = this.f990d.getChildAt(i);
        Runnable runnable = this.f988b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f988b = new a(childAt);
        post(this.f988b);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f988b;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a.a.n.a a2 = a.a.n.a.a(getContext());
        setContentHeight(a2.e());
        this.h = a2.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f988b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((d) view).a().e();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f990d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i3 = -1;
        } else {
            if (childCount > 2) {
                this.g = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.g = View.MeasureSpec.getSize(i) / 2;
            }
            i3 = Math.min(this.g, this.h);
        }
        this.g = i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.i, 1073741824);
        if (z2 || !this.f) {
            z = false;
        }
        if (z) {
            this.f990d.measure(0, makeMeasureSpec);
            if (this.f990d.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                c();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z2 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.j);
                    return;
                }
            }
        }
        d();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f = z;
    }

    public void setContentHeight(int i) {
        this.i = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.j = i;
        int childCount = this.f990d.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f990d.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                a(i);
            }
            i2++;
        }
        Spinner spinner = this.f991e;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }
}
