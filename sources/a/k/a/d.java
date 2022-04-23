package a.k.a;

import a.d.h;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.lifecycle.e;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class d extends androidx.core.app.d implements s, a.b, a.d {
    private r f;
    boolean g;
    boolean h;
    boolean j;
    boolean k;
    boolean l;
    int m;
    h<String> n;

    /* renamed from: d  reason: collision with root package name */
    final Handler f399d = new a();

    /* renamed from: e  reason: collision with root package name */
    final f f400e = f.a(new b());
    boolean i = true;

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            d.this.k();
            d.this.f400e.i();
        }
    }

    /* loaded from: classes.dex */
    class b extends g<d> {
        public b() {
            super(d.this);
        }

        @Override // a.k.a.e
        public View a(int i) {
            return d.this.findViewById(i);
        }

        @Override // a.k.a.g
        public void a(a.k.a.c cVar) {
            d.this.a(cVar);
        }

        @Override // a.k.a.g
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            d.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // a.k.a.e
        public boolean a() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // a.k.a.g
        public boolean b(a.k.a.c cVar) {
            return !d.this.isFinishing();
        }

        @Override // a.k.a.g
        public LayoutInflater f() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // a.k.a.g
        public int g() {
            Window window = d.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // a.k.a.g
        public boolean h() {
            return d.this.getWindow() != null;
        }

        @Override // a.k.a.g
        public void i() {
            d.this.m();
        }
    }

    /* loaded from: classes.dex */
    static final class c {

        /* renamed from: a  reason: collision with root package name */
        r f403a;

        /* renamed from: b  reason: collision with root package name */
        j f404b;

        c() {
        }
    }

    private static boolean a(h hVar, e.b bVar) {
        boolean z = false;
        for (a.k.a.c cVar : hVar.a()) {
            if (cVar != null) {
                if (cVar.e().a().a(e.b.STARTED)) {
                    cVar.T.a(bVar);
                    z = true;
                }
                h O = cVar.O();
                if (O != null) {
                    z |= a(O, bVar);
                }
            }
        }
        return z;
    }

    static void c(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void n() {
        do {
        } while (a(j(), e.b.CREATED));
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f400e.a(view, str, context, attributeSet);
    }

    @Override // androidx.core.app.a.d
    public final void a(int i) {
        if (!this.j && i != -1) {
            c(i);
        }
    }

    public void a(a.k.a.c cVar) {
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.g);
        printWriter.print(" mResumed=");
        printWriter.print(this.h);
        printWriter.print(" mStopped=");
        printWriter.print(this.i);
        if (getApplication() != null) {
            a.m.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f400e.j().a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.core.app.d, androidx.lifecycle.g
    public e e() {
        return super.e();
    }

    @Override // androidx.lifecycle.s
    public r f() {
        if (getApplication() != null) {
            if (this.f == null) {
                c cVar = (c) getLastNonConfigurationInstance();
                if (cVar != null) {
                    this.f = cVar.f403a;
                }
                if (this.f == null) {
                    this.f = new r();
                }
            }
            return this.f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public h j() {
        return this.f400e.j();
    }

    protected void k() {
        this.f400e.f();
    }

    public Object l() {
        return null;
    }

    @Deprecated
    public void m() {
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f400e.k();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String b2 = this.n.b(i4);
            this.n.d(i4);
            if (b2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            a.k.a.c a2 = this.f400e.a(b2);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + b2);
                return;
            }
            a2.a(i & 65535, i2, intent);
            return;
        }
        a.c a3 = androidx.core.app.a.a();
        if (a3 == null || !a3.a(this, i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h j = this.f400e.j();
        boolean b2 = j.b();
        if (b2 && Build.VERSION.SDK_INT <= 25) {
            return;
        }
        if (b2 || !j.c()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f400e.k();
        this.f400e.a(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        r rVar;
        j jVar = null;
        this.f400e.a((a.k.a.c) null);
        super.onCreate(bundle);
        c cVar = (c) getLastNonConfigurationInstance();
        if (!(cVar == null || (rVar = cVar.f403a) == null || this.f != null)) {
            this.f = rVar;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            f fVar = this.f400e;
            if (cVar != null) {
                jVar = cVar.f404b;
            }
            fVar.a(parcelable, jVar);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.m = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.n = new h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.n.c(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.n == null) {
            this.n = new h<>();
            this.m = 0;
        }
        this.f400e.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.f400e.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a(null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f != null && !isChangingConfigurations()) {
            this.f.a();
        }
        this.f400e.c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f400e.d();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.f400e.b(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.f400e.a(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f400e.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f400e.k();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f400e.a(menu);
        }
        super.onPanelClosed(i, menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.h = false;
        if (this.f399d.hasMessages(2)) {
            this.f399d.removeMessages(2);
            k();
        }
        this.f400e.e();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f400e.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f399d.removeMessages(2);
        k();
        this.f400e.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : a(view, menu) | this.f400e.b(menu);
    }

    @Override // android.app.Activity, androidx.core.app.a.b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f400e.k();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String b2 = this.n.b(i3);
            this.n.d(i3);
            if (b2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            a.k.a.c a2 = this.f400e.a(b2);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for who: " + b2);
                return;
            }
            a2.a(i & 65535, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f399d.sendEmptyMessage(2);
        this.h = true;
        this.f400e.i();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object l = l();
        j l2 = this.f400e.l();
        if (l2 == null && this.f == null && l == null) {
            return null;
        }
        c cVar = new c();
        cVar.f403a = this.f;
        cVar.f404b = l2;
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.d, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        n();
        Parcelable m = this.f400e.m();
        if (m != null) {
            bundle.putParcelable("android:support:fragments", m);
        }
        if (this.n.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.m);
            int[] iArr = new int[this.n.b()];
            String[] strArr = new String[this.n.b()];
            for (int i = 0; i < this.n.b(); i++) {
                iArr[i] = this.n.c(i);
                strArr[i] = this.n.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.i = false;
        if (!this.g) {
            this.g = true;
            this.f400e.a();
        }
        this.f400e.k();
        this.f400e.i();
        this.f400e.g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f400e.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.i = true;
        n();
        this.f400e.h();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.l && i != -1) {
            c(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.l && i != -1) {
            c(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.k && i != -1) {
            c(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.k && i != -1) {
            c(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
