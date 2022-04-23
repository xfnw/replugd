package com.ecloud.eshare.activity;

import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.ecloud.eshare.util.t;
import com.king.zxing.c;
import com.king.zxing.e;
import com.king.zxing.i;
import com.squareup.picasso.R;

/* loaded from: classes.dex */
public class QRCaptureActivity extends c {

    /* renamed from: e  reason: collision with root package name */
    private TextView f2698e;
    private RelativeLayout f;

    private void a(View view) {
        boolean isSelected = view.isSelected();
        a(!isSelected);
        view.setSelected(!isSelected);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    public void a(boolean z) {
        Camera a2 = a().e().a();
        Camera.Parameters parameters = a2.getParameters();
        com.king.zxing.s.c.b(parameters, z);
        a2.setParameters(parameters);
    }

    @Override // com.king.zxing.c, com.king.zxing.m
    public boolean a(String str) {
        return super.a(str);
    }

    @Override // com.king.zxing.c
    public int c() {
        return R.layout.activity_qrcapture;
    }

    public boolean g() {
        return getPackageManager().hasSystemFeature("android.hardware.camera.flash");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFlash /* 2131230904 */:
                a(view);
                return;
            case R.id.ivLeft /* 2131230905 */:
                onBackPressed();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.king.zxing.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(-16777216);
        t.a(this, toolbar, 0.2f);
        this.f = (RelativeLayout) findViewById(R.id.ll);
        a(this.f, 0, 50, 0, 0);
        TextView textView = (TextView) findViewById(R.id.tvTitle);
        textView.setTextColor(-1);
        textView.setText(getIntent().getStringExtra("QR_TITLE"));
        this.f2698e = (TextView) findViewById(R.id.ivFlash);
        if (!g()) {
            this.f2698e.setVisibility(8);
        }
        e b2 = b();
        b2.b(false);
        b2.d(true);
        b2.a(i.f3296d);
        b2.c(false);
        b2.a(false);
    }
}
