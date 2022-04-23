package androidx.appcompat.widget;

import a.a.k.a.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.i;

/* loaded from: classes.dex */
public class h extends CheckedTextView {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f968c = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final w f969b;

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(p0.b(context), attributeSet, i);
        this.f969b = new w(this);
        this.f969b.a(attributeSet, i);
        this.f969b.a();
        s0 a2 = s0.a(getContext(), attributeSet, f968c, i, 0);
        setCheckMarkDrawable(a2.b(0));
        a2.a();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f969b;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        k.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.c(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        w wVar = this.f969b;
        if (wVar != null) {
            wVar.a(context, i);
        }
    }
}
