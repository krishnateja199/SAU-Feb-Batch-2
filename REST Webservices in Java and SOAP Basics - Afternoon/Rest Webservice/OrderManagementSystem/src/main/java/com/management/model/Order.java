package com.management.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    private int id;
    private long totalOrderCost, customerPhone;
    private String customerName, deliveryAddress;
    private HashMap<Integer, OrderItem> itemsList = new HashMap<>();

    public boolean addItem(OrderItem item){
        item.setTotalCost(item.getUnits() * item.getItem().getCost());
        itemsList.put(item.getId(), item);
        this.totalOrderCost += item.getTotalCost();
        return true;
    }

    public boolean isValid(){
        if(this.customerName != null && this.customerName != "" &&
                String.valueOf(this.customerPhone).length() == 10 &&
                this.deliveryAddress != null && this.deliveryAddress != ""){
            return true;
        }
        return false;
    }

    public List<OrderItem> getItemsList() {
        List<OrderItem> items = new ArrayList<>();
        for(Map.Entry<Integer, OrderItem> entry : itemsList.entrySet()){
            items.add(entry.getValue());
        }
        return items;
    }

    public boolean removeItem(int itemId){
        if(itemsList.containsKey(itemId)){
            this.totalOrderCost -= itemsList.get(itemId).getTotalCost();
            itemsList.remove(itemId);
            return true;
        }
        return false;
    }

    public OrderItem updateOrderItem(int itemId, OrderItem item){
        if(itemsList.containsKey(itemId)) {
            this.totalOrderCost -= itemsList.get(itemId).getTotalCost();
            int id = itemsList.get(itemId).getId();
            item.setId(id);
            item.setTotalCost(item.getUnits() * item.getItem().getCost());
            itemsList.put(itemId, item);
            this.totalOrderCost += item.getTotalCost();
            return item;
        }
        return null;
    }

    public long getTotalOrderCost() {
        return totalOrderCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getcustomerPhone() {
        return customerPhone;
    }

    public void setcustomerPhone(long customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
