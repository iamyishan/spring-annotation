package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest {
	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
	@Test
	public void testImport(){
		printBeans(applicationContext);
		
		 // ����bean��ȡ���ǵ���getObject���������Ķ���
	    Object bean2 = applicationContext.getBean("colorFactoryBean");
	    Object bean3 = applicationContext.getBean("colorFactoryBean");
	    System.out.println("bean�����ͣ�" + bean2.getClass());
	    System.out.println(bean2 == bean3);
	    
	    
	    Object bean4 = applicationContext.getBean("&colorFactoryBean");
		System.out.println(bean4.getClass());

	}
	
	private void printBeans(AnnotationConfigApplicationContext applicationContext){
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}
	
	@Test
	public void test04() {
		String[] definitionNames=applicationContext.getBeanNamesForType(Person.class);
		ConfigurableEnvironment environment =applicationContext.getEnvironment();  // �õ�IOC���л���
		//��̬��ȡ����������ֵ:Windows 10
		String property=environment.getProperty("os.name");
		System.out.println(property);
		
		for (String name : definitionNames) {
			System.out.println(name);
		}
		
		Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
		System.out.println(persons);
		
	}

	@Test
	public void test03() {
		// �������ھ�����һ��IOC����������Щbean��������������bean���������
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfig2.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
		
//        �ж��Ƿ���ģʽ�Ͷ���ģʽ
		Object bean = applicationContext.getBean("person2");
		Object bean2 = applicationContext.getBean("person2");
		System.out.println(bean == bean2);

	}

	@Test
	public void test02() {
		// �������ھ�����һ��IOC����������Щbean��������������bean���������
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfig.class);
		String[] definitionNames = applicationContext.getBeanDefinitionNames();
		for (String name : definitionNames) {
			System.out.println(name);
		}
	}

//    @Test
//    public void test01(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String name : definitionNames) {
//            System.out.println(name);
//        }
//    }
}
