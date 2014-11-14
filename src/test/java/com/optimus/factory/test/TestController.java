package com.optimus.factory.test;

import com.optimus.factory.TargetTypeAnnotationAware;
import com.optimus.factory.AnnotationObjectFactory;
import com.optimus.factory.TargetType;

/**
 * Created by sujay on 14/11/14.
 */
public class TestController implements TargetTypeAnnotationAware {


    @TargetType("com.optimus.factory.test.AlertService")
    private InfraService alertService;

    @TargetType("com.optimus.factory.test.PingService")
    private InfraService pingService;

    public TestController(){
        init();
    }

    @Override
    public void init() {
        AnnotationObjectFactory.create(this);
    }

    public InfraService getAlertService() {
        return alertService;
    }

    public InfraService getPingService() {
        return pingService;
    }
}
