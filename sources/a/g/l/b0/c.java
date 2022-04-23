package a.g.l.b0;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final AccessibilityNodeInfo f293a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Object f294a;

        a(Object obj) {
            this.f294a = obj;
        }

        public static a a(int i, int i2, boolean z, int i3) {
            int i4 = Build.VERSION.SDK_INT;
            return i4 >= 21 ? new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3)) : i4 >= 19 ? new a(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z)) : new a(null);
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final Object f295a;

        b(Object obj) {
            this.f295a = obj;
        }

        public static b a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 21 ? new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2)) : i5 >= 19 ? new b(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z)) : new b(null);
        }
    }

    private c(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f293a = accessibilityNodeInfo;
    }

    public static c a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new c(accessibilityNodeInfo);
    }

    private static String b(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public int a() {
        return this.f293a.getActions();
    }

    public void a(int i) {
        this.f293a.addAction(i);
    }

    public void a(Rect rect) {
        this.f293a.getBoundsInParent(rect);
    }

    public void a(CharSequence charSequence) {
        this.f293a.setClassName(charSequence);
    }

    public void a(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f293a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((a) obj).f294a);
        }
    }

    public void a(boolean z) {
        this.f293a.setCheckable(z);
    }

    public CharSequence b() {
        return this.f293a.getClassName();
    }

    public void b(Rect rect) {
        this.f293a.getBoundsInScreen(rect);
    }

    public void b(Object obj) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f293a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((b) obj).f295a);
        }
    }

    public void b(boolean z) {
        this.f293a.setChecked(z);
    }

    public CharSequence c() {
        return this.f293a.getContentDescription();
    }

    public void c(boolean z) {
        this.f293a.setScrollable(z);
    }

    public CharSequence d() {
        return this.f293a.getPackageName();
    }

    public CharSequence e() {
        return this.f293a.getText();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfo accessibilityNodeInfo = this.f293a;
        AccessibilityNodeInfo accessibilityNodeInfo2 = ((c) obj).f293a;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfo2 != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfo2)) {
            return false;
        }
        return true;
    }

    public String f() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f293a.getViewIdResourceName();
        }
        return null;
    }

    public boolean g() {
        return this.f293a.isCheckable();
    }

    public boolean h() {
        return this.f293a.isChecked();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f293a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean i() {
        return this.f293a.isClickable();
    }

    public boolean j() {
        return this.f293a.isEnabled();
    }

    public boolean k() {
        return this.f293a.isFocusable();
    }

    public boolean l() {
        return this.f293a.isFocused();
    }

    public boolean m() {
        return this.f293a.isLongClickable();
    }

    public boolean n() {
        return this.f293a.isPassword();
    }

    public boolean o() {
        return this.f293a.isScrollable();
    }

    public boolean p() {
        return this.f293a.isSelected();
    }

    public AccessibilityNodeInfo q() {
        return this.f293a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        sb.append("; boundsInParent: " + rect);
        b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(d());
        sb.append("; className: ");
        sb.append(b());
        sb.append("; text: ");
        sb.append(e());
        sb.append("; contentDescription: ");
        sb.append(c());
        sb.append("; viewId: ");
        sb.append(f());
        sb.append("; checkable: ");
        sb.append(g());
        sb.append("; checked: ");
        sb.append(h());
        sb.append("; focusable: ");
        sb.append(k());
        sb.append("; focused: ");
        sb.append(l());
        sb.append("; selected: ");
        sb.append(p());
        sb.append("; clickable: ");
        sb.append(i());
        sb.append("; longClickable: ");
        sb.append(m());
        sb.append("; enabled: ");
        sb.append(j());
        sb.append("; password: ");
        sb.append(n());
        sb.append("; scrollable: " + o());
        sb.append("; [");
        int a2 = a();
        while (a2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a2);
            a2 &= numberOfTrailingZeros ^ (-1);
            sb.append(b(numberOfTrailingZeros));
            if (a2 != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
