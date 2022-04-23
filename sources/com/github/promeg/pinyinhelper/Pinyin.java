package com.github.promeg.pinyinhelper;

/* loaded from: classes.dex */
public final class Pinyin {
    private Pinyin() {
    }

    private static short decodeIndex(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i % 8;
        short s = (short) (bArr2[i] & 255);
        return (bArr[i / 8] & PinyinData.BIT_MASKS[i2]) != 0 ? (short) (s | 256) : s;
    }

    private static int getPinyinCode(char c2) {
        int i = c2 - 19968;
        return (i < 0 || i >= 7000) ? (7000 > i || i >= 14000) ? decodeIndex(PinyinCode3.PINYIN_CODE_PADDING, PinyinCode3.PINYIN_CODE, i - 14000) : decodeIndex(PinyinCode2.PINYIN_CODE_PADDING, PinyinCode2.PINYIN_CODE, i - 7000) : decodeIndex(PinyinCode1.PINYIN_CODE_PADDING, PinyinCode1.PINYIN_CODE, i);
    }

    public static boolean isChinese(char c2) {
        return (19968 <= c2 && c2 <= 40869 && getPinyinCode(c2) > 0) || 12295 == c2;
    }

    public static String toPinyin(char c2) {
        return isChinese(c2) ? c2 == 12295 ? "LING" : PinyinData.PINYIN_TABLE[getPinyinCode(c2)] : String.valueOf(c2);
    }
}
