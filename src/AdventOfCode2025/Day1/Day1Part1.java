package src.AdventOfCode2025.Day1;

import src.AdventOfCode2025.Reader.Reader;

import java.util.ArrayList;
import java.util.Arrays;


public class Day1Part1 {
    public static void main(String[] args) {
        ArrayList<String> input = Reader.reader("input1.txt");
        int loc = 50;
        int count = 0;
        for(String s : input){
            char c = s.charAt(0);
            int x = Integer.parseInt(s.substring(1));
            switch (c){
                case 'L':
                    while(x != 0){
                        if(loc == 0){
                            loc = 99;
                            x--;
                        } else {
                            loc--;
                            x--;
                        }
                    }
                    if(loc == 0){
                        count++;
                    }
                    break;
                case 'R':
                    while(x != 0){
                        if(loc == 99){
                            loc = 0;
                            x--;
                        } else {
                            loc++;
                            x--;
                        }
                    }
                    if(loc == 0){
                        count++;
                    }
                    break;
            }
        }
        System.out.println(count);
    }
}
