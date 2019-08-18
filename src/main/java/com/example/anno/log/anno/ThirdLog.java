package com.example.anno.log.anno;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ThirdLog {

    /** service 微服务名称 */
    String local() default "";

    /** 第三方名称 */
    String third() default "";

}
