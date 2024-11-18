package com.example.pjatkpasswordmanagerv3;

public class User {

    private int id;
    private String name;
    private String password;
    private String category;
    private String page;

    public User(int id, String name, String password, String category, String page) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.category = category;
        this.page = page;
    }


    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPage() {
        return page;
    }

    public String getPassword() {
        return password;
    }

    public String getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
