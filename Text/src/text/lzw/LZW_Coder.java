/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package text.lzw;
import java.util.Hashtable;
import java.util.ArrayList;
/**
 *
 * @author Nghia
 */
public class LZW_Coder {
    Hashtable<String, Integer> dict=null;
    ArrayList<Integer> zippedData= null;
    int code=0;
    String initDictStr=null;
    
    public LZW_Coder() {
    }
    
    private void initDict() {
        dict= new Hashtable();
        if (initDictStr==null) {
            for (int i=0; i<256; i++) dict.put("" + (char)i, i);
            code= 256;
        }
        else {
            int L= initDictStr.length();
            for (int i=0; i<L; i++) dict.put("" + initDictStr.charAt(i), i);
            code = L;
        }
    }
    
    private void putToDict(String s) {
        dict.put(s, code++);
    }
    
    private void addOutput(int code) {
        zippedData.add(code);
    }
    
    private ArrayList<Integer> encode(String src) {
        zippedData = new ArrayList();
        Integer resultCode;
        String curSub="";
        String newSub;
        char c;
        for (int i=0; i<src.length(); i++) {
            c = src.charAt(i);
            newSub = curSub + c;
            if (dict.containsKey(newSub)) curSub= newSub;
            else {
                resultCode= dict.get(curSub);
                addOutput(resultCode);
                putToDict(newSub);
                curSub = "" + c;
            }
        }
        resultCode= dict.get(curSub);
        addOutput(resultCode);
        return zippedData;
    }
    
    public ArrayList<Integer> zip(String src) {
        initDictStr= null;
        initDict();
        return encode(src);
    }
    
    public ArrayList<Integer> zip(String initDictStr, String src) {
        this.initDictStr= initDictStr;
        initDict();
        return encode(src);
    }
}
