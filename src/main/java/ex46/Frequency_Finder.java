package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Frequency_Finder {

    private boolean error_occurred;

    public Frequency_Finder() {
        error_occurred = false;
    }

    public boolean isError_occurred() {
        return error_occurred;
    }

    //Pre: Receives a List of words not null, and the address of the input file
    //Post: Reads the words in the files and updates the word frequency of each word
    //        Respectively
    public void setfrequency(List<Word> wordList, String ifp_address)
    {
        File ifp = new File(ifp_address);
        try {
            for(Word word : wordList)
            {
                Scanner reader = new Scanner(ifp);
                while (reader.hasNext())
                {
                    if(word.getWord().equals(reader.next()))
                        word.setFrequency(word.getFrequency() + 1);
                }
                reader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            error_occurred = true;
        }

    }


    //Pre: Receives a not null word list
    //Post: If list is null program exits with status -1, if list is not null
    //      List gets sorted based on the frequency and then Displayed
    public void display_freq_based(List<Word> wordList)
    {
        if(wordList == null || error_occurred)
        {
            error_occurred = true;
            System.exit(-1);
        }

        Collections.sort(wordList);
        for (Word word : wordList)
        {
            System.out.printf("%-8s: ", word.getWord());
            for(int i = 0; i < word.getFrequency(); i++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }
}
