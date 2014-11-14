package com.optimus.service;

/**
 * Created by sujay on 14/11/14.
 */
public class PingService implements InfraService {

    public String onEvent(){
        return "This is an Ping Event.";
    }
}
