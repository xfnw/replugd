package a.p;

import a.p.a;
import a.p.m;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class i0 extends m {
    private static final String[] L = {"android:visibility:visibility", "android:visibility:parent"};
    private int K = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f562b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f563c;

        a(i0 i0Var, w wVar, View view) {
            this.f562b = wVar;
            this.f563c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f562b.b(this.f563c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.AbstractC0025a {

        /* renamed from: b  reason: collision with root package name */
        private final View f564b;

        /* renamed from: c  reason: collision with root package name */
        private final int f565c;

        /* renamed from: d  reason: collision with root package name */
        private final ViewGroup f566d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f567e;
        private boolean f;
        boolean g = false;

        b(View view, int i, boolean z) {
            this.f564b = view;
            this.f565c = i;
            this.f566d = (ViewGroup) view.getParent();
            this.f567e = z;
            a(true);
        }

        private void a() {
            if (!this.g) {
                d0.a(this.f564b, this.f565c);
                ViewGroup viewGroup = this.f566d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (this.f567e && this.f != z && (viewGroup = this.f566d) != null) {
                this.f = z;
                x.a(viewGroup, z);
            }
        }

        @Override // a.p.m.f
        public void a(m mVar) {
            a(false);
        }

        @Override // a.p.m.f
        public void b(m mVar) {
            a(true);
        }

        @Override // a.p.m.f
        public void c(m mVar) {
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            a();
            mVar.b(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.g = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.p.a.AbstractC0025a
        public void onAnimationPause(Animator animator) {
            if (!this.g) {
                d0.a(this.f564b, this.f565c);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.p.a.AbstractC0025a
        public void onAnimationResume(Animator animator) {
            if (!this.g) {
                d0.a(this.f564b, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f568a;

        /* renamed from: b  reason: collision with root package name */
        boolean f569b;

        /* renamed from: c  reason: collision with root package name */
        int f570c;

        /* renamed from: d  reason: collision with root package name */
        int f571d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f572e;
        ViewGroup f;

        c() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
        if (r9 == 0) goto L_0x008c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0083, code lost:
        if (r0.f572e == null) goto L_0x008c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0095, code lost:
        if (r0.f570c == 0) goto L_0x0097;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a.p.i0.c b(a.p.s r8, a.p.s r9) {
        /*
            r7 = this;
            a.p.i0$c r0 = new a.p.i0$c
            r0.<init>()
            r1 = 0
            r0.f568a = r1
            r0.f569b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f602a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f602a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f570c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f602a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f572e = r6
            goto L_0x0037
        L_0x0033:
            r0.f570c = r4
            r0.f572e = r3
        L_0x0037:
            if (r9 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f602a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f602a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f571d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f602a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L_0x005e
        L_0x005a:
            r0.f571d = r4
            r0.f = r3
        L_0x005e:
            r2 = 1
            if (r8 == 0) goto L_0x0086
            if (r9 == 0) goto L_0x0086
            int r8 = r0.f570c
            int r9 = r0.f571d
            if (r8 != r9) goto L_0x0070
            android.view.ViewGroup r8 = r0.f572e
            android.view.ViewGroup r9 = r0.f
            if (r8 != r9) goto L_0x0070
            return r0
        L_0x0070:
            int r8 = r0.f570c
            int r9 = r0.f571d
            if (r8 == r9) goto L_0x007c
            if (r8 != 0) goto L_0x0079
            goto L_0x0097
        L_0x0079:
            if (r9 != 0) goto L_0x009a
            goto L_0x008c
        L_0x007c:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L_0x0081
            goto L_0x0097
        L_0x0081:
            android.view.ViewGroup r8 = r0.f572e
            if (r8 != 0) goto L_0x009a
            goto L_0x008c
        L_0x0086:
            if (r8 != 0) goto L_0x0091
            int r8 = r0.f571d
            if (r8 != 0) goto L_0x0091
        L_0x008c:
            r0.f569b = r2
        L_0x008e:
            r0.f568a = r2
            goto L_0x009a
        L_0x0091:
            if (r9 != 0) goto L_0x009a
            int r8 = r0.f570c
            if (r8 != 0) goto L_0x009a
        L_0x0097:
            r0.f569b = r1
            goto L_0x008e
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.p.i0.b(a.p.s, a.p.s):a.p.i0$c");
    }

    private void d(s sVar) {
        sVar.f602a.put("android:visibility:visibility", Integer.valueOf(sVar.f603b.getVisibility()));
        sVar.f602a.put("android:visibility:parent", sVar.f603b.getParent());
        int[] iArr = new int[2];
        sVar.f603b.getLocationOnScreen(iArr);
        sVar.f602a.put("android:visibility:screenLocation", iArr);
    }

    public Animator a(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        if ((this.K & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f603b.getParent();
            if (b(a(view, false), b(view, false)).f568a) {
                return null;
            }
        }
        return a(viewGroup, sVar2.f603b, sVar, sVar2);
    }

    @Override // a.p.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        c b2 = b(sVar, sVar2);
        if (!b2.f568a) {
            return null;
        }
        if (b2.f572e == null && b2.f == null) {
            return null;
        }
        return b2.f569b ? a(viewGroup, sVar, b2.f570c, sVar2, b2.f571d) : b(viewGroup, sVar, b2.f570c, sVar2, b2.f571d);
    }

    public abstract Animator a(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public void a(int i) {
        if ((i & (-4)) == 0) {
            this.K = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // a.p.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // a.p.m
    public boolean a(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.f602a.containsKey("android:visibility:visibility") != sVar.f602a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c b2 = b(sVar, sVar2);
        if (b2.f568a) {
            return b2.f570c == 0 || b2.f571d == 0;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0082 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e9 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator b(android.view.ViewGroup r7, a.p.s r8, int r9, a.p.s r10, int r11) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.p.i0.b(android.view.ViewGroup, a.p.s, int, a.p.s, int):android.animation.Animator");
    }

    public abstract Animator b(ViewGroup viewGroup, View view, s sVar, s sVar2);

    @Override // a.p.m
    public void c(s sVar) {
        d(sVar);
    }

    @Override // a.p.m
    public String[] n() {
        return L;
    }
}
