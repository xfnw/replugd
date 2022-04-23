package com.squareup.picasso;

import android.content.Context;
import d.a0;
import d.c;
import d.e;
import d.v;
import d.y;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class OkHttp3Downloader implements Downloader {
    private final c cache;
    final e.a client;
    private boolean sharedClient;

    public OkHttp3Downloader(Context context) {
        this(Utils.createDefaultCacheDir(context));
    }

    public OkHttp3Downloader(Context context, long j) {
        this(Utils.createDefaultCacheDir(context), j);
    }

    public OkHttp3Downloader(e.a aVar) {
        this.sharedClient = true;
        this.client = aVar;
        this.cache = null;
    }

    public OkHttp3Downloader(v vVar) {
        this.sharedClient = true;
        this.client = vVar;
        this.cache = vVar.b();
    }

    public OkHttp3Downloader(File file) {
        this(file, Utils.calculateDiskCacheSize(file));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public OkHttp3Downloader(java.io.File r3, long r4) {
        /*
            r2 = this;
            d.v$b r0 = new d.v$b
            r0.<init>()
            d.c r1 = new d.c
            r1.<init>(r3, r4)
            r0.a(r1)
            d.v r3 = r0.a()
            r2.<init>(r3)
            r3 = 0
            r2.sharedClient = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.OkHttp3Downloader.<init>(java.io.File, long):void");
    }

    @Override // com.squareup.picasso.Downloader
    public a0 load(y yVar) {
        return this.client.a(yVar).m();
    }

    @Override // com.squareup.picasso.Downloader
    public void shutdown() {
        c cVar;
        if (!this.sharedClient && (cVar = this.cache) != null) {
            try {
                cVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
