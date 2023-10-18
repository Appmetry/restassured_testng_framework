package api.endpoints;

import api.utils.BaseSpecsUtils;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import report.ExtentReportManager;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookStoreEndPoints extends BaseSpecsUtils {
    public static Response getAllBooks(String authToken) {
        return getRequest(authToken, Routes.books);
    }

    public static Response addBook(String authToken, Object payload) {
        return BaseSpecsUtils.postRequest(authToken, payload, Routes.books);
    }

    public static Response getBookData(Map<String,Object>headers, String isbn) {
        return BaseSpecsUtils.getRequest(headers,"ISBN",isbn,Routes.getBook);
    }

    public static Response updateBook(Map<String,Object> headers,Map<String,Object> pathParams,Map<String,Object> payload) {
        return BaseSpecsUtils.putRequest(headers,pathParams,payload,Routes.updateBookDetails);
    }


}


