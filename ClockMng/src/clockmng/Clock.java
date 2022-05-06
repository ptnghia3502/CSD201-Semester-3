/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

import java.util.Scanner;
import tools.NghiaUtils;

/**
 *
 * @author Nghia
 */
public class Clock {
    String id ="", manufact="";
    int price = 0, guarantee=0;
    Scanner sc = new Scanner(System.in);

    public Clock() {
    }

    public Clock(String id) {
        this.id = id;
    }
    
    public Clock(String id, String manufact, int price, int guarantee) {
        this.id = id;
        this.manufact = manufact;
        this.price = price;
        this.guarantee = guarantee;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMannufact() {
        return manufact;
    }

    public void setMannufact(String mannufact) {
        this.manufact = mannufact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }    
    
    public String toString() {
        return id + ", " + manufact + ", " + price + ", " + guarantee;
    }
    
    public void input() {
        this.id = NghiaUtils.getString("Input id: ");
        this.manufact = NghiaUtils.getString("Input manufact: ");
        this.price = NghiaUtils.getInt("Intput price: ");
        this.guarantee = NghiaUtils.getInt("Input guarantee: ");
    }

    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Clock)obj).id);
    }
    
    
}
