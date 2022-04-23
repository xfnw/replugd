package b.c.b.x.b;

import b.c.b.o;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2053a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z) {
        this.f2053a = z;
    }

    public void a(o[] oVarArr) {
        if (this.f2053a && oVarArr != null && oVarArr.length >= 3) {
            o oVar = oVarArr[0];
            oVarArr[0] = oVarArr[2];
            oVarArr[2] = oVar;
        }
    }
}
