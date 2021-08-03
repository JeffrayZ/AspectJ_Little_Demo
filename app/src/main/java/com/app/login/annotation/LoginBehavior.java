package com.app.login.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author feifei.zhan
 */
@Target(ElementType.METHOD) // 目标作用在方法之上
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginBehavior {
}
