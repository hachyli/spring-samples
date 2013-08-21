package com.sivalabs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sivalabs.springcore.DataSource;
import com.sivalabs.springcore.User;
import com.sivalabs.springcore.UserService;

public class UserServiceTest
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		
		
		UserService userService1 = ctx.getBean("userService", UserService.class);
		System.out.println(userService1.hashCode()+":"+userService1.getUserRepository().hashCode());
		
		UserService userService2 = ctx.getBean("userService", UserService.class);
		System.out.println(userService2.hashCode()+":"+userService2.getUserRepository().hashCode());
		
		
		
		//BaseDAO bean = ctx.getBean(BaseDAO.class);
		//System.out.println(bean);
		
		User siva = ctx.getBean("siva",User.class);
		System.out.println(siva.getUserName());
		
		DataSource dataSource = ctx.getBean("mysqlDataSource", DataSource.class);
		System.out.println(dataSource.getDsName());
		
		DataSource dataSource1 = ctx.getBean("oracleDataSource", DataSource.class);
		System.out.println(dataSource1.getDsName());
	}
}
