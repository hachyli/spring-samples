/**
 * 
 */
package com.sivalabs.springtraining;

/**
 * @author Siva
 *
 */
public abstract class MySingletonBean {

	/*private MyPrototypeBean prototypeBean;
	
	public void setPrototypeBean(MyPrototypeBean prototypeBean) {
		this.prototypeBean = prototypeBean;
	}
	public MyPrototypeBean getPrototypeBean() {
		return prototypeBean;
	}*/
	
	public void init()
	{
		System.err.println("----------MySingletonBean.init()-----------");
	}
	public void destroy()
	{
		System.err.println("----------MySingletonBean.destroy()-----------");
	}
	
	public void printMe(String string) {
		createMyPrototypeBean().printMe(string);
	}
	abstract MyPrototypeBean createMyPrototypeBean();
}
