package com.ecloud.eshare.activity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import b.b.a.e;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.util.c;
import com.squareup.picasso.R;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class WirelessStorageSettingActivity extends com.ecloud.eshare.activity.a {
    private TextView H;
    private TextView I;
    private TextView J;
    private ImageButton K;
    private e L;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WirelessStorageSettingActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z = !WirelessStorageSettingActivity.this.L.v();
            WirelessStorageSettingActivity.this.L.f(z);
            if (z) {
                WirelessStorageSettingActivity.this.w();
            } else {
                WirelessStorageSettingActivity.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.J.setText(R.string.document_storage_enable);
        this.I.setVisibility(4);
        this.H.setText(R.string.document_storage_disable_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.I.setVisibility(0);
        this.I.setText("http://" + c.a(this) + ":" + this.L.t());
        this.H.setText(R.string.document_storage_enable_content);
        this.J.setText(R.string.document_storage_disable);
    }

    private void x() {
        if (this.L.v()) {
            w();
        } else {
            v();
        }
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        finish();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        double width = ((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth();
        Double.isNaN(width);
        attributes.width = (int) (width * 0.85d);
        attributes.height = -2;
        window.setAttributes(attributes);
        this.H = (TextView) findViewById(R.id.tv_wireless_storage_content);
        this.I = (TextView) findViewById(R.id.tv_wireless_storage_ip);
        this.J = (TextView) findViewById(R.id.tv_wireless_storage_enable);
        this.K = (ImageButton) findViewById(R.id.ibtn_wireless_storage_close);
        this.K.setOnClickListener(new a());
        this.J.setOnClickListener(new b());
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_wireless_storage_setting;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.L = b.b.a.a.a(this).h();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        x();
    }
}
