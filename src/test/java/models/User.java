package models;

public class User {
    private String id;
    private String email;
    private String password;
    private String username;
    private String token;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    // Getters and Setters
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setToken(String token) { this.token = token; }
}