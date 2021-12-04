package co.com.koombea.qa.precise_conversion.screen;


import co.com.koombea.qa.precise_conversion.utils.UtilityFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SideMenuScreen {

    AndroidDriver<AndroidElement> driver;
    UtilityFunctions util;

    public SideMenuScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        util = new UtilityFunctions(driver);
    }

    @AndroidFindBy(className = "android.widget.ImageButton")
    WebElement menuBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Area']")
   WebElement areaOption;

    @AndroidFindBy(xpath = "// android.widget.TextView[@text='Favorite conversions']")
    WebElement favoriteSectionBtn;



    public void clickOnMenuBtn(){
        menuBtn.click();
    }

    public void clickOnAreaOption(){
        areaOption.click();
    }

    public void scrollAndClickOnSpeed(){
        util.scrollAndClickOnOption("Speed");
    }

    public void clickOnFavoriteSection(){
        favoriteSectionBtn.click();
    }


}
