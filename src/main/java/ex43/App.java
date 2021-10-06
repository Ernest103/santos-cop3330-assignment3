package ex43;

import java.util.Locale;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 first_name last_name
 */
public class App {
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        String siteName, author, jsc, css;
        String root = "./website/";

        System.out.print("Site name: ");
        siteName = sc.nextLine();
        System.out.print("Author: ");
        author = sc.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        jsc = sc.nextLine().toLowerCase(Locale.ROOT);
        System.out.print("Do you want a folder for CSS? ");
        css = sc.nextLine().toLowerCase(Locale.ROOT);
        sc.close();

        Website newSite = new Website(root, siteName, author, css, jsc);
        newSite.initWebsite();
        newSite.initHTML();
        newSite.display();
    }
}
