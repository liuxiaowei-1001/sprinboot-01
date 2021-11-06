package com.bonc.sprinboot01.controller;

import com.bonc.sprinboot01.entity.User;
import com.bonc.sprinboot01.service.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = {"接口分组1", "接口分组2"})
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;



    @RequestMapping("/")
    public String submit(){
        logger.info("start submit");

        //调用service层的任务
        userService.executeAsync();

        logger.info("end submit");

        return "success";
    }




    //http://localhost:8080/query?id=2
    @RequestMapping("/query")
    public User queryuser(@RequestParam("id") Integer id) {
        return userService.queryById(id);
    }


    //http://localhost:8080/querylist
    @RequestMapping("/querylist")
    public List<User> querylist() {
        return userService.queryList();
    }


    //http://localhost:8080/insert?id=343&name=dfasdf&pwd=sdfdsfad
    @RequestMapping("/insert")
    public User insert(User user) {
        return userService.insert(user);
    }


    //http://localhost:8080/update?id=2&name=随便&pwd=leixing
    @RequestMapping("/update")
    public User update(User user) {
        String str = null;
        str.equals("111");
        return userService.update(user);
    }

    //http://localhost:8080/delete?id=2
    @RequestMapping("/delete")
    public int delete(@RequestParam("id") int id) {
        return userService.deleteById(id);
    }

}
