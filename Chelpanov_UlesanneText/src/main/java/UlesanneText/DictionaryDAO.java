/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UlesanneText;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Chelpanov
 * Date: 01.04.2021
 * 
 * 
 */
public class DictionaryDAO extends Thread{
    public static final List<String> wordsList = new ArrayList<>();
    public static final List<String> wordsFromText = new ArrayList<>();

    static void readDictionary() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "EnglishDictionary.txt"));
            String Line;
            while ((Line = reader.readLine()) != null) {
                String word = Line.trim().toUpperCase();
                wordsList.add(word);
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(DictionaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

    static void readWordsFromText() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "The_Last_of_the_Mohicans-James_Fenimore_Cooper.txt"));
            String Line;
            while ((Line = reader.readLine()) != null) {
                String line = Line.replaceAll("[()'?:!.,;{}-]+", " ");
                String[] lineWords = line.split(" ");
                for (int i = 0; i < lineWords.length; i++) {
                    String word = lineWords[i].trim();//режем пробелы по концам
                    word = word.replaceAll(" ", "");//заменяем все пробелы чтобы отследить пустую строку
                    if (!"".equals(word)) {
                        if (i < lineWords.length - 1) {
                            String wordNext = lineWords[i + 1].trim();
                            wordNext = wordNext.replaceAll(" ", "");
                            //проверяем для начала что слово не англ don't
                            if ("don".equals(word) && "t".equals(wordNext)) {
                                wordsFromText.add(word.toUpperCase() + "'" + wordNext.toUpperCase());

                                i++;
                            } else {
                                //Если попадается слово father's считаю что это father и s не добавляю 
                                if (!"s".equals(word)) {
                                    wordsFromText.add(word.toUpperCase());

                                }
                            }
                        } else {
                            if (!"s".equals(word)) {
                                wordsFromText.add(word.toUpperCase());

                            }
                        }

                    }

                }
            }
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(DictionaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }


}
