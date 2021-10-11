package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Word_finder {
    /* *
    * 1 - Read the file line by line storing each line in an array list of strings
    * 2 - Replace the specified word in the string with the new word
    * 3 - Write the data into the user specified output file */

    private ArrayList<String> lines;
    private boolean error_occurred;

    public Word_finder() {
        this.lines = new ArrayList<>();
        this.error_occurred = false;
    }

    //Getter for Error occurred
    public boolean isError_occurred() {
        return error_occurred;
    }

    //Pre: Receives a String with the location of the input file
    //Post: Reads the data from the file storing each line into the class
    //        String array.
    public void readData(String input_file)
    {
        File ifp = new File(input_file);

        try {
            Scanner reader = new Scanner(ifp);
            int i = 0;
            while (reader.hasNextLine())
            {
                lines.add(i++, reader.nextLine().concat("\n"));
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            error_occurred = true;
        }

    }


    //Pre: Receives to String containing the word to find and the word that will replace it
    //Post: Replaces each occurrence of the word toFind with the replacement word
    public void find_replace(String toFind, String replacement)
    {

        if (!error_occurred) {
            int counter = 0;
            while (counter < lines.size())
            {
                if(!lines.get(counter).contains(toFind))
                {
                    counter++;
                    continue;
                }

                String replaced = lines.get(counter).replace(toFind, replacement);
                lines.set(counter++, replaced);
            }
        }
    }


    //Pre: Receives the location of where to put the output file
    //Post: Creates the new output file, if the file exists it gets deleted then
    //      a new file is created
    public File create_output(String location)
    {
        File output = new File(location);

        try {
            boolean fileCreated = output.createNewFile();
            if (!fileCreated) {
                error_occurred = output.delete();
                error_occurred = !output.createNewFile();
            }

            return output;
        } catch (IOException e) {
            System.out.println("An error occurred while creating the output");
            System.out.println("Now exiting");
            System.exit(1);
        }

        return null;
    }


    //Pre: Receives the address to the output file
    //Post: Writes the data held in the class string array onto the
    //      newly created output file
    public void write_output(String output_address)
    {
        File ofp = create_output(output_address);

        if (!error_occurred) {
            try {
                FileWriter writer = new FileWriter(ofp);
                for(String line : lines)
                {
                    writer.write(line);
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                error_occurred = true;
            }
        }
    }
}
