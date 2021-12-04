package co.com.koombea.qa.precise_conversion.screen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FavoriteSectionScreen {

    public FavoriteSectionScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.ba.universalconverter:id/favoritesCategoryIcon")
    WebElement favoriteMeasure;

    public boolean isFavoriteMeasureDisplayed(){
        return favoriteMeasure.isDisplayed();
    }
}
