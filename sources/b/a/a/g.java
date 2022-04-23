package b.a.a;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class g extends i implements Map<String, i> {

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, i> f1616b = new LinkedHashMap();

    /* renamed from: a */
    public i put(String str, i iVar) {
        if (str == null) {
            return null;
        }
        return iVar == null ? this.f1616b.get(str) : this.f1616b.put(str, iVar);
    }

    public i a(String str, Object obj) {
        return put(str, i.a(obj));
    }

    public HashMap<String, i> a() {
        return this.f1616b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void a(c cVar) {
        super.a(cVar);
        for (Map.Entry<String, i> entry : this.f1616b.entrySet()) {
            new k(entry.getKey()).a(cVar);
            entry.getValue().a(cVar);
        }
    }

    public boolean a(String str) {
        return this.f1616b.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b.a.a.i
    public void b(c cVar) {
        cVar.a(13, this.f1616b.size());
        Set<Map.Entry<String, i>> entrySet = this.f1616b.entrySet();
        for (Map.Entry<String, i> entry : entrySet) {
            cVar.b(cVar.b(new k(entry.getKey())));
        }
        for (Map.Entry<String, i> entry2 : entrySet) {
            cVar.b(cVar.b(entry2.getValue()));
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.f1616b.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f1616b.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f1616b.containsValue(i.a(obj));
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, i>> entrySet() {
        return this.f1616b.entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj.getClass().equals(g.class) && ((g) obj).f1616b.equals(this.f1616b);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public i get(Object obj) {
        return this.f1616b.get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        HashMap<String, i> hashMap = this.f1616b;
        return 581 + (hashMap != null ? hashMap.hashCode() : 0);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f1616b.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.f1616b.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends i> map) {
        for (Map.Entry<? extends String, ? extends i> entry : map.entrySet()) {
            put((String) entry.getKey(), (i) entry.getValue());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map
    public i remove(Object obj) {
        return this.f1616b.remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return this.f1616b.size();
    }

    @Override // java.util.Map
    public Collection<i> values() {
        return this.f1616b.values();
    }
}
