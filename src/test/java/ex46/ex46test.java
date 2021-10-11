package ex46;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class ex46test {

    @Test
    public void Frequency_Finder_test(){
        Frequency_Finder testFF = new Frequency_Finder();
        List<Word> wordList = new ArrayList<Word>(){{
            add(new Word("badger"));
            add(new Word("mushroom"));
            add(new Word("snake"));
        }};
        String ifp_address = "Input_files/exercise46_input.txt";

        testFF.setfrequency(wordList, ifp_address);
        testFF.display_freq_based(wordList);

        //Asserts to false if all the methods in the class proceeded without errors
        Assertions.assertEquals(false, testFF.isError_occurred());

    }
}
