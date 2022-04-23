package b.b.a.n;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static int branding;

    /* renamed from: a */
    private static String switchBranding() {
        branding++;
        return branding % 2 == 0 ? "FindBoxlight" : "FindECloudBox";
    }

    /* renamed from: a */
    public static void getScreenCapture(DatagramSocket datagramSocket, String str) {
        byte[] bytes = "getScreenCap".getBytes();
        byte[] bArr = new byte[50];
        a(bArr, 0, 26);
        a(bArr, 4, 0);
        a(bArr, 8, 0);
        a(bArr, 12, bytes.length);
        a(bArr, 16, 0);
        System.arraycopy(bytes, 0, bArr, 20, bytes.length);
        try {
            datagramSocket.send(new DatagramPacket(bArr, bArr.length, InetAddress.getByName(str), 48689));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void scan(DatagramSocket datagramSocket, InetAddress inetAddress) {
        byte[] bytes = switchBranding().getBytes();
        byte[] bArr = new byte[50];
        a(bArr, 0, 0);
        a(bArr, 4, 0);
        a(bArr, 8, 0);
        a(bArr, 12, bytes.length);
        a(bArr, 16, 0);
        System.arraycopy(bytes, 0, bArr, 20, bytes.length);
        datagramSocket.send(new DatagramPacket(bArr, bArr.length, inetAddress, 48689));
    }

    public static void a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >> 24) & 255);
        int i3 = i + 1;
        bArr[i3] = (byte) ((i2 >> 16) & 255);
        int i4 = i3 + 1;
        bArr[i4] = (byte) ((i2 >> 8) & 255);
        bArr[i4 + 1] = (byte) (i2 & 255);
    }
}
