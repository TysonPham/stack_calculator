/**
 * Author: Tyson Pham
 * Class: COMP 352 Data Structure and Algorithm
 */
package Default;

import java.io.*;
import java.util.Scanner;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Welcome to Tyson's Stack-based Calculator. Please enter the file name you wish to calculate: ");
        String fileName = sc.next();
        Scanner sc_reader = null;
        PrintWriter pw = null;
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        try {
            sc_reader = new Scanner(new FileInputStream(fileName));
            pw = new PrintWriter(new FileOutputStream("Output.txt"));
        } catch (FileNotFoundException e) {
            System.out.print("File not found. Program will terminate");
            System.exit(0);
        }
        while (sc_reader.hasNextLine()) {
            String temp = sc_reader.nextLine();
            pw.print(temp);
            pw.println("= " + calculator.evalExp(temp));  //expression will be put in here
        }
        sc.close();
        sc_reader.close();
        pw.close();
    }


}








