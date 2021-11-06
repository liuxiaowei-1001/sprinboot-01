package com.bonc.sprinboot01.dao;


import com.bonc.sprinboot01.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    User queryById(@Param("id") int id);


    List<User> queryList();


    int insert(User user);


    int update(User user);


    int deleteById(@Param("id") int id);

}
