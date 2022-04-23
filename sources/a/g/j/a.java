package a.g.j;

import a.g.k.c;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes.dex */
public class a implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    private final Spannable f269b;

    /* renamed from: c  reason: collision with root package name */
    private final C0009a f270c;

    /* renamed from: a.g.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0009a {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f271a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f272b;

        /* renamed from: c  reason: collision with root package name */
        private final int f273c;

        /* renamed from: d  reason: collision with root package name */
        private final int f274d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f275e = null;

        /* renamed from: a.g.j.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0010a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f276a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f277b;

            /* renamed from: c  reason: collision with root package name */
            private int f278c;

            /* renamed from: d  reason: collision with root package name */
            private int f279d;

            public C0010a(TextPaint textPaint) {
                this.f276a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f278c = 1;
                    this.f279d = 1;
                } else {
                    this.f279d = 0;
                    this.f278c = 0;
                }
                this.f277b = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public C0010a a(int i) {
                this.f278c = i;
                return this;
            }

            public C0010a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f277b = textDirectionHeuristic;
                return this;
            }

            public C0009a a() {
                return new C0009a(this.f276a, this.f277b, this.f278c, this.f279d);
            }

            public C0010a b(int i) {
                this.f279d = i;
                return this;
            }
        }

        public C0009a(PrecomputedText.Params params) {
            this.f271a = params.getTextPaint();
            this.f272b = params.getTextDirection();
            this.f273c = params.getBreakStrategy();
            this.f274d = params.getHyphenationFrequency();
        }

        C0009a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.f271a = textPaint;
            this.f272b = textDirectionHeuristic;
            this.f273c = i;
            this.f274d = i2;
        }

        public int a() {
            return this.f273c;
        }

        public boolean a(C0009a aVar) {
            PrecomputedText.Params params = this.f275e;
            if (params != null) {
                return params.equals(aVar.f275e);
            }
            if ((Build.VERSION.SDK_INT >= 23 && (this.f273c != aVar.a() || this.f274d != aVar.b())) || this.f271a.getTextSize() != aVar.d().getTextSize() || this.f271a.getTextScaleX() != aVar.d().getTextScaleX() || this.f271a.getTextSkewX() != aVar.d().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f271a.getLetterSpacing() != aVar.d().getLetterSpacing() || !TextUtils.equals(this.f271a.getFontFeatureSettings(), aVar.d().getFontFeatureSettings()))) || this.f271a.getFlags() != aVar.d().getFlags()) {
                return false;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                if (!this.f271a.getTextLocales().equals(aVar.d().getTextLocales())) {
                    return false;
                }
            } else if (i >= 17 && !this.f271a.getTextLocale().equals(aVar.d().getTextLocale())) {
                return false;
            }
            return this.f271a.getTypeface() == null ? aVar.d().getTypeface() == null : this.f271a.getTypeface().equals(aVar.d().getTypeface());
        }

        public int b() {
            return this.f274d;
        }

        public TextDirectionHeuristic c() {
            return this.f272b;
        }

        public TextPaint d() {
            return this.f271a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0009a)) {
                return false;
            }
            C0009a aVar = (C0009a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f272b == aVar.c();
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return c.a(Float.valueOf(this.f271a.getTextSize()), Float.valueOf(this.f271a.getTextScaleX()), Float.valueOf(this.f271a.getTextSkewX()), Float.valueOf(this.f271a.getLetterSpacing()), Integer.valueOf(this.f271a.getFlags()), this.f271a.getTextLocales(), this.f271a.getTypeface(), Boolean.valueOf(this.f271a.isElegantTextHeight()), this.f272b, Integer.valueOf(this.f273c), Integer.valueOf(this.f274d));
            }
            if (i >= 21) {
                return c.a(Float.valueOf(this.f271a.getTextSize()), Float.valueOf(this.f271a.getTextScaleX()), Float.valueOf(this.f271a.getTextSkewX()), Float.valueOf(this.f271a.getLetterSpacing()), Integer.valueOf(this.f271a.getFlags()), this.f271a.getTextLocale(), this.f271a.getTypeface(), Boolean.valueOf(this.f271a.isElegantTextHeight()), this.f272b, Integer.valueOf(this.f273c), Integer.valueOf(this.f274d));
            }
            if (i < 18 && i < 17) {
                return c.a(Float.valueOf(this.f271a.getTextSize()), Float.valueOf(this.f271a.getTextScaleX()), Float.valueOf(this.f271a.getTextSkewX()), Integer.valueOf(this.f271a.getFlags()), this.f271a.getTypeface(), this.f272b, Integer.valueOf(this.f273c), Integer.valueOf(this.f274d));
            }
            return c.a(Float.valueOf(this.f271a.getTextSize()), Float.valueOf(this.f271a.getTextScaleX()), Float.valueOf(this.f271a.getTextSkewX()), Integer.valueOf(this.f271a.getFlags()), this.f271a.getTextLocale(), this.f271a.getTypeface(), this.f272b, Integer.valueOf(this.f273c), Integer.valueOf(this.f274d));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00e3  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instructions count: 329
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a.g.j.a.C0009a.toString():java.lang.String");
        }
    }

    public C0009a a() {
        return this.f270c;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f269b.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f269b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f269b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f269b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.f269b.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f269b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f269b.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f269b.removeSpan(obj);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            this.f269b.setSpan(obj, i, i2, i3);
            return;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f269b.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f269b.toString();
    }
}
