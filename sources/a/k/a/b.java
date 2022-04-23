package a.k.a;

import a.k.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    final int[] f383b;

    /* renamed from: c  reason: collision with root package name */
    final int f384c;

    /* renamed from: d  reason: collision with root package name */
    final int f385d;

    /* renamed from: e  reason: collision with root package name */
    final String f386e;
    final int f;
    final int g;
    final CharSequence h;
    final int i;
    final CharSequence j;
    final ArrayList<String> k;
    final ArrayList<String> l;
    final boolean m;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(a.k.a.a aVar) {
        int size = aVar.f374b.size();
        this.f383b = new int[size * 6];
        if (aVar.i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                a.C0019a aVar2 = aVar.f374b.get(i2);
                int[] iArr = this.f383b;
                int i3 = i + 1;
                iArr[i] = aVar2.f378a;
                int i4 = i3 + 1;
                c cVar = aVar2.f379b;
                iArr[i3] = cVar != null ? cVar.f : -1;
                int[] iArr2 = this.f383b;
                int i5 = i4 + 1;
                iArr2[i4] = aVar2.f380c;
                int i6 = i5 + 1;
                iArr2[i5] = aVar2.f381d;
                int i7 = i6 + 1;
                iArr2[i6] = aVar2.f382e;
                i = i7 + 1;
                iArr2[i7] = aVar2.f;
            }
            this.f384c = aVar.g;
            this.f385d = aVar.h;
            this.f386e = aVar.j;
            this.f = aVar.l;
            this.g = aVar.m;
            this.h = aVar.n;
            this.i = aVar.o;
            this.j = aVar.p;
            this.k = aVar.q;
            this.l = aVar.r;
            this.m = aVar.s;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public b(Parcel parcel) {
        this.f383b = parcel.createIntArray();
        this.f384c = parcel.readInt();
        this.f385d = parcel.readInt();
        this.f386e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.createStringArrayList();
        this.l = parcel.createStringArrayList();
        this.m = parcel.readInt() != 0;
    }

    public a.k.a.a a(i iVar) {
        a.k.a.a aVar = new a.k.a.a(iVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f383b.length) {
            a.C0019a aVar2 = new a.C0019a();
            int i3 = i + 1;
            aVar2.f378a = this.f383b[i];
            if (i.F) {
                String str = "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f383b[i3];
            }
            int i4 = i3 + 1;
            int i5 = this.f383b[i3];
            aVar2.f379b = i5 >= 0 ? iVar.f.get(i5) : null;
            int[] iArr = this.f383b;
            int i6 = i4 + 1;
            aVar2.f380c = iArr[i4];
            int i7 = i6 + 1;
            aVar2.f381d = iArr[i6];
            int i8 = i7 + 1;
            aVar2.f382e = iArr[i7];
            i = i8 + 1;
            aVar2.f = iArr[i8];
            aVar.f375c = aVar2.f380c;
            aVar.f376d = aVar2.f381d;
            aVar.f377e = aVar2.f382e;
            aVar.f = aVar2.f;
            aVar.a(aVar2);
            i2++;
        }
        aVar.g = this.f384c;
        aVar.h = this.f385d;
        aVar.j = this.f386e;
        aVar.l = this.f;
        aVar.i = true;
        aVar.m = this.g;
        aVar.n = this.h;
        aVar.o = this.i;
        aVar.p = this.j;
        aVar.q = this.k;
        aVar.r = this.l;
        aVar.s = this.m;
        aVar.a(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f383b);
        parcel.writeInt(this.f384c);
        parcel.writeInt(this.f385d);
        parcel.writeString(this.f386e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        TextUtils.writeToParcel(this.h, parcel, 0);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeStringList(this.k);
        parcel.writeStringList(this.l);
        parcel.writeInt(this.m ? 1 : 0);
    }
}
