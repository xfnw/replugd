package com.ecloud.eshare.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.d.e;
import com.squareup.picasso.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private final List<b.b.a.k.a> f2753c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private e f2754d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        TextView t;
        TextView u;

        /* renamed from: com.ecloud.eshare.c.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnClickListenerC0072a implements View.OnClickListener {
            View$OnClickListenerC0072a(c cVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = c.this.f2754d;
                a aVar = a.this;
                eVar.a(c.this, aVar.i());
            }
        }

        a(View view) {
            super(view);
            if (c.this.f2754d != null) {
                view.setOnClickListener(new View$OnClickListenerC0072a(c.this));
            }
            this.t = (TextView) view.findViewById(R.id.tv_item_device_name);
            this.u = (TextView) view.findViewById(R.id.tv_item_device_info);
        }
    }

    public c(Context context) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2753c.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        b.b.a.k.a aVar2 = this.f2753c.get(i);
        aVar.t.setText(aVar2.b());
        aVar.u.setText(aVar2.a());
    }

    public void a(e eVar) {
        this.f2754d = eVar;
    }

    public void a(List<b.b.a.k.a> list) {
        this.f2753c.clear();
        this.f2753c.addAll(list);
        c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_device, viewGroup, false));
    }

    public b.b.a.k.a d(int i) {
        if (i >= this.f2753c.size()) {
            return null;
        }
        return this.f2753c.get(i);
    }
}
