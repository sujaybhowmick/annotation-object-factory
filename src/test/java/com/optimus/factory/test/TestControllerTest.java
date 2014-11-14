package com.optimus.factory.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestControllerTest {

    TestController testController;

    @Before
    public void setUp() throws Exception {
        testController = new TestController();

    }

    @After
    public void tearDown() throws Exception {
        testController = null;
    }

    @Test
    public void testTestControllerAlertService() throws Exception {
        assertEquals("This is an Alert Event.",
                testController.getAlertService().onEvent());
    }

    @Test
    public void testTestControllerPingService() throws Exception {
        assertEquals("This is an Ping Event.",
                testController.getPingService().onEvent());
    }
}