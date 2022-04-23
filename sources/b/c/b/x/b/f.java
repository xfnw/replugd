package b.c.b.x.b;

/* loaded from: classes.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    
    private static final f[] f;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i) {
    }

    public static f a(int i) {
        if (i >= 0) {
            f[] fVarArr = f;
            if (i < fVarArr.length) {
                return fVarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
