package com.sunshine.shine.MyTest.TestAnnotation;

import com.sunshine.shine.Annotations.Todo;
import org.junit.Test;

import java.lang.reflect.Method;


public class AnnotationTest1 {


    public void inCompleteMethod(){

    }
    @Todo(priority = Todo.Priority.HIGH,author = "yangguang",status = Todo.Status.START)
    public void inCompleteMethod2(){

    }

    @Test
    public void test(){
        Class<AnnotationTest1> annotationTest1Class = AnnotationTest1.class;
        for(Method m:annotationTest1Class.getMethods()){
            Todo annotation = m.getAnnotation(Todo.class);
            if(annotation!=null){
                System.out.println(m.getName());
                System.out.println(annotation.author());
                System.out.println(annotation.priority());
                System.out.println(annotation.status());
            }
        }
    }
}