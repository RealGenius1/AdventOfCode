package src.AdventOfCode2024.Reader;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;


public class Reader {
    public static ArrayList<String> reader(String title) {
        ArrayList <String> data = new ArrayList<String>();
        try {
            File myObj = new File("C:\\Users\\sptho\\IdeaProjects\\AdventOfCode\\src\\AdventOfCode2024\\Reader\\" + title);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.add(myReader.nextLine());
                //  System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}