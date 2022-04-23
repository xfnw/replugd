package com.ecloud.eshare.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ecloud.eshare.bean.EventCollections;
import com.squareup.picasso.R;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class AboutActivity extends a {
    private TextView H;
    private Button I;
    private LinearLayout J;

    private String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() == EventCollections.FinishActivityEvent.FINISH_DEFAULT) {
            finish();
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.ivLeft) {
            onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        ((TextView) findViewById(R.id.tvTitle)).setText(R.string.setting_about);
        this.H = (TextView) findViewById(R.id.tv_version);
        this.I = (Button) findViewById(R.id.btn_about_app_update);
        this.I.setOnClickListener(this);
        this.J = (LinearLayout) findViewById(R.id.ll_privacy);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_about;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.H.setText(a((Context) this));
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
    }
}
