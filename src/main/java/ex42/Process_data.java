package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Process_data {

    //Pre: Receive the location of an input file
    //Post: Read the data on the file and append it to the string
    public String readData(File input){
        String unparsed_data = "";
        try{
            Scanner reader = new Scanner(input);
            while (reader.hasNext())
            {
                unparsed_data = unparsed_data.concat(reader.nextLine()).concat("\n");
            }

            reader.close();
            return unparsed_data;

        }catch (FileNotFoundException e)
        {
            System.out.println("Error while reading the file");
            e.printStackTrace();
            return null;
        }
    }

    //Pre: Receives a non-empty string containing the data read from the file
    //Post: Returns and array of data objects which hold the now parsed data
    public Data[] parse_data(String unparsed_data)
    {
        if(unparsed_data == null)
            return null;

        String[] temp_stor = unparsed_data.split(",|\\R");
        Data[] return_vals = new Data[temp_stor.length / 3];


        int count = 0;
        for(int i = 0; i < return_vals.length; i++)
        {
            return_vals[i] = new Data(temp_stor[count++], temp_stor[count++], temp_stor[count++]);
        }

        return return_vals;
    }


    //Pre: Receives a non-empty Array of data objects
    //Post: Display The data in the array in a tabular manner
    public void displayData(Data[] data)
    {
        if(data == null)
        {
            System.out.println("Error occurred while displaying data");
            System.exit(1);
        }

        System.out.println("Last      First     Salary\n" +
                "--------------------------");

        for(Data user : data)
        {
            System.out.printf("%-10s%-10s%-10s\n"
                    , user.getfName(), user.getlName(), user.getSalary());
        }
    }
}
