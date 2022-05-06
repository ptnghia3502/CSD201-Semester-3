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
public class GeometricProgress {
    
    public static double gp (int n, double a, double q) {
        if (n==1) return a;
        return gp(n-1, a, q) * q;
    }
    
    public static void main(String[] args) {
        int n = 6;
        double a[] = {1.5, 3, 6, 12, 24, 48};
        int q = 2;
        System.out.println(gp(n,a[0],q));
    }
}
