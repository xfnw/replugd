package com.eshare.mirror.m;

/* loaded from: classes.dex */
public abstract class c extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public boolean f3107b = false;

    protected abstract void a();

    public void a(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public boolean b() {
        return this.f3107b && !Thread.interrupted();
    }

    public void c() {
        start();
        while (!this.f3107b) {
            a(25);
        }
    }

    public void d() {
        if (this.f3107b) {
            this.f3107b = false;
            interrupt();
            try {
                join(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3107b = true;
        while (!Thread.interrupted() && this.f3107b) {
            try {
                a();
            } catch (Exception unused) {
            }
        }
        if (System.currentTimeMillis() - currentTimeMillis <= 100) {
            a(100);
        }
        this.f3107b = false;
    }
}
