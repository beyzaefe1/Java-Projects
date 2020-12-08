/* Beyza Efe
 * John Nehrbass
 * Aaron Hammer
 * CS1180-07
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs1180project03efe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Beyza
 */
public class CS1180Project03Efe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        System.out.println("THE ANAGRAM GAME\n");
        ArrayList<String> arrlist = new ArrayList();
        File file = new File("dictionary.txt");
        Scanner out = new Scanner(file);
        int x = (int) (Math.random() * 18);

        while (out.hasNext()) {//reading words from file
            arrlist.add(out.next());

        }
        out.close();
        while (true) {
            String word = randomword(arrlist);
            String shuffle = shuffleword(word);

            game(x, arrlist, file, word, shuffle);
        }
    }

    public static String randomword(ArrayList<String> arrlist) {

        int x = (int) (Math.random() * arrlist.size());//getting a random word from file

        return (arrlist.get(x));
    }

    public static String shuffleword(String word) {
        Random rand = new Random();
        int[] positions = rand.ints(0, word.length()).distinct().limit(word.length()).toArray();//getting random number from 0 to length of 
        String shuffleword = "";                                                                //word all distinct and limit of number is
        for (int i = 0; i < word.length(); i++) {                                               // length of word Aaron helped me with this
            shuffleword += word.charAt(positions[i]);
        }
        return shuffleword;

    }

    public static void game(int x, ArrayList<String> arrlist, File file, String word, String shuffle) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";

        int hint = 1;

        while (!input.equalsIgnoreCase("next")) {
            System.out.println("Unscramble the following letters to make a word: " + shuffle);
            System.out.println("Guess the word, or type: hint (for a hint), next (to skip this word),\nor quit (to end the game):");
            input = keyboard.next();

            if (input.equalsIgnoreCase(word) || input.equalsIgnoreCase("next")) {
                System.out.println("Congrats");
                input = "next";
            } else if (input.equalsIgnoreCase("hint")) {
                System.out.println(word.substring(0, hint));//giving next letter each time
                hint++;                                     //counter for how many hints given
            } else if (input.equalsIgnoreCase("quit")) {
                System.exit(0);
            } else {
                System.out.println("Try again");
            }
        }

    }
}
