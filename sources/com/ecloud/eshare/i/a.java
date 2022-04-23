package com.ecloud.eshare.i;

import com.ecloud.eshare.bean.AlbumItem;
import java.util.Comparator;

/* loaded from: classes.dex */
public class a implements Comparator<AlbumItem> {
    /* renamed from: a */
    public int compare(AlbumItem albumItem, AlbumItem albumItem2) {
        if (albumItem.isCamera() && !albumItem2.isCamera()) {
            return -1;
        }
        if (albumItem.isCamera() || !albumItem2.isCamera()) {
            return albumItem.getTitle().compareTo(albumItem2.getTitle());
        }
        return 1;
    }
}
