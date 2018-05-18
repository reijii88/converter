package client;

import person.Person;

import java.util.UUID;

public class Client extends Person{

    private String fullName;
    private DUL dul;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public DUL getDul() {
        return dul;
    }

    public void setDul(DUL dul) {
        this.dul = dul;
    }

    public UUID getId() {
        return super.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
