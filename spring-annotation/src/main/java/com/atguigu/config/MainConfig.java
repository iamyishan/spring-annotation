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

//������==�����ļ�
@Configuration // ����Spring����һ��������
@ComponentScan(value = "com.atguigu", includeFilters = {
//		@Filter(type=FilterType.ANNOTATION,classes = {Controller.class,Service.class
//		@Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BookService.class), 
		@Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class), 
		}, useDefaultFilters = false)

//��ɨ��
//@ComponentScan  value:ָ��Ҫɨ��İ�
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������
public class MainConfig {
	// ��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�
	// bean_idĬ�����÷�������Ϊid,�����Ը���@Bean(value = "person")
	@Bean(value = "person")
	public Person person01() {
		return new Person("lisi", 20);
	}
}
