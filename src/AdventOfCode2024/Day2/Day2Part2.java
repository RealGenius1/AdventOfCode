package src.AdventOfCode2024.Day2;

import src.AdventOfCode2024.Reader.Reader;

import java.util.ArrayList;

public class Day2Part2 {

    public static int removals = 0;

    public static boolean isSafe(ArrayList<Integer> list){
        boolean isDecreasing = list.get(0) < list.get(1) ? false : true;
        if(isDecreasing){
            for(int i = 0; i < list.size() - 1; i++){
                int dist = Math.abs(list.get(i) - list.get(i+1));
                if(list.get(i) <= list.get(i+1)){
                    if(removals == 0) {
                        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
                        ArrayList<Integer> list3 = (ArrayList<Integer>) list.clone();
                        list2.remove(i);
                        list.remove(i + 1);
                        try {
                            list3.remove(i - 1);
                        } catch(IndexOutOfBoundsException c){}
                        removals++;
                        return isSafe(list) || isSafe(list2) || isSafe(list3);
                    } else {
                        return false;
                    }
                }
                if(dist > 3) {
                    if(removals == 0) {
                        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
                        ArrayList<Integer> list3 = (ArrayList<Integer>) list.clone();
                        list2.remove(i);
                        list.remove(i + 1);
                        try {
                            list3.remove(i - 1);
                        } catch(IndexOutOfBoundsException c){}
                        removals++;
                        return isSafe(list) || isSafe(list2) || isSafe(list3);
                    }else {
                        return false;
                    }
                }
            }
        } else {
            for(int i = 0; i < list.size() - 1; i++){
                int dist = Math.abs(list.get(i) - list.get(i+1));
                if(list.get(i) >= list.get(i+1)){
                    if(removals == 0) {
                        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
                        ArrayList<Integer> list3 = (ArrayList<Integer>) list.clone();
                        list2.remove(i);
                        list.remove(i + 1);
                        try {
                            list3.remove(i - 1);
                        } catch(IndexOutOfBoundsException c){}
                        removals++;
                        return isSafe(list) || isSafe(list2) || isSafe(list3);
                    } else {
                        return false;
                    }
                }
                if(dist > 3) {
                    if(removals == 0) {
                        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
                        ArrayList<Integer> list3 = (ArrayList<Integer>) list.clone();
                        list2.remove(i);
                        list.remove(i + 1);
                        try {
                            list3.remove(i - 1);
                        } catch(IndexOutOfBoundsException c){}
                        removals++;
                        return isSafe(list) || isSafe(list2) || isSafe(list3);
                    } else {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args){
        ArrayList<String> input = Reader.reader("Input2.txt");
        int count = 0;
        for(String s : input){
            ArrayList<Integer> line = new ArrayList<Integer>();
            while(!s.isEmpty()){
                if(s.indexOf(' ') != -1){
                    line.add(Integer.valueOf(s.substring(0,s.indexOf(' '))));
                    s = s.substring(s.indexOf(' ') + 1);
                } else {
                    line.add(Integer.valueOf(s));
                    s = "";
                }

            }

            if(isSafe(line)){
                count++;
            } else {
                System.out.println(line);
                System.out.println(isSafe(line));
                System.out.println();
            }
            line = null;
            removals = 0;
        }

        System.out.println(count);
    }
}
