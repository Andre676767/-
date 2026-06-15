package com.example.demo6;

public class CartItem {
    private Furniture furniture;
    private int quantity;

    public CartItem(Furniture furniture, int quantity) {
        this.furniture = furniture;
        this.quantity = quantity;
    }

    public Furniture getFurniture() { return furniture; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalPrice() {
        return furniture.getPrice() * quantity;
    }

    public String getFormattedTotal() {
        return String.format("%,.0f ₽", getTotalPrice()).replace(",", " ");
    }
}