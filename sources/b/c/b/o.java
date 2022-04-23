package b.c.b;

import b.c.b.r.m.a;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final float f1788a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1789b;

    public o(float f, float f2) {
        this.f1788a = f;
        this.f1789b = f2;
    }

    public static float a(o oVar, o oVar2) {
        return a.a(oVar.f1788a, oVar.f1789b, oVar2.f1788a, oVar2.f1789b);
    }

    private static float a(o oVar, o oVar2, o oVar3) {
        float f = oVar2.f1788a;
        float f2 = oVar2.f1789b;
        return ((oVar3.f1788a - f) * (oVar.f1789b - f2)) - ((oVar3.f1789b - f2) * (oVar.f1788a - f));
    }

    public static void a(o[] oVarArr) {
        o oVar;
        o oVar2;
        o oVar3;
        float a2 = a(oVarArr[0], oVarArr[1]);
        float a3 = a(oVarArr[1], oVarArr[2]);
        float a4 = a(oVarArr[0], oVarArr[2]);
        if (a3 >= a2 && a3 >= a4) {
            oVar3 = oVarArr[0];
            oVar2 = oVarArr[1];
            oVar = oVarArr[2];
        } else if (a4 < a3 || a4 < a2) {
            oVar3 = oVarArr[2];
            oVar2 = oVarArr[0];
            oVar = oVarArr[1];
        } else {
            oVar3 = oVarArr[1];
            oVar2 = oVarArr[0];
            oVar = oVarArr[2];
        }
        if (a(oVar2, oVar3, oVar) < 0.0f) {
            oVar = oVar2;
            oVar2 = oVar;
        }
        oVarArr[0] = oVar2;
        oVarArr[1] = oVar3;
        oVarArr[2] = oVar;
    }

    public final float a() {
        return this.f1788a;
    }

    public final float b() {
        return this.f1789b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f1788a == oVar.f1788a && this.f1789b == oVar.f1789b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f1788a) * 31) + Float.floatToIntBits(this.f1789b);
    }

    public final String toString() {
        return "(" + this.f1788a + ',' + this.f1789b + ')';
    }
}
