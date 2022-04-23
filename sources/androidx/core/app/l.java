package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l implements Iterable<Intent> {

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Intent> f1182b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Context f1183c;

    /* loaded from: classes.dex */
    public interface a {
        Intent i();
    }

    private l(Context context) {
        this.f1183c = context;
    }

    public static l a(Context context) {
        return new l(context);
    }

    public l a(Activity activity) {
        Intent i = activity instanceof a ? ((a) activity).i() : null;
        if (i == null) {
            i = e.a(activity);
        }
        if (i != null) {
            ComponentName component = i.getComponent();
            if (component == null) {
                component = i.resolveActivity(this.f1183c.getPackageManager());
            }
            a(component);
            a(i);
        }
        return this;
    }

    public l a(ComponentName componentName) {
        int size = this.f1182b.size();
        try {
            Context context = this.f1183c;
            while (true) {
                Intent a2 = e.a(context, componentName);
                if (a2 == null) {
                    return this;
                }
                this.f1182b.add(size, a2);
                context = this.f1183c;
                componentName = a2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public l a(Intent intent) {
        this.f1182b.add(intent);
        return this;
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f1182b.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1182b;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!androidx.core.content.a.a(this.f1183c, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f1183c.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1182b.iterator();
    }
}
