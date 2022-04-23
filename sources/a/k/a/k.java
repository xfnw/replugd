package a.k.a;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    l[] f445b;

    /* renamed from: c  reason: collision with root package name */
    int[] f446c;

    /* renamed from: d  reason: collision with root package name */
    b[] f447d;

    /* renamed from: e  reason: collision with root package name */
    int f448e;
    int f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<k> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public k[] newArray(int i) {
            return new k[i];
        }
    }

    public k() {
        this.f448e = -1;
    }

    public k(Parcel parcel) {
        this.f448e = -1;
        this.f445b = (l[]) parcel.createTypedArray(l.CREATOR);
        this.f446c = parcel.createIntArray();
        this.f447d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f448e = parcel.readInt();
        this.f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f445b, i);
        parcel.writeIntArray(this.f446c);
        parcel.writeTypedArray(this.f447d, i);
        parcel.writeInt(this.f448e);
        parcel.writeInt(this.f);
    }
}
