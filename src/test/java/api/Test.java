package api;

import api.utils.RandomDataGenerator;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        RandomDataGenerator gen = new RandomDataGenerator();


        String userID ;
        String userName = gen.generateRandomUsername();
        String password = gen.generateRandomPassword();
        String baseUrl = "https://bookstore.toolsqa.com";

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();


        //Step - 1
        //Test will start from generating Token for Authorization
        request.header("Content-Type", "application/json");
         Response responseUser = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}").post("/Account/v1/User");

          userID = responseUser.jsonPath().get("userID");
        System.out.println(userID);
        request.header("Content-Type", "application/json");
        Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                .post("/Account/v1/GenerateToken");

        Assert.assertEquals(response.getStatusCode(), 200);

        String jsonString = response.asString();
        Assert.assertTrue(jsonString.contains("token"));


        String token = JsonPath.from(jsonString).get("token");


        System.out.println(token);
        response = request.get("/BookStore/v1/Books");

        Assert.assertEquals(response.getStatusCode(), 200);

        jsonString = response.asString();
        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);


        String bookId = books.get(0).get("isbn");


        // Add a book - with Auth
        //The token we had saved in the variable before from response
        //we will be passing in the headers for each of the succeeding request
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

       Response responseBook = request.body("{ \"userId\": \"" + userID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + bookId + "\" } ]}")
                .post("/BookStore/v1/Books");

        Assert.assertEquals( 201, responseBook.getStatusCode());
        System.out.println(responseBook.getBody().asString());
    }
}