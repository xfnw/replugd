package com.ecloud.eshare.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b.a.h;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.util.e;
import com.squareup.picasso.R;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class SettingActivity extends com.ecloud.eshare.activity.a {
    private static SharedPreferences L;
    private TextView H;
    private ImageView I;
    private h J;
    private RelativeLayout K;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SettingActivity.this.H.setText(e.a(SettingActivity.this));
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        if (L == null) {
            L = context.getSharedPreferences("brush", 0);
        }
        return L.getBoolean(str, z);
    }

    public static void b(Context context, String str, boolean z) {
        if (L == null) {
            L = context.getSharedPreferences("brush", 0);
        }
        L.edit().putBoolean(str, z).apply();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        finishActivityEvent.getType();
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_CAST) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.iv_pen_share /* 2131230945 */:
                boolean z = true;
                if (Boolean.valueOf(a(this, "hide", true)).booleanValue()) {
                    this.I.setImageResource(R.drawable.pen_share_on);
                    z = false;
                } else {
                    this.I.setImageResource(R.drawable.pen_share_off);
                }
                b(this, "hide", z);
                if (MainActivity.J().N0.booleanValue()) {
                    this.J.s();
                    return;
                }
                return;
            case R.id.iv_setting_back /* 2131230959 */:
                finish();
                return;
            case R.id.rl_wirte_nfc /* 2131231072 */:
                intent = new Intent(this, WriteNFCTextActivity.class);
                break;
            case R.id.vg_setting_about /* 2131231264 */:
                intent = new Intent();
                intent.setClass(getApplicationContext(), AboutActivity.class);
                break;
            case R.id.vg_setting_name /* 2131231265 */:
                a(new a());
                return;
            default:
                return;
        }
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // a.k.a.d, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.J = b.b.a.a.a(this).f();
        this.H = (TextView) findViewById(R.id.tv_setting_name);
        findViewById(R.id.iv_setting_back).setOnClickListener(this);
        findViewById(R.id.vg_setting_name).setOnClickListener(this);
        findViewById(R.id.vg_setting_about).setOnClickListener(this);
        this.K = (RelativeLayout) findViewById(R.id.rl_wirte_nfc);
        this.K.setOnClickListener(this);
        this.I = (ImageView) findViewById(R.id.iv_pen_share);
        this.I.setOnClickListener(this);
        if (com.ecloud.eshare.util.a.a()) {
            findViewById(R.id.rl_wirte_nfc).setVisibility(8);
            findViewById(R.id.vg_setting_pen).setVisibility(8);
        }
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_setting;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        int i;
        ImageView imageView;
        this.H.setText(e.a(this));
        if (Boolean.valueOf(a(this, "hide", true)).booleanValue()) {
            imageView = this.I;
            i = R.drawable.pen_share_off;
        } else {
            imageView = this.I;
            i = R.drawable.pen_share_on;
        }
        imageView.setImageResource(i);
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
    }
}
