/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.lzw;
import java.util.ArrayList;
/**
 *
 * @author Nghia
 */
public class LZW_Test {
    public static void main(String args[]) {
        LZW_Coder coder = new LZW_Coder();
        LZW_Decoder decoder = new LZW_Decoder();
        
        String src = "AABAABBCCACC", initDictStr="ABC";
        ArrayList<Integer> zippedData= coder.zip(initDictStr, src);
        System.out.println("Test 1 src: " + src);
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNumber of codewords:" + zippedData.size());
        String unzippedStr = decoder.unzip(initDictStr, zippedData);
        System.out.println("After unzipping: " + unzippedStr + "\n\n");
        
        src= "LZW starts out with a dictionary of 256 characters\n";
        System.out.println("Test 2 src: " + src + "\nLength: " + src.length());
        zippedData= coder.zip(src);
        System.out.println("Zipped data:\n" + zippedData);
        System.out.println("\nNumber of codewords:" + zippedData.size());
        unzippedStr = decoder.unzip(zippedData);
        System.out.println("After unzipping:\n\n" + unzippedStr);
    }
}
