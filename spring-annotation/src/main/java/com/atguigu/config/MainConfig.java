package com.atguigu.config;

import com.atguigu.bean.Person;
import com.atguigu.service.BookService;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//配置类==配置文件
@Configuration // 告诉Spring这是一个配置类
@ComponentScan(value = "com.atguigu", includeFilters = {
//		@Filter(type=FilterType.ANNOTATION,classes = {Controller.class,Service.class
//		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookService.class), 
		@Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class), 
		}, useDefaultFilters = false)

//包扫描
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class MainConfig {
	// 给容器中注册一个Bean;类型为返回值的类型，
	// bean_id默认是用方法名作为id,但可以更改@Bean(value = "person")
	@Bean(value = "person")
	public Person person01() {
		return new Person("lisi", 20);
	}
}
