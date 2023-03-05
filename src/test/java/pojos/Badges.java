package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Badges {

    /*
    {
        "attachmentsByType": {
            "trello": {
                "board": 0,
                "card": 0
            }
        },
        "location": false,
        "votes": 0,
        "viewingMemberVoted": false,
        "subscribed": false,
        "fogbugz": "",
        "checkItems": 0,
        "checkItemsChecked": 0,
        "checkItemsEarliestDue": null,
        "comments": 0,
        "attachments": 0,
        "description":
     */

    private AttachmentsByType attachmentsByType;
    private boolean location;
    private int votes;
    private boolean viewingMemberVoted;
    private boolean subscribed;
    private String fogbugz;
    private int checkItems;
    private int checkItemsChecked;
    private int checkItemsEarliestDue;
    private int comments ;
    private int attachments;
    private boolean description;
    private String due;



    public Badges(){

    }

    public Badges(AttachmentsByType att){
        super();
        this.attachmentsByType=att;
    }

    public AttachmentsByType getAttachmentsByType() {
        return attachmentsByType;
    }

    public void setAttachmentsByType(AttachmentsByType attachmentsByType) {
        this.attachmentsByType = attachmentsByType;
    }

    public boolean isLocation() {
        return location;
    }

    public void setLocation(boolean location) {
        this.location = location;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public boolean isViewingMemberVoted() {
        return viewingMemberVoted;
    }

    public void setViewingMemberVoted(boolean viewingMemberVoted) {
        this.viewingMemberVoted = viewingMemberVoted;
    }

    public boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getFogbugz() {
        return fogbugz;
    }

    public void setFogbugz(String fogbugz) {
        this.fogbugz = fogbugz;
    }

    public int getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(int checkItemsChecked) {
        this.checkItems = checkItemsChecked;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getAttachments() {
        return attachments;
    }

    public void setAttachments(int attachments) {
        this.attachments = attachments;
    }

    public boolean isDescription() {
        return description;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public int getCheckItemsChecked() {
        return checkItemsChecked;
    }

    public void setCheckItemsChecked(int checkItemsChecked) {
        this.checkItemsChecked = checkItemsChecked;
    }

    public int getCheckItemsEarliestDue() {
        return checkItemsEarliestDue;
    }

    public void setCheckItemsEarliestDue(int checkItemsEarliestDue) {
        this.checkItemsEarliestDue = checkItemsEarliestDue;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

}