package a.p;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    public View f603b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f602a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<m> f604c = new ArrayList<>();

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f603b == sVar.f603b && this.f602a.equals(sVar.f602a);
    }

    public int hashCode() {
        return (this.f603b.hashCode() * 31) + this.f602a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f603b + "\n") + "    values:";
        for (String str2 : this.f602a.keySet()) {
            str = str + "    " + str2 + ": " + this.f602a.get(str2) + "\n";
        }
        return str;
    }
}
