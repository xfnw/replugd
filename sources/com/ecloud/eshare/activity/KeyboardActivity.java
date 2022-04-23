package com.ecloud.eshare.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.util.r;
import com.ecloud.eshare.view.FadingTextView;
import com.squareup.picasso.R;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public final class KeyboardActivity extends com.ecloud.eshare.activity.a {
    public static KeyboardActivity M;
    private FadingTextView H;
    private ExecutorService I;
    private b.b.a.f J;
    private ImageView K;
    private Boolean L = true;

    /* loaded from: classes.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (RemoteControlActivity.x() == null) {
                return false;
            }
            RemoteControlActivity.x().a(motionEvent, KeyboardActivity.this.K.getMeasuredWidth(), KeyboardActivity.this.K.getMeasuredHeight());
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements FadingTextView.b {
        b() {
        }

        @Override // com.ecloud.eshare.view.FadingTextView.b
        public boolean a(int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            KeyboardActivity.this.finish();
            return false;
        }

        @Override // com.ecloud.eshare.view.FadingTextView.b
        public boolean a(CharSequence charSequence) {
            if (KeyboardActivity.this.L.booleanValue()) {
                KeyboardActivity.this.a(1, 0, charSequence.toString());
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class c implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        int f2561b = 0;

        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (!KeyboardActivity.this.L.booleanValue()) {
                KeyboardActivity.this.L = true;
            }
            KeyboardActivity.this.a(0, this.f2561b, editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f2561b = charSequence.length();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    class d implements r.b {
        d() {
        }

        @Override // com.ecloud.eshare.util.r.b
        public void a(int i) {
            KeyboardActivity.this.finish();
        }

        @Override // com.ecloud.eshare.util.r.b
        public void b(int i) {
        }
    }

    /* loaded from: classes.dex */
    class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 2) {
                String charSequence = textView.getText().toString();
                if (!charSequence.isEmpty()) {
                    KeyboardActivity.this.a(1, 0, charSequence);
                    KeyboardActivity.this.H.setText("");
                    KeyboardActivity.this.L = false;
                } else {
                    ((InputMethodManager) KeyboardActivity.this.getApplicationContext().getSystemService("input_method")).hideSoftInputFromWindow(KeyboardActivity.this.getWindow().getDecorView().getWindowToken(), 0);
                    KeyboardActivity.this.finish();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f2565b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f2566c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f2567d;

        f(int i, int i2, String str) {
            this.f2565b = i;
            this.f2566c = i2;
            this.f2567d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            KeyboardActivity.this.J.a(this.f2565b, this.f2566c, this.f2567d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str) {
        this.I.execute(new f(i, i2, str));
    }

    public static KeyboardActivity v() {
        return M;
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_CAST) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        M = this;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            finish();
        }
        if (i != 67 || this.H.getText().length() > 0 || RemoteControlActivity.x() == null) {
            return true;
        }
        RemoteControlActivity.x().sendKeycode(i);
        return true;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.H = (FadingTextView) findViewById(R.id.text_feedback_chars);
        this.H.requestFocus();
        this.K = (ImageView) findViewById(R.id.touchPad);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_keyboard;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.J = b.b.a.a.a(this).c();
        this.I = Executors.newSingleThreadExecutor();
    }

    @Override // com.ecloud.eshare.activity.a
    @SuppressLint({"ClickableViewAccessibility"})
    protected void u() {
        this.K.setOnTouchListener(new a());
        this.H.setInterceptor(new b());
        this.H.addTextChangedListener(new c());
        r.a(this, new d());
        this.H.setOnEditorActionListener(new e());
    }
}
