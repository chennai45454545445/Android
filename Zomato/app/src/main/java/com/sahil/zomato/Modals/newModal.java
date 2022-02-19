package com.sahil.zomato.Modals;

public class newModal {
    int Image;
    String Name,Price,Description;

    public newModal(int image , String name , String price , String description ) {
        Image = image;
        Name = name;
        Price = price;
        Description = description;

    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
