package com.synaptic.library.pages.android;

import com.synaptic.library.pages.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class HomeAndroidPage extends BasePage {


    @FindBy(className = "android.widget.Button")
    public MobileElement hamburgerMenu;
}
