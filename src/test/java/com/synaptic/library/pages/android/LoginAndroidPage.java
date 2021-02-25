package com.synaptic.library.pages.android;

import com.synaptic.library.pages.BasePage;
import com.synaptic.library.pages.basePages.LoginBasePage;
import com.synaptic.library.utils.ConfigurationReader;
import com.synaptic.library.utils.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class  LoginAndroidPage extends LoginBasePage {


    //@iOSXCUITFindBy(xpath = "")
    //Login Page
    @AndroidFindBy(xpath ="//android.view.View[contains(@resource-id,'username')]" )
    public MobileElement usernameInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'password')]")
    public MobileElement passwordInput;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'Login')]")
    public MobileElement loginButton;

    //AllowAccess Page
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'oaapprove')]")
    public MobileElement allowAccessButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'oadeny')]")
    public MobileElement denyAccessButton;


    //Create Passcode Page
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'com.synaptic.yourekamobile:id/sf__passcode_text')]")
    public MobileElement newPassCodeInput;  //same as verify passcode

    //Set up Fingerprint unlock
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'c')]")
    public MobileElement notNow;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,'sf__biometric_enable_button')]")
    public MobileElement enableFingerprintButton;


    //Hamburger Menu
    @FindBy(xpath = "//*[@text='Youreka Mobile']/following-sibling::android.view.View")
    public MobileElement version;

    @FindBy(xpath = "//android.view.View[@text =  'Search']")
    public MobileElement searchButton;

    @FindBy(xpath = "//android.view.View[@text =  'Data Management']")
    public MobileElement dataManagementButton;

    @FindBy(xpath = "//android.view.View[@text =  'Logout']")
    public MobileElement logoutButton;




    @Override
    public void login(){
        usernameInput.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(ConfigurationReader.getProperty("email")).perform();
        passwordInput.click();
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        //click Log in
        loginButton.click();
        //allow access
        allowAccessButton.click();
        //create passcode
        newPassCodeInput.sendKeys("0000");
        newPassCodeInput.sendKeys("0000");


    }

    @Override
    public void allowAccess(boolean allowAccess){
        if (allowAccess == true){
             allowAccessButton.click();
        }else if(allowAccess ==false){
            denyAccessButton.click();
        }
    }

    @Override
    public void createPasscode(int passcode) {

    }





    }