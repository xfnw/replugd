package com.ecloud.eshare.f;

import android.os.AsyncTask;
import com.ecloud.eshare.bean.DocumentItem;
import com.ecloud.eshare.d.d;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class a extends AsyncTask<Void, Void, ArrayList<DocumentItem>> {

    /* renamed from: a  reason: collision with root package name */
    private d<ArrayList<DocumentItem>> f2796a;

    /* renamed from: b  reason: collision with root package name */
    private String f2797b;

    public a(String str, d<ArrayList<DocumentItem>> dVar) {
        this.f2796a = dVar;
        this.f2797b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<DocumentItem> doInBackground(Void... voidArr) {
        if (isCancelled()) {
            return null;
        }
        File file = new File(this.f2797b);
        ArrayList<DocumentItem> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                DocumentItem documentItem = new DocumentItem(file2);
                if (file2.isDirectory()) {
                    documentItem.setDir(true);
                } else {
                    documentItem.setDir(false);
                }
                if (file2.getName().indexOf(46) != 0) {
                    arrayList.add(documentItem);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(ArrayList<DocumentItem> arrayList) {
        super.onPostExecute(arrayList);
        this.f2796a.a(arrayList);
    }
}
