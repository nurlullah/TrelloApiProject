package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Board;
import utilities.ConfigReader;

import static BaseUrl.TrelloBaseUrl.*;
import static io.restassured.RestAssured.given;

public class BoardStepDefs {

    public static Board board;
    Response response;

    @When("user create a board")
    public void user_create_a_board() {
        boardSpec.pathParam("first","boards")
                .queryParam("name", "New Board")
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        response = given().spec(boardSpec).contentType(ContentType.JSON).when().post("/{first}");
        response.prettyPrint();
        board = response.as(Board.class);
        System.out.println(board.toString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }

    @When("user get the board")
    public void user_get_the_board() {
        boardSpec.pathParams("first","boards","second",board.getId())
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        response = given().spec(boardSpec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();
        board = response.as(Board.class);
        System.out.println(board.toString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }
    @When("user delete the board")
    public void user_delete_the_board() {
        boardSpec.pathParams("first","boards","second",board.getId())
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        response = given().spec(boardSpec).contentType(ContentType.JSON).when().delete("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

    }



}