package com.ecloud.eshare;

import android.os.Environment;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2519a = Environment.getExternalStorageDirectory().getAbsolutePath();

    /* renamed from: b  reason: collision with root package name */
    public static final String f2520b = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();

    /* renamed from: c  reason: collision with root package name */
    public static final String f2521c = f2519a + "/.esharecache/video";

    /* renamed from: d  reason: collision with root package name */
    public static final String f2522d = f2521c + "/%s.png";

    /* renamed from: e  reason: collision with root package name */
    public static final String f2523e = f2519a + "/.esharecache/appList";
    public static final String f = f2519a + "/EShare";
}
