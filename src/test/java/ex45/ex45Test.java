package ex45;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;


public class ex45Test {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();


    @Test
    public void testWord_fined() {
        String ifp_path = "Input_files/exercise45_input.txt"; // * Location of input file
        String ofp_path = temp.getRoot().getPath().concat("/temp.txt");
        Word_finder testFinder = new Word_finder();

        testFinder.readData(ifp_path);
        testFinder.find_replace("utilize", "use");
        testFinder.write_output(ofp_path);

        //Should assert false if no error occurred while running through the methods in the class
        Assertions.assertEquals(false, testFinder.isError_occurred());
    }

}
