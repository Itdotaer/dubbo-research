package demo.ratelimit.aop;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * LimitAspect
 *
 * @author jt_hu
 * @date 2018/6/26
 */
@Aspect
public class LimitAspect {

    private static RateLimiter rateLimiter = RateLimiter.create(100);

    @Pointcut("@annotation(demo.ratelimit.annotation.ServiceLimit)")
    public void rateLimit(){}

    @Around("rateLimit()")
    public Object around(ProceedingJoinPoint jp) {
        System.out.println("around");

        boolean acquired = rateLimiter.tryAcquire();

        if (acquired) {
            try {
                return jp.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        return null;
    }

}
