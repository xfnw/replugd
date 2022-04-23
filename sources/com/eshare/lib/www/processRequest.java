package com.eshare.lib.www;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import b.b.a.n.j;
import com.eshare.lib.i;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.eshare.lib.j.e */
/* loaded from: classes.dex */
class processRequest implements Runnable {

    /* renamed from: b */
    private Socket socket;

    /* renamed from: c */
    private File file;

    /* renamed from: d */
    private Context context;

    /* renamed from: e */
    private String path;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.eshare.lib.j.e$a */
    /* loaded from: classes.dex */
    public class filterName implements FilenameFilter {
        filterName(processRequest eVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.startsWith(".");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.eshare.lib.j.e$b */
    /* loaded from: classes.dex */
    public class fileBuffer extends FileInputStream {

        /* renamed from: b */
        final /* synthetic */ long readable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        fileBuffer(processRequest eVar, File file, long j) {
            super(file);
            this.readable = j;
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int available() {
            return (int) this.readable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.eshare.lib.j.e$c */
    /* loaded from: classes.dex */
    public class filterName implements FilenameFilter {
        filterName(processRequest eVar) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return !str.startsWith(".");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.eshare.lib.j.e$d */
    /* loaded from: classes.dex */
    public class d extends FileInputStream {

        /* renamed from: b */
        final /* synthetic */ long readable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(processRequest eVar, File file, long j) {
            super(file);
            this.readable = j;
        }

        @Override // java.io.FileInputStream, java.io.InputStream
        public int available() {
            return (int) this.readable;
        }
    }

    public processRequest(Context context, Socket socket, File file) {
        File file2;
        this.context = context;
        this.file = file;
        this.socket = socket;
        if (Build.VERSION.SDK_INT > 21) {
            file2 = j.a(context).get(0);
            if (file2.getParentFile().exists() && file2.getParentFile().canWrite()) {
                file2 = file2.getParentFile();
            }
        } else {
            file2 = new File("/storage");
        }
        if (!file2.exists()) {
            file2 = new File("/mnt");
            if (!file2.exists()) {
                file2 = Environment.getExternalStorageDirectory();
            }
        }
        this.path = file2.getPath();
        try {
            this.socket.setSoTimeout(15000);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private int a(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 13) {
                i++;
                if (bArr[i] == 10) {
                    i++;
                    if (bArr[i] == 13) {
                        i++;
                        if (bArr[i] == 10) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return i + 1;
    }

    private String a(long j, boolean z) {
        int i = z ? 1000 : 1024;
        if (j < i) {
            return j + " bytes";
        }
        double d2 = j;
        double d3 = i;
        int log = (int) (Math.log(d2) / Math.log(d3));
        StringBuilder sb = new StringBuilder();
        sb.append((z ? "kMGTPE" : "KMGTPE").charAt(log - 1));
        sb.append("");
        String sb2 = sb.toString();
        double pow = Math.pow(d3, log);
        Double.isNaN(d2);
        return String.format("%.1f %sb", Double.valueOf(d2 / pow), sb2);
    }

    /* renamed from: a */
    private String uploadHandler(String str, String str2, byte[] bArr, int i, int i2) {
        if (i2 <= 0) {
            return "";
        }
        if (str.startsWith("/upload")) {
            str = str.replaceFirst("/upload", this.path);
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            httpReply(400, "BAD REQUEST: No this dir");
            throw null;
        } else if (str2 != null) {
            String a2 = i.unicode(str2);
            File file2 = new File(file, a2);
            if (file2.exists() && a2.indexOf(".") != -1) {
                file2 = new File(file, a2.substring(0, a2.lastIndexOf(".")) + "-" + System.currentTimeMillis() + a2.substring(a2.lastIndexOf(".")));
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(bArr, i, i2);
                fileOutputStream.close();
                return "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        } else {
            httpReply(400, "BAD REQUEST: No FileName found.");
            throw null;
        }
    }

    /* renamed from: a */
    private void httpReply(int i, String str) {
        httpResponse hVar = new httpResponse(i);
        hVar.setHeader("Connection", "close");
        hVar.setContentType("text/plain");
        hVar.setContents(unicode(str));
        makeHeaders(hVar, true);
        throw new InterruptedException();
    }

    /* renamed from: a */
    private void makeHeaders(httpResponse hVar, boolean z) {
        int read;
        String a2 = httpStatus.genHttpStatus(hVar.getStatus(), hVar.getVersion());
        try {
            try {
                OutputStream outputStream = this.socket.getOutputStream();
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.print(a2 + " \r\n");
                Map<String, String> d2 = hVar.getHeaders();
                d2.put("Server", "EShare Http Server/1.0");
                if (TextUtils.isEmpty(d2.get("Accept-Ranges"))) {
                    d2.put("Accept-Ranges", "bytes");
                }
                if (TextUtils.isEmpty(d2.get("Connection"))) {
                    d2.put("Connection", "keep-alive");
                }
                if (!TextUtils.isEmpty(d2.get("Content-Type")) && !d2.get("Content-Type").contains("htm") && TextUtils.isEmpty(d2.get("Cache-Control"))) {
                    d2.put("Cache-Control", "public, max-age=3600");
                }
                if (TextUtils.isEmpty(d2.get("Content-Type"))) {
                    d2.put("Content-Type", "text/plain");
                }
                if (TextUtils.isEmpty(d2.get("Date"))) {
                    d2.put("Date", hVar.setTimestamp());
                }
                if (TextUtils.isEmpty(d2.get("Content-Length"))) {
                    long available = hVar.getStream() != null ? hVar.getStream().available() : 0L;
                    d2.put("Content-Length", available + "");
                }
                for (Map.Entry<String, String> entry : hVar.getHeaders().entrySet()) {
                    printWriter.print(entry.getKey() + ": " + entry.getValue() + "\r\n");
                }
                printWriter.print("\r\n");
                printWriter.flush();
                if (hVar.getStream() != null && z) {
                    long b2 = hVar.getLength();
                    byte[] bArr = new byte[4096];
                    while (b2 > 0 && (read = hVar.getStream().read(bArr)) > 0) {
                        outputStream.write(bArr, 0, read);
                        b2 -= read;
                    }
                }
                outputStream.flush();
                outputStream.close();
                if (hVar.getStream() != null) {
                    hVar.getStream().close();
                }
            } catch (IOException unused) {
                this.socket.close();
            }
        } catch (Throwable unused2) {
        }
    }

    private void a(BufferedReader bufferedReader, httpHeaders httpheads) {
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    httpheads.c(stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        int indexOf = nextToken.indexOf(63);
                        if (indexOf >= 0) {
                            a(nextToken.substring(indexOf + 1), httpheads);
                        }
                        if (indexOf >= 0) {
                            nextToken = nextToken.substring(0, indexOf);
                        }
                        httpheads.ingestToken(nextToken);
                        if (stringTokenizer.hasMoreTokens()) {
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && readLine2.trim().length() > 0) {
                                    int indexOf2 = readLine2.indexOf(58);
                                    if (indexOf2 >= 0) {
                                        httpheads.a(readLine2.substring(0, indexOf2).trim(), readLine2.substring(indexOf2 + 1).trim());
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                    } else {
                        httpReply(400, "BAD REQUEST: Missing URI. ");
                        throw null;
                    }
                } else {
                    httpReply(400, "BAD REQUEST: Syntax error. ");
                    throw null;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            httpReply(500, "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
            throw null;
        }
    }

    private void a(String str, httpHeaders gVar) {
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                int indexOf = nextToken.indexOf(61);
                if (indexOf >= 0) {
                    gVar.setHeader(i.unicode(nextToken.substring(0, indexOf)).trim(), i.unicode(nextToken.substring(indexOf + 1)));
                }
            }
        }
    }

    private void a(String str, String str2, StringBuilder sb) {
        File file = new File(str);
        sb.append("<D:response>");
        sb.append("<D:href>" + str2 + "</D:href>");
        sb.append("<D:propstat>");
        sb.append("<D:prop>");
        sb.append(file.isDirectory() ? "<D:resourcetype><D:collection/></D:resourcetype>" : "<D:resourcetype/>");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+00:00'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        sb.append("<D:creationdate>" + simpleDateFormat.format(new Date(file.lastModified())) + "</D:creationdate>");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("GMT"));
        sb.append("<D:getlastmodified>" + simpleDateFormat2.format(new Date(file.lastModified())) + "</D:getlastmodified>");
        sb.append("<D:getcontentlength>" + file.length() + "</D:getcontentlength>");
        sb.append("</D:prop>");
        sb.append("<D:status>HTTP/1.1 200 OK</D:status>");
        sb.append("</D:propstat>");
        sb.append("</D:response>\n");
    }

    private void a(String str, String str2, byte[] bArr, BufferedReader bufferedReader, httpHeaders gVar) {
        int indexOf;
        try {
            int[] a2 = a(bArr, str2.getBytes());
            String readLine = bufferedReader.readLine();
            int i = 1;
            while (readLine != null) {
                if (readLine.indexOf(str2) != -1) {
                    int i2 = i + 1;
                    Properties properties = new Properties();
                    while (true) {
                        readLine = bufferedReader.readLine();
                        if (readLine == null || readLine.trim().length() <= 0) {
                            break;
                        }
                        int indexOf2 = readLine.indexOf(58);
                        if (indexOf2 != -1) {
                            properties.put(readLine.substring(0, indexOf2).trim().toLowerCase(), readLine.substring(indexOf2 + 1).trim());
                        }
                    }
                    if (readLine != null) {
                        String property = properties.getProperty("content-disposition");
                        if (property != null) {
                            StringTokenizer stringTokenizer = new StringTokenizer(property, "; ");
                            Properties properties2 = new Properties();
                            while (stringTokenizer.hasMoreTokens()) {
                                String nextToken = stringTokenizer.nextToken();
                                int indexOf3 = nextToken.indexOf(61);
                                if (indexOf3 != -1) {
                                    properties2.put(nextToken.substring(0, indexOf3).trim().toLowerCase(), nextToken.substring(indexOf3 + 1).trim());
                                }
                            }
                            Matcher matcher = Pattern.compile("filename=\"(.+?)\"").matcher(property);
                            while (matcher.find()) {
                                properties2.put("filename", matcher.group(1));
                            }
                            String property2 = properties2.getProperty("name");
                            String substring = property2.substring(1, property2.length() - 1);
                            String str3 = "";
                            if (properties.getProperty("content-type") == null) {
                                while (readLine != null && readLine.indexOf(str2) == -1) {
                                    readLine = bufferedReader.readLine();
                                    if (readLine != null) {
                                        if (readLine.indexOf(str2) == -1) {
                                            str3 = str3 + readLine;
                                        } else {
                                            str3 = str3 + readLine.substring(0, indexOf - 2);
                                        }
                                    }
                                }
                            } else if (i2 <= a2.length) {
                                int a3 = a(bArr, a2[i2 - 2]);
                                String property3 = properties2.getProperty("filename");
                                if (property3.indexOf("\"") != -1) {
                                    property3 = property3.substring(1, property3.length() - 1);
                                }
                                gVar.d().put(substring, uploadHandler(str, property3, bArr, a3, (a2[i2 - 1] - a3) - 4));
                                String property4 = properties2.getProperty("filename");
                                str3 = property4.substring(1, property4.length() - 1);
                                do {
                                    readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                } while (readLine.indexOf(str2) == -1);
                            } else {
                                httpReply(500, "Error processing request");
                                throw null;
                            }
                            gVar.setHeader(substring, str3);
                        } else {
                            httpReply(400, "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found.");
                            throw null;
                        }
                    }
                    i = i2;
                } else {
                    httpReply(400, "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. ");
                    throw null;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            httpReply(500, "SERVER INTERNAL ERROR: IOException: " + e2.getMessage());
            throw null;
        }
    }

    /* renamed from: a */
    private static byte[] unicode(String str) {
        try {
            return str.getBytes("utf-8");
        } catch (Exception unused) {
            return str.getBytes();
        }
    }

    private byte[] b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        int ceil = (int) Math.ceil(options.outHeight / 200);
        int ceil2 = (int) Math.ceil(options.outWidth / 200);
        if (ceil > 1 || ceil2 > 1) {
            if (ceil > ceil2) {
                options.inSampleSize = ceil;
            } else {
                options.inSampleSize = ceil2;
            }
            Bitmap decodeFile2 = BitmapFactory.decodeFile(str, options);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (decodeFile2.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream)) {
                    byteArrayOutputStream.close();
                }
                decodeFile2.recycle();
                return byteArrayOutputStream.toByteArray();
            } catch (Exception unused) {
                decodeFile2.recycle();
                return null;
            }
        } else {
            decodeFile.recycle();
            return null;
        }
    }

    httpResponse a(httpHeaders httpheaders) {
        String replaceFirst = i.unicode(httpheaders.getToken()).replaceFirst("/remote/", "mobile/");
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(replaceFirst);
        try {
            InputStream open = this.context.getAssets().open(replaceFirst);
            httpResponse hVar = new httpResponse(200);
            hVar.setContentType(guessContentTypeFromName);
            hVar.setStream(open, open.available());
            return hVar;
        } catch (Exception unused) {
            httpResponse hVar2 = new httpResponse(404);
            hVar2.setContentType("text/html");
            hVar2.setContents(unicode("File Not Found"));
            return hVar2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0366 A[Catch: IOException -> 0x03ca, TryCatch #0 {IOException -> 0x03ca, blocks: (B:86:0x0301, B:87:0x0356, B:89:0x0366, B:90:0x0374, B:92:0x0382), top: B:108:0x02a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0374 A[Catch: IOException -> 0x03ca, TryCatch #0 {IOException -> 0x03ca, blocks: (B:86:0x0301, B:87:0x0356, B:89:0x0366, B:90:0x0374, B:92:0x0382), top: B:108:0x02a3 }] */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    com.eshare.lib.www.httpResponse a(com.eshare.lib.www.httpHeaders r24, java.io.File r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 1001
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eshare.lib.www.processRequest.a(com.eshare.lib.j.g, java.io.File, boolean):com.eshare.lib.j.h");
    }

    @SuppressLint({"UseValueOf"})
    public int[] a(byte[] bArr, byte[] bArr2) {
        Vector vector = new Vector();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < bArr.length) {
            if (bArr[i] == bArr2[i2]) {
                if (i2 == 0) {
                    i3 = i;
                }
                i2++;
                if (i2 == bArr2.length) {
                    vector.addElement(new Integer(i3));
                } else {
                    i++;
                }
            } else {
                i -= i2;
            }
            i2 = 0;
            i3 = -1;
            i++;
        }
        int[] iArr = new int[vector.size()];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = ((Integer) vector.elementAt(i4)).intValue();
        }
        return iArr;
    }

    public httpResponse b(httpHeaders gVar) {
        return new httpResponse(501);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v3, types: [long] */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* renamed from: b */
    httpResponse uploadFile(httpHeaders e2, File file, boolean z) {
        httpResponse hVar;
        String str;
        long j;
        byte[] b2;
        int indexOf;
        boolean z2;
        String str2;
        StringBuilder sb;
        File[] listFiles;
        int i;
        if (e2.method().equals("POST") && "mutiupload".equals(e2.b("action"))) {
            httpResponse hVar2 = new httpResponse(200);
            hVar2.setContents(unicode("{\"success\": true}"));
            hVar2.setContentType("text/html");
            return hVar2;
        } else if ("delete".equals(e2.b("action"))) {
            String f = e2.getToken();
            String replaceFirst = f.startsWith("/upload") ? f.replaceFirst("/upload", this.path) : f;
            File file2 = new File(i.unicode(replaceFirst));
            if (!file2.exists()) {
                file2 = new File(replaceFirst);
            }
            if (file2.isFile()) {
                file2.delete();
            } else {
                delete.deleteDirectory(file2);
            }
            if (!f.endsWith("/") || f.length() <= 1) {
                if (f.length() > 1) {
                    i = f.lastIndexOf("/");
                }
                httpResponse hVar3 = new httpResponse(301);
                hVar3.setContentType("text/html");
                hVar3.setContents(unicode("<html><body>Redirected: <a href=\"" + f + "\">" + f + "</a></body></html>"));
                hVar3.setHeader("Location", f);
                return hVar3;
            }
            i = f.length() - 2;
            f = f.substring(0, i);
            httpResponse hVar32 = new httpResponse(301);
            hVar32.setContentType("text/html");
            hVar32.setContents(unicode("<html><body>Redirected: <a href=\"" + f + "\">" + f + "</a></body></html>"));
            hVar32.setHeader("Location", f);
            return hVar32;
        } else {
            String a2 = e2.a("accept-language");
            if (a2 != null) {
                a2 = a2.toLowerCase();
            }
            boolean z3 = a2 != null && a2.contains("zh");
            StringBuilder sb2 = new StringBuilder();
            String a3 = i.unicode(e2.getToken());
            String replaceFirst2 = a3.replaceFirst("/upload", this.path);
            if (replaceFirst2.startsWith("..") || replaceFirst2.endsWith("..") || replaceFirst2.indexOf("../") >= 0) {
                hVar = new httpResponse(403);
                hVar.setContentType("text/plain");
                hVar.setContents(unicode("FORBIDDEN: Won't serve ../ for security reasons."));
            } else {
                hVar = null;
            }
            File file3 = new File(file, replaceFirst2);
            if (hVar == null && !file3.exists()) {
                a3 = e2.getToken();
                File file4 = new File(file, replaceFirst2.replaceFirst("/upload", this.path));
                if (!file4.exists()) {
                    hVar = new httpResponse(404);
                    hVar.setContentType("text/plain");
                    hVar.setContents(unicode("Error 404, file not found."));
                }
                file3 = file4;
            }
            if (hVar == null && file3.isDirectory()) {
                if (!a3.endsWith("/")) {
                    a3 = a3 + "/";
                    hVar = new httpResponse(301);
                    hVar.setContentType("text/html");
                    hVar.setContents(unicode("<html><body>Redirected: <a href=\"" + a3 + "\">" + a3 + "</a></body></html>"));
                    hVar.setHeader("Location", a3);
                }
                if (hVar == null) {
                    if (!z || !file3.canRead()) {
                        hVar = new httpResponse(403);
                        hVar.setContentType("text/plain");
                        hVar.setContents(unicode("FORBIDDEN: No directory listing."));
                    } else {
                        String[] list = file3.list(new filterName(this));
                        StringBuilder sb3 = new StringBuilder();
                        if (a3.replaceFirst("/upload", "").length() > 1) {
                            String substring = a3.substring(0, a3.length() - 1);
                            int lastIndexOf = substring.lastIndexOf(47);
                            if (lastIndexOf >= 0 && lastIndexOf < substring.length()) {
                                sb3.append("<li><a data-ajax=\"false\" href=\"" + a3.substring(0, lastIndexOf + 1) + "\"><h2 style=\"color:red;\">");
                                sb3.append(z3 ? "返回" : "Back");
                                sb3.append("</h2><p></p></a></li>");
                            }
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (list != null) {
                            for (int i2 = 0; i2 < list.length; i2++) {
                                File file5 = new File(file3, list[i2]);
                                if (file5.canRead() && (!z2 || !file5.isDirectory() || !((listFiles = file5.listFiles()) == null || listFiles.length == 0))) {
                                    String a4 = mimetype.convertMinetype(file5.getAbsolutePath());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(a3);
                                    a3 = a3;
                                    sb4.append(list[i2]);
                                    String b3 = i.urlencoder(sb4.toString());
                                    sb3.append("<li><a data-ajax=\"false\" href=\"");
                                    sb3.append(b3);
                                    sb3.append("\">");
                                    if (a4.contains("image")) {
                                        StringBuilder sb5 = new StringBuilder();
                                        list = list;
                                        sb5.append("<img src=\"");
                                        sb5.append(b3);
                                        sb3.append(sb5.toString());
                                        if (a4.contains("gif") || file5.length() < 81920) {
                                            sb3.append("\">");
                                        } else {
                                            sb3.append("?type=icon\">");
                                        }
                                        sb3.append("<h2>" + file5.getName() + "</h2>");
                                        sb = new StringBuilder();
                                    } else {
                                        list = list;
                                        sb3.append("<h2>" + file5.getName() + "</h2>");
                                        if (file5.isFile()) {
                                            sb = new StringBuilder();
                                        } else {
                                            str2 = "<p></p>";
                                            sb3.append(str2);
                                            sb3.append("</a>");
                                            sb3.append("</li>");
                                        }
                                    }
                                    sb.append("<p>");
                                    sb.append(a(file5.length(), true));
                                    sb.append("</p>");
                                    str2 = sb.toString();
                                    sb3.append(str2);
                                    sb3.append("</a>");
                                    sb3.append("</li>");
                                } else {
                                    list = list;
                                    a3 = a3;
                                }
                            }
                            page.generate(sb2, "Media Center", sb3, !z2 && file3.canWrite(), z3, e2.a("user-agent") != null && e2.a("user-agent").contains("iPhone"));
                        }
                        byte[] a5 = unicode(sb2.toString());
                        hVar = new httpResponse(200);
                        hVar.setContentType("text/html");
                        hVar.setContents(a5);
                    }
                }
            }
            if (hVar == null) {
                try {
                    String a6 = mimetype.convertMinetype(file3.getCanonicalPath());
                    String hexString = Integer.toHexString((file3.getAbsolutePath() + file3.lastModified() + "" + file3.length()).hashCode());
                    str = -1;
                    String a7 = e2.a("range");
                    if (a7 == null || !a7.startsWith("bytes=") || (indexOf = (a7 = a7.substring(6)).indexOf(45)) <= 0) {
                        j = 0;
                    } else {
                        try {
                            j = Long.parseLong(a7.substring(0, indexOf));
                        } catch (NumberFormatException unused) {
                            j = 0;
                        }
                        try {
                            str = Long.parseLong(a7.substring(indexOf + 1));
                        } catch (NumberFormatException unused2) {
                            str = -1;
                        }
                    }
                    long length = file3.length();
                    try {
                        if (a7 == null || j < 0) {
                            if (hexString.equals(e2.a("if-none-match"))) {
                                hVar = new httpResponse(304);
                                hVar.setContentType(a6);
                            } else {
                                if ("icon".equals(e2.b("type")) && (b2 = b(file3.getAbsolutePath())) != null) {
                                    hVar = new httpResponse(200);
                                    hVar.setContentType("image/png");
                                    hVar.setContents(b2);
                                }
                                if (hVar == null) {
                                    hVar = new httpResponse(200);
                                    hVar.setContentType(a6);
                                    hVar.setStream(new FileInputStream(file3), length);
                                    hVar.setHeader("ETag", hexString);
                                }
                            }
                        } else if (j >= length) {
                            hVar = new httpResponse(416);
                            hVar.setContentType("text/plain");
                            hVar.setHeader("Content-Range", "bytes 0-0/" + length);
                            hVar.setHeader("ETag", hexString);
                        } else {
                            int i3 = (str > 0L ? 1 : (str == 0L ? 0 : -1));
                            long j2 = str;
                            if (i3 < 0) {
                                j2 = length - 1;
                            }
                            long j3 = length - j;
                            long j4 = j3 < 0 ? 0L : j3;
                            try {
                                fileBuffer fbuff = new fileBuffer(this, file3, j4);
                                fbuff.skip(j);
                                httpResponse response = new httpResponse(206);
                                response.setContentType(a6);
                                response.setStream(fbuff, j4);
                                response.setHeader("Content-Range", "bytes " + j + "-" + j2 + "/" + length);
                                response.setHeader("ETag", hexString);
                                return response;
                            } catch (IOException unused3) {
                                str = "text/plain";
                                httpResponse response2 = new httpResponse(403);
                                response2.setContentType(str);
                                response2.setContents(unicode("FORBIDDEN: Reading file failed."));
                                return response2;
                            }
                        }
                    } catch (IOException unused4) {
                    }
                } catch (IOException unused5) {
                    str = "text/plain";
                }
            }
            return hVar;
        }
    }

    public httpResponse c(httpHeaders gVar) {
        String url = gVar.getToken();
        if (url.startsWith("/upload")) {
            url = url.replaceFirst("/upload", this.path);
        }
        File file = new File(i.unicode(url));
        if (!file.exists()) {
            file = new File(url);
            if (!file.exists()) {
                httpResponse hVar = new httpResponse(204);
                hVar.setContents(unicode("Not Found."));
                return hVar;
            }
        }
        if (file.canWrite()) {
            if (file.isFile()) {
                return file.delete() ? new httpResponse(200) : new httpResponse(404);
            }
            delete.deleteDirectory(file);
            return new httpResponse(200);
        } else if (file.isFile()) {
            httpResponse hVar2 = new httpResponse(423);
            hVar2.setHeader("Content-Type", "application/xml; charset=\"utf-8\"");
            hVar2.setContents(unicode("<?xml version=\"1.0\" encoding=\"utf-8\" ?><D:error xmlns:D=\"DAV:\"><D:lock-token-submitted><D:href>/locked/</D:href></D:lock-token-submitted></D:error>"));
            return hVar2;
        } else {
            httpResponse hVar3 = new httpResponse(207);
            hVar3.setHeader("Content-Type", "application/xml; charset=\"utf-8\"");
            hVar3.setContents(unicode("<?xml version=\"1.0\" encoding=\"utf-8\" ?> <d:multistatus xmlns:d=\"DAV:\"><d:response> <d:href>" + gVar.getToken() + "</d:href><d:status>HTTP/1.1 423 Locked</d:status><d:error><d:lock-token-submitted/></d:error> </d:response></d:multistatus>"));
            return hVar3;
        }
    }

    /* renamed from: d */
    public httpResponse response504(httpHeaders gVar) {
        return new httpResponse(501);
    }

    public httpResponse e(httpHeaders gVar) {
        String f = gVar.getToken();
        if (f.startsWith("/upload")) {
            f = f.replaceFirst("/upload", this.path);
        }
        if (f.endsWith("/")) {
            f = f.substring(0, f.lastIndexOf("/"));
        }
        httpResponse hVar = new httpResponse();
        int i = 201;
        if (new File(f).exists() || new File(i.unicode(f)).exists()) {
            i = 200;
        } else if (!new File(i.unicode(f)).mkdirs()) {
            i = 405;
            hVar.setContents(unicode("Failed creating collection at " + gVar.getToken()));
        }
        hVar.setStatus(i);
        return hVar;
    }

    public httpResponse f(httpHeaders gVar) {
        return new httpResponse(501);
    }

    public httpResponse g(httpHeaders gVar) {
        httpResponse hVar = new httpResponse(200);
        hVar.setHeader("MS-Author-Via", "DAV");
        hVar.setHeader("DASL", "<DAV:sql>");
        String a2 = gVar.a("User-Agent");
        hVar.setHeader("DAV", (TextUtils.isEmpty(a2) || !a2.startsWith("WebDAVFS/")) ? "1" : "1, 2");
        hVar.setHeader("Accept-Ranges", "none");
        hVar.setHeader("Cache-Control", "private");
        hVar.setHeader("Public", "OPTIONS, TRACE, GET, HEAD, POST, DELETE, COPY, SEARCH, MOVE, PROPFIND, PROPPATCH, MKCOL, LOCK, UNLOCK, PUT");
        hVar.setHeader("Allow", "OPTIONS, GET, HEAD, POST, DELETE, PROPFIND, MKCOL, PUT");
        return hVar;
    }

    public httpResponse h(httpHeaders gVar) {
        boolean equals = "1".equals(gVar.a("Depth"));
        String f = gVar.getToken();
        String replaceFirst = f.startsWith("/upload") ? f.replaceFirst("/upload", this.path) : f;
        gVar.a();
        File file = new File(i.unicode(replaceFirst));
        if (!file.exists()) {
            file = new File(replaceFirst);
            if (!file.exists()) {
                httpResponse hVar = new httpResponse(404);
                hVar.setContents(unicode("Not Found."));
                return hVar;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        sb.append("<D:multistatus xmlns:D=\"DAV:\">\n");
        if (!f.startsWith("/")) {
            f = "/" + f;
        }
        a(file.getAbsolutePath(), f, sb);
        if (equals) {
            if (!f.endsWith("/")) {
                f = f + "/";
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f);
                    sb2.append(i.urlencoder(file2.getName()));
                    sb2.append(file2.isDirectory() ? "/" : "");
                    a(file2.getAbsolutePath(), sb2.toString(), sb);
                }
            }
        }
        sb.append("</D:multistatus>");
        httpResponse hVar2 = new httpResponse(207);
        hVar2.setContents(unicode(sb.toString()));
        hVar2.setHeader("Content-Type", "application/xml; charset=\"utf-8\"");
        return hVar2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:156|(3:158|159|(11:161|165|(3:169|170|(1:658)(5:179|(1:181)(1:182)|183|(2:189|(4:193|(1:195)(3:196|(1:201)|202)|203|698))(4:187|609|188|699)|204))|205|(2:208|206)|591|209|210|211|(3:567|213|(1:215)(4:661|216|217|218))(2:219|220)|(1:222)(4:662|223|224|225))(1:162))(1:163)|164|165|(4:167|169|170|(0)(0))|696|205|(1:206)|591|209|210|211|(0)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01ab, code lost:
        if (r2[r7] == 10) goto L_0x01bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0201, code lost:
        r15.httpReply(404, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0207, code lost:
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x02a9, code lost:
        r3.close();
        r14.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02af, code lost:
        if (r8 == null) goto L_0x02b6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x02b1, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x038a, code lost:
        r15.httpReply(400, "BAD REQUEST: No this dir");
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0392, code lost:
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:179:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x032b A[Catch: all -> 0x0377, Exception -> 0x037a, SocketTimeoutException -> 0x03df, LOOP:5: B:206:0x0325->B:208:0x032b, LOOP_END, TRY_LEAVE, TryCatch #57 {all -> 0x0377, blocks: (B:188:0x02d2, B:189:0x02d6, B:191:0x02db, B:193:0x02e3, B:195:0x02f2, B:196:0x02f8, B:198:0x0301, B:203:0x030d, B:206:0x0325, B:208:0x032b, B:209:0x0332, B:210:0x0335), top: B:609:0x02d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0367 A[Catch: all -> 0x0533, Exception -> 0x0536, SocketTimeoutException -> 0x0896, TryCatch #9 {all -> 0x0533, blocks: (B:213:0x033d, B:215:0x0348, B:216:0x0353, B:220:0x035e, B:222:0x0367, B:223:0x036e, B:229:0x037f, B:233:0x038a, B:243:0x03ae, B:247:0x03ba, B:260:0x03ea, B:262:0x03f4, B:264:0x0404, B:266:0x040c, B:268:0x0412, B:270:0x041b, B:271:0x0422, B:275:0x042b, B:277:0x0436, B:279:0x0445, B:281:0x045f, B:284:0x0466, B:287:0x046f, B:291:0x0481, B:293:0x048c, B:296:0x0492, B:304:0x04a8, B:306:0x04ae, B:308:0x04c3, B:311:0x04cc, B:326:0x0511, B:338:0x052b), top: B:567:0x033d }] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x0559 A[Catch: all -> 0x07e6, Exception -> 0x07ee, SocketTimeoutException -> 0x07f6, TRY_LEAVE, TryCatch #57 {SocketTimeoutException -> 0x07f6, Exception -> 0x07ee, all -> 0x07e6, blocks: (B:344:0x0551, B:346:0x0559, B:354:0x057a), top: B:637:0x0551 }] */
    /* JADX WARN: Removed duplicated region for block: B:397:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0661 A[Catch: all -> 0x07d3, Exception -> 0x07da, SocketTimeoutException -> 0x07e1, TryCatch #28 {all -> 0x07d3, blocks: (B:386:0x0614, B:388:0x061a, B:390:0x0622, B:391:0x0637, B:398:0x0659, B:400:0x0661, B:402:0x0671, B:404:0x0677, B:406:0x067f, B:407:0x0685, B:409:0x0692, B:411:0x06a1, B:413:0x06bb, B:416:0x06c2, B:420:0x06cd, B:422:0x06db, B:423:0x06eb, B:426:0x06f2, B:430:0x070a, B:432:0x0712, B:433:0x0717, B:435:0x071f, B:436:0x0724, B:438:0x072c, B:439:0x0731, B:441:0x0739, B:442:0x073e, B:444:0x0746, B:445:0x074b, B:447:0x0753, B:448:0x0758, B:450:0x0760, B:452:0x0766, B:454:0x0770, B:456:0x0779, B:457:0x077e, B:461:0x0787, B:463:0x078d, B:465:0x0796, B:466:0x079e, B:470:0x07a6, B:474:0x07b2, B:477:0x07bb, B:479:0x07ca), top: B:580:0x0614 }] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0708  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a A[Catch: all -> 0x0075, Exception -> 0x007a, SocketTimeoutException -> 0x0080, TRY_ENTER, TryCatch #56 {all -> 0x0075, blocks: (B:26:0x005d, B:37:0x008d, B:43:0x009a, B:45:0x009e, B:47:0x00a6, B:49:0x00ae, B:59:0x00cb), top: B:607:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:474:0x07b2 A[Catch: all -> 0x07d3, Exception -> 0x07da, SocketTimeoutException -> 0x07e1, TryCatch #28 {all -> 0x07d3, blocks: (B:386:0x0614, B:388:0x061a, B:390:0x0622, B:391:0x0637, B:398:0x0659, B:400:0x0661, B:402:0x0671, B:404:0x0677, B:406:0x067f, B:407:0x0685, B:409:0x0692, B:411:0x06a1, B:413:0x06bb, B:416:0x06c2, B:420:0x06cd, B:422:0x06db, B:423:0x06eb, B:426:0x06f2, B:430:0x070a, B:432:0x0712, B:433:0x0717, B:435:0x071f, B:436:0x0724, B:438:0x072c, B:439:0x0731, B:441:0x0739, B:442:0x073e, B:444:0x0746, B:445:0x074b, B:447:0x0753, B:448:0x0758, B:450:0x0760, B:452:0x0766, B:454:0x0770, B:456:0x0779, B:457:0x077e, B:461:0x0787, B:463:0x078d, B:465:0x0796, B:466:0x079e, B:470:0x07a6, B:474:0x07b2, B:477:0x07bb, B:479:0x07ca), top: B:580:0x0614 }] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x084b A[Catch: all -> 0x0882, TRY_LEAVE, TryCatch #67 {all -> 0x0882, blocks: (B:521:0x0845, B:523:0x084b, B:526:0x085a), top: B:621:0x0845 }] */
    /* JADX WARN: Removed duplicated region for block: B:548:0x08a0 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:567:0x033d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:572:0x0887 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x088e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0877 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x0898 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:643:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:658:0x02a9 A[EDGE_INSN: B:658:0x02a9->B:172:0x02a9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:659:0x04fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:662:0x036e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:672:0x0518 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:678:0x07ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:684:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:722:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 2209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eshare.lib.www.processRequest.run():void");
    }
}
