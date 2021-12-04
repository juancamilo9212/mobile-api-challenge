package co.com.koombea.qa.precise_conversion.api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class RickAndMorty {
    final static String baseUrl="https://rickandmortyapi.com/api";

    public Response allCharactersRequest(String endpoint){
         return given().when().get(baseUrl+endpoint).andReturn();
    }

    public Response specificCharacterRequest(String endpoint,String id){
        return given().when().get(baseUrl+endpoint+id).andReturn();
    }

    public Response filterByCharacterNameRequest(String endpoint,String name){
        return given().queryParam("name", name).when().get(baseUrl+endpoint).andReturn();
    }
}
