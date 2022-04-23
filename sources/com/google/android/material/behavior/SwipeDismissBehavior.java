package com.google.android.material.behavior;

import a.g.l.s;
import a.i.b.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    a.i.b.a f3138a;

    /* renamed from: b  reason: collision with root package name */
    b f3139b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3140c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3142e;

    /* renamed from: d  reason: collision with root package name */
    private float f3141d = 0.0f;
    int f = 2;
    float g = 0.5f;
    float h = 0.0f;
    float i = 0.5f;
    private final a.c j = new a();

    /* loaded from: classes.dex */
    class a extends a.c {

        /* renamed from: a  reason: collision with root package name */
        private int f3143a;

        /* renamed from: b  reason: collision with root package name */
        private int f3144b = -1;

        a() {
        }

        private boolean a(View view, float f) {
            if (f != 0.0f) {
                boolean z = s.j(view) == 1;
                int i = SwipeDismissBehavior.this.f;
                if (i == 2) {
                    return true;
                }
                if (i == 0) {
                    if (z) {
                        if (f >= 0.0f) {
                            return false;
                        }
                    } else if (f <= 0.0f) {
                        return false;
                    }
                    return true;
                } else if (i != 1) {
                    return false;
                } else {
                    if (z) {
                        if (f <= 0.0f) {
                            return false;
                        }
                    } else if (f >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            } else {
                return Math.abs(view.getLeft() - this.f3143a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.g);
            }
        }

        @Override // a.i.b.a.c
        public int a(View view) {
            return view.getWidth();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
            r5 = r2.f3143a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (r5 != false) goto L_0x001c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
            if (r5 != false) goto L_0x0012;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
            r5 = r2.f3143a - r3.getWidth();
            r3 = r2.f3143a;
         */
        @Override // a.i.b.a.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = a.g.l.s.j(r3)
                r0 = 1
                if (r5 != r0) goto L_0x0009
                r5 = 1
                goto L_0x000a
            L_0x0009:
                r5 = 0
            L_0x000a:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f
                if (r1 != 0) goto L_0x0024
                if (r5 == 0) goto L_0x001c
            L_0x0012:
                int r5 = r2.f3143a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f3143a
                goto L_0x0037
            L_0x001c:
                int r5 = r2.f3143a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L_0x0037
            L_0x0024:
                if (r1 != r0) goto L_0x0029
                if (r5 == 0) goto L_0x0012
                goto L_0x001c
            L_0x0029:
                int r5 = r2.f3143a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f3143a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L_0x0037:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.a(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // a.i.b.a.c
        public void a(View view, float f, float f2) {
            boolean z;
            int i;
            b bVar;
            this.f3144b = -1;
            int width = view.getWidth();
            if (a(view, f)) {
                int left = view.getLeft();
                int i2 = this.f3143a;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.f3143a;
                z = false;
            }
            if (SwipeDismissBehavior.this.f3138a.c(i, view.getTop())) {
                s.a(view, new c(view, z));
            } else if (z && (bVar = SwipeDismissBehavior.this.f3139b) != null) {
                bVar.a(view);
            }
        }

        @Override // a.i.b.a.c
        public void a(View view, int i) {
            this.f3144b = i;
            this.f3143a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // a.i.b.a.c
        public void a(View view, int i, int i2, int i3, int i4) {
            float width = this.f3143a + (view.getWidth() * SwipeDismissBehavior.this.h);
            float width2 = this.f3143a + (view.getWidth() * SwipeDismissBehavior.this.i);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(width, width2, f), 1.0f));
            }
        }

        @Override // a.i.b.a.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // a.i.b.a.c
        public boolean b(View view, int i) {
            return this.f3144b == -1 && SwipeDismissBehavior.this.a(view);
        }

        @Override // a.i.b.a.c
        public void c(int i) {
            b bVar = SwipeDismissBehavior.this.f3139b;
            if (bVar != null) {
                bVar.a(i);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i);

        void a(View view);
    }

    /* loaded from: classes.dex */
    private class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final View f3146b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3147c;

        c(View view, boolean z) {
            this.f3146b = view;
            this.f3147c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            a.i.b.a aVar = SwipeDismissBehavior.this.f3138a;
            if (aVar != null && aVar.a(true)) {
                s.a(this.f3146b, this);
            } else if (this.f3147c && (bVar = SwipeDismissBehavior.this.f3139b) != null) {
                bVar.a(this.f3146b);
            }
        }
    }

    static float a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    private void a(ViewGroup viewGroup) {
        if (this.f3138a == null) {
            this.f3138a = this.f3142e ? a.i.b.a.a(viewGroup, this.f3141d, this.j) : a.i.b.a.a(viewGroup, this.j);
        }
    }

    static float b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public void a(float f) {
        this.i = a(0.0f, f, 1.0f);
    }

    public void a(int i) {
        this.f = i;
    }

    public boolean a(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f3140c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f3140c = coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f3140c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f3140c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f3138a.b(motionEvent);
    }

    public void b(float f) {
        this.h = a(0.0f, f, 1.0f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        a.i.b.a aVar = this.f3138a;
        if (aVar == null) {
            return false;
        }
        aVar.a(motionEvent);
        return true;
    }
}
