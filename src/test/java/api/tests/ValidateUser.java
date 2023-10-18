package api.tests;

import api.basetest.BaseTest;
import api.endpoints.UserEndPoints;
import api.payloads.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateUser {
    String userId;
    String userName;
    String authToken;

    @Test(dataProvider = "loginUserData", dataProviderClass = DataProviders.class ,priority = 0)
    public void createUserTest(String username,String password){
        String requestBody = "{ \"userName\": \"" + username + "\", \"password\": \"" + password + "\" }";
        Response response = UserEndPoints.createUser(requestBody);
        Assert.assertEquals(response.getStatusCode(),201);
        userId = response.jsonPath().get("userID");
        userName = response.jsonPath().get("username");
        //System.out.println(response.getBody().asString());

    }

    @Test(dataProvider = "loginUserData",dataProviderClass = DataProviders.class,priority = 1)
    public void generateToken(String username,String password){
        String requestBody = "{ \"userName\": \"" + username + "\", \"password\": \"" + password + "\" }";
        Response response = UserEndPoints.generateToken(requestBody);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().get("status"),"Success");
        authToken = response.jsonPath().get("token");
        // System.out.println(response.getBody().asString());

    }

    @Test(priority = 2)
    public void validateUserInfo(){
        Response response=UserEndPoints.getUserInfo(authToken,userId);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.jsonPath().get("username"),userName);
        // System.out.println(response.getBody().asString());
    }

    @Test(priority = 3)
    public void deleteUser(){
        //  System.out.println("AuthToken  --> " + authToken + "UserID ----> " + userId);
        Response response = UserEndPoints.deleteUser(authToken,userId);
        Assert.assertEquals(response.getStatusCode(),200);
       /* System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());*/
    }

}
