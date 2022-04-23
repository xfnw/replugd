package com.ecloud.eshare.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.squareup.picasso.R;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static b f2921a;

    /* renamed from: b  reason: collision with root package name */
    private static AlertDialog f2922b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            f.f2921a.g();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void g();
    }

    public static ProgressDialog a(Context context) {
        return a(context, (int) R.string.loading_title, (int) R.string.loading_msg);
    }

    public static ProgressDialog a(Context context, int i, int i2) {
        return a(context, context.getString(i), i2 != -1 ? context.getString(i2) : "");
    }

    public static ProgressDialog a(Context context, String str, String str2) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(str);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(true);
        return progressDialog;
    }

    public static Dialog b(Context context, int i, int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(i);
        builder.setPositiveButton(i2, new a());
        f2922b = builder.create();
        return f2922b;
    }

    public static void c(Context context, int i, int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(i);
        builder.setPositiveButton(i2, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void a(b bVar) {
        f2921a = bVar;
    }
}
