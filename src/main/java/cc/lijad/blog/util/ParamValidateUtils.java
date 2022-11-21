package cc.lijad.blog.util;

import cc.lijad.blog.exception.RequestParamException;

/**
 * @author 李坚达
 * @create 2022/11/16 14:34
 */
public class ParamValidateUtils {

    /**
     * 判断数字不为空且大于0
     *
     * @param args
     */
    public static void checkNumberLegal(Integer... args) {
        for (Integer arg : args) {
            if (arg == null || arg < 0) {
                throw new RequestParamException("请求参数异常，为空或负数", args);
            }
        }
    }

    public static void checkNumberLegal(Long... args) {
        for (Long arg : args) {
            if (arg == null || arg < 0) {
                throw new RequestParamException("请求参数异常，为空或负数", args);
            }
        }
    }


    /**
     * 检查一个对象是否为空
     *
     * @param obj
     */
    public static void checkParamNotNull(Object obj) {
        if (obj == null) {
            throw new RequestParamException("请求参数异常，参数为空");
        }
    }
}
