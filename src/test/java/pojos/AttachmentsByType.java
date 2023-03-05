package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentsByType {
    private Trello trello;

    public AttachmentsByType(){

    }

    public AttachmentsByType(Trello t){
        super();
        this.trello=t;
    }

    public Trello getTrello() {
        return trello;
    }

    public void setTrello(Trello trello) {
        this.trello = trello;
    }

    @Override
    public String toString() {
        return "AttachmentsByType{" +
                "trello=" + trello +
                '}';
    }
}