package com.sunshine.shine.MyTest.TestTest;

import com.sunshine.shine.common.Annotations.Id;
import com.sunshine.shine.MyTest.TestAnnotation.AnnotationTest2;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestId {

    @Test
    public void test(){
        List<Integer> list=new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        traverse(list,AnnotationTest2.class);

    }
    private void traverse(List<Integer> list,Class<?> clazz){
        for(Method m:clazz.getDeclaredMethods()){
            Id id = m.getAnnotation(Id.class);
            if(id!=null){
                System.out.println("id= "+id.id());
                System.out.println("description= "+id.description());
            }
        }
        for(int i:list){
            System.out.println("i= "+i);
        }
    }
}
