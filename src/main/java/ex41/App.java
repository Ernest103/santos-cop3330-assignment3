package ex41;

import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = "exercise41_input.txt";
        Data_Handler readFile;
        Scanner input = new Scanner(System.in);

        //There's a file to be used store

        readFile = new Data_Handler(fileName);

        readFile.handleData();
        System.out.println("Process complete check for output file!");

    }
}
