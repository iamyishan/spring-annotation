package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//配置类==配置文件
@Configuration  //告诉Spring这是一个配置类
@ComponentScan(value = "com.atguigu",excludeFilters = {}) //包扫描
public class MainConfig {
    //给容器中注册一个Bean;类型为返回值的类型，
    // bean_id默认是用方法名作为id,但可以更改@Bean(value = "person")
    @Bean(value = "person")
    public Person person01() {
        return new Person("lisi", 20);
    }
}
