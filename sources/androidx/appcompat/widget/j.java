package androidx.appcompat.widget;

import a.a.ActionBar;
import a.d.h;
import a.q.a.a.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class j {
    private static j h;

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f975a;

    /* renamed from: b  reason: collision with root package name */
    private a.d.a<String, d> f976b;

    /* renamed from: c  reason: collision with root package name */
    private h<String> f977c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, a.d.d<WeakReference<Drawable.ConstantState>>> f978d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f979e;
    private boolean f;
    private static final PorterDuff.Mode g = PorterDuff.Mode.SRC_IN;
    private static final c i = new c(6);
    private static final int[] j = {a.a.e.abc_textfield_search_default_mtrl_alpha, a.a.e.abc_textfield_default_mtrl_alpha, a.a.e.abc_ab_share_pack_mtrl_alpha};
    private static final int[] k = {a.a.e.abc_ic_commit_search_api_mtrl_alpha, a.a.e.abc_seekbar_tick_mark_material, a.a.e.abc_ic_menu_share_mtrl_alpha, a.a.e.abc_ic_menu_copy_mtrl_am_alpha, a.a.e.abc_ic_menu_cut_mtrl_alpha, a.a.e.abc_ic_menu_selectall_mtrl_alpha, a.a.e.abc_ic_menu_paste_mtrl_am_alpha};
    private static final int[] l = {a.a.e.abc_textfield_activated_mtrl_alpha, a.a.e.abc_textfield_search_activated_mtrl_alpha, a.a.e.abc_cab_background_top_mtrl_alpha, a.a.e.abc_text_cursor_material, a.a.e.abc_text_select_handle_left_mtrl_dark, a.a.e.abc_text_select_handle_middle_mtrl_dark, a.a.e.abc_text_select_handle_right_mtrl_dark, a.a.e.abc_text_select_handle_left_mtrl_light, a.a.e.abc_text_select_handle_middle_mtrl_light, a.a.e.abc_text_select_handle_right_mtrl_light};
    private static final int[] m = {a.a.e.abc_popup_background_mtrl_mult, a.a.e.abc_cab_background_internal_bg, a.a.e.abc_menu_hardkey_panel_mtrl_mult};
    private static final int[] n = {a.a.e.abc_tab_indicator_material, a.a.e.abc_textfield_search_material};
    private static final int[] o = {a.a.e.abc_btn_check_material, a.a.e.abc_btn_radio_material};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements d {
        a() {
        }

        @Override // androidx.appcompat.widget.j.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.a.l.a.a.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements d {
        b() {
        }

        @Override // androidx.appcompat.widget.j.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return a.q.a.a.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends a.d.e<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return b(Integer.valueOf(b(i, mode)));
        }

        PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((c) Integer.valueOf(b(i, mode)), (Integer) porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e implements d {
        e() {
        }

        @Override // androidx.appcompat.widget.j.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.createFromXmlInner(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    static PorterDuff.Mode a(int i2) {
        if (i2 == a.a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (j.class) {
            a2 = i.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                i.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable findDrawableByLayerId;
        int i3;
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (b0.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable i4 = androidx.core.graphics.drawable.a.i(drawable);
            androidx.core.graphics.drawable.a.a(i4, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return i4;
            }
            androidx.core.graphics.drawable.a.a(i4, a2);
            return i4;
        }
        if (i2 == a.a.e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), n0.b(context, ActionBar.colorControlNormal), g);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = ActionBar.colorControlNormal;
        } else if (i2 == a.a.e.abc_ratingbar_material || i2 == a.a.e.abc_ratingbar_indicator_material || i2 == a.a.e.abc_ratingbar_small_material) {
            layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(16908288), n0.a(context, ActionBar.colorControlNormal), g);
            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908303);
            i3 = ActionBar.colorControlActivated;
        } else if (a(context, i2, drawable) || !z) {
            return drawable;
        } else {
            return null;
        }
        a(findDrawableByLayerId, n0.b(context, i3), g);
        a(layerDrawable.findDrawableByLayerId(16908301), n0.b(context, ActionBar.colorControlActivated), g);
        return drawable;
    }

    private synchronized Drawable a(Context context, long j2) {
        a.d.d<WeakReference<Drawable.ConstantState>> dVar = this.f978d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> c2 = dVar.c(j2);
        if (c2 != null) {
            Drawable.ConstantState constantState = c2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.b(j2);
        }
        return null;
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (h == null) {
                h = new j();
                a(h);
            }
            jVar = h;
        }
        return jVar;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.f975a == null) {
            this.f975a = new WeakHashMap<>();
        }
        h<ColorStateList> hVar = this.f975a.get(context);
        if (hVar == null) {
            hVar = new h<>();
            this.f975a.put(context, hVar);
        }
        hVar.a(i2, colorStateList);
    }

    private static void a(Drawable drawable, int i2, PorterDuff.Mode mode) {
        if (b0.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = g;
        }
        drawable.setColorFilter(a(i2, mode));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, q0 q0Var, int[] iArr) {
        if (!b0.a(drawable) || drawable.mutate() == drawable) {
            if (q0Var.f1031d || q0Var.f1030c) {
                drawable.setColorFilter(a(q0Var.f1031d ? q0Var.f1028a : null, q0Var.f1030c ? q0Var.f1029b : g, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    private static void a(j jVar) {
        if (Build.VERSION.SDK_INT < 24) {
            jVar.a("vector", new e());
            jVar.a("animated-vector", new b());
            jVar.a("animated-selector", new a());
        }
    }

    private void a(String str, d dVar) {
        if (this.f976b == null) {
            this.f976b = new a.d.a<>();
        }
        this.f976b.put(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, int r7, android.graphics.drawable.Drawable r8) {
        /*
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.j.g
            int[] r1 = androidx.appcompat.widget.j.j
            boolean r1 = a(r1, r7)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0015
            int r2 = a.a.ActionBar.colorControlNormal
        L_0x0012:
            r7 = 1
            r1 = -1
            goto L_0x0044
        L_0x0015:
            int[] r1 = androidx.appcompat.widget.j.l
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L_0x0020
            int r2 = a.a.ActionBar.colorControlActivated
            goto L_0x0012
        L_0x0020:
            int[] r1 = androidx.appcompat.widget.j.m
            boolean r1 = a(r1, r7)
            if (r1 == 0) goto L_0x002b
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x0012
        L_0x002b:
            int r1 = a.a.e.abc_list_divider_mtrl_alpha
            if (r7 != r1) goto L_0x003c
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r7 = 1109603123(0x42233333, float:40.8)
            int r7 = java.lang.Math.round(r7)
            r1 = r7
            r7 = 1
            goto L_0x0044
        L_0x003c:
            int r1 = a.a.e.abc_dialog_material_background
            if (r7 != r1) goto L_0x0041
            goto L_0x0012
        L_0x0041:
            r7 = 0
            r1 = -1
            r2 = 0
        L_0x0044:
            if (r7 == 0) goto L_0x0061
            boolean r7 = androidx.appcompat.widget.b0.a(r8)
            if (r7 == 0) goto L_0x0050
            android.graphics.drawable.Drawable r8 = r8.mutate()
        L_0x0050:
            int r6 = androidx.appcompat.widget.n0.b(r6, r2)
            android.graphics.PorterDuffColorFilter r6 = a(r6, r0)
            r8.setColorFilter(r6)
            if (r1 == r3) goto L_0x0060
            r8.setAlpha(r1)
        L_0x0060:
            return r5
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            a.d.d<WeakReference<Drawable.ConstantState>> dVar = this.f978d.get(context);
            if (dVar == null) {
                dVar = new a.d.d<>();
                this.f978d.put(context, dVar);
            }
            dVar.c(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean a(int[] iArr, int i2) {
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void b(Context context) {
        if (!this.f) {
            this.f = true;
            Drawable a2 = a(context, a.a.e.abc_vector_test);
            if (a2 == null || !a(a2)) {
                this.f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private ColorStateList c(Context context) {
        return c(context, 0);
    }

    private ColorStateList c(Context context, int i2) {
        int b2 = n0.b(context, ActionBar.colorControlHighlight);
        return new ColorStateList(new int[][]{n0.f1012b, n0.f1014d, n0.f1013c, n0.f}, new int[]{n0.a(context, ActionBar.colorButtonNormal), a.g.e.a.b(b2, i2), a.g.e.a.b(b2, i2), i2});
    }

    private ColorStateList d(Context context) {
        return c(context, n0.b(context, ActionBar.colorAccent));
    }

    private Drawable d(Context context, int i2) {
        if (this.f979e == null) {
            this.f979e = new TypedValue();
        }
        TypedValue typedValue = this.f979e;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        if (i2 == a.a.e.abc_cab_background_top_material) {
            a3 = new LayerDrawable(new Drawable[]{a(context, a.a.e.abc_cab_background_internal_bg), a(context, a.a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a3);
        }
        return a3;
    }

    private ColorStateList e(Context context) {
        return c(context, n0.b(context, ActionBar.colorButtonNormal));
    }

    private ColorStateList e(Context context, int i2) {
        h<ColorStateList> hVar;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.f975a;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return hVar.b(i2);
    }

    private ColorStateList f(Context context) {
        int[][] iArr = new int[3];
        int[] iArr2 = new int[3];
        ColorStateList c2 = n0.c(context, ActionBar.colorSwitchThumbNormal);
        if (c2 == null || !c2.isStateful()) {
            iArr[0] = n0.f1012b;
            iArr2[0] = n0.a(context, ActionBar.colorSwitchThumbNormal);
            iArr[1] = n0.f1015e;
            iArr2[1] = n0.b(context, ActionBar.colorControlActivated);
            iArr[2] = n0.f;
            iArr2[2] = n0.b(context, ActionBar.colorSwitchThumbNormal);
        } else {
            iArr[0] = n0.f1012b;
            iArr2[0] = c2.getColorForState(iArr[0], 0);
            iArr[1] = n0.f1015e;
            iArr2[1] = n0.b(context, ActionBar.colorControlActivated);
            iArr[2] = n0.f;
            iArr2[2] = c2.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private Drawable f(Context context, int i2) {
        int next;
        a.d.a<String, d> aVar = this.f976b;
        if (aVar == null || aVar.isEmpty()) {
            return null;
        }
        h<String> hVar = this.f977c;
        if (hVar != null) {
            String b2 = hVar.b(i2);
            if ("appcompat_skip_skip".equals(b2) || (b2 != null && this.f976b.get(b2) == null)) {
                return null;
            }
        } else {
            this.f977c = new h<>();
        }
        if (this.f979e == null) {
            this.f979e = new TypedValue();
        }
        TypedValue typedValue = this.f979e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.f977c.a(i2, name);
                    d dVar = this.f976b.get(name);
                    if (dVar != null) {
                        a3 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (a3 != null) {
                        a3.setChangingConfigurations(typedValue.changingConfigurations);
                        a(context, a2, a3);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e2) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e2);
            }
        }
        if (a3 == null) {
            this.f977c.a(i2, "appcompat_skip_skip");
        }
        return a3;
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable f;
        b(context);
        f = f(context, i2);
        if (f == null) {
            f = d(context, i2);
        }
        if (f == null) {
            f = androidx.core.content.a.c(context, i2);
        }
        if (f != null) {
            f = a(context, i2, z, f);
        }
        if (f != null) {
            b0.b(f);
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, x0 x0Var, int i2) {
        Drawable f = f(context, i2);
        if (f == null) {
            f = x0Var.a(i2);
        }
        if (f == null) {
            return null;
        }
        return a(context, i2, false, f);
    }

    public synchronized void a(Context context) {
        a.d.d<WeakReference<Drawable.ConstantState>> dVar = this.f978d.get(context);
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:8:0x000d, B:9:0x0013, B:11:0x0017, B:12:0x001a, B:14:0x001e, B:15:0x0023, B:17:0x0027, B:18:0x002c, B:20:0x0030, B:21:0x0035, B:23:0x0039, B:24:0x003e, B:26:0x0042, B:29:0x0047, B:31:0x004f, B:32:0x0056, B:34:0x005e, B:35:0x0061, B:37:0x0069, B:38:0x006c, B:40:0x0070, B:41:0x0073, B:43:0x0078), top: B:48:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.content.res.ColorStateList b(android.content.Context r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.res.ColorStateList r0 = r2.e(r3, r4)     // Catch: all -> 0x007d
            if (r0 != 0) goto L_0x007b
            int r1 = a.a.e.abc_edit_text_material     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x0013
            int r0 = a.a.c.abc_tint_edittext     // Catch: all -> 0x007d
        L_0x000d:
            android.content.res.ColorStateList r0 = a.a.k.a.a.b(r3, r0)     // Catch: all -> 0x007d
            goto L_0x0076
        L_0x0013:
            int r1 = a.a.e.abc_switch_track_mtrl_alpha     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x001a
            int r0 = a.a.c.abc_tint_switch_track     // Catch: all -> 0x007d
            goto L_0x000d
        L_0x001a:
            int r1 = a.a.e.abc_switch_thumb_material     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x0023
            android.content.res.ColorStateList r0 = r2.f(r3)     // Catch: all -> 0x007d
            goto L_0x0076
        L_0x0023:
            int r1 = a.a.e.abc_btn_default_mtrl_shape     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x002c
            android.content.res.ColorStateList r0 = r2.e(r3)     // Catch: all -> 0x007d
            goto L_0x0076
        L_0x002c:
            int r1 = a.a.e.abc_btn_borderless_material     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x0035
            android.content.res.ColorStateList r0 = r2.c(r3)     // Catch: all -> 0x007d
            goto L_0x0076
        L_0x0035:
            int r1 = a.a.e.abc_btn_colored_material     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x003e
            android.content.res.ColorStateList r0 = r2.d(r3)     // Catch: all -> 0x007d
            goto L_0x0076
        L_0x003e:
            int r1 = a.a.e.abc_spinner_mtrl_am_alpha     // Catch: all -> 0x007d
            if (r4 == r1) goto L_0x0073
            int r1 = a.a.e.abc_spinner_textfield_background_material     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x0047
            goto L_0x0073
        L_0x0047:
            int[] r1 = androidx.appcompat.widget.j.k     // Catch: all -> 0x007d
            boolean r1 = a(r1, r4)     // Catch: all -> 0x007d
            if (r1 == 0) goto L_0x0056
            int r0 = a.a.ActionBar.colorControlNormal     // Catch: all -> 0x007d
            android.content.res.ColorStateList r0 = androidx.appcompat.widget.n0.c(r3, r0)     // Catch: all -> 0x007d
            goto L_0x0076
        L_0x0056:
            int[] r1 = androidx.appcompat.widget.j.n     // Catch: all -> 0x007d
            boolean r1 = a(r1, r4)     // Catch: all -> 0x007d
            if (r1 == 0) goto L_0x0061
            int r0 = a.a.c.abc_tint_default     // Catch: all -> 0x007d
            goto L_0x000d
        L_0x0061:
            int[] r1 = androidx.appcompat.widget.j.o     // Catch: all -> 0x007d
            boolean r1 = a(r1, r4)     // Catch: all -> 0x007d
            if (r1 == 0) goto L_0x006c
            int r0 = a.a.c.abc_tint_btn_checkable     // Catch: all -> 0x007d
            goto L_0x000d
        L_0x006c:
            int r1 = a.a.e.abc_seekbar_thumb_material     // Catch: all -> 0x007d
            if (r4 != r1) goto L_0x0076
            int r0 = a.a.c.abc_tint_seek_thumb     // Catch: all -> 0x007d
            goto L_0x000d
        L_0x0073:
            int r0 = a.a.c.abc_tint_spinner     // Catch: all -> 0x007d
            goto L_0x000d
        L_0x0076:
            if (r0 == 0) goto L_0x007b
            r2.a(r3, r4, r0)     // Catch: all -> 0x007d
        L_0x007b:
            monitor-exit(r2)
            return r0
        L_0x007d:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0081
        L_0x0080:
            throw r3
        L_0x0081:
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j.b(android.content.Context, int):android.content.res.ColorStateList");
    }
}
