package com.ecloud.eshare.i;

import com.ecloud.eshare.bean.FileItem;
import java.util.Comparator;

/* loaded from: classes.dex */
public class e implements Comparator<FileItem> {
    /* renamed from: a */
    public int compare(FileItem fileItem, FileItem fileItem2) {
        long lastModified = fileItem.getLastModified();
        long lastModified2 = fileItem2.getLastModified();
        if (lastModified > lastModified2) {
            return -1;
        }
        if (lastModified < lastModified2) {
            return 1;
        }
        return fileItem.getTitle().compareTo(fileItem2.getTitle());
    }
}
