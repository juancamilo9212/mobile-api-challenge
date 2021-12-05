package co.com.koombea.qa.precise_conversion;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import co.com.koombea.qa.precise_conversion.utils.*;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseAppium {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;

    public AndroidDriver<AndroidElement> init() throws Exception {
        PropertyLoader loadProperty = new PropertyLoader();
        File app = new File(
                loadProperty.getConfigValue("apkDir"),
                loadProperty.getConfigValue("apkName")
        );

        DesiredCapabilities clientCapabilities = new DesiredCapabilities();
        clientCapabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
        clientCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        clientCapabilities.setCapability(MobileCapabilityType.UDID, loadProperty.getConfigValue("udid"));
        clientCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,loadProperty.getConfigValue("deviceName"));
        clientCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        try {
            driver = new AndroidDriver<>(
                    new URL("http://127.0.0.1:4723/wd/hub")
                    ,clientCapabilities
            );
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        }catch (Exception e){
            throw new Exception("Error connecting to Appium Service:" + e.getMessage());
        }

    }

    public void tearDown(){
        if(driver != null) driver.quit();
    }


}
