/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bst;

/**
 *
 * @author Nghia
 */
public class DSWIntBstTreeDemo {
    public static void main(String[] args) {
        DSWIntBstTree tree = new DSWIntBstTree();
        tree.add(1,2,20,10,24,11,25,12,26,13,27,14,18);
        System.out.println("\nInitial tree:\n");
        tree.printAlign();
        tree.DSW_Balance();
        System.out.println("\nBalance tree:\n");
        tree.printAlign();
    }
}
