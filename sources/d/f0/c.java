package d.f0;

import android.support.v4.media.session.PlaybackStateCompat;
import d.b0;
import d.r;
import d.s;
import d.z;
import e.f;
import e.t;
import e.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f3403a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f3404b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final b0 f3405c = b0.a(null, f3403a);

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f3406d = Charset.forName("UTF-8");

    /* renamed from: e  reason: collision with root package name */
    public static final TimeZone f3407e = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> f = new a();
    private static final Method g;
    private static final Pattern h;

    /* loaded from: classes.dex */
    class a implements Comparator<String> {
        a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* loaded from: classes.dex */
    class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f3408a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f3409b;

        b(String str, boolean z) {
            this.f3408a = str;
            this.f3409b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f3408a);
            thread.setDaemon(this.f3409b);
            return thread;
        }
    }

    static {
        Method method = null;
        z.a(null, f3403a);
        f.b("efbbbf");
        f.b("feff");
        f.b("fffe");
        f.b("0000ffff");
        f.b("ffff0000");
        Charset.forName("ISO-8859-1");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        g = method;
        h = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static int a(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int a(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String a(s sVar, boolean z) {
        String str;
        if (sVar.g().contains(":")) {
            str = "[" + sVar.g() + "]";
        } else {
            str = sVar.g();
        }
        if (!z && sVar.j() == s.c(sVar.m())) {
            return str;
        }
        return str + ":" + sVar.j();
    }

    public static String a(String str) {
        if (str.contains(":")) {
            InetAddress a2 = (!str.startsWith("[") || !str.endsWith("]")) ? a(str, 0, str.length()) : a(str, 1, str.length() - 1);
            if (a2 == null) {
                return null;
            }
            byte[] address = a2.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (b(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static String a(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (i2 < bArr.length) {
            int i5 = i2;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i2;
            if (i6 > i4 && i6 >= 4) {
                i3 = i2;
                i4 = i6;
            }
            i2 = i5 + 2;
        }
        e.c cVar = new e.c();
        while (i < bArr.length) {
            if (i == i3) {
                cVar.writeByte(58);
                i += i4;
                if (i == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i > 0) {
                    cVar.writeByte(58);
                }
                cVar.a(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return cVar.q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress a(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L_0x0009:
            r6 = 0
            if (r11 >= r12) goto L_0x007b
            int r7 = r0.length
            if (r3 != r7) goto L_0x0010
            return r6
        L_0x0010:
            int r7 = r11 + 2
            if (r7 > r12) goto L_0x0028
            r8 = 2
            java.lang.String r9 = "::"
            boolean r8 = r10.regionMatches(r11, r9, r2, r8)
            if (r8 == 0) goto L_0x0028
            if (r4 == r1) goto L_0x0020
            return r6
        L_0x0020:
            int r3 = r3 + 2
            r4 = r3
            if (r7 != r12) goto L_0x0026
            goto L_0x007b
        L_0x0026:
            r5 = r7
            goto L_0x004c
        L_0x0028:
            if (r3 == 0) goto L_0x004b
            r7 = 1
            java.lang.String r8 = ":"
            boolean r8 = r10.regionMatches(r11, r8, r2, r7)
            if (r8 == 0) goto L_0x0036
            int r11 = r11 + 1
            goto L_0x004b
        L_0x0036:
            java.lang.String r8 = "."
            boolean r11 = r10.regionMatches(r11, r8, r2, r7)
            if (r11 == 0) goto L_0x004a
            int r11 = r3 + (-2)
            boolean r10 = a(r10, r5, r12, r0, r11)
            if (r10 != 0) goto L_0x0047
            return r6
        L_0x0047:
            int r3 = r3 + 2
            goto L_0x007b
        L_0x004a:
            return r6
        L_0x004b:
            r5 = r11
        L_0x004c:
            r11 = r5
            r7 = 0
        L_0x004e:
            if (r11 >= r12) goto L_0x0061
            char r8 = r10.charAt(r11)
            int r8 = a(r8)
            if (r8 != r1) goto L_0x005b
            goto L_0x0061
        L_0x005b:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L_0x004e
        L_0x0061:
            int r8 = r11 - r5
            if (r8 == 0) goto L_0x007a
            r9 = 4
            if (r8 <= r9) goto L_0x0069
            goto L_0x007a
        L_0x0069:
            int r6 = r3 + 1
            int r8 = r7 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r0[r3] = r8
            int r3 = r6 + 1
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r6] = r7
            goto L_0x0009
        L_0x007a:
            return r6
        L_0x007b:
            int r10 = r0.length
            if (r3 == r10) goto L_0x008e
            if (r4 != r1) goto L_0x0081
            return r6
        L_0x0081:
            int r10 = r0.length
            int r11 = r3 - r4
            int r10 = r10 - r11
            java.lang.System.arraycopy(r0, r4, r0, r10, r11)
            int r10 = r0.length
            int r10 = r10 - r3
            int r10 = r10 + r4
            java.util.Arrays.fill(r0, r4, r10, r2)
        L_0x008e:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: UnknownHostException -> 0x0093
            return r10
        L_0x0093:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            goto L_0x009a
        L_0x0099:
            throw r10
        L_0x009a:
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f0.c.a(java.lang.String, int, int):java.net.InetAddress");
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new b(str, z);
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw a("No System TLS", (Exception) e2);
        }
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = g;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(t tVar, int i, TimeUnit timeUnit) {
        try {
            return b(tVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            i4++;
            bArr[i4] = (byte) i6;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int b(String str, int i, int i2) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static r b(List<d.f0.i.c> list) {
        r.a aVar = new r.a();
        for (d.f0.i.c cVar : list) {
            d.f0.a.f3401a.a(aVar, cVar.f3510a.j(), cVar.f3511b.j());
        }
        return aVar.a();
    }

    public static boolean b(t tVar, int i, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c2 = tVar.b().d() ? tVar.b().c() - nanoTime : Long.MAX_VALUE;
        tVar.b().a(Math.min(c2, timeUnit.toNanos(i)) + nanoTime);
        try {
            e.c cVar = new e.c();
            while (tVar.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.n();
            }
            int i2 = (c2 > Long.MAX_VALUE ? 1 : (c2 == Long.MAX_VALUE ? 0 : -1));
            u b2 = tVar.b();
            if (i2 == 0) {
                b2.a();
            } else {
                b2.a(nanoTime + c2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i3 = (c2 > Long.MAX_VALUE ? 1 : (c2 == Long.MAX_VALUE ? 0 : -1));
            u b3 = tVar.b();
            if (i3 == 0) {
                b3.a();
            } else {
                b3.a(nanoTime + c2);
            }
            return false;
        } catch (Throwable th) {
            int i4 = (c2 > Long.MAX_VALUE ? 1 : (c2 == Long.MAX_VALUE ? 0 : -1));
            u b4 = tVar.b();
            if (i4 == 0) {
                b4.a();
            } else {
                b4.a(nanoTime + c2);
            }
            throw th;
        }
    }

    private static boolean b(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int c(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static int c(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char charAt = str.charAt(i3);
            if (!(charAt == '\t' || charAt == '\n' || charAt == '\f' || charAt == '\r' || charAt == ' ')) {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String d(String str, int i, int i2) {
        int b2 = b(str, i, i2);
        return str.substring(b2, c(str, b2, i2));
    }

    public static boolean d(String str) {
        return h.matcher(str).matches();
    }
}
