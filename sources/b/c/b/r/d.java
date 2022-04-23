package b.c.b.r;

import b.c.b.f;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum d {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");
    
    private static final Map<Integer, d> E = new HashMap();
    private static final Map<String, d> F = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1821b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f1822c;

    static {
        d[] values;
        for (d dVar : values()) {
            for (int i : dVar.f1821b) {
                E.put(Integer.valueOf(i), dVar);
            }
            F.put(dVar.name(), dVar);
            for (String str : dVar.f1822c) {
                F.put(str, dVar);
            }
        }
    }

    d(int i) {
        this(new int[]{i}, new String[0]);
    }

    d(int i, String... strArr) {
        this.f1821b = new int[]{i};
        this.f1822c = strArr;
    }

    d(int[] iArr, String... strArr) {
        this.f1821b = iArr;
        this.f1822c = strArr;
    }

    public static d a(int i) {
        if (i >= 0 && i < 900) {
            return E.get(Integer.valueOf(i));
        }
        throw f.a();
    }
}
