package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f919a;

    public b(ActionBarContainer actionBarContainer) {
        this.f919a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f919a;
        if (actionBarContainer.i) {
            Drawable drawable = actionBarContainer.h;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f919a;
        Drawable drawable3 = actionBarContainer2.g;
        if (drawable3 != null && actionBarContainer2.j) {
            drawable3.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable;
        ActionBarContainer actionBarContainer = this.f919a;
        if (actionBarContainer.i) {
            drawable = actionBarContainer.h;
            if (drawable == null) {
                return;
            }
        } else {
            drawable = actionBarContainer.f;
            if (drawable == null) {
                return;
            }
        }
        drawable.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
