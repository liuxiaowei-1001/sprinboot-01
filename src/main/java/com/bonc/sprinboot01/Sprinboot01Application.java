package com.bonc.sprinboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching  //开启缓存
@EnableTransactionManagement//开启事务
//@EnableScheduling//开启定时任务
@EnableSwagger2//开启接口测试
@EnableAsync//开启线程池
public class Sprinboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Sprinboot01Application.class, args);
    }

}
