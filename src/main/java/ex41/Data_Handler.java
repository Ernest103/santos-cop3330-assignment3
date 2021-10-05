package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Data_Handler {
    //Array list holding the list of names
    //File object will store the file holding the names
    private final ArrayList<String> names;
    private final File inData;

    //constructor:
    //Pre: Receives the name of the file were to extract the data from
    //Post: Initializes the file object and calls the function which will read the data into the arrayList;
    public Data_Handler(String fileName) {
        inData = new File("Input_files/" + fileName);
        names = new ArrayList<>();
    }

    //This is a wrapper function which will process the data by
    //  Calling the necessary functions
    public void handleData()
    {
        readData(inData);
        sortData(names);
        displayNames();
    }


    //Pre: Receives a File object
    //Post: Initializes the Array list with the Strings read from the file
    public String readData(File _inData)
    {
        try{
            int i = 0;
            Scanner reader = new Scanner(_inData);
            while(reader.hasNextLine())
            {
                names.add(i++, reader.nextLine());
            }

            reader.close();
        }catch (FileNotFoundException e)
        {
            System.out.println("An Error has occurred, Printing error report: ");
            e.printStackTrace();
            System.out.println("Now exiting the program");
            System.exit(1);
        }

        return "Data read correctly";
    }

    //Pre:--
    //Post: Sorts the Array of names
    public int sortData(ArrayList<String> _names)
    {
        if(_names == null)//Unable to sort data
            return 0;

        Collections.sort(_names);
        return 1;
    }

    public void createFile()
    {
        File output = new File("src/main/java/ex41/exercise41_output.txt");

        try {
            boolean fileCreated = output.createNewFile();
            if (!fileCreated) {
                output.delete();
                output.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the output");
            System.out.println("Now exiting");
            System.exit(1);
        }
    }


    //Pre:--
    //Post: Creates the file holding the sorted output
    public void displayNames(){
        String s = String.format("Total of %d names\n" +
                "-----------------\n", names.size());
        try(FileWriter writer = new FileWriter("src/main/java/ex41/exercise41_output.txt"))
        {
            writer.write(s);
            for(String name : names)
            {
                writer.append(name).append("\n");
            }
        }catch (IOException e)
        {
            System.out.println("ERROR while writing to file");
            e.printStackTrace();
        }

    }
}
