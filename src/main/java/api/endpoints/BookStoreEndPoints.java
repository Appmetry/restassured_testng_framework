package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;

import static io.restassured.RestAssured.given;

public class BookStoreEndPoints {


    private static RequestSpecification baseRequestSpec(String authToken, String USERNAME, String PASSWORD) {
        String credentials = USERNAME + ":" + PASSWORD;
        String base64Credentials = new String(Base64.encodeBase64(credentials.getBytes()));
        System.out.println("BASE 64 AUTH ---> " + base64Credentials);
        return given()
                .header("accept", "application/json")
                .header("authorization", "Basic " + base64Credentials)
                .header("Authorization", authToken)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }

    private static RequestSpecification baseRequestSpec(String authToken) {
        return given()
                //.header("accept", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json");
               // .contentType(ContentType.JSON);
    }

    public static Response getAllBooks(String authToken) {
        return baseRequestSpec(authToken)
                .when()
                .get(Routes.books);
    }

    public static Response addBook(String authToken, String payload) {
        return baseRequestSpec(authToken)
                .and()
                .body(payload)
                .when()
                .post(Routes.books);
    }

    public static Response getBookData(String authToken, String isbn) {
        return baseRequestSpec(authToken)
                .queryParam("ISBN", isbn)
                .when()
                .get(Routes.getBook);
    }

    public static Response updateBook(String authToken, String ISBN, String body) {
        return baseRequestSpec(authToken)
                .pathParams("ISBN", ISBN)
                .body(body)
                .when()
                .put(Routes.updateBookDetails);
    }

}
