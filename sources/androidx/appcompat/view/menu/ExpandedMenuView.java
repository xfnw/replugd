package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.widget.s0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements h.b, q, AdapterView.OnItemClickListener {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f765d = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private h f766b;

    /* renamed from: c  reason: collision with root package name */
    private int f767c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        s0 a2 = s0.a(context, attributeSet, f765d, i, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.b(0));
        }
        if (a2.g(1)) {
            setDivider(a2.b(1));
        }
        a2.a();
    }

    @Override // androidx.appcompat.view.menu.q
    public void a(h hVar) {
        this.f766b = hVar;
    }

    @Override // androidx.appcompat.view.menu.h.b
    public boolean a(k kVar) {
        return this.f766b.a(kVar, 0);
    }

    public int getWindowAnimations() {
        return this.f767c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((k) getAdapter().getItem(i));
    }
}
