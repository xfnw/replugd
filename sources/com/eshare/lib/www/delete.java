package com.eshare.lib.www;

import java.io.File;

/* renamed from: com.eshare.lib.j.a */
/* loaded from: classes.dex */
public class delete {
    /* renamed from: a */
    public static boolean deleteDirectory(File file) {
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            boolean z = true;
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    z = deleteFile(listFiles[i].getAbsolutePath());
                    if (!z) {
                        break;
                    }
                } else {
                    z = deleteDirectory(listFiles[i]);
                    if (!z) {
                        break;
                    }
                }
            }
            if (z && file.delete()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (!file.isFile() || !file.exists()) {
            return false;
        }
        file.delete();
        return true;
    }
}
