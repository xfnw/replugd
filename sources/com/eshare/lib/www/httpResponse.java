package com.eshare.lib.www;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.eshare.lib.j.h */
/* loaded from: classes.dex */
public class httpResponse {

    /* renamed from: f */
    private static SimpleDateFormat timestamp = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    private int status;

    /* renamed from: b  reason: collision with root package name */
    private String version;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> headers;

    /* renamed from: d  reason: collision with root package name */
    private InputStream inStream;

    /* renamed from: e  reason: collision with root package name */
    private long length;

    static {
        timestamp.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    public httpResponse() {
        this.status = 200;
        this.version = "1.1";
        this.headers = new HashMap();
        this.length = 0L;
    }

    public httpResponse(int i) {
        this.status = 200;
        this.version = "1.1";
        this.headers = new HashMap();
        this.length = 0L;
        this.status = i;
    }

    /* renamed from: a */
    public InputStream getStream() {
        return this.inStream;
    }

    /* renamed from: a */
    public void setStatus(int i) {
        this.status = i;
    }

    /* renamed from: a */
    public void setStream(InputStream inputStream, long j) {
        this.inStream = inputStream;
        this.length = j;
    }

    /* renamed from: a */
    public void setContentType(String str) {
        this.headers.put("Content-Type", str);
    }

    /* renamed from: a */
    public void setHeader(String str, String str2) {
        this.headers.put(str, str2);
    }

    /* renamed from: a */
    public void setContents(byte[] inputStream) {
        if (inputStream != null) {
            this.inStream = new ByteArrayInputStream(inputStream);
            this.length = inputStream.length;
        }
    }

    /* renamed from: b */
    public long getLength() {
        return this.length;
    }

    /* renamed from: c */
    public String setTimestamp() {
        return timestamp.format(new Date());
    }

    /* renamed from: d */
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    /* renamed from: e */
    public String getVersion() {
        return this.version;
    }

    /* renamed from: f */
    public int getStatus() {
        return this.status;
    }
}
