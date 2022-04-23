package com.ecloud.eshare.d;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NdefRecord f2784a;

        a(NdefRecord ndefRecord) {
            this.f2784a = ndefRecord;
        }

        @Override // com.ecloud.eshare.d.g
        public String a() {
            return new String(this.f2784a.getPayload()) + "\n";
        }
    }

    public static List<g> a(NdefMessage ndefMessage) {
        return a(ndefMessage.getRecords());
    }

    public static List<g> a(NdefRecord[] ndefRecordArr) {
        ArrayList arrayList = new ArrayList();
        for (NdefRecord ndefRecord : ndefRecordArr) {
            if (h.a(ndefRecord)) {
                arrayList.add(h.b(ndefRecord));
            } else {
                arrayList.add(new a(ndefRecord));
            }
        }
        return arrayList;
    }
}
