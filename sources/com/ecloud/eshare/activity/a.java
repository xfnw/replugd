package com.ecloud.eshare.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.c;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.util.f;
import com.ecloud.eshare.util.l;
import com.ecloud.eshare.util.m;
import com.squareup.picasso.R;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public abstract class a extends androidx.appcompat.app.d implements View.OnClickListener, m, com.ecloud.eshare.d.a, f.b {
    private b.b.a.c A;
    private int B;
    private com.ecloud.eshare.util.f C;
    private Dialog D;
    private ExecutorService E;
    private com.ecloud.eshare.e.a F;
    public int r;
    protected boolean s;
    protected int t;
    protected int u;
    protected int v;
    private com.ecloud.eshare.f.d x;
    private androidx.appcompat.app.c y;
    private androidx.appcompat.app.c z;
    private int w = -1;
    private Handler G = new c(Looper.getMainLooper());

    /* renamed from: com.ecloud.eshare.activity.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class DialogInterface$OnClickListenerC0069a implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC0069a(a aVar) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f2726b;

        b(File file) {
            this.f2726b = file;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.F.a(this.f2726b);
        }
    }

    /* loaded from: classes.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void handleMessage(android.os.Message r4) {
            /*
                r3 = this;
                int r0 = r4.what
                switch(r0) {
                    case 1: goto L_0x00a9;
                    case 2: goto L_0x007f;
                    case 3: goto L_0x0070;
                    case 4: goto L_0x006a;
                    case 5: goto L_0x0060;
                    case 6: goto L_0x004a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                r1 = 300(0x12c, double:1.48E-321)
                r4 = 101(0x65, float:1.42E-43)
                switch(r0) {
                    case 101: goto L_0x003d;
                    case 102: goto L_0x0019;
                    case 103: goto L_0x002f;
                    case 104: goto L_0x000e;
                    default: goto L_0x000c;
                }
            L_0x000c:
                goto L_0x00ae
            L_0x000e:
                com.ecloud.eshare.activity.a r0 = com.ecloud.eshare.activity.a.this
                android.os.Handler r0 = com.ecloud.eshare.activity.a.h(r0)
                r0.sendEmptyMessageDelayed(r4, r1)
                goto L_0x00ae
            L_0x0019:
                com.ecloud.eshare.activity.PhotoActivity r0 = com.ecloud.eshare.activity.PhotoActivity.w()
                if (r0 == 0) goto L_0x002f
                com.ecloud.eshare.activity.PhotoActivity r0 = com.ecloud.eshare.activity.PhotoActivity.w()
                r0.finish()
                com.ecloud.eshare.activity.a r0 = com.ecloud.eshare.activity.a.this
                android.os.Handler r0 = com.ecloud.eshare.activity.a.h(r0)
                r0.sendEmptyMessageDelayed(r4, r1)
            L_0x002f:
                com.ecloud.eshare.activity.MediaActivity r0 = com.ecloud.eshare.activity.MediaActivity.v()
                if (r0 == 0) goto L_0x00ae
                com.ecloud.eshare.activity.MediaActivity r0 = com.ecloud.eshare.activity.MediaActivity.v()
                r0.finish()
                goto L_0x000e
            L_0x003d:
                com.ecloud.eshare.activity.MainActivity r4 = com.ecloud.eshare.activity.MainActivity.J()
                r0 = 0
                com.ecloud.eshare.activity.MainActivity r1 = com.ecloud.eshare.activity.MainActivity.J()
                r4.a(r0, r1)
                goto L_0x00ae
            L_0x004a:
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                androidx.appcompat.app.c r4 = com.ecloud.eshare.activity.a.g(r4)
                boolean r4 = r4.isShowing()
                if (r4 == 0) goto L_0x00ae
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                androidx.appcompat.app.c r4 = com.ecloud.eshare.activity.a.g(r4)
                r4.dismiss()
                goto L_0x00ae
            L_0x0060:
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                int r0 = r4.r
                if (r0 == 0) goto L_0x00ae
                com.ecloud.eshare.activity.a.f(r4)
                goto L_0x00ae
            L_0x006a:
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                com.ecloud.eshare.activity.a.e(r4)
                goto L_0x00ae
            L_0x0070:
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                boolean r4 = com.ecloud.eshare.activity.a.b(r4)
                if (r4 != 0) goto L_0x00ae
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                r0 = 3
                com.ecloud.eshare.activity.a.a(r4, r0)
                goto L_0x00ae
            L_0x007f:
                com.ecloud.eshare.activity.a r0 = com.ecloud.eshare.activity.a.this
                boolean r0 = com.ecloud.eshare.activity.a.b(r0)
                java.lang.Object r4 = r4.obj
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
                r1 = 1
                if (r4 != r1) goto L_0x00a1
                com.ecloud.eshare.activity.a r1 = com.ecloud.eshare.activity.a.this
                com.ecloud.eshare.f.d r1 = com.ecloud.eshare.activity.a.d(r1)
                if (r1 == 0) goto L_0x00a1
                com.ecloud.eshare.activity.a r1 = com.ecloud.eshare.activity.a.this
                com.ecloud.eshare.f.d r1 = com.ecloud.eshare.activity.a.d(r1)
                r1.onSuccess()
            L_0x00a1:
                if (r0 != 0) goto L_0x00ae
                com.ecloud.eshare.activity.a r0 = com.ecloud.eshare.activity.a.this
                com.ecloud.eshare.activity.a.a(r0, r4)
                goto L_0x00ae
            L_0x00a9:
                com.ecloud.eshare.activity.a r4 = com.ecloud.eshare.activity.a.this
                com.ecloud.eshare.activity.a.a(r4)
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.a.c.handleMessage(android.os.Message):void");
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2729b;

        d(int i) {
            this.f2729b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.b(this.f2729b, aVar.x);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.A != null) {
                a.this.A.g(a.this.B);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2732b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f2733c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f2734d;

        f(EditText editText, TextView textView, Runnable runnable) {
            this.f2732b = editText;
            this.f2733c = textView;
            this.f2734d = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            String trim = this.f2732b.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                this.f2733c.setVisibility(0);
                return;
            }
            com.ecloud.eshare.util.e.a(a.this, trim);
            if (a.this.A == null) {
                a aVar = a.this;
                aVar.A = b.b.a.a.a(aVar).b();
            }
            a.this.A.h(trim);
            Runnable runnable = this.f2734d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f2736b;

        g(a aVar, Runnable runnable) {
            this.f2736b = runnable;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Runnable runnable = this.f2736b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements DialogInterface.OnCancelListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f2737b;

        h(a aVar, Runnable runnable) {
            this.f2737b = runnable;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Runnable runnable = this.f2737b;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.app.c f2738b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TextView f2739c;

        i(a aVar, androidx.appcompat.app.c cVar, TextView textView) {
            this.f2738b = cVar;
            this.f2739c = textView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextView textView;
            int i;
            if (editable.toString().isEmpty()) {
                i = 0;
                this.f2738b.b(-1).setEnabled(false);
                textView = this.f2739c;
            } else {
                this.f2738b.b(-1).setEnabled(true);
                textView = this.f2739c;
                i = 8;
            }
            textView.setVisibility(i);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    class j implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2740b;

        j(String str) {
            this.f2740b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.A.b(true, this.f2740b);
        }
    }

    /* loaded from: classes.dex */
    class k implements DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2742b;

        k(String str) {
            this.f2742b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.A.b(false, this.f2742b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        int i3;
        if (this.s) {
            if (i2 == 2) {
                i3 = R.string.confirm_error_message_deny;
            } else if (i2 == 3) {
                i3 = R.string.confirm_error_message_timeout;
            } else if (i2 == 5) {
                i3 = R.string.confirm_error_message_error;
            } else {
                return;
            }
            com.ecloud.eshare.util.f.c(this, i3, R.string.confirm_error_ok);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        Dialog dialog = this.D;
        if (dialog == null || !dialog.isShowing()) {
            return true;
        }
        this.D.cancel();
        this.D = null;
        return false;
    }

    private void w() {
        this.G.removeMessages(3, this.G.obtainMessage(3));
        if (this.A == null) {
            this.A = b.b.a.a.a(this).b();
        }
        this.A.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        androidx.appcompat.app.c cVar;
        if (this.s && (cVar = this.z) != null && cVar.isShowing()) {
            this.z.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        Dialog dialog = this.D;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        if (!this.s) {
            l.a("showConfirmDialog isStarted false");
            return;
        }
        if (this.D != null) {
            this.D = null;
        }
        this.G.removeMessages(3);
        this.D = com.ecloud.eshare.util.f.b(this, R.string.confirm_loading_title, R.string.confirm_loading_cancel);
        this.D.show();
        this.D.setCanceledOnTouchOutside(false);
        this.D.setCancelable(false);
        this.G.sendEmptyMessageDelayed(3, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        c.a.a.e.a(this, getString(R.string.host_function_disabled), null, getResources().getColor(R.color.c_666666), getResources().getColor(R.color.white), 0, false, true).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i2, com.ecloud.eshare.f.d dVar) {
        this.A = b.b.a.a.a(this).b();
        this.x = dVar;
        if (com.ecloud.eshare.util.e.b(this)) {
            a(new d(i2));
            com.ecloud.eshare.util.e.a((Context) this, false);
            return;
        }
        b(i2, this.x);
    }

    public void a(File file) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog.Builder title = builder.setTitle(R.string.tips);
        title.setMessage(getString(R.string.save_file) + " " + file.getName() + "?").setCancelable(false).setPositiveButton(R.string.host_assign_ok_btn, new b(file)).setNegativeButton(R.string.setting_rename_cancel, new DialogInterface$OnClickListenerC0069a(this));
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Runnable runnable) {
        c.a aVar = new c.a(this);
        aVar.a(R.string.setting_rename_title);
        View inflate = View.inflate(this, R.layout.dialog_rename, null);
        EditText editText = (EditText) inflate.findViewById(R.id.et_rename);
        editText.requestFocus();
        TextView textView = (TextView) inflate.findViewById(R.id.tv_dialog_error);
        String a2 = com.ecloud.eshare.util.e.a(this);
        if (!TextUtils.isEmpty(a2)) {
            if (a2.length() > 13) {
                a2 = a2.substring(0, 13);
            }
            editText.setText(a2);
            editText.setSelection(a2.length());
        }
        aVar.b(inflate);
        aVar.b(R.string.setting_rename_save, new f(editText, textView, runnable));
        aVar.a(R.string.setting_rename_cancel, new g(this, runnable));
        aVar.a(new h(this, runnable));
        androidx.appcompat.app.c a3 = aVar.a();
        editText.addTextChangedListener(new i(this, a3, textView));
        a3.show();
    }

    public void a(Object... objArr) {
        l.a(objArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void b(int i2, com.ecloud.eshare.f.d dVar) {
        boolean z = false;
        if (!this.s) {
            l.a("startRequest isStarted false");
        } else if (!this.A.c()) {
            this.x.onSuccess();
        } else {
            this.B = i2;
            this.x = dVar;
            switch (i2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 6:
                case 7:
                    int i3 = this.w;
                    if (i3 != 1) {
                        if (i3 == 0) {
                            z();
                            return;
                        }
                        z = true;
                        break;
                    } else {
                        dVar.onSuccess();
                        return;
                    }
                case 4:
                    int i4 = this.u;
                    if (i4 != 0 && i4 != 2) {
                        if (i4 == 1) {
                            dVar.onSuccess();
                            return;
                        }
                        z = true;
                        break;
                    } else {
                        z();
                        return;
                    }
                case 5:
                default:
                    z = true;
                    break;
                case 8:
                    int i5 = this.w;
                    if (i5 != 1) {
                        if (i5 == 0) {
                            z();
                            return;
                        }
                        z = true;
                        break;
                    } else {
                        dVar.onSuccess();
                        break;
                    }
                case 9:
                    int i6 = this.u;
                    if (i6 != 0) {
                        if (i6 == 1 || i6 == 2) {
                            dVar.onSuccess();
                            return;
                        }
                        z = true;
                        break;
                    } else {
                        z();
                        return;
                    }
            }
            new e().run();
            if (z) {
                this.G.sendEmptyMessage(1);
            }
        }
    }

    public void b(Object... objArr) {
        l.b(objArr);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void cancelPeerCastDialog(EventCollections.PeerDeviceDealtEvent peerDeviceDealtEvent) {
        x();
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void castRequestReceive(EventCollections.CastRequestEvent castRequestEvent) {
        if (this.D != null) {
            v();
            if (castRequestEvent.getRet() != 1) {
                d(castRequestEvent.getRet() == 0 ? 2 : 3);
            } else if (this.s) {
                this.x.onSuccess();
            }
        }
    }

    @Override // com.ecloud.eshare.util.f.b
    public void g() {
        w();
    }

    @org.greenrobot.eventbus.m
    public void heartbeatInfoUpdate(EventCollections.HeartbeatInfo heartbeatInfo) {
        if (this.w != heartbeatInfo.getCastMode() && heartbeatInfo.getCastMode() == 0) {
            this.w = heartbeatInfo.getCastMode();
            EventCollections.FinishActivityEvent finishActivityEvent = new EventCollections.FinishActivityEvent();
            finishActivityEvent.setType(EventCollections.FinishActivityEvent.FINISH_CAST);
            org.greenrobot.eventbus.c.d().a(finishActivityEvent);
        }
        if (this.u != heartbeatInfo.getMirrorMode() && heartbeatInfo.getMirrorMode() == 0) {
            this.u = heartbeatInfo.getMirrorMode();
            this.G.sendEmptyMessage(5);
            EventCollections.FinishActivityEvent finishActivityEvent2 = new EventCollections.FinishActivityEvent();
            finishActivityEvent2.setType(EventCollections.FinishActivityEvent.FINISH_MIRROR);
            org.greenrobot.eventbus.c.d().a(finishActivityEvent2);
        }
        this.w = heartbeatInfo.getCastMode();
        this.u = heartbeatInfo.getMirrorMode();
        this.t = heartbeatInfo.getMultiScreen();
        heartbeatInfo.getCastState();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (!(this instanceof MainActivity) && MainActivity.J() != null) {
            MainActivity.J().a(i2, i3, intent);
        }
    }

    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(s());
        r();
        t();
        u();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        org.greenrobot.eventbus.c.d().b(this);
        this.C = new com.ecloud.eshare.util.f();
        this.C.a((f.b) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        androidx.appcompat.app.c cVar = this.z;
        if (cVar != null && cVar.isShowing()) {
            this.z.dismiss();
            this.z = null;
        }
        org.greenrobot.eventbus.c.d().c(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMain(com.ecloud.eshare.util.h hVar) {
        if (this.s) {
            int a2 = hVar.a();
            if (a2 != 1000) {
                if (a2 == 1001) {
                    this.G.removeMessages(6);
                    if (this.y.isShowing()) {
                        this.y.dismiss();
                    }
                }
            } else if (this instanceof MainActivity) {
                if (MainActivity.J() != null) {
                    MainActivity.J().a(false, (a) MainActivity.J());
                }
            } else if (this instanceof MirrorNoteActivity) {
                if (MirrorNoteActivity.C() != null) {
                    MirrorNoteActivity.C().finish();
                    this.G.sendEmptyMessageDelayed(101, 300L);
                }
            } else if (this instanceof CameraActivity) {
                if (CameraActivity.E() != null) {
                    CameraActivity.E().finish();
                    this.G.sendEmptyMessageDelayed(101, 300L);
                }
            } else if (this instanceof DocumentActivity) {
                if (DocumentActivity.v() != null) {
                    DocumentActivity.v().finish();
                    this.G.sendEmptyMessageDelayed(101, 300L);
                }
            } else if (this instanceof PhotoActivity) {
                if (PhotoActivity.w() != null) {
                    PhotoActivity.w().finish();
                    this.G.sendEmptyMessageDelayed(101, 300L);
                }
            } else if (this instanceof MediaActivity) {
                if (MediaActivity.v() != null) {
                    MediaActivity.v().finish();
                    this.G.sendEmptyMessageDelayed(101, 300L);
                }
            } else if (this instanceof ImageActivity) {
                if (ImageActivity.w() != null) {
                    ImageActivity.w().finish();
                    this.G.sendEmptyMessageDelayed(102, 300L);
                }
            } else if (this instanceof PlayerActivity) {
                if (PlayerActivity.w() != null) {
                    PlayerActivity.w().finish();
                    this.G.sendEmptyMessageDelayed(103, 300L);
                }
            } else if (this instanceof KeyboardActivity) {
                if (KeyboardActivity.v() != null) {
                    KeyboardActivity.v().finish();
                    this.G.sendEmptyMessageDelayed(104, 300L);
                }
            } else if (this instanceof AirMouseActivity) {
                if (AirMouseActivity.w() != null) {
                    AirMouseActivity.w().finish();
                    this.G.sendEmptyMessageDelayed(104, 300L);
                }
            } else if ((this instanceof RemoteControlActivity) && RemoteControlActivity.x() != null) {
                RemoteControlActivity.x().finish();
                this.G.sendEmptyMessageDelayed(101, 300L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onStart() {
        super.onStart();
        this.s = true;
        MainActivity.J();
        if (com.ecloud.eshare.util.e.b(this)) {
            if (this.A == null) {
                this.A = b.b.a.a.a(this).b();
            }
            a((Runnable) null);
            com.ecloud.eshare.util.e.a((Context) this, false);
        }
        this.E = Executors.newSingleThreadExecutor();
        this.F = new com.ecloud.eshare.e.a(this, this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onStop() {
        super.onStop();
        this.s = false;
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void peerCastRequestHandle(EventCollections.PeerCastRequestEvent peerCastRequestEvent) {
        String str;
        if (!MainActivity.Y0 && this.s) {
            x();
            this.G.removeMessages(4);
            c.a aVar = new c.a(this);
            switch (peerCastRequestEvent.getCastType()) {
                case 0:
                    str = String.format(getString(R.string.host_cast_request_doc), peerCastRequestEvent.getDeviceName());
                    break;
                case 1:
                    str = String.format(getString(R.string.host_cast_request_pics), peerCastRequestEvent.getDeviceName());
                    break;
                case 2:
                    str = String.format(getString(R.string.host_cast_request_audio_video), peerCastRequestEvent.getDeviceName());
                    break;
                case 3:
                case 9:
                default:
                    str = String.format(getString(R.string.host_cast_request_mirror), peerCastRequestEvent.getDeviceName());
                    break;
                case 4:
                    str = String.format(getString(R.string.host_cast_request_remote), peerCastRequestEvent.getDeviceName());
                    break;
                case 5:
                    str = String.format(getString(R.string.host_cast_request_apk), peerCastRequestEvent.getDeviceName());
                    break;
                case 6:
                    str = String.format(getString(R.string.host_cast_request_camera), peerCastRequestEvent.getDeviceName());
                    break;
                case 7:
                    str = String.format(getString(R.string.host_cast_request_mirror), peerCastRequestEvent.getDeviceName());
                    break;
                case 8:
                    str = String.format(getString(R.string.host_cast_full_request_content), peerCastRequestEvent.getDeviceName());
                    break;
                case 10:
                    str = String.format(getString(R.string.host_cast_request_cancel_fullcast), peerCastRequestEvent.getDeviceName());
                    break;
            }
            aVar.a(str);
            if (this.A == null) {
                this.A = b.b.a.a.a(this).b();
            }
            String ip = peerCastRequestEvent.getIp();
            aVar.b(R.string.host_cast_request_ok_btn, new j(ip));
            aVar.a(17039360, new k(ip));
            this.z = aVar.a();
            this.z.show();
            this.G.sendEmptyMessageDelayed(4, 10000L);
        }
    }

    protected abstract void r();

    protected abstract int s();

    protected abstract void t();

    protected abstract void u();
}
