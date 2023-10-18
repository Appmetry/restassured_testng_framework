package api.payloads;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapPayload {
    private String authToken;
    private  String userId;
    private  String bookId;

    public MapPayload(String authToken,String userId,String bookId) {
        this.authToken = authToken;
        this.userId = userId;
        this.bookId =bookId;
    }

    public Map<String, Object> getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Authorization","Bearer "+ authToken);
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public static Map<String, Object> getHeader() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("Content-Type", "application/json");
        return headers;
    }


    public Map<String, Object> getPathParams() {
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("ISBN", bookId);
        return pathParams;
    }

    public Map<String, Object> getPayload() {
        Map<String, Object> payload = new LinkedHashMap<>();
        payload.put("userId", userId);
        payload.put("isbn", "9781449325862");
        return payload;
    }
}

/*
{
  "userId": "10d2e543-3a1b-4f56-803d-ddf9499ef880",
  "isbn": "9781449331818"
}
 */