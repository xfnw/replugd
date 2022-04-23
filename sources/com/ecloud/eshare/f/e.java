package com.ecloud.eshare.f;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import b.b.a.c;
import b.b.a.n.b;
import com.ecloud.eshare.CustomApplication;
import com.ecloud.eshare.bean.ClientInfo;
import com.ecloud.eshare.bean.EventCollections;
import com.ecloud.eshare.bean.MessageEvent;
import com.ecloud.eshare.util.h;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class e extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public long f2811b;

    /* renamed from: c  reason: collision with root package name */
    public long f2812c;

    /* renamed from: d  reason: collision with root package name */
    public long f2813d;

    /* renamed from: e  reason: collision with root package name */
    public long f2814e;
    public long f;
    private volatile boolean k;
    private a l;
    private c m;
    public long g = 350;
    private int h = -2;
    private int i = -2;
    private int j = 0;
    private Gson n = new Gson();

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i);

        void a(String str);

        void a(List<ClientInfo> list);

        void a(boolean z);

        void b();

        void c();
    }

    public e(c cVar, a aVar) {
        this.m = cVar;
        this.l = aVar;
    }

    private void a(JsonObject jsonObject) {
        EventCollections.HeartbeatInfo heartbeatInfo = new EventCollections.HeartbeatInfo();
        if (jsonObject.has("castMode")) {
            heartbeatInfo.setCastMode(jsonObject.get("castMode").getAsInt());
        }
        boolean z = false;
        if (jsonObject.has("hostCastable")) {
            int asInt = jsonObject.get("hostCastable").getAsInt();
            if (asInt != 1) {
                asInt = asInt == -1 ? 0 : 2;
            }
            heartbeatInfo.setCastMode(asInt);
        }
        if (jsonObject.has("mirrorMode")) {
            heartbeatInfo.setMirrorMode(jsonObject.get("mirrorMode").getAsInt());
        }
        if (jsonObject.has("hostInteract")) {
            int asInt2 = jsonObject.get("hostInteract").getAsInt();
            if (asInt2 != 1) {
                asInt2 = asInt2 == -1 ? 0 : 2;
            }
            heartbeatInfo.setMirrorMode(asInt2);
        }
        if (jsonObject.has("multiScreen")) {
            int asInt3 = jsonObject.get("multiScreen").getAsInt();
            if (this.i != asInt3) {
                this.i = asInt3;
                z = true;
            }
            heartbeatInfo.setMultiScreen(asInt3);
        }
        if (jsonObject.has("castState")) {
            int asInt4 = jsonObject.get("castState").getAsInt();
            if (this.h != asInt4 || z) {
                this.h = asInt4;
                this.l.a(asInt4);
            }
            heartbeatInfo.setCastState(asInt4);
        }
        org.greenrobot.eventbus.c.d().a(heartbeatInfo);
    }

    @SuppressLint({"NewApi"})
    private void a(String str) {
        org.greenrobot.eventbus.c d2;
        Object hVar;
        org.greenrobot.eventbus.c d3;
        Object peerDeviceDealtEvent;
        for (String str2 : new String(str.getBytes("UTF-8"), "UTF-8").split(System.lineSeparator())) {
            JsonObject asJsonObject = JsonParser.parseString(str2.trim()).getAsJsonObject();
            if (asJsonObject.has("replyHeartbeat") || asJsonObject.has("hostHeartBeat")) {
                a(asJsonObject);
            } else if (!asJsonObject.has("disconnectClient") && !asJsonObject.has("disconnectWithServer")) {
                if (asJsonObject.has("replyCastRequest")) {
                    int asInt = asJsonObject.get("replyCastRequest").getAsInt();
                    d2 = org.greenrobot.eventbus.c.d();
                    hVar = new EventCollections.CastRequestEvent(asInt);
                } else if (asJsonObject.has("allowCast")) {
                    int asInt2 = asJsonObject.get("allowCast").getAsInt();
                    d2 = org.greenrobot.eventbus.c.d();
                    hVar = new EventCollections.CastRequestEvent(asInt2);
                } else {
                    boolean z = true;
                    if (asJsonObject.has("imageControl")) {
                        d3 = org.greenrobot.eventbus.c.d();
                        peerDeviceDealtEvent = new MessageEvent(1);
                    } else if (asJsonObject.has("addModerator")) {
                        if (System.currentTimeMillis() - this.f2813d >= this.g) {
                            this.f2813d = System.currentTimeMillis();
                            this.l.a(true);
                        } else {
                            return;
                        }
                    } else if (asJsonObject.has("removeModerator")) {
                        if (System.currentTimeMillis() - this.f2813d >= this.g) {
                            this.f2813d = System.currentTimeMillis();
                            this.l.a(false);
                        } else {
                            return;
                        }
                    } else if (asJsonObject.has("inviteCast") || asJsonObject.has("castInvitation")) {
                        if (System.currentTimeMillis() - this.f >= this.g) {
                            EventCollections.FinishActivityEvent finishActivityEvent = new EventCollections.FinishActivityEvent();
                            finishActivityEvent.setType(EventCollections.FinishActivityEvent.FINISH_MIRROR);
                            org.greenrobot.eventbus.c.d().a(finishActivityEvent);
                            this.f = System.currentTimeMillis();
                            String asString = (b.f ? asJsonObject.get("castInvitation") : asJsonObject.get("inviteCast")).getAsString();
                            this.l.a(asString);
                            d2 = org.greenrobot.eventbus.c.d();
                            hVar = new h(1000, asString);
                        } else {
                            return;
                        }
                    } else if (asJsonObject.has("cancelCastInvite")) {
                        this.l.c();
                        d3 = org.greenrobot.eventbus.c.d();
                        peerDeviceDealtEvent = new h(1001, null);
                    } else if (asJsonObject.has("reportInfo")) {
                        EventCollections.ServerInfoChangedEvent serverInfoChangedEvent = new EventCollections.ServerInfoChangedEvent();
                        if (asJsonObject.has("deviceName")) {
                            serverInfoChangedEvent.setDeviceName(asJsonObject.get("deviceName").getAsString());
                        }
                        if (asJsonObject.has("features")) {
                            serverInfoChangedEvent.setFeature(asJsonObject.get("features").getAsString());
                        }
                        if (asJsonObject.has("boardExists")) {
                            if (asJsonObject.get("boardExists").getAsInt() != 1) {
                                z = false;
                            }
                            CustomApplication.b("key_board_exists", z);
                        }
                        org.greenrobot.eventbus.c.d().a(serverInfoChangedEvent);
                        this.m.q();
                    } else if (asJsonObject.has("clientList")) {
                        if (System.currentTimeMillis() - this.f2811b >= this.g) {
                            this.f2811b = System.currentTimeMillis();
                            this.l.a(Arrays.asList((ClientInfo[]) this.n.fromJson(asJsonObject.get("clientList"), (Class<Object>) ClientInfo[].class)));
                        }
                    } else if (asJsonObject.has("transferHost")) {
                        if (System.currentTimeMillis() - this.f2814e >= this.g) {
                            this.f2814e = System.currentTimeMillis();
                            this.l.b();
                        } else {
                            return;
                        }
                    } else if (asJsonObject.has("requestCastClient")) {
                        String asString2 = asJsonObject.get("requestCastClient").getAsString();
                        String asString3 = asJsonObject.get("clientIP").getAsString();
                        org.greenrobot.eventbus.c.d().a(asJsonObject.has("castType") ? new EventCollections.PeerCastRequestEvent(asString2, asString3, asJsonObject.get("castType").getAsInt()) : new EventCollections.PeerCastRequestEvent(asString2, asString3, 0));
                    } else if (asJsonObject.has("allowClientCast")) {
                        d3 = org.greenrobot.eventbus.c.d();
                        peerDeviceDealtEvent = new EventCollections.PeerDeviceDealtEvent();
                    }
                    d3.a(peerDeviceDealtEvent);
                }
                d2.a(hVar);
            } else if (System.currentTimeMillis() - this.f2812c >= this.g) {
                c();
            } else {
                return;
            }
        }
    }

    private void c() {
        this.f2812c = System.currentTimeMillis();
        EventCollections.FinishActivityEvent finishActivityEvent = new EventCollections.FinishActivityEvent();
        finishActivityEvent.setType(EventCollections.FinishActivityEvent.FINISH_DEFAULT);
        org.greenrobot.eventbus.c.d().a(finishActivityEvent);
    }

    public void a() {
        this.k = true;
        start();
    }

    public void b() {
        this.k = false;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        a aVar;
        long j = 0;
        while (this.k) {
            if (System.currentTimeMillis() - j >= 1000) {
                j = System.currentTimeMillis();
                int i = this.j;
                if (i < Integer.MAX_VALUE) {
                    this.j = i + 1;
                } else {
                    this.j = 0;
                }
                String h = this.m.h(this.j);
                String str = "HostHeartBeatThread" + h;
                if (!TextUtils.isEmpty(h)) {
                    com.eshare.mirror.b.f3055b = 0;
                    try {
                        a(h);
                    } catch (JsonSyntaxException e2) {
                        e2.printStackTrace();
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    String str2 = "not received msg...,timeoutmark=" + com.eshare.mirror.b.f3055b;
                    com.eshare.mirror.b.f3055b++;
                    if (com.eshare.mirror.b.f3055b == 10 && (aVar = this.l) != null) {
                        aVar.a();
                        c();
                    }
                }
            } else {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }
}
