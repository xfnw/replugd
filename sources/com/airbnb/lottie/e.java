package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.w.t;
import com.airbnb.lottie.x.h;
import e.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, m<com.airbnb.lottie.d>> f2110a = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements h<com.airbnb.lottie.d> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2111a;

        a(String str) {
            this.f2111a = str;
        }

        public void a(com.airbnb.lottie.d dVar) {
            if (this.f2111a != null) {
                com.airbnb.lottie.u.g.a().a(this.f2111a, dVar);
            }
            e.f2110a.remove(this.f2111a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements h<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2112a;

        b(String str) {
            this.f2112a = str;
        }

        public void a(Throwable th) {
            e.f2110a.remove(this.f2112a);
        }
    }

    /* loaded from: classes.dex */
    static class c implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2113a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2114b;

        c(Context context, String str) {
            this.f2113a = context;
            this.f2114b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<com.airbnb.lottie.d> call() {
            return com.airbnb.lottie.v.c.a(this.f2113a, this.f2114b);
        }
    }

    /* loaded from: classes.dex */
    static class d implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2115a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2116b;

        d(Context context, String str) {
            this.f2115a = context;
            this.f2116b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<com.airbnb.lottie.d> call() {
            return e.b(this.f2115a, this.f2116b);
        }
    }

    /* renamed from: com.airbnb.lottie.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class CallableC0060e implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2117a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2118b;

        CallableC0060e(Context context, int i) {
            this.f2117a = context;
            this.f2118b = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<com.airbnb.lottie.d> call() {
            return e.b(this.f2117a, this.f2118b);
        }
    }

    /* loaded from: classes.dex */
    static class f implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.w.k0.c f2119a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2120b;

        f(com.airbnb.lottie.w.k0.c cVar, String str) {
            this.f2119a = cVar;
            this.f2120b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<com.airbnb.lottie.d> call() {
            return e.b(this.f2119a, this.f2120b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g implements Callable<l<com.airbnb.lottie.d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.d f2121a;

        g(com.airbnb.lottie.d dVar) {
            this.f2121a = dVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public l<com.airbnb.lottie.d> call() {
            return new l<>(this.f2121a);
        }
    }

    private static com.airbnb.lottie.g a(com.airbnb.lottie.d dVar, String str) {
        for (com.airbnb.lottie.g gVar : dVar.h().values()) {
            if (gVar.b().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static l<com.airbnb.lottie.d> a(com.airbnb.lottie.w.k0.c cVar, String str, boolean z) {
        try {
            try {
                com.airbnb.lottie.d a2 = t.a(cVar);
                com.airbnb.lottie.u.g.a().a(str, a2);
                l<com.airbnb.lottie.d> lVar = new l<>(a2);
                if (z) {
                    h.a(cVar);
                }
                return lVar;
            } catch (Exception e2) {
                l<com.airbnb.lottie.d> lVar2 = new l<>(e2);
                if (z) {
                    h.a(cVar);
                }
                return lVar2;
            }
        } catch (Throwable th) {
            if (z) {
                h.a(cVar);
            }
            throw th;
        }
    }

    public static l<com.airbnb.lottie.d> a(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static l<com.airbnb.lottie.d> a(InputStream inputStream, String str, boolean z) {
        try {
            return b(com.airbnb.lottie.w.k0.c.a(l.a(l.a(inputStream))), str);
        } finally {
            if (z) {
                h.a(inputStream);
            }
        }
    }

    public static l<com.airbnb.lottie.d> a(ZipInputStream zipInputStream, String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            h.a(zipInputStream);
        }
    }

    public static m<com.airbnb.lottie.d> a(Context context, int i) {
        return a(a(i), new CallableC0060e(context.getApplicationContext(), i));
    }

    public static m<com.airbnb.lottie.d> a(Context context, String str) {
        return a(str, new d(context.getApplicationContext(), str));
    }

    public static m<com.airbnb.lottie.d> a(com.airbnb.lottie.w.k0.c cVar, String str) {
        return a(str, new f(cVar, str));
    }

    private static m<com.airbnb.lottie.d> a(String str, Callable<l<com.airbnb.lottie.d>> callable) {
        com.airbnb.lottie.d a2 = str == null ? null : com.airbnb.lottie.u.g.a().a(str);
        if (a2 != null) {
            return new m<>(new g(a2));
        }
        if (str != null && f2110a.containsKey(str)) {
            return f2110a.get(str);
        }
        m<com.airbnb.lottie.d> mVar = new m<>(callable);
        mVar.b(new a(str));
        mVar.a(new b(str));
        f2110a.put(str, mVar);
        return mVar;
    }

    private static String a(int i) {
        return "rawRes_" + i;
    }

    public static l<com.airbnb.lottie.d> b(Context context, int i) {
        try {
            return a(context.getResources().openRawResource(i), a(i));
        } catch (Resources.NotFoundException e2) {
            return new l<>(e2);
        }
    }

    public static l<com.airbnb.lottie.d> b(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(".zip") ? a(new ZipInputStream(context.getAssets().open(str)), str2) : a(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    public static l<com.airbnb.lottie.d> b(com.airbnb.lottie.w.k0.c cVar, String str) {
        return a(cVar, str, true);
    }

    private static l<com.airbnb.lottie.d> b(ZipInputStream zipInputStream, String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.d dVar = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (!name.contains("__MACOSX")) {
                    if (nextEntry.getName().contains(".json")) {
                        dVar = a(com.airbnb.lottie.w.k0.c.a(l.a(l.a(zipInputStream))), (String) null, false).b();
                    } else if (name.contains(".png") || name.contains(".webp")) {
                        hashMap.put(name.split("/")[split.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                    nextEntry = zipInputStream.getNextEntry();
                }
                zipInputStream.closeEntry();
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVar == null) {
                return new l<>(new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                com.airbnb.lottie.g a2 = a(dVar, (String) entry.getKey());
                if (a2 != null) {
                    a2.a(h.a((Bitmap) entry.getValue(), a2.e(), a2.c()));
                }
            }
            for (Map.Entry<String, com.airbnb.lottie.g> entry2 : dVar.h().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new l<>(new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            com.airbnb.lottie.u.g.a().a(str, dVar);
            return new l<>(dVar);
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    public static m<com.airbnb.lottie.d> c(Context context, String str) {
        return a("url_" + str, new c(context, str));
    }
}
