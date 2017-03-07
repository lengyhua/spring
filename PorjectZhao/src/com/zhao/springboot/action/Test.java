package com.zhao.springboot.action;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String [] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DIConfig.class);
		UseFunctionService useFunctionService=ctx.getBean(UseFunctionService.class);
		System.out.println(useFunctionService.SayHello("DI"));
		ctx.close();
	}
}
