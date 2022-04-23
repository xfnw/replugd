package a.n.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {
    private static final Object f = new Object();
    private static a g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f504a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f505b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f506c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<b> f507d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f508e;

    /* renamed from: a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0024a extends Handler {
        HandlerC0024a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f510a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<c> f511b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f510a = intent;
            this.f511b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f512a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f513b;

        /* renamed from: c  reason: collision with root package name */
        boolean f514c;

        /* renamed from: d  reason: collision with root package name */
        boolean f515d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f512a = intentFilter;
            this.f513b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f513b);
            sb.append(" filter=");
            sb.append(this.f512a);
            if (this.f515d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f504a = context;
        this.f508e = new HandlerC0024a(context.getMainLooper());
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f) {
            if (g == null) {
                g = new a(context.getApplicationContext());
            }
            aVar = g;
        }
        return aVar;
    }

    void a() {
        b[] bVarArr;
        while (true) {
            synchronized (this.f505b) {
                int size = this.f507d.size();
                if (size > 0) {
                    bVarArr = new b[size];
                    this.f507d.toArray(bVarArr);
                    this.f507d.clear();
                } else {
                    return;
                }
            }
            for (b bVar : bVarArr) {
                int size2 = bVar.f511b.size();
                for (int i = 0; i < size2; i++) {
                    c cVar = bVar.f511b.get(i);
                    if (!cVar.f515d) {
                        cVar.f513b.onReceive(this.f504a, bVar.f510a);
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f505b) {
            ArrayList<c> remove = this.f505b.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.f515d = true;
                    for (int i = 0; i < cVar.f512a.countActions(); i++) {
                        String action = cVar.f512a.getAction(i);
                        ArrayList<c> arrayList = this.f506c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.f513b == broadcastReceiver) {
                                    cVar2.f515d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f506c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f505b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f505b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f505b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.f506c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f506c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean a(Intent intent) {
        int i;
        synchronized (this.f505b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f504a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                String str = "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent;
            }
            ArrayList<c> arrayList = this.f506c.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    String str2 = "Action list: " + arrayList;
                }
                ArrayList arrayList2 = null;
                for (int i2 = 0; i2 < arrayList.size(); i2 = i + 1) {
                    c cVar = arrayList.get(i2);
                    if (z) {
                        String str3 = "Matching against filter " + cVar.f512a;
                    }
                    if (cVar.f514c) {
                        i = i2;
                        arrayList = arrayList;
                        action = action;
                        resolveTypeIfNeeded = resolveTypeIfNeeded;
                        arrayList2 = arrayList2;
                    } else {
                        action = action;
                        arrayList2 = arrayList2;
                        i = i2;
                        arrayList = arrayList;
                        resolveTypeIfNeeded = resolveTypeIfNeeded;
                        int match = cVar.f512a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                String str4 = "  Filter matched!  match=0x" + Integer.toHexString(match);
                            }
                            arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList2.add(cVar);
                            cVar.f514c = true;
                        } else if (z) {
                            String str5 = "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category");
                        }
                    }
                }
                if (arrayList2 != null) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        ((c) arrayList2.get(i3)).f514c = false;
                    }
                    this.f507d.add(new b(intent, arrayList2));
                    if (!this.f508e.hasMessages(1)) {
                        this.f508e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
