package com.optimus.test;

import com.optimus.controller.TestController2;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestController2Test {

    TestController2 testController2;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = RuntimeException.class)
    public void testClassNotFoundException() throws Exception {

        testController2 = new TestController2();

    }


}