package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Board;
import pojos.BoardList;
import pojos.Card;
import utilities.ConfigReader;
import static baseurl.TrelloBaseUrl.spec;
import static io.restassured.RestAssured.given;

public class TrelloApiTest {
    public Board board;
    public BoardList boardList;

    public Card card1;
    public Card card2;
    @When("user create a board")
    public void user_create_a_board() {
        spec.pathParam("first","boards")
                .queryParam("name", "New Board")
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        Response response = given().spec(spec).contentType(ContentType.JSON).when().post("/{first}");
        response.prettyPrint();
        board = response.as(Board.class);
        System.out.println(board.toString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

    }
    @And("user create two cart on board")
    public void user_create_two_cart_on_board() {
        //List Oluşturma
        //'https://api.trello.com/1/boards/{id}/lists?name={name}&key=APIKey&token=APIToken' \
        spec.pathParams("first","boards","second",board.getId(),"third","lists")
                .queryParam("name", "First List")
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        Response response = given().spec(spec).contentType(ContentType.JSON).when().post("/{first}/{second}/{third}");
        response.prettyPrint();
        boardList = response.as(BoardList.class);
        System.out.println(boardList.toString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


    }
    @And("user update one of the cart randomly")
    public void user_update_one_of_the_cart_randomly() {
        //Card Oluşturma

        //'https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken'
        spec.pathParam("first","cards")
                .queryParam("idList", boardList.getId())
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));

        Response response1 = given().spec(spec).contentType(ContentType.JSON).when().post("/{first}");
        System.out.println(boardList.getId());
        response1.prettyPrint();

        card1 = response1.as(Card.class);
        System.out.println(card1.toString());
        response1.then().assertThat().statusCode(200).contentType(ContentType.JSON);

//        Response response2 = given().spec(spec).contentType(ContentType.JSON).when().post("/{first}");
//        response2.prettyPrint();
//        card2 = response2.as(Card.class);
//        System.out.println(card2.toString());
//        response2.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }
    @And("user delete all carts")
    public void user_delete_all_carts() {

    }
    @And("user delete the board")
    public void user_delete_the_board() {

    }

}
