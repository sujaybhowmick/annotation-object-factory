package com.optimus.controller;

import com.optimus.factory.TargetTypeAnnotationAware;
import com.optimus.factory.AnnotationObjectFactory;
import com.optimus.factory.TargetType;
import com.optimus.service.AlertService;
import com.optimus.service.InfraService;

/**
 * Created by sujay on 14/11/14.
 */
public class TestController implements TargetTypeAnnotationAware {


    @TargetType("com.optimus.service.AlertService")
    private InfraService alertService;

    @TargetType("com.optimus.service.PingService")
    private InfraService pingService;

    @TargetType("com.optimus.service.AlertService")
    private AlertService alertService2;

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
