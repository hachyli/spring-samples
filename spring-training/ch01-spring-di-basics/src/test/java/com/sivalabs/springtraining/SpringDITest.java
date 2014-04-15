/**
 * 
 */
package com.sivalabs.springtraining;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Siva
 *
 */
public class SpringDITest {


	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.registerShutdownHook();
		UserController userController = ctx.getBean(UserController.class);
		System.out.println(userController.getAdminEmail());
		System.out.println(userController.login("siva", "siva"));
		
		Authenticator ldapAuthenticator = ctx.getBean("ldapAuthenticator", Authenticator.class);
		ldapAuthenticator.authenticate("siva", "siva");
		Authenticator socialAuthenticator = ctx.getBean("socialAuthenticator", Authenticator.class);
		socialAuthenticator.authenticate("siva", "siva");
		
		
		MySingletonBean mySingletonBean = ctx.getBean(MySingletonBean.class);
		System.out.println(mySingletonBean);
		mySingletonBean.printMe("siva");
		mySingletonBean = ctx.getBean(MySingletonBean.class);
		System.out.println(mySingletonBean);
		mySingletonBean.printMe("prasad");
		
		MyAppContextHolder appContextHolder = ctx.getBean(MyAppContextHolder.class);
		MySingletonBean mySingletonBean2 = appContextHolder.getBean(MySingletonBean.class);
		mySingletonBean2.printMe("sivaprasad");
		
		
		AdminService adminService = ctx.getBean(AdminService.class);
		adminService.doTask("task1");
		System.out.println(adminService.getAdminEmail());
		
		SysConfigService sysConfigService = ctx.getBean(SysConfigService.class);
		String user = sysConfigService.authenticate("siva", "admin");
		System.out.println(user);
		sysConfigService.doTask("simple tassk");
		
		
	}

}
