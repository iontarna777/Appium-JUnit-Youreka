package com.synaptic.library.pages;

import com.synaptic.library.utils.*;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);

    }
    //    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);



}
