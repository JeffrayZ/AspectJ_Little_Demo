package com.app.login.aspect;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.app.login.LoginActivity;
import com.app.login.annotation.ClickBehavior;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class ClickBehaviorAspect {
    private static final String TAG = "aop_aspect >>> ";

    @Pointcut("execution(@com.app.login.annotation.ClickBehavior * *(..))")
    public void methodPointCut1() {
    }

    @Pointcut("execution(@com.app.login.annotation.LoginBehavior * *(..))")
    public void methodPointCut2() {
    }

    @Around("methodPointCut1()")
    public Object jPoint1(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取签名方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法所属的类名
        String className = methodSignature.getDeclaringType().getSimpleName();
        // 获取方法名
        String methodName = methodSignature.getName();
        // 获取方法注解
        ClickBehavior annotation = methodSignature.getMethod().getAnnotation(ClickBehavior.class);
        long begin = System.currentTimeMillis();
        Log.e(TAG, "开始时间：" + begin);
        Log.e(TAG, "方法开始");
        Object obj = joinPoint.proceed();
        Log.e(TAG, "方法结束");
        long end = System.currentTimeMillis();
        Log.e(TAG, "结束时间：" + end);
        long duration = end - begin;
        Log.e(TAG, "方法用时:" + duration);
        Log.e(TAG, String.format("className:%s methodName:%s annotation:%s", className, methodName, annotation));
        return obj;
    }

    @Around("methodPointCut2()")
    public Object jPoint2(ProceedingJoinPoint joinPoint) throws Throwable {
        Context context = (Context) joinPoint.getThis();
        if (true) { // 判断登录状态，这里直接写true和false，方便
            Log.e(TAG, "已登录");
            return joinPoint.proceed();
        } else {
            Toast.makeText(context, "未登录", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, LoginActivity.class));
            return null;
        }
    }
}
