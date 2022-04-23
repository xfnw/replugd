package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f1174a;

    /* renamed from: b  reason: collision with root package name */
    private final g.b f1175b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f1176c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f1177d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Bundle> f1178e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g.b bVar) {
        ArrayList<String> arrayList;
        String str;
        Bundle bundle;
        this.f1175b = bVar;
        this.f1174a = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(bVar.f1169a, bVar.I) : new Notification.Builder(bVar.f1169a);
        Notification notification = bVar.N;
        this.f1174a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, bVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(bVar.f1172d).setContentText(bVar.f1173e).setContentInfo(bVar.j).setContentIntent(bVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(bVar.g, (notification.flags & 128) != 0).setLargeIcon(bVar.i).setNumber(bVar.k).setProgress(bVar.r, bVar.s, bVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f1174a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1174a.setSubText(bVar.p).setUsesChronometer(bVar.n).setPriority(bVar.l);
            Iterator<g.a> it = bVar.f1170b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            Bundle bundle2 = bVar.B;
            if (bundle2 != null) {
                this.f.putAll(bundle2);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (bVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                String str2 = bVar.u;
                if (str2 != null) {
                    this.f.putString("android.support.groupKey", str2);
                    if (bVar.v) {
                        bundle = this.f;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str3 = bVar.w;
                if (str3 != null) {
                    this.f.putString("android.support.sortKey", str3);
                }
            }
            this.f1176c = bVar.F;
            this.f1177d = bVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1174a.setShowWhen(bVar.m);
            if (Build.VERSION.SDK_INT < 21 && (arrayList = bVar.O) != null && !arrayList.isEmpty()) {
                Bundle bundle3 = this.f;
                ArrayList<String> arrayList2 = bVar.O;
                bundle3.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f1174a.setLocalOnly(bVar.x).setGroup(bVar.u).setGroupSummary(bVar.v).setSortKey(bVar.w);
            this.g = bVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1174a.setCategory(bVar.A).setColor(bVar.C).setVisibility(bVar.D).setPublicVersion(bVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = bVar.O.iterator();
            while (it2.hasNext()) {
                this.f1174a.addPerson(it2.next());
            }
            this.h = bVar.H;
            if (bVar.f1171c.size() > 0) {
                Bundle bundle4 = bVar.b().getBundle("android.car.EXTENSIONS");
                bundle4 = bundle4 == null ? new Bundle() : bundle4;
                Bundle bundle5 = new Bundle();
                for (int i = 0; i < bVar.f1171c.size(); i++) {
                    bundle5.putBundle(Integer.toString(i), i.a(bVar.f1171c.get(i)));
                }
                bundle4.putBundle("invisible_actions", bundle5);
                bVar.b().putBundle("android.car.EXTENSIONS", bundle4);
                this.f.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1174a.setExtras(bVar.B).setRemoteInputHistory(bVar.q);
            RemoteViews remoteViews = bVar.F;
            if (remoteViews != null) {
                this.f1174a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = bVar.G;
            if (remoteViews2 != null) {
                this.f1174a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = bVar.H;
            if (remoteViews3 != null) {
                this.f1174a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f1174a.setBadgeIconType(bVar.J).setShortcutId(bVar.K).setTimeoutAfter(bVar.L).setGroupAlertBehavior(bVar.M);
            if (bVar.z) {
                this.f1174a.setColorized(bVar.y);
            }
            if (!TextUtils.isEmpty(bVar.I)) {
                this.f1174a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    private void a(g.a aVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 20) {
            Notification.Action.Builder builder = new Notification.Action.Builder(aVar.e(), aVar.i(), aVar.a());
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : j.a(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.f1174a.addAction(builder.build());
        } else if (i >= 16) {
            this.f1178e.add(i.a(this.f1174a, aVar));
        }
    }

    public Notification a() {
        Bundle a2;
        RemoteViews d2;
        RemoteViews b2;
        g.c cVar = this.f1175b.o;
        if (cVar != null) {
            cVar.a(this);
        }
        RemoteViews c2 = cVar != null ? cVar.c(this) : null;
        Notification b3 = b();
        if (!(c2 == null && (c2 = this.f1175b.F) == null)) {
            b3.contentView = c2;
        }
        if (!(Build.VERSION.SDK_INT < 16 || cVar == null || (b2 = cVar.b(this)) == null)) {
            b3.bigContentView = b2;
        }
        if (!(Build.VERSION.SDK_INT < 21 || cVar == null || (d2 = this.f1175b.o.d(this)) == null)) {
            b3.headsUpContentView = d2;
        }
        if (!(Build.VERSION.SDK_INT < 16 || cVar == null || (a2 = g.a(b3)) == null)) {
            cVar.a(a2);
        }
        return b3;
    }

    protected Notification b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f1174a.build();
        }
        if (i >= 24) {
            Notification build = this.f1174a.build();
            if (this.g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.g != 2)) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f1174a.setExtras(this.f);
            Notification build2 = this.f1174a.build();
            RemoteViews remoteViews = this.f1176c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1177d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.g != 2)) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f1174a.setExtras(this.f);
            Notification build3 = this.f1174a.build();
            RemoteViews remoteViews4 = this.f1176c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1177d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.g != 2)) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> a2 = i.a(this.f1178e);
            if (a2 != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f1174a.setExtras(this.f);
            Notification build4 = this.f1174a.build();
            RemoteViews remoteViews6 = this.f1176c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1177d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i < 16) {
            return this.f1174a.getNotification();
        } else {
            Notification build5 = this.f1174a.build();
            Bundle a3 = g.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = i.a(this.f1178e);
            if (a4 != null) {
                g.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f1176c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f1177d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
