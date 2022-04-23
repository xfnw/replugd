package b.a.a;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* loaded from: classes.dex */
public class k extends i implements Comparable<Object> {

    /* renamed from: c  reason: collision with root package name */
    private static CharsetEncoder f1623c;

    /* renamed from: d  reason: collision with root package name */
    private static CharsetEncoder f1624d;

    /* renamed from: b  reason: collision with root package name */
    private String f1625b;

    public k(String str) {
        this.f1625b = str;
    }

    public k(byte[] bArr, int i, int i2, String str) {
        this.f1625b = new String(bArr, i, i2 - i, str);
    }

    public String a() {
        return this.f1625b;
    }

    @Override // b.a.a.i
    public void b(c cVar) {
        int i;
        CharsetEncoder charsetEncoder;
        ByteBuffer encode;
        CharBuffer wrap = CharBuffer.wrap(this.f1625b);
        synchronized (k.class) {
            if (f1623c == null) {
                f1623c = Charset.forName("ASCII").newEncoder();
            } else {
                f1623c.reset();
            }
            if (f1623c.canEncode(wrap)) {
                i = 5;
                charsetEncoder = f1623c;
            } else {
                if (f1624d == null) {
                    f1624d = Charset.forName("UTF-16BE").newEncoder();
                } else {
                    f1624d.reset();
                }
                i = 6;
                charsetEncoder = f1624d;
            }
            encode = charsetEncoder.encode(wrap);
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        cVar.a(i, this.f1625b.length());
        cVar.a(bArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        String a2;
        String str;
        if (obj instanceof k) {
            a2 = a();
            str = ((k) obj).a();
        } else if (!(obj instanceof String)) {
            return -1;
        } else {
            a2 = a();
            str = (String) obj;
        }
        return a2.compareTo(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        return this.f1625b.equals(((k) obj).f1625b);
    }

    public int hashCode() {
        return this.f1625b.hashCode();
    }

    public String toString() {
        return this.f1625b;
    }
}
