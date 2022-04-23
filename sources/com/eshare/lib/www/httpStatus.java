package com.eshare.lib.www;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
/* renamed from: com.eshare.lib.j.c */
/* loaded from: classes.dex */
public class httpStatus {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Integer, String> httpStatuses = new HashMap();

    static {
        httpStatuses.put(100, "Continue");
        httpStatuses.put(101, "Switching Protocols");
        httpStatuses.put(102, "Processing");
        httpStatuses.put(200, "OK");
        httpStatuses.put(201, "Created");
        httpStatuses.put(202, "Accepted");
        httpStatuses.put(203, "Non-Authorative Information");
        httpStatuses.put(204, "No Content");
        httpStatuses.put(205, "Reset Content");
        httpStatuses.put(206, "Partial Content");
        httpStatuses.put(207, "Multi-Status");
        httpStatuses.put(208, "Already Reported");
        httpStatuses.put(226, "IM Used");
        httpStatuses.put(300, "Multiple Choices");
        httpStatuses.put(301, "Moved Permanently");
        httpStatuses.put(302, "Found");
        httpStatuses.put(303, "See Other");
        httpStatuses.put(304, "Not Modified");
        httpStatuses.put(305, "Use Proxy");
        httpStatuses.put(306, "Reserved");
        httpStatuses.put(307, "Temporary Redirect");
        httpStatuses.put(400, "Bad request");
        httpStatuses.put(401, "Unauthorized");
        httpStatuses.put(402, "Payment Required");
        httpStatuses.put(403, "Forbidden");
        httpStatuses.put(404, "Not Found");
        httpStatuses.put(405, "Method Not Allowed");
        httpStatuses.put(406, "Not Acceptable");
        httpStatuses.put(407, "Proxy Authentication Required");
        httpStatuses.put(408, "Request Timeout");
        httpStatuses.put(409, "Conflict");
        httpStatuses.put(410, "Gone");
        httpStatuses.put(411, "Length Required");
        httpStatuses.put(412, "Precondition failed");
        httpStatuses.put(413, "Request Entity Too Large");
        httpStatuses.put(414, "Request-URI Too Long");
        httpStatuses.put(415, "Unsupported Media Type");
        httpStatuses.put(416, "Requested Range Not Satisfiable");
        httpStatuses.put(417, "Expectation Failed");
        httpStatuses.put(418, "I'm a teapot");
        httpStatuses.put(422, "Unprocessable Entity");
        httpStatuses.put(423, "Locked");
        httpStatuses.put(424, "Failed Dependency");
        httpStatuses.put(426, "Upgrade required");
        httpStatuses.put(428, "Precondition required");
        httpStatuses.put(429, "Too Many Requests");
        httpStatuses.put(431, "Request Header Fields Too Large");
        httpStatuses.put(500, "Internal Server Error");
        httpStatuses.put(501, "Not Implemented");
        httpStatuses.put(502, "Bad Gateway");
        httpStatuses.put(503, "Service Unavailable");
        httpStatuses.put(504, "Gateway Timeout");
        httpStatuses.put(505, "HTTP Version not supported");
        httpStatuses.put(506, "Variant Also Negotiates");
        httpStatuses.put(507, "Insufficient Storage");
        httpStatuses.put(508, "Loop Detected");
        httpStatuses.put(510, "Not extended");
        httpStatuses.put(511, "Network Authentication Required");
    }

    /* renamed from: a */
    public static String genHttpStatus(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "1.1";
        }
        return "HTTP/" + str + " " + i + " " + httpStatuses.get(Integer.valueOf(i));
    }
}
