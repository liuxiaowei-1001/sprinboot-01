package com.bonc.sprinboot01.service.impl;

import com.bonc.sprinboot01.dao.UserMapper;
import com.bonc.sprinboot01.entity.User;
import com.bonc.sprinboot01.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"userCache"})
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    @Cacheable(cacheNames = {"user"}, key = "#id",unless = "#result == null ")
    public User queryById(int id) {
        System.out.println("缓存不存在，执行方法");
        return userMapper.queryById(id);
    }

    @Override
    @Async("taskExecutor1")
    //@Cacheable("userList") // 标志读取缓存操作，如果缓存不存在，则调用目标方法，并将结果放入缓存
    public List<User> queryList() {
        System.out.println("UserServiceImpl.queryList");
        return userMapper.queryList();
    }

    @Override
    @CachePut(cacheNames = {"user"}, key = "#user.id",unless = "#result == null ")//写入缓存，key为user.id,一般该注解标注在新增方法上
    public User insert(User user) {
        System.out.println("写入缓存");
        userMapper.insert(user);
        return user;
    }

    @Override
    @CacheEvict(cacheNames = {"user"}, key = "#user.id")//根据key清除缓存，一般该注解标注在修改和删除方法上
    public User update(User user) {
        System.out.println("清除缓存");
        userMapper.update(user);
        return user;
    }

    @Override
    @CacheEvict(value = "userCache", allEntries = true)//方法调用后清空所有缓存
    //@CacheEvict(value="userCache",beforeInvocation=true)//方法调用前清空所有缓存
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    @Async("taskExecutor1")
    public void executeAsync() {
        logger.info("start executeAsync");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }
}
