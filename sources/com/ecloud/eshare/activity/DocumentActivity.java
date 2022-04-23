package com.ecloud.eshare.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.DocumentItem;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.e.a;
import com.ecloud.eshare.model.b;
import com.squareup.picasso.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class DocumentActivity extends com.ecloud.eshare.activity.a implements com.ecloud.eshare.d.e, b.i, com.ecloud.eshare.d.f {
    public static DocumentActivity W;
    private RecyclerView H;
    private SwipeRefreshLayout I;
    private com.ecloud.eshare.c.d J;
    private b.b.a.c K;
    private b.b.a.g L;
    private ExecutorService M;
    private ProgressDialog N;
    private com.ecloud.eshare.e.a O;
    private ArrayList<DocumentItem> P = new ArrayList<>();
    private ArrayList<String> Q = new ArrayList<>();
    private TextView R;
    private TextView S;
    private com.ecloud.eshare.f.a T;
    private int U;
    private com.ecloud.eshare.model.b V;

    /* loaded from: classes.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10) {
                c.a.a.e.a(DocumentActivity.this.getApplicationContext(), DocumentActivity.this.getString(R.string.host_function_disabled), null, DocumentActivity.this.getResources().getColor(R.color.c_666666), DocumentActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
                DocumentActivity.this.finish();
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes.dex */
    class b implements a.e {
        b() {
        }

        @Override // com.ecloud.eshare.e.a.e
        public void a() {
            DocumentActivity.this.startActivity(new Intent(DocumentActivity.this, RemoteControlActivity.class));
        }
    }

    /* loaded from: classes.dex */
    class c implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DocumentItem f2537a;

        c(DocumentItem documentItem) {
            this.f2537a = documentItem;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            int i;
            if (!DocumentActivity.this.L.b(this.f2537a.getFile())) {
                return;
            }
            if (!DocumentActivity.this.K.c() || !DocumentActivity.this.K.c() || (i = DocumentActivity.this.u) == 1 || i == 3) {
                DocumentActivity.this.startActivity(new Intent(DocumentActivity.this, RemoteControlActivity.class));
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements com.ecloud.eshare.f.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DocumentItem f2539a;

        d(DocumentItem documentItem) {
            this.f2539a = documentItem;
        }

        @Override // com.ecloud.eshare.f.d
        public void onSuccess() {
            DocumentActivity.this.a(this.f2539a.getFile());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements com.ecloud.eshare.d.d<ArrayList<DocumentItem>> {
        e() {
        }

        public void a(ArrayList<DocumentItem> arrayList) {
            if (arrayList != null) {
                DocumentActivity.this.P.addAll(arrayList);
                DocumentActivity.this.J.d();
                DocumentActivity.this.J.a(arrayList);
                DocumentActivity.this.H.h(DocumentActivity.this.U);
                DocumentActivity.this.w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f2542b;

        f(String str) {
            this.f2542b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextView textView = DocumentActivity.this.S;
            String str = this.f2542b;
            textView.setText(str.substring(str.lastIndexOf("/") + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DocumentActivity.this.S.setText(R.string.document_title);
        }
    }

    public DocumentActivity() {
        new a(Looper.getMainLooper());
    }

    private void a(String str) {
        com.ecloud.eshare.f.a aVar = this.T;
        if (aVar != null && aVar.getStatus() == AsyncTask.Status.RUNNING) {
            this.T.cancel(true);
        }
        b(str);
        this.T = new com.ecloud.eshare.f.a(str, new e());
        this.T.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void b(String str) {
        if (this.Q.size() >= 2) {
            this.S.post(new f(str));
        } else {
            this.S.post(new g());
        }
    }

    public static DocumentActivity v() {
        return W;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (this.P.size() == 0) {
            this.I.setRefreshing(false);
            this.R.setVisibility(0);
            this.I.setVisibility(4);
            this.H.setVisibility(8);
            return;
        }
        this.I.setVisibility(0);
        this.H.setVisibility(0);
        this.R.setVisibility(8);
    }

    @Override // com.ecloud.eshare.d.e
    public void a(RecyclerView.g gVar, int i) {
        DocumentItem d2;
        if (!this.K.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
            return;
        }
        com.ecloud.eshare.c.d dVar = this.J;
        if (gVar == dVar && (d2 = dVar.d(i)) != null) {
            if (!d2.getFile().isDirectory()) {
                a(0, new c(d2));
            } else if (d2.getFile().canRead()) {
                this.U = i;
                this.Q.add(d2.getPathName());
                this.P.clear();
                a(d2.getPathName());
                this.J.c();
            } else {
                CustomApplication.a((int) R.string.document_access_denied);
            }
        }
    }

    @Override // com.ecloud.eshare.d.f
    public void b(RecyclerView.g gVar, int i) {
        DocumentItem d2;
        if (!this.K.y()) {
            CustomApplication.a((int) R.string.device_not_connected);
            return;
        }
        com.ecloud.eshare.c.d dVar = this.J;
        if (gVar == dVar && (d2 = dVar.d(i)) != null) {
            if (!d2.getFile().isDirectory()) {
                a(0, new d(d2));
            } else if (d2.getFile().canRead()) {
                this.U = i;
                this.Q.add(d2.getPathName());
                this.P.clear();
                a(d2.getPathName());
                this.J.c();
            } else {
                CustomApplication.a((int) R.string.document_access_denied);
            }
        }
    }

    @Override // com.ecloud.eshare.model.b.i
    public void b(List<DocumentItem> list) {
        String str = "onDocumentList----->" + list;
        this.J = new com.ecloud.eshare.c.d(this, list);
        this.J.a((com.ecloud.eshare.d.e) this);
        this.H.setLayoutManager(new LinearLayoutManager(this));
        this.H.setAdapter(this.J);
        this.N.cancel();
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
    }

    @Override // a.k.a.d, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_document_back) {
            onBackPressed();
        } else if (id == R.id.tv_enable_http_server) {
            startActivity(new Intent(this, WirelessStorageSettingActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        W = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.M.shutdown();
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.H = (RecyclerView) findViewById(R.id.rv_document);
        this.H.a(new com.ecloud.eshare.view.b(getResources().getDimensionPixelOffset(R.dimen.size_15dp)));
        this.R = (TextView) findViewById(R.id.tv_doc_empty);
        this.S = (TextView) findViewById(R.id.tv_doc_title);
        findViewById(R.id.iv_document_back).setOnClickListener(this);
        findViewById(R.id.tv_enable_http_server).setOnClickListener(this);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_document;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        this.V = com.ecloud.eshare.model.b.c();
        this.V.a((b.i) this);
        this.N = com.ecloud.eshare.util.f.a((Context) this);
        this.M = Executors.newSingleThreadExecutor();
        this.K = b.b.a.a.a(this).b();
        this.L = b.b.a.a.a(this).e();
        this.O = new com.ecloud.eshare.e.a(this, this.M);
        this.O.a(new b());
        this.V.d(this);
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
    }
}
