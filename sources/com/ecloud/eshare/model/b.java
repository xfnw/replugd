package com.ecloud.eshare.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.MediaStore;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.AlbumItem;
import com.ecloud.eshare.bean.AudioItem;
import com.ecloud.eshare.bean.DocumentItem;
import com.ecloud.eshare.bean.PhotoItem;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.util.l;
import com.ecloud.eshare.util.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class b implements m {
    public static boolean p = true;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2866b;

    /* renamed from: c  reason: collision with root package name */
    private ContentResolver f2867c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f2868d;

    /* renamed from: e  reason: collision with root package name */
    private List<VideoItem> f2869e;
    private List<AudioItem> f;
    private List<String> g;
    private List<DocumentItem> h;
    private List<AlbumItem> i;
    private k j;
    private i k;
    private g l;
    private h m;
    private List<PhotoItem> n;
    boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2870b;

        /* renamed from: com.ecloud.eshare.model.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0086a implements Runnable {
            RunnableC0086a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.j != null) {
                    b.this.j.d(b.this.f2869e);
                }
            }
        }

        a(Context context) {
            this.f2870b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemClock.uptimeMillis();
            b.this.g(this.f2870b);
            b.this.f2868d.post(new RunnableC0086a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ecloud.eshare.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0087b implements Runnable {

        /* renamed from: com.ecloud.eshare.model.b$b$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.j != null) {
                    b.this.j.a(b.this.f, b.this.g);
                }
            }
        }

        RunnableC0087b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            b.this.e();
            b.this.f2868d.post(new a());
            b.this.a("listMedias", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), Thread.currentThread().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2875b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.j != null) {
                    b.this.j.d(b.this.f2869e);
                }
            }
        }

        /* renamed from: com.ecloud.eshare.model.b$c$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0088b implements Runnable {
            RunnableC0088b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.j != null) {
                    b.this.j.a(b.this.f, b.this.g);
                }
            }
        }

        c(Context context) {
            this.f2875b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            b.this.g(this.f2875b);
            b.this.f2868d.post(new a());
            b.this.e();
            b.this.f2868d.post(new RunnableC0088b());
            b.this.a("listMedias", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), Thread.currentThread().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.k != null) {
                    b.this.k.b(b.this.h);
                }
            }
        }

        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            b.this.f();
            b.this.f2868d.post(new a());
            b.this.a("listDocuments", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), Thread.currentThread().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2881b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.l != null) {
                    b.this.l.a(b.this.i);
                }
            }
        }

        e(Context context) {
            this.f2881b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            b.this.a(b.b.a.a.a(this.f2881b).e());
            b.this.f2868d.post(new a());
            b.this.a("listAlbums", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), Thread.currentThread().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f2884b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.m != null) {
                    b.this.m.c(b.this.n);
                }
            }
        }

        f(Context context) {
            this.f2884b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            long uptimeMillis = SystemClock.uptimeMillis();
            b.this.b(b.b.a.a.a(this.f2884b).e());
            b.this.f2868d.post(new a());
            b.this.a("listAlbums", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), Thread.currentThread().getName());
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(List<AlbumItem> list);
    }

    /* loaded from: classes.dex */
    public interface h {
        void c(List<PhotoItem> list);
    }

    /* loaded from: classes.dex */
    public interface i {
        void b(List<DocumentItem> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private static b f2887a = new b(null);
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(List<AudioItem> list, List<String> list2);

        void d(List<VideoItem> list);
    }

    private b() {
        this.f2868d = new Handler(Looper.getMainLooper());
        this.f2866b = Executors.newCachedThreadPool();
        this.f2869e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        new ArrayList();
        this.i = new ArrayList();
        this.n = new ArrayList();
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    private String a(String str) {
        return String.format("%1$s='%2$s'", "mime_type", str);
    }

    private void a() {
        String str = null;
        for (int i2 = 0; i2 < this.f.size(); i2++) {
            AudioItem audioItem = this.f.get(i2);
            if (!audioItem.getLetter().equals(str)) {
                audioItem.setFirst(true);
                str = audioItem.getLetter();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b.b.a.g gVar) {
        Cursor cursor = null;
        try {
            cursor = this.f2867c.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursor != null) {
            this.i.clear();
            while (cursor.moveToNext()) {
                File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                if (file.exists()) {
                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                    AlbumItem albumItem = new AlbumItem(file.getParentFile());
                    if (!this.i.contains(albumItem)) {
                        albumItem.setCoverUri(string);
                        this.i.add(albumItem);
                    }
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            Collections.sort(this.i, new com.ecloud.eshare.i.a());
            a("listAlbums", Integer.valueOf(this.i.size()), this.i);
        }
    }

    private void b() {
        String str = null;
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            DocumentItem documentItem = this.h.get(i2);
            String date = documentItem.getDate();
            if (!date.equals(str)) {
                documentItem.setFirst(true);
                documentItem.setIndex(1);
                str = date;
            } else {
                DocumentItem documentItem2 = this.h.get(i2 - 1);
                documentItem2.setLast(false);
                documentItem.setIndex(documentItem2.getIndex() + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b.b.a.g gVar) {
        Cursor cursor;
        try {
            cursor = this.f2867c.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            cursor = null;
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {
                File file = new File(cursor.getString(cursor.getColumnIndex("_data")));
                if (file.exists()) {
                    cursor.getString(cursor.getColumnIndex("_data"));
                    PhotoItem photoItem = new PhotoItem(file);
                    photoItem.parseDate(CustomApplication.c());
                    if (!this.n.contains(photoItem)) {
                        this.n.add(photoItem);
                    }
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
        }
    }

    public static b c() {
        return j.f2887a;
    }

    private void d() {
        String str = null;
        for (int i2 = 0; i2 < this.f2869e.size(); i2++) {
            VideoItem videoItem = this.f2869e.get(i2);
            String date = videoItem.getDate();
            if (!date.equals(str)) {
                videoItem.setFirst(true);
                videoItem.setIndex(1);
                str = date;
            } else {
                VideoItem videoItem2 = this.f2869e.get(i2 - 1);
                videoItem2.setLast(false);
                videoItem.setIndex(videoItem2.getIndex() + 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        Cursor cursor = null;
        try {
            cursor = this.f2867c.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursor != null) {
            this.f.clear();
            this.g.clear();
            while (cursor.moveToNext()) {
                AudioItem audioItem = new AudioItem(cursor.getString(cursor.getColumnIndex("_data")));
                if (audioItem.isExists()) {
                    long j2 = cursor.getLong(cursor.getColumnIndex("duration"));
                    if (j2 > 0) {
                        audioItem.setDuration(j2);
                        audioItem.setTitle(cursor.getString(cursor.getColumnIndex("_display_name")));
                        if (!this.g.contains(audioItem.getLetter())) {
                            this.g.add(audioItem.getLetter());
                        }
                        if (!this.f.contains(audioItem)) {
                            this.f.add(audioItem);
                        }
                    }
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            Collections.sort(this.f, new com.ecloud.eshare.i.b());
            a();
            a("listAudios", Integer.valueOf(this.f.size()), this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        Cursor cursor = null;
        try {
            cursor = this.f2867c.query(MediaStore.Files.getContentUri("external"), null, a("application/msword") + " OR " + a("application/vnd.openxmlformats-officedocument.wordprocessingml.document") + " OR " + a("application/vnd.ms-powerpoint") + " OR " + a("application/vnd.openxmlformats-officedocument.presentationml.presentation") + " OR " + a("application/vnd.ms-excel") + " OR " + a("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") + " OR " + a("application/pdf"), null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursor != null) {
            this.h.clear();
            while (cursor.moveToNext()) {
                DocumentItem documentItem = new DocumentItem(cursor.getString(cursor.getColumnIndex("_data")));
                if (documentItem.isExists()) {
                    documentItem.parseDate(CustomApplication.c());
                    if (!this.h.contains(documentItem)) {
                        this.h.add(documentItem);
                    }
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            Collections.sort(this.h, new com.ecloud.eshare.i.e());
            b();
            a("listDocuments", Integer.valueOf(this.h.size()), this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Context context) {
        this.o = true;
        Cursor cursor = null;
        try {
            cursor = this.f2867c.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (cursor != null) {
            this.f2869e.clear();
            while (cursor.moveToNext()) {
                VideoItem videoItem = new VideoItem(cursor.getString(cursor.getColumnIndex("_data")));
                if (videoItem.isExists()) {
                    long j2 = cursor.getLong(cursor.getColumnIndex("duration"));
                    if (j2 > 0) {
                        videoItem.setDuration(j2);
                        videoItem.setTitle(cursor.getString(cursor.getColumnIndex("_display_name")));
                        videoItem.parseDate(context);
                        if (!this.f2869e.contains(videoItem)) {
                            this.f2869e.add(videoItem);
                        }
                    }
                }
            }
            if (!cursor.isClosed()) {
                cursor.close();
            }
            Collections.sort(this.f2869e, new com.ecloud.eshare.i.e());
            d();
            a("listVideos", Integer.valueOf(this.f2869e.size()), this.f2869e);
            this.o = false;
        }
    }

    public void a(Context context) {
        if (this.f2867c == null) {
            this.f2867c = context.getContentResolver();
        }
        this.f2866b.execute(new RunnableC0087b());
    }

    public void a(g gVar) {
        this.l = gVar;
    }

    public void a(h hVar) {
        this.m = hVar;
    }

    public void a(i iVar) {
        this.k = iVar;
    }

    public void a(k kVar) {
        this.j = kVar;
    }

    public void a(Object... objArr) {
        if (p) {
            l.a(objArr);
        }
    }

    public void b(Context context) {
        if (!this.o) {
            if (this.f2867c == null) {
                this.f2867c = context.getContentResolver();
            }
            this.f2866b.execute(new a(context));
        }
    }

    public void c(Context context) {
        if (this.f2867c == null) {
            this.f2867c = context.getContentResolver();
        }
        this.f2866b.execute(new e(context));
    }

    public void d(Context context) {
        if (this.f2867c == null) {
            this.f2867c = context.getContentResolver();
        }
        this.f2866b.execute(new d());
    }

    public void e(Context context) {
        if (this.f2867c == null) {
            this.f2867c = context.getContentResolver();
        }
        this.f2866b.execute(new c(context));
    }

    public void f(Context context) {
        if (this.f2867c == null) {
            this.f2867c = context.getContentResolver();
        }
        this.f2866b.execute(new f(context));
    }
}
