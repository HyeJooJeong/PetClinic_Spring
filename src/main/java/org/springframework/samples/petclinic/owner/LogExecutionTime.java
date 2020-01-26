package org.springframework.samples.petclinic.owner;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 어떤 method 에다가 @LogExecutionTime 어노테이션을 쓰겠다 !!
@Retention(RetentionPolicy.RUNTIME) // 해당 어노테이션은 런타임 동안 유지된다 !!
public @interface LogExecutionTime {

}
