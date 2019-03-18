package com.sunshine.shine.common.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {

    enum Priority{LOW,MEDIUM,HIGH}

    enum Status{START,NOT_STARTED}

    String author() default "sunshine";

    Priority priority() default Priority.MEDIUM;

    Status status() default Status.NOT_STARTED;
}
