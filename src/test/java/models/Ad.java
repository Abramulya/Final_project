package models;

public class Ad {
    private String title;
    private String description;
    private int price;
    private String category;
    private String phone;

    // Constructors
    public Ad(String title, String description, int price, String category, String phone) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.phone = phone;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPrice() { return price; }
}