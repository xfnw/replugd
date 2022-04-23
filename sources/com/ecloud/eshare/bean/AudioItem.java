package com.ecloud.eshare.bean;

import android.text.TextUtils;
import com.ecloud.eshare.util.c;
import com.github.promeg.pinyinhelper.Pinyin;
import java.io.File;

/* loaded from: classes.dex */
public class AudioItem extends FileItem {
    private long duration;
    private boolean isFirst;
    private String letter;

    public AudioItem(File file) {
        super(file);
    }

    public AudioItem(String str) {
        super(str);
    }

    private void parseLetter() {
        String upperCase;
        String str;
        if (TextUtils.isEmpty(this.title)) {
            this.letter = "#";
        }
        char charAt = this.title.charAt(0);
        if (Pinyin.isChinese(charAt)) {
            str = Pinyin.toPinyin(charAt);
        } else if (charAt >= 'A' && charAt <= 'Z') {
            str = this.title;
        } else if (charAt < 'a' || charAt > 'z') {
            this.letter = "#";
            return;
        } else {
            upperCase = this.title.substring(0, 1).toUpperCase();
            this.letter = upperCase;
        }
        upperCase = str.substring(0, 1);
        this.letter = upperCase;
    }

    public String getDuration() {
        return c.a(this.duration);
    }

    public String getLetter() {
        return this.letter;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    @Override // com.ecloud.eshare.bean.FileItem
    public void setTitle(String str) {
        super.setTitle(str);
        parseLetter();
    }

    @Override // com.ecloud.eshare.bean.FileItem
    public String toString() {
        return "VideoItem <" + this.pathName + " - " + this.title + " - " + this.duration + '>';
    }
}
