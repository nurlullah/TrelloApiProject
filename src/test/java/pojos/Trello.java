package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trello {

    private int board;
    private int card;

    public Trello(){}
    public Trello(int board, int card){
        super();
        this.board=board;
        this.card=card;
    }

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Trello{" +
                "board=" + board +
                ", card=" + card +
                '}';
    }
}