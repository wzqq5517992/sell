package com.food.utils;

import com.food.enums.CodeEnum;

/**枚举遍历获取方式
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-12 15:26
 */
public class EnumUtil {

    public static <T extends CodeEnum > T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
