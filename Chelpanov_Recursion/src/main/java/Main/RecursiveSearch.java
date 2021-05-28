/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Alexander Chelpanov
 * Date: 08.02.2021
 * 
 * 
 * 1) If the current character is the last character of the text, but pat
 *    has more characters, return false.
 * 2) Else If the current character is the last character of the pattern,
 *    then return true
 * 3) Else If current characters of pat and text match, then
 *    return contains(text + 1, pat + 1);
 * 4) Else If current characters of pat and text don't match
 *    return contains(text + 1, pat);
 * 
 * 
 */
public class RecursiveSearch {

    private static boolean exactMatch(char[] text, char[] pat, int textIndex, int patIndex) {
        if (textIndex == text.length && patIndex != pat.length) {
            return false;
        }
        //Else If last character of pattern reaches 
        if (patIndex == pat.length) {
            return true;
        }
        if (text[textIndex] == pat[patIndex]) {
            return exactMatch(text, pat, textIndex + 1, patIndex + 1);
        }
        return false;
    }

    
    public static int indexOf(char [] text, char [] pat, int textIndex, int patIndex) {
        // If last character of text reaches 
        if (textIndex == text.length) {
            return -1;
        }
        // If current characters of pat and text match 
        if (text[textIndex] == pat[patIndex]) {
            if (exactMatch(text, pat, textIndex, patIndex)) {
                return textIndex;
            }else{
                return indexOf(text, pat, textIndex+1, patIndex);
            }
        }
        //If current characters of pat and tex don't match 
        return indexOf(text, pat, textIndex+1, patIndex);
    }
    
    public static int lastIndexOf(char [] text, char [] pat, int textIndex, int patIndex) {
        // If last character of text reaches 
        if (textIndex == text.length) {
            return -1;
        }
        // If current characters of pat and text match 
        if (text[textIndex] == pat[patIndex]) {
            if (exactMatch(text, pat, textIndex, patIndex)) {
                return textIndex+(pat.length-1);
            }else{
                return lastIndexOf(text, pat, textIndex+1, patIndex);
            }
        }
        //If current characters of pat and tex don't match 
        return lastIndexOf(text, pat, textIndex+1, patIndex);
    }

}
