package com.company;
import java.util.Scanner;


public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        fullOperation();
    }
    
    static boolean checkContains(String s) {
        String[] RomanNum = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < RomanNum.length; i++) {
            if (s.equals(RomanNum[i])) return true;
        }
        return false;
    }


    public static void fullOperation(){

        System.out.println("Type what you want, man");
        String str = scanner.nextLine();
        try{
            if (str.split(" ").length > 3 || str.split(" ").length == 1 || str.split(" ").length == 2 || str.split(" ").length == 0) {
                throw new Exception ("You can't type more than 2 operands");
            }
         }catch (Exception ex) {
            System.out.println(" You can enter only 2 numbers, man, whatchu doing?");
            System.out.println("I am not gonna work like that");
            System.exit(1);
         }

        int n1= 0,n2 = 0;

        int result = 0;
        if (checkContains(str.split(" ")[0]) && checkContains(str.split(" ")[2])) {
            n1 = RomanToArabic.romanToArabicMethod(str.split(" ")[0]);
            n2 = RomanToArabic.romanToArabicMethod(str.split(" ")[2]);
            try {
                if ((n1 < n2) && str.split(" ")[1].equals("-")) throw new ArithmeticException(" ");
            } catch (ArithmeticException ex) {
                System.out.println("In roman decimal we don't work with negative results!");
                System.exit(-1);
            }
        } else {
            n1 = Integer.parseInt(str.split(" ")[0]);
            n2 = Integer.parseInt(str.split(" ")[2]);
        }

        try{
            if (!((n1 > 0) && (n1 < 11) && (n2 > 0) && (n2 < 11 ))) {
                throw new Exception ("Your numbers should be between 1-10");
            }
        }catch (Exception ex) {
            System.out.println("Your numbers should be between 1-10!");
            System.exit(1);
        }
        if (str.split(" ")[1].equals("+")) {
            result = n1 + n2;
        } else if (str.split(" ")[1].equals("-")) {
            result = n1-n2;
        } else if (str.split(" ")[1].equals("*")) {
            result = n1*n2;
        } else if (str.split(" ")[1].equals("/")) {
            result = n1/n2;
        } else {
            System.out.println("Wrong operand!");
            System.exit(-1);
        }

        if(checkContains(str.split(" ")[0]) && checkContains(str.split(" ")[2])) {
            System.out.println(ArabToRoman.ArabToRomanMethod(n1) + " "+ str.split(" ")[1] +" " + ArabToRoman.ArabToRomanMethod(n2) + " = " + ArabToRoman.ArabToRomanMethod(result));
        }
         else {
            System.out.println(n1 + " "+ str.split(" ")[1] +" " + n2 + " = " + result);
        }
        return;
    }}

