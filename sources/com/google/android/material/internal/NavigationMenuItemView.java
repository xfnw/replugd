package com.google.android.material.internal;

import a.a.ActionBar;
import a.g.l.b0.c;
import a.g.l.s;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.u0;
import androidx.core.content.c.f;
import androidx.core.widget.i;
import b.c.a.a.d;
import b.c.a.a.e;
import b.c.a.a.g;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends c implements q.a {
    private static final int[] G = {16842912};
    private FrameLayout A;
    private k B;
    private ColorStateList C;
    private boolean D;
    private Drawable E;
    private final a.g.l.a F;
    private final int w;
    private boolean x;
    boolean y;
    private final CheckedTextView z;

    /* loaded from: classes.dex */
    class a extends a.g.l.a {
        a() {
        }

        @Override // a.g.l.a
        public void a(View view, c cVar) {
            super.a(view, cVar);
            cVar.a(NavigationMenuItemView.this.y);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = new a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(g.design_navigation_menu_item, (ViewGroup) this, true);
        this.w = context.getResources().getDimensionPixelSize(b.c.a.a.c.design_navigation_icon_size);
        this.z = (CheckedTextView) findViewById(e.design_menu_item_text);
        this.z.setDuplicateParentStateEnabled(true);
        s.a(this.z, this.F);
    }

    private void d() {
        int i;
        f0.a aVar;
        if (f()) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout != null) {
                aVar = (f0.a) frameLayout.getLayoutParams();
                i = -1;
            } else {
                return;
            }
        } else {
            this.z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 != null) {
                aVar = (f0.a) frameLayout2.getLayoutParams();
                i = -2;
            } else {
                return;
            }
        }
        ((ViewGroup.MarginLayoutParams) aVar).width = i;
        this.A.setLayoutParams(aVar);
    }

    private StateListDrawable e() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(ActionBar.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean f() {
        return this.B.getTitle() == null && this.B.getIcon() == null && this.B.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(e.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.q.a
    public void a(k kVar, int i) {
        this.B = kVar;
        setVisibility(kVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            s.a(this, e());
        }
        setCheckable(kVar.isCheckable());
        setChecked(kVar.isChecked());
        setEnabled(kVar.isEnabled());
        setTitle(kVar.getTitle());
        setIcon(kVar.getIcon());
        setActionView(kVar.getActionView());
        setContentDescription(kVar.getContentDescription());
        u0.a(this, kVar.getTooltipText());
        d();
    }

    @Override // androidx.appcompat.view.menu.q.a
    public boolean a() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.q.a
    public k getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        k kVar = this.B;
        if (kVar != null && kVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.y != z) {
            this.y = z;
            this.F.a(this.z, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.z.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.i(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.C);
            }
            int i = this.w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.x) {
            if (this.E == null) {
                this.E = f.a(getResources(), d.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.E;
                if (drawable2 != null) {
                    int i2 = this.w;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.E;
        }
        i.a(this.z, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = this.C != null;
        k kVar = this.B;
        if (kVar != null) {
            setIcon(kVar.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.x = z;
    }

    public void setTextAppearance(int i) {
        i.d(this.z, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }
}
