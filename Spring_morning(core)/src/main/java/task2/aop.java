package task2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy

public class aop {
    @Before("pointBreak()")
    public static void beforeannotation() {
        System.out.println("Before calling the method");
    }

    @After("pointBreak()")
    public static void afterannotation() {
        System.out.println("after calling the method");
    }

    @Pointcut("execution (public void getName())")
    public void pointBreak() {
     System.out.println("point break");
    }

    @AfterReturning(pointcut = "execution(int getRollnumber())", returning = "roll")
    public void afterreturningannotation(int roll) {
        System.out.println("After returning annotation. Returned roll number = " + roll);
    }


}
