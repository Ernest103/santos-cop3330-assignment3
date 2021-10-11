package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ernesto Santos
 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String input_address = "Input_files/exercise45_input.txt"; // Location of input file
        String toFind = "utilize"; // word to find
        String replacement = "use"; // replacement word
        String output_address = "src/main/java/ex45/"; //Path where to put output file
        Scanner input = new Scanner(System.in);

        Word_finder replacer = new Word_finder();
        replacer.readData(input_address);
        replacer.find_replace(toFind, replacement);

        System.out.print("What would you like to name the output file(Format <file_name.txt>): ");
        output_address = output_address.concat(input.nextLine());
        replacer.write_output(output_address);

        input.close();

    }
}
