package a.g.i;

import a.g.e.i;
import a.g.i.c;
import a.g.k.h;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.c.f;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final a.d.e<String, Typeface> f233a = new a.d.e<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final a.g.i.c f234b = new a.g.i.c("fonts", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f235c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final a.d.g<String, ArrayList<c.d<g>>> f236d = new a.d.g<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<byte[]> f237e = new d();

    /* loaded from: classes.dex */
    static class a implements Callable<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f238a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a.g.i.a f239b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f240c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f241d;

        a(Context context, a.g.i.a aVar, int i, String str) {
            this.f238a = context;
            this.f239b = aVar;
            this.f240c = i;
            this.f241d = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public g call() {
            g a2 = b.a(this.f238a, this.f239b, this.f240c);
            Typeface typeface = a2.f252a;
            if (typeface != null) {
                b.f233a.a(this.f241d, typeface);
            }
            return a2;
        }
    }

    /* renamed from: a.g.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0007b implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f.a f242a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Handler f243b;

        C0007b(f.a aVar, Handler handler) {
            this.f242a = aVar;
            this.f243b = handler;
        }

        public void a(g gVar) {
            int i;
            f.a aVar;
            if (gVar == null) {
                aVar = this.f242a;
                i = 1;
            } else {
                i = gVar.f253b;
                if (i == 0) {
                    this.f242a.a(gVar.f252a, this.f243b);
                    return;
                }
                aVar = this.f242a;
            }
            aVar.a(i, this.f243b);
        }
    }

    /* loaded from: classes.dex */
    static class c implements c.d<g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f244a;

        c(String str) {
            this.f244a = str;
        }

        public void a(g gVar) {
            synchronized (b.f235c) {
                ArrayList<c.d<g>> arrayList = b.f236d.get(this.f244a);
                if (arrayList != null) {
                    b.f236d.remove(this.f244a);
                    for (int i = 0; i < arrayList.size(); i++) {
                        arrayList.get(i).a(gVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    static class d implements Comparator<byte[]> {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private final int f245a;

        /* renamed from: b  reason: collision with root package name */
        private final f[] f246b;

        public e(int i, f[] fVarArr) {
            this.f245a = i;
            this.f246b = fVarArr;
        }

        public f[] a() {
            return this.f246b;
        }

        public int b() {
            return this.f245a;
        }
    }

    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f247a;

        /* renamed from: b  reason: collision with root package name */
        private final int f248b;

        /* renamed from: c  reason: collision with root package name */
        private final int f249c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f250d;

        /* renamed from: e  reason: collision with root package name */
        private final int f251e;

        public f(Uri uri, int i, int i2, boolean z, int i3) {
            h.a(uri);
            this.f247a = uri;
            this.f248b = i;
            this.f249c = i2;
            this.f250d = z;
            this.f251e = i3;
        }

        public int a() {
            return this.f251e;
        }

        public int b() {
            return this.f248b;
        }

        public Uri c() {
            return this.f247a;
        }

        public int d() {
            return this.f249c;
        }

        public boolean e() {
            return this.f250d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f252a;

        /* renamed from: b  reason: collision with root package name */
        final int f253b;

        g(Typeface typeface, int i) {
            this.f252a = typeface;
            this.f253b = i;
        }
    }

    public static e a(Context context, CancellationSignal cancellationSignal, a.g.i.a aVar) {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        return a2 == null ? new e(1, null) : new e(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    static g a(Context context, a.g.i.a aVar, int i) {
        try {
            e a2 = a(context, (CancellationSignal) null, aVar);
            int i2 = -3;
            if (a2.b() == 0) {
                Typeface a3 = a.g.e.c.a(context, null, a2.a(), i);
                if (a3 != null) {
                    i2 = 0;
                }
                return new g(a3, i2);
            }
            if (a2.b() == 1) {
                i2 = -2;
            }
            return new g(null, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new g(null, -1);
        }
    }

    public static ProviderInfo a(PackageManager packageManager, a.g.i.a aVar, Resources resources) {
        String d2 = aVar.d();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(d2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + d2);
        } else if (resolveContentProvider.packageName.equals(aVar.e())) {
            List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a2, f237e);
            List<List<byte[]>> a3 = a(aVar, resources);
            for (int i = 0; i < a3.size(); i++) {
                ArrayList arrayList = new ArrayList(a3.get(i));
                Collections.sort(arrayList, f237e);
                if (a(a2, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        } else {
            throw new PackageManager.NameNotFoundException("Found content provider " + d2 + ", but package was not " + aVar.e());
        }
    }

    public static Typeface a(Context context, a.g.i.a aVar, f.a aVar2, Handler handler, boolean z, int i, int i2) {
        String str = aVar.c() + "-" + i2;
        Typeface b2 = f233a.b(str);
        if (b2 != null) {
            if (aVar2 != null) {
                aVar2.a(b2);
            }
            return b2;
        } else if (!z || i != -1) {
            a aVar3 = new a(context, aVar, i2, str);
            if (z) {
                try {
                    return ((g) f234b.a(aVar3, i)).f252a;
                } catch (InterruptedException unused) {
                    return null;
                }
            } else {
                C0007b bVar = aVar2 == null ? null : new C0007b(aVar2, handler);
                synchronized (f235c) {
                    if (f236d.containsKey(str)) {
                        if (bVar != null) {
                            f236d.get(str).add(bVar);
                        }
                        return null;
                    }
                    if (bVar != null) {
                        ArrayList<c.d<g>> arrayList = new ArrayList<>();
                        arrayList.add(bVar);
                        f236d.put(str, arrayList);
                    }
                    f234b.a(aVar3, new c(str));
                    return null;
                }
            }
        } else {
            g a2 = a(context, aVar, i2);
            if (aVar2 != null) {
                int i3 = a2.f253b;
                if (i3 == 0) {
                    aVar2.a(a2.f252a, handler);
                } else {
                    aVar2.a(i3, handler);
                }
            }
            return a2.f252a;
        }
    }

    private static List<List<byte[]>> a(a.g.i.a aVar, Resources resources) {
        return aVar.a() != null ? aVar.a() : androidx.core.content.c.c.a(resources, aVar.b());
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static Map<Uri, ByteBuffer> a(Context context, f[] fVarArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (f fVar : fVarArr) {
            if (fVar.a() == 0) {
                Uri c2 = fVar.c();
                if (!hashMap.containsKey(c2)) {
                    hashMap.put(c2, i.a(context, cancellationSignal, c2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static a.g.i.b.f[] a(android.content.Context r19, a.g.i.a r20, java.lang.String r21, android.os.CancellationSignal r22) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g.i.b.a(android.content.Context, a.g.i.a, java.lang.String, android.os.CancellationSignal):a.g.i.b$f[]");
    }
}
