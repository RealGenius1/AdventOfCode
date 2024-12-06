package src.AdventOfCode2024.Day6;

import src.AdventOfCode2024.Reader.Reader;
import java.util.ArrayList;

public class Day6Part1 {
    public static int starti = 0;
    public static int startj = 0;
    public static void main(String[] args){
        ArrayList<String> input = Reader.reader("Input6.txt");
        char[][] grid = new char[input.size()][input.get(0).length()];
        int count = 0;

        for(int i = 0; i < input.size(); i++){
            if(input.get(i).contains("^")){
                starti = i;
                startj = input.get(i).indexOf('^');
            }
            grid[i] = input.get(i).toCharArray();
        }


        while(true){
            try {
                char c;
                char dir = grid[starti][startj];
                switch (dir) {
                    //Go up
                    case '^':
                        c = grid[starti-1][startj];
                        if(c != '#'){
                            grid[starti][startj] = 'X';
                            grid[starti-1][startj] = '^';
                            starti--;
                        } else {
                            grid[starti][startj] = '>';
                        }
                        break;
                    //Go right
                    case '>':
                        c = grid[starti][startj+1];
                        if(c != '#'){
                            grid[starti][startj] = 'X';
                            grid[starti][startj+1] = '>';
                            startj++;
                            break;
                        } else {
                            grid[starti][startj] = 'v';
                            break;
                        }

                    //Go down
                    case 'v':
                        c = grid[starti+1][startj];
                        if(c != '#'){
                            grid[starti][startj] = 'X';
                            grid[starti+1][startj] = 'v';
                            starti++;
                            break;
                        } else {
                            grid[starti][startj] = '<';
                            break;
                        }
                    //Go left
                    case '<':
                        c = grid[starti][startj-1];
                        if(c != '#'){
                            grid[starti][startj] = 'X';
                            grid[starti][startj-1] = '<';
                            startj--;
                            break;
                        } else {
                            grid[starti][startj] = '^';
                            break;
                        }
                    //Error check
                    default:
                        throw new ArrayStoreException("Somehow your index wasn't the guard");
                }
            } catch(ArrayIndexOutOfBoundsException c){
                count++;
                break;
            }
        }
        for(char[] c : grid){
            for(char i : c){
                if(i == 'X'){
                    count++;
                }
            }
        }
        System.out.println(count);


    }
}
