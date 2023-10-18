package api.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.commons.codec.binary.Base64;
import report.ExtentReportManager;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseSpecsUtils {

    private static RequestSpecification baseRequestSpec(String USERNAME, String PASSWORD, String authToken) {
        String credentials = USERNAME + ":" + PASSWORD;
        String base64Credentials = new String(Base64.encodeBase64(credentials.getBytes()));
        System.out.println("BASE 64 AUTH ---> " + base64Credentials);
        return given()
                .header("accept", "application/json")
                .header("authorization", "Basic " + base64Credentials)
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }

    private static RequestSpecification baseRequestSpec(String authToken, Object payload) {
        return given()
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .body(payload);
    }



    private static RequestSpecification baseRequestSpec(String authToken) {
        return given()
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + authToken)
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON);
    }

    private static RequestSpecification baseRequestSpec(Map<String, Object> headers, Map<String, Object> pathParam, Map<String, Object> payload) {
        return given()
                .headers(headers)
                .pathParams(pathParam)
                .contentType(ContentType.JSON)
                .body(payload);
    }

    private static RequestSpecification baseRequestSpec(Map<String, Object> headers, Map<String, Object> payload) {
        return given()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(payload);
    }

    private static RequestSpecification baseRequestSpec(Map<String, Object> header, String quary, String quaryPara) {
        return given()
                .headers(header)
                .queryParam(quary, quaryPara)
                .contentType(ContentType.JSON);
    }

    public static Response postRequest(String authToken, Object payload, String endPoint) {
        RequestSpecification specs = baseRequestSpec(authToken,payload);
        Response response = specs
                .when()
                .post(endPoint);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    public static Response postRequest(Map<String,Object>headers ,Map<String, Object> payload, String endPoint) {
        RequestSpecification specs = baseRequestSpec(headers,payload);
        Response response = specs.body(payload)
                .when()
                .post(endPoint);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    public static Response getRequest(String authToken, String endPoint) {
        RequestSpecification specs = baseRequestSpec(authToken);
        Response response = specs
                .when()
                .get(endPoint);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    public static Response getRequest(Map<String, Object> header, String quary, String quaryParam, String endPoint) {
        RequestSpecification specs = baseRequestSpec(header, quary, quaryParam);
        Response response = specs
                .when()
                .get(endPoint);
        printLogReport(specs);
        printResponseLogInReport(response);
        return response;
    }

    protected static Response putRequest(Map<String, Object> headers, Map<String, Object> pathParam, Map<String, Object> payload, String endPoint) {
        RequestSpecification specs = baseRequestSpec(headers, pathParam, payload);
        Response response = specs
                .when()
                .put(endPoint);
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
