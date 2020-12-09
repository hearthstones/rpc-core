package com.rpc.common.serialization;

import java.util.ServiceLoader;

/**
 * @description SerializationUtil 序列化工具类
 * @author luchao
 * @since 2020/11/20 19:42:33
 */
public class SerializationUtil {

    private static final Serialization serialization;

    static {
        ServiceLoader<Serialization> loader = ServiceLoader.load(Serialization.class);
        // 选择第一个Serialization，否则默认使用Hessian2Serialization
        serialization = loader.iterator().hasNext() ? loader.iterator().next() : new Hessian2Serialization();
    }

    /**
     * 序列化
     * @param object 对象
     * @return byte[] 字节数组
     */
    public static <T> byte[] serialize(T object) {
        return serialization.serialize(object);
    }

    /**
     * 反序列化
     * @param bytes 字节数组
     * @return T对象(泛型)
     */
    public static <T> T deserialize(byte[] bytes) {
        return serialization.deserialize(bytes);
    }
}
