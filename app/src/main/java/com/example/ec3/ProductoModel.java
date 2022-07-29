package com.example.ec3;

public class ProductoModel {

    private String productophoto;
    private String protuctoname;
    private String description;
    private String price;

    public ProductoModel(String productophoto, String protuctoname, String description, String price) {
        this.productophoto = productophoto;
        this.protuctoname = protuctoname;
        this.description = description;
        this.price = price;
    }

    public ProductoModel(String productophoto, String protuctoname) {
        this.productophoto = productophoto;
        this.protuctoname = protuctoname;
    }

    public String getProductophoto() {
        return productophoto;
    }

    public void setProductophoto(String productophoto) {
        this.productophoto = productophoto;
    }

    public String getProtuctoname() {
        return protuctoname;
    }

    public void setProtuctoname(String protuctoname) {
        this.protuctoname = protuctoname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
