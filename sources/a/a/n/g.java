package a.a.n;

import a.a.j;
import a.g.l.h;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.widget.b0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    /* renamed from: e  reason: collision with root package name */
    static final Class<?>[] f41e = {Context.class};
    static final Class<?>[] f = f41e;

    /* renamed from: a  reason: collision with root package name */
    final Object[] f42a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f43b;

    /* renamed from: c  reason: collision with root package name */
    Context f44c;

    /* renamed from: d  reason: collision with root package name */
    private Object f45d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        private static final Class<?>[] f46c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        private Object f47a;

        /* renamed from: b  reason: collision with root package name */
        private Method f48b;

        public a(Object obj, String str) {
            this.f47a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f48b = cls.getMethod(str, f46c);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f48b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f48b.invoke(this.f47a, menuItem)).booleanValue();
                }
                this.f48b.invoke(this.f47a, menuItem);
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        a.g.l.b A;
        private CharSequence B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        private Menu f49a;

        /* renamed from: b  reason: collision with root package name */
        private int f50b;

        /* renamed from: c  reason: collision with root package name */
        private int f51c;

        /* renamed from: d  reason: collision with root package name */
        private int f52d;

        /* renamed from: e  reason: collision with root package name */
        private int f53e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private CharSequence k;
        private CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;

        public b(Menu menu) {
            this.f49a = menu;
            d();
        }

        private char a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = g.this.f44c.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (!g.this.f44c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            boolean z2 = menuItem instanceof k;
            if (z2) {
                k kVar = (k) menuItem;
            }
            if (this.r >= 2) {
                if (z2) {
                    ((k) menuItem).c(true);
                } else if (menuItem instanceof l) {
                    ((l) menuItem).a(true);
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f41e, g.this.f42a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            a.g.l.b bVar = this.A;
            if (bVar != null) {
                h.a(menuItem, bVar);
            }
            h.a(menuItem, this.B);
            h.b(menuItem, this.C);
            h.a(menuItem, this.n, this.o);
            h.b(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                h.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                h.a(menuItem, colorStateList);
            }
        }

        public void a() {
            this.h = true;
            a(this.f49a.add(this.f50b, this.i, this.j, this.k));
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f44c.obtainStyledAttributes(attributeSet, j.MenuGroup);
            this.f50b = obtainStyledAttributes.getResourceId(j.MenuGroup_android_id, 0);
            this.f51c = obtainStyledAttributes.getInt(j.MenuGroup_android_menuCategory, 0);
            this.f52d = obtainStyledAttributes.getInt(j.MenuGroup_android_orderInCategory, 0);
            this.f53e = obtainStyledAttributes.getInt(j.MenuGroup_android_checkableBehavior, 0);
            this.f = obtainStyledAttributes.getBoolean(j.MenuGroup_android_visible, true);
            this.g = obtainStyledAttributes.getBoolean(j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public SubMenu b() {
            this.h = true;
            SubMenu addSubMenu = this.f49a.addSubMenu(this.f50b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f44c.obtainStyledAttributes(attributeSet, j.MenuItem);
            this.i = obtainStyledAttributes.getResourceId(j.MenuItem_android_id, 0);
            this.j = (obtainStyledAttributes.getInt(j.MenuItem_android_menuCategory, this.f51c) & (-65536)) | (obtainStyledAttributes.getInt(j.MenuItem_android_orderInCategory, this.f52d) & 65535);
            this.k = obtainStyledAttributes.getText(j.MenuItem_android_title);
            this.l = obtainStyledAttributes.getText(j.MenuItem_android_titleCondensed);
            this.m = obtainStyledAttributes.getResourceId(j.MenuItem_android_icon, 0);
            this.n = a(obtainStyledAttributes.getString(j.MenuItem_android_alphabeticShortcut));
            this.o = obtainStyledAttributes.getInt(j.MenuItem_alphabeticModifiers, 4096);
            this.p = a(obtainStyledAttributes.getString(j.MenuItem_android_numericShortcut));
            this.q = obtainStyledAttributes.getInt(j.MenuItem_numericModifiers, 4096);
            this.r = obtainStyledAttributes.hasValue(j.MenuItem_android_checkable) ? obtainStyledAttributes.getBoolean(j.MenuItem_android_checkable, false) : this.f53e;
            this.s = obtainStyledAttributes.getBoolean(j.MenuItem_android_checked, false);
            this.t = obtainStyledAttributes.getBoolean(j.MenuItem_android_visible, this.f);
            this.u = obtainStyledAttributes.getBoolean(j.MenuItem_android_enabled, this.g);
            this.v = obtainStyledAttributes.getInt(j.MenuItem_showAsAction, -1);
            this.z = obtainStyledAttributes.getString(j.MenuItem_android_onClick);
            this.w = obtainStyledAttributes.getResourceId(j.MenuItem_actionLayout, 0);
            this.x = obtainStyledAttributes.getString(j.MenuItem_actionViewClass);
            this.y = obtainStyledAttributes.getString(j.MenuItem_actionProviderClass);
            boolean z = this.y != null;
            if (z && this.w == 0 && this.x == null) {
                this.A = (a.g.l.b) a(this.y, g.f, g.this.f43b);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.B = obtainStyledAttributes.getText(j.MenuItem_contentDescription);
            this.C = obtainStyledAttributes.getText(j.MenuItem_tooltipText);
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTintMode)) {
                this.E = b0.a(obtainStyledAttributes.getInt(j.MenuItem_iconTintMode, -1), this.E);
            } else {
                this.E = null;
            }
            if (obtainStyledAttributes.hasValue(j.MenuItem_iconTint)) {
                this.D = obtainStyledAttributes.getColorStateList(j.MenuItem_iconTint);
            } else {
                this.D = null;
            }
            obtainStyledAttributes.recycle();
            this.h = false;
        }

        public boolean c() {
            return this.h;
        }

        public void d() {
            this.f50b = 0;
            this.f51c = 0;
            this.f52d = 0;
            this.f53e = 0;
            this.f = true;
            this.g = true;
        }
    }

    public g(Context context) {
        super(context);
        this.f44c = context;
        this.f42a = new Object[]{context};
        this.f43b = this.f42a;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.d();
                        } else if (name2.equals("item")) {
                            if (!bVar.c()) {
                                a.g.l.b bVar2 = bVar.A;
                                if (bVar2 == null || !bVar2.a()) {
                                    bVar.a();
                                } else {
                                    bVar.b();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.b(attributeSet);
                    } else if (name3.equals("menu")) {
                        a(xmlPullParser, attributeSet, bVar.b());
                    } else {
                        str = name3;
                        z2 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    Object a() {
        if (this.f45d == null) {
            this.f45d = a(this.f44c);
        }
        return this.f45d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof a.g.f.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f44c.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
}
