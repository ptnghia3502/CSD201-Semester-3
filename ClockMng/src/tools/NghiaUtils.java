/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author Nghia
 */
public class NghiaUtils {
    public static String getString(String welcome) {
        String result = "";
        boolean check = true;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    public static int getInt(String welcome) {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        boolean cont = true;
        do
        try {
            System.out.print(welcome);
            value = Integer.parseInt(sc.nextLine());
            cont = false;
        } catch (Exception e) {
            System.out.println("Retype an integer: ");
        } while (cont == true);
        return value;
    }
}
