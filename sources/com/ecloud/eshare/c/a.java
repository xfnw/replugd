package com.ecloud.eshare.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ecloud.eshare.bean.AlbumItem;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.R;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    private Context f2744b;

    /* renamed from: c  reason: collision with root package name */
    private List<AlbumItem> f2745c;

    /* renamed from: d  reason: collision with root package name */
    private int f2746d;

    /* renamed from: e  reason: collision with root package name */
    private int f2747e;
    ImageView f;
    TextView g;
    ImageView h;

    public a(Context context, List<AlbumItem> list) {
        this.f2744b = context;
        this.f2745c = list;
        this.f2747e = this.f2744b.getResources().getDimensionPixelSize(R.dimen.size_50dp);
    }

    public void a(int i) {
        this.f2746d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2745c.size();
    }

    @Override // android.widget.Adapter
    public AlbumItem getItem(int i) {
        return this.f2745c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AlbumItem albumItem = this.f2745c.get(i);
        View inflate = View.inflate(this.f2744b, R.layout.item_album, null);
        this.f = (ImageView) inflate.findViewById(R.id.iv_photo_cover);
        this.g = (TextView) inflate.findViewById(R.id.tv_item_album_name);
        this.h = (ImageView) inflate.findViewById(R.id.iv_item_album_select);
        RequestCreator error = Picasso.get().load(new File(albumItem.getCoverUri())).placeholder(R.drawable.ic_thumb_image).error(R.drawable.ic_thumb_image);
        int i2 = this.f2747e;
        error.resize(i2, i2).centerCrop().onlyScaleDown().into(this.f);
        this.g.setText(albumItem.getInfo());
        this.h.setSelected(this.f2746d == i);
        return inflate;
    }
}
