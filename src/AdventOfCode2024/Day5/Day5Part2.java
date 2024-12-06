package src.AdventOfCode2024.Day5;

import src.AdventOfCode2024.Reader.Reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Day5Part2 {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<String> input = Reader.reader("Input5.txt");
        int end = input.indexOf("");
        HashMap<Integer, ArrayList<Integer>> rules = new HashMap<Integer, ArrayList<Integer>>();
        //Get all the rules
        for(int i = 0; i < end; i++){
            int key = Integer.parseInt(input.get(i).substring(0,2));
            int val = Integer.parseInt(input.get(i).substring(input.get(i).indexOf('|') + 1));
            if(rules.containsKey(key)){
                rules.get(key).add(val);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(val);
                rules.put(key,temp);
            }
        }
        for(int i = end + 1; i < input.size(); i++){
            int[] arr = Arrays.stream(input.get(i).split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            ArrayList<Integer> prev = new ArrayList<>();
            outerloop:
            for(int k = 0; k < arr.length; k++){
                ArrayList<Integer> prevs = rules.get(arr[k]);
                for(int s : prevs){
                    if(prev.contains(s)){

                    }
                }
                prev.add(arr[k]);
            }
            if(prev.size() == arr.length){
                count += arr[(arr.length - 1) / 2];
            }

        }
        System.out.println(count);


    }
}
