package model;

public class Professor {
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    String id;
    String pw;
    String Name;

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    String Position;


    public Professor() {
        this.id = id;
        this.Name = Name;
        this.pw = pw;
        this.Position = Position;
    }

}
