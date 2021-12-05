package co.com.koombea.qa.precise_conversion.screen;

import co.com.koombea.qa.precise_conversion.utils.UtilityFunctions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ConversionScreen {

    AndroidDriver<AndroidElement> driver;
    UtilityFunctions util;

    public ConversionScreen(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
        util = new UtilityFunctions(driver);
    }

    @AndroidFindBy(className = "android.widget.Spinner")
    List<WebElement> conversionDropDowns;

    //TODO improve this locator
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView")
    WebElement srcTxtField;

    //TODO improve this locator
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.TextView[1]")
    WebElement targetTxtField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='C']")
    WebElement clearBtn;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='SHOW ALL']")
    WebElement showAllBtn;

    @AndroidFindBy(id = "com.ba.universalconverter:id/btn_del")
    WebElement deleteBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Add to favorites\"]")
    WebElement favoriteBtn;

    public void clearSrcAndTarget() {
        clearBtn.click();
    }

    public String getSourceValue() {
        return srcTxtField.getText();
    }

    public String getTargetValue() {
        return targetTxtField.getText();
    }

    public void selectUnitToConvert(String sourceText, String targetText) {
        conversionDropDowns.get(0).click();
        util.scrollAndClickOnOption(sourceText);
        conversionDropDowns.get(1).click();
        util.scrollAndClickOnOption(targetText);
    }

    public void selectHectareToSquareMeter(String source, String target) {
        this.selectUnitToConvert(source, target);
    }

    public void selectkmtHourTomileHour(String source, String target) {
        this.selectUnitToConvert(source, target);
    }

    public void typeTheInput(String input) {
        char[] inputInChar = input.toCharArray();
        for (char c : inputInChar) {
            driver.findElementByXPath("//android.widget.Button[@text=" + c + ']').click();
        }
    }

    public void clickOnDeleteBtn() {
        deleteBtn.click();
    }

    public void clickOnShowAllBtn() {
        showAllBtn.click();
    }

    public void clickOnFavoriteBtn() {
        favoriteBtn.click();
    }


}
