package com.ecloud.eshare.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.bean.ClientInfo;
import com.squareup.picasso.R;
import java.util.List;

/* loaded from: classes.dex */
public class e extends RecyclerView.g<a> {

    /* renamed from: c  reason: collision with root package name */
    public List<ClientInfo> f2761c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f2762d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.d0 {
        ImageView t;
        ImageView u;
        ImageView v;
        ImageView w;
        ImageView x;
        ImageView y;
        TextView z;

        public a(e eVar, View view) {
            super(view);
            this.t = (ImageView) view.findViewById(R.id.iv_item_peer_device_type);
            this.z = (TextView) view.findViewById(R.id.tv_item_peer_device_name);
            this.u = (ImageView) view.findViewById(R.id.iv_item_peer_device_host);
            this.v = (ImageView) view.findViewById(R.id.iv_item_peer_device_fullscreen);
            this.w = (ImageView) view.findViewById(R.id.iv_item_peer_device_cast);
            this.x = (ImageView) view.findViewById(R.id.iv_item_peer_device_allow);
            this.y = (ImageView) view.findViewById(R.id.iv_item_peer_device_deny);
            this.w.setTag(this);
            this.v.setTag(this);
            this.u.setTag(this);
            this.x.setTag(this);
            this.y.setTag(this);
            this.x.setOnClickListener(eVar.f2762d);
            this.y.setOnClickListener(eVar.f2762d);
            this.u.setOnClickListener(eVar.f2762d);
            this.v.setOnClickListener(eVar.f2762d);
            this.w.setOnClickListener(eVar.f2762d);
        }
    }

    public e(List<ClientInfo> list, View.OnClickListener onClickListener) {
        this.f2761c = list;
        this.f2762d = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        return this.f2761c.size();
    }

    /* renamed from: a */
    public void b(a aVar, int i) {
        int i2;
        ImageView imageView;
        int i3;
        ImageView imageView2;
        ImageView imageView3;
        int i4;
        ClientInfo clientInfo = this.f2761c.get(i);
        int i5 = clientInfo.device_os;
        if (i5 == 5 || i5 == 0) {
            imageView = aVar.t;
            i2 = R.drawable.ic_laptop;
        } else {
            imageView = aVar.t;
            i2 = R.drawable.ic_mobile;
        }
        imageView.setBackgroundResource(i2);
        aVar.z.setText(clientInfo.ClientModel);
        if (clientInfo.getRequestCasting() == 1) {
            aVar.u.setVisibility(8);
            aVar.v.setVisibility(8);
            aVar.w.setVisibility(8);
            aVar.x.setVisibility(0);
            aVar.y.setVisibility(0);
            return;
        }
        aVar.x.setVisibility(8);
        aVar.y.setVisibility(8);
        aVar.w.setVisibility(0);
        aVar.v.setVisibility(0);
        aVar.u.setVisibility(0);
        if (clientInfo.getMastercontrol() == 1) {
            imageView2 = aVar.u;
            i3 = R.drawable.ic_host_enabled_selected;
        } else {
            imageView2 = aVar.u;
            i3 = R.drawable.ic_host_enabled_normal;
        }
        imageView2.setBackgroundResource(i3);
        if (clientInfo.getScreening() == 1) {
            aVar.w.setSelected(true);
        } else {
            aVar.w.setSelected(false);
        }
        if (clientInfo.getFullScreen() == 1) {
            imageView3 = aVar.v;
            i4 = R.drawable.ic_full_02_selected;
        } else if (clientInfo.getFullScreen() == 0) {
            imageView3 = aVar.v;
            i4 = R.drawable.ic_full_01_normal;
        } else if (clientInfo.getFullScreen() == -1) {
            imageView3 = aVar.v;
            i4 = R.drawable.ic_full_disabled;
        } else {
            return;
        }
        imageView3.setBackgroundResource(i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public a b(ViewGroup viewGroup, int i) {
        return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_peer_device, viewGroup, false));
    }
}
