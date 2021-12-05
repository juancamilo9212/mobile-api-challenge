package co.com.koombea.qa.precise_conversion_suite.step_definitions;

import co.com.koombea.qa.precise_conversion.BaseAppium;
import co.com.koombea.qa.precise_conversion.screen.ConversionScreen;
import co.com.koombea.qa.precise_conversion.screen.FavoriteSectionScreen;
import co.com.koombea.qa.precise_conversion.screen.ShowAllScreen;
import co.com.koombea.qa.precise_conversion.screen.SideMenuScreen;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;

public class PreciseConversionStepsDefinition {

    BaseAppium appium = new BaseAppium();
    AndroidDriver<AndroidElement> driver;
    SideMenuScreen menuScreen;
    ConversionScreen conversionScreen;
    ShowAllScreen allScreen;
    FavoriteSectionScreen favoriteScreen;

    @Given("I open the Precise Unit Conversion App")
    public void iOpenThePreciseUnitConversionApp() throws Exception {
        driver = appium.init();
        menuScreen = new SideMenuScreen(driver);
        conversionScreen = new ConversionScreen(driver);
        allScreen = new ShowAllScreen(driver);
        favoriteScreen = new FavoriteSectionScreen(driver);
    }

    @And("I want to convert {string} to {string}")
    public void iWantToConvertHectareToSquareMeter(String source, String target) {
        menuScreen.clickOnMenuBtn();
        menuScreen.clickOnAreaOption();
        conversionScreen.selectHectareToSquareMeter(source, target);
    }

    @And("I want to convert  {string} to {string}")
    public void iWantToConvertKilometerPerHourToMilePerHour(String source, String target) {
        menuScreen.clickOnMenuBtn();
        menuScreen.scrollAndClickOnSpeed();
        conversionScreen.selectkmtHourTomileHour(source, target);
    }

    @When("I set a {string} to be converted")
    public void iSetAToBeConverted(String input) {
        conversionScreen.typeTheInput(input);
    }

    @When("I click on clear button")
    public void iClickOnClearButton() {
        conversionScreen.clearSrcAndTarget();
    }

    @When("I click on delete button")
    public void iClickOnDeleteButton() {
        conversionScreen.clickOnDeleteBtn();
    }

    @And("I click on show all button")
    public void iClickOnShowAllButton() {
        conversionScreen.clickOnShowAllBtn();
    }

    @And("I click on favorite button")
    public void iClickOnFavoriteButton() {
        conversionScreen.clickOnFavoriteBtn();
        menuScreen.clickOnMenuBtn();
        menuScreen.clickOnFavoriteSection();
    }

    @Then("I see the {string} is shorter than the original value")
    public void iSeeTheNewInputIsShorterThanTheOriginalValue(String newInputValue) {
        String actualSourceText = conversionScreen.getSourceValue();
        Assert.assertEquals(actualSourceText, newInputValue);
        appium.tearDown();
    }

    @Then("I see a {string} generated")
    public void iSeeAGenerate(String targetValue) {
        String actualTargetText = conversionScreen.getTargetValue();
        Assert.assertEquals(actualTargetText, targetValue);
        appium.tearDown();
    }

    @Then("I see the source and target sections are cleared out")
    public void iSeeTheSourceAndTargetSectionsAreClearedOut() {
        String actualTargetText = conversionScreen.getSourceValue();
        Assert.assertEquals(actualTargetText, "1");
        appium.tearDown();
    }

    @Then("I see all conversions screen")
    public void iSeeAllConversionsScreen() {
        Assert.assertTrue(allScreen.isHectareaTitleDisplayed());
        appium.tearDown();
    }

    @Then("I see the conversion is saved in favorites section")
    public void iSeeTheConversionIsSavedInFavoritesSection() {
        Assert.assertTrue(favoriteScreen.isFavoriteMeasureDisplayed());
        appium.tearDown();
    }

}
