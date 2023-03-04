package baseurl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class TrelloBaseUrl {

    public static RequestSpecification spec;
    public static void trelloSetUp(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("trello_url")).build();
    }

}