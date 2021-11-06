package com.bonc.sprinboot01.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-10-27 00:12:32
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "user", description = "用户对象")
public class User implements Serializable {
    private static final long serialVersionUID = -69075317601331199L;
    
    private Integer id;
    
    private String name;
    
    private String pwd;




}

