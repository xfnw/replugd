package com.airbnb.lottie.u;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f2283a;

    /* renamed from: b  reason: collision with root package name */
    private f f2284b;

    private e(e eVar) {
        this.f2283a = new ArrayList(eVar.f2283a);
        this.f2284b = eVar.f2284b;
    }

    public e(String... strArr) {
        this.f2283a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f2283a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    public e a(f fVar) {
        e eVar = new e(this);
        eVar.f2284b = fVar;
        return eVar;
    }

    public e a(String str) {
        e eVar = new e(this);
        eVar.f2283a.add(str);
        return eVar;
    }

    public f a() {
        return this.f2284b;
    }

    public boolean a(String str, int i) {
        if (i >= this.f2283a.size()) {
            return false;
        }
        boolean z = i == this.f2283a.size() - 1;
        String str2 = this.f2283a.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.f2283a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f2283a.get(i + 1).equals(str)) {
            return i == this.f2283a.size() + (-2) || (i == this.f2283a.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f2283a.size() - 1) {
            return false;
        }
        return this.f2283a.get(i2).equals(str);
    }

    public int b(String str, int i) {
        if (b(str)) {
            return 0;
        }
        if (!this.f2283a.get(i).equals("**")) {
            return 1;
        }
        return (i != this.f2283a.size() - 1 && this.f2283a.get(i + 1).equals(str)) ? 2 : 0;
    }

    public boolean c(String str, int i) {
        if (b(str)) {
            return true;
        }
        if (i >= this.f2283a.size()) {
            return false;
        }
        return this.f2283a.get(i).equals(str) || this.f2283a.get(i).equals("**") || this.f2283a.get(i).equals("*");
    }

    public boolean d(String str, int i) {
        return "__container".equals(str) || i < this.f2283a.size() - 1 || this.f2283a.get(i).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f2283a);
        sb.append(",resolved=");
        sb.append(this.f2284b != null);
        sb.append('}');
        return sb.toString();
    }
}
