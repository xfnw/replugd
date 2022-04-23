package com.ecloud.eshare.e;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import b.b.a.g;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.util.l;
import com.ecloud.eshare.util.m;
import com.ecloud.eshare.view.ProgressCircle;
import com.squareup.picasso.R;
import java.io.File;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class a extends Dialog implements View.OnClickListener, m {

    /* renamed from: b  reason: collision with root package name */
    private ProgressCircle f2786b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f2787c;

    /* renamed from: d  reason: collision with root package name */
    private ExecutorService f2788d;

    /* renamed from: e  reason: collision with root package name */
    private g f2789e;
    private e f;
    @SuppressLint({"HandlerLeak"})
    private final Handler g = new HandlerC0078a();

    /* renamed from: com.ecloud.eshare.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0078a extends Handler {

        /* renamed from: com.ecloud.eshare.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0079a implements Runnable {
            RunnableC0079a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Message message;
                HandlerC0078a aVar;
                int u = a.this.f2789e.u();
                a.this.a("getUploadProgress", Integer.valueOf(u));
                switch (u) {
                    case -105:
                        HandlerC0078a aVar2 = HandlerC0078a.this;
                        aVar2.sendMessageDelayed(aVar2.obtainMessage(2), 100L);
                        return;
                    case -104:
                    case -103:
                        aVar = HandlerC0078a.this;
                        message = aVar.obtainMessage(1);
                        aVar.sendMessage(message);
                        return;
                    case -102:
                        aVar = HandlerC0078a.this;
                        message = aVar.obtainMessage(3);
                        aVar.sendMessage(message);
                        return;
                    default:
                        if (u >= 0) {
                            a.this.f2786b.setProgress(u);
                            HandlerC0078a aVar22 = HandlerC0078a.this;
                            aVar22.sendMessageDelayed(aVar22.obtainMessage(2), 100L);
                            return;
                        }
                        aVar = HandlerC0078a.this;
                        message = aVar.obtainMessage(1);
                        aVar.sendMessage(message);
                        return;
                }
            }
        }

        HandlerC0078a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                a.this.cancel();
                CustomApplication.a((int) R.string.document_upload_failed);
            } else if (i == 2) {
                a.this.f2788d.execute(new RunnableC0079a());
            } else if (i == 3) {
                a.this.f2786b.setProgress(100);
                a.this.cancel();
                if (a.this.f != null) {
                    a.this.f.a();
                }
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            return !a.this.isShowing() || super.sendMessageAtTime(message, j);
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnShowListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            a.this.f2786b.setProgress(0);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f2789e.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f2794b;

        d(File file) {
            this.f2794b = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.f2789e.a(this.f2794b)) {
                a.this.g.sendMessage(a.this.g.obtainMessage(1));
            } else {
                a.this.g.sendMessageDelayed(a.this.g.obtainMessage(2), 100L);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    public a(Context context, ExecutorService executorService) {
        super(context, R.style.UploadDialog);
        this.f2788d = executorService;
        this.f2789e = b.b.a.a.a(context).e();
    }

    public void a(e eVar) {
        this.f = eVar;
    }

    public void a(File file) {
        show();
        this.f2788d.execute(new d(file));
    }

    public void a(Object... objArr) {
        l.a(objArr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_document_cancel) {
            this.g.removeMessages(2);
            this.f2788d.execute(new c());
            cancel();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setOnShowListener(new b());
        setContentView(R.layout.dialog_upload);
        this.f2786b = (ProgressCircle) findViewById(R.id.pc_upload);
        this.f2787c = (TextView) findViewById(R.id.tv_document_cancel);
        this.f2787c.setOnClickListener(this);
    }
}
