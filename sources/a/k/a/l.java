package a.k.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.r;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final String f449b;

    /* renamed from: c  reason: collision with root package name */
    final int f450c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f451d;

    /* renamed from: e  reason: collision with root package name */
    final int f452e;
    final int f;
    final String g;
    final boolean h;
    final boolean i;
    final Bundle j;
    final boolean k;
    Bundle l;
    c m;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<l> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar) {
        this.f449b = cVar.getClass().getName();
        this.f450c = cVar.f;
        this.f451d = cVar.n;
        this.f452e = cVar.y;
        this.f = cVar.z;
        this.g = cVar.A;
        this.h = cVar.D;
        this.i = cVar.C;
        this.j = cVar.h;
        this.k = cVar.B;
    }

    l(Parcel parcel) {
        this.f449b = parcel.readString();
        this.f450c = parcel.readInt();
        boolean z = true;
        this.f451d = parcel.readInt() != 0;
        this.f452e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() == 0 ? false : z;
        this.l = parcel.readBundle();
    }

    public c a(g gVar, e eVar, c cVar, j jVar, r rVar) {
        if (this.m == null) {
            Context c2 = gVar.c();
            Bundle bundle = this.j;
            if (bundle != null) {
                bundle.setClassLoader(c2.getClassLoader());
            }
            this.m = eVar != null ? eVar.a(c2, this.f449b, this.j) : c.a(c2, this.f449b, this.j);
            Bundle bundle2 = this.l;
            if (bundle2 != null) {
                bundle2.setClassLoader(c2.getClassLoader());
                this.m.f388c = this.l;
            }
            this.m.a(this.f450c, cVar);
            c cVar2 = this.m;
            cVar2.n = this.f451d;
            cVar2.p = true;
            cVar2.y = this.f452e;
            cVar2.z = this.f;
            cVar2.A = this.g;
            cVar2.D = this.h;
            cVar2.C = this.i;
            cVar2.B = this.k;
            cVar2.s = gVar.f409d;
            if (i.F) {
                String str = "Instantiated fragment " + this.m;
            }
        }
        c cVar3 = this.m;
        cVar3.v = jVar;
        cVar3.w = rVar;
        return cVar3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f449b);
        parcel.writeInt(this.f450c);
        parcel.writeInt(this.f451d ? 1 : 0);
        parcel.writeInt(this.f452e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.l);
    }
}
