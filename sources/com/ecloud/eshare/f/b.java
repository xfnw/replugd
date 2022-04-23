package com.ecloud.eshare.f;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Handler;
import android.os.Looper;
import com.ecloud.eshare.bean.VideoItem;
import com.ecloud.eshare.util.i;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private final Handler f2800c = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    private Map<String, SoftReference<Bitmap>> f2798a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f2799b = Executors.newFixedThreadPool(5);

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ VideoItem f2801b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AbstractC0081b f2802c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f2803d;

        /* renamed from: com.ecloud.eshare.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0080a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Bitmap f2805b;

            RunnableC0080a(Bitmap bitmap) {
                this.f2805b = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap = this.f2805b;
                if (bitmap == null) {
                    a aVar = a.this;
                    aVar.f2802c.onError(aVar.f2803d);
                    return;
                }
                a aVar2 = a.this;
                aVar2.f2802c.a(bitmap, aVar2.f2803d);
            }
        }

        a(VideoItem videoItem, AbstractC0081b bVar, String str) {
            this.f2801b = videoItem;
            this.f2802c = bVar;
            this.f2803d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f2800c.post(new RunnableC0080a(b.this.a(this.f2801b)));
        }
    }

    /* renamed from: com.ecloud.eshare.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0081b {
        void a(Bitmap bitmap, String str);

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(VideoItem videoItem) {
        if (videoItem.isThumbExists()) {
            return i.a(videoItem.getThumbPath(), 1920, 1080);
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(videoItem.getPathName(), 1);
        i.a(createVideoThumbnail, new File(videoItem.getThumbPath()));
        return createVideoThumbnail;
    }

    public void a() {
        for (String str : this.f2798a.keySet()) {
            Bitmap bitmap = this.f2798a.get(str).get();
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }
        this.f2798a.clear();
        if (!this.f2799b.isShutdown()) {
            this.f2799b.shutdown();
        }
    }

    public void a(VideoItem videoItem, AbstractC0081b bVar) {
        Bitmap bitmap;
        String pathName = videoItem.getPathName();
        if (!this.f2798a.containsKey(pathName) || (bitmap = this.f2798a.get(pathName).get()) == null || bitmap.isRecycled()) {
            this.f2799b.execute(new a(videoItem, bVar, pathName));
        } else {
            bVar.a(bitmap, pathName);
        }
    }
}
