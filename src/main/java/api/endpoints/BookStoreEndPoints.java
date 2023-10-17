package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.commons.codec.binary.Base64;
import report.ExtentReportManager;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class BookStoreEndPoints {


    private static RequestSpecification baseRequestSpec(String authToken) {
      /*  String credentials = USERNAME + ":" + PASSWORD;
        String base64Credentials = new String(Base64.encodeBase64(credentials.getBytes()));
        System.out.println("BASE 64 AUTH ---> " + base64Credentials);*/
        return given()
                .header("accept", "application/json")
                // .header("authorization", "Basic " + base64Credentials)
                .header("Authorization", authToken)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }

    private static RequestSpecification baseRequestSpec(String authToken, Object payload) {
        return given()
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .body(payload);
        // .contentType(ContentType.JSON);
    }


    public static Response getAllBooks(String authToken) {
       RequestSpecification specs = baseRequestSpec(authToken);
        Response response = specs
                .when()
                .get(Routes.books);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;

    }

    public static Response addBook(String authToken, Object payload) {
        RequestSpecification specs = baseRequestSpec(authToken,payload);
        Response response =specs
                /*.and()
                .body(payload)*/
                .when()
                .post(Routes.books);

        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    public static Response getBookData(String authToken, String isbn) {
        RequestSpecification specs = baseRequestSpec(authToken);
        Response response = specs
                .queryParam("ISBN", isbn)
                .when()
                .get(Routes.getBook);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    public static Response updateBook(String authToken, String ISBN, String body) {
        RequestSpecification specs = baseRequestSpec(authToken);
        Response response = specs
                .pathParams("ISBN", ISBN)
                .body(body)
                .when()
                .put(Routes.updateBookDetails);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    private static void printLogReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryDetail = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryDetail.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryDetail.getMethod());
    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

}


