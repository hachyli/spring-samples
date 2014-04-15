package com.sivalabs.core.util;

public class MutabilityTest
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		//final StringBuffer sb = new StringBuffer("dsfgdfgfhdfhffgfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		final StringBuilder sb = new StringBuilder("dsfgdfgfhdfhffgfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				/*for (int i = 1; i <= 10; i++) {
					System.out.println("i="+i);
					sb.append(i+",");
					int j = 0;
					while(j++ <1100);
				}*/
				System.out.println("Thread1 is working...");
				int len = sb.length();
				for (int i = 0; i < len; i++) {
					System.out.println("  i="+i);
					System.out.print(sb.charAt(i));
				}
				System.out.println("Thread1 is completed");
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				System.out.println("Thread2 is working...");
				int len = sb.length();
				for (int j = 0; j < len; j++) {
					System.out.println("  j="+j);
					System.out.print(sb.append(j));
				}
				System.out.println();
				System.out.println("Thread2 is completed");
				/*
				for (int i = 50; i <= 60; i++) {
					System.out.println("i="+i);
					sb.append(i+",");
					int j = 0;
					while(j++ <1000);
				}*/
			}
		});
		
		t2.start();
		t1.start();
		
		t1.join();
		t2.join();
		
		System.out.println("sb="+sb);
		
	}

}
