package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserEndPoints {
    private static RequestSpecification baseRequestSpec() {
        return given()
                .header("accept", "application/json")
                .contentType(ContentType.JSON);
    }

    private static Response performPostRequest(String endpointPath, String payload) {
        return baseRequestSpec()
                .body(payload)
                .when()
                .post(endpointPath);
    }

    public static Response createUser(String payload) {
        return performPostRequest(Routes.createUser, payload);
    }

    public static Response authorizeUser(String payload) {
        return performPostRequest(Routes.validateUser, payload);
    }

    public static Response generateToken(String payload) {
        return performPostRequest(Routes.generatToken, payload);
    }

    public static Response deleteUser(String authToken, String UUID) {
        return baseRequestSpec()
                .header("Authorization", "Bearer " + authToken)
                .pathParams("uuid", UUID)
                .when()
                .delete(Routes.deleteUser);
    }

    public static Response getUserInfo(String authToken, String UUID) {
        return baseRequestSpec()
                .header("Authorization", "Bearer " + authToken)
                .pathParams("uuid", UUID)
                .when()
                .get(Routes.getUser);
    }
   /* public static Response createUser(User payload){
       Response response =  given()
                                .header("accept","application/json")
                                .contentType(ContentType.JSON)
                              .and()
                                .body(payload)
                              .when()
                                .post(Routes.createUser);

       return response;
    }

    public static Response authorizeUser(User payload){
        Response response =  given()
                .header("accept","application/json")
                .contentType(ContentType.JSON)
                .and()
                .body(payload)
                .when()
                .post(Routes.validateUser);

        return response;
    }

    public static Response generateToken(User payload){
        Response response =  given()
                .header("accept","application/json")
                .contentType(ContentType.JSON)
                .and()
                .body(payload)
                .when()
                .post(Routes.generatToken);

        return response;
    }*/

}
