package com.synaptic.library.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AppiumDriver<MobileElement> driver;
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//    private final static String ANDROID_APP_URL = ConfigurationReader.getProperty("android.app.path");
//    private final static String IOS_APP_URL = ConfigurationReader.getProperty("ios.app.url");


    private Driver() {
    }

    public static void setupDriver() {
        //mvn test -Dplatform=android
        String platform = System.getProperty("platform");
        //if platform was't pass as an env variable
        if (driver == null){
            platform = ConfigurationReader.getProperty("platform");


    }

            switch (platform.toLowerCase()) {
                case "android":
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigurationReader.getProperty("android.app.path"));
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Synaptic's_Galaxy_Tab_S6");//Pixel_4
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                    desiredCapabilities.setCapability("appPackage","com.synaptic.yourekamobile");
                    desiredCapabilities.setCapability("appActivity","com.salesforce.androidsdk.phonegap.ui.SalesforceDroidGapActivity");
                    desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30000);
//                    desiredCapabilities.setCapability("w3c","true");
                    try {
                        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ios":
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.3");
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, ConfigurationReader.getProperty("ios.app.path"));
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Synaptic's iPad");
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30000);
//                    desiredCapabilities.setCapability("w3c","true");


                    try {
                        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);//localhost
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new RuntimeException("Driver type is not implemented yet!");
            }
        }




    public static AppiumDriver getDriver(){
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver = null;
        }
    }


}
