package demo.ratelimit.annotation;

import java.lang.annotation.*;

/**
 * ServiceLimit
 *
 * @author jt_hu
 * @date 2018/6/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLimit {

    String desc() default "";

}
