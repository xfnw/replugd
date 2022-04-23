package com.eshare.mirror.m;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class b extends ConcurrentLinkedQueue {

    /* renamed from: b  reason: collision with root package name */
    private int f3103b;

    /* renamed from: c  reason: collision with root package name */
    private int f3104c = 0;

    /* renamed from: d  reason: collision with root package name */
    final ReentrantLock f3105d = new ReentrantLock();

    /* renamed from: e  reason: collision with root package name */
    final Condition f3106e = this.f3105d.newCondition();
    final Condition f = this.f3105d.newCondition();

    public b(int i) {
        this.f3103b = 2;
        this.f3103b = i;
    }

    public a a(long j) {
        this.f3105d.lockInterruptibly();
        do {
            try {
                a aVar = (a) peek();
                if (aVar != null) {
                    this.f3104c -= aVar.b();
                    remove();
                    this.f3106e.signal();
                    return aVar;
                }
            } finally {
                this.f3105d.unlock();
            }
        } while (this.f.await(j, TimeUnit.MILLISECONDS));
        return null;
    }

    public void a(a aVar) {
        this.f3105d.lockInterruptibly();
        while (super.size() == this.f3103b) {
            try {
                this.f3106e.await();
            } finally {
                this.f3105d.unlock();
            }
        }
        this.f3104c += aVar.b();
        offer(aVar);
        this.f.signal();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f3105d.lock();
        try {
            super.clear();
            this.f3104c = 0;
            for (int size = super.size(); size > 0; size--) {
                if (!this.f3105d.hasWaiters(this.f3106e)) {
                    break;
                }
                this.f3106e.signal();
            }
        } finally {
            this.f3105d.unlock();
        }
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.AbstractCollection, java.util.Collection
    public int size() {
        this.f3105d.lock();
        try {
            return super.size();
        } finally {
            this.f3105d.unlock();
        }
    }
}
