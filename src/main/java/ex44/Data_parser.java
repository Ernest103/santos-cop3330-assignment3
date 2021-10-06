package ex44;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Data_parser {


    //Pre: Receives a string holding the location of the JSON data file
    //Post: Parses the data held on the file and returns an array of products
    //          from the data held in the file
    public ArrayList<Products> read_products(String location)
    {
        String name, price, quantity;

        try {
            Object parser = new JSONParser().parse(new FileReader(location));
            JSONArray jsonArray = (JSONArray) ((JSONObject)parser).get("products");
            ArrayList<Products> ret_array = new ArrayList<>();

            for (Object obj : jsonArray) {
                name = ((JSONObject) obj).get("name").toString();
                price = ((JSONObject) obj).get("price").toString();
                quantity = ((JSONObject) obj).get("quantity").toString();

                ret_array.add(new Products(name, price, quantity));
            }
            return ret_array;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }


    //Pre: Receives a non-empty array of products and the name of a product
    //Post: Returns null if the product is not found on the array
    //          else it returns the product;
    public Products getProduct(ArrayList<Products> list, String product_name)
    {
        for (Products product : list) {
            if(product.getName().toLowerCase(Locale.ROOT).equals(product_name))
                return product;
        }

        return null;
    }

}
