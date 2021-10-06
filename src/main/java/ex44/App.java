package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        String file_location = "Input_files/exercise44_input.json";
        Data_parser handler = new Data_parser();
        Products search = null;
        Scanner sc = new Scanner(System.in);

        ArrayList<Products> product_list = handler.read_products(file_location);
        while (search == null)
        {
            System.out.print("What is the product name? ");
            search = handler.getProduct(product_list, sc.nextLine().toLowerCase(Locale.ROOT));
            if(search == null)
                System.out.println("Sorry, that product was not found in our inventory.");
            else
                System.out.println(search.full_product_info());
        }


    }
}
