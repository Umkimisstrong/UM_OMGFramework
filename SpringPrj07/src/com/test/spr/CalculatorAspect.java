/*
	CalculatorProxy.java
	- 프록시 클래스.
	- 보조 업무 적용 및 주 업무 호출 과정
*/
// InvocationHandler 인터페이스

// ○ Spring AOP Proxy 클래스를 만들기 위해서
//    MethodIntercepter 인터페이스를 구현하는 클래스로 설계한다.

package com.test.spr;

// import 참고~!
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class CalculatorAspect implements MethodInterceptor 
{

	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
	public Object invoke(MethodInvocation method) throws Throwable
	{
		// 보조 업무 설정(cross-cutting concern) 설정
		// 시간 측정, 로그 기록(Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();		// 스탑워치 시작
		log.info("처리 시간 측정 시작 =========================================");
		
		
		// 주 업무(core concern) 호출부분~!
		Object result = method.proceed();
		
		sw.stop();		// 스탑워치 종료
		log.info("처리 시간 측정 종료 =========================================");
		log.info(String.format("경과시간 : %s/1000초", sw.getTotalTimeMillis()));
		
		return result;
	}
	
}	
