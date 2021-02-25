package com.synaptic.tests;

import com.synaptic.library.utils.ConfigurationReader;
import com.synaptic.library.utils.Driver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Demo {

     AndroidDriver<AndroidElement> driver;

     @Before
     public void setup () {
          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
          desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
          desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
          desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\ionta\\Downloads\\Youreka_Hollywood_v11.apk");
          desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Synaptic's_Galaxy_Tab_S6");//Synaptic's_Galaxy_Tab_S6  Pixel_4
          desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
          desiredCapabilities.setCapability("appPackage","com.synaptic.yourekamobile");
          desiredCapabilities.setCapability("appActivity","com.salesforce.androidsdk.phonegap.ui.SalesforceDroidGapActivity");
          desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
          try {
               driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
          } catch (Exception e) {
               e.printStackTrace();
          }

     }


     @Test
     public void demo() throws InterruptedException {

          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          //locating login input
          AndroidElement usernameInput = driver.findElementByXPath("//android.view.View[contains(@resource-id,'username')]");
          usernameInput.click();
          Actions actions = new Actions(driver);
          actions.sendKeys("ion@yourekaprodtest.com").perform();
          //locating password input
          AndroidElement passwordInput = driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'password')]");
          passwordInput.click();
          passwordInput.sendKeys("Parola19911");
          //loginIn button
          AndroidElement loginButton = driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'Login')]");
          loginButton.click();

          //todo locate notallow button
          AndroidElement denyButton  = driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'oadeny')]");

          //Allow button
          AndroidElement allow  = driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'oaapprove')]");
          allow.click();

          AndroidElement firstPassINput  = driver.findElementByXPath("//android.widget.EditText[contains(@resource-id,'com.synaptic.yourekamobile:id/sf__passcode_text')]");
          firstPassINput.click();
          firstPassINput.sendKeys("0000");
          firstPassINput.click();
          firstPassINput.sendKeys(("0000"));

          AndroidElement notNow = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'sf__biometric_not_now_button')]"));
          notNow.click();

//          AndroidElement enableButton = driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'sf__biometric_enable_button')]");
//          enableButton.click();
//          Thread.sleep(5000);



          WebDriverWait wait = new WebDriverWait(driver,30);


          AndroidElement menu = driver.findElementByClassName("android.widget.Button");
          wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MobileBy.className("android.widget.Button")));

          menu.click();

//

          AndroidElement version = driver.findElementByXPath("//*[@text='Youreka Mobile']/following-sibling::android.view.View");
          String versionText = version.getText();
          //Hamburger menu
          AndroidElement searchButton = driver.findElement(By.xpath("//android.view.View[@text =  'Search']"));


          Assert.assertEquals("Version not v3.1.21" ,versionText, "v3.1.21");



//          Thread.sleep(15000);
//          AndroidElement toFind = driver.findElementByXPath("(//*[@class = 'android.widget.Button'])[0]");
//          System.out.println(driver.getPageSource());
//          AndroidElement allow = driver.findElementByXPath("//android.widget.Button[contains(@resource-id,'Allow')]");
//          allow.click();

     }
}
