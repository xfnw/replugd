package com.eshare.lib.www;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.eshare.lib.j.g */
/* loaded from: classes.dex */
public class httpHeaders {

    /* renamed from: a  reason: collision with root package name */
    private String method;

    /* renamed from: b  reason: collision with root package name */
    private String token;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> requestHeaders = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, String> responseHeaders = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, String> f3026e = new HashMap();
    private byte[] f;

    public String a(String str) {
        for (Map.Entry<String, String> entry : this.requestHeaders.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public void a(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    public void a(byte[] bArr) {
        this.f = bArr;
    }

    public byte[] a() {
        return this.f;
    }

    /* renamed from: b */
    public String getContentLength() {
        return this.requestHeaders.get("Content-Length");
    }

    public String b(String str) {
        for (Map.Entry<String, String> entry : this.responseHeaders.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    /* renamed from: b */
    public void setHeader(String header, String value) {
        this.responseHeaders.put(header, value);
    }

    /* renamed from: c */
    public String getContentType() {
        return this.requestHeaders.get("Content-Type");
    }

    public void c(String str) {
        this.method = str;
    }

    public Map<String, String> d() {
        return this.f3026e;
    }

    /* renamed from: d */
    public void ingestToken(String str) {
        this.token = str;
    }

    /* renamed from: e */
    public String method() {
        return this.method;
    }

    /* renamed from: f */
    public String getToken() {
        return this.token;
    }
}
