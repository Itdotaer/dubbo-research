package demo.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * AspectJTest
 *
 * @author jt_hu
 * @date 2018/5/21
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test() {

    }

    @Before("test()")
    public void a() {
        System.out.println("Before");
    }

    @Around("test()")
    public Object b(ProceedingJoinPoint joinPoint) {
        System.out.println("Around-1");

        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("Around-2");
        return o;
    }

    @After("test()")
    public void c() {
        System.out.println("After");
    }


}
