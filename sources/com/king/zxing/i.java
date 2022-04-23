package com.king.zxing;

import b.c.b.a;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<a> f3296d = EnumSet.of(a.QR_CODE);

    /* renamed from: e  reason: collision with root package name */
    public static final Set<a> f3297e = EnumSet.of(a.DATA_MATRIX);
    public static final Set<a> f = EnumSet.of(a.AZTEC);
    public static final Set<a> g = EnumSet.of(a.PDF_417);

    /* renamed from: a  reason: collision with root package name */
    public static final Set<a> f3293a = EnumSet.of(a.UPC_A, a.UPC_E, a.EAN_13, a.EAN_8, a.RSS_14, a.RSS_EXPANDED);

    /* renamed from: b  reason: collision with root package name */
    public static final Set<a> f3294b = EnumSet.of(a.CODE_39, a.CODE_93, a.CODE_128, a.ITF, a.CODABAR);

    /* renamed from: c  reason: collision with root package name */
    public static final Set<a> f3295c = EnumSet.copyOf(f3293a);
    private static final Map<String, Set<a>> h = new HashMap();

    static {
        Pattern.compile(",");
        f3295c.addAll(f3294b);
        h.put("ONE_D_MODE", f3295c);
        h.put("PRODUCT_MODE", f3293a);
        h.put("QR_CODE_MODE", f3296d);
        h.put("DATA_MATRIX_MODE", f3297e);
        h.put("AZTEC_MODE", f);
        h.put("PDF417_MODE", g);
    }
}
