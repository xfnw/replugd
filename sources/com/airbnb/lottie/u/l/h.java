package com.airbnb.lottie.u.l;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.r;
import com.airbnb.lottie.s.c.n;
import com.airbnb.lottie.u.b;
import com.airbnb.lottie.u.j.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h extends com.airbnb.lottie.u.l.a {
    private final n D;
    private final f E;
    private final d F;
    private com.airbnb.lottie.s.c.a<Integer, Integer> G;
    private com.airbnb.lottie.s.c.a<Integer, Integer> H;
    private com.airbnb.lottie.s.c.a<Float, Float> I;
    private com.airbnb.lottie.s.c.a<Float, Float> J;
    private final StringBuilder w = new StringBuilder(2);
    private final RectF x = new RectF();
    private final Matrix y = new Matrix();
    private final Paint z = new a(this, 1);
    private final Paint A = new b(this, 1);
    private final Map<com.airbnb.lottie.u.d, List<com.airbnb.lottie.s.b.d>> B = new HashMap();
    private final a.d.d<String> C = new a.d.d<>();

    /* loaded from: classes.dex */
    class a extends Paint {
        a(h hVar, int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* loaded from: classes.dex */
    class b extends Paint {
        b(h hVar, int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2421a = new int[b.a.values().length];

        static {
            try {
                f2421a[b.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2421a[b.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2421a[b.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, d dVar) {
        super(fVar, dVar);
        com.airbnb.lottie.u.j.b bVar;
        com.airbnb.lottie.u.j.b bVar2;
        com.airbnb.lottie.u.j.a aVar;
        com.airbnb.lottie.u.j.a aVar2;
        this.E = fVar;
        this.F = dVar.a();
        this.D = dVar.q().a();
        this.D.a(this);
        a(this.D);
        k r = dVar.r();
        if (!(r == null || (aVar2 = r.f2296a) == null)) {
            this.G = aVar2.a();
            this.G.a(this);
            a(this.G);
        }
        if (!(r == null || (aVar = r.f2297b) == null)) {
            this.H = aVar.a();
            this.H.a(this);
            a(this.H);
        }
        if (!(r == null || (bVar2 = r.f2298c) == null)) {
            this.I = bVar2.a();
            this.I.a(this);
            a(this.I);
        }
        if (r != null && (bVar = r.f2299d) != null) {
            this.J = bVar.a();
            this.J.a(this);
            a(this.J);
        }
    }

    private float a(String str, com.airbnb.lottie.u.c cVar, float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < str.length(); i++) {
            com.airbnb.lottie.u.d b2 = this.F.b().b(com.airbnb.lottie.u.d.a(str.charAt(i), cVar.a(), cVar.c()));
            if (b2 != null) {
                double d2 = f3;
                double b3 = b2.b();
                double d3 = f;
                Double.isNaN(d3);
                double d4 = b3 * d3;
                double a2 = com.airbnb.lottie.x.h.a();
                Double.isNaN(a2);
                double d5 = d4 * a2;
                double d6 = f2;
                Double.isNaN(d6);
                Double.isNaN(d2);
                f3 = (float) (d2 + (d5 * d6));
            }
        }
        return f3;
    }

    private String a(String str, int i) {
        int codePointAt = str.codePointAt(i);
        int charCount = Character.charCount(codePointAt) + i;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!a(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j = codePointAt;
        if (this.C.a(j)) {
            return this.C.c(j);
        }
        this.w.setLength(0);
        while (i < charCount) {
            int codePointAt3 = str.codePointAt(i);
            this.w.appendCodePoint(codePointAt3);
            i += Character.charCount(codePointAt3);
        }
        String sb = this.w.toString();
        this.C.c(j, sb);
        return sb;
    }

    private List<com.airbnb.lottie.s.b.d> a(com.airbnb.lottie.u.d dVar) {
        if (this.B.containsKey(dVar)) {
            return this.B.get(dVar);
        }
        List<com.airbnb.lottie.u.k.n> a2 = dVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new com.airbnb.lottie.s.b.d(this.E, this, a2.get(i)));
        }
        this.B.put(dVar, arrayList);
        return arrayList;
    }

    private List<String> a(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private void a(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    private void a(b.a aVar, Canvas canvas, float f) {
        float f2;
        int i = c.f2421a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                f2 = -f;
            } else if (i == 3) {
                f2 = (-f) / 2.0f;
            } else {
                return;
            }
            canvas.translate(f2, 0.0f);
        }
    }

    private void a(com.airbnb.lottie.u.b bVar, Matrix matrix, com.airbnb.lottie.u.c cVar, Canvas canvas) {
        float f = ((float) bVar.f2268c) / 100.0f;
        float a2 = com.airbnb.lottie.x.h.a(matrix);
        String str = bVar.f2266a;
        float a3 = ((float) bVar.f) * com.airbnb.lottie.x.h.a();
        List<String> a4 = a(str);
        int size = a4.size();
        for (int i = 0; i < size; i++) {
            String str2 = a4.get(i);
            float a5 = a(str2, cVar, f, a2);
            canvas.save();
            a(bVar.f2269d, canvas, a5);
            canvas.translate(0.0f, (i * a3) - (((size - 1) * a3) / 2.0f));
            a(str2, bVar, matrix, cVar, canvas, a2, f);
            canvas.restore();
        }
    }

    private void a(com.airbnb.lottie.u.b bVar, com.airbnb.lottie.u.c cVar, Matrix matrix, Canvas canvas) {
        float a2 = com.airbnb.lottie.x.h.a(matrix);
        Typeface a3 = this.E.a(cVar.a(), cVar.c());
        if (a3 != null) {
            String str = bVar.f2266a;
            r p = this.E.p();
            if (p == null) {
                this.z.setTypeface(a3);
                Paint paint = this.z;
                double d2 = bVar.f2268c;
                double a4 = com.airbnb.lottie.x.h.a();
                Double.isNaN(a4);
                paint.setTextSize((float) (d2 * a4));
                this.A.setTypeface(this.z.getTypeface());
                this.A.setTextSize(this.z.getTextSize());
                float a5 = ((float) bVar.f) * com.airbnb.lottie.x.h.a();
                List<String> a6 = a(str);
                int size = a6.size();
                for (int i = 0; i < size; i++) {
                    String str2 = a6.get(i);
                    a(bVar.f2269d, canvas, this.A.measureText(str2));
                    canvas.translate(0.0f, (i * a5) - (((size - 1) * a5) / 2.0f));
                    a(str2, bVar, canvas, a2);
                    canvas.setMatrix(matrix);
                }
                return;
            }
            p.a(str);
            throw null;
        }
    }

    private void a(com.airbnb.lottie.u.d dVar, Matrix matrix, float f, com.airbnb.lottie.u.b bVar, Canvas canvas) {
        Paint paint;
        List<com.airbnb.lottie.s.b.d> a2 = a(dVar);
        for (int i = 0; i < a2.size(); i++) {
            Path c2 = a2.get(i).c();
            c2.computeBounds(this.x, false);
            this.y.set(matrix);
            this.y.preTranslate(0.0f, ((float) (-bVar.g)) * com.airbnb.lottie.x.h.a());
            this.y.preScale(f, f);
            c2.transform(this.y);
            if (bVar.k) {
                a(c2, this.z, canvas);
                paint = this.A;
            } else {
                a(c2, this.A, canvas);
                paint = this.z;
            }
            a(c2, paint, canvas);
        }
    }

    private void a(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    private void a(String str, com.airbnb.lottie.u.b bVar, Canvas canvas) {
        Paint paint;
        if (bVar.k) {
            a(str, this.z, canvas);
            paint = this.A;
        } else {
            a(str, this.A, canvas);
            paint = this.z;
        }
        a(str, paint, canvas);
    }

    private void a(String str, com.airbnb.lottie.u.b bVar, Canvas canvas, float f) {
        int i = 0;
        while (i < str.length()) {
            String a2 = a(str, i);
            i += a2.length();
            a(a2, bVar, canvas);
            float measureText = this.z.measureText(a2, 0, 1);
            float f2 = bVar.f2270e / 10.0f;
            com.airbnb.lottie.s.c.a<Float, Float> aVar = this.J;
            if (aVar != null) {
                f2 += aVar.f().floatValue();
            }
            canvas.translate(measureText + (f2 * f), 0.0f);
        }
    }

    private void a(String str, com.airbnb.lottie.u.b bVar, Matrix matrix, com.airbnb.lottie.u.c cVar, Canvas canvas, float f, float f2) {
        for (int i = 0; i < str.length(); i++) {
            com.airbnb.lottie.u.d b2 = this.F.b().b(com.airbnb.lottie.u.d.a(str.charAt(i), cVar.a(), cVar.c()));
            if (b2 != null) {
                a(b2, matrix, f2, bVar, canvas);
                float b3 = ((float) b2.b()) * f2 * com.airbnb.lottie.x.h.a() * f;
                float f3 = bVar.f2270e / 10.0f;
                com.airbnb.lottie.s.c.a<Float, Float> aVar = this.J;
                if (aVar != null) {
                    f3 += aVar.f().floatValue();
                }
                canvas.translate(b3 + (f3 * f), 0.0f);
            }
        }
    }

    private boolean a(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 19;
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.s.b.e
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.F.a().width(), this.F.a().height());
    }

    @Override // com.airbnb.lottie.u.l.a, com.airbnb.lottie.u.f
    public <T> void a(T t, com.airbnb.lottie.y.c<T> cVar) {
        com.airbnb.lottie.s.c.a<Float, Float> aVar;
        com.airbnb.lottie.s.c.a aVar2;
        super.a((h) t, (com.airbnb.lottie.y.c<h>) cVar);
        if ((t == com.airbnb.lottie.k.f2159a && (aVar2 = this.G) != null) || ((t == com.airbnb.lottie.k.f2160b && (aVar2 = this.H) != null) || (t == com.airbnb.lottie.k.o && (aVar2 = this.I) != null))) {
            aVar2.a(cVar);
        } else if (t == com.airbnb.lottie.k.p && (aVar = this.J) != null) {
            aVar.a((com.airbnb.lottie.y.c<Float>) cVar);
        }
    }

    @Override // com.airbnb.lottie.u.l.a
    void b(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        float f;
        canvas.save();
        if (!this.E.u()) {
            canvas.setMatrix(matrix);
        }
        com.airbnb.lottie.u.b f2 = this.D.f();
        com.airbnb.lottie.u.c cVar = this.F.f().get(f2.f2267b);
        if (cVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.s.c.a<Integer, Integer> aVar = this.G;
        if (aVar != null) {
            this.z.setColor(aVar.f().intValue());
        } else {
            this.z.setColor(f2.h);
        }
        com.airbnb.lottie.s.c.a<Integer, Integer> aVar2 = this.H;
        if (aVar2 != null) {
            this.A.setColor(aVar2.f().intValue());
        } else {
            this.A.setColor(f2.i);
        }
        int intValue = ((this.u.c() == null ? 100 : this.u.c().f().intValue()) * 255) / 100;
        this.z.setAlpha(intValue);
        this.A.setAlpha(intValue);
        com.airbnb.lottie.s.c.a<Float, Float> aVar3 = this.I;
        if (aVar3 != null) {
            paint = this.A;
            f = aVar3.f().floatValue();
        } else {
            float a2 = com.airbnb.lottie.x.h.a(matrix);
            paint = this.A;
            double d2 = f2.j;
            double a3 = com.airbnb.lottie.x.h.a();
            Double.isNaN(a3);
            double d3 = d2 * a3;
            double d4 = a2;
            Double.isNaN(d4);
            f = (float) (d3 * d4);
        }
        paint.setStrokeWidth(f);
        if (this.E.u()) {
            a(f2, matrix, cVar, canvas);
        } else {
            a(f2, cVar, matrix, canvas);
        }
        canvas.restore();
    }
}
