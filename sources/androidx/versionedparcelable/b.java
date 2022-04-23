package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f1566a;

    /* renamed from: b  reason: collision with root package name */
    private final Parcel f1567b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1568c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1569d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1570e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    b(Parcel parcel, int i, int i2, String str) {
        this.f1566a = new SparseIntArray();
        this.f = -1;
        this.g = 0;
        this.f1567b = parcel;
        this.f1568c = i;
        this.f1569d = i2;
        this.g = this.f1568c;
        this.f1570e = str;
    }

    private int d(int i) {
        int readInt;
        do {
            int i2 = this.g;
            if (i2 >= this.f1569d) {
                return -1;
            }
            this.f1567b.setDataPosition(i2);
            int readInt2 = this.f1567b.readInt();
            readInt = this.f1567b.readInt();
            this.g += readInt2;
        } while (readInt != i);
        return this.f1567b.dataPosition();
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i = this.f;
        if (i >= 0) {
            int i2 = this.f1566a.get(i);
            int dataPosition = this.f1567b.dataPosition();
            this.f1567b.setDataPosition(i2);
            this.f1567b.writeInt(dataPosition - i2);
            this.f1567b.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    public void a(Parcelable parcelable) {
        this.f1567b.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void a(String str) {
        this.f1567b.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f1567b.writeInt(bArr.length);
            this.f1567b.writeByteArray(bArr);
            return;
        }
        this.f1567b.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.a
    public boolean a(int i) {
        int d2 = d(i);
        if (d2 == -1) {
            return false;
        }
        this.f1567b.setDataPosition(d2);
        return true;
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f1567b;
        int dataPosition = parcel.dataPosition();
        int i = this.g;
        if (i == this.f1568c) {
            i = this.f1569d;
        }
        return new b(parcel, dataPosition, i, this.f1570e + "  ");
    }

    @Override // androidx.versionedparcelable.a
    public void b(int i) {
        a();
        this.f = i;
        this.f1566a.put(i, this.f1567b.dataPosition());
        c(0);
        c(i);
    }

    @Override // androidx.versionedparcelable.a
    public void c(int i) {
        this.f1567b.writeInt(i);
    }

    @Override // androidx.versionedparcelable.a
    public byte[] d() {
        int readInt = this.f1567b.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1567b.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    public int e() {
        return this.f1567b.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T f() {
        return (T) this.f1567b.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String g() {
        return this.f1567b.readString();
    }
}
