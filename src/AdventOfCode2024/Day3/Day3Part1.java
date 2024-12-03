package src.AdventOfCode2024.Day3;

import src.AdventOfCode2024.Reader.Reader;
import java.util.ArrayList;

public class Day3Part1 {
    public static void main(String[] args){
        ArrayList <String> input = Reader.reader("Input3.txt");
        int total = 0;
        for(String s : input){
            while(!s.isEmpty()) {
                try {
                    s = s.substring(s.indexOf("mul("));
                } catch(StringIndexOutOfBoundsException c){
                    s = "";
                    continue;
                }
                //Trying to parse a non-real int throws an error;
                String temp = s.substring(0,s.indexOf(')') + 1); // gets just the mul part
                if(temp.length() > 12){
                    s = s.substring(3);
                    continue;
                }
                s = s.substring(s.indexOf(')') + 1); //removes the temp part
                int x1 = 0;
                int x2 = 0;
                try {
                    x1 = Integer.valueOf(temp.substring(temp.indexOf('(') + 1, temp.indexOf(',')));
                } catch (NumberFormatException c) {
                    continue;
                } catch (StringIndexOutOfBoundsException e){
                    continue;
                }
                try {
                    x2 = Integer.valueOf(temp.substring(temp.indexOf(',') + 1, temp.indexOf(')')));
                } catch (NumberFormatException c) {
                    System.out.println("x2 error");
                    continue;
                }
                temp = temp.replace(Integer.toString(x1), "");
                temp = temp.replace(Integer.toString(x2), "");
                total += (x2 * x1);
                x1 = x2 = 0;

            }

    }
        System.out.println(total);
}
}
