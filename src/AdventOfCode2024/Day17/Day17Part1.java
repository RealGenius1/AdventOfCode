package src.AdventOfCode2024.Day17;

import src.AdventOfCode2024.Reader.Reader;

import java.math.BigInteger;
import java.util.ArrayList;

public class Day17Part1 {
    public static BigInteger A;
    public static BigInteger B;
    public static BigInteger C;

    public static BigInteger combo(int arg){
        return switch (arg) {
            case 0 -> BigInteger.valueOf(arg);
            case 1 -> BigInteger.valueOf(arg);
            case 2 -> BigInteger.valueOf(arg);
            case 3 -> BigInteger.valueOf(arg);
            case 4 -> A;
            case 5 -> B;
            case 6 -> C;
            case 7 -> BigInteger.valueOf(7);
            default -> BigInteger.TEN;
        };
    }
    public static void main(String[] args) {
        ArrayList<String> input = Reader.reader("Input17.txt");
        //Grab the inputs
        String A1 = input.get(0);
        String B1 = input.get(1);
        String C1 = input.get(2);
        String prog = input.get(4);

        //Let's convert the registers to numbers
        A = new BigInteger(A1.substring(A1.lastIndexOf(" ") + 1));
        B = new BigInteger(B1.substring(B1.lastIndexOf(" ") + 1));
        C = new BigInteger(C1.substring(C1.lastIndexOf(" ") + 1));

        int instruct = 0;
        int cmd = 0;
        int operand = 1;
        int op = 0;
        prog = prog.substring(prog.lastIndexOf(" ") + 1).replace(",","");
        int[] inst = new int[prog.length()];
        for(int i = 0; i < inst.length; i++){
            inst[i] = (int) prog.charAt(i) - '0';
        }

        while(instruct < inst.length){
            cmd = inst[instruct];
            op = inst[operand];
            switch(cmd){
                case 0:
                    A = A.divide(BigInteger.TWO.pow(combo(op).intValueExact()));
                    instruct += 2;
                    operand += 2;
                    break;
                case 1:
                    B = B.xor(BigInteger.valueOf(op));
                    instruct += 2;
                    operand += 2;
                    break;
                case 2:
                    B = combo(op).mod(BigInteger.valueOf(8));
                    instruct += 2;
                    operand += 2;
                    break;
                case 3:
                    if(A.equals(BigInteger.ZERO)) {
                        instruct += 2;
                        operand += 2;
                        break;
                    } else {
                        instruct = op;
                        operand = instruct + 1;
                        break;
                    }
                case 4:
                    B = B.xor(C);
                    instruct += 2;
                    operand += 2;
                    break;
                case 5:
                    System.out.print(combo(op).mod(BigInteger.valueOf(8)) + ",");
                    instruct += 2;
                    operand += 2;
                    break;
                case 6:
                    B = A.divide(BigInteger.TWO.pow(combo(op).intValueExact()));
                    instruct += 2;
                    operand += 2;
                    break;
                case 7:
                    C = A.divide(BigInteger.TWO.pow(combo(op).intValueExact()));
                    instruct += 2;
                    operand += 2;
                    break;
                default:
                    break;
            }
        }

    }

}
