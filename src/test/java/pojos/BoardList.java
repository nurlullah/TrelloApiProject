package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoardList {
    private String id;
    private String name;
    public BoardList(){}

    public BoardList (String id, String name){
        super();
        this.id= id;
        this.name = name;

    }
    public BoardList (String name){
        super();
        this.name = name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BoardList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}