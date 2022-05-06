/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo03;
import java.util.Scanner;
import java.util.Comparator;

/**
 *
 * @author Nghia
 */
public class Clock {
    String ID="";
    String manufacturer="";
    int price = 0;
    Scanner sc = new Scanner(System.in);
    public static Comparator comparator = new Comparator() {
        @Override
        public int compare(Object t, Object t1) {
            return ((Clock)t).ID.compareTo(((Clock)t1).ID);
        }
    };

    public Clock() {
    }
    
    public Clock(String ID) {
        this.ID = ID;
    }
    
    public Clock(String ID, String manu, int p) {
        this.ID = ID;
        this.manufacturer = manu;
        this.price = p;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public static Comparator getComparator() {
        return comparator;
    }

    public static void setComparator(Comparator comparator) {
        Clock.comparator = comparator;
    }

    @Override
    public String toString() {
        return ID + ", " + manufacturer + ", " + price;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.ID.equalsIgnoreCase(((Clock) obj).getID()); //so sanh id
    }
    
    public String print() {
        return (this.getID() + ", " + this.getManufacturer() + ", "
                + this.getPrice() + ", ");
    }
    
    public void input() {
        this.ID = tools.NghiaUtils.getString("Input clock ID: ");
        this.manufacturer = tools.NghiaUtils.getString("Input manufacturer: ");
        this.price = tools.NghiaUtils.getInt("Input clock price: ", 0, 999999999);
    }
    
    public void edit() {
        this.ID = tools.NghiaUtils.getString("Input new clock ID: ");
        this.manufacturer = tools.NghiaUtils.getString("Input new manufactuere: ");
        this.price = tools.NghiaUtils.getInt("Input new clock price: ");
    }
}
