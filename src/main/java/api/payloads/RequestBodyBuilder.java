package api.payloads;

public class RequestBodyBuilder {
    public static String buildAddBookRequestBody(String userId, String isbnNo) {
        return "{\n" +
                "  \"userId\": \"" + userId + "\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"" + isbnNo + "\"\n" +
                "    }\n" +
                "  ]\n" + "}";
    }
}


