package com.bonc.sprinboot01.utils;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Deprecated
public class StaticScheduleJob {

    /**
     * 上次开始执行时间点后5秒再次执行
     */
    @Scheduled(fixedRate = 5000)
    public void job3() {
        System.out.println("执行任务job3：" + new Date());
    }

    /**
     * 上次执行完毕时间点后3秒再次执行
     */
    @Scheduled(fixedDelay = 3000)
    public void job2() {
        System.out.println("执行任务job2：" + new Date());
    }

    /**
     * 每隔10秒执行一次（按照 corn 表达式规则执行）
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        System.out.println("执行任务job1：" + new Date());
    }

}
