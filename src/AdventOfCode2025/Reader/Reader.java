package src.AdventOfCode2025.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static ArrayList<String> reader(String file) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            String path = "src/AdventOfCode2025/Reader/Input/" + file;
            File myObj = new File(path);
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
