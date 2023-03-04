package pojos;

public class Card {
    private String id;
    private String idList;
    private String name;

    public Card(){}
    public Card(String id, String idList, String name){
        super();
        this.id =id;
        this.idList = idList;
        this.name= name;
    }
    public Card(String id, String idList){
        super();
        this.id =id;
        this.idList = idList;

    }
    public Card( String idList){
        super();

        this.idList = idList;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
