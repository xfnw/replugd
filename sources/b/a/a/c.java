package b.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f1606a;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f1607b;

    /* renamed from: c  reason: collision with root package name */
    private long f1608c;

    /* renamed from: d  reason: collision with root package name */
    private Map<i, Integer> f1609d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private int f1610e;

    c(OutputStream outputStream, int i) {
        this.f1606a = 0;
        this.f1606a = i;
        this.f1607b = new BufferedOutputStream(outputStream);
    }

    public static void a(OutputStream outputStream, i iVar) {
        int d2 = d(iVar);
        if (d2 > 0) {
            String str = d2 != 10 ? d2 != 15 ? d2 == 20 ? "v2.0" : "v0.0" : "v1.5" : "v1.0";
            throw new IOException("The given property list structure cannot be saved. The required version of the binary format (" + str + ") is not yet supported.");
        }
        new c(outputStream, d2).c(iVar);
    }

    private int b(long j) {
        if (j < 256) {
            return 1;
        }
        if (j < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            return 2;
        }
        return j < 4294967296L ? 4 : 8;
    }

    private static int c(int i) {
        if (i < 256) {
            return 1;
        }
        return i < 65536 ? 2 : 4;
    }

    private static int d(i iVar) {
        int i = 10;
        int i2 = 0;
        int i3 = iVar == null ? 10 : 0;
        if (iVar instanceof g) {
            for (i iVar2 : ((g) iVar).a().values()) {
                int d2 = d(iVar2);
                if (d2 > i3) {
                    i3 = d2;
                }
            }
            return i3;
        } else if (iVar instanceof d) {
            i[] b2 = ((d) iVar).b();
            int length = b2.length;
            while (i2 < length) {
                int d3 = d(b2[i2]);
                if (d3 > i3) {
                    i3 = d3;
                }
                i2++;
            }
            return i3;
        } else if (!(iVar instanceof j)) {
            return i3;
        } else {
            i[] a2 = ((j) iVar).a();
            int length2 = a2.length;
            while (i2 < length2) {
                int d4 = d(a2[i2]);
                if (d4 > i) {
                    i = d4;
                }
                i2++;
            }
            return i;
        }
    }

    public static byte[] e(i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(byteArrayOutputStream, iVar);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d2) {
        a(Double.doubleToRawLongBits(d2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f1607b.write(i);
        this.f1608c++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        long j;
        int i3;
        if (i2 < 15) {
            a((i << 4) + i2);
            return;
        }
        if (i2 < 256) {
            a((i << 4) + 15);
            a(16);
            j = i2;
            i3 = 1;
        } else {
            a((i << 4) + 15);
            if (i2 < 65536) {
                a(17);
                j = i2;
                i3 = 2;
            } else {
                a(18);
                a(i2, 4);
                return;
            }
        }
        a(j, i3);
    }

    void a(long j) {
        a(j, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j, int i) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            a((int) (j >> (i2 * 8)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar) {
        if (!this.f1609d.containsKey(iVar)) {
            Map<i, Integer> map = this.f1609d;
            map.put(iVar, Integer.valueOf(map.size()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        this.f1607b.write(bArr);
        this.f1608c += bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(i iVar) {
        return this.f1609d.get(iVar).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        a(i, this.f1610e);
    }

    void c(i iVar) {
        int i;
        a(new byte[]{98, 112, 108, 105, 115, 116});
        int i2 = this.f1606a;
        if (i2 == 0) {
            a(new byte[]{48, 48});
        } else if (i2 == 10) {
            a(new byte[]{49, 48});
        } else if (i2 == 15) {
            a(new byte[]{49, 53});
        } else if (i2 == 20) {
            a(new byte[]{50, 48});
        }
        iVar.a(this);
        this.f1610e = c(this.f1609d.size());
        long[] jArr = new long[this.f1609d.size()];
        Iterator<Map.Entry<i, Integer>> it = this.f1609d.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<i, Integer> next = it.next();
            i key = next.getKey();
            jArr[next.getValue().intValue()] = this.f1608c;
            if (key == null) {
                a(0);
            } else {
                key.b(this);
            }
        }
        long j = this.f1608c;
        int b2 = b(j);
        for (long j2 : jArr) {
            a(j2, b2);
        }
        if (this.f1606a != 15) {
            a(new byte[6]);
            a(b2);
            a(this.f1610e);
            a(this.f1609d.size());
            a(this.f1609d.get(iVar).intValue());
            a(j);
        }
        this.f1607b.flush();
    }
}
