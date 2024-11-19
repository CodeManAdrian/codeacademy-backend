package com.adrian.codeacademybackend.common.context;

import java.util.Map;

/*
 * Date: 2024/11/19 12:10
 * Author: Adrian
 * Version: 1.0
 * Description:
 * */
public class BaseContext {

    // 定义 ThreadLocal 存储 Map
    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    // 设置当前线程的 Map
    public static void setCurrentMap(Map<String, Object> map) {
        threadLocal.set(map);
    }

    // 获取当前线程的 Map
    public static Map<String, Object> getCurrentMap() {
        return threadLocal.get();
    }

    // 向当前线程的 Map 添加一个键值对
    public static void put(String key, Object value) {
        threadLocal.get().put(key, value);
    }

    // 从当前线程的 Map 获取值
    public static Object get(String key) {
        return threadLocal.get().get(key);
    }

    // 清除当前线程的 Map
    public static void removeCurrentMap() {
        threadLocal.remove();
    }
}
