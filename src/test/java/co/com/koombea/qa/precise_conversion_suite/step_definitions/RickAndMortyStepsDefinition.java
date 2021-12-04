package co.com.koombea.qa.precise_conversion_suite.step_definitions;

import co.com.koombea.qa.precise_conversion.api.RickAndMorty;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

public class RickAndMortyStepsDefinition {
    RickAndMorty rickAndMorty;
    Response body;

    @Given("I want to use Rick And Morty API")
    public void iWantToUseRickAndMortyAPI() {
        rickAndMorty = new RickAndMorty();
    }

    @When("I send a GET request to the endpoint {string}")
    public void iSendAGETRequestToTheEndpointCharacter(String endpoint) {
      body = rickAndMorty.allCharactersRequest(endpoint);
    }

    @When("I send a GET request to the {string} with a specific {string}")
    public void iSendAGETRequestToTheWithASpecific(String endpoint, String id) {
        body = rickAndMorty.specificCharacterRequest(endpoint, id);
    }

    @When("I send a GET request to the {string} with a parameter {string}")
    public void iSendAGETRequestToTheWithAParameter(String endpoint, String characterName) {
        body = rickAndMorty.filterByCharacterNameRequest(endpoint, characterName);
    }

    @Then("I will see a {int} response code")
    public void iWillSeeAResponseCode(Integer responseCode) {
    body.then().assertThat().statusCode(responseCode);
    }

    @And("I will see character {string} in the response body")
    public void iWillSeeCharacterInTheResponseBody(String characterName) {
        String actualNumber = body.then().extract().path("name").toString();
        Assert.assertEquals(
                "Count for all characters should be 826",
                characterName,
                actualNumber);
    }

    @And("I will see {string} in the response body")
    public void iWillSeeAllCharactersInTheResponseBody(String totalCharacters) {
       String actualCount = body.then().extract().path("info.count").toString();
        Assert.assertEquals(
                "Count for all characters should be 826",
                totalCharacters,
                actualCount);
    }


}
