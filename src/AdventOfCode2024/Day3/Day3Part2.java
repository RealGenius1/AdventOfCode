package src.AdventOfCode2024.Day3;

import src.AdventOfCode2024.Reader.Reader;
import java.util.ArrayList;

public class Day3Part2 {
    public static int total = 0;

    public static void instruct(String s) {
        while (!s.isEmpty()) {
            try {
                s = s.substring(s.indexOf("mul("));
            } catch (StringIndexOutOfBoundsException c) {
                s = "";
                continue;
            }
            //Trying to parse a non-real int throws an error;
            String temp = s.substring(0, s.indexOf(')') + 1); // gets just the mul part
            if (temp.length() > 12) {
                s = s.substring(3);
                continue;
            }
            s = s.substring(s.indexOf(')') + 1); //removes the temp part
            int x1 = 0;
            int x2 = 0;
            try {
                x1 = Integer.valueOf(temp.substring(temp.indexOf('(') + 1, temp.indexOf(',')));
            } catch (NumberFormatException | StringIndexOutOfBoundsException c) {
                continue;
            }
            try {
                x2 = Integer.valueOf(temp.substring(temp.indexOf(',') + 1, temp.indexOf(')')));
            } catch (NumberFormatException c) {
                continue;
            }
            total += (x2 * x1);
        }
    }

    public static void main(String[] args) {
        boolean enabled = true;
        ArrayList<String> input = Reader.reader("Input3.txt");
        String all = "";
        //Create one large string of the whole input
        for(String s : input){
            all += s;
        }

        while(!all.isEmpty()) {
            //Check to see if there is a don't() instruction to be dealt with
            if(all.contains("don't()")) {
                //Get all the instructions before the next don't() to be ran
                String d = all.substring(0, all.indexOf("don't()") + 1);
                //Remove all of those from the mega string so we start from the don't()
                all = all.substring(all.indexOf("don't()") + 1);
                //Run instructions
                instruct(d);

                //Check if we ever get re-enabled
                if(all.contains("do()")) {
                    //Skip all the instructions until our next re-enabling
                    all = all.substring(all.indexOf("do()"));
                } else {
                    //If we never get re-enabled, just kill the string
                    all = "";
                }
            } else {
                //If we are never disabled, just send all remaining instructions to be dealt with
                instruct(all);
            }
        }
        System.out.println(total);
    }
}