package com.ecloud.eshare.bean;

import android.text.TextUtils;
import com.ecloud.eshare.a;
import java.io.File;

/* loaded from: classes.dex */
public class AlbumItem extends FileItem {
    private String coverUri;
    private final boolean isCamera;
    private String pathName;
    private int photoCount;

    public AlbumItem(File file) {
        this(file.getAbsolutePath());
    }

    public AlbumItem(File file, String str) {
        this(file.getAbsolutePath());
        this.coverUri = str;
    }

    public AlbumItem(String str) {
        super(str);
        this.isCamera = str.contains(a.f2520b);
        this.pathName = str;
    }

    @Override // com.ecloud.eshare.bean.FileItem
    public boolean equals(Object obj) {
        return TextUtils.equals(getPathName(), ((AlbumItem) obj).getPathName());
    }

    public String getCoverUri() {
        return this.coverUri;
    }

    public String getInfo() {
        return this.title + '(' + this.photoCount + ')';
    }

    public int getPhotoCount() {
        return this.photoCount;
    }

    public boolean isCamera() {
        return this.isCamera;
    }

    public void setCoverUri(String str) {
        this.coverUri = str;
    }

    public void setPhotoCount(int i) {
        this.photoCount = i;
    }

    @Override // com.ecloud.eshare.bean.FileItem
    public String toString() {
        return "AlbumItem <" + this.pathName + " - " + this.photoCount + '>';
    }
}
