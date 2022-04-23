package com.ecloud.eshare.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.bean.MessageEvent;
import com.ecloud.eshare.bean.PhotoItem;
import com.ecloud.eshare.util.i;
import com.ecloud.eshare.view.PinchImageView;
import com.squareup.picasso.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.m;

/* loaded from: classes.dex */
public class ImageActivity extends com.ecloud.eshare.activity.a {
    public static ImageActivity X;
    private ViewPager H;
    private ViewGroup I;
    private TextView J;
    private RelativeLayout K;
    private ImageButton L;
    private h M;
    private List<PhotoItem> N;
    private b.b.a.g O;
    private ExecutorService P;
    private int Q;
    private Matrix R;
    private RectF S;
    private int T;
    private int U;
    @SuppressLint({"HandlerLeak"})
    private Handler V = new a();
    private b.b.a.c W;

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ImageActivity.this.Q++;
                if (ImageActivity.this.Q > ImageActivity.this.N.size()) {
                    ImageActivity.this.Q = 0;
                }
                ImageActivity.this.H.setCurrentItem(ImageActivity.this.Q);
                ImageActivity.this.V.sendEmptyMessageDelayed(0, 5000L);
            } else if (i == 1) {
                ImageActivity.this.v();
            } else if (i == 10) {
                c.a.a.e.a(ImageActivity.this.getApplicationContext(), ImageActivity.this.getString(R.string.host_function_disabled), null, ImageActivity.this.getResources().getColor(R.color.c_666666), ImageActivity.this.getResources().getColor(R.color.white), 0, false, true).show();
                ImageActivity.this.finish();
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes.dex */
    class b extends ViewPager.n {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.n, androidx.viewpager.widget.ViewPager.j
        public void a(int i) {
            ImageActivity.this.U = i;
            super.a(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.n, androidx.viewpager.widget.ViewPager.j
        public void a(int i, float f, int i2) {
            ImageActivity.this.H.findViewWithTag(Integer.valueOf(ImageActivity.this.Q));
            super.a(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void b(int i) {
            View findViewWithTag = ImageActivity.this.H.findViewWithTag(Integer.valueOf(ImageActivity.this.Q));
            if (findViewWithTag instanceof PinchImageView) {
                ((PinchImageView) findViewWithTag).a();
                if (findViewWithTag.getRotation() != 0.0f) {
                    findViewWithTag.setRotation(0.0f);
                }
            }
            ImageActivity.this.Q = i;
            ImageActivity.this.d(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.O.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f2548b;

        d(File file) {
            this.f2548b = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.J.setText(this.f2548b.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f2550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f2551c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f2552d;

        e(File file, File file2, File file3) {
            this.f2550b = file;
            this.f2551c = file2;
            this.f2552d = file3;
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageActivity.this.O.a(this.f2550b, this.f2551c, this.f2552d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ImageActivity.this.K.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ImageActivity.this.I.setVisibility(4);
        }
    }

    /* loaded from: classes.dex */
    class h extends androidx.viewpager.widget.a {

        /* renamed from: a  reason: collision with root package name */
        private PinchImageView f2556a;

        /* loaded from: classes.dex */
        class a implements PinchImageView.g {
            a() {
            }

            @Override // com.ecloud.eshare.view.PinchImageView.g
            public void a(PinchImageView pinchImageView) {
                if (ImageActivity.this.V.hasMessages(0)) {
                    ImageActivity.this.V.removeCallbacksAndMessages(null);
                    ImageActivity.this.L.setBackgroundResource(R.drawable.image_play);
                }
                ImageActivity imageActivity = ImageActivity.this;
                imageActivity.a(pinchImageView.c(imageActivity.R), pinchImageView.a(ImageActivity.this.S), pinchImageView.getInnerImageBound());
            }
        }

        h() {
        }

        @Override // androidx.viewpager.widget.a
        public int a() {
            return ImageActivity.this.N.size();
        }

        @Override // androidx.viewpager.widget.a
        @SuppressLint({"ClickableViewAccessibility"})
        public Object a(ViewGroup viewGroup, int i) {
            this.f2556a = (PinchImageView) View.inflate(ImageActivity.this, R.layout.item_image, null);
            this.f2556a.setTag(Integer.valueOf(i));
            this.f2556a.setImageBitmap(i.a(((PhotoItem) ImageActivity.this.N.get(i)).getPathName(), 1920, 1080));
            this.f2556a.a(new a());
            viewGroup.addView(this.f2556a);
            return this.f2556a;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public boolean a(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Matrix matrix, RectF rectF, RectF rectF2) {
        b.b.a.g gVar;
        a("calculateMatrix", matrix, rectF, rectF2);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float f2 = fArr[0];
        float centerX = (rectF.centerX() - rectF2.centerX()) / rectF2.width();
        float centerY = (rectF.centerY() - rectF2.centerY()) / rectF2.height();
        if (this.W.p()) {
            gVar = this.O;
            centerX = -centerX;
            centerY = -centerY;
        } else {
            gVar = this.O;
        }
        gVar.a(f2, centerX, centerY);
    }

    private void a(PinchImageView pinchImageView) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.T);
        Bitmap a2 = i.a(this.N.get(this.H.getCurrentItem()).getPathName(), 1920, 1080);
        pinchImageView.setImageBitmap(Bitmap.createBitmap(a2, 0, 0, a2.getWidth(), a2.getHeight(), matrix, true));
    }

    private void a(File file, File file2, File file3) {
        this.P.execute(new e(file, file2, file3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i >= 0 && i < this.N.size()) {
            File file = this.N.get(i).getFile();
            File file2 = null;
            File file3 = i > 0 ? this.N.get(i - 1).getFile() : null;
            if (i < this.N.size() - 1) {
                file2 = this.N.get(i + 1).getFile();
            }
            this.T = 0;
            a(file, file3, file2);
            this.J.post(new d(file));
        }
    }

    private void e(List<PhotoItem> list) {
        Collections.sort(list, new com.ecloud.eshare.i.e());
        this.N.clear();
        this.N.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.K.getVisibility() == 0) {
            this.K.setAlpha(1.0f);
            this.K.animate().alpha(0.0f).setDuration(800L).setListener(new f());
            this.I.setAlpha(1.0f);
            this.I.animate().alpha(0.0f).setDuration(800L).setListener(new g());
            return;
        }
        this.K.setAlpha(1.0f);
        this.K.setVisibility(0);
        this.I.setAlpha(1.0f);
        this.I.setVisibility(0);
    }

    public static ImageActivity w() {
        return X;
    }

    private void x() {
        if (this.V.hasMessages(0)) {
            this.V.removeCallbacksAndMessages(null);
            this.L.setBackgroundResource(R.drawable.image_play);
        }
        this.O.c(0);
        this.T -= 90;
        int i = this.T;
        if (i <= 0) {
            this.T = i + 360;
        }
        ViewPager viewPager = this.H;
        PinchImageView pinchImageView = (PinchImageView) viewPager.findViewWithTag(Integer.valueOf(viewPager.getCurrentItem()));
        if (pinchImageView != null) {
            a(pinchImageView);
        }
    }

    private void y() {
        if (this.V.hasMessages(0)) {
            this.V.removeCallbacksAndMessages(null);
            this.L.setBackgroundResource(R.drawable.image_play);
        }
        this.O.c(1);
        this.T += 90;
        int i = this.T;
        if (i >= 360) {
            this.T = i - 360;
        }
        ViewPager viewPager = this.H;
        PinchImageView pinchImageView = (PinchImageView) viewPager.findViewWithTag(Integer.valueOf(viewPager.getCurrentItem()));
        if (pinchImageView != null) {
            a(pinchImageView);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        this.V.removeCallbacksAndMessages(null);
        super.finish();
        this.P.execute(new c());
    }

    @m
    public void finishSelf(EventCollections.FinishActivityEvent finishActivityEvent) {
        if (finishActivityEvent.getType() != EventCollections.FinishActivityEvent.FINISH_MIRROR) {
            this.V.sendEmptyMessage(10);
        }
    }

    @Override // com.ecloud.eshare.activity.a, android.view.View.OnClickListener
    public void onClick(View view) {
        ImageButton imageButton;
        int i;
        int id = view.getId();
        if (id != R.id.ivLeft) {
            switch (id) {
                case R.id.ibtn_photo_play_pause /* 2131230891 */:
                    if (this.V.hasMessages(0)) {
                        this.V.removeCallbacksAndMessages(null);
                        imageButton = this.L;
                        i = R.drawable.image_play;
                    } else {
                        this.V.sendEmptyMessage(0);
                        imageButton = this.L;
                        i = R.drawable.image_stop;
                    }
                    imageButton.setBackgroundResource(i);
                    return;
                case R.id.ibtn_photo_rotate_left /* 2131230892 */:
                    x();
                    return;
                case R.id.ibtn_photo_rotate_right /* 2131230893 */:
                    y();
                    return;
                default:
                    return;
            }
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, androidx.core.app.d, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        X = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ecloud.eshare.activity.a, androidx.appcompat.app.d, a.k.a.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.P.shutdown();
    }

    @m(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        if (this.V.hasMessages(0)) {
            this.V.removeCallbacksAndMessages(null);
            this.L.setBackgroundResource(R.drawable.image_play);
        }
    }

    @Override // com.ecloud.eshare.activity.a
    protected void r() {
        this.H = (ViewPager) findViewById(R.id.vp_image);
        this.I = (ViewGroup) findViewById(R.id.vg_image_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.K = (RelativeLayout) findViewById(R.id.rl_image_bottom);
        this.J = (TextView) findViewById(R.id.tvTitle);
        this.L = (ImageButton) findViewById(R.id.ibtn_photo_play_pause);
        this.L.setOnClickListener(this);
        findViewById(R.id.ibtn_photo_rotate_left).setOnClickListener(this);
        findViewById(R.id.ibtn_photo_rotate_right).setOnClickListener(this);
    }

    @Override // com.ecloud.eshare.activity.a
    protected int s() {
        return R.layout.activity_image;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void t() {
        int i = 0;
        this.r = 0;
        this.R = new Matrix();
        this.S = new RectF();
        this.N = new ArrayList();
        this.M = new h();
        this.P = Executors.newSingleThreadExecutor();
        this.O = b.b.a.a.a(this).e();
        this.W = b.b.a.a.a(this).b();
        ViewConfiguration.get(this).getScaledTouchSlop();
        if (getIntent().getBooleanExtra("share", false)) {
            PhotoItem photoItem = new PhotoItem(new File(getIntent().getStringExtra("path")));
            photoItem.parseDate(this);
            this.N.add(photoItem);
            if (this.Q < this.N.size()) {
                return;
            }
        } else {
            e(PhotoActivity.w().H);
            i = getIntent().getIntExtra("com.eshare.optoma.extra.PHOTO_INDEX", 0);
        }
        this.Q = i;
    }

    @Override // com.ecloud.eshare.activity.a
    protected void u() {
        this.H.setAdapter(this.M);
        this.H.a(new b());
        this.H.setCurrentItem(this.Q);
        d(this.Q);
    }
}
