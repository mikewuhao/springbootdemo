package com.jd;

import lombok.Data;

/**
 * @Description:
 * @CreateDate: 2020-02-16 12:28
 * @Author: wuhao
 */
@Data
public class User {

    public User(Long id, String name, String addr, Integer sex) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.sex = sex;
    }

    private Long id;
    private String name;
    private String addr;
    private Integer sex;

}
