package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Card {
    private String id;
    private String idList;
    private String name;
    private Badges badges;

    public Card(){}
    public Card(String id, String idList, String name, Badges fields){
        super();
        this.id =id;
        this.idList = idList;
        this.name= name;
        this.badges=fields;
    }
    public Card(String id, String idList,Badges fields){
        super();
        this.id =id;
        this.idList = idList;
        this.badges=fields;


    }
    public Card(String idList, Badges fields){
        super();
        this.idList = idList;
        this.badges= fields;
    }

    public Card(String idList){
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

    public Badges getBadges() {
        return badges;
    }

    public void setBadges(Badges fields) {
        this.badges = fields;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", idList='" + idList + '\'' +
                ", name='" + name + '\'' +
                ", badges=" + badges +
                '}';
    }
}
