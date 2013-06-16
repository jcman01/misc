package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class CMSObjectCache {
    static Map<String, Object> cmsObjectCache = new ConcurrentHashMap<String, Object>();
    static Map<String, Object> cmsDeadlineCache = new ConcurrentHashMap<String, Object>();

    public static <T> void putCMSObject(String cmsKey, T cmsObject) {
        init();
        cmsObjectCache.put(cmsKey, cmsObject);
    }

    public static <T> T getCachedCMSObject(String objectKey, Class<T> type) {
        init();
        return type.cast(cmsObjectCache.get(objectKey));
    }

    public static void clearCache() {
        init();
        cmsObjectCache.clear();
    }

    public static List<String> listContents() {
        init();
        ArrayList<String> listContents = new ArrayList<String>();

        for (Map.Entry<String, Object> entry : cmsObjectCache.entrySet()) {
            listContents.add(entry.getKey());
        }
        return listContents;
    }

    private static void init() {
        if (cmsObjectCache == null) {
            cmsObjectCache = new ConcurrentHashMap<String, Object>();
        }
    }
}
