package com.ecloud.eshare.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.AlbumItem;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.bean.PhotoItem;
import com.ecloud.eshare.c.g;
import com.ecloud.eshare.d.f;
import com.ecloud.eshare.model.b;
import com.ecloud.eshare.util.i;
import com.squareup.picasso.R;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class PhotoActivity extends com.ecloud.eshare.activity.a implements b.g, com.ecloud.eshare.d.e, AdapterView.OnItemLongClickListener, f, b.h {
    public static PhotoActivity X;
    public List<PhotoItem> H;
    public List<PhotoItem> I;
    private Boolean J = true;
    private TextView K;
    private RecyclerView L;
    private ListView M;
    private LinearLayout N;
    private LinearLayout O;
    private g P;
    private com.ecloud.eshare.c.a Q;
    private b.b.a.c R;
    private com.ecloud.eshare.model.b S;
    private RecyclerView T;
    private LinearLayout U;
    private LinearLayout V;
    private ImageView W;

    /* loaded from: classes.dex */
    class a implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f2653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2654b;

        a(RecyclerView.g gVar, int i) {
            this.f2653a = gVar;
            this.f2654b = i;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            if (this.f2653a == PhotoActivity.this.P && PhotoActivity.this.P.d(this.f2654b) != null) {
                Intent intent = new Intent(PhotoActivity.this, ImageActivity.class);
                intent.putExtra("com.eshare.optoma.extra.PHOTO_INDEX", this.f2654b);
                PhotoActivity.this.startActivity(intent);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f2656a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2657b;

        b(RecyclerView.g gVar, int i) {
            this.f2656a = gVar;
            this.f2657b = i;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            PhotoItem d2;
            if (this.f2656a == PhotoActivity.this.P && (d2 = PhotoActivity.this.P.d(this.f2657b)) != null) {
                PhotoActivity.this.a(d2.getFile());
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PhotoActivity.this.V.setVisibility(8);
            PhotoActivity.this.K.setVisibility(0);
            PhotoActivity.this.b(false);
            AlbumItem item = PhotoActivity.this.Q.getItem(i);
            PhotoActivity.this.Q.a(i);
            PhotoActivity.this.a(item);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements FileFilter {
        d(PhotoActivity photoActivity) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return i.c(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements FileFilter {
        e(PhotoActivity photoActivity) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return i.c(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlbumItem albumItem) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = albumItem.getFile().listFiles(new e(this));
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file : listFiles) {
                PhotoItem photoItem = new PhotoItem(file);
                photoItem.parseDate(this);
                arrayList.add(photoItem);
            }
        }
        Collections.sort(arrayList, new com.ecloud.eshare.i.e());
        f(arrayList);
        this.H.clear();
        this.H.addAll(arrayList);
        this.L.setLayoutManager(new GridLayoutManager(this, 3));
        this.L.setAdapter(this.P);
        if (this.K.isSelected()) {
            this.K.setText(albumItem.getInfo());
        } else {
            this.K.setText(R.string.main_item_photo);
        }
        this.Q.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.O.setVisibility(0);
            this.K.setText(R.string.main_item_photo);
            this.K.setSelected(false);
            this.N.setVisibility(8);
            return;
        }
        this.N.setVisibility(0);
        this.K.setSelected(true);
    }

    private void e(List<AlbumItem> list) {
        for (AlbumItem albumItem : list) {
            File[] listFiles = albumItem.getFile().listFiles(new d(this));
            if (listFiles != null) {
                albumItem.setPhotoCount(listFiles.length);
            }
        }
    }

    private void f(List<PhotoItem> list) {
        String str = null;
        for (int i = 0; i < list.size(); i++) {
            PhotoItem photoItem = list.get(i);
            String date = photoItem.getDate();
            if (!date.equals(str)) {
                photoItem.setFirst(true);
                photoItem.setIndex(1);
                str = date;
            } else {
                PhotoItem photoItem2 = list.get(i - 1);
                photoItem2.setLast(false);
                photoItem.setIndex(photoItem2.getIndex() + 1);
            }
        }
    }

    private void v() {
        ObjectAnimator.ofFloat(this.O, "translationY", 0.0f, -3000.0f).setDuration(800L).start();
        this.J = true;
        this.H.clear();
        this.H.addAll(this.I);
        this.P.c();
        this.W.setRotation(0.0f);
    }

    public static PhotoActivity w() {
        return X;
    }

    private void x() {
        ObjectAnimator.ofFloat(this.O, "translationY", -3000.0f, 0.0f).setDuration(800L).start();
        this.J = false;
        this.W.setRotation(180.0f);
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i) {
        if (!this.R.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else {
            a(1, new a(gVar, i));
        }
    }

    @Override // com.ecloud.eshare.model.b.g
    public void a(List<AlbumItem> list) {
        this.Q = new com.ecloud.eshare.c.a(this, list);
        this.M.setAdapter((ListAdapter) this.Q);
        e(list);
        this.M.setOnItemClickListener(new c());
    }

    @Override // com.ecloud.eshare.d.f
    public void b(RecyclerView.g gVar, int i) {
        a(1, new b(gVar, i));
    }

    @Override // com.ecloud.eshare.model.b.h
    public void c(List<PhotoItem> list) {
        Collections.sort(list, new com.ecloud.eshare.i.e());
        this.I.clear();
        this.I.addAll(list);
        this.H.clear();
        this.H.addAll(list);
        this.P.c();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() == EventCollections.FinishActivityEvent.FINISH_DEFAULT) {
            finish();
        }
    }

    @Override // a.k.a.d, android.app.Activity
    public void onBackPressed() {
        if (this.N.getVisibility() == 0) {
            b(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.iv_photo_back) {
            if (id == R.id.ll_choose_photo) {
                if (this.J.booleanValue()) {
                    x();
                    return;
                }
            } else {
                return;
            }
        } else if (this.N.getVisibility() == 0) {
            this.N.setVisibility(8);
            this.V.setVisibility(0);
            this.K.setVisibility(8);
            return;
        } else if (this.J.booleanValue()) {
            if (this.U.getVisibility() == 0 && this.J.booleanValue()) {
                finish();
                return;
            }
            return;
        }
        v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        X = this;
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AlbumItem item = this.Q.getItem(i);
        if (item == null) {
            return true;
        }
        a(item.getFile());
        return true;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.K = (TextView) findViewById(R.id.tv_photo_title);
        this.L = (RecyclerView) findViewById(R.id.rv_photo_grid);
        this.M = (ListView) findViewById(R.id.lv_photo_album);
        this.M.setOnItemLongClickListener(this);
        this.N = (LinearLayout) findViewById(R.id.ll_photo_grid);
        this.O = (LinearLayout) findViewById(R.id.ll_photo_album);
        this.V = (LinearLayout) findViewById(R.id.ll_choose_photo);
        this.V.setOnClickListener(this);
        this.O.setTranslationY(-3000.0f);
        this.W = (ImageView) findViewById(R.id.iv_spin);
        this.U = (LinearLayout) findViewById(R.id.ll_all_photo);
        findViewById(R.id.iv_photo_back).setOnClickListener(this);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_photo;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.S = com.ecloud.eshare.model.b.c();
        this.S.a((b.g) this);
        this.S.c(this);
        this.S.a((b.h) this);
        this.S.f(this);
        this.R = b.b.a.a.a(this).b();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.P = new g(this, this.H);
        this.P.a((com.ecloud.eshare.d.e) this);
        this.P.a((f) this);
        this.T = (RecyclerView) findViewById(R.id.rv_all_photo_grid);
        this.T.setLayoutManager(new GridLayoutManager(this, 4));
        this.T.setAdapter(this.P);
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        this.K.setOnClickListener(this);
        this.O.setOnClickListener(this);
    }
}
