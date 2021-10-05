package ex41;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTestex41
{
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();


    @Test
    public void readDataTest() throws IOException {
        File testFile = folder.newFile("temp.txt");
        FileWriter output = new FileWriter(testFile);
        output.write("Test\n" +
                "test\n" +
                "test\n");
        Data_Handler testData = new Data_Handler("temp.txt");
        assertEquals("Data read correctly", testData.readData(testFile));
    }

    @Test
    public void sortDataTest()
    {
        ArrayList<String> testArr = new ArrayList<>();
        testArr.add("one");
        testArr.add("two");
        testArr.add("five");

        Data_Handler testData = new Data_Handler("temp.txt");
        assertEquals(1, testData.sortData(testArr));
    }
}
