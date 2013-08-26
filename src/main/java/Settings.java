package main.java;

public class Settings {

    private String name;

    private int id;

    private String password;

    public Settings(String name, String password, int id) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public Settings(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}