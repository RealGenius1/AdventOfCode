package src.AdventOfCode2024.Day9;

import src.AdventOfCode2024.Reader.Reader;

import java.util.ArrayList;
import java.math.BigInteger;

public class Day9Part1 {
    public static int minIndex(ArrayList<String> str){
        for(int i = str.size() - 1; i > -1; i--){
            if(!str.get(i).equals(".")){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        String input = Reader.reader("Input9.txt").get(0);
        //cuts off the last value, may live to regret this decision, but math says it's free space
//        input = input.substring(0,input.length() - 1);
        //build the file structure.
        ArrayList <String> list = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < input.length(); i++){
            if(i % 2 == 0){
                int x = Integer.parseInt(String.valueOf(input.charAt(i)));
                for(int k = 0; k < x; k++){
                    list.add(Integer.toString(index));
                }
                index++;
            } else {
                int x = Integer.parseInt(String.valueOf(input.charAt(i)));
                for(int k = 0; k < x; k++){
                    list.add(".");
                }
            }
        }

        index = 0;
        while(index < minIndex(list)){
            if(list.get(index).contains(".")){
                list.set(index, list.get(minIndex(list)));
                list.set(minIndex(list), ".");
            }
            index++;
        }
        //This gets really big, so I need python levels of int size
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(".")){
                break;
            }
            BigInteger temp = new BigInteger(list.get(i));
            temp = temp.multiply(BigInteger.valueOf(i));
            sum = sum.add(temp);
        }
        System.out.println(sum);
    }
}
