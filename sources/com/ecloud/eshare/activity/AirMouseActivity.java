package com.ecloud.eshare.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import b.b.a.f;
import b.b.a.g;
import b.b.a.i;
import com.ecloud.eshare.bean.EventCollections;
import com.squareup.picasso.R;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class AirMouseActivity extends com.ecloud.eshare.activity.a implements SeekBar.OnSeekBarChangeListener {
    public static AirMouseActivity U;
    private SeekBar H;
    private ImageButton I;
    private ImageButton J;
    private ImageButton K;
    private ImageButton L;
    private i M;
    private ImageView N;
    private ImageView O;
    private TextView Q;
    private g R;
    private f S;
    private float P = 0.85f;
    private Handler T = new a(Looper.getMainLooper());

    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                AirMouseActivity.this.b(true);
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes.dex */
    class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @SuppressLint({"DefaultLocale"})
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            AirMouseActivity.this.P = (i * 1.0f) / 100.0f;
            AirMouseActivity.this.Q.setText(String.format("%s%.2f", AirMouseActivity.this.getString(R.string.remote_airmouse_sensitivity), Float.valueOf(AirMouseActivity.this.P)));
            AirMouseActivity.this.M.a(AirMouseActivity.this.P);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            this.M.a();
        } else {
            this.M.b();
        }
    }

    private void v() {
        this.M.d();
    }

    public static AirMouseActivity w() {
        return U;
    }

    @Override // android.app.Activity
    public void finish() {
        setResult(10, new Intent());
        super.finish();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_CAST) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        RemoteControlActivity remoteControlActivity;
        int i;
        int id = view.getId();
        if (id == R.id.calibrate) {
            v();
        } else if (id != R.id.iv_air_back) {
            switch (id) {
                case R.id.airmouse_back /* 2131230748 */:
                    if (RemoteControlActivity.x() != null) {
                        remoteControlActivity = RemoteControlActivity.x();
                        i = 4;
                        break;
                    } else {
                        return;
                    }
                case R.id.airmouse_home /* 2131230749 */:
                    if (RemoteControlActivity.x() != null) {
                        remoteControlActivity = RemoteControlActivity.x();
                        i = 3;
                        break;
                    } else {
                        return;
                    }
                case R.id.airmouse_keyboard /* 2131230750 */:
                    if (RemoteControlActivity.x() != null) {
                        RemoteControlActivity.x().b(KeyboardActivity.class);
                        return;
                    }
                    return;
                default:
                    return;
            }
            remoteControlActivity.sendKeycode(i);
        } else {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        U = this;
    }

    @Override // androidx.appcompat.app.d, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 25 || i == 24) {
            this.S.e(i);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onPause() {
        super.onPause();
        b(false);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        RemoteControlActivity.I0 = seekBar.getProgress();
        this.R.f(seekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onResume() {
        super.onResume();
        this.T.sendEmptyMessageDelayed(1, 500L);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        RemoteControlActivity.x().e(seekBar.getProgress());
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.Q = (TextView) findViewById(R.id.tiptext);
        this.I = (ImageButton) findViewById(R.id.calibrate);
        this.I.setOnClickListener(this);
        this.J = (ImageButton) findViewById(R.id.airmouse_home);
        this.J.setOnClickListener(this);
        this.K = (ImageButton) findViewById(R.id.airmouse_back);
        this.K.setOnClickListener(this);
        this.L = (ImageButton) findViewById(R.id.airmouse_keyboard);
        this.L.setOnClickListener(this);
        this.N = (ImageView) findViewById(R.id.full_touchPad_mouse);
        this.O = (ImageView) findViewById(R.id.iv_air_back);
        this.O.setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(R.id.vol_progresss);
        seekBar.setThumb(null);
        seekBar.setProgress(RemoteControlActivity.I0);
        seekBar.setOnSeekBarChangeListener(this);
        this.H = (SeekBar) findViewById(R.id.seekfactor);
        this.H.setOnSeekBarChangeListener(new b());
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_air_mouse;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.M = b.b.a.a.a(this).g();
        this.S = b.b.a.a.a(this).c();
        this.R = b.b.a.a.a(this).e();
    }

    @Override // com.ecloud.eshare.activity.a
    @SuppressLint({"DefaultLocale"})
    protected void u() {
        this.N.setOnTouchListener(this.M);
        this.N.setOnClickListener(this);
        this.P = this.M.c();
        this.Q.setText(String.format("%s%.2f", getString(R.string.remote_airmouse_sensitivity), Float.valueOf(this.P)));
        this.H.setProgress((int) (this.P * 100.0f));
        this.H.setThumb(null);
    }
}
