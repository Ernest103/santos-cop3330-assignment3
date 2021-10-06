package ex44;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class ex44test {

    @Test
    public void read_products(){
        String path = "Input_files/exercise44_input.json";
        String badPath = "Input_files/exercise44input.json";

        Data_parser testParse = new Data_parser();
        //Bad path is passed
        assertEquals(null, testParse.read_products(badPath));
        //Good path is passed
        Assertions.assertNotEquals(null, testParse.read_products(path));
    }

    @Test
    public void getProductTest(){
        String path = "Input_files/exercise44_input.json";
        String productName = "thing";

        Data_parser testParse = new Data_parser();
        ArrayList<Products> testArr = testParse.read_products(path);

        //String not contained is passed
        assertEquals(null, testParse.getProduct(testArr, "iphone"));

        //String is contained in array
        Assertions.assertNotEquals(null, testParse.getProduct(testArr, productName));
    }

    @Test
    public void testFullProductinfo(){
        String expected_prudct_info = "Name: Thing \n" +
                            "Price: 15.0 \n" +
                            "Quantity: 5";
        String path = "Input_files/exercise44_input.json";
        String productName = "thing";

        Products product_found;

        Data_parser testParse = new Data_parser();
        ArrayList<Products> testArr = testParse.read_products(path);
        product_found = testParse.getProduct(testArr, productName);

        assertEquals(expected_prudct_info, product_found.full_product_info());

    }
}
