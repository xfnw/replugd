package androidx.appcompat.view.menu;

import a.a.ActionBar;
import a.a.f;
import a.a.g;
import a.a.j;
import a.g.l.s;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.q;
import androidx.appcompat.widget.s0;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements q.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    private k f768b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f769c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f770d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f771e;
    private CheckBox f;
    private TextView g;
    private ImageView h;
    private ImageView i;
    private LinearLayout j;
    private Drawable k;
    private int l;
    private Context m;
    private boolean n;
    private Drawable o;
    private boolean p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ActionBar.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        s0 a2 = s0.a(getContext(), attributeSet, j.MenuView, i, 0);
        this.k = a2.b(j.MenuView_android_itemBackground);
        this.l = a2.g(j.MenuView_android_itemTextAppearance, -1);
        this.n = a2.a(j.MenuView_preserveIconSpacing, false);
        this.m = context;
        this.o = a2.b(j.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, ActionBar.dropDownListViewStyle, 0);
        this.p = obtainStyledAttributes.hasValue(0);
        a2.a();
        obtainStyledAttributes.recycle();
    }

    private void a(View view) {
        a(view, -1);
    }

    private void a(View view, int i) {
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(view, i);
        } else {
            addView(view, i);
        }
    }

    private void b() {
        this.f = (CheckBox) getInflater().inflate(g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        a(this.f);
    }

    private void c() {
        this.f769c = (ImageView) getInflater().inflate(g.abc_list_menu_item_icon, (ViewGroup) this, false);
        a(this.f769c, 0);
    }

    private void d() {
        this.f770d = (RadioButton) getInflater().inflate(g.abc_list_menu_item_radio, (ViewGroup) this, false);
        a(this.f770d);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // androidx.appcompat.view.menu.q.a
    public void a(k kVar, int i) {
        this.f768b = kVar;
        setVisibility(kVar.isVisible() ? 0 : 8);
        setTitle(kVar.a(this));
        setCheckable(kVar.isCheckable());
        a(kVar.m(), kVar.d());
        setIcon(kVar.getIcon());
        setEnabled(kVar.isEnabled());
        setSubMenuArrowVisible(kVar.hasSubMenu());
        setContentDescription(kVar.getContentDescription());
    }

    public void a(boolean z, char c2) {
        int i = (!z || !this.f768b.m()) ? 8 : 0;
        if (i == 0) {
            this.g.setText(this.f768b.e());
        }
        if (this.g.getVisibility() != i) {
            this.g.setVisibility(i);
        }
    }

    @Override // androidx.appcompat.view.menu.q.a
    public boolean a() {
        return false;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
            rect.top += this.i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override // androidx.appcompat.view.menu.q.a
    public k getItemData() {
        return this.f768b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        s.a(this, this.k);
        this.f771e = (TextView) findViewById(f.title);
        int i = this.l;
        if (i != -1) {
            this.f771e.setTextAppearance(this.m, i);
        }
        this.g = (TextView) findViewById(f.shortcut);
        this.h = (ImageView) findViewById(f.submenuarrow);
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.i = (ImageView) findViewById(f.group_divider);
        this.j = (LinearLayout) findViewById(f.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f769c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f769c.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.f770d != null || this.f != null) {
            if (this.f768b.i()) {
                if (this.f770d == null) {
                    d();
                }
                compoundButton2 = this.f770d;
                compoundButton = this.f;
            } else {
                if (this.f == null) {
                    b();
                }
                compoundButton2 = this.f;
                compoundButton = this.f770d;
            }
            if (z) {
                compoundButton2.setChecked(this.f768b.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f770d;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f768b.i()) {
            if (this.f770d == null) {
                d();
            }
            compoundButton = this.f770d;
        } else {
            if (this.f == null) {
                b();
            }
            compoundButton = this.f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f768b.l() || this.r;
        if (!z && !this.n) {
            return;
        }
        if (this.f769c != null || drawable != null || this.n) {
            if (this.f769c == null) {
                c();
            }
            if (drawable != null || this.n) {
                ImageView imageView = this.f769c;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f769c.getVisibility() != 0) {
                    this.f769c.setVisibility(0);
                    return;
                }
                return;
            }
            this.f769c.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView;
        int i;
        if (charSequence != null) {
            this.f771e.setText(charSequence);
            if (this.f771e.getVisibility() != 0) {
                textView = this.f771e;
                i = 0;
            } else {
                return;
            }
        } else {
            i = 8;
            if (this.f771e.getVisibility() != 8) {
                textView = this.f771e;
            } else {
                return;
            }
        }
        textView.setVisibility(i);
    }
}
