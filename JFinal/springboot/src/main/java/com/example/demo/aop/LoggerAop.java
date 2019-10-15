package com.example.demo.aop;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 10:32
 * @Version 1.0
 */
@Aspect
@Configuration
@Slf4j
public class LoggerAop {

    // 切入所有的controller
    private static final String POINT = "execution (* com.example.demo.controller.*.*(..))";

    // 统计每次请求的耗时
    @Around(POINT)
    public Object consAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        long startTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringType().getSimpleName() + "." + signature.getName();
        this.printBeginLog(methodName, args);
        Object result = joinPoint.proceed(args);
        this.printResultLog(methodName, result, startTime);
        return result;
    }

    // 打印每次方法的入参及方法名
    private void printBeginLog(String methodName, Object[] args) {
        log.info("{} begin param {}", methodName, JSONObject.toJSONString(args, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.IgnoreNonFieldGetter));
    }

    // 打印每次请求的出参和耗时
    private void printResultLog(String methodName, Object result, long startTime) {
        String resStr = null;
        if (null != result) {
            resStr = JSONObject.toJSONString(result, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.IgnoreNonFieldGetter);
            if (resStr.length() > 1000) {
                resStr = resStr.substring(0, 1000) + "......";
            }
        }
        log.info("{} success [cost:{}]ms result:{}", methodName, (System.currentTimeMillis() - startTime), resStr);
    }
}
