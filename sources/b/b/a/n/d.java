package b.b.a.n;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public class d extends Exception {

    /* renamed from: b  reason: collision with root package name */
    private int f1698b;

    /* renamed from: c  reason: collision with root package name */
    private String f1699c;

    public d(int i) {
        this.f1698b = i;
    }

    public d(int i, String str) {
        this.f1698b = i;
        this.f1699c = str;
    }

    public d(Exception exc) {
        this.f1698b = -200;
        this.f1699c = Log.getStackTraceString(exc);
    }

    public void a(Exception exc) {
        this.f1698b = -200;
        this.f1699c = Log.getStackTraceString(exc);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f1699c;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb;
        if (TextUtils.isEmpty(this.f1699c)) {
            sb = new StringBuilder();
            sb.append("EShareException <");
            sb.append(this.f1698b);
        } else {
            sb = new StringBuilder();
            sb.append("EShareException <");
            sb.append(this.f1698b);
            sb.append(" - ");
            sb.append(this.f1699c);
        }
        sb.append(">");
        return sb.toString();
    }
}
