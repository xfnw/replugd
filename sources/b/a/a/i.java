package b.a.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class i {
    static {
        System.getProperty("line.separator");
    }

    public static d a(Object[] objArr) {
        d dVar = new d(objArr.length);
        for (int i = 0; i < objArr.length; i++) {
            dVar.a(i, a(objArr[i]));
        }
        return dVar;
    }

    public static e a(byte[] bArr) {
        return new e(bArr);
    }

    public static h a(double d2) {
        return new h(d2);
    }

    public static h a(long j) {
        return new h(j);
    }

    public static h a(boolean z) {
        return new h(z);
    }

    public static i a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof i) {
            return (i) obj;
        }
        Class<?> cls = obj.getClass();
        if (Boolean.class.equals(cls)) {
            return a(((Boolean) obj).booleanValue());
        }
        if (Byte.class.equals(cls)) {
            return a(((Byte) obj).byteValue());
        }
        if (Short.class.equals(cls)) {
            return a(((Short) obj).shortValue());
        }
        if (Integer.class.equals(cls)) {
            return a(((Integer) obj).intValue());
        }
        if (Long.class.isAssignableFrom(cls)) {
            return a(((Long) obj).longValue());
        }
        if (Float.class.equals(cls)) {
            return a(((Float) obj).floatValue());
        }
        if (Double.class.isAssignableFrom(cls)) {
            return a(((Double) obj).doubleValue());
        }
        if (String.class.equals(cls)) {
            return new k((String) obj);
        }
        if (Date.class.equals(cls)) {
            return new f((Date) obj);
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            if (componentType.equals(Byte.TYPE)) {
                return a((byte[]) obj);
            }
            int i = 0;
            if (componentType.equals(Boolean.TYPE)) {
                boolean[] zArr = (boolean[]) obj;
                d dVar = new d(zArr.length);
                while (i < zArr.length) {
                    dVar.a(i, a(zArr[i]));
                    i++;
                }
                return dVar;
            } else if (Float.TYPE.equals(componentType)) {
                float[] fArr = (float[]) obj;
                d dVar2 = new d(fArr.length);
                while (i < fArr.length) {
                    dVar2.a(i, a(fArr[i]));
                    i++;
                }
                return dVar2;
            } else if (Double.TYPE.equals(componentType)) {
                double[] dArr = (double[]) obj;
                d dVar3 = new d(dArr.length);
                while (i < dArr.length) {
                    dVar3.a(i, a(dArr[i]));
                    i++;
                }
                return dVar3;
            } else if (Short.TYPE.equals(componentType)) {
                short[] sArr = (short[]) obj;
                d dVar4 = new d(sArr.length);
                while (i < sArr.length) {
                    dVar4.a(i, a(sArr[i]));
                    i++;
                }
                return dVar4;
            } else if (Integer.TYPE.equals(componentType)) {
                int[] iArr = (int[]) obj;
                d dVar5 = new d(iArr.length);
                while (i < iArr.length) {
                    dVar5.a(i, a(iArr[i]));
                    i++;
                }
                return dVar5;
            } else if (!Long.TYPE.equals(componentType)) {
                return a((Object[]) obj);
            } else {
                long[] jArr = (long[]) obj;
                d dVar6 = new d(jArr.length);
                while (i < jArr.length) {
                    dVar6.a(i, a(jArr[i]));
                    i++;
                }
                return dVar6;
            }
        } else if (!Map.class.isAssignableFrom(cls)) {
            return Collection.class.isAssignableFrom(cls) ? a(((Collection) obj).toArray()) : b(obj);
        } else {
            Map map = (Map) obj;
            Set keySet = map.keySet();
            g gVar = new g();
            for (Object obj2 : keySet) {
                gVar.put(String.valueOf(obj2), a(map.get(obj2)));
            }
            return gVar;
        }
    }

    public static e b(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new e(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new RuntimeException("The given object of class " + obj.getClass().toString() + " could not be serialized and stored in a NSData object.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(c cVar) {
        cVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(c cVar);
}
