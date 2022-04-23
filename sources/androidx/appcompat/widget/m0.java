package androidx.appcompat.widget;

import a.a.ActionBar;
import a.a.f;
import a.h.a.c;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
class m0 extends c implements View.OnClickListener {
    private final SearchView m;
    private final SearchableInfo n;
    private final Context o;
    private final WeakHashMap<String, Drawable.ConstantState> p;
    private final int q;
    private ColorStateList t;
    private boolean r = false;
    private int s = 1;
    private int u = -1;
    private int v = -1;
    private int w = -1;
    private int x = -1;
    private int y = -1;
    private int z = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final TextView f1004a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f1005b;

        /* renamed from: c  reason: collision with root package name */
        public final ImageView f1006c;

        /* renamed from: d  reason: collision with root package name */
        public final ImageView f1007d;

        /* renamed from: e  reason: collision with root package name */
        public final ImageView f1008e;

        public a(View view) {
            this.f1004a = (TextView) view.findViewById(16908308);
            this.f1005b = (TextView) view.findViewById(16908309);
            this.f1006c = (ImageView) view.findViewById(16908295);
            this.f1007d = (ImageView) view.findViewById(16908296);
            this.f1008e = (ImageView) view.findViewById(f.edit_query);
        }
    }

    public m0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        SearchManager searchManager = (SearchManager) this.f343e.getSystemService("search");
        this.m = searchView;
        this.n = searchableInfo;
        this.q = searchView.getSuggestionCommitIconResId();
        this.o = context;
        this.p = weakHashMap;
    }

    private Drawable a(ComponentName componentName) {
        String nameNotFoundException;
        ActivityInfo activityInfo;
        int iconResource;
        PackageManager packageManager = this.f343e.getPackageManager();
        try {
            activityInfo = packageManager.getActivityInfo(componentName, 128);
            iconResource = activityInfo.getIconResource();
        } catch (PackageManager.NameNotFoundException e2) {
            nameNotFoundException = e2.toString();
        }
        if (iconResource == 0) {
            return null;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
        if (drawable != null) {
            return drawable;
        }
        nameNotFoundException = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
        Log.w("SuggestionsAdapter", nameNotFoundException);
        return null;
    }

    private Drawable a(String str) {
        Drawable.ConstantState constantState = this.p.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e2);
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.p.put(str, drawable.getConstantState());
        }
    }

    private Drawable b(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.p.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.p.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.o.getResources());
        }
        Drawable a2 = a(componentName);
        if (a2 != null) {
            constantState = a2.getConstantState();
        }
        this.p.put(flattenToShortString, constantState);
        return a2;
    }

    private Drawable b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            } else {
                InputStream openInputStream = this.o.getContentResolver().openInputStream(uri);
                if (openInputStream != null) {
                    Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                    try {
                        openInputStream.close();
                    } catch (IOException e2) {
                        Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                    }
                    return createFromStream;
                }
                throw new FileNotFoundException("Failed to open " + uri);
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    private Drawable b(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.o.getPackageName() + "/" + parseInt;
            Drawable a2 = a(str2);
            if (a2 != null) {
                return a2;
            }
            Drawable c2 = androidx.core.content.a.c(this.o, parseInt);
            a(str2, c2);
            return c2;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable a3 = a(str);
            if (a3 != null) {
                return a3;
            }
            Drawable b2 = b(Uri.parse(str));
            a(str, b2);
            return b2;
        }
    }

    private CharSequence b(CharSequence charSequence) {
        if (this.t == null) {
            TypedValue typedValue = new TypedValue();
            this.f343e.getTheme().resolveAttribute(ActionBar.textColorSearchUrl, typedValue, true);
            this.t = this.f343e.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.t, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private Drawable d(Cursor cursor) {
        Drawable b2 = b(this.n.getSearchActivity());
        return b2 != null ? b2 : this.f343e.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable e(Cursor cursor) {
        int i = this.x;
        if (i == -1) {
            return null;
        }
        Drawable b2 = b(cursor.getString(i));
        return b2 != null ? b2 : d(cursor);
    }

    private Drawable f(Cursor cursor) {
        int i = this.y;
        if (i == -1) {
            return null;
        }
        return b(cursor.getString(i));
    }

    private void g(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f343e.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    @Override // a.h.a.b.a
    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.m.getVisibility() == 0 && this.m.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.n, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e2) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e2);
            }
        }
        return null;
    }

    Drawable a(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f343e.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    @Override // a.h.a.a, a.h.a.b.a
    public CharSequence a(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, "suggest_intent_query");
        if (a4 != null) {
            return a4;
        }
        if (this.n.shouldRewriteQueryFromData() && (a3 = a(cursor, "suggest_intent_data")) != null) {
            return a3;
        }
        if (!this.n.shouldRewriteQueryFromText() || (a2 = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a2;
    }

    public void a(int i) {
        this.s = i;
    }

    @Override // a.h.a.a
    public void a(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i = this.z;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f1004a != null) {
            a(aVar.f1004a, a(cursor, this.u));
        }
        if (aVar.f1005b != null) {
            String a2 = a(cursor, this.w);
            CharSequence b2 = a2 != null ? b((CharSequence) a2) : a(cursor, this.v);
            if (TextUtils.isEmpty(b2)) {
                TextView textView = aVar.f1004a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f1004a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f1004a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f1004a.setMaxLines(1);
                }
            }
            a(aVar.f1005b, b2);
        }
        ImageView imageView = aVar.f1006c;
        if (imageView != null) {
            a(imageView, e(cursor), 4);
        }
        ImageView imageView2 = aVar.f1007d;
        if (imageView2 != null) {
            a(imageView2, f(cursor), 8);
        }
        int i3 = this.s;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.f1008e.setVisibility(0);
            aVar.f1008e.setTag(aVar.f1004a.getText());
            aVar.f1008e.setOnClickListener(this);
            return;
        }
        aVar.f1008e.setVisibility(8);
    }

    @Override // a.h.a.c, a.h.a.a
    public View b(Context context, Cursor cursor, ViewGroup viewGroup) {
        View b2 = super.b(context, cursor, viewGroup);
        b2.setTag(new a(b2));
        ((ImageView) b2.findViewById(f.edit_query)).setImageResource(this.q);
        return b2;
    }

    @Override // a.h.a.a, a.h.a.b.a
    public void b(Cursor cursor) {
        if (this.r) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.b(cursor);
            if (cursor != null) {
                this.u = cursor.getColumnIndex("suggest_text_1");
                this.v = cursor.getColumnIndex("suggest_text_2");
                this.w = cursor.getColumnIndex("suggest_text_2_url");
                this.x = cursor.getColumnIndex("suggest_icon_1");
                this.y = cursor.getColumnIndex("suggest_icon_2");
                this.z = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e2) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e2);
        }
    }

    @Override // a.h.a.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View a2 = a(this.f343e, this.f342d, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).f1004a.setText(e2.toString());
            }
            return a2;
        }
    }

    @Override // a.h.a.a, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e2) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e2);
            View b2 = b(this.f343e, this.f342d, viewGroup);
            if (b2 != null) {
                ((a) b2.getTag()).f1004a.setText(e2.toString());
            }
            return b2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        g(a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        g(a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.m.a((CharSequence) tag);
        }
    }
}