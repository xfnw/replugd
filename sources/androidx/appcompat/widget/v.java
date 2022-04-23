package androidx.appcompat.widget;

import a.a.ActionBar;
import a.g.l.r;
import a.g.l.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.view.menu.t;

/* loaded from: classes.dex */
public class v extends Spinner implements r {
    private static final int[] j = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final e f1052b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1053c;

    /* renamed from: d  reason: collision with root package name */
    private e0 f1054d;

    /* renamed from: e  reason: collision with root package name */
    private SpinnerAdapter f1055e;
    private final boolean f;
    c g;
    int h;
    final Rect i;

    /* loaded from: classes.dex */
    class a extends e0 {
        final /* synthetic */ c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, c cVar) {
            super(view);
            this.k = cVar;
        }

        @Override // androidx.appcompat.widget.e0
        public t e() {
            return this.k;
        }

        @Override // androidx.appcompat.widget.e0
        public boolean f() {
            if (v.this.g.c()) {
                return true;
            }
            v.this.g.b();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements ListAdapter, SpinnerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private SpinnerAdapter f1056b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1057c;

        public b(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1056b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1057c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof o0) {
                o0 o0Var = (o0) spinnerAdapter;
                if (o0Var.getDropDownViewTheme() == null) {
                    o0Var.setDropDownViewTheme(theme);
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1057c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1057c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1056b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends g0 {
        private CharSequence J;
        ListAdapter K;
        private final Rect L = new Rect();

        /* loaded from: classes.dex */
        class a implements AdapterView.OnItemClickListener {
            a(v vVar) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.this.setSelection(i);
                if (v.this.getOnItemClickListener() != null) {
                    c cVar = c.this;
                    v.this.performItemClick(view, i, cVar.K.getItemId(i));
                }
                c.this.dismiss();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                c cVar = c.this;
                if (!cVar.b(v.this)) {
                    c.this.dismiss();
                    return;
                }
                c.this.l();
                c.super.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.appcompat.widget.v$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0034c implements PopupWindow.OnDismissListener {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1060b;

            C0034c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1060b = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = v.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1060b);
                }
            }
        }

        public c(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            a(v.this);
            a(true);
            f(0);
            a(new a(v.this));
        }

        @Override // androidx.appcompat.widget.g0
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.K = listAdapter;
        }

        public void a(CharSequence charSequence) {
            this.J = charSequence;
        }

        @Override // androidx.appcompat.widget.g0, androidx.appcompat.view.menu.t
        public void b() {
            ViewTreeObserver viewTreeObserver;
            boolean c2 = c();
            l();
            e(2);
            super.b();
            d().setChoiceMode(1);
            g(v.this.getSelectedItemPosition());
            if (!c2 && (viewTreeObserver = v.this.getViewTreeObserver()) != null) {
                b bVar = new b();
                viewTreeObserver.addOnGlobalLayoutListener(bVar);
                a(new C0034c(bVar));
            }
        }

        boolean b(View view) {
            return s.v(view) && view.getGlobalVisibleRect(this.L);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0095  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void l() {
            /*
                r8 = this;
                android.graphics.drawable.Drawable r0 = r8.f()
                r1 = 0
                if (r0 == 0) goto L_0x0026
                androidx.appcompat.widget.v r1 = androidx.appcompat.widget.v.this
                android.graphics.Rect r1 = r1.i
                r0.getPadding(r1)
                androidx.appcompat.widget.v r0 = androidx.appcompat.widget.v.this
                boolean r0 = androidx.appcompat.widget.y0.a(r0)
                if (r0 == 0) goto L_0x001d
                androidx.appcompat.widget.v r0 = androidx.appcompat.widget.v.this
                android.graphics.Rect r0 = r0.i
                int r0 = r0.right
                goto L_0x0024
            L_0x001d:
                androidx.appcompat.widget.v r0 = androidx.appcompat.widget.v.this
                android.graphics.Rect r0 = r0.i
                int r0 = r0.left
                int r0 = -r0
            L_0x0024:
                r1 = r0
                goto L_0x002e
            L_0x0026:
                androidx.appcompat.widget.v r0 = androidx.appcompat.widget.v.this
                android.graphics.Rect r0 = r0.i
                r0.right = r1
                r0.left = r1
            L_0x002e:
                androidx.appcompat.widget.v r0 = androidx.appcompat.widget.v.this
                int r0 = r0.getPaddingLeft()
                androidx.appcompat.widget.v r2 = androidx.appcompat.widget.v.this
                int r2 = r2.getPaddingRight()
                androidx.appcompat.widget.v r3 = androidx.appcompat.widget.v.this
                int r3 = r3.getWidth()
                androidx.appcompat.widget.v r4 = androidx.appcompat.widget.v.this
                int r5 = r4.h
                r6 = -2
                if (r5 != r6) goto L_0x0078
                android.widget.ListAdapter r5 = r8.K
                android.widget.SpinnerAdapter r5 = (android.widget.SpinnerAdapter) r5
                android.graphics.drawable.Drawable r6 = r8.f()
                int r4 = r4.a(r5, r6)
                androidx.appcompat.widget.v r5 = androidx.appcompat.widget.v.this
                android.content.Context r5 = r5.getContext()
                android.content.res.Resources r5 = r5.getResources()
                android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
                int r5 = r5.widthPixels
                androidx.appcompat.widget.v r6 = androidx.appcompat.widget.v.this
                android.graphics.Rect r6 = r6.i
                int r7 = r6.left
                int r5 = r5 - r7
                int r6 = r6.right
                int r5 = r5 - r6
                if (r4 <= r5) goto L_0x0070
                r4 = r5
            L_0x0070:
                int r5 = r3 - r0
                int r5 = r5 - r2
                int r4 = java.lang.Math.max(r4, r5)
                goto L_0x007e
            L_0x0078:
                r4 = -1
                if (r5 != r4) goto L_0x0082
                int r4 = r3 - r0
                int r4 = r4 - r2
            L_0x007e:
                r8.b(r4)
                goto L_0x0085
            L_0x0082:
                r8.b(r5)
            L_0x0085:
                androidx.appcompat.widget.v r4 = androidx.appcompat.widget.v.this
                boolean r4 = androidx.appcompat.widget.y0.a(r4)
                if (r4 == 0) goto L_0x0095
                int r3 = r3 - r2
                int r0 = r8.i()
                int r3 = r3 - r0
                int r1 = r1 + r3
                goto L_0x0096
            L_0x0095:
                int r1 = r1 + r0
            L_0x0096:
                r8.d(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v.c.l():void");
        }

        public CharSequence m() {
            return this.J;
        }
    }

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.spinnerStyle);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public v(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r12 != null) goto L_0x0056;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
        r12.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0068, code lost:
        if (r12 == null) goto L_0x0072;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public v(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) {
        /*
            r7 = this;
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r7.i = r0
            int[] r0 = a.a.j.Spinner
            r1 = 0
            androidx.appcompat.widget.s0 r0 = androidx.appcompat.widget.s0.a(r8, r9, r0, r10, r1)
            androidx.appcompat.widget.e r2 = new androidx.appcompat.widget.e
            r2.<init>(r7)
            r7.f1052b = r2
            r2 = 0
            if (r12 == 0) goto L_0x0023
            a.a.n.d r3 = new a.a.n.d
            r3.<init>(r8, r12)
        L_0x0020:
            r7.f1053c = r3
            goto L_0x003c
        L_0x0023:
            int r12 = a.a.j.Spinner_popupTheme
            int r12 = r0.g(r12, r1)
            if (r12 == 0) goto L_0x0031
            a.a.n.d r3 = new a.a.n.d
            r3.<init>(r8, r12)
            goto L_0x0020
        L_0x0031:
            int r12 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r12 >= r3) goto L_0x0039
            r12 = r8
            goto L_0x003a
        L_0x0039:
            r12 = r2
        L_0x003a:
            r7.f1053c = r12
        L_0x003c:
            android.content.Context r12 = r7.f1053c
            r3 = 1
            if (r12 == 0) goto L_0x00aa
            r12 = -1
            if (r11 != r12) goto L_0x0072
            int[] r12 = androidx.appcompat.widget.v.j     // Catch: all -> 0x005c, Exception -> 0x005f
            android.content.res.TypedArray r12 = r8.obtainStyledAttributes(r9, r12, r10, r1)     // Catch: all -> 0x005c, Exception -> 0x005f
            boolean r4 = r12.hasValue(r1)     // Catch: Exception -> 0x005a, all -> 0x006b
            if (r4 == 0) goto L_0x0054
            int r11 = r12.getInt(r1, r1)     // Catch: Exception -> 0x005a, all -> 0x006b
        L_0x0054:
            if (r12 == 0) goto L_0x0072
        L_0x0056:
            r12.recycle()
            goto L_0x0072
        L_0x005a:
            r4 = move-exception
            goto L_0x0061
        L_0x005c:
            r8 = move-exception
            r12 = r2
            goto L_0x006c
        L_0x005f:
            r4 = move-exception
            r12 = r2
        L_0x0061:
            java.lang.String r5 = "AppCompatSpinner"
            java.lang.String r6 = "Could not read android:spinnerMode"
            android.util.Log.i(r5, r6, r4)     // Catch: all -> 0x006b
            if (r12 == 0) goto L_0x0072
            goto L_0x0056
        L_0x006b:
            r8 = move-exception
        L_0x006c:
            if (r12 == 0) goto L_0x0071
            r12.recycle()
        L_0x0071:
            throw r8
        L_0x0072:
            if (r11 != r3) goto L_0x00aa
            androidx.appcompat.widget.v$c r11 = new androidx.appcompat.widget.v$c
            android.content.Context r12 = r7.f1053c
            r11.<init>(r12, r9, r10)
            android.content.Context r12 = r7.f1053c
            int[] r4 = a.a.j.Spinner
            androidx.appcompat.widget.s0 r12 = androidx.appcompat.widget.s0.a(r12, r9, r4, r10, r1)
            int r1 = a.a.j.Spinner_android_dropDownWidth
            r4 = -2
            int r1 = r12.f(r1, r4)
            r7.h = r1
            int r1 = a.a.j.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r1 = r12.b(r1)
            r11.a(r1)
            int r1 = a.a.j.Spinner_android_prompt
            java.lang.String r1 = r0.d(r1)
            r11.a(r1)
            r12.a()
            r7.g = r11
            androidx.appcompat.widget.v$a r12 = new androidx.appcompat.widget.v$a
            r12.<init>(r7, r11)
            r7.f1054d = r12
        L_0x00aa:
            int r11 = a.a.j.Spinner_android_entries
            java.lang.CharSequence[] r11 = r0.f(r11)
            if (r11 == 0) goto L_0x00c2
            android.widget.ArrayAdapter r12 = new android.widget.ArrayAdapter
            r1 = 17367048(0x1090008, float:2.5162948E-38)
            r12.<init>(r8, r1, r11)
            int r8 = a.a.g.support_simple_spinner_dropdown_item
            r12.setDropDownViewResource(r8)
            r7.setAdapter(r12)
        L_0x00c2:
            r0.a()
            r7.f = r3
            android.widget.SpinnerAdapter r8 = r7.f1055e
            if (r8 == 0) goto L_0x00d0
            r7.setAdapter(r8)
            r7.f1055e = r2
        L_0x00d0:
            androidx.appcompat.widget.e r8 = r7.f1052b
            r8.a(r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.v.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i2;
        }
        drawable.getPadding(this.i);
        Rect rect = this.i;
        return i2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.g();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.g != null) {
            return this.h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        c cVar = this.g;
        if (cVar != null) {
            return cVar.f();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.g != null) {
            return this.f1053c;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        c cVar = this.g;
        return cVar != null ? cVar.m() : super.getPrompt();
    }

    @Override // a.g.l.r
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1052b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // a.g.l.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1052b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.g;
        if (cVar != null && cVar.c()) {
            this.g.dismiss();
        }
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e0 e0Var = this.f1054d;
        if (e0Var == null || !e0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        c cVar = this.g;
        if (cVar == null) {
            return super.performClick();
        }
        if (cVar.c()) {
            return true;
        }
        this.g.b();
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f) {
            this.f1055e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.g != null) {
            Context context = this.f1053c;
            if (context == null) {
                context = getContext();
            }
            this.g.a(new b(spinnerAdapter, context.getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.h(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.g != null) {
            this.h = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(a.a.k.a.a.c(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        c cVar = this.g;
        if (cVar != null) {
            cVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.b(colorStateList);
        }
    }

    @Override // a.g.l.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1052b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }
}
