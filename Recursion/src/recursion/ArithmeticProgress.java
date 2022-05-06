/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;


/**
 *
 * @author Nghia
 */
public class ArithmeticProgress {
    
    public static double ap (int n, double a, double d) {
        if (n==1) return a;
        return ap(n-1, a, d) + d;
    }
    
    public static void main(String[] args) {
        int n = 6;
        double a[] = {1.5, 3.5, 5.5, 7.5, 9.5, 11.5};
        int d = 2;
        System.out.println(ap(n,a[0],d));
    }
}
