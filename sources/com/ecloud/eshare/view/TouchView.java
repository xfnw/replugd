package com.ecloud.eshare.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.squareup.picasso.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class TouchView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private Paint f2980b;

    /* renamed from: c  reason: collision with root package name */
    private List<Point> f2981c;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: d  reason: collision with root package name */
    private final Handler f2982d = new a();

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f2983e;

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                if (!TouchView.this.f2981c.isEmpty()) {
                    TouchView.this.f2981c.remove(0);
                    TouchView.this.f2981c.add(new Point(-1, -1));
                    TouchView.this.invalidate();
                }
                sendEmptyMessageDelayed(1, 30L);
            }
        }
    }

    public TouchView(Context context) {
        super(context);
        a(context);
    }

    public TouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public TouchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f2983e = BitmapFactory.decodeResource(context.getResources(), R.drawable.touch_ball);
        this.f2980b = new Paint();
        this.f2981c = new ArrayList();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f2981c.size(); i++) {
            Point point = this.f2981c.get(i);
            if (point.x >= 0 && point.y >= 0) {
                this.f2980b.setAlpha(((i + 1) * 50) / this.f2981c.size());
                canvas.drawBitmap(this.f2983e, point.x, point.y, this.f2980b);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.f2981c.size() >= 15) {
            this.f2981c.remove(0);
        }
        this.f2981c.add(point);
        invalidate();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2982d.removeMessages(1);
        } else if (action == 1 || action == 3) {
            this.f2982d.sendEmptyMessageDelayed(1, 30L);
        }
        return true;
    }
}
