package com.ecloud.eshare.d;

import android.annotation.SuppressLint;
import android.nfc.NdefRecord;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final String f2785a;

    @SuppressLint({"RestrictedApi"})
    public h(String str, String str2) {
        a.g.k.h.a(str);
        a.g.k.h.a(str2);
        this.f2785a = str2;
    }

    public static boolean a(NdefRecord ndefRecord) {
        try {
            b(ndefRecord);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    @SuppressLint({"RestrictedApi"})
    public static h b(NdefRecord ndefRecord) {
        a.g.k.h.a(ndefRecord.getTnf() == 1);
        a.g.k.h.a(Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT));
        try {
            byte[] payload = ndefRecord.getPayload();
            if (payload.length <= 0) {
                ndefRecord.getType();
                return null;
            }
            String str = (payload[0] & 128) == 0 ? "UTF-8" : "UTF-16";
            int i = payload[0] & 63;
            return new h(new String(payload, 1, i, "US-ASCII"), new String(payload, i + 1, (payload.length - i) - 1, str));
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // com.ecloud.eshare.d.g
    public String a() {
        return this.f2785a;
    }
}
