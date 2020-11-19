package com.rpc.common.serialization;

/**
 * @description 定义「序列化/反序列化」抽象类
 * @author luchao
 * @since 2020/11/18 11:54:18
 */
public abstract class Serialization {
    /**
     * 定义序列化
     * @param object 对象
     * @return byte[] 字节数组
     */
    public abstract <T> byte[] serialize(T object);

    /**
     * 定义反序列化
     * @param bytes 字节数组
     * @return T对象(泛型)
     */
    public abstract <T> T deserialize(byte[] bytes);
}
