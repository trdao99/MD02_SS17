package bai8;

public class Product {
    private int id;
    private String name;
    private String brand;
    private String description;
    private float price;

    public Product() {
    }

    public Product(int id, String name, String brand, String description, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("ID : %d | Name : %s | Brand : %s | Description : %s | Price : %f \n", id, name, brand, description, price);
    }
}
