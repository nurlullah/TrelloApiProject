package stepdefinitions;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Card;
import utilities.ConfigReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static BaseUrl.TrelloBaseUrl.*;
import static io.restassured.RestAssured.given;
import static stepdefinitions.BoardListStepDefs.boardList;

public class CardStepDefs {

    public static Card card;
    Response response;
    public List<Card> cardList = new ArrayList<>();

    @When("user create a card on the board list")
    public void user_create_a_card_on_the_board_list() {
        //Card Oluşturma
        //'https://api.trello.com/1/cards?idList=5abbe4b7ddc1b351ef961414&key=APIKey&token=APIToken'

        cardSpec.pathParams("first","1","second","cards")
                .queryParam("idList", boardList.getId())
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));

        response = given().spec(cardSpec).contentType(ContentType.JSON).when().post("/{first}/{second}");
        response.prettyPrint();
        card = response.as(Card.class);
        cardList.add(card);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);


        cardSpec.pathParams("first","1","second","cards")
                .queryParam("idList", boardList.getId())
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));

        response = given().spec(cardSpec).contentType(ContentType.JSON).when().post("/{first}/{second}");
        response.prettyPrint();
        card = response.as(Card.class);
        cardList.add(card);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }
    @When("user get a random card")
    public void user_get_a_random_card() {
        Random rand = new Random();
        int index = rand.nextInt(cardList.size()-1);
        card = cardList.get(index);
    }
    @When("user update the card")
    public void user_update_the_card() {
        cardSpec.pathParams("first","1","second","cards","third",card.getId())
                .queryParam("name", "kart guncelleme")
                .queryParam("key", ConfigReader.getProperty("KEY"))
                .queryParam("token",ConfigReader.getProperty("TOKEN"));

        response = given().spec(cardSpec).contentType(ContentType.JSON).when().put("/{first}/{second}/{third}");
        response.prettyPrint();
        card = response.as(Card.class);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

    }
    @When("user delete all cards")
    public void user_delete_all_cards() {
        for (Card c: cardList) {
            cardSpec.pathParams("first","1","second","cards","third",c.getId())
                    .queryParam("key", ConfigReader.getProperty("KEY"))
                    .queryParam("token",ConfigReader.getProperty("TOKEN"));

            response = given().spec(cardSpec).contentType(ContentType.JSON).when().delete("/{first}/{second}/{third}");
            response.prettyPrint();
            response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        }
    }

}