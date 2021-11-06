package com.bonc.sprinboot01.service;

import com.bonc.sprinboot01.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {


    User queryById(@Param("id") int id);


    List<User> queryList();


    User insert(User user);


    User update(User user);


    int deleteById(@Param("id") int id);

    /**
     * 执行异步任务
     */
    void executeAsync();



}
