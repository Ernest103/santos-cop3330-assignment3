package ex42;

import ex41.Data_Handler;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;


/**
 * Unit test for simple App.
 */
public class AppTestex42 {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void readDataTest(){
        File testFile = new File("Input_files/" + "exercise42_input.txt");

        Process_data test_prossr = new Process_data();
        Assertions.assertNotEquals(null, test_prossr.readData(testFile));
    }

    @Test
    public void parseDataTest()
    {
        Process_data test_prossr = new Process_data();
        String toParse = "john,doe,4562\nJane,Doe,1354";

        Assertions.assertNotEquals(null, test_prossr.parse_data(toParse));
    }
}

