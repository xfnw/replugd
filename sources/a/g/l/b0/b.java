package a.g.l.b0;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class b {

    /* loaded from: classes.dex */
    public interface a {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* renamed from: a.g.l.b0.b$b  reason: collision with other inner class name and invalid class name */
    /* loaded from: classes.dex */
    private static class accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0013b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final a f292a;

        accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0013b(a aVar) {
            this.f292a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0013b.class != obj.getClass()) {
                return false;
            }
            return this.f292a.equals(((accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0013b) obj).f292a);
        }

        public int hashCode() {
            return this.f292a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f292a.onTouchExplorationStateChanged(z);
        }
    }

    public static boolean a(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.addTouchExplorationStateChangeListener(new accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0013b(aVar));
    }

    public static boolean b(AccessibilityManager accessibilityManager, a aVar) {
        if (Build.VERSION.SDK_INT < 19 || aVar == null) {
            return false;
        }
        return accessibilityManager.removeTouchExplorationStateChangeListener(new accessibilityAccessibilityManager$TouchExplorationStateChangeListenerC0013b(aVar));
    }
}
