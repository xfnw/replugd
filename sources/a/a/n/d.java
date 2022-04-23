package a.a.n;

import a.a.i;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f28a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f29b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f30c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f31d;

    /* renamed from: e  reason: collision with root package name */
    private Resources f32e;

    public d() {
        super(null);
    }

    public d(Context context, int i) {
        super(context);
        this.f28a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f29b = theme;
    }

    private Resources b() {
        Resources resources;
        if (this.f32e == null) {
            Configuration configuration = this.f31d;
            if (configuration == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(configuration).getResources();
            }
            this.f32e = resources;
        }
        return this.f32e;
    }

    private void c() {
        boolean z = this.f29b == null;
        if (z) {
            this.f29b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f29b.setTo(theme);
            }
        }
        a(this.f29b, this.f28a, z);
    }

    public int a() {
        return this.f28a;
    }

    protected void a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f30c == null) {
            this.f30c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f30c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f29b;
        if (theme != null) {
            return theme;
        }
        if (this.f28a == 0) {
            this.f28a = i.Theme_AppCompat_Light;
        }
        c();
        return this.f29b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f28a != i) {
            this.f28a = i;
            c();
        }
    }
}
