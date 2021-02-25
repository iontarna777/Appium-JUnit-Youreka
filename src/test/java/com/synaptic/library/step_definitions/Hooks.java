package com.synaptic.library.step_definitions;

import com.synaptic.library.utils.AppiumServer;
import com.synaptic.library.utils.Driver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {



    @Before
    public void setup(){
        //AppiumServer.startServer();
        Driver.setupDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

    }


    @After
    public void teardown(){
        //AppiumServer.stopServer();
        Driver.closeDriver();

    }


}
