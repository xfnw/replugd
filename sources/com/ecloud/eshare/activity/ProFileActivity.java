package com.ecloud.eshare.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.AlbumItem;
import com.ecloud.eshare.bean.AppItem;
import com.ecloud.eshare.bean.AudioItem;
import com.ecloud.eshare.bean.DocumentItem;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.bean.FileItem;
import com.ecloud.eshare.bean.PhotoItem;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.e.a;
import com.ecloud.eshare.model.NpaGridLayoutManager;
import com.ecloud.eshare.model.a;
import com.ecloud.eshare.model.b;
import com.ecloud.eshare.service.MediaService;
import com.ecloud.eshare.util.p;
import com.squareup.picasso.R;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class ProFileActivity extends com.ecloud.eshare.activity.a implements a.d, com.ecloud.eshare.d.e, b.k, MediaService.e, b.g, b.i, com.ecloud.eshare.d.f {
    private RecyclerView H;
    private RecyclerView I;
    private RecyclerView J;
    private RecyclerView K;
    private RecyclerView L;
    private com.ecloud.eshare.model.a M;
    private com.ecloud.eshare.c.h N;
    private b.b.a.c O;
    private ExecutorService P;
    private TextView Q;
    private ProgressBar R;
    private com.ecloud.eshare.c.b U;
    private int V;
    private com.ecloud.eshare.f.b W;
    private MediaService X;
    private int Y;
    private RecyclerView Z;
    private com.ecloud.eshare.c.i a0;
    private TextView b0;
    private TextView c0;
    private b.b.a.g d0;
    private com.ecloud.eshare.c.f e0;
    private List<PhotoItem> f0;
    private com.ecloud.eshare.c.g g0;
    private com.ecloud.eshare.e.a h0;
    private com.ecloud.eshare.c.d i0;
    private TextView j0;
    private TextView k0;
    private com.ecloud.eshare.model.b l0;
    private ProgressBar n0;
    private boolean S = false;
    private boolean T = false;
    private ServiceConnection m0 = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements FileFilter {
        a(ProFileActivity proFileActivity) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return com.ecloud.eshare.util.i.c(file);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements FileFilter {
        b(ProFileActivity proFileActivity) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return com.ecloud.eshare.util.i.c(file);
        }
    }

    /* loaded from: classes.dex */
    class c implements ServiceConnection {
        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ProFileActivity.this.X = ((MediaService.f) iBinder).a();
            ProFileActivity.this.X.a(ProFileActivity.this);
            ProFileActivity proFileActivity = ProFileActivity.this;
            proFileActivity.a(proFileActivity.X.a());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ProFileActivity.this.X = null;
        }
    }

    /* loaded from: classes.dex */
    class d implements a.e {
        d() {
        }

        @Override // com.ecloud.eshare.e.a.e
        public void a() {
            ProFileActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class e implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2680a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f2681b;

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ VideoItem f2683b;

            a(VideoItem videoItem) {
                this.f2683b = videoItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ProFileActivity.this.d0.b(this.f2683b.getFile())) {
                    ProFileActivity.this.finish();
                }
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AudioItem f2685b;

            b(AudioItem audioItem) {
                this.f2685b = audioItem;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ProFileActivity.this.d0.b(this.f2685b.getFile())) {
                    ProFileActivity.this.finish();
                }
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ProFileActivity.this.O.i(ProFileActivity.this.N.d(e.this.f2680a).getPackageName());
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.clear();
                for (PhotoItem photoItem : ProFileActivity.this.f0) {
                    if (!arrayList2.contains(photoItem.getFile())) {
                        arrayList2.add(photoItem.getFile());
                    }
                }
                String parent = ((File) arrayList2.get(0)).getParent();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((File) it.next()).getName());
                }
                ProFileActivity.this.d0.a(parent, arrayList, e.this.f2680a);
                ProFileActivity.this.finish();
            }
        }

        e(int i, RecyclerView.g gVar) {
            this.f2680a = i;
            this.f2681b = gVar;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            DocumentItem d2;
            ExecutorService executorService;
            Runnable dVar;
            ExecutorService executorService2;
            Runnable bVar;
            if (ProFileActivity.this.X != null) {
                ProFileActivity.this.X.a((File) null, true);
                ProFileActivity.this.X.a(this.f2680a);
            }
            if (this.f2681b == ProFileActivity.this.a0) {
                VideoItem d3 = ProFileActivity.this.a0.d(this.f2680a);
                if (d3 != null && ProFileActivity.this.X != null) {
                    ProFileActivity.this.a0.d();
                    executorService2 = ProFileActivity.this.P;
                    bVar = new a(d3);
                } else {
                    return;
                }
            } else if (this.f2681b == ProFileActivity.this.U) {
                AudioItem d4 = ProFileActivity.this.U.d(this.f2680a);
                if (d4 != null && ProFileActivity.this.X != null) {
                    ProFileActivity.this.U.d();
                    executorService2 = ProFileActivity.this.P;
                    bVar = new b(d4);
                } else {
                    return;
                }
            } else {
                if (this.f2681b == ProFileActivity.this.N) {
                    executorService = ProFileActivity.this.P;
                    dVar = new c();
                } else if (this.f2681b == ProFileActivity.this.g0) {
                    if (ProFileActivity.this.g0.d(this.f2680a) != null) {
                        executorService = ProFileActivity.this.P;
                        dVar = new d();
                    } else {
                        return;
                    }
                } else if (this.f2681b == ProFileActivity.this.i0 && (d2 = ProFileActivity.this.i0.d(this.f2680a)) != null && ProFileActivity.this.d0.b(d2.getFile())) {
                    ProFileActivity.this.finish();
                    return;
                } else {
                    return;
                }
                executorService.execute(dVar);
                return;
            }
            executorService2.execute(bVar);
        }
    }

    /* loaded from: classes.dex */
    class f implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2689a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f2690b;

        f(int i, RecyclerView.g gVar) {
            this.f2689a = i;
            this.f2690b = gVar;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            FileItem d2;
            if (ProFileActivity.this.X != null) {
                ProFileActivity.this.X.a((File) null, true);
                ProFileActivity.this.X.a(this.f2689a);
            }
            if (this.f2690b == ProFileActivity.this.a0) {
                d2 = ProFileActivity.this.a0.d(this.f2689a);
                if (d2 == null) {
                    return;
                }
            } else if (this.f2690b == ProFileActivity.this.U) {
                d2 = ProFileActivity.this.U.d(this.f2689a);
                if (d2 == null) {
                    return;
                }
            } else if (this.f2690b == ProFileActivity.this.g0) {
                d2 = ProFileActivity.this.g0.d(this.f2689a);
                if (d2 == null) {
                    return;
                }
            } else if (this.f2690b != ProFileActivity.this.i0 || (d2 = ProFileActivity.this.i0.d(this.f2689a)) == null) {
                return;
            }
            ProFileActivity.this.a(d2.getFile());
        }
    }

    /* loaded from: classes.dex */
    class g extends GridLayoutManager.c {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NpaGridLayoutManager f2692c;

        g(NpaGridLayoutManager npaGridLayoutManager) {
            this.f2692c = npaGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int b(int i) {
            if (ProFileActivity.this.a0.b(i) == 1) {
                return this.f2692c.K();
            }
            return 1;
        }
    }

    /* loaded from: classes.dex */
    class h extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NpaGridLayoutManager f2694a;

        h(NpaGridLayoutManager npaGridLayoutManager) {
            this.f2694a = npaGridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i, int i2) {
            int F = this.f2694a.F();
            if (F != ProFileActivity.this.V) {
                ProFileActivity.this.V = F;
            }
        }
    }

    /* loaded from: classes.dex */
    class i implements com.ecloud.eshare.d.e {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2696b;

        i(List list) {
            this.f2696b = list;
        }

        @Override // com.ecloud.eshare.d.e
        public void a(RecyclerView.g gVar, int i) {
            ProFileActivity.this.b(false);
            ProFileActivity.this.a((AlbumItem) this.f2696b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlbumItem albumItem) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = albumItem.getFile().listFiles(new b(this));
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file : listFiles) {
                PhotoItem photoItem = new PhotoItem(file);
                photoItem.parseDate(this);
                arrayList.add(photoItem);
            }
        }
        Collections.sort(arrayList, new com.ecloud.eshare.i.e());
        f(arrayList);
        this.f0.clear();
        this.f0.addAll(arrayList);
        this.g0.c();
        this.e0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.K.setVisibility(0);
            this.Z.setVisibility(8);
            return;
        }
        this.K.setVisibility(8);
        this.Z.setVisibility(0);
    }

    private void e(List<AlbumItem> list) {
        for (AlbumItem albumItem : list) {
            File[] listFiles = albumItem.getFile().listFiles(new a(this));
            if (listFiles != null) {
                albumItem.setPhotoCount(listFiles.length);
            }
        }
    }

    private void f(List<PhotoItem> list) {
        String str = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            PhotoItem photoItem = list.get(i2);
            String date = photoItem.getDate();
            if (!date.equals(str)) {
                photoItem.setFirst(true);
                photoItem.setIndex(1);
                str = date;
            } else {
                PhotoItem photoItem2 = list.get(i2 - 1);
                photoItem2.setLast(false);
                photoItem.setIndex(photoItem2.getIndex() + 1);
            }
        }
    }

    private void v() {
        if (!this.S) {
            this.R.setVisibility(0);
        }
        this.M.a((Context) this);
    }

    private void w() {
        this.L.setVisibility(8);
        this.Z.setVisibility(8);
        this.I.setVisibility(8);
        this.H.setVisibility(8);
        this.J.setVisibility(8);
        this.K.setVisibility(8);
        this.Q.setAlpha(0.6f);
        this.c0.setAlpha(0.6f);
        this.b0.setAlpha(0.6f);
        this.j0.setAlpha(0.6f);
        this.k0.setAlpha(0.6f);
        this.Q.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.k0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.c0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.b0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        this.j0.setTextSize(getResources().getDimension(R.dimen.size_16px));
        if (this.Y == 2) {
            this.b0.setAlpha(1.0f);
            this.b0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.I.setVisibility(0);
        }
        if (this.Y == 3) {
            this.c0.setAlpha(1.0f);
            this.c0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.J.setVisibility(0);
        }
        if (this.Y == 5) {
            this.Q.setAlpha(1.0f);
            this.Q.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.H.setVisibility(0);
        }
        if (this.Y == 1) {
            this.j0.setAlpha(1.0f);
            this.j0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            b(true);
        }
        if (this.Y == 4) {
            this.k0.setAlpha(1.0f);
            this.k0.setTextSize(getResources().getDimension(R.dimen.size_20px));
            this.L.setVisibility(0);
        }
        if (this.Y != 5 && this.R.getVisibility() == 0) {
            this.R.setVisibility(8);
        }
        if (this.Y != 4) {
            this.n0.setVisibility(8);
        }
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i2) {
        if (!this.O.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else {
            a(gVar == this.U ? 2 : gVar == this.a0 ? 3 : 1, new e(i2, gVar));
        }
    }

    @Override // com.ecloud.eshare.service.MediaService.e
    public void a(FileItem fileItem) {
    }

    @Override // com.ecloud.eshare.model.b.g
    public void a(List<AlbumItem> list) {
        this.e0 = new com.ecloud.eshare.c.f(this, list);
        this.K.setAdapter(this.e0);
        this.K.setLayoutManager(new GridLayoutManager(this, 2));
        e(list);
        Iterator<AlbumItem> it = list.iterator();
        while (it.hasNext() && !it.next().isCamera()) {
        }
        this.e0.a(new i(list));
        this.e0.a((com.ecloud.eshare.d.f) this);
    }

    @Override // com.ecloud.eshare.model.b.k
    public void a(List<AudioItem> list, List<String> list2) {
        this.U = new com.ecloud.eshare.c.b(this, list, list2);
        this.U.a((com.ecloud.eshare.d.e) this);
        this.U.a((com.ecloud.eshare.d.f) this);
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(this, 1);
        this.I.setLayoutManager(npaGridLayoutManager);
        this.I.setAdapter(this.U);
        this.U.c();
        this.I.a(new h(npaGridLayoutManager));
    }

    @Override // com.ecloud.eshare.model.a.d
    public void a(boolean z, List<AppItem> list) {
        if (z) {
            this.S = true;
            if (this.R.getVisibility() == 0) {
                this.R.setVisibility(8);
            }
            this.N = new com.ecloud.eshare.c.h(this, list, false);
            this.N.a((com.ecloud.eshare.d.e) this);
            this.N.a((com.ecloud.eshare.d.f) this);
            this.H.setLayoutManager(new GridLayoutManager(this, 3));
            this.H.setAdapter(this.N);
            return;
        }
        CustomApplication.a((int) R.string.program_list_failed);
    }

    @Override // com.ecloud.eshare.d.f
    public void b(RecyclerView.g gVar, int i2) {
        if (!this.O.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else {
            a(gVar == this.U ? 2 : 3, new f(i2, gVar));
        }
    }

    @Override // com.ecloud.eshare.model.b.i
    public void b(List<DocumentItem> list) {
        this.T = true;
        if (this.n0.getVisibility() == 0) {
            this.n0.setVisibility(8);
        }
        this.i0 = new com.ecloud.eshare.c.d(this, list);
        this.L.setLayoutManager(new NpaGridLayoutManager(this, 1));
        this.L.setAdapter(this.i0);
        this.i0.a((com.ecloud.eshare.d.e) this);
        this.i0.a((com.ecloud.eshare.d.f) this);
    }

    @Override // com.ecloud.eshare.model.b.k
    public void d(List<VideoItem> list) {
        this.a0 = new com.ecloud.eshare.c.i(this, list);
        this.a0.a(this.W);
        this.a0.a((com.ecloud.eshare.d.e) this);
        this.a0.a((com.ecloud.eshare.d.f) this);
        NpaGridLayoutManager npaGridLayoutManager = new NpaGridLayoutManager(this, 3);
        npaGridLayoutManager.a(new g(npaGridLayoutManager));
        this.J.setLayoutManager(npaGridLayoutManager);
        this.J.setAdapter(this.a0);
        this.a0.c();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_CAST) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        switch (view.getId()) {
            case R.id.tv_file_apk /* 2131231200 */:
                if (this.Y != 5) {
                    this.Y = 5;
                    v();
                    break;
                }
                break;
            case R.id.tv_file_audio /* 2131231201 */:
                i2 = 2;
                if (this.Y != 2) {
                    this.l0.a((Context) this);
                    this.Y = i2;
                    break;
                }
                break;
            case R.id.tv_file_document /* 2131231202 */:
                if (this.Y != 4) {
                    this.l0.d(this);
                    this.Y = 4;
                    if (!this.T) {
                        this.n0.setVisibility(0);
                        break;
                    }
                }
                break;
            case R.id.tv_file_photo /* 2131231203 */:
                this.Y = 1;
                break;
            case R.id.tv_file_video /* 2131231204 */:
                i2 = 3;
                if (this.Y != 3) {
                    this.l0.b(this);
                    this.Y = i2;
                    break;
                }
                break;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.X.c();
        unbindService(this.m0);
        this.W.a();
        this.P.shutdown();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.K = (RecyclerView) findViewById(R.id.rv_photo_album);
        this.Z = (RecyclerView) findViewById(R.id.rv_photo_grid);
        this.H = (RecyclerView) findViewById(R.id.rv_program_apk);
        this.Q = (TextView) findViewById(R.id.tv_file_apk);
        this.Q.setOnClickListener(this);
        this.R = (ProgressBar) findViewById(R.id.pb_tools_loading);
        this.I = (RecyclerView) findViewById(R.id.rv_media_audio);
        this.J = (RecyclerView) findViewById(R.id.rv_media_video_grid);
        this.b0 = (TextView) findViewById(R.id.tv_file_audio);
        this.b0.setOnClickListener(this);
        this.c0 = (TextView) findViewById(R.id.tv_file_video);
        this.c0.setOnClickListener(this);
        this.j0 = (TextView) findViewById(R.id.tv_file_photo);
        this.j0.setOnClickListener(this);
        this.L = (RecyclerView) findViewById(R.id.rv_documents);
        this.k0 = (TextView) findViewById(R.id.tv_file_document);
        this.k0.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ll_folder);
        this.n0 = (ProgressBar) findViewById(R.id.pb_doc_loading);
        onClick(this.j0);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_pro_file;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        getIntent().getIntExtra("ROTATION", 0);
        this.W = new com.ecloud.eshare.f.b();
        this.l0 = com.ecloud.eshare.model.b.c();
        this.l0.a((b.i) this);
        this.l0.a((b.g) this);
        this.l0.c(this);
        this.l0.a((b.k) this);
        bindService(new Intent(this, MediaService.class), this.m0, 1);
        p.c(getWindow());
        this.O = b.b.a.a.a(this).b();
        this.d0 = b.b.a.a.a(this).e();
        this.P = Executors.newSingleThreadExecutor();
        this.M = com.ecloud.eshare.model.a.a();
        this.M.a((a.d) this);
        this.f0 = new ArrayList();
        this.g0 = new com.ecloud.eshare.c.g(this, this.f0);
        this.g0.a((com.ecloud.eshare.d.e) this);
        this.g0.a((com.ecloud.eshare.d.f) this);
        this.h0 = new com.ecloud.eshare.e.a(this, this.P);
        this.h0.a(new d());
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        this.K.a(new com.ecloud.eshare.view.b(getResources().getDimensionPixelOffset(R.dimen.size_1dp)));
        this.Z.setLayoutManager(new NpaGridLayoutManager(this, 3));
        this.Z.setAdapter(this.g0);
    }
}
