package com.sunshine.shine.common.Aspects;


import com.sunshine.shine.Util.AopUtil;
import com.sunshine.shine.common.Annotations.Demo;
import com.sunshine.shine.config.BeanConfig;
import com.sunshine.shine.config.CartoonConfig;
import com.sunshine.shine.controller.TestController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class DemoAspect {

    @Resource
    private CartoonConfig cartoonConfig;

    @Resource
    private BeanConfig beanConfig;

    @Resource
    private TestController testController;

    @Pointcut("execution(public * com.sunshine.shine.*.*Config.get*(..))")
    public void pointCut() {

    }



    @Around("pointCut()")
    public <T> T demo(ProceedingJoinPoint joinPoint) throws Throwable {

        Object aThis = joinPoint.getThis();
        Object target = joinPoint.getTarget();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        String kind = joinPoint.getKind();
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        Class<?> aClass = joinPoint.getTarget().getClass();

//        Object target1 = AopUtil.getTarget(aClass);
//        Object cglibProxyTargetObject = AopUtil.getCglibProxyTargetObject(aClass);
//        Class<?> aClass1 = cglibProxyTargetObject.getClass();
//
//        if(aClass1.isAnnotationPresent(Demo.class)){
//            String value = aClass1.getAnnotation(Demo.class).value();
//            System.out.println(value);
//        }

        Class withinType = sourceLocation.getWithinType();
//        String name = signature.getName();
        Class declaringType = signature.getDeclaringType();
//        Class<? extends Class> aClass1 = declaringType.getClass();
        if (declaringType.isAnnotationPresent(Demo.class)) {
            Demo annotation = (Demo) declaringType.getAnnotation(Demo.class);
            String value = annotation.value();
            System.out.println(value);
        }


//        Class<?> thisClass = aThis.getClass();
//        Class<?> targetClass = target.getClass();
//        if(thisClass.isAnnotationPresent(Demo.class)){
//            String value = thisClass.getAnnotation(Demo.class).value();
//            System.out.println(value);
//        }
//        if(targetClass.isAnnotationPresent(Demo.class)){
//            String value = targetClass.getAnnotation(Demo.class).value();
//            System.out.println(value);
//        }

        T proceed = (T) joinPoint.proceed();
        T t = (T) ("22" + proceed);
        System.out.println(t);
        return t;
    }

    @Around("@annotation(demo)")
    public <T> T demo(ProceedingJoinPoint joinPoint, Demo demo) throws Throwable {

        Class<?> aClass = joinPoint.getTarget().getClass();
        if (aClass.isAnnotationPresent(Demo.class)) {
            String value = aClass.getAnnotation(Demo.class).value();
            System.out.println(value);
        }
        return (T) joinPoint.proceed();
    }

}
