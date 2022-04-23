package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.d0;

/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements d0 {

    /* renamed from: b  reason: collision with root package name */
    private d0.a f868b;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        d0.a aVar = this.f868b;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.d0
    public void setOnFitSystemWindowsListener(d0.a aVar) {
        this.f868b = aVar;
    }
}
