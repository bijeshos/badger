package io.github.bijeshos.badger.common;

import java.util.Collection;
import java.util.Map;

public class CollectionUtils {
    public static boolean isNonNull(Collection collection) {
        return collection != null && collection.size() > 0 ? true : false;
    }

    public static boolean isSizeGreaterThan(Collection collection, int size) {
        return collection != null && collection.size() > size ? true : false;
    }

    public static boolean isNonNull(Map map) {
        return map != null && map.size() > 0 ? true : false;
    }

    public static boolean isSizeGreaterThan(Map map, int size) {
        return map != null && map.size() > size ? true : false;
    }
}
