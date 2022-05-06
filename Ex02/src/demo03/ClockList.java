/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo03;

import demo02.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Nghia
 */
public class ClockList extends TreeSet<Clock> {

    Scanner sc = new Scanner(System.in);

    public ClockList() {
        super(Clock.comparator);
    }

    public Clock search(String ID) {
        return this.ceiling(new Clock(ID));
    }

    public void output() {
        Iterator it = this.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
