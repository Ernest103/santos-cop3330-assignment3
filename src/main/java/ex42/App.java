package ex42;

import ex41.Data_Handler;

import java.io.File;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ernesto Santos
 */
public class App
{
    public static void main( String[] args )
    {
        //Members
        String file_name = "Input_files/" + "exercise42_input.txt";
        File ifp = new File(file_name);
        Data[] user_data;
        Process_data processor = new Process_data();
        String unparsed_data;

        //Function call to read the data from file
        unparsed_data = processor.readData(ifp);

        //Function call to parse the data read from the file
        user_data = processor.parse_data(unparsed_data);

        //Function call to display the parsed data.
        processor.displayData(user_data);
    }
}
