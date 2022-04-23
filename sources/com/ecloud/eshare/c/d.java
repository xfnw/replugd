package com.ecloud.eshare.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.DocumentItem;
import com.ecloud.eshare.d.e;
import com.ecloud.eshare.d.f;
import com.squareup.picasso.R;
import java.util.List;

/* loaded from: classes.dex */
public class d extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private Context f2756c;

    /* renamed from: d  reason: collision with root package name */
    private List<DocumentItem> f2757d;

    /* renamed from: e  reason: collision with root package name */
    private e f2758e;
    private f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        RelativeLayout t;
        ImageView u;
        TextView v;
        TextView w;

        /* renamed from: com.ecloud.eshare.c.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnClickListenerC0073a implements View.OnClickListener {
            View$OnClickListenerC0073a(d dVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = d.this.f2758e;
                a aVar = a.this;
                eVar.a(d.this, aVar.i());
            }
        }

        /* loaded from: classes.dex */
        class b implements View.OnLongClickListener {
            b(d dVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f fVar = d.this.f;
                a aVar = a.this;
                fVar.b(d.this, aVar.i());
                return true;
            }
        }

        public a(View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.rl_item_document);
            if (d.this.f2758e != null) {
                this.t.setOnClickListener(new View$OnClickListenerC0073a(d.this));
            }
            if (d.this.f != null) {
                view.setOnLongClickListener(new b(d.this));
            }
            this.u = (ImageView) view.findViewById(R.id.iv_item_document_icon);
            this.v = (TextView) view.findViewById(R.id.tv_item_document_name);
            this.w = (TextView) view.findViewById(R.id.tv_item_document_size);
        }
    }

    public d(Context context, List<DocumentItem> list) {
        this.f2756c = context;
        float f = context.getResources().getDisplayMetrics().density;
        this.f2757d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2757d.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        DocumentItem documentItem = this.f2757d.get(i);
        aVar.u.setImageResource(documentItem.getResId());
        aVar.v.setText(documentItem.getTitle());
        if (!documentItem.isDir()) {
            aVar.w.setText(documentItem.getSize(this.f2756c));
        }
    }

    public void a(e eVar) {
        this.f2758e = eVar;
    }

    public void a(f fVar) {
        this.f = fVar;
    }

    public void a(List<DocumentItem> list) {
        this.f2757d.addAll(list);
        c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(View.inflate(this.f2756c, R.layout.item_document, null));
    }

    public DocumentItem d(int i) {
        if (i >= this.f2757d.size()) {
            return null;
        }
        return this.f2757d.get(i);
    }

    public void d() {
        this.f2757d.clear();
        c();
    }
}
