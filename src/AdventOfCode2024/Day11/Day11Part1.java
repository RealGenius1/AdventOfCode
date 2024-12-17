package src.AdventOfCode2024.Day11;

import src.AdventOfCode2024.Reader.Reader;

import java.math.BigInteger;
import java.util.ArrayList;

public class Day11Part1 {
    public static void main(String[] args){
        String input = Reader.reader("Input11.txt").get(0);
        ArrayList<BigInteger> list = new ArrayList<>();
        while(!input.isEmpty()){
            String temp;
            if(input.contains(" ")){
                temp = input.substring(0,input.indexOf(" "));
                input = input.substring(input.indexOf(" ") + 1);
                list.add(BigInteger.valueOf(Integer.parseInt(temp)));
            } else {
                list.add(BigInteger.valueOf(Integer.parseInt(input)));
                input = "";
            }
        }
        //This solution works whenever integer overflow isn't an issue
        //Integer overflow however, is an issue and as such it breaks cuz I multiply by 2024
        //This specific input breaks at Blink #10 when a number is -5 and it tries to parseInt("-")
        //The solution is to do some abs value chicanery to fix it, but it doesn't solve overflow problem
        //Something like python would be able to get around this issue however
        //The java solution is BigInteger class (i've used this before once or twice)
        //BigInteger does python levels of memory BS to get around overflow
        for(int blink = 0; blink < 25; blink++){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).equals(BigInteger.ZERO)){
                    list.set(i,BigInteger.valueOf(1));
                } else if (list.get(i).toString().length() % 2 == 0){
                    String num = list.get(i).toString();
                    String left = num.substring(0,num.length() / 2);
                    String right = num.substring(num.length() / 2);
                    try {
                        list.set(i, BigInteger.valueOf(Integer.valueOf(left)));
                    } catch(Exception c){
                        System.out.println(left);
                        System.out.println(num);
                        System.out.println(right);
                        System.out.println(blink);
                        System.out.println(i);
                        return;
                    }
                    list.add(i+1, BigInteger.valueOf(Integer.valueOf(right)));
                    i++;
                } else {
                    list.set(i,list.get(i).multiply(BigInteger.valueOf(2024)));
                }
            }
        }
        System.out.println(list.size());
    }
}
