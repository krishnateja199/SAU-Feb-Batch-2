package com.management.model;

public class Item {
    private int id;
    private long cost;
    private String name, category;

    public boolean isValid(){
        if(this.cost != 0 && this.name != "" && this.name != null && this.category != null && this.category != ""){
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
