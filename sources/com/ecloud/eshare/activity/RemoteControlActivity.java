package com.ecloud.eshare.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.AppItem;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.model.a;
import com.ecloud.eshare.util.AutoResizeTextButton;
import com.ecloud.eshare.view.KeysButton;
import com.squareup.picasso.R;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class RemoteControlActivity extends com.ecloud.eshare.activity.a implements a.d, com.ecloud.eshare.d.e, SeekBar.OnSeekBarChangeListener, View.OnLongClickListener {
    public static RemoteControlActivity H0 = null;
    public static int I0 = 10;

    /* renamed from: A0 */
    private ImageView imageview;

    /* renamed from: B0 */
    private ImageView otherimageview;

    /* renamed from: C0 */
    private ViewGroup viewgroup;

    /* renamed from: D0 */
    private ViewGroup otherviewgroup;
    private ImageView F0;
    private ImageView G0;
    private ImageButton K;
    private b.b.a.f L;

    /* renamed from: M */
    private SeekBar seekbar;

    /* renamed from: N */
    private ExecutorService executerService;
    private ImageButton O;
    private ImageView P;
    private ImageButton Q;
    private ViewGroup R;
    private ViewGroup S;
    private ViewGroup T;
    private ViewGroup U;
    private TextView V;
    private TextView W;
    private TextView X;
    private TextView Y;
    private ImageView Z;
    private TextView a0;
    private ImageView b0;
    private AlertDialog d0;
    private RecyclerView e0;
    private ProgressDialog f0;
    private com.ecloud.eshare.model.a g0;
    private com.ecloud.eshare.c.h h0;
    private b.b.a.c i0;
    private KeysButton j0;
    private ImageView k0;
    private b.b.a.g l0;
    private RecyclerView m0;
    private SharedPreferences n0;
    private String o0;
    private String p0;
    private com.ecloud.eshare.c.h s0;
    private AutoResizeTextButton t0;
    private AutoResizeTextButton u0;
    private ImageView v0;
    private ImageView w0;
    private ImageView x0;
    private ImageView y0;
    private ImageView z0;
    private float H = 0.0f;
    private float I = 0.0f;
    @SuppressLint({"HandlerLeak"})
    private final Handler J = new c();
    private boolean c0 = false;
    private String q0 = "";
    private String r0 = "";
    private int E0 = 0;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2699b;

        a(int i) {
            this.f2699b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControlActivity.this.i0.i(RemoteControlActivity.this.h0.d(this.f2699b).getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RemoteControlActivity.this.d0.dismiss();
        }
    }

    /* loaded from: classes.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                c.a.a.e.a(RemoteControlActivity.H0, RemoteControlActivity.this.getString(R.string.host_function_disabled), null, RemoteControlActivity.this.getResources().getColor(R.color.c_666666), RemoteControlActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteControlActivity remoteControlActivity;
            int i;
            int i2;
            if (RemoteControlActivity.this.E0 == 90 || RemoteControlActivity.this.E0 == 270) {
                remoteControlActivity = RemoteControlActivity.this;
                i2 = remoteControlActivity.Z.getMeasuredHeight();
                i = RemoteControlActivity.this.Z.getMeasuredWidth();
            } else {
                remoteControlActivity = RemoteControlActivity.this;
                i2 = remoteControlActivity.Z.getMeasuredWidth();
                i = RemoteControlActivity.this.Z.getMeasuredHeight();
            }
            remoteControlActivity.a(motionEvent, i2, i);
            return false;
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnTouchListener {
        e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteControlActivity remoteControlActivity = RemoteControlActivity.this;
            remoteControlActivity.b(motionEvent, remoteControlActivity.Z.getWidth(), RemoteControlActivity.this.Z.getHeight());
            return false;
        }
    }

    /* loaded from: classes.dex */
    class f implements KeysButton.a {
        f() {
        }

        @Override // com.ecloud.eshare.view.KeysButton.a
        public void a(int i) {
            RemoteControlActivity remoteControlActivity;
            boolean z;
            if (i == 6) {
                remoteControlActivity = RemoteControlActivity.this;
                z = true;
            } else if (i == 8) {
                remoteControlActivity = RemoteControlActivity.this;
                z = false;
            } else {
                return;
            }
            remoteControlActivity.b(z);
            RemoteControlActivity.this.v();
        }

        @Override // com.ecloud.eshare.view.KeysButton.a
        public void b(int i) {
            RemoteControlActivity remoteControlActivity;
            int i2;
            b.b.a.c cVar;
            String str;
            RemoteControlActivity remoteControlActivity2;
            boolean z = true;
            switch (i) {
                case 1:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 19;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                case 2:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 20;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                case 3:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 21;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                case 4:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 22;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                case 5:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 66;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                case 6:
                    if (RemoteControlActivity.this.o0.length() < 1) {
                        remoteControlActivity2 = RemoteControlActivity.this;
                        remoteControlActivity2.b(z);
                        RemoteControlActivity.this.v();
                        return;
                    }
                    cVar = RemoteControlActivity.this.i0;
                    str = RemoteControlActivity.this.o0;
                    cVar.i(str);
                    return;
                case 7:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 92;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                case 8:
                    if (RemoteControlActivity.this.p0.length() < 1) {
                        remoteControlActivity2 = RemoteControlActivity.this;
                        z = false;
                        remoteControlActivity2.b(z);
                        RemoteControlActivity.this.v();
                        return;
                    }
                    cVar = RemoteControlActivity.this.i0;
                    str = RemoteControlActivity.this.p0;
                    cVar.i(str);
                    return;
                case 9:
                    remoteControlActivity = RemoteControlActivity.this;
                    i2 = 93;
                    remoteControlActivity.sendKeycode(i2);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    class g implements View.OnTouchListener {
        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteControlActivity.this.L.a(motionEvent, false, RemoteControlActivity.this.G0.getWidth(), RemoteControlActivity.this.G0.getHeight(), 1.0f);
            RemoteControlActivity.this.a(motionEvent);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class h implements View.OnTouchListener {
        h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RemoteControlActivity.this.L.a(motionEvent, true, RemoteControlActivity.this.F0.getWidth(), RemoteControlActivity.this.F0.getHeight(), 1.0f);
            RemoteControlActivity.this.b(motionEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f2708a;

        i(RemoteControlActivity remoteControlActivity, ImageView imageView) {
            this.f2708a = imageView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2708a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f2709a;

        j(RemoteControlActivity remoteControlActivity, ImageView imageView) {
            this.f2709a = imageView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2709a.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int keycode;

        k(int i) {
            this.keycode = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            RemoteControlActivity.this.L.e(this.keycode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(MotionEvent motionEvent, int i2, int i3) {
        this.L.b(motionEvent, i2, i3, 1.0f);
    }

    public static RemoteControlActivity x() {
        return H0;
    }

    private void y() {
        Intent intent = new Intent(this, AirMouseActivity.class);
        intent.addFlags(67108864);
        startActivityForResult(intent, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b A[LOOP:0: B:10:0x001b->B:19:0x004b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getAction()
            if (r0 != 0) goto L_0x000c
            float r0 = r7.getX()
            r6.H = r0
        L_0x000c:
            float r0 = r7.getX()
            float r1 = r6.H
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0018
            r0 = -1
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            float r1 = r6.H
        L_0x001b:
            float r2 = r7.getX()
            if (r0 <= 0) goto L_0x0026
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x0075
            goto L_0x002a
        L_0x0026:
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0075
        L_0x002a:
            android.widget.ImageView r2 = r6.G0
            int r2 = r2.getWidth()
            android.widget.ImageView r3 = r6.G0
            int r3 = r3.getHeight()
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams
            r5 = -2
            r4.<init>(r5, r3)
            r3 = 1084227584(0x40a00000, float:5.0)
            float r3 = r3 + r1
            int r3 = (int) r3
            int r3 = r3 / 10
            int r3 = r3 * 10
            r4.leftMargin = r3
            int r3 = r4.leftMargin
            if (r3 < r2) goto L_0x004b
            return
        L_0x004b:
            android.widget.ImageView r2 = new android.widget.ImageView
            r2.<init>(r6)
            r3 = 2131165582(0x7f07018e, float:1.7945385E38)
            r2.setImageResource(r3)
            r2.setLayoutParams(r4)
            android.view.ViewGroup r3 = r6.otherviewgroup
            r3.addView(r2)
            r3 = 2130771980(0x7f01000c, float:1.7147065E38)
            android.view.animation.Animation r3 = android.view.animation.AnimationUtils.loadAnimation(r6, r3)
            com.ecloud.eshare.activity.RemoteControlActivity$j r4 = new com.ecloud.eshare.activity.RemoteControlActivity$j
            r4.<init>(r6, r2)
            r3.setAnimationListener(r4)
            r2.startAnimation(r3)
            int r2 = r0 * 10
            float r2 = (float) r2
            float r1 = r1 + r2
            goto L_0x001b
        L_0x0075:
            float r7 = r7.getX()
            r6.H = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.RemoteControlActivity.a(android.view.MotionEvent):void");
    }

    public void a(MotionEvent motionEvent, int i2, int i3) {
        this.L.a(motionEvent, i2, i3, 1.5f);
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i2) {
        String str;
        String str2;
        if (gVar == this.h0) {
            this.executerService.execute(new a(i2));
        }
        com.ecloud.eshare.c.h hVar = this.s0;
        if (gVar == hVar) {
            String packageName = hVar.d(i2).getPackageName();
            String appName = this.s0.d(i2).getAppName();
            if (this.c0) {
                this.o0 = packageName;
                this.t0.setText(appName);
                str2 = "user_key0";
                str = "APP_NAME0";
            } else {
                this.p0 = packageName;
                this.u0.setText(appName);
                str2 = "user_key1";
                str = "APP_NAME1";
            }
            SharedPreferences.Editor edit = this.n0.edit();
            edit.putString(str2, packageName);
            edit.putString(str, appName);
            edit.apply();
            AlertDialog alertDialog = this.d0;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.d0.dismiss();
            }
        }
    }

    @Override // com.ecloud.eshare.model.a.d
    public void a(boolean z, List<AppItem> list) {
        ProgressDialog progressDialog = this.f0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f0.cancel();
        }
        if (z) {
            this.h0 = new com.ecloud.eshare.c.h(this, list, true);
            this.h0.a(this);
            this.e0.setLayoutManager(new GridLayoutManager(this, 4));
            this.e0.setAdapter(this.h0);
            this.s0 = new com.ecloud.eshare.c.h(this, list, true);
            this.s0.a(this);
            RecyclerView recyclerView = this.m0;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
                this.m0.setAdapter(this.s0);
                return;
            }
            return;
        }
        CustomApplication.a((int) R.string.program_list_failed);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a A[LOOP:0: B:10:0x002f->B:19:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void b(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getAction()
            if (r0 != 0) goto L_0x000c
            float r0 = r9.getY()
            r8.I = r0
        L_0x000c:
            float r0 = r9.getY()
            float r1 = r8.I
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0018
            r0 = -1
            goto L_0x0019
        L_0x0018:
            r0 = 1
        L_0x0019:
            android.widget.ImageView r1 = r8.F0
            int r1 = r1.getWidth()
            android.widget.ImageView r2 = r8.F0
            int r2 = r2.getHeight()
            r3 = 2
            int[] r3 = new int[r3]
            android.widget.ImageView r4 = r8.F0
            r4.getLocationOnScreen(r3)
            float r4 = r8.I
        L_0x002f:
            float r5 = r9.getY()
            if (r0 <= 0) goto L_0x003a
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0084
            goto L_0x003e
        L_0x003a:
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 < 0) goto L_0x0084
        L_0x003e:
            android.widget.RelativeLayout$LayoutParams r5 = new android.widget.RelativeLayout$LayoutParams
            r6 = -2
            r5.<init>(r1, r6)
            r6 = 1084227584(0x40a00000, float:5.0)
            float r6 = r6 + r4
            int r6 = (int) r6
            int r6 = r6 / 10
            int r6 = r6 * 10
            r5.topMargin = r6
            r6 = 0
            r6 = r3[r6]
            r5.leftMargin = r6
            int r6 = r5.topMargin
            int r7 = r2 + (-10)
            if (r6 < r7) goto L_0x005a
            return
        L_0x005a:
            android.widget.ImageView r6 = new android.widget.ImageView
            r6.<init>(r8)
            r7 = 2131165584(0x7f070190, float:1.794539E38)
            r6.setImageResource(r7)
            r6.setLayoutParams(r5)
            android.view.ViewGroup r5 = r8.viewgroup
            r5.addView(r6)
            r5 = 2130771980(0x7f01000c, float:1.7147065E38)
            android.view.animation.Animation r5 = android.view.animation.AnimationUtils.loadAnimation(r8, r5)
            r6.startAnimation(r5)
            com.ecloud.eshare.activity.RemoteControlActivity$i r7 = new com.ecloud.eshare.activity.RemoteControlActivity$i
            r7.<init>(r8, r6)
            r5.setAnimationListener(r7)
            int r5 = r0 * 10
            float r5 = (float) r5
            float r4 = r4 + r5
            goto L_0x002f
        L_0x0084:
            float r9 = r9.getY()
            r8.I = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.activity.RemoteControlActivity.b(android.view.MotionEvent):void");
    }

    public void b(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    void b(boolean z) {
        this.c0 = z;
        if (this.d0 == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.custom_apps_layout, (ViewGroup) null);
            this.m0 = (RecyclerView) inflate.findViewById(R.id.appView);
            Button button = (Button) inflate.findViewById(R.id.app_close);
            button.setVisibility(0);
            button.setOnClickListener(new b());
            builder.setView(inflate);
            this.d0 = builder.create();
        }
        if (this.d0 != null && !isFinishing()) {
            this.d0.show();
        }
    }

    /* renamed from: d */
    public void sendKeycode(int keycode) {
        this.executerService.execute(new k(keycode));
    }

    public void e(int i2) {
        this.l0.f(i2);
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_CAST) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, a.k.a.d, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == 10) {
            this.seekbar.setOnSeekBarChangeListener(null);
            this.seekbar.setProgress(I0);
            this.seekbar.setOnSeekBarChangeListener(this);
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        int keycode;
        b.b.a.c cVar;
        String str;
        int id = view.getId();
        if (id == R.id.chumo) {
            w();
            this.S.setVisibility(0);
            this.a0.setText(getString(R.string.remote_tv_touch_control));
            textView = this.W;
        } else if (id == R.id.iv_control_back) {
            finish();
            return;
        } else if (id != R.id.shubiao) {
            switch (id) {
                case R.id.anjian /* 2131230754 */:
                    w();
                    this.T.setVisibility(0);
                    this.a0.setText(getString(R.string.remote_tv_button_control));
                    textView = this.X;
                    break;
                case R.id.app /* 2131230755 */:
                    w();
                    this.U.setVisibility(0);
                    this.a0.setText(getString(R.string.remote_tv_application));
                    this.Y.setSelected(true);
                    break;
                default:
                    switch (id) {
                        case R.id.button_airmouse /* 2131230800 */:
                            y();
                            return;
                        case R.id.button_keyboard /* 2131230801 */:
                            b(KeyboardActivity.class);
                            return;
                        default:
                            switch (id) {
                                case R.id.ib_remote_back /* 2131230889 */:
                                    keycode = 4;
                                    break;
                                case R.id.ib_remote_home /* 2131230890 */:
                                    keycode = 3;
                                    break;
                                default:
                                    switch (id) {
                                        case R.id.keybutton_down /* 2131230965 */:
                                            keycode = 20;
                                            break;
                                        case R.id.keybutton_left /* 2131230966 */:
                                            keycode = 21;
                                            break;
                                        case R.id.keybutton_ok /* 2131230967 */:
                                            keycode = 23;
                                            break;
                                        case R.id.keybutton_right /* 2131230968 */:
                                            keycode = 22;
                                            break;
                                        case R.id.keybutton_right_0 /* 2131230969 */:
                                            keycode = 92;
                                            break;
                                        case R.id.keybutton_right_1 /* 2131230970 */:
                                            keycode = 93;
                                            break;
                                        case R.id.keybutton_up /* 2131230971 */:
                                            keycode = 19;
                                            break;
                                        case R.id.keybutton_userdefine01 /* 2131230972 */:
                                            if (this.o0.length() < 1) {
                                                b(true);
                                                break;
                                            } else {
                                                cVar = this.i0;
                                                str = this.o0;
                                                cVar.i(str);
                                                return;
                                            }
                                        case R.id.keybutton_userdefine02 /* 2131230973 */:
                                            if (this.p0.length() < 1) {
                                                b(false);
                                                break;
                                            } else {
                                                cVar = this.i0;
                                                str = this.p0;
                                                cVar.i(str);
                                                return;
                                            }
                                        default:
                                            return;
                                    }
                            }
                            sendKeycode(keycode);
                            return;
                    }
            }
            v();
            return;
        } else {
            w();
            this.R.setVisibility(0);
            this.a0.setText(getString(R.string.remote_tv_mouse_control));
            textView = this.V;
        }
        textView.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H0 = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        H0 = null;
        this.executerService.shutdown();
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 25 || i2 == 24) {
            this.L.e(i2);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        switch (view.getId()) {
            case R.id.keybutton_userdefine01 /* 2131230972 */:
                b(true);
                break;
            case R.id.keybutton_userdefine02 /* 2131230973 */:
                b(false);
                break;
            default:
                return true;
        }
        v();
        return true;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        if (I0 == 0) {
            e(1);
        }
        I0 = seekBar.getProgress();
        e(I0);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.viewgroup = (ViewGroup) findViewById(R.id.right_layout);
        this.otherviewgroup = (ViewGroup) findViewById(R.id.bottom_layout);
        this.a0 = (TextView) findViewById(R.id.tv_control_title);
        this.Z = (ImageView) findViewById(R.id.iv_mouse_pad);
        this.K = (ImageButton) findViewById(R.id.ib_remote_home);
        this.K.setOnClickListener(this);
        this.O = (ImageButton) findViewById(R.id.ib_remote_back);
        this.O.setOnClickListener(this);
        this.P = (ImageView) findViewById(R.id.button_keyboard);
        this.P.setOnClickListener(this);
        this.Q = (ImageButton) findViewById(R.id.button_airmouse);
        this.Q.setOnClickListener(this);
        this.b0 = (ImageView) findViewById(R.id.touch_pad);
        this.R = (ViewGroup) findViewById(R.id.mouse_id);
        this.S = (ViewGroup) findViewById(R.id.touch_id);
        this.T = (ViewGroup) findViewById(R.id.keys_id);
        this.U = (ViewGroup) findViewById(R.id.apps_id);
        this.V = (TextView) findViewById(R.id.shubiao);
        this.V.setOnClickListener(this);
        this.W = (TextView) findViewById(R.id.chumo);
        this.W.setOnClickListener(this);
        this.X = (TextView) findViewById(R.id.anjian);
        this.X.setOnClickListener(this);
        this.Y = (TextView) findViewById(R.id.app);
        this.Y.setOnClickListener(this);
        this.e0 = (RecyclerView) findViewById(R.id.rv_app);
        this.j0 = (KeysButton) findViewById(R.id.kb_control_keys);
        this.k0 = (ImageView) findViewById(R.id.iv_control_back);
        this.k0.setOnClickListener(this);
        this.seekbar = (SeekBar) findViewById(R.id.vol_progresss);
        this.seekbar.setThumb(null);
        this.seekbar.setProgress(I0);
        this.seekbar.setOnSeekBarChangeListener(this);
        w();
        this.R.setVisibility(0);
        this.a0.setText(getString(R.string.remote_tv_mouse_control));
        this.V.setSelected(true);
        this.v0 = (ImageView) findViewById(R.id.keybutton_up);
        this.v0.setOnClickListener(this);
        this.w0 = (ImageView) findViewById(R.id.keybutton_down);
        this.w0.setOnClickListener(this);
        this.x0 = (ImageView) findViewById(R.id.keybutton_right_0);
        this.x0.setOnClickListener(this);
        this.y0 = (ImageView) findViewById(R.id.keybutton_right_1);
        this.y0.setOnClickListener(this);
        this.z0 = (ImageView) findViewById(R.id.keybutton_left);
        this.z0.setOnClickListener(this);
        this.imageview = (ImageView) findViewById(R.id.keybutton_ok);
        this.imageview.setOnClickListener(this);
        this.otherimageview = (ImageView) findViewById(R.id.keybutton_right);
        this.otherimageview.setOnClickListener(this);
        this.F0 = (ImageView) findViewById(R.id.right_panel);
        this.G0 = (ImageView) findViewById(R.id.bottom_panel);
        this.t0 = (AutoResizeTextButton) findViewById(R.id.keybutton_userdefine01);
        this.u0 = (AutoResizeTextButton) findViewById(R.id.keybutton_userdefine02);
        this.t0.setOnClickListener(this);
        this.t0.setOnLongClickListener(this);
        this.u0.setOnClickListener(this);
        this.u0.setOnLongClickListener(this);
        this.t0.setMinTextSize(12.0f);
        this.t0.b();
        this.u0.setMinTextSize(12.0f);
        this.u0.b();
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.remote_layout;
    }

    @Override // com.ecloud.eshare.activity.a
    @SuppressLint({"ClickableViewAccessibility"})
    protected void t() {
        String str;
        AutoResizeTextButton autoResizeTextButton;
        String str2;
        AutoResizeTextButton autoResizeTextButton2;
        this.r = 2;
        this.L = b.b.a.a.a(this).c();
        this.executerService = Executors.newSingleThreadExecutor();
        this.i0 = b.b.a.a.a(this).b();
        this.l0 = b.b.a.a.a(this).e();
        this.g0 = com.ecloud.eshare.model.a.a();
        this.g0.a((a.d) this);
        this.f0 = com.ecloud.eshare.util.f.a((Context) this);
        this.n0 = PreferenceManager.getDefaultSharedPreferences(this);
        this.o0 = this.n0.getString("user_key0", "");
        this.p0 = this.n0.getString("user_key1", "");
        this.q0 = this.n0.getString("APP_NAME0", "");
        this.r0 = this.n0.getString("APP_NAME1", "");
        if (this.q0.length() < 1) {
            autoResizeTextButton = this.t0;
            str = getString(R.string.user_define);
        } else {
            autoResizeTextButton = this.t0;
            str = this.q0;
        }
        autoResizeTextButton.setText(str);
        if (this.r0.length() < 1) {
            autoResizeTextButton2 = this.u0;
            str2 = getString(R.string.user_define);
        } else {
            autoResizeTextButton2 = this.u0;
            str2 = this.r0;
        }
        autoResizeTextButton2.setText(str2);
        this.G0.setOnTouchListener(new g());
        this.F0.setOnTouchListener(new h());
    }

    @Override // com.ecloud.eshare.activity.a
    @SuppressLint({"ClickableViewAccessibility"})
    protected void u() {
        this.E0 = getIntent().getIntExtra("ROTATION", 0);
        this.Z.setOnTouchListener(new d());
        this.b0.setOnTouchListener(new e());
        this.j0.setButtonClickListener(new f());
    }

    @m
    public void updateMirorrAbility(EventCollections.HeartbeatInfo heartbeatInfo) {
        if (heartbeatInfo.getMirrorMode() == 2) {
            this.J.sendEmptyMessage(1);
            finish();
        }
    }

    public void v() {
        ProgressDialog progressDialog;
        this.g0.a((Context) this);
        if (!isFinishing() && (progressDialog = this.f0) != null && !progressDialog.isShowing()) {
            this.f0.show();
        }
    }

    void w() {
        this.R.setVisibility(8);
        this.S.setVisibility(8);
        this.T.setVisibility(8);
        this.U.setVisibility(8);
        this.V.setSelected(false);
        this.W.setSelected(false);
        this.X.setSelected(false);
        this.Y.setSelected(false);
    }
}
