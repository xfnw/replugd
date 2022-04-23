package com.ecloud.eshare.c;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.AppItem;
import com.ecloud.eshare.d.e;
import com.ecloud.eshare.d.f;
import com.squareup.picasso.R;
import java.util.List;

/* loaded from: classes.dex */
public class h extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private Context f2773c;

    /* renamed from: d  reason: collision with root package name */
    private List<AppItem> f2774d;

    /* renamed from: e  reason: collision with root package name */
    private e f2775e;
    private f f;
    Boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        ImageView t;
        TextView u;

        /* renamed from: com.ecloud.eshare.c.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnClickListenerC0076a implements View.OnClickListener {
            View$OnClickListenerC0076a(h hVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = h.this.f2775e;
                a aVar = a.this;
                eVar.a(h.this, aVar.i());
            }
        }

        /* loaded from: classes.dex */
        class b implements View.OnLongClickListener {
            b(h hVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f fVar = h.this.f;
                a aVar = a.this;
                fVar.b(h.this, aVar.i());
                return true;
            }
        }

        public a(View view) {
            super(view);
            if (h.this.f2775e != null) {
                view.setOnClickListener(new View$OnClickListenerC0076a(h.this));
            }
            if (h.this.f != null) {
                view.setOnLongClickListener(new b(h.this));
            }
            this.t = (ImageView) view.findViewById(R.id.iv_item_program);
            this.u = (TextView) view.findViewById(R.id.tv_item_program);
            if (!h.this.g.booleanValue()) {
                this.u.setTextColor(h.this.f2773c.getResources().getColor(R.color.c_666666));
            } else {
                this.u.setTextColor(-1);
            }
        }
    }

    public h(Context context, List<AppItem> list, boolean z) {
        this.g = false;
        this.f2773c = context;
        this.f2774d = list;
        this.g = Boolean.valueOf(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2774d.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        AppItem appItem = this.f2774d.get(i);
        aVar.t.setImageBitmap(BitmapFactory.decodeByteArray(appItem.getAppIcon(), 0, appItem.getAppIcon().length));
        aVar.u.setText(appItem.getAppName());
    }

    public void a(e eVar) {
        this.f2775e = eVar;
    }

    public void a(f fVar) {
        this.f = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(View.inflate(this.f2773c, R.layout.item_program, null));
    }

    public AppItem d(int i) {
        if (i >= this.f2774d.size()) {
            return null;
        }
        return this.f2774d.get(i);
    }
}
