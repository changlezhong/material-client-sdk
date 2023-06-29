package cn.pinming.material.util;

import cn.hutool.core.lang.UUID;

/**
 * @author changlezhong
 * @date 2023/6/12
 */
public class UuidUtil {

    public static String uuidWithoutConnector() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
