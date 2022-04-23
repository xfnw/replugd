package com.ecloud.eshare.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.AudioItem;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.bean.FileItem;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.c.i;
import com.ecloud.eshare.model.b;
import com.ecloud.eshare.service.MediaService;
import com.squareup.picasso.R;
import java.io.File;
import java.util.List;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class MediaActivity extends com.ecloud.eshare.activity.a implements com.ecloud.eshare.d.e, b.k, MediaService.e, com.ecloud.eshare.d.f {
    public static MediaActivity X;
    private TextView H;
    private TextView I;
    private TextView J;
    private RecyclerView K;
    private RecyclerView L;
    private TextView M;
    private ViewPager N;
    private i O;
    private com.ecloud.eshare.c.b P;
    private com.ecloud.eshare.f.b Q;
    private int T;
    private b.b.a.c U;
    private MediaService V;
    private List<VideoItem> R = null;
    private List<AudioItem> S = null;
    private ServiceConnection W = new b();

    /* loaded from: classes.dex */
    class a extends Handler {
        a(MediaActivity mediaActivity) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
        }
    }

    /* loaded from: classes.dex */
    class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MediaActivity.this.a("MediaActivity", "onServiceConnected");
            MediaActivity.this.V = ((MediaService.f) iBinder).a();
            MediaActivity.this.V.a(MediaActivity.this);
            MediaActivity mediaActivity = MediaActivity.this;
            mediaActivity.a(mediaActivity.V.a());
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MediaActivity.this.a("MediaActivity", "onServiceDisconnected");
            MediaActivity.this.V = null;
        }
    }

    /* loaded from: classes.dex */
    class c extends androidx.viewpager.widget.a {
        c(MediaActivity mediaActivity) {
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return 2;
        }

        @Override // androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            return viewGroup.getChildAt(i);
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: classes.dex */
    class d extends ViewPager.n {
        d() {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i) {
            MediaActivity.this.b(i == 0);
        }
    }

    /* loaded from: classes.dex */
    class e implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f2624b;

        e(int i, RecyclerView.g gVar) {
            this.f2623a = i;
            this.f2624b = gVar;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            AudioItem d2;
            if (MediaActivity.this.V != null) {
                MediaActivity.this.V.a((File) null, true);
                MediaActivity.this.V.a(this.f2623a);
            }
            if (this.f2624b == MediaActivity.this.O) {
                VideoItem d3 = MediaActivity.this.O.d(this.f2623a);
                if (d3 != null) {
                    if (MediaActivity.this.V != null) {
                        MediaActivity.this.V.b(MediaActivity.this.O.d());
                        MediaActivity.this.V.a((List<AudioItem>) null);
                    }
                    Intent intent = new Intent(MediaActivity.this, PlayerActivity.class);
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", true);
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_PATH", d3.getPathName());
                    intent.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", d3.getTitle());
                    MediaActivity.this.startActivity(intent);
                }
            } else if (this.f2624b == MediaActivity.this.P && (d2 = MediaActivity.this.P.d(this.f2623a)) != null) {
                if (MediaActivity.this.V != null) {
                    List<AudioItem> d4 = MediaActivity.this.P.d();
                    MediaActivity.this.V.b((List<VideoItem>) null);
                    MediaActivity.this.V.a(d4);
                }
                Intent intent2 = new Intent(MediaActivity.this, PlayerActivity.class);
                intent2.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", false);
                intent2.putExtra("com.eshare.optoma.extra.MEDIA_PATH", d2.getPathName());
                intent2.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", d2.getTitle());
                MediaActivity.this.startActivity(intent2);
            }
        }
    }

    /* loaded from: classes.dex */
    class f implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f2626a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RecyclerView.g f2627b;

        f(int i, RecyclerView.g gVar) {
            this.f2626a = i;
            this.f2627b = gVar;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            FileItem d2;
            if (MediaActivity.this.V != null) {
                MediaActivity.this.V.a((File) null, true);
                MediaActivity.this.V.a(this.f2626a);
            }
            if (this.f2627b == MediaActivity.this.O) {
                d2 = MediaActivity.this.O.d(this.f2626a);
                if (d2 == null) {
                    return;
                }
            } else if (this.f2627b != MediaActivity.this.P || (d2 = MediaActivity.this.P.d(this.f2626a)) == null) {
                return;
            }
            MediaActivity.this.a(d2.getFile());
        }
    }

    /* loaded from: classes.dex */
    class g extends RecyclerView.t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f2629a;

        g(LinearLayoutManager linearLayoutManager) {
            this.f2629a = linearLayoutManager;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void a(RecyclerView recyclerView, int i, int i2) {
            int F = this.f2629a.F();
            if (F != MediaActivity.this.T) {
                MediaActivity.this.T = F;
            }
        }
    }

    public MediaActivity() {
        new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        TextView textView;
        this.H.setSelected(z);
        this.I.setSelected(!z);
        if (z) {
            this.H.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_6sp));
            textView = this.I;
        } else {
            this.I.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_6sp));
            textView = this.H;
        }
        textView.setTextSize(getResources().getDimensionPixelSize(R.dimen.size_4sp));
    }

    public static MediaActivity v() {
        return X;
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i) {
        if (!this.U.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else {
            a(gVar == this.P ? 2 : 3, new e(i, gVar));
        }
    }

    @Override // com.ecloud.eshare.service.MediaService.e
    public void a(FileItem fileItem) {
        if (fileItem == null) {
            this.M.setVisibility(8);
        }
    }

    @Override // com.ecloud.eshare.model.b.k
    public void a(List<AudioItem> list, List<String> list2) {
        this.S = list;
        if (this.I.isSelected()) {
            if (list.size() > 0) {
                this.L.setVisibility(0);
                this.J.setVisibility(8);
            } else {
                this.J.setVisibility(0);
                this.L.setVisibility(8);
            }
        }
        this.P = new com.ecloud.eshare.c.b(this, list, list2);
        this.P.a((com.ecloud.eshare.d.e) this);
        this.P.a((com.ecloud.eshare.d.f) this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.L.setLayoutManager(linearLayoutManager);
        this.L.setAdapter(this.P);
        this.L.a(new g(linearLayoutManager));
    }

    @Override // com.ecloud.eshare.d.f
    public void b(RecyclerView.g gVar, int i) {
        if (!this.U.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
        } else {
            a(gVar == this.P ? 2 : 3, new f(i, gVar));
        }
    }

    @Override // com.ecloud.eshare.model.b.k
    public void d(List<VideoItem> list) {
        TextView textView;
        this.R = list;
        if (this.H.isSelected()) {
            int i = 8;
            if (list.size() > 0) {
                textView = this.J;
            } else {
                this.K.setVisibility(8);
                textView = this.J;
                i = 0;
            }
            textView.setVisibility(i);
        }
        this.O = new i(this, list);
        this.O.a(this.Q);
        this.O.a((com.ecloud.eshare.d.e) this);
        this.O.a((com.ecloud.eshare.d.f) this);
        this.K.setLayoutManager(new GridLayoutManager(this, com.ecloud.eshare.util.g.a(this, 120.0f)));
        this.K.setAdapter(this.O);
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() == EventCollections.FinishActivityEvent.FINISH_DEFAULT) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        FileItem a2;
        int id = view.getId();
        if (id != R.id.iv_media_back) {
            switch (id) {
                case R.id.tv_media_audio /* 2131231232 */:
                    this.N.setCurrentItem(1);
                    List<AudioItem> list = this.S;
                    if (list != null && list.size() > 0) {
                        this.L.setVisibility(0);
                        break;
                    } else {
                        this.J.setVisibility(0);
                        this.L.setVisibility(8);
                        return;
                    }
                case R.id.tv_media_playing /* 2131231233 */:
                    MediaService mediaService = this.V;
                    if (mediaService != null && (a2 = mediaService.a()) != null) {
                        Intent intent = new Intent(this, PlayerActivity.class);
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", a2 instanceof VideoItem);
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_PATH", a2.getPathName());
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_TITLE", a2.getTitle());
                        intent.putExtra("com.eshare.optoma.extra.MEDIA_PLAYING", true);
                        startActivity(intent);
                        return;
                    }
                    return;
                case R.id.tv_media_video /* 2131231234 */:
                    this.N.setCurrentItem(0);
                    List<VideoItem> list2 = this.R;
                    if (list2 == null || list2.size() <= 0) {
                        this.K.setVisibility(8);
                        this.J.setVisibility(0);
                        return;
                    }
                    break;
                default:
                    return;
            }
            this.J.setVisibility(8);
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        X = this;
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.V.c();
        unbindService(this.W);
        this.Q.a();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.H = (TextView) findViewById(R.id.tv_media_video);
        this.I = (TextView) findViewById(R.id.tv_media_audio);
        this.J = (TextView) findViewById(R.id.tv_media_video_placeholder);
        this.K = (RecyclerView) findViewById(R.id.rv_media_video_grid);
        this.L = (RecyclerView) findViewById(R.id.rv_media_audio);
        this.M = (TextView) findViewById(R.id.tv_media_playing);
        this.N = (ViewPager) findViewById(R.id.vp_media);
        findViewById(R.id.iv_media_back).setOnClickListener(this);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_media;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.Q = new com.ecloud.eshare.f.b();
        com.ecloud.eshare.model.b c2 = com.ecloud.eshare.model.b.c();
        c2.a((b.k) this);
        c2.e(this);
        this.U = b.b.a.a.a(this).b();
        bindService(new Intent(this, MediaService.class), this.W, 1);
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.N.setAdapter(new c(this));
        this.N.a(new d());
        this.L.a(new com.ecloud.eshare.view.b(getResources().getDimensionPixelOffset(R.dimen.size_15dp)));
    }
}
