package b.c.a.a.s;

import a.d.g;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class a extends a.i.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0055a();

    /* renamed from: d  reason: collision with root package name */
    public final g<String, Bundle> f1755d;

    /* renamed from: b.c.a.a.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0055a implements Parcelable.ClassLoaderCreator<a> {
        C0055a() {
        }

        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    private a(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f1755d = new g<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f1755d.put(strArr[i], bundleArr[i]);
        }
    }

    /* synthetic */ a(Parcel parcel, ClassLoader classLoader, C0055a aVar) {
        this(parcel, classLoader);
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.f1755d = new g<>();
    }

    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.f1755d + "}";
    }

    @Override // a.i.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int size = this.f1755d.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i2 = 0; i2 < size; i2++) {
            strArr[i2] = this.f1755d.b(i2);
            bundleArr[i2] = this.f1755d.d(i2);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
