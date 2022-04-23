package com.king.zxing;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public final class b implements MediaPlayer.OnErrorListener, Closeable {
    private static final String f = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final Activity f3269b;

    /* renamed from: c  reason: collision with root package name */
    private MediaPlayer f3270c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3271d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3272e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Activity activity) {
        this.f3269b = activity;
        n();
    }

    @TargetApi(19)
    private MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(q.zxl_beep);
            mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
            mediaPlayer.setOnErrorListener(this);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setLooping(false);
            mediaPlayer.setVolume(0.1f, 0.1f);
            mediaPlayer.prepare();
            if (openRawResourceFd != null) {
                openRawResourceFd.close();
            }
            return mediaPlayer;
        } catch (IOException e2) {
            Log.w(f, e2);
            mediaPlayer.release();
            return null;
        }
    }

    private static boolean a(SharedPreferences sharedPreferences, Context context) {
        boolean z = sharedPreferences.getBoolean("preferences_play_beep", false);
        if (!z || ((AudioManager) context.getSystemService("audio")).getRingerMode() == 2) {
            return z;
        }
        return false;
    }

    public void a(boolean z) {
        this.f3271d = z;
    }

    public void b(boolean z) {
        this.f3272e = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f3270c != null) {
            this.f3270c.release();
            this.f3270c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void m() {
        if (this.f3271d && this.f3270c != null) {
            this.f3270c.start();
        }
        if (this.f3272e) {
            ((Vibrator) this.f3269b.getSystemService("vibrator")).vibrate(200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void n() {
        a(PreferenceManager.getDefaultSharedPreferences(this.f3269b), this.f3269b);
        if (this.f3271d && this.f3270c == null) {
            this.f3269b.setVolumeControlStream(3);
            this.f3270c = a(this.f3269b);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.f3269b.finish();
        } else {
            close();
            n();
        }
        return true;
    }
}
