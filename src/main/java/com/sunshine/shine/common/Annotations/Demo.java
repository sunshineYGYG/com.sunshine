package com.sunshine.shine.common.Annotations;


import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Demo {
    String value() default "";
}
