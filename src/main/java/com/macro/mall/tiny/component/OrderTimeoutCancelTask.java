package com.macro.mall.tiny.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Classname OrderTimeoutCancelTask
 * @Description ToDo
 * @Date 2020/7/7 10:44
 * @Creater by weiyao
 */
@Component
public class OrderTimeoutCancelTask {

    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeoutCancelTask.class);

    /**
     * cron表达式：Seconds Minutes Hours DayofMonth Month DayofWeek [Year]
     * 每10分钟扫描一次，扫描设定超时时间之前下的订单，如果没支付则取消该订单
     */
//    @Scheduled(cron = "0 0/10 * ? * ?") // 每月每天从0时开始，每10分钟触发一次
    @Scheduled(cron = "0/10 * * ? * ?") // 每月每天每小时每分钟从0秒开始，每10秒钟触发一次
    private void cancelTimeOutOrder() {
        // TODO: 2019/5/3 此处应调用取消订单的方法，具体查看mall项目源码
        LOGGER.info("取消订单，并根据sku编号释放锁定库存");
    }
}
