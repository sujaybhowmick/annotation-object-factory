package com.optimus.factory.test;

import com.optimus.factory.AnnotationAware;
import com.optimus.factory.AnnotationObjectFactory;
import com.optimus.factory.TargetType;

/**
 * Created by sujay on 14/11/14.
 */
public class TestController2 implements AnnotationAware {

    @TargetType("com.optimus.factory.test.SomeService")
    private InfraService someService;

    public TestController2(){
        init();
    }

    @Override
    public void init() {
        AnnotationObjectFactory.create(this);
    }
}
