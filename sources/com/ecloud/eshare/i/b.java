package com.ecloud.eshare.i;

import com.ecloud.eshare.bean.AudioItem;
import java.util.Comparator;

/* loaded from: classes.dex */
public class b implements Comparator<AudioItem> {
    /* renamed from: a */
    public int compare(AudioItem audioItem, AudioItem audioItem2) {
        String letter = audioItem.getLetter();
        String letter2 = audioItem2.getLetter();
        if (letter.equals("#") && !letter2.equals("#")) {
            return 1;
        }
        if (letter.equals("#") || !letter2.equals("#")) {
            return !letter.equals(letter2) ? letter.compareTo(letter2) : audioItem.getTitle().compareTo(audioItem2.getTitle());
        }
        return -1;
    }
}
