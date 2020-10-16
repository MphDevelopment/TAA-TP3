package tp3.monitor;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import tp3.bank.Bank;

@Aspect
@Component
public class ServiceMonitor {

	@Before("execution(* tp3.bank.*.*(..)) "
			+ "|| execution(* tp3.client.*.*(..)) "
			+ "|| execution(* tp3.provider.*.*(..))"
			+ "|| execution(* tp3.store.*.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.print(joinPoint.getTarget().getClass().getName());
		
		System.out.print("#" + joinPoint.getSignature().getName());
				
		String argsString = " With args: ";
		for(Object a : joinPoint.getArgs())
		{
			argsString += a.toString() + " ";
		}
		System.out.println(argsString);
	}
	
	@Around("execution(* tp3.bank.Bank.transfert(..))")
	public boolean verify(ProceedingJoinPoint joinPoint)
	{
		Map<Integer, Integer> accounts = ((Bank)joinPoint.getTarget()).getAccounts();
		Object[] args = joinPoint.getArgs();
		//senderId, receiverId, amount
		if(accounts.get((Integer)args[0]) < (Integer)args[2])
		{
			return false;
		} else
		{
			try {
				joinPoint.proceed();
				return true;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
		
	}

}