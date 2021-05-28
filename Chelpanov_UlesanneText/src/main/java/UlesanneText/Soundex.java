/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UlesanneText;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Alexander Chelpanov
 * Date: 01.04.2021
 * 
 * 
 */
public class Soundex {
    public static String soundex(String s) { 
        ArrayList<String> x = new ArrayList<>(Arrays.asList(s.toUpperCase().trim().split("")));
        //Meelde jääb sõna esimene täht.
        String firstLetter = x.get(0);

        // convert letters to numeric code
        for (int i = 0; i < x.size(); i++) {
            //Eemaldab kõik h ja w  (välja arvatud sõna esimene täht)           
            if (i!=0 && ("H".equals(x.get(i)) || "W".equals(x.get(i)))) {
                x.remove(i);
                i--;
            //Kaashäälikud asendatakse numbritega 1–6 ja samad numbrid 
            //vastavad tähtedele, mis kõlavad sarnaselt
            // b, f, p, v → 1
            } else if("B".equals(x.get(i)) || "F".equals(x.get(i)) || 
                    "P".equals(x.get(i)) || "V".equals(x.get(i))) {
                x.set(i, "1");
            // c, g, j, k, q, s, x, z → 2    
            } else if("C".equals(x.get(i)) || "G".equals(x.get(i)) 
                    || "J".equals(x.get(i)) || "K".equals(x.get(i)) 
                    || "Q".equals(x.get(i)) || "S".equals(x.get(i)) 
                    || "X".equals(x.get(i)) || "Z".equals(x.get(i))){
                x.set(i, "2");
            // d, t → 3
            } else if("D".equals(x.get(i)) || "T".equals(x.get(i))){
                x.set(i, "3");
            // l → 4
            } else if("L".equals(x.get(i))){
                x.set(i, "4");
            // m, n → 5
            } else if("M".equals(x.get(i)) || "N".equals(x.get(i))){
                x.set(i, "5");
            // r → 6    
            } else if("R".equals(x.get(i))){
                x.set(i, "6");
            // a, e, i, o, u, y → 0
            } else {
                x.set(i, "0");;
            }

        }

        // remove duplicates
        String output = "" + firstLetter;
        for (int i = 1; i < x.size(); i++) {
            //Järjestikused identsed numbrid taandatakse ühele sellisele numbrile. 
            //Kõik 0 ei loeta (0 = a, e, i, o, u, y)
            if (!x.get(i).equals(x.get(i - 1)) && !"0".equals(x.get(i))) {
                output += x.get(i);
            }
        }

        // Saadud string kärbitakse nelja esimese tähemärgini. 
        // Kui stringi pikkus on nõutavast väiksem, asendatakse puuduvad tähemärgid 0-ga.        
        output = output + "0000";
        return output.substring(0, 4);
    }
    
    
    public static int difference(String str, String str2 ){
        String [] arr = soundex(str).split("");
        String [] arr2 = soundex(str2).split("");
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {            
            if (arr[i].equals(arr2[i])) {
                counter++;
            }
        }
        return counter;
    }
}
