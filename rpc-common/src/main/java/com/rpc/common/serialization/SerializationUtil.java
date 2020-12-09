package com.rpc.common.serialization;

/**
 * @author luchao
 * @description SerializationUtil
 * @since 2020/11/20 19:42:33
 */
public class SerializationUtil {

    //默认使用Hessian2做序列化
    private static final Serialization DEFAULT_SERIALIZATION = new Hessian2Serialization();

//    private static Serialization serialization;

    /**
     * 序列化
     * @param object 对象
     * @return byte[] 字节数组
     */
    public static <T> byte[] serialize(T object) {
        return DEFAULT_SERIALIZATION.serialize(object);
    }

    /**
     * 反序列化
     * @param bytes 字节数组
     * @return T对象(泛型)
     */
    public static <T> T deserialize(byte[] bytes) {
        return DEFAULT_SERIALIZATION.deserialize(bytes);
    }
}
