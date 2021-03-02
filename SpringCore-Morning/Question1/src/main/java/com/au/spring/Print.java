package com.au.spring;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Print {
	public static void main(String[] args) throws IOException {
		ApplicationContext factory = new AnnotationConfigApplicationContext(Config.class);
		Rectangle rectangle = (Rectangle) factory.getBean("rectangleObj");
		rectangle.print();
		((AnnotationConfigApplicationContext) factory).close();
	}

}