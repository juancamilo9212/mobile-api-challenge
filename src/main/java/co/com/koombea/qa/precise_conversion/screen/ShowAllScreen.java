package co.com.koombea.qa.precise_conversion.screen;

import co.com.koombea.qa.precise_conversion.utils.UtilityFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ShowAllScreen {

    public ShowAllScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hectare (ha)']")
    WebElement hectareTitle;

    public boolean isHectareaTitleDisplayed(){
        return hectareTitle.isDisplayed();
    }
}
