package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class f extends View {

    /* renamed from: b  reason: collision with root package name */
    private int f1132b;

    /* renamed from: c  reason: collision with root package name */
    private View f1133c;

    /* renamed from: d  reason: collision with root package name */
    private int f1134d;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1133c != null) {
            ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f1133c.getLayoutParams();
            aVar2.k0.n(0);
            aVar.k0.o(aVar2.k0.s());
            aVar.k0.g(aVar2.k0.i());
            aVar2.k0.n(8);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1132b == -1 && !isInEditMode()) {
            setVisibility(this.f1134d);
        }
        this.f1133c = constraintLayout.findViewById(this.f1132b);
        View view = this.f1133c;
        if (view != null) {
            ((ConstraintLayout.a) view.getLayoutParams()).Z = true;
            this.f1133c.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1133c;
    }

    public int getEmptyVisibility() {
        return this.f1134d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f1132b != i) {
            View view = this.f1133c;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.a) this.f1133c.getLayoutParams()).Z = false;
                this.f1133c = null;
            }
            this.f1132b = i;
            if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i) {
        this.f1134d = i;
    }
}
