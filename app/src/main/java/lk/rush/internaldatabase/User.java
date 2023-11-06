package lk.rush.internaldatabase;

public class User {

    private int id;
    private String name;
    private String address;
    private String email;

    public User() {
    }

    public User(String name, String email, String address) {
        this.email = email;
        this.address = address;
        this.name= name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
