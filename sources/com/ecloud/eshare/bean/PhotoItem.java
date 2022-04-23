package com.ecloud.eshare.bean;

import android.content.Context;
import android.text.format.Formatter;
import com.ecloud.eshare.util.c;
import com.squareup.picasso.R;
import java.io.File;

/* loaded from: classes.dex */
public class PhotoItem extends FileItem {
    private String date;
    private int index;
    private boolean isFirst;
    private boolean isLast;
    private final long size;

    public PhotoItem(File file) {
        super(file);
        this.isLast = true;
        this.size = file.length();
    }

    public PhotoItem(String str) {
        this(new File(str));
    }

    public String getDate() {
        return this.date;
    }

    public int getIndex() {
        return this.index;
    }

    public String getSize(Context context) {
        return Formatter.formatFileSize(context, this.size);
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
        return "PhotoItem <" + this.pathName + " - " + this.date + " - " + this.index + '>';
    }
}
