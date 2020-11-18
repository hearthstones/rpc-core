package com.rpc.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description annotation for rpc service
 * @author luchao
 * @since 2020/11/18 10:46:07
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface RpcService {
    Class<?> value();
    String version() default "";
}
