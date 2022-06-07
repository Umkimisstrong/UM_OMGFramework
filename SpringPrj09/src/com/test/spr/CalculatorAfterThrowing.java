/*
	CalculatorAfterThrowing.java
	- After Throwing Advice 구성
*/

package com.test.spr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class CalculatorAfterThrowing implements ThrowsAdvice
{
	// 따로 구현할 메소드는 없음. → 명시적으로 인터페이스를 implements 하는 것
	
	
	// 파라미터(매개변수를) 잘못 넘긴 예외에 대한 처리를 해주는 메소드 afterThrowing()
	public void afterThrowing(IllegalArgumentException e)
	{
		Log log = LogFactory.getLog(this.getClass());
		log.info("After Throwing Advice 수행 =============================================");
		
		log.info("주 업무 실행 과정에서 예외 발생 시 처리되는 사후 업무");
		log.info(e.toString());
		
		log.info("============================================= After Throwing Advice 수행");
		
	}
	
	
}
