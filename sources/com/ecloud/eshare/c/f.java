package com.ecloud.eshare.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.AlbumItem;
import com.ecloud.eshare.d.e;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.R;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class f extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private List<AlbumItem> f2763c;

    /* renamed from: d  reason: collision with root package name */
    private Context f2764d;

    /* renamed from: e  reason: collision with root package name */
    private e f2765e;
    private int f;
    private com.ecloud.eshare.d.f g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        RelativeLayout t;
        ImageView u;
        TextView v;

        /* renamed from: com.ecloud.eshare.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnClickListenerC0074a implements View.OnClickListener {
            View$OnClickListenerC0074a(f fVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = f.this.f2765e;
                a aVar = a.this;
                eVar.a(f.this, aVar.i());
            }
        }

        /* loaded from: classes.dex */
        class b implements View.OnLongClickListener {
            b(f fVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                com.ecloud.eshare.d.f fVar = f.this.g;
                a aVar = a.this;
                fVar.b(f.this, aVar.i());
                return true;
            }
        }

        public a(View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.rl_item_photo_list);
            if (f.this.f2765e != null) {
                this.t.setOnClickListener(new View$OnClickListenerC0074a(f.this));
            }
            if (f.this.g != null) {
                view.setOnLongClickListener(new b(f.this));
            }
            this.u = (ImageView) view.findViewById(R.id.iv_bg_album);
            this.v = (TextView) view.findViewById(R.id.tv_item_album_name);
        }
    }

    public f(Context context, List<AlbumItem> list) {
        this.f2764d = context;
        this.f2763c = list;
        this.f = this.f2764d.getResources().getDimensionPixelSize(R.dimen.size_120dp);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2763c.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        AlbumItem albumItem = this.f2763c.get(i);
        RequestCreator error = Picasso.get().load(new File(albumItem.getCoverUri())).placeholder(R.drawable.ic_thumb_image).error(R.drawable.ic_thumb_image);
        int i2 = this.f;
        error.resize(i2, i2).centerCrop().onlyScaleDown().into(aVar.u);
        aVar.v.setText(albumItem.getInfo());
    }

    public void a(e eVar) {
        this.f2765e = eVar;
    }

    public void a(com.ecloud.eshare.d.f fVar) {
        this.g = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(View.inflate(this.f2764d, R.layout.item_photo_list, null));
    }
}
