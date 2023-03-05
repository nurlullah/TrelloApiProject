package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.BoardList;
import utilities.ConfigReader;

import static BaseUrl.TrelloBaseUrl.*;
import static io.restassured.RestAssured.given;
import static stepdefinitions.BoardStepDefs.board;


public class BoardListStepDefs {


    public static BoardList boardList;
    Response response;

    @When("user create a list on the board")
    public void user_create_a_list_on_the_board() {
        //List Oluşturma
        //'https://api.trello.com/1/boards/{id}/lists?name={name}&key=APIKey&token=APIToken' \

        boardSpec.pathParams("first","boards","second",board.getId(),"third","lists")
                .queryParam("name", "First List")
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        response = given().spec(boardSpec).contentType(ContentType.JSON).when().post("/{first}/{second}/{third}");
        response.prettyPrint();
        boardList = response.as(BoardList.class);
        System.out.println(boardList.toString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

    }
    @When("user get the list")
    public void user_get_the_list() {
        listSpec.pathParams("first","lists","second",boardList.getId())
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));
        response = given().spec(listSpec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();
        boardList = response.as(BoardList.class);
        System.out.println(boardList.toString());
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }

}