package d.f0.i;

import e.e;
import java.util.List;

/* loaded from: classes.dex */
public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f3607a = new a();

    /* loaded from: classes.dex */
    class a implements l {
        a() {
        }

        @Override // d.f0.i.l
        public void a(int i, b bVar) {
        }

        @Override // d.f0.i.l
        public boolean a(int i, e eVar, int i2, boolean z) {
            eVar.skip(i2);
            return true;
        }

        @Override // d.f0.i.l
        public boolean a(int i, List<c> list) {
            return true;
        }

        @Override // d.f0.i.l
        public boolean a(int i, List<c> list, boolean z) {
            return true;
        }
    }

    void a(int i, b bVar);

    boolean a(int i, e eVar, int i2, boolean z);

    boolean a(int i, List<c> list);

    boolean a(int i, List<c> list, boolean z);
}
