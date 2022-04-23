package b.b.a.n;

import android.content.Context;
import android.os.storage.StorageManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static List<i> f1709a = new ArrayList();

    public static ArrayList<File> a(Context context) {
        ArrayList<File> arrayList = new ArrayList<>();
        List<i> b2 = b(context);
        for (i iVar : b2) {
            if (iVar.a()) {
                arrayList.add(new File(iVar.f1706a));
            }
        }
        f1709a.addAll(b2);
        return arrayList;
    }

    public static List<i> b(Context context) {
        ArrayList arrayList = new ArrayList();
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Object[] objArr = (Object[]) StorageManager.class.getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
            if (objArr != null) {
                for (Object obj : objArr) {
                    i iVar = new i((String) obj.getClass().getMethod("getPath", new Class[0]).invoke(obj, new Object[0]));
                    iVar.f1707b = (String) StorageManager.class.getMethod("getVolumeState", String.class).invoke(storageManager, iVar.f1706a);
                    iVar.f1708c = ((Boolean) obj.getClass().getMethod("isRemovable", new Class[0]).invoke(obj, new Object[0])).booleanValue();
                    File file = new File(iVar.f1706a);
                    if (file.exists() && file.isDirectory() && iVar.a()) {
                        arrayList.add(iVar);
                    }
                    String str = "path: " + iVar.f1706a + " info " + iVar.toString() + " " + file.isDirectory() + " " + file.canWrite();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
