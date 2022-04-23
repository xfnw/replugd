package com.ecloud.eshare.activity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.widget.Toast;
import b.b.a.c;
import com.squareup.picasso.R;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WriteNFCTextActivity extends Activity {

    /* renamed from: b  reason: collision with root package name */
    private c f2721b;

    /* renamed from: c  reason: collision with root package name */
    private String f2722c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f2723d;

    /* renamed from: e  reason: collision with root package name */
    private String f2724e;
    protected NfcAdapter f;
    private PendingIntent g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String C = WriteNFCTextActivity.this.f2721b.C();
            String str = "netWorkInfo===>" + C;
            if (C != null) {
                try {
                    JSONObject jSONObject = new JSONObject(C);
                    String string = jSONObject.getString("password");
                    String str2 = "password===>" + string;
                    String string2 = jSONObject.getString("ipAddress");
                    String str3 = "ipAddress===>" + string2;
                    String string3 = jSONObject.getString("ssid");
                    String str4 = "ssid===>" + string3;
                    WriteNFCTextActivity.this.f2722c = "ssid=" + string3 + "&ip=" + string2 + "&password=" + string + "&mode=0";
                    StringBuilder sb = new StringBuilder();
                    sb.append("nfcData==>");
                    sb.append(WriteNFCTextActivity.this.f2722c);
                    sb.toString();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else {
                WriteNFCTextActivity.this.f2722c = "ssid= &ip=" + WriteNFCTextActivity.this.f2724e + "&password= &mode=0";
                StringBuilder sb2 = new StringBuilder();
                sb2.append("nfcData old===>");
                sb2.append(WriteNFCTextActivity.this.f2722c);
                sb2.toString();
            }
        }
    }

    private void a() {
        this.f2723d = Executors.newSingleThreadExecutor();
        this.f2721b = b.b.a.a.a(this).b();
        this.f2724e = b.b.a.a.a(this).d();
        this.f2723d.execute(new a());
    }

    public static boolean a(NdefMessage ndefMessage, Tag tag) {
        try {
            Ndef ndef = Ndef.get(tag);
            ndef.connect();
            ndef.writeNdefMessage(ndefMessage);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_write_n_f_c_text);
        a();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f2723d.shutdown();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        String str = "intent========>" + intent.getAction();
        if (this.f2722c != null) {
            boolean a2 = a(new NdefMessage(NdefRecord.createMime("application/com.ecloud.eshare", this.f2722c.getBytes()), new NdefRecord[0]), (Tag) intent.getParcelableExtra("android.nfc.extra.TAG"));
            String str2 = "nfc result===>" + a2;
            Toast.makeText(this, a2 ? "写入成功" : "写入失败", 0).show();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = this.f;
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        NfcAdapter nfcAdapter = this.f;
        if (nfcAdapter != null) {
            nfcAdapter.enableForegroundDispatch(this, this.g, null, null);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f = NfcAdapter.getDefaultAdapter(this);
        this.g = PendingIntent.getActivity(this, 0, new Intent(this, WriteNFCTextActivity.class), 0);
    }
}
