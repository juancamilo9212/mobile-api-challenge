package co.com.koombea.qa.precise_conversion.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UtilityFunctions {
    AndroidDriver<AndroidElement> driver;

    public UtilityFunctions(AndroidDriver<AndroidElement> driver) {
        this.driver=driver;
    }

    public void scrollAndClickOnOption(String option){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView" +
                "(text(\""+option+"\"));").click();
    }





}
