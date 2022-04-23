package com.ecloud.eshare.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.ecloud.eshare.activity.PlayerActivity;
import com.ecloud.eshare.bean.AudioItem;
import com.ecloud.eshare.bean.FileItem;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.util.l;
import com.ecloud.eshare.util.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes.dex */
public class MediaService extends Service implements m {

    /* renamed from: b  reason: collision with root package name */
    private Context f2894b;

    /* renamed from: c  reason: collision with root package name */
    private b.b.a.g f2895c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.ecloud.eshare.d.b> f2896d;

    /* renamed from: e  reason: collision with root package name */
    private e f2897e;
    private g f;
    private d g;
    private int i;
    private int j;
    private FileItem k;
    private List<VideoItem> l;
    private List<AudioItem> m;
    private int n;
    private int o;
    private int h = 10;
    @SuppressLint({"HandlerLeak"})
    private final Handler p = new a();

    /* loaded from: classes.dex */
    class a extends Handler {

        /* renamed from: com.ecloud.eshare.service.MediaService$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0089a implements b.b.a.m.e {
            C0089a() {
            }

            @Override // b.b.a.m.e
            public void a(int i, int i2, int i3, String str) {
                com.eshare.mirror.b.f3055b = 0;
                String a2 = com.ecloud.eshare.util.c.a(MediaService.this.f2894b);
                if (a2.equals(str)) {
                    PlayerActivity.r0 = true;
                } else if ((a2.endsWith(String.valueOf(str)) || PlayerActivity.r0.booleanValue()) && PlayerActivity.r0.booleanValue()) {
                    MediaService.this.g.a(false);
                }
                if (MediaService.this.a(i, i2, i3)) {
                    MediaService.this.a((File) null, true);
                    MediaService.this.c();
                }
                MediaService mediaService = MediaService.this;
                mediaService.a("onStateChanged: " + MediaService.this.h + " => " + i, Integer.valueOf(MediaService.this.f2896d.size()));
                MediaService.this.h = i;
                if (i2 == -1 || i2 == -3) {
                    MediaService.this.h = i2;
                }
                for (com.ecloud.eshare.d.b bVar : MediaService.this.f2896d) {
                    if (bVar != null) {
                        bVar.b(MediaService.this.h);
                    }
                }
                MediaService.this.i = i2;
                MediaService.this.j = i3;
                MediaService mediaService2 = MediaService.this;
                mediaService2.a(mediaService2.i, MediaService.this.j);
            }

            @Override // b.b.a.m.e
            public void onError(Exception exc) {
                MediaService.this.a("getMediaStateError", exc);
            }
        }

        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                MediaService.this.f2895c.a(new C0089a());
                sendMessageDelayed(obtainMessage(1), 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2900b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2901c;

        b(int i, int i2) {
            this.f2900b = i;
            this.f2901c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (com.ecloud.eshare.d.b bVar : MediaService.this.f2896d) {
                if (bVar != null) {
                    bVar.a(this.f2900b, this.f2901c);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MediaService.this.f2897e != null) {
                MediaService.this.f2897e.a(MediaService.this.k);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(Boolean bool);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(FileItem fileItem);
    }

    /* loaded from: classes.dex */
    public class f extends Binder {
        public f() {
        }

        public MediaService a() {
            return MediaService.this;
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void b(FileItem fileItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.p.post(new b(i, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2, int i3) {
        return i == -3 && i2 == 0 && i3 == 0;
    }

    private void d() {
        this.p.post(new c());
    }

    public FileItem a() {
        return this.k;
    }

    public void a(int i) {
        this.n = i;
    }

    public void a(int i, boolean z) {
        AudioItem audioItem;
        File file;
        if (z) {
            List<VideoItem> list = this.l;
            if (list != null && list.size() >= 1) {
                c();
                this.n += i;
                if (this.n < 0) {
                    this.n = this.l.size() - 1;
                }
                if (this.n >= this.l.size()) {
                    this.n = 0;
                }
                audioItem = this.l.get(this.n);
                file = new File(audioItem.getPathName());
            } else {
                return;
            }
        } else {
            List<AudioItem> list2 = this.m;
            if (list2 != null && list2.size() >= 1) {
                c();
                String str = "musicPlayMode===>" + this.o;
                int i2 = this.o;
                if (i2 == 0) {
                    this.n += i;
                } else if (i2 != 1) {
                    if (i2 == 2) {
                        this.n = this.m.size() == 1 ? -1 : new Random().nextInt(this.m.size());
                    }
                } else if (PlayerActivity.s0) {
                    this.n += i;
                    PlayerActivity.s0 = false;
                }
                if (this.n < 0) {
                    this.n = this.m.size() - 1;
                }
                if (this.n >= this.m.size()) {
                    this.n = 0;
                }
                audioItem = this.m.get(this.n);
                file = new File(audioItem.getPathName());
            } else {
                return;
            }
        }
        a(file, z);
        g gVar = this.f;
        if (gVar != null) {
            gVar.b(audioItem);
        }
    }

    public void a(com.ecloud.eshare.d.b bVar) {
        if (!this.f2896d.contains(bVar)) {
            this.f2896d.add(bVar);
        }
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    public void a(e eVar) {
        this.f2897e = eVar;
    }

    public void a(g gVar) {
        this.f = gVar;
    }

    public void a(File file, boolean z) {
        b("setFileItem", file);
        if (file == null) {
            this.k = null;
        } else {
            this.k = z ? new VideoItem(file) : new AudioItem(file);
        }
        d();
    }

    public void a(List<AudioItem> list) {
        this.m = list;
    }

    public void a(Object... objArr) {
        l.a(objArr);
    }

    public void b() {
        b("startCheckProgress");
        this.p.removeMessages(1);
        this.p.sendEmptyMessage(1);
    }

    public void b(int i) {
        this.o = i;
    }

    public void b(com.ecloud.eshare.d.b bVar) {
        if (this.f2896d.contains(bVar)) {
            this.f2896d.remove(bVar);
        }
    }

    public void b(List<VideoItem> list) {
        this.l = list;
    }

    public void b(Object... objArr) {
        l.b(objArr);
    }

    public void c() {
        b("stopCheckProgress");
        this.p.removeCallbacksAndMessages(null);
        a((File) null, true);
        a(0, 0);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new f();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a("MediaService", "onCreate");
        this.f2895c = b.b.a.a.a(this).e();
        this.f2896d = new ArrayList();
        this.f2894b = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a("MediaService", "onDestroy");
        c();
    }
}
