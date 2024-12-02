package src.AdventOfCode2024.Day1;

import src.AdventOfCode2024.Reader.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day1Part2 {

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
        int score = 0;

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i : right){
            if(map.containsKey(i)){
                map.put(i,map.get(i) + 1);
            } else {
                map.put(i,1);
            }
        }

        for(int i : left){
            if(map.containsKey(i)){
                int temp = map.get(i);
                score += temp * i;
            }
        }
        System.out.println(score);

    }
}
