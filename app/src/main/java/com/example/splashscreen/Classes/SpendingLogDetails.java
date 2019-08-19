package com.example.splashscreen.Classes;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class SpendingLogDetails {
    String date;
    String spentMoney;
    String itemBudget;
    String storeName;
    int tick;
    int cross;

    public SpendingLogDetails(String date, String spentMoney, String itemBudget, String storeName, int tick, int cross) {
        this.date = date;
        this.spentMoney = spentMoney;
        this.itemBudget = itemBudget;
        this.storeName = storeName;
        this.tick = tick;
        this.cross = cross;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(String spentMoney) {
        this.spentMoney = spentMoney;
    }

    public String getItemBudget() {
        return itemBudget;
    }

    public void setItemBudget(String itemBudget) {
        this.itemBudget = itemBudget;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }

    public int getCross() {
        return cross;
    }

    public void setCross(int cross) {
        this.cross = cross;
    }
}
