package com.rpc.common.POJO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author luchao
 * @description User
 * @since 2020/11/19 15:27:59
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private int age;
}
