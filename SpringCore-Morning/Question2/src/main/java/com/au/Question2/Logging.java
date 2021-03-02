package com.au.Question2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Logging {

    //Before advice
	@Before("execution(public void show())")
	public void loggingAdvice1() {
		System.out.println("Before 'show' is called");
	}
   
	//After advice
	@After("execution(public void show())")
	public void loggingAdvice2() {
		System.out.println("After 'show' is called");
	}

	//Around advice
	@Around("execution(public void show())")
	public void loggingAdvice3(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Before and After invoking 'show' method");
		joinPoint.proceed();
	}

	//AfterThrowing advice
	@AfterThrowing(value = "execution(public void show())", throwing = "ex")
	public void loggingAdvice4(JoinPoint joinPoint, Exception ex) {
		System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
		System.out.println("Exception is:" + ex.getMessage());
	}

	//AfterReturning advice
	@AfterReturning("execution(public void show())")
	public void loggingAdvice5() {
		System.out.println("AfterReturning from 'show'");
	}

	//pointcut with 'within' and 'args ------------------------
	@Pointcut("within(com.au.Question2.Helper)")
	public void allhelper() {
	}

	@Pointcut("(args(String))")
	public void allStringArgs() {
	}
}
