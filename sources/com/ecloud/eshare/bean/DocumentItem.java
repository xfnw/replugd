package com.ecloud.eshare.bean;

import android.content.Context;
import android.text.format.Formatter;
import com.ecloud.eshare.util.c;
import com.squareup.picasso.R;
import java.io.File;

/* loaded from: classes.dex */
public class DocumentItem extends FileItem {
    private String date;
    private int index;
    private boolean isDir;
    private boolean isFirst;
    private boolean isLast;
    private final int resId;
    private final long size;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006b, code lost:
        if (r1.equals("docx") != false) goto L_0x0146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DocumentItem(java.io.File r4) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ecloud.eshare.bean.DocumentItem.<init>(java.io.File):void");
    }

    public DocumentItem(String str) {
        this(new File(str));
    }

    public String getDate() {
        return this.date;
    }

    public int getIndex() {
        return this.index;
    }

    public int getResId() {
        return this.resId;
    }

    public String getSize(Context context) {
        return Formatter.formatFileSize(context, this.size);
    }

    public boolean isDir() {
        return this.isDir;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public void parseDate(Context context) {
        String a2;
        int i;
        if (c.b(this.lastModified)) {
            i = R.string.media_today;
        } else if (c.c(this.lastModified)) {
            i = R.string.media_yesterday;
        } else {
            a2 = c.a(context.getString(R.string.media_date), this.lastModified);
            this.date = a2;
        }
        a2 = context.getString(i);
        this.date = a2;
    }

    public void setDir(boolean z) {
        this.isDir = z;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setLast(boolean z) {
        this.isLast = z;
    }

    @Override // com.ecloud.eshare.bean.FileItem
    public String toString() {
        return "DocumentItem <" + this.pathName + " - " + this.date + '>';
    }
}
