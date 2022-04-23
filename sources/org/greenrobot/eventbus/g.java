package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;

/* loaded from: classes.dex */
public interface g {

    /* loaded from: classes.dex */
    public static class a implements g {

        /* renamed from: b  reason: collision with root package name */
        static final boolean f3810b;

        /* renamed from: a  reason: collision with root package name */
        private final String f3811a;

        static {
            boolean z = false;
            try {
                if (Class.forName("android.util.Log") != null) {
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            }
            f3810b = z;
        }

        public a(String str) {
            this.f3811a = str;
        }

        public static boolean a() {
            return f3810b;
        }

        protected int a(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            }
            if (intValue < 900) {
                return 4;
            }
            return intValue < 1000 ? 5 : 6;
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(a(level), this.f3811a, str);
            }
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int a2 = a(level);
                String str2 = this.f3811a;
                Log.println(a2, str2, str + "\n" + Log.getStackTraceString(th));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements g {
        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.g
        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
