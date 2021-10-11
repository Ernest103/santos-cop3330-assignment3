package ex46;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ernesto Santos
 */


import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        //List is implicitly created with the words to be checked
        List<Word> wordList = new ArrayList<Word>(){{
            add(new Word("badger"));
            add(new Word("mushroom"));
            add(new Word("snake"));
        }};
        String ifp_address = "Input_files/exercise46_input.txt"; //Location of input file for ease of access


        Frequency_Finder FF = new Frequency_Finder();

        FF.setfrequency(wordList, ifp_address);
        FF.display_freq_based(wordList);

    }
}
