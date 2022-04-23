package com.ecloud.eshare.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.AudioItem;
import com.ecloud.eshare.d.e;
import com.ecloud.eshare.d.f;
import com.squareup.picasso.R;
import java.util.List;

/* loaded from: classes.dex */
public class b extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    private Context f2748c;

    /* renamed from: d  reason: collision with root package name */
    private List<AudioItem> f2749d;

    /* renamed from: e  reason: collision with root package name */
    private e f2750e;
    private f f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        RelativeLayout t;
        TextView u;

        /* renamed from: com.ecloud.eshare.c.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnClickListenerC0070a implements View.OnClickListener {
            View$OnClickListenerC0070a(b bVar) {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = b.this.f2750e;
                a aVar = a.this;
                eVar.a(b.this, aVar.i());
            }
        }

        /* renamed from: com.ecloud.eshare.c.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class View$OnLongClickListenerC0071b implements View.OnLongClickListener {
            View$OnLongClickListenerC0071b(b bVar) {
            }

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                f fVar = b.this.f;
                a aVar = a.this;
                fVar.b(b.this, aVar.i());
                return true;
            }
        }

        public a(View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.rl_item_audio);
            if (b.this.f2750e != null) {
                this.t.setOnClickListener(new View$OnClickListenerC0070a(b.this));
            }
            if (b.this.f != null) {
                view.setOnLongClickListener(new View$OnLongClickListenerC0071b(b.this));
            }
            this.u = (TextView) view.findViewById(R.id.tv_item_audio_name);
        }
    }

    public b(Context context, List<AudioItem> list, List<String> list2) {
        this.f2748c = context;
        this.f2749d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2749d.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        aVar.u.setText(this.f2749d.get(i).getTitle());
    }

    public void a(e eVar) {
        this.f2750e = eVar;
    }

    public void a(f fVar) {
        this.f = fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(View.inflate(this.f2748c, R.layout.item_audio, null));
    }

    public AudioItem d(int i) {
        if (i >= this.f2749d.size()) {
            return null;
        }
        return this.f2749d.get(i);
    }

    public List<AudioItem> d() {
        return this.f2749d;
    }
}
