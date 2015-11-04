package cs544.exercise7_1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class ApplicationAdvice {

	@After("execution(public void cs544.exercise7_1.IEmailSender.sendEmail(..)) && args(email,message)")
	public void logendEMail(JoinPoint joinpoint, String email, String message) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		IEmailSender emailsender = (EmailSender) joinpoint.getTarget();
		System.out.println(dateFormat.format(date) + " method= " + joinpoint.getSignature().getName() + " address= "
				+ email + " message " + message);
		System.out.println(" outgoing mail server=" + emailsender.getOutgoingMailServer());
	}

	@Around("execution(public * cs544.exercise7_1.ICustomerDAO.*(..) )")
	public void logMethodDuration(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start();
		Object retval = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute " + call.getSignature().getName() + " = " + totaltime);
	}

}
