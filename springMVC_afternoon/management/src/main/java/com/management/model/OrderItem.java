package com.management.model;

public class OrderItem {
    private int id, units;
    private Item item;
    private long totalCost;

    public boolean isValid(){
        if(this.item.isValid()){
            if(this.units != 0){
                return true;
            }
        }
        return false;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost += totalCost;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}