/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulesanne_Hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Chelpanov 182730EDTR
 * Date: 27.02.2021
 * 
 */
public class DictionaryDAO {
    public static final HashMap<String, Integer> hashList = new HashMap<>();
    
    static {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt"));
            String Line;
            while ((Line = reader.readLine()) != null) {
                String line = Line.replaceAll("[()'?:!.,;{}-]+", " ");
                String [] lineWords = line.split(" ");
                for (int i = 0; i < lineWords.length; i++) {
                    String word = lineWords[i].trim();//режем пробелы по концам
                    word = word.replaceAll(" ", "");//заменяем все пробелы чтобы отследить пустую строку
                    if (!"".equals(word)) {
                        if (i < lineWords.length - 1) {
                            String wordNext = lineWords[i + 1].trim();
                            wordNext = wordNext.replaceAll(" ", "");
                            //проверяем для начала что слово не англ don't
                            if ("don".equals(word) && "t".equals(wordNext)) {
                                addToHashList(word + "'" + wordNext);
                                i++;
                            } else {
                                //Если попадается слово father's считаю что это father и s не добавляю 
                                if (!"s".equals(word)) {
                                    addToHashList(word);
                                }
                            }
                        } else {
                            if (!"s".equals(word)) {
                               addToHashList(word);
                            }                            
                        }
                        
                    }
                    
                    
                }
             
            }
        } catch (IOException ex) {
            Logger.getLogger(DictionaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void addToHashList(String word){
        //Если число то не заносим в словарь 
        if (isInt(word)) {
            return;
        }
        word = word.toLowerCase();
        if (hashList.containsKey(word)) {
            hashList.put(word, hashList.get(word)+1);
        }else{
            hashList.put(word, 1);
        }
    }
    
    /**
     * Проверка на число.
     * @param s
     * @return 
     */
    static boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException er) {
            return false;
        }
    }
}
