package com.ecloud.eshare.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.d.e;
import com.ecloud.eshare.d.f;
import com.ecloud.eshare.f.b;
import com.squareup.picasso.R;
import java.util.List;

/* loaded from: classes.dex */
public class i extends RecyclerView.g<b> {

    /* renamed from: c  reason: collision with root package name */
    private Context f2778c;

    /* renamed from: d  reason: collision with root package name */
    private List<VideoItem> f2779d;

    /* renamed from: e  reason: collision with root package name */
    private e f2780e;
    private com.ecloud.eshare.f.b f;
    private f g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.AbstractC0081b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f2781a;

        a(i iVar, b bVar) {
            this.f2781a = bVar;
        }

        @Override // com.ecloud.eshare.f.b.AbstractC0081b
        public void a(Bitmap bitmap, String str) {
            if (str.equals(this.f2781a.u.getTag())) {
                this.f2781a.u.setImageBitmap(bitmap);
            }
        }

        @Override // com.ecloud.eshare.f.b.AbstractC0081b
        public void onError(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.d0 {
        CardView t;
        ImageView u;
        TextView v;

        /* loaded from: classes.dex */
        class a implements View.OnClickListener {
            a(i iVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = i.this.f2780e;
                b bVar = b.this;
                eVar.a(i.this, bVar.i());
            }
        }

        /* renamed from: com.ecloud.eshare.c.i$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnLongClickListenerC0077b implements View.OnLongClickListener {
            View$OnLongClickListenerC0077b(i iVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f fVar = i.this.g;
                b bVar = b.this;
                fVar.b(i.this, bVar.i());
                return true;
            }
        }

        public b(View view) {
            super(view);
            this.t = (CardView) view.findViewById(R.id.rl_item_video_grid);
            if (i.this.f2780e != null) {
                this.t.setOnClickListener(new a(i.this));
            }
            if (i.this.g != null) {
                view.setOnLongClickListener(new View$OnLongClickListenerC0077b(i.this));
            }
            this.u = (ImageView) view.findViewById(R.id.iv_item_video_grid_icon);
            this.v = (TextView) view.findViewById(R.id.tv_item_video_grid_duration);
        }
    }

    public i(Context context, List<VideoItem> list) {
        this.f2778c = context;
        this.f2779d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2779d.size();
    }

    /* renamed from: a */
    public void b(b bVar, int i) {
        VideoItem videoItem = this.f2779d.get(i);
        bVar.u.setTag(videoItem.getPathName());
        bVar.u.setImageResource(R.drawable.ic_thumb_video);
        this.f.a(videoItem, new a(this, bVar));
        bVar.v.setText(videoItem.getDuration());
    }

    public void a(e eVar) {
        this.f2780e = eVar;
    }

    public void a(f fVar) {
        this.g = fVar;
    }

    public void a(com.ecloud.eshare.f.b bVar) {
        this.f = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public b b(ViewGroup viewGroup, int i) {
        return new b(View.inflate(this.f2778c, R.layout.item_video_grid, null));
    }

    public VideoItem d(int i) {
        if (i >= this.f2779d.size()) {
            return null;
        }
        return this.f2779d.get(i);
    }

    public List<VideoItem> d() {
        return this.f2779d;
    }
}
