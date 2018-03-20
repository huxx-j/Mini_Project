package com.javaproject.miniproject;

public class AddressBook {
    private String name;
    private String hp;
    private String company;

    public AddressBook() {
    }

    public AddressBook(String name, String hp, String company) {
        this.name = name;
        this.hp = hp;
        this.company = company;
    }

    public String writeInfo() {
        return name + "," + hp +"," + company + "\n";
    }

    @Override
    public String toString() {
        return name + " " + hp + "\t" + company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
