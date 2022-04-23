package androidx.core.content.c;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0038c[] f1195a;

        public b(C0038c[] cVarArr) {
            this.f1195a = cVarArr;
        }

        public C0038c[] a() {
            return this.f1195a;
        }
    }

    /* renamed from: androidx.core.content.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0038c {

        /* renamed from: a  reason: collision with root package name */
        private final String f1196a;

        /* renamed from: b  reason: collision with root package name */
        private int f1197b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1198c;

        /* renamed from: d  reason: collision with root package name */
        private String f1199d;

        /* renamed from: e  reason: collision with root package name */
        private int f1200e;
        private int f;

        public C0038c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1196a = str;
            this.f1197b = i;
            this.f1198c = z;
            this.f1199d = str2;
            this.f1200e = i2;
            this.f = i3;
        }

        public String a() {
            return this.f1196a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.f1200e;
        }

        public String d() {
            return this.f1199d;
        }

        public int e() {
            return this.f1197b;
        }

        public boolean f() {
            return this.f1198c;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final a.g.i.a f1201a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1202b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1203c;

        public d(a.g.i.a aVar, int i, int i2) {
            this.f1201a = aVar;
            this.f1203c = i;
            this.f1202b = i2;
        }

        public int a() {
            return this.f1203c;
        }

        public a.g.i.a b() {
            return this.f1201a;
        }

        public int c() {
            return this.f1202b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.g.d.FontFamily);
        String string = obtainAttributes.getString(a.g.d.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(a.g.d.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(a.g.d.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(a.g.d.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(a.g.d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(a.g.d.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(d(xmlPullParser, resources));
                    } else {
                        a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((C0038c[]) arrayList.toArray(new C0038c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new d(new a.g.i.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
    }

    private static C0038c d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.g.d.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(a.g.d.FontFamilyFont_fontWeight) ? a.g.d.FontFamilyFont_fontWeight : a.g.d.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(a.g.d.FontFamilyFont_fontStyle) ? a.g.d.FontFamilyFont_fontStyle : a.g.d.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(a.g.d.FontFamilyFont_ttcIndex) ? a.g.d.FontFamilyFont_ttcIndex : a.g.d.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(a.g.d.FontFamilyFont_fontVariationSettings) ? a.g.d.FontFamilyFont_fontVariationSettings : a.g.d.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(a.g.d.FontFamilyFont_font) ? a.g.d.FontFamilyFont_font : a.g.d.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0038c(string2, i, z, string, i3, resourceId);
    }
}
