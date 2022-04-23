package com.ecloud.eshare.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import com.squareup.picasso.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public final class FadingTextView extends EditText {

    /* renamed from: b  reason: collision with root package name */
    private final AlphaAnimation f2947b = new AlphaAnimation(1.0f, 0.0f);

    /* renamed from: c  reason: collision with root package name */
    private b f2948c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (FadingTextView.this.f2948c != null) {
                FadingTextView.this.f2948c.a(FadingTextView.this.getText());
            }
            FadingTextView.this.setText("");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(int i, KeyEvent keyEvent);

        boolean a(CharSequence charSequence);
    }

    public FadingTextView(Context context) {
        super(context);
        a();
    }

    public FadingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FadingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.f2947b.setDuration(getContext().getResources().getInteger(R.integer.fading_text_timeout));
        this.f2947b.setFillAfter(true);
        this.f2947b.setAnimationListener(new a());
        setAnimation(this.f2947b);
    }

    private void b() {
        this.f2947b.reset();
        this.f2947b.start();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        b bVar = this.f2948c;
        if (bVar != null) {
            bVar.a(i, keyEvent);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!TextUtils.isEmpty(charSequence)) {
            b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setInterceptor(b bVar) {
        this.f2948c = bVar;
    }
}
