package hooks;

import io.cucumber.java.Before;

import static BaseUrl.TrelloBaseUrl.*;

public class Hooks {
    @Before(value = "@trello_api")
    public void beforeTrello_Api (){
        boardSetUp();
        listSetUp();
        cardSetUp();
    }

}