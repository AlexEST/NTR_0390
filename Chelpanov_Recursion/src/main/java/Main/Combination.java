/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Alexander Chelpanov
 * Date: 07.02.2021
 * 
 */
public class Combination {

    static void makeCombiUtil(ArrayList<String> tmp, int participants, int left, int teamSize) {
        if (teamSize == 0) {
            System.out.println(tmp);
            return;
        }

        for (int i = left; i <= participants; ++i) {
            tmp.add("Participant"+i);
            makeCombiUtil(tmp, participants, i + 1, teamSize - 1);

            tmp.remove(tmp.size() - 1);
        }
    }

    static void makeCombi(int participants, int teamSize) {

        ArrayList<String> tmp = new ArrayList<>();
        makeCombiUtil(tmp, participants, 1, teamSize);
    }

}
