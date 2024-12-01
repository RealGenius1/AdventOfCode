package src.AdventOfCode2024.Day1;

import src.Reader.Reader;


import java.util.ArrayList;
import java.util.Arrays;

public class Day1Part1 {

    public static void main(String[] args){
        ArrayList<String> Input = Reader.reader("Input1.txt");

        int[] left = new int[Input.size()];
        int[] right = new int[Input.size()];


        for(int i = 0; i < Input.size(); i++){
            String s = Input.get(i);
            left[i] = Integer.parseInt(s.substring(0,5));
            s = s.substring(8);
            right[i] = Integer.parseInt(s.substring(0,5));
        }

        Input = null;

        Arrays.sort(left);
        Arrays.sort(right);
        int distance, total  = 0;
        for(int i = 0; i < left.length; i++){
            distance = Math.abs(left[i] - right[i]);
            total += distance;
        }

        System.out.println(total);
    }

}
