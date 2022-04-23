package b.c.b.x.b;

import b.c.b.f;
import b.c.b.r.c;
import b.c.b.r.e;
import b.c.b.r.l;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f2039a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2040a = new int[h.values().length];

        static {
            try {
                f2040a[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2040a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2040a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2040a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2040a[h.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2040a[h.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2040a[h.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2040a[h.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2040a[h.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2040a[h.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static char a(int i) {
        char[] cArr = f2039a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw f.a();
    }

    private static int a(c cVar) {
        int a2 = cVar.a(8);
        if ((a2 & 128) == 0) {
            return a2 & 127;
        }
        if ((a2 & 192) == 128) {
            return cVar.a(8) | ((a2 & 63) << 8);
        }
        if ((a2 & 224) == 192) {
            return cVar.a(16) | ((a2 & 31) << 16);
        }
        throw f.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static e a(byte[] bArr, j jVar, f fVar, Map<b.c.b.e, ?> map) {
        h hVar;
        c cVar = new c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        b.c.b.r.d dVar = null;
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            try {
                h a2 = cVar.a() < 4 ? h.TERMINATOR : h.a(cVar.a(4));
                switch (a.f2040a[a2.ordinal()]) {
                    case 5:
                        hVar = a2;
                        break;
                    case 6:
                    case 7:
                        hVar = a2;
                        z = true;
                        break;
                    case 8:
                        if (cVar.a() >= 16) {
                            i2 = cVar.a(8);
                            i3 = cVar.a(8);
                            hVar = a2;
                            break;
                        } else {
                            throw f.a();
                        }
                    case 9:
                        dVar = b.c.b.r.d.a(a(cVar));
                        if (dVar == null) {
                            throw f.a();
                        }
                        hVar = a2;
                        break;
                    case 10:
                        int a3 = cVar.a(4);
                        int a4 = cVar.a(a2.a(jVar));
                        if (a3 == i) {
                            a(cVar, sb, a4);
                        }
                        hVar = a2;
                        break;
                    default:
                        int a5 = cVar.a(a2.a(jVar));
                        int i4 = a.f2040a[a2.ordinal()];
                        if (i4 != i) {
                            if (i4 != 2) {
                                if (i4 == 3) {
                                    hVar = a2;
                                    a(cVar, sb, a5, dVar, arrayList, map);
                                    break;
                                } else if (i4 == 4) {
                                    b(cVar, sb, a5);
                                    hVar = a2;
                                    break;
                                } else {
                                    throw f.a();
                                }
                            } else {
                                hVar = a2;
                                a(cVar, sb, a5, z);
                                break;
                            }
                        } else {
                            hVar = a2;
                            c(cVar, sb, a5);
                            break;
                        }
                }
                if (hVar == h.TERMINATOR) {
                    return new e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i2, i3);
                }
                i = 1;
            } catch (IllegalArgumentException unused) {
                throw f.a();
            }
        }
    }

    private static void a(c cVar, StringBuilder sb, int i) {
        if (i * 13 <= cVar.a()) {
            byte[] bArr = new byte[i * 2];
            int i2 = 0;
            while (i > 0) {
                int a2 = cVar.a(13);
                int i3 = (a2 % 96) | ((a2 / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i, b.c.b.r.d dVar, Collection<byte[]> collection, Map<b.c.b.e, ?> map) {
        if ((i << 3) <= cVar.a()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) cVar.a(8);
            }
            try {
                sb.append(new String(bArr, dVar == null ? l.a(bArr, map) : dVar.name()));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static void a(c cVar, StringBuilder sb, int i, boolean z) {
        while (i > 1) {
            if (cVar.a() >= 11) {
                int a2 = cVar.a(11);
                sb.append(a(a2 / 45));
                sb.append(a(a2 % 45));
                i -= 2;
            } else {
                throw f.a();
            }
        }
        if (i == 1) {
            if (cVar.a() >= 6) {
                sb.append(a(cVar.a(6)));
            } else {
                throw f.a();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void b(c cVar, StringBuilder sb, int i) {
        if (i * 13 <= cVar.a()) {
            byte[] bArr = new byte[i * 2];
            int i2 = 0;
            while (i > 0) {
                int a2 = cVar.a(13);
                int i3 = (a2 % 192) | ((a2 / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw f.a();
            }
        } else {
            throw f.a();
        }
    }

    private static void c(c cVar, StringBuilder sb, int i) {
        while (i >= 3) {
            if (cVar.a() >= 10) {
                int a2 = cVar.a(10);
                if (a2 < 1000) {
                    sb.append(a(a2 / 100));
                    sb.append(a((a2 / 10) % 10));
                    sb.append(a(a2 % 10));
                    i -= 3;
                } else {
                    throw f.a();
                }
            } else {
                throw f.a();
            }
        }
        if (i == 2) {
            if (cVar.a() >= 7) {
                int a3 = cVar.a(7);
                if (a3 < 100) {
                    sb.append(a(a3 / 10));
                    sb.append(a(a3 % 10));
                    return;
                }
                throw f.a();
            }
            throw f.a();
        } else if (i != 1) {
        } else {
            if (cVar.a() >= 4) {
                int a4 = cVar.a(4);
                if (a4 < 10) {
                    sb.append(a(a4));
                    return;
                }
                throw f.a();
            }
            throw f.a();
        }
    }
}
