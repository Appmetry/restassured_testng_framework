package api.payloads;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "loginUserData")
    public Object[][] getLoginUserData() {
        return new Object[][] {
                {"test234296", "Password@11"},

        };
    }

    @DataProvider(name = "userISBN")
    public Object[][] getUserIsbn() {
        return new Object[][] {
                {"59ab7c54-4236-458d-b2dc-9f155fafeaf4", "9781593277574"}
        };
    }

    @DataProvider(name = "bookUserData")
    public Object[][] getBookUserData() {
        return new Object[][] {
                {"Book A", "1", "This is Book A"},
                {"Book B", "2", "This is Book B"}
        };
    }

    @DataProvider(name = "addBookToCollectionData")
    public Object[][] getAddBookToCollectionData() {
        String requestBody = "{\n" +
                "  \"userId\": \"080ad264-cb82-4be7-a49f-c1d368b61d9c\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \"9781593277574\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        return new Object[][] { { requestBody } };
    }

}
