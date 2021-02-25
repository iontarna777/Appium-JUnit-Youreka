package com.synaptic.library.pages.basePages;

import com.synaptic.library.utils.Driver;
import freemarker.core.Comment;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class LoginBasePage {


    public LoginBasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    public abstract void login();

    public abstract void allowAccess(boolean allow);

    public abstract void createPasscode(int passcode);
}
