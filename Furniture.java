package com.example.demo6;

public class Furniture {
    private String name;
    private String category;
    private double price; // Цена в рублях
    private String description;
    private int stock;

    public Furniture(String name, String category, double price, String description, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public String getFormattedPrice() {
        return String.format("%,.0f ₽", price).replace(",", " ");
    }

    public boolean isAvailable() { return stock > 0; }

    @Override
    public String toString() {
        return String.format("%s - %s (в наличии: %d)",
                name, getFormattedPrice(), stock);
    }
}