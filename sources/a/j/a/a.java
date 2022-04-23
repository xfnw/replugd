package a.j.a;

import android.content.res.AssetManager;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class a {
    static final c[][] F;
    private static final HashMap<Integer, c>[] H;
    private static final HashMap<String, c>[] I;

    /* renamed from: a  reason: collision with root package name */
    private final String f355a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager.AssetInputStream f356b;

    /* renamed from: c  reason: collision with root package name */
    private int f357c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, b>[] f358d;

    /* renamed from: e  reason: collision with root package name */
    private Set<Integer> f359e;
    private ByteOrder f = ByteOrder.BIG_ENDIAN;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    public static final int[] m = {8, 8, 8};
    public static final int[] n = {8};
    static final byte[] o = {-1, -40, -1};
    private static final byte[] p = {79, 76, 89, 77, 80, 0};
    private static final byte[] q = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    static final String[] s = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] t = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] u = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final c[] v = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
    private static final c[] w = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c[] x = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
    private static final c[] y = {new c("InteroperabilityIndex", 1, 2)};
    private static final c[] z = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
    private static final c A = new c("StripOffsets", 273, 3);
    private static final c[] B = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
    private static final c[] C = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
    private static final c[] D = {new c("AspectFrame", 4371, 3)};
    private static final c[] E = {new c("ColorSpace", 55, 3)};
    private static final c[] G = {new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
    private static final HashSet<String> J = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    private static final HashMap<Integer, Integer> K = new HashMap<>();
    static final Charset L = Charset.forName("US-ASCII");
    static final byte[] M = "Exif\u0000\u0000".getBytes(L);
    private static SimpleDateFormat r = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018a extends InputStream implements DataInput {
        private static final ByteOrder f = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder g = ByteOrder.BIG_ENDIAN;

        /* renamed from: b  reason: collision with root package name */
        private DataInputStream f360b;

        /* renamed from: c  reason: collision with root package name */
        private ByteOrder f361c;

        /* renamed from: d  reason: collision with root package name */
        final int f362d;

        /* renamed from: e  reason: collision with root package name */
        int f363e;

        public C0018a(InputStream inputStream) {
            this.f361c = ByteOrder.BIG_ENDIAN;
            this.f360b = new DataInputStream(inputStream);
            this.f362d = this.f360b.available();
            this.f363e = 0;
            this.f360b.mark(this.f362d);
        }

        public C0018a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public void a(ByteOrder byteOrder) {
            this.f361c = byteOrder;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f360b.available();
        }

        public void h(long j) {
            int i = this.f363e;
            if (i > j) {
                this.f363e = 0;
                this.f360b.reset();
                this.f360b.mark(this.f362d);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int m() {
            return this.f363e;
        }

        public long n() {
            return readInt() & 4294967295L;
        }

        @Override // java.io.InputStream
        public int read() {
            this.f363e++;
            return this.f360b.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = this.f360b.read(bArr, i, i2);
            this.f363e += read;
            return read;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f363e++;
            return this.f360b.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f363e++;
            if (this.f363e <= this.f362d) {
                int read = this.f360b.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f363e += 2;
            return this.f360b.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f363e += bArr.length;
            if (this.f363e > this.f362d) {
                throw new EOFException();
            } else if (this.f360b.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            this.f363e += i2;
            if (this.f363e > this.f362d) {
                throw new EOFException();
            } else if (this.f360b.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f363e += 4;
            if (this.f363e <= this.f362d) {
                int read = this.f360b.read();
                int read2 = this.f360b.read();
                int read3 = this.f360b.read();
                int read4 = this.f360b.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.f361c;
                    if (byteOrder == f) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == g) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.f361c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f363e += 8;
            if (this.f363e <= this.f362d) {
                int read = this.f360b.read();
                int read2 = this.f360b.read();
                int read3 = this.f360b.read();
                int read4 = this.f360b.read();
                int read5 = this.f360b.read();
                int read6 = this.f360b.read();
                int read7 = this.f360b.read();
                int read8 = this.f360b.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.f361c;
                    if (byteOrder == f) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == g) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    throw new IOException("Invalid byte order: " + this.f361c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f363e += 2;
            if (this.f363e <= this.f362d) {
                int read = this.f360b.read();
                int read2 = this.f360b.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f361c;
                    if (byteOrder == f) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == g) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.f361c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f363e += 2;
            return this.f360b.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f363e++;
            return this.f360b.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f363e += 2;
            if (this.f363e <= this.f362d) {
                int read = this.f360b.read();
                int read2 = this.f360b.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.f361c;
                    if (byteOrder == f) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == g) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.f361c);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int min = Math.min(i, this.f362d - this.f363e);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.f360b.skipBytes(min - i2);
            }
            this.f363e += i2;
            return i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f364a;

        /* renamed from: b  reason: collision with root package name */
        public final int f365b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f366c;

        b(int i, int i2, byte[] bArr) {
            this.f364a = i;
            this.f365b = i2;
            this.f366c = bArr;
        }

        public static b a(int i, ByteOrder byteOrder) {
            return a(new int[]{i}, byteOrder);
        }

        public static b a(long j, ByteOrder byteOrder) {
            return a(new long[]{j}, byteOrder);
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            return a(new d[]{dVar}, byteOrder);
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.L);
            return new b(2, bytes.length, bytes);
        }

        public static b a(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.t[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new b(3, iArr.length, wrap.array());
        }

        public static b a(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.t[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b a(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.t[5] * dVarArr.length]);
            wrap.order(byteOrder);
            for (d dVar : dVarArr) {
                wrap.putInt((int) dVar.f371a);
                wrap.putInt((int) dVar.f372b);
            }
            return new b(5, dVarArr.length, wrap.array());
        }

        public double a(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (d2 instanceof String) {
                return Double.parseDouble((String) d2);
            } else {
                if (d2 instanceof long[]) {
                    long[] jArr = (long[]) d2;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof int[]) {
                    int[] iArr = (int[]) d2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof double[]) {
                    double[] dArr = (double[]) d2;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof d[]) {
                    d[] dVarArr = (d[]) d2;
                    if (dVarArr.length == 1) {
                        return dVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int b(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (d2 instanceof String) {
                return Integer.parseInt((String) d2);
            } else {
                if (d2 instanceof long[]) {
                    long[] jArr = (long[]) d2;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d2 instanceof int[]) {
                    int[] iArr = (int[]) d2;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String c(ByteOrder byteOrder) {
            Object d2 = d(byteOrder);
            if (d2 == null) {
                return null;
            }
            if (d2 instanceof String) {
                return (String) d2;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (d2 instanceof long[]) {
                long[] jArr = (long[]) d2;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (d2 instanceof int[]) {
                int[] iArr = (int[]) d2;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (d2 instanceof double[]) {
                double[] dArr = (double[]) d2;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(d2 instanceof d[])) {
                return null;
            } else {
                d[] dVarArr = (d[]) d2;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].f371a);
                    sb.append('/');
                    sb.append(dVarArr[i].f372b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:149:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object d(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 466
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: a.j.a.a.b.d(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            return "(" + a.s[this.f364a] + ", data length:" + this.f366c.length + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f367a;

        /* renamed from: b  reason: collision with root package name */
        public final String f368b;

        /* renamed from: c  reason: collision with root package name */
        public final int f369c;

        /* renamed from: d  reason: collision with root package name */
        public final int f370d;

        c(String str, int i, int i2) {
            this.f368b = str;
            this.f367a = i;
            this.f369c = i2;
            this.f370d = -1;
        }

        c(String str, int i, int i2, int i3) {
            this.f368b = str;
            this.f367a = i;
            this.f369c = i2;
            this.f370d = i3;
        }

        boolean a(int i) {
            int i2;
            int i3 = this.f369c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.f370d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((this.f369c == 9 || this.f370d == 9) && i == 8) {
                return true;
            }
            return (this.f369c == 12 || this.f370d == 12) && i == 11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final long f371a;

        /* renamed from: b  reason: collision with root package name */
        public final long f372b;

        d(long j, long j2) {
            if (j2 == 0) {
                this.f371a = 0L;
                this.f372b = 1L;
                return;
            }
            this.f371a = j;
            this.f372b = j2;
        }

        public double a() {
            double d2 = this.f371a;
            double d3 = this.f372b;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.f371a + "/" + this.f372b;
        }
    }

    static {
        c[] cVarArr;
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        new int[1][0] = 4;
        c[] cVarArr2 = v;
        F = new c[][]{cVarArr2, w, x, y, z, cVarArr2, B, C, D, E};
        new c("JPEGInterchangeFormat", 513, 4);
        new c("JPEGInterchangeFormatLength", 514, 4);
        c[][] cVarArr3 = F;
        H = new HashMap[cVarArr3.length];
        I = new HashMap[cVarArr3.length];
        r.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < F.length; i++) {
            H[i] = new HashMap<>();
            I[i] = new HashMap<>();
            for (c cVar : F[i]) {
                H[i].put(Integer.valueOf(cVar.f367a), cVar);
                I[i].put(cVar.f368b, cVar);
            }
        }
        K.put(Integer.valueOf(G[0].f367a), 5);
        K.put(Integer.valueOf(G[1].f367a), 1);
        K.put(Integer.valueOf(G[2].f367a), 2);
        K.put(Integer.valueOf(G[3].f367a), 3);
        K.put(Integer.valueOf(G[4].f367a), 7);
        K.put(Integer.valueOf(G[5].f367a), 8);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public a(String str) {
        Throwable th;
        c[][] cVarArr = F;
        this.f358d = new HashMap[cVarArr.length];
        this.f359e = new HashSet(cVarArr.length);
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.f356b = null;
            this.f355a = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    a((InputStream) fileInputStream2);
                    a((Closeable) fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    a((Closeable) fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    private int a(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a(bArr)) {
            return 4;
        }
        if (c(bArr)) {
            return 9;
        }
        if (b(bArr)) {
            return 7;
        }
        return d(bArr) ? 10 : 0;
    }

    private void a() {
        String a2 = a("DateTimeOriginal");
        if (a2 != null && a("DateTime") == null) {
            this.f358d[0].put("DateTime", b.a(a2));
        }
        if (a("ImageWidth") == null) {
            this.f358d[0].put("ImageWidth", b.a(0L, this.f));
        }
        if (a("ImageLength") == null) {
            this.f358d[0].put("ImageLength", b.a(0L, this.f));
        }
        if (a("Orientation") == null) {
            this.f358d[0].put("Orientation", b.a(0L, this.f));
        }
        if (a("LightSource") == null) {
            this.f358d[1].put("LightSource", b.a(0L, this.f));
        }
    }

    private void a(int i, int i2) {
        if (!this.f358d[i].isEmpty() && !this.f358d[i2].isEmpty()) {
            b bVar = this.f358d[i].get("ImageLength");
            b bVar2 = this.f358d[i].get("ImageWidth");
            b bVar3 = this.f358d[i2].get("ImageLength");
            b bVar4 = this.f358d[i2].get("ImageWidth");
            if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null) {
                int b2 = bVar.b(this.f);
                int b3 = bVar2.b(this.f);
                int b4 = bVar3.b(this.f);
                int b5 = bVar4.b(this.f);
                if (b2 < b4 && b3 < b5) {
                    HashMap<String, b>[] hashMapArr = this.f358d;
                    HashMap<String, b> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(a.j.a.a.C0018a r7) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.j.a.a.a(a.j.a.a$a):void");
    }

    private void a(C0018a aVar, int i) {
        this.f = e(aVar);
        aVar.a(this.f);
        int readUnsignedShort = aVar.readUnsignedShort();
        int i2 = this.f357c;
        if (i2 == 7 || i2 == 10 || readUnsignedShort == 42) {
            int readInt = aVar.readInt();
            if (readInt < 8 || readInt >= i) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i3 = readInt - 8;
            if (i3 > 0 && aVar.skipBytes(i3) != i3) {
                throw new IOException("Couldn't jump to first Ifd: " + i3);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0115, code lost:
        r10.a(r9.f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011a, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(a.j.a.a.C0018a r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.j.a.a.a(a.j.a.a$a, int, int):void");
    }

    private void a(C0018a aVar, HashMap hashMap) {
        int i;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar != null && bVar2 != null) {
            int b2 = bVar.b(this.f);
            int min = Math.min(bVar2.b(this.f), aVar.available() - b2);
            int i2 = this.f357c;
            if (i2 == 4 || i2 == 9 || i2 == 10) {
                i = this.h;
            } else {
                if (i2 == 7) {
                    i = this.i;
                }
                if (b2 > 0 && min > 0 && this.f355a == null && this.f356b == null) {
                    aVar.h(b2);
                    aVar.readFully(new byte[min]);
                    return;
                }
                return;
            }
            b2 += i;
            if (b2 > 0) {
            }
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private void a(InputStream inputStream) {
        for (int i = 0; i < F.length; i++) {
            try {
                this.f358d[i] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.f357c = a(bufferedInputStream);
        C0018a aVar = new C0018a(bufferedInputStream);
        switch (this.f357c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                c(aVar);
                break;
            case 4:
                a(aVar, 0, 0);
                break;
            case 7:
                a(aVar);
                break;
            case 9:
                b(aVar);
                break;
            case 10:
                d(aVar);
                break;
        }
        f(aVar);
        a();
    }

    private void a(byte[] bArr, int i) {
        C0018a aVar = new C0018a(bArr);
        a(aVar, bArr.length);
        b(aVar, i);
    }

    private boolean a(HashMap hashMap) {
        b bVar;
        b bVar2 = (b) hashMap.get("BitsPerSample");
        if (bVar2 == null) {
            return false;
        }
        int[] iArr = (int[]) bVar2.d(this.f);
        if (Arrays.equals(m, iArr)) {
            return true;
        }
        if (this.f357c != 3 || (bVar = (b) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int b2 = bVar.b(this.f);
        return (b2 == 1 && Arrays.equals(iArr, n)) || (b2 == 6 && Arrays.equals(iArr, m));
    }

    private static boolean a(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = o;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    private b b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < F.length; i++) {
            b bVar = this.f358d[i].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    private void b(C0018a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i, 5);
        aVar.h(i2);
        aVar.a(ByteOrder.BIG_ENDIAN);
        int readInt = aVar.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == A.f367a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b a2 = b.a((int) readShort, this.f);
                b a3 = b.a((int) readShort2, this.f);
                this.f358d[0].put("ImageLength", a2);
                this.f358d[0].put("ImageWidth", a3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(a.j.a.a.C0018a r24, int r25) {
        /*
            Method dump skipped, instructions count: 774
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: a.j.a.a.b(a.j.a.a$a, int):void");
    }

    private void b(C0018a aVar, HashMap hashMap) {
        String str;
        b bVar = (b) hashMap.get("StripOffsets");
        b bVar2 = (b) hashMap.get("StripByteCounts");
        if (!(bVar == null || bVar2 == null)) {
            long[] a2 = a(bVar.d(this.f));
            long[] a3 = a(bVar2.d(this.f));
            if (a2 == null) {
                str = "stripOffsets should not be null.";
            } else if (a3 == null) {
                str = "stripByteCounts should not be null.";
            } else {
                long j = 0;
                for (long j2 : a3) {
                    j += j2;
                }
                byte[] bArr = new byte[(int) j];
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < a2.length; i3++) {
                    int i4 = (int) a2[i3];
                    int i5 = (int) a3[i3];
                    int i6 = i4 - i;
                    aVar.h(i6);
                    int i7 = i + i6;
                    byte[] bArr2 = new byte[i5];
                    aVar.read(bArr2);
                    i = i7 + i5;
                    System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                    i2 += bArr2.length;
                }
                return;
            }
            Log.w("ExifInterface", str);
        }
    }

    private void b(InputStream inputStream) {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar = this.f358d[1].get("PixelXDimension");
        b bVar2 = this.f358d[1].get("PixelYDimension");
        if (!(bVar == null || bVar2 == null)) {
            this.f358d[0].put("ImageWidth", bVar);
            this.f358d[0].put("ImageLength", bVar2);
        }
        if (this.f358d[4].isEmpty() && b(this.f358d[5])) {
            HashMap<String, b>[] hashMapArr = this.f358d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        b(this.f358d[4]);
    }

    private boolean b(HashMap hashMap) {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.b(this.f) <= 512 && bVar2.b(this.f) <= 512;
    }

    private boolean b(byte[] bArr) {
        C0018a aVar = new C0018a(bArr);
        this.f = e(aVar);
        aVar.a(this.f);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 20306 || readShort == 21330;
    }

    private void c(C0018a aVar) {
        b bVar;
        a(aVar, aVar.available());
        b(aVar, 0);
        d(aVar, 0);
        d(aVar, 5);
        d(aVar, 4);
        b((InputStream) aVar);
        if (this.f357c == 8 && (bVar = this.f358d[1].get("MakerNote")) != null) {
            C0018a aVar2 = new C0018a(bVar.f366c);
            aVar2.a(this.f);
            aVar2.h(6L);
            b(aVar2, 9);
            b bVar2 = this.f358d[9].get("ColorSpace");
            if (bVar2 != null) {
                this.f358d[1].put("ColorSpace", bVar2);
            }
        }
    }

    private void c(C0018a aVar, int i) {
        b bVar;
        b bVar2 = this.f358d[i].get("ImageLength");
        b bVar3 = this.f358d[i].get("ImageWidth");
        if ((bVar2 == null || bVar3 == null) && (bVar = this.f358d[i].get("JPEGInterchangeFormat")) != null) {
            a(aVar, bVar.b(this.f), i);
        }
    }

    private boolean c(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private void d(C0018a aVar) {
        c(aVar);
        if (this.f358d[0].get("JpgFromRaw") != null) {
            a(aVar, this.l, 5);
        }
        b bVar = this.f358d[0].get("ISO");
        b bVar2 = this.f358d[1].get("PhotographicSensitivity");
        if (bVar != null && bVar2 == null) {
            this.f358d[1].put("PhotographicSensitivity", bVar);
        }
    }

    private void d(C0018a aVar, int i) {
        b bVar;
        b bVar2;
        StringBuilder sb;
        String arrays;
        b bVar3 = this.f358d[i].get("DefaultCropSize");
        b bVar4 = this.f358d[i].get("SensorTopBorder");
        b bVar5 = this.f358d[i].get("SensorLeftBorder");
        b bVar6 = this.f358d[i].get("SensorBottomBorder");
        b bVar7 = this.f358d[i].get("SensorRightBorder");
        if (bVar3 != null) {
            if (bVar3.f364a == 5) {
                d[] dVarArr = (d[]) bVar3.d(this.f);
                if (dVarArr == null || dVarArr.length != 2) {
                    sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    arrays = Arrays.toString(dVarArr);
                    sb.append(arrays);
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                bVar2 = b.a(dVarArr[0], this.f);
                bVar = b.a(dVarArr[1], this.f);
                this.f358d[i].put("ImageWidth", bVar2);
                this.f358d[i].put("ImageLength", bVar);
            }
            int[] iArr = (int[]) bVar3.d(this.f);
            if (iArr == null || iArr.length != 2) {
                sb = new StringBuilder();
                sb.append("Invalid crop size values. cropSize=");
                arrays = Arrays.toString(iArr);
                sb.append(arrays);
                Log.w("ExifInterface", sb.toString());
                return;
            }
            bVar2 = b.a(iArr[0], this.f);
            bVar = b.a(iArr[1], this.f);
            this.f358d[i].put("ImageWidth", bVar2);
            this.f358d[i].put("ImageLength", bVar);
        } else if (bVar4 == null || bVar5 == null || bVar6 == null || bVar7 == null) {
            c(aVar, i);
        } else {
            int b2 = bVar4.b(this.f);
            int b3 = bVar6.b(this.f);
            int b4 = bVar7.b(this.f);
            int b5 = bVar5.b(this.f);
            if (b3 > b2 && b4 > b5) {
                b a2 = b.a(b3 - b2, this.f);
                b a3 = b.a(b4 - b5, this.f);
                this.f358d[i].put("ImageLength", a2);
                this.f358d[i].put("ImageWidth", a3);
            }
        }
    }

    private boolean d(byte[] bArr) {
        C0018a aVar = new C0018a(bArr);
        this.f = e(aVar);
        aVar.a(this.f);
        short readShort = aVar.readShort();
        aVar.close();
        return readShort == 85;
    }

    private ByteOrder e(C0018a aVar) {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void f(C0018a aVar) {
        HashMap<String, b> hashMap = this.f358d[4];
        b bVar = hashMap.get("Compression");
        if (bVar != null) {
            this.g = bVar.b(this.f);
            int i = this.g;
            if (i != 1) {
                if (i != 6) {
                    if (i != 7) {
                        return;
                    }
                }
            }
            if (a((HashMap) hashMap)) {
                b(aVar, hashMap);
                return;
            }
            return;
        }
        this.g = 6;
        a(aVar, hashMap);
    }

    public int a(String str, int i) {
        b b2 = b(str);
        if (b2 == null) {
            return i;
        }
        try {
            return b2.b(this.f);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public String a(String str) {
        String str2;
        b b2 = b(str);
        if (b2 != null) {
            if (!J.contains(str)) {
                return b2.c(this.f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = b2.f364a;
                if (i == 5 || i == 10) {
                    d[] dVarArr = (d[]) b2.d(this.f);
                    if (dVarArr != null && dVarArr.length == 3) {
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) dVarArr[0].f371a) / ((float) dVarArr[0].f372b))), Integer.valueOf((int) (((float) dVarArr[1].f371a) / ((float) dVarArr[1].f372b))), Integer.valueOf((int) (((float) dVarArr[2].f371a) / ((float) dVarArr[2].f372b))));
                    }
                    str2 = "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr);
                } else {
                    str2 = "GPS Timestamp format is not rational. format=" + b2.f364a;
                }
                Log.w("ExifInterface", str2);
                return null;
            }
            try {
                return Double.toString(b2.a(this.f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
