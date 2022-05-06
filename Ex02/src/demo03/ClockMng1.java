/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo03;

import java.util.Iterator;

/**
 *
 * @author Nghia
 */
public class ClockMng1 {

    public static void main(String[] args) {
        I_Menu menu = new Menu();
        menu.addItem("1. Add new clock");
        menu.addItem("2. Update clock by ID");
        menu.addItem("3. Delete clock by ID");
        menu.addItem("4. Search clock");
        menu.addItem("5. Show list of clocks");
        menu.addItem("6. Quit");

        int choice;
        boolean cont = false;
        boolean check = false;
        ClockList list = new ClockList();
        Clock clock = new Clock();
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    Clock clk = new Clock();
                    clk.input();
                    list.add(clk);
                    System.out.println("Add Succesffully");
                    System.out.println("\n");
                    break;

                case 2:
                    String id = tools.NghiaUtils.getString("Input clock ID you want to update: ");
                    Clock dk = list.search(id);
                    if (dk == null || !dk.getID().equals(id)) {
                        System.out.println("Clock " + id + " does not exist\n");
                    } else {
                        list.remove(dk);
                        Clock nclk = new Clock();
                        nclk.edit();
                        list.add(nclk);
                        check = true;
                        if (check == true) {
                            System.out.println("Update successfully!!!\n");
                        } else {
                            System.out.println("Update fail!\n");
                        }
                    }
                    break;

                case 3:
                    String iddel = tools.NghiaUtils.getString("Input clock ID you want to delete: ");
                    Clock mk = list.search(iddel);
                    if (mk == null || !mk.getID().equals(iddel)) {
                        System.out.println("Clock " + iddel + " does not exist\n");
                    } else {
                        list.remove(mk);
                        check = true;
                        if (check == true) {
                            System.out.println("Removed successfully!!!\n");
                        } else {
                            System.out.println("Removed fail!\n");
                        }
                    }
                    break;

                case 4:
                    String idsearch = tools.NghiaUtils.getString("Input clock ID you want to search: ");
                    Clock ck = list.search(idsearch);
                    if (ck == null || !ck.getID().equals(idsearch)) {
                        System.out.println("Clock " + idsearch + " does not exist");
                    } else {
                        System.out.println("Found: " + ck);
                    }
                    System.out.println("\n");
                    break;

                case 5:
                    list.output();
                    System.out.println("\n");
                    break;

                case 6:
                    cont = menu.confirmYesNo("Do you want to quit?(Y/N): ");
                    break;
            }
        } while (!cont);
    }
}
