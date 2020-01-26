package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.logging.Logger;

@Component // bean 으로 등록이 되어야 하므로
@Aspect // @LogExecutionTime 이라는 어노테이션이 메소드에 붙으면 어떤 수행을 하는지 알수 있도록 해주는 class 이므로!
public class LogAspect {

	Logger logger = (Logger) LoggerFactory.getLogger(LogAspect.class);

	/*
	 *
	 * around 라는 어노테이션을 쓰면 jointPoint 라는 것을 인자로 받는다. -> jointpoint 라는 것은 해당 어노테이션이 붙어있는
	 * 메소드(타겟)를 뜻한다. 이 타겟이 Jointpoint 라는 인터페이스 타겟으로 들어오고, 이것을 실행한다는 코드가 바로 밑에 있는 'Object
	 * proceed = joinPoint.proceed();' 이고, 이것을 리턴해준다. 단지 앞 뒤로 시간을 재서 logger 를 사용하여 출력해줌.
	 ***
	 * @Around("@annotation(LogExecutionTime)") *** => 이 모든 일들을 LogExecutionTime 이라는
	 * 어노테이션이 붙은 모든 곳에서 하겠다. 이것이 바로 스프링이 제공해주는 어노테이션 기반의 AOP 이고, 이 내부는 프록시 패턴 기반으로 동작하고
	 * 있다.
	 *
	 * 이렇게 만든 상태에서 어플리케이션을 실행하면, localhost: 8080 > find owner 에서 콘솔에서 성능 측정이 되는 것을 볼 수 있다.
	 *
	 */
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object proceed = joinPoint.proceed();

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());
		return proceed;
	}

}
