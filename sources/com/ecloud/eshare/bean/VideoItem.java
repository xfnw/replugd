package com.ecloud.eshare.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.ecloud.eshare.a;
import com.ecloud.eshare.util.c;
import com.squareup.picasso.R;
import java.io.File;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class VideoItem extends FileItem {
    private String date;
    private long duration;
    private int index;
    private boolean isFirst;
    private boolean isLast;
    private final String thumbPath;
    private Bitmap thumbnail;

    public VideoItem(File file) {
        super(file);
        this.isLast = true;
        this.thumbPath = String.format(a.f2522d, this.pathName.replace(a.f2519a, "").replaceAll("/", Pattern.quote("$")));
    }

    public VideoItem(String str) {
        this(new File(str));
    }

    public String getDate() {
        return this.date;
    }

    public String getDuration() {
        return c.a(this.duration);
    }

    public int getIndex() {
        return this.index;
    }

    public String getThumbPath() {
        return this.thumbPath;
    }

    public Bitmap getThumbnail() {
        return this.thumbnail;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isThumbExists() {
        return !TextUtils.isEmpty(this.thumbPath) && new File(this.thumbPath).exists();
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

    public void setDuration(long j) {
        this.duration = j;
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

    public void setThumbnail(Bitmap bitmap) {
        this.thumbnail = bitmap;
    }

    @Override // com.ecloud.eshare.bean.FileItem
    public String toString() {
        return "VideoItem <" + this.pathName + " - " + this.title + " - " + this.duration + '>';
    }
}
