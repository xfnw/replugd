package com.ecloud.eshare.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.PhotoItem;
import com.ecloud.eshare.d.e;
import com.ecloud.eshare.d.f;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.R;
import java.util.List;

/* loaded from: classes.dex */
public class g extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private Context f2768c;

    /* renamed from: d  reason: collision with root package name */
    private List<PhotoItem> f2769d;

    /* renamed from: e  reason: collision with root package name */
    private e f2770e;
    private f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        ImageView t;

        /* renamed from: com.ecloud.eshare.c.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnClickListenerC0075a implements View.OnClickListener {
            View$OnClickListenerC0075a(g gVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = g.this.f2770e;
                a aVar = a.this;
                eVar.a(g.this, aVar.i());
            }
        }

        /* loaded from: classes.dex */
        class b implements View.OnLongClickListener {
            b(g gVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f fVar = g.this.f;
                a aVar = a.this;
                fVar.b(g.this, aVar.i());
                return true;
            }
        }

        public a(View view) {
            super(view);
            if (g.this.f2770e != null) {
                view.setOnClickListener(new View$OnClickListenerC0075a(g.this));
            }
            if (g.this.f != null) {
                view.setOnLongClickListener(new b(g.this));
            }
            this.t = (ImageView) view.findViewById(R.id.iv_item_photo_grid);
        }
    }

    public g(Context context, List<PhotoItem> list) {
        this.f2768c = context;
        this.f2769d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2769d.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        Picasso.get().load(this.f2769d.get(i).getFile()).resize(320, 320).placeholder(R.drawable.ic_thumb_image).error(R.drawable.ic_thumb_image).centerCrop().onlyScaleDown().into(aVar.t);
    }

    public void a(e eVar) {
        this.f2770e = eVar;
    }

    public void a(f fVar) {
        this.f = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(View.inflate(this.f2768c, R.layout.item_photo_grid, null));
    }

    public PhotoItem d(int i) {
        if (i >= this.f2769d.size()) {
            return null;
        }
        return this.f2769d.get(i);
    }
}
