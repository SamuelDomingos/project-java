package projectJava.models;

public class User {

    private int id;
    private String name;
    private String login;
    private String password;
    private int active;

    public User(int id, String name, String login, String password, int active) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.active = active;
    }

    public User(String name, String login, String password, int active) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.active = active;
    }

    public int getUserId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(int active) {
        this.active = active;
    }
}