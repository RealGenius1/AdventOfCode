package src.AdventOfCode2024.Day4;

import src.AdventOfCode2024.Reader.Reader;
import java.util.ArrayList;
import java.util.Arrays;

public class Day4Part1 {

    public static final String word = "XMAS";
    public static final char X = 'X';
    public static int count = 0;
//    public void find(String word, ArrayList<Character[]> puzzle) {
//        boolean wordFound = false;
//        int size = puzzle.get(0).length; // Puzzle dimensions.
//        for (int row = 0; row < puzzle.size(); row++) {
//            for (int column = 0; column < size; column++) {
//                if (wordFound == false && puzzle.get(row)[column] == word.charAt(0)) { // Assumes the puzzle only contains the match once.
//                    wordFound = confirmMatch(word, row, column);
//                }
//            }
//        }
//        if (wordFound == false)
//            System.out.println(word + " not found");
//    }

    // Searches all eight directions from a first letter match passed by Find().
    // Algorithm is efficient, but lots of repeated code. Consider a recursive solution.
    public static boolean confirmMatch(int row, int column, char[][] puzzle) {
        boolean foundMatch = false;
        int len = word.length(); // We will only search in directions that have at least this much space.

        if ((column - len) >= -1) { // The word can exist to the left.
            int wordPos = 0;
            for (int i = column; i >= (column - len) + 1; i--) {
                if (word.charAt(wordPos) != puzzle[row][i]) {
                    break;
                }
                if (i == (column - len) + 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
            }
        }

        if ((column + len) <= puzzle[0].length) { // The word can exist to the right
            int wordPos = 0;
            for (int i = column; i <= (column + len) - 1; i++) {
                if (word.charAt(wordPos) != puzzle[row][i]) {
                    break;
                }
                if (i == (column + len) - 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
            }
        }

        if ((row - len) >= -1) { // The word can exist above
            int wordPos = 0;
            for (int i = row; i >= (row - len) + 1; i--) {
                if (word.charAt(wordPos) != puzzle[i][column]) {
                    break;
                }
                if (i == (row - len) + 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
            }
        }

        if ((row + len) <= puzzle[0].length) { // The word can exist below
            int wordPos = 0;
            for (int i = row; i <= (row + len) - 1; i++) {
                if (word.charAt(wordPos) != puzzle[i][column]) {
                    break;
                }
                if (i == (row + len) - 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
            }
        }

        if ((row - len) >= -1 && (column - len) >= -1) { // The word can exist up and to the left
            int wordPos = 0;
            int j = column;
            for (int i = row; i >= (row - len) + 1; i--) {
                if (word.charAt(wordPos) != puzzle[i][j]) {
                    break;
                }
                if (i == (row - len) + 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
                j--;
            }
        }

        if ((row - len) >= -1 && (column + len) <= puzzle[0].length) { // The word can exist up and to the right
            int wordPos = 0;
            int j = column;
            for (int i = row; i >= (row - len) + 1; i--) {
                if (word.charAt(wordPos) != puzzle[i][j]) {
                    break;
                }
                if (i == (row - len) + 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
                j++;
            }
        }

        if ((row + len) <= puzzle[0].length && (column - len) >= -1) { // The word can exist down and to the left
            int wordPos = 0;
            int j = column;
            for (int i = row; i <= (row + len) - 1; i++) {
                if (word.charAt(wordPos) != puzzle[i][j]) {
                    break;
                }
                if (i == (row + len) - 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
                j--;
            }
        }

        if ((row + len) <= puzzle[0].length && (column + len) <= puzzle[0].length) { // The word can exist down and to the right
            int wordPos = 0;
            int j = column;
            for (int i = row; i <= (row + len) - 1; i++) {
                if (word.charAt(wordPos) != puzzle[i][j]) {
                    break;
                }
                if (i == (row + len) - 1) { // A match was found
                    foundMatch = true;
                }
                wordPos++;
                j++;
            }
        }

        return foundMatch;
    }


    public static void main(String[] args) {

        //560 -- TO LOW
        //

        ArrayList<String> input = Reader.reader("Input4.txt");
        //Make a 2d Char array that may not be used
        char[][] map = new char[input.size()][input.get(0).length()];
//        ArrayList<Character[]> grid = new ArrayList<Character[]>();
        //Java can't easily convert char[] to Character[] so I need to do some BS
//        for (String s : input) {
//            Character[] temp = new Character[s.length()];
//            char[] list = s.toCharArray();
//            for(int i = 0; i < temp.length; i++){
//                temp[i] = list[i];
//            }
//            grid.add(temp);
//
//        }
        for(int i = 0; i < input.size(); i++){
            map[i] = input.get(0).toCharArray();
        }

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == X){
                    if(confirmMatch(i,j,map)){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
