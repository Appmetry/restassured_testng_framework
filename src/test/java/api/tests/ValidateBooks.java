package api.tests;

import api.basetest.BaseTest;
import api.endpoints.BookStoreEndPoints;
import api.payloads.DataProviders;
import api.payloads.RequestBodyBuilder;
import api.utils.RandomDataGenerator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;


public class ValidateBooks {
    String authToken;
    String userName;
    String userId;
    String bookId;
    RandomDataGenerator data = new RandomDataGenerator();
    private String username = data.generateRandomUsername();
    private String password = data.generateRandomPassword();

    @BeforeClass
    public void createUserAndAuthorize() {
        System.out.println(username + "   " + password);
        Map<String, String> userMap = BaseTest.createUser(userName, password);
        authToken = userMap.get("authToken");
        userName = userMap.get("username");
        userId = userMap.get("userId");
    }


    @Test(priority = 0)
    public void validateAllBooks() {
        Response response = BookStoreEndPoints.getAllBooks(authToken);
        Assert.assertEquals(response.getStatusCode(), 200);
        String jsonString = response.asString();

        List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
        Assert.assertTrue(books.size() > 0);
        bookId = books.get(0).get("isbn");
        List<Map<String, Object>> bookList = new ArrayList<>();
        JsonPath jsonPath = response.getBody().jsonPath();

     //   List<Map<String, Object>> books = jsonPath.getList("books");
        System.out.println("JSON MAP ----> "+jsonPath.getMap("Books"));

        System.out.println("*************************");
        System.out.println(books);
    }

    @Test(priority = 1)
    public void validateAddBook() {
        System.out.println(userId + "    auth token   " + authToken);
        String requestBody = RequestBodyBuilder.buildAddBookRequestBody(userId, bookId);

        Response response = BookStoreEndPoints.addBook(authToken, requestBody);
        System.out.println(response.getStatusCode() + "  " + response.getHeaders());
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("books[0].isbn"), bookId);

    }

    @Test(priority = 2)
    public void validateGetBook() {
        Response response = BookStoreEndPoints.getBookData(authToken, bookId);
        Assert.assertEquals(response.getStatusCode(), 200);
       // System.out.println(response.getBody().asString());
      /*  String bookId = response.getBody().jsonPath().get("isbn");
        String title = response.getBody().jsonPath().get("title");
        String subTitle = response.getBody().jsonPath().get("subTitle");
        String author = response.getBody().jsonPath().get("author");
        String website = response.getBody().jsonPath().get("website");*/

        String[] fields = {"isbn", "title", "subTitle", "author", "website"};
        Map<String,String> resposeMap = new LinkedHashMap<>();
        for (String field : fields) {
            String value = response.getBody().jsonPath().get(field);
            resposeMap.put(field, value);
        }

      //  System.out.println(resposeMap);




    }

    @Test(dataProvider = "userISBN", dataProviderClass = DataProviders.class)
    public void updateBook(String userID, String ISBN) {
        String requestBody = "{ \"userId\": \"" + userID + "\", \"isbn\": \"" + ISBN + "\" }";
        Response response = BookStoreEndPoints.updateBook(authToken, "9781593277574", requestBody);
    }


}
