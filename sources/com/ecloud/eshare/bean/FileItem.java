package com.ecloud.eshare.bean;

import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public abstract class FileItem {
    protected final File file;
    protected final boolean isExists;
    protected final long lastModified;
    protected final String pathName;
    protected String title;

    public FileItem(File file) {
        this.file = file;
        this.pathName = file.getAbsolutePath();
        this.lastModified = file.lastModified();
        this.isExists = file.exists();
        this.title = file.getName();
    }

    public FileItem(String str) {
        this(new File(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.pathName;
        String str2 = ((FileItem) obj).pathName;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public File getFile() {
        return this.file;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getPathName() {
        return this.pathName;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.pathName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isExists() {
        return this.isExists;
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.title = str;
        }
    }

    public String toString() {
        return "FileItem <" + this.pathName + '>';
    }
}
