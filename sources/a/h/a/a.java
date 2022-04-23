package a.h.a;

import a.h.a.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f340b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f341c;

    /* renamed from: d  reason: collision with root package name */
    protected Cursor f342d;

    /* renamed from: e  reason: collision with root package name */
    protected Context f343e;
    protected int f;
    protected C0015a g;
    protected DataSetObserver h;
    protected a.h.a.b i;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0015a extends ContentObserver {
        C0015a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f340b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f340b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    @Override // a.h.a.b.a
    public Cursor a() {
        return this.f342d;
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // a.h.a.b.a
    public abstract CharSequence a(Cursor cursor);

    void a(Context context, Cursor cursor, int i) {
        b bVar;
        boolean z = false;
        if ((i & 1) == 1) {
            i |= 2;
            this.f341c = true;
        } else {
            this.f341c = false;
        }
        if (cursor != null) {
            z = true;
        }
        this.f342d = cursor;
        this.f340b = z;
        this.f343e = context;
        this.f = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.g = new C0015a();
            bVar = new b();
        } else {
            bVar = null;
            this.g = null;
        }
        this.h = bVar;
        if (z) {
            C0015a aVar = this.g;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract View b(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void b() {
        Cursor cursor;
        if (this.f341c && (cursor = this.f342d) != null && !cursor.isClosed()) {
            this.f340b = this.f342d.requery();
        }
    }

    @Override // a.h.a.b.a
    public void b(Cursor cursor) {
        Cursor c2 = c(cursor);
        if (c2 != null) {
            c2.close();
        }
    }

    public Cursor c(Cursor cursor) {
        Cursor cursor2 = this.f342d;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0015a aVar = this.g;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f342d = cursor;
        if (cursor != null) {
            C0015a aVar2 = this.g;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.h;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f = cursor.getColumnIndexOrThrow("_id");
            this.f340b = true;
            notifyDataSetChanged();
        } else {
            this.f = -1;
            this.f340b = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f340b || (cursor = this.f342d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f340b) {
            return null;
        }
        this.f342d.moveToPosition(i);
        if (view == null) {
            view = a(this.f343e, this.f342d, viewGroup);
        }
        a(view, this.f343e, this.f342d);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new a.h.a.b(this);
        }
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f340b || (cursor = this.f342d) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f342d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (!this.f340b || (cursor = this.f342d) == null || !cursor.moveToPosition(i)) {
            return 0L;
        }
        return this.f342d.getLong(this.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f340b) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f342d.moveToPosition(i)) {
            if (view == null) {
                view = b(this.f343e, this.f342d, viewGroup);
            }
            a(view, this.f343e, this.f342d);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }
}
