package com.example.materialpractice.recyclerviewpractice;

public class Product {
    private int id;
    private String productName;
    private String retailPrice;
    private int facing;
    private int cases;
    private int isAvailable;

    public Product(int id, String productName, String retailPrice, int facing, int cases, int isAvailable) {
        this.id = id;
        this.productName = productName;
        this.retailPrice = retailPrice;
        this.facing = facing;
        this.cases = cases;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getFacing() {
        return facing;
    }

    public void setFacing(int facing) {
        this.facing = facing;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(int isAvailable) {
        this.isAvailable = isAvailable;
    }
}
