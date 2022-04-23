package com.ecloud.eshare.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.AudioItem;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.bean.FileItem;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.model.b;
import com.ecloud.eshare.service.MediaService;
import com.squareup.picasso.R;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class PlayerActivity extends com.ecloud.eshare.activity.a implements com.ecloud.eshare.d.b, MediaService.g, MediaService.d, b.k, com.ecloud.eshare.d.e {
    public static Boolean r0 = false;
    public static boolean s0 = false;
    public static PlayerActivity t0 = null;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private ImageView M;
    private ImageView N;
    private ImageView O;
    private ImageView P;
    private ImageView Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private SeekBar U;
    private boolean V;
    private File W;
    private String X;
    private boolean Y;
    private long a0;
    private volatile boolean b0;
    private volatile boolean c0;
    private int g0;
    private b.b.a.g h0;
    private ExecutorService i0;
    private MediaService j0;
    private RelativeLayout n0;
    private ConstraintLayout o0;
    private RecyclerView p0;
    private com.ecloud.eshare.c.b q0;
    private int Z = 10;
    private int d0 = -3;
    private int e0 = 1;
    private int f0 = -1;
    private Boolean k0 = false;
    private Handler l0 = new b(Looper.getMainLooper());
    private ServiceConnection m0 = new c();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: com.ecloud.eshare.activity.PlayerActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0066a implements Runnable {
            RunnableC0066a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.J.setText(PlayerActivity.this.X);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.d(-1);
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            PlayerActivity playerActivity;
            Log.e("miao", "onNextFile.....");
            if (PlayerActivity.this.h0.c(PlayerActivity.this.W)) {
                PlayerActivity.this.j0.b();
                playerActivity = PlayerActivity.this;
                runnable = new RunnableC0066a();
            } else {
                playerActivity = PlayerActivity.this;
                runnable = new b();
            }
            playerActivity.runOnUiThread(runnable);
        }
    }

    /* loaded from: classes.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10) {
                c.a.a.e.a(PlayerActivity.this.getApplicationContext(), PlayerActivity.this.getString(R.string.host_function_disabled), null, PlayerActivity.this.getResources().getColor(R.color.c_666666), PlayerActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
                PlayerActivity.this.finish();
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes.dex */
    class c implements ServiceConnection {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: com.ecloud.eshare.activity.PlayerActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0067a implements Runnable {
                RunnableC0067a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    PlayerActivity.this.d(-1);
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PlayerActivity.this.h0.c(PlayerActivity.this.W)) {
                    PlayerActivity.this.j0.a(PlayerActivity.this.W, PlayerActivity.this.V);
                    PlayerActivity.this.j0.b(CustomApplication.a("com.eshare.optoma.key.MUSIC_MODE", 0));
                    PlayerActivity.this.j0.b();
                    return;
                }
                PlayerActivity.this.runOnUiThread(new RunnableC0067a());
            }
        }

        c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            PlayerActivity.this.a("PlayerActivity", "onServiceConnected");
            PlayerActivity.this.j0 = ((MediaService.f) iBinder).a();
            PlayerActivity.this.j0.a((com.ecloud.eshare.d.b) PlayerActivity.this);
            PlayerActivity.this.j0.a((MediaService.g) PlayerActivity.this);
            PlayerActivity.this.j0.a((MediaService.d) PlayerActivity.this);
            if (!PlayerActivity.this.Y) {
                PlayerActivity.this.i0.execute(new a());
                return;
            }
            PlayerActivity.this.j0.a(PlayerActivity.this.W, PlayerActivity.this.V);
            PlayerActivity.this.j0.b();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            PlayerActivity.this.a("PlayerActivity", "onServiceDisconnected");
            PlayerActivity.this.j0 = null;
        }
    }

    /* loaded from: classes.dex */
    class d implements SeekBar.OnSeekBarChangeListener {
        d() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            PlayerActivity.this.h0.a(seekBar.getProgress());
            PlayerActivity.this.x();
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity playerActivity = PlayerActivity.this;
                playerActivity.b(!playerActivity.z());
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PlayerActivity.this.h0.d(!PlayerActivity.this.z())) {
                PlayerActivity.this.y();
                PlayerActivity.this.runOnUiThread(new a());
                return;
            }
            CustomApplication.a((int) R.string.player_control_failed);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PlayerActivity.this.h0.B()) {
                PlayerActivity.this.A();
            } else {
                CustomApplication.a((int) R.string.player_control_failed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f2671b;

        g(boolean z) {
            this.f2671b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            ImageView imageView;
            if (this.f2671b) {
                PlayerActivity.this.N.setSelected(true);
                imageView = PlayerActivity.this.N;
                i = R.drawable.ic_play;
            } else {
                PlayerActivity.this.N.setSelected(false);
                imageView = PlayerActivity.this.N;
                i = R.drawable.ic_pause;
            }
            imageView.setImageResource(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivity.this.b0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {
        i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PlayerActivity.this.c0 = false;
        }
    }

    /* loaded from: classes.dex */
    class j implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.J.setText(PlayerActivity.this.X);
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PlayerActivity.this.d(-1);
            }
        }

        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            PlayerActivity playerActivity;
            Log.e("miao", "onNextFile.....");
            if (PlayerActivity.this.h0.c(PlayerActivity.this.W)) {
                PlayerActivity.this.j0.b();
                playerActivity = PlayerActivity.this;
                runnable = new a();
            } else {
                playerActivity = PlayerActivity.this;
                runnable = new b();
            }
            playerActivity.runOnUiThread(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        b("playOver");
        MediaService mediaService = this.j0;
        if (mediaService != null) {
            mediaService.a((File) null, this.V);
            this.j0.c();
        }
        if (!isFinishing()) {
            finish();
        }
    }

    private void B() {
        int i2;
        ImageView imageView;
        if (this.V) {
            this.I.setVisibility(0);
            this.H.setText(R.string.player_video);
            imageView = this.M;
            i2 = R.drawable.ic_video_play_ok;
        } else {
            this.H.setText(R.string.player_audio);
            this.I.setVisibility(4);
            imageView = this.M;
            i2 = R.drawable.ic_audio_play;
        }
        imageView.setImageResource(i2);
    }

    private void C() {
        this.i0.execute(new f());
    }

    private void D() {
        int i2;
        ImageView imageView;
        int i3 = this.g0;
        if (i3 == 0) {
            imageView = this.Q;
            i2 = R.drawable.ic_music_loop_selector;
        } else if (i3 == 1) {
            imageView = this.Q;
            i2 = R.drawable.ic_music_single_cycle_selector;
        } else if (i3 == 2) {
            imageView = this.Q;
            i2 = R.drawable.ic_music_random_selector;
        } else {
            return;
        }
        imageView.setImageResource(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        runOnUiThread(new g(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        TextView textView;
        int i3;
        if (this.Z != i2) {
            this.Z = i2;
            if (i2 == -1) {
                textView = this.I;
                i3 = R.string.player_error;
            } else if (i2 != 1) {
                if (i2 == 11) {
                    if (this.V) {
                        textView = this.I;
                        i3 = R.string.player_video_loading;
                    } else {
                        textView = this.I;
                        i3 = R.string.player_audio_loading;
                    }
                } else {
                    return;
                }
            } else if (this.V) {
                textView = this.I;
                i3 = R.string.player_video_playing;
            } else {
                textView = this.I;
                i3 = R.string.player_audio_playing;
            }
            textView.setText(i3);
            this.M.setSelected(false);
        }
    }

    private void v() {
        String str = "changePlayMode====>" + this.g0;
        this.g0++;
        if (this.g0 > 2) {
            this.g0 = 0;
        }
        String str2 = "Mode====>" + this.g0;
        this.j0.b(this.g0);
        CustomApplication.b("com.eshare.optoma.key.MUSIC_MODE", this.g0);
        D();
    }

    public static PlayerActivity w() {
        return t0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        this.c0 = true;
        this.U.postDelayed(new i(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.b0 = true;
        this.N.postDelayed(new h(), 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        return this.N.isSelected();
    }

    @Override // com.ecloud.eshare.d.b
    public void a(int i2, int i3) {
        if (!this.c0) {
            this.U.setMax(i3);
            this.L.setText(com.ecloud.eshare.util.c.a(i3));
            this.U.setProgress(i2);
            this.K.setText(com.ecloud.eshare.util.c.a(i2));
            if (i2 > 0) {
                this.d0 = i2;
                d(1);
            } else if (this.d0 != i2) {
                this.d0 = i2;
                if (i2 == -3) {
                    if (this.k0.booleanValue()) {
                        Boolean bool = true;
                        this.k0 = bool;
                        if (!bool.booleanValue()) {
                            return;
                        }
                        A();
                        return;
                    }
                    this.k0 = true;
                } else if (i2 == -2) {
                    s0 = false;
                    this.j0.a(this.e0, this.V);
                    x();
                } else if (i2 == -1) {
                    if (this.k0.booleanValue()) {
                        Boolean bool2 = true;
                        this.k0 = bool2;
                        if (!bool2.booleanValue()) {
                            return;
                        }
                        A();
                        return;
                    }
                    this.k0 = true;
                }
            }
        }
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i2) {
        com.ecloud.eshare.c.b bVar = this.q0;
        if (gVar == bVar) {
            AudioItem d2 = bVar.d(i2);
            if (d2 != null) {
                this.X = d2.getTitle();
                this.W = new File(d2.getPathName());
                this.i0.execute(new a());
            }
            this.n0.setVisibility(8);
        }
    }

    @Override // com.ecloud.eshare.service.MediaService.d
    public void a(Boolean bool) {
        if (!bool.booleanValue()) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.model.b.k
    public void a(List<AudioItem> list, List<String> list2) {
        this.q0 = new com.ecloud.eshare.c.b(this, list, list2);
        this.q0.a(this);
        this.p0.setLayoutManager(new LinearLayoutManager(this));
        this.p0.setAdapter(this.q0);
    }

    @Override // com.ecloud.eshare.d.b
    public void b(int i2) {
        if (i2 != -3 && i2 != 6) {
            int i3 = -1;
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        i3 = 11;
                        if (!(i2 == 10 || i2 == 11)) {
                            return;
                        }
                    } else if (!this.b0) {
                        d(1);
                        if (z()) {
                            b(false);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else if (!this.b0) {
                    d(1);
                    if (!z()) {
                        b(true);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            d(i3);
        } else if (this.Z == 1 && SystemClock.uptimeMillis() - this.a0 > 5000) {
            A();
            this.Z = 10;
        }
    }

    @Override // com.ecloud.eshare.service.MediaService.g
    public void b(FileItem fileItem) {
        if (fileItem != null) {
            this.X = fileItem.getTitle();
            this.W = new File(fileItem.getPathName());
            this.i0.execute(new j());
        }
    }

    @Override // com.ecloud.eshare.model.b.k
    public void d(List<VideoItem> list) {
    }

    @Override // android.app.Activity
    public void finish() {
        C();
        super.finish();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_MIRROR) {
            this.l0.sendEmptyMessage(10);
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        int i2;
        MediaService mediaService;
        int i3;
        int id = view.getId();
        if (id == R.id.rl_play) {
            relativeLayout = this.n0;
            i2 = 8;
        } else if (id != R.id.tv_player_stop) {
            i2 = 0;
            switch (id) {
                case R.id.iv_play_loop /* 2131230950 */:
                    v();
                    return;
                case R.id.iv_player_back /* 2131230951 */:
                    finish();
                    return;
                case R.id.iv_player_next /* 2131230952 */:
                    s0 = true;
                    mediaService = this.j0;
                    i3 = this.e0;
                    break;
                case R.id.iv_player_play /* 2131230953 */:
                    this.i0.execute(new e());
                    return;
                case R.id.iv_player_prev /* 2131230954 */:
                    s0 = true;
                    mediaService = this.j0;
                    i3 = this.f0;
                    break;
                case R.id.iv_player_random /* 2131230955 */:
                    relativeLayout = this.n0;
                    break;
                default:
                    switch (id) {
                        case R.id.iv_player_volume_down /* 2131230957 */:
                            this.h0.c(false);
                            return;
                        case R.id.iv_player_volume_up /* 2131230958 */:
                            this.h0.c(true);
                            return;
                        default:
                            return;
                    }
            }
            mediaService.a(i3, this.V);
            return;
        } else {
            C();
            return;
        }
        relativeLayout.setVisibility(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a0 = SystemClock.uptimeMillis();
        r0 = false;
        this.k0 = false;
        t0 = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MediaService mediaService = this.j0;
        if (mediaService != null) {
            mediaService.c();
            this.j0.b(this);
        }
        unbindService(this.m0);
        this.i0.shutdown();
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            this.h0.c(true);
            return true;
        } else if (i2 != 25) {
            return super.onKeyDown(i2, keyEvent);
        } else {
            this.h0.c(false);
            return true;
        }
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.H = (TextView) findViewById(R.id.tv_player_title);
        this.I = (TextView) findViewById(R.id.tv_player_state);
        this.J = (TextView) findViewById(R.id.tv_player_name);
        this.K = (TextView) findViewById(R.id.tv_player_progress);
        this.L = (TextView) findViewById(R.id.tv_player_duration);
        this.M = (ImageView) findViewById(R.id.iv_player_state);
        this.S = (ImageView) findViewById(R.id.iv_player_volume_up);
        this.T = (ImageView) findViewById(R.id.iv_player_volume_down);
        this.N = (ImageView) findViewById(R.id.iv_player_play);
        this.O = (ImageView) findViewById(R.id.iv_player_next);
        this.P = (ImageView) findViewById(R.id.iv_player_prev);
        this.Q = (ImageView) findViewById(R.id.iv_play_loop);
        this.R = (ImageView) findViewById(R.id.iv_player_random);
        this.U = (SeekBar) findViewById(R.id.sb_player);
        findViewById(R.id.iv_player_back).setOnClickListener(this);
        findViewById(R.id.tv_player_stop).setOnClickListener(this);
        this.n0 = (RelativeLayout) findViewById(R.id.rl_audio_show);
        this.o0 = (ConstraintLayout) findViewById(R.id.rl_play);
        this.o0.setOnClickListener(this);
        this.p0 = (RecyclerView) findViewById(R.id.rv_play_media_audio);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_player;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.r = 0;
        this.d0 = -3;
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        this.V = getIntent().getBooleanExtra("com.eshare.optoma.extra.MEDIA_IS_VIDEO", true);
        B();
        this.Y = getIntent().getBooleanExtra("com.eshare.optoma.extra.MEDIA_PLAYING", false);
        d(this.Y ? 1 : 11);
        this.g0 = CustomApplication.a("com.eshare.optoma.key.MUSIC_MODE", 0);
        String str = " playFunction====>" + this.g0;
        this.i0 = Executors.newCachedThreadPool();
        this.h0 = b.b.a.a.a(this).e();
        com.ecloud.eshare.model.b c2 = com.ecloud.eshare.model.b.c();
        c2.a((b.k) this);
        c2.e(this);
        bindService(new Intent(this, MediaService.class), this.m0, 1);
        this.X = getIntent().getStringExtra("com.eshare.optoma.extra.MEDIA_TITLE");
        this.W = new File(getIntent().getStringExtra("com.eshare.optoma.extra.MEDIA_PATH"));
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        ImageView imageView;
        this.N.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.O.setOnClickListener(this);
        if (this.V) {
            this.S.setOnClickListener(this);
            this.T.setOnClickListener(this);
            this.Q.setVisibility(8);
            imageView = this.R;
        } else {
            this.R.setOnClickListener(this);
            this.Q.setOnClickListener(this);
            D();
            this.T.setVisibility(8);
            imageView = this.S;
        }
        imageView.setVisibility(8);
        this.J.setText(this.X);
        this.U.setOnSeekBarChangeListener(new d());
    }
}
