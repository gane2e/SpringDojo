package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j;

@Component
@Log4j
@Aspect
public class LogAdvice {
	
	/*
	 * org.zerock.service.SampleService로 시작하는 클래스의 메서드가 실행되기 전에 
	 * Before읽고 먼저실행
	 */
//	@Before( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("================================");
	}
	
//	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("str1 : " + str1);
		log.info("str2 : " + str2);
	}
	
	//SampleService실행후 예외발생 캐치
//	@AfterThrowing(pointcut =  "execution(* org.zerock.service.SampleService*.*(..))", throwing = "exception")
	public void logException(Exception exception) {
		log.info("SampleService 실행중 예외가 발생했습니다,,,,");
		log.info("exception :" + exception);
	}
		
	//SampleService실행후 예외 유무 상관없이 실행
//	@After( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logAfter() {
		log.info("=============예외 상관없이 @After는 실행한다==================");
	}
	
//	@AfterReturning( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logReturning() {
		log.info("====================@AfterReturning================");
	}
	
	

	
	// @Around = 메서드 직접 실행 권한 O, 메서드의 실행 전/후 처리 가능
	// ProceedingJoinPoint = @Around와 결합하여 파라미터/예외 처리 가능
	@Around( "execution(* org.zerock.service.SampleService*.*(..))")
	public Object ObjectlogTime(ProceedingJoinPoint pjp) {
		
		long start = System.nanoTime();

		//어떤클래스 호출하고있는지
		log.info("Target : " + pjp.getTarget());

		//파라미터 읽기
		log.info("Param : " + Arrays.toString(pjp.getArgs()));
		
		//어떤메서드가 호출되고 있는지
		log.info("Name : " + pjp.getSignature().getName()); 		
		
		Object result = null;
		
		try {
			//실제 메서드 호출하는 코드(doadd 일고 result에 결과반환함)
			result = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		
		log.info("TIME : " + (end-start));
		
		//try결과값(메서드 실행값) 리턴
		return result;
	}
}
