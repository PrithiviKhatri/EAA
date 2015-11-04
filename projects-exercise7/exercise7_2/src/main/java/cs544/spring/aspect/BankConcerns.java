package cs544.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.util.StopWatch;

import cs544.spring.bank.logging.ILogger;

@Aspect
public class BankConcerns {
	ILogger logger;

	public void setLogger(ILogger logger) {
		this.logger = logger;
	}

	@Before("execution(* cs544.spring.bank.dao.*.*(..))")
	public void logDaoMethod(JoinPoint point) {

		logger.log("calling method =" + point.getSignature().getName());

	}

	@Around("execution(* cs544.spring.bank.service.*.*(..))")
	public Object logServiceMethodTime(ProceedingJoinPoint point) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Object retvalue = point.proceed();
		sw.stop();
		long timetaken = sw.getLastTaskTimeMillis();
		System.out.println("timeTaken for method =" + point.getSignature().getName() + " is " + timetaken + "ms");
		return retvalue;
	}

	@After("execution(* cs544.spring.bank.jms.*.*(..)) && args(msg)")
	public void logJMSmessage(JoinPoint point, String msg) {
		logger.log("sending jms message=" + msg);
	}

}
