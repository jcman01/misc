package misc;

import java.util.HashMap;
import java.util.Map;

public final class CMSObject {
    private Map<Class<?>, Object> cmsObject = new HashMap<Class<?>, Object>();

    public CMSObject() {
    }

    public <T> CMSObject(Class<T> type, T instance) {
        this.putCMSObject(type, instance);
    }

    public <T> void putCMSObject(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        cmsObject.put(type, instance);
    }

    public <T> T getCMSObject(Class<T> type) {
        return type.cast(cmsObject.get(type));
    }
}
