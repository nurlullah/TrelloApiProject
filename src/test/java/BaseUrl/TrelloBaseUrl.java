package BaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class TrelloBaseUrl {

    public static RequestSpecification boardSpec;
    public static RequestSpecification listSpec;
    public static RequestSpecification cardSpec;

    public static void boardSetUp(){
        boardSpec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("board_url")).build();
    }
    public static void listSetUp(){
        listSpec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("lists_url")).build();
    }

    public static void cardSetUp(){
        cardSpec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("cards_url")).build();
    }

}