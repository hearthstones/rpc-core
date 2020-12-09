package com.rpc.common.serialization;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.rpc.common.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @description 使用Hessian2进行序列化/反序列化
 * @author luchao
 * @since 2020/11/19 14:12:23
 */
@Slf4j
public class Hessian2Serialization extends Serialization {

    @Override
    public <T> byte[] serialize(T object) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output hessian2Output = new Hessian2Output(os);

        try {
            //object对应的实体类均必须实现Serializable接口
            hessian2Output.writeObject(object);
            hessian2Output.flush();
        } catch (IOException e) {
            log.error("Hessian2 serialize error!", e);
        } finally {
            try {
                hessian2Output.close();
                os.close();
            } catch (IOException e) {
                log.error("serialize resource close error!", e);
            }
        }

        return os.toByteArray();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        T result = null;
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        Hessian2Input hessian2Input = new Hessian2Input(is);

        try {
            result = (T) hessian2Input.readObject();
        } catch (IOException e) {
            log.error("Hessian2 deserialize error!", e);
        } finally {
            try {
                hessian2Input.close();
                is.close();
            } catch (IOException e) {
                log.error("deserialize resource close error!", e);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        User user = new User("lu", 20);
        byte[] ub = SerializationUtil.serialize(user);
        log.info(ub + ", length = " + ub.length);
        User userDs = SerializationUtil.deserialize(ub);
        log.info(userDs.toString());
    }
}


