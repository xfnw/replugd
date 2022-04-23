package androidx.appcompat.view.menu;

import a.g.l.t;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class h implements a.g.f.a.a {
    private static final int[] A = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    private final Context f808a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f809b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f810c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f811d;

    /* renamed from: e  reason: collision with root package name */
    private a f812e;
    private ContextMenu.ContextMenuInfo m;
    CharSequence n;
    Drawable o;
    View p;
    private k x;
    private boolean z;
    private int l = 0;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<k> v = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<p>> w = new CopyOnWriteArrayList<>();
    private boolean y = false;
    private ArrayList<k> f = new ArrayList<>();
    private ArrayList<k> g = new ArrayList<>();
    private boolean h = true;
    private ArrayList<k> i = new ArrayList<>();
    private ArrayList<k> j = new ArrayList<>();
    private boolean k = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(h hVar);

        boolean a(h hVar, MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(k kVar);
    }

    public h(Context context) {
        this.f808a = context;
        this.f809b = context.getResources();
        e(true);
    }

    private static int a(ArrayList<k> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private k a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new k(this, i, i2, i3, i4, charSequence, i5);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources l = l();
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = l.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = androidx.core.content.a.c(e(), i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        b(false);
    }

    private void a(int i, boolean z) {
        if (i >= 0 && i < this.f.size()) {
            this.f.remove(i);
            if (z) {
                b(true);
            }
        }
    }

    private boolean a(v vVar, p pVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        if (pVar != null) {
            z = pVar.a(vVar);
        }
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar2 = next.get();
            if (pVar2 == null) {
                this.w.remove(next);
            } else if (!z) {
                z = pVar2.a(vVar);
            }
        }
        return z;
    }

    private void d(boolean z) {
        if (!this.w.isEmpty()) {
            s();
            Iterator<WeakReference<p>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<p> next = it.next();
                p pVar = next.get();
                if (pVar == null) {
                    this.w.remove(next);
                } else {
                    pVar.a(z);
                }
            }
            r();
        }
    }

    private void e(boolean z) {
        boolean z2 = true;
        if (!z || this.f809b.getConfiguration().keyboard == 1 || !t.d(ViewConfiguration.get(this.f808a), this.f808a)) {
            z2 = false;
        }
        this.f811d = z2;
    }

    private static int f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = A;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public int a(int i) {
        return a(i, 0);
    }

    public int a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    protected MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int f = f(i3);
        k a2 = a(i, i2, i3, f, charSequence, this.l);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
        if (contextMenuInfo != null) {
            a2.a(contextMenuInfo);
        }
        ArrayList<k> arrayList = this.f;
        arrayList.add(a(arrayList, f), a2);
        b(true);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h a(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    k a(int i, KeyEvent keyEvent) {
        ArrayList<k> arrayList = this.v;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean p = p();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = arrayList.get(i2);
            char alphabeticShortcut = p ? kVar.getAlphabeticShortcut() : kVar.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (p && alphabeticShortcut == '\b' && i == 67))) {
                return kVar;
            }
        }
        return null;
    }

    public void a() {
        a aVar = this.f812e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(d());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((v) item.getSubMenu()).a(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f.size();
        s();
        for (int i = 0; i < size; i++) {
            k kVar = this.f.get(i);
            if (kVar.getGroupId() == groupId && kVar.i() && kVar.isCheckable()) {
                kVar.b(kVar == menuItem);
            }
        }
        r();
    }

    public void a(a aVar) {
        this.f812e = aVar;
    }

    public void a(p pVar) {
        a(pVar, this.f808a);
    }

    public void a(p pVar, Context context) {
        this.w.add(new WeakReference<>(pVar));
        pVar.a(context, this);
        this.k = true;
    }

    void a(List<k> list, int i, KeyEvent keyEvent) {
        boolean p = p();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f.size();
            for (int i2 = 0; i2 < size; i2++) {
                k kVar = this.f.get(i2);
                if (kVar.hasSubMenu()) {
                    ((h) kVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = p ? kVar.getAlphabeticShortcut() : kVar.getNumericShortcut();
                if (((modifiers & 69647) == ((p ? kVar.getAlphabeticModifiers() : kVar.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (p && alphabeticShortcut == '\b' && i == 67)) && kVar.isEnabled()) {
                        list.add(kVar);
                    }
                }
            }
        }
    }

    public final void a(boolean z) {
        if (!this.u) {
            this.u = true;
            Iterator<WeakReference<p>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<p> next = it.next();
                p pVar = next.get();
                if (pVar == null) {
                    this.w.remove(next);
                } else {
                    pVar.a(this, z);
                }
            }
            this.u = false;
        }
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (p) null, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r1 != false) goto L_0x002d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        a(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
        if ((r9 & 1) == 0) goto L_0x002d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
        if (r1 == false) goto L_0x002d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006b, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.view.MenuItem r7, androidx.appcompat.view.menu.p r8, int r9) {
        /*
            r6 = this;
            androidx.appcompat.view.menu.k r7 = (androidx.appcompat.view.menu.k) r7
            r0 = 0
            if (r7 == 0) goto L_0x006c
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000c
            goto L_0x006c
        L_0x000c:
            boolean r1 = r7.g()
            a.g.l.b r2 = r7.a()
            r3 = 1
            if (r2 == 0) goto L_0x001f
            boolean r4 = r2.a()
            if (r4 == 0) goto L_0x001f
            r4 = 1
            goto L_0x0020
        L_0x001f:
            r4 = 0
        L_0x0020:
            boolean r5 = r7.f()
            if (r5 == 0) goto L_0x0031
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x006b
        L_0x002d:
            r6.a(r3)
            goto L_0x006b
        L_0x0031:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x003f
            if (r4 == 0) goto L_0x003a
            goto L_0x003f
        L_0x003a:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x006b
            goto L_0x002d
        L_0x003f:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0046
            r6.a(r0)
        L_0x0046:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0058
            androidx.appcompat.view.menu.v r9 = new androidx.appcompat.view.menu.v
            android.content.Context r0 = r6.e()
            r9.<init>(r0, r6, r7)
            r7.a(r9)
        L_0x0058:
            android.view.SubMenu r7 = r7.getSubMenu()
            androidx.appcompat.view.menu.v r7 = (androidx.appcompat.view.menu.v) r7
            if (r4 == 0) goto L_0x0063
            r2.a(r7)
        L_0x0063:
            boolean r7 = r6.a(r7, r8)
            r1 = r1 | r7
            if (r1 != 0) goto L_0x006b
            goto L_0x002d
        L_0x006b:
            return r1
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.h.a(android.view.MenuItem, androidx.appcompat.view.menu.p, int):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(h hVar, MenuItem menuItem) {
        a aVar = this.f812e;
        return aVar != null && aVar.a(hVar, menuItem);
    }

    public boolean a(k kVar) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == kVar) {
            s();
            Iterator<WeakReference<p>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<p> next = it.next();
                p pVar = next.get();
                if (pVar == null) {
                    this.w.remove(next);
                } else {
                    z = pVar.a(this, kVar);
                    if (z) {
                        break;
                    }
                }
            }
            r();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f809b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f809b.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f808a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f809b.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f809b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        k kVar = (k) a(i, i2, i3, charSequence);
        v vVar = new v(this.f808a, this, kVar);
        kVar.a(vVar);
        return vVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void b() {
        ArrayList<k> n = n();
        if (this.k) {
            Iterator<WeakReference<p>> it = this.w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<p> next = it.next();
                p pVar = next.get();
                if (pVar == null) {
                    this.w.remove(next);
                } else {
                    z |= pVar.a();
                }
            }
            if (z) {
                this.i.clear();
                this.j.clear();
                int size = n.size();
                for (int i = 0; i < size; i++) {
                    k kVar = n.get(i);
                    (kVar.h() ? this.i : this.j).add(kVar);
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(n());
            }
            this.k = false;
        }
    }

    public void b(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((v) item.getSubMenu()).b(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(d(), sparseArray);
        }
    }

    public void b(p pVar) {
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar2 = next.get();
            if (pVar2 == null || pVar2 == pVar) {
                this.w.remove(next);
            }
        }
    }

    public void b(boolean z) {
        if (!this.q) {
            if (z) {
                this.h = true;
                this.k = true;
            }
            d(z);
            return;
        }
        this.r = true;
        if (z) {
            this.s = true;
        }
    }

    public boolean b(k kVar) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        s();
        Iterator<WeakReference<p>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<p> next = it.next();
            p pVar = next.get();
            if (pVar == null) {
                this.w.remove(next);
            } else {
                z = pVar.b(this, kVar);
                if (z) {
                    break;
                }
            }
        }
        r();
        if (z) {
            this.x = kVar;
        }
        return z;
    }

    public h c(int i) {
        this.l = i;
        return this;
    }

    public ArrayList<k> c() {
        b();
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(k kVar) {
        this.k = true;
        b(true);
    }

    public void c(boolean z) {
        this.z = z;
    }

    @Override // android.view.Menu
    public void clear() {
        k kVar = this.x;
        if (kVar != null) {
            a(kVar);
        }
        this.f.clear();
        b(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        b(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h d(int i) {
        a(0, null, i, null, null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return "android:menu:actionviewstates";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(k kVar) {
        this.h = true;
        b(true);
    }

    public Context e() {
        return this.f808a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h e(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    public k f() {
        return this.x;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f.get(i2);
            if (kVar.getItemId() == i) {
                return kVar;
            }
            if (kVar.hasSubMenu() && (findItem = kVar.getSubMenu().findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public Drawable g() {
        return this.o;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f.get(i);
    }

    public CharSequence h() {
        return this.n;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public View i() {
        return this.p;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public ArrayList<k> j() {
        b();
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.t;
    }

    Resources l() {
        return this.f809b;
    }

    public h m() {
        return this;
    }

    public ArrayList<k> n() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            k kVar = this.f.get(i);
            if (kVar.isVisible()) {
                this.g.add(kVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean o() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f810c;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        k a2 = a(i, keyEvent);
        boolean a3 = a2 != null ? a(a2, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    public boolean q() {
        return this.f811d;
    }

    public void r() {
        this.q = false;
        if (this.r) {
            this.r = false;
            b(this.s);
        }
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int a2 = a(i);
        if (a2 >= 0) {
            int size = this.f.size() - a2;
            int i2 = 0;
            while (true) {
                i2++;
                if (i2 >= size || this.f.get(a2).getGroupId() != i) {
                    break;
                }
                a(a2, false);
            }
            b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(b(i), true);
    }

    public void s() {
        if (!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f.get(i2);
            if (kVar.getGroupId() == i) {
                kVar.c(z2);
                kVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f.get(i2);
            if (kVar.getGroupId() == i) {
                kVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            k kVar = this.f.get(i2);
            if (kVar.getGroupId() == i && kVar.e(z)) {
                z2 = true;
            }
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f810c = z;
        b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }
}
