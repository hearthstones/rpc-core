package com.rpc.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @description RpcReference: annotation for rpc service autowired
 * @author luchao
 * @since 2020/11/18 10:50:24
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Component
public @interface RpcReference {
    String version() default "";
}
