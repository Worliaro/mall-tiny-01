package com.macro.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Classname MyBatisConfig
 * @Description ToDo
 * @Date 2020/7/3 11:42
 * @Creater by weiyao
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.macro.mall.tiny.mbg.mapper","com.macro.mall.tiny.dao"})
public class MyBatisConfig {
}
