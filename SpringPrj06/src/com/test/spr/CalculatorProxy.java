/*
	CalculatorProxy.java
	- 프록시 클래스.
	- 보조 업무 적용 및 주 업무 호출 과정
*/
// InvocationHandler 인터페이스


package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class CalculatorProxy implements InvocationHandler
{
	private Object target;
	
	public CalculatorProxy(Object target)
	{
		this.target = target;
	}

	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		
		// 보조 업무cross-cutting concern(설정)
		// 시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정시작 =======================");
		
		// 주 업무(core concern) 실행 내용
		Object result = method.invoke(target, args);
		
		sw.stop();
		log.info("처리 시간 측정 종료 =======================");
		log.info(String.format("경과시간 : %s/1000초", sw.getTotalTimeMillis()));
		
		return result;
	}
	
	
	
}	
