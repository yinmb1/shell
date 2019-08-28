package com.ymb.shell.http;

import java.util.Map;

/**
 * @author yinmb
 * @date 20190828
 * @since
 */
public class MapUtils {

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return !isEmpty(map);
    }

}
