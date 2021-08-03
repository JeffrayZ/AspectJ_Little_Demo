//package com.app.login.aspect;
//
//import android.util.Log;
//
//import com.app.login.annotation.ClickBehavior;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//
//@Aspect
//public class LoginBehaviorAspect {
//    private static final String TAG = "aop_aspect >>> ";
//
//    @Pointcut("execution(@com.app.login.annotation.LoginBehavior * *(..))")
//    public void methodPointCut() {
//    }
//
//    @Around("methodPointCut()")
//    public Object jPoint(ProceedingJoinPoint joinPoint) throws Throwable {
//        // 获取签名方法
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        // 获取方法所属的类名
//        String className = methodSignature.getDeclaringType().getSimpleName();
//        // 获取方法名
//        String methodName = methodSignature.getName();
//        // 获取方法注解
//        ClickBehavior annotation = methodSignature.getMethod().getAnnotation(ClickBehavior.class);
//        long begin = System.currentTimeMillis();
//        Log.e(TAG,"方法开始");
//        Object obj = joinPoint.proceed();
//        Log.e(TAG,"方法结束");
//        long end = System.currentTimeMillis();
//        Log.e(TAG,"方法用时:" + (begin - end));
//        Log.e(TAG,String.format("className:%s methodName:%s annotation:%s",className,methodName,annotation) );
//        return obj;
//    }
//}
