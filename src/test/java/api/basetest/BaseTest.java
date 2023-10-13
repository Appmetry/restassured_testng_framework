package api.basetest;

import api.endpoints.UserEndPoints;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static Map<String, String> createUser(String username, String password) {
        String requestBody = "{ \"userName\": \"" + username + "\", \"password\": \"" + password + "\" }";
        Response response = UserEndPoints.createUser(requestBody);
        Assert.assertEquals(response.getStatusCode(), 201);
        String userId = response.jsonPath().get("userID");
        String userName = response.jsonPath().get("username");
        Response generateTokenRes = UserEndPoints.generateToken(requestBody);
        Assert.assertEquals(generateTokenRes.getStatusCode(), 200);
        Assert.assertEquals(generateTokenRes.jsonPath().get("status"), "Success");
        String authToken = generateTokenRes.jsonPath().get("token");
        Map<String, String> userMap = new HashMap<>();
        userMap.put("username", userName);
        userMap.put("userId", userId);
        userMap.put("authToken", authToken);
        return userMap;

    }


}

