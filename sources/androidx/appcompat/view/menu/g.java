package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.q;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class g extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    h f804b;

    /* renamed from: c  reason: collision with root package name */
    private int f805c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f806d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f807e;
    private final LayoutInflater f;
    private final int g;

    public g(h hVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f807e = z;
        this.f = layoutInflater;
        this.f804b = hVar;
        this.g = i;
        a();
    }

    void a() {
        k f = this.f804b.f();
        if (f != null) {
            ArrayList<k> j = this.f804b.j();
            int size = j.size();
            for (int i = 0; i < size; i++) {
                if (j.get(i) == f) {
                    this.f805c = i;
                    return;
                }
            }
        }
        this.f805c = -1;
    }

    public void a(boolean z) {
        this.f806d = z;
    }

    public h b() {
        return this.f804b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<k> j = this.f807e ? this.f804b.j() : this.f804b.n();
        int i = this.f805c;
        int size = j.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public k getItem(int i) {
        ArrayList<k> j = this.f807e ? this.f804b.j() : this.f804b.n();
        int i2 = this.f805c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return j.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f.inflate(this.g, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f804b.o() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        q.a aVar = (q.a) view;
        if (this.f806d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
