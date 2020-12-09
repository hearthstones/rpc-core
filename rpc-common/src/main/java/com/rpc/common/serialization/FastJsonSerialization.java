package com.rpc.common.serialization;

/**
 * @author luchao
 * @description FastJsonSerialization
 * @since 2020/12/9 20:10:04
 */
public class FastJsonSerialization extends Serialization {
    @Override
    public <T> byte[] serialize(T object) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] bytes) {
        return null;
    }
}
