package api.endpoints;

public class Routes {
    private static String baseUrl = "https://bookstore.toolsqa.com";
    private static String accountPath = "/Account/v1";
    private static String bookStorePath = "/BookStore/v1";
    public static String accountModule = baseUrl + accountPath;
    public static String bookStoreModule = baseUrl + bookStorePath;

    //ACCOUNT SECTION
    public static String createUser = accountModule + "/User";
    public static String validateUser = accountModule + "/Authorized";
    public static String generatToken = accountModule + "/GenerateToken";
    public static String deleteUser = createUser + "/" + "{uuid}";

    public static String getUser = createUser + "/" + "{uuid}";

    // BOOKSTORE SECTION
    public static String books = bookStoreModule + "/Books";
    public static String book = bookStoreModule + "/Book";
    public static String updateBookDetails = books + "/" + "{ISBN}";
    public static String getBook = bookStoreModule + "/Book";


}
