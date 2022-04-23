package androidx.appcompat.app;

import a.a.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;

/* loaded from: classes.dex */
public class c extends h implements DialogInterface {

    /* renamed from: d  reason: collision with root package name */
    final AlertController f701d = new AlertController(getContext(), this, getWindow());

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.f f702a;

        /* renamed from: b  reason: collision with root package name */
        private final int f703b;

        public a(Context context) {
            this(context, c.a(context, 0));
        }

        public a(Context context, int i) {
            this.f702a = new AlertController.f(new ContextThemeWrapper(context, c.a(context, i)));
            this.f703b = i;
        }

        public a a(int i) {
            AlertController.f fVar = this.f702a;
            fVar.f = fVar.f679a.getText(i);
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f702a;
            fVar.l = fVar.f679a.getText(i);
            this.f702a.n = onClickListener;
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.f702a.s = onCancelListener;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f702a.u = onKeyListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.f702a.f682d = drawable;
            return this;
        }

        public a a(View view) {
            this.f702a.g = view;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f702a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f702a.h = charSequence;
            return this;
        }

        public c a() {
            c cVar = new c(this.f702a.f679a, this.f703b);
            this.f702a.a(cVar.f701d);
            cVar.setCancelable(this.f702a.r);
            if (this.f702a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.f702a.s);
            cVar.setOnDismissListener(this.f702a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f702a.u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.f702a.f679a;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.f702a;
            fVar.i = fVar.f679a.getText(i);
            this.f702a.k = onClickListener;
            return this;
        }

        public a b(View view) {
            AlertController.f fVar = this.f702a;
            fVar.z = view;
            fVar.y = 0;
            fVar.E = false;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f702a.f = charSequence;
            return this;
        }
    }

    protected c(Context context, int i) {
        super(context, a(context, i));
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(ActionBar.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button b(int i) {
        return this.f701d.a(i);
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f701d.a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f701d.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f701d.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f701d.b(charSequence);
    }
}
