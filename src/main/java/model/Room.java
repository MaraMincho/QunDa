package model;

public class Room {
    String index;
    String head;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    String body;

    public Room(){
        this.body = body;
        this.head = head;
        this.index = index;
    }

}
