package client;

public class DUL {

    private String type;
    private int number;
    private String fullName;

    public DUL(String type, int number, String fullName) {
        this.type = type;
        this.number = number;
        this.fullName = fullName;
    }

    public DUL() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

}
