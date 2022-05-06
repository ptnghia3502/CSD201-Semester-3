/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockmng;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Nghia
 */
public class ClockList extends LinkedList<Clock> {

    Scanner sc = new Scanner(System.in);

    public void addClock() {
        Clock clk = new Clock();
        clk.input();
        if (this.add(clk) == true) {
            System.out.println("Add Successfully.");
        } else {
            System.out.println("Added failed!");
        }
        System.out.println("\n");
    }

    private int search(String id) {
        return this.indexOf(new Clock(id));
    }

    public void removeClock() {
        String id;
        System.out.print("Input clock id which will be removed:");
        id = sc.nextLine();
        int pos = search(id);
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            this.remove(pos);
            System.out.println("Clock" + id + "was deleted.");
        }
        System.out.println("\n");
    }

    public void updateClock() {
        String id;
        System.out.print("Input clock id which will be updated:");
        id = sc.nextLine();
        int pos = search(id);
        if (pos < 0) {
            System.out.println("Not found!");
        } else {
            this.get(pos).input();
            System.out.println("Clock" + id + "was updated.");
        }
        System.out.println("\n");
    }

    public void print() {
        for (Clock clk : this) {
            System.out.println(clk);
        }
        System.out.println("\n");
    }

    public void printPrice() {
        int price1, price2;
        System.out.println("Input price range.");
        System.out.print("Price 1:");
        price1 = Integer.parseInt(sc.nextLine());
        System.out.print("Price 2:");
        price2 = Integer.parseInt(sc.nextLine());
        if (price1 > price2) {
            int t = price1;
            price1 = price2;
            price2 = t;
        }
        for (Clock clk : this) {
            int price = clk.getPrice();
            if (price >= price1 && price <= price2) {
                System.out.println(clk);
            }
        }
        System.out.println("\n");
    }
}
