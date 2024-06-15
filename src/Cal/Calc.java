package Cal;

import java.util.*;

import java.util.Scanner;
import java.util.Arrays;

public class Calc {

    static List<String> arabic = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    static List<String> roman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    static List<String> romanTens = Arrays.asList("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String vvod = s.nextLine();
        String[] spl = vvod.split(" ");
        exceptions(spl);
        arabicMath(spl);
        convertRoman(spl);


    }

    public static void exceptions(String[] spl) {
        if (spl.length != 3) {
            throw new IllegalArgumentException("Введено некорректное выражение.");
        } else if (spl[2].equals("0")) {
            throw new ArithmeticException("Ты дурак?");
        }
        if ( (!roman.contains(spl[0])) && !arabic.contains(spl[0])) {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
        if ( (!roman.contains(spl[2])) && !arabic.contains(spl[2])) {
            throw new IllegalArgumentException("Введены некорректные данные");
        }

    }



    private static void arabicMath(String[] spl) {
        for (int i = 0; i < arabic.size() ; i++) {
            if (spl[0].equals(arabic.get(i))) {
                for (int j = 0; j < arabic.size(); j++) {
                    if (spl[2].equals(arabic.get(j))) {

                        int spl00 = Integer.parseInt(spl[0]);
                        int spl02 = Integer.parseInt(spl[2]);
                        String math1 = spl[1];
                        int arabicCalculation = Result(spl00, spl02, math1);
                        System.out.println("Результат: " + arabicCalculation);
                    }
                }
            }
        }
    }

    private static void convertRoman(String[] spl) {
        if (spl[0].equals("X")) {
            spl[0] = "10";
        }
        if (spl[2].equals("X")) {
            spl[2] = "10";
        }
        for (int i = 0; i < roman.size(); i++) {
            if (spl[0].equals(roman.get(i))) {
                spl[0] = arabic.get(i);
            }

            if (spl[2].equals(roman.get(i))) {
                spl[2] = arabic.get(i);


                int spl0 = Integer.parseInt(spl[0]);
                int spl2 = Integer.parseInt(spl[2]);
                String math = spl[1];
                int calculation = Result(spl0, spl2, math);


                if (calculation == 100) {
                    System.out.println("С");
                } else if (calculation % 10 == 0) {
                    int s = calculation / 10;
                    System.out.print(romanTens.get(s - 1));
                } else if (((calculation % 100) / 10) != 0) {
                    int s = (calculation % 100) / 10;
                    System.out.print(romanTens.get(s - 1));
                }
                if (calculation % 10 != 0) {
                    int ss = calculation % 10;
                    System.out.println(roman.get(ss - 1));

                }
            }
        }
    }



    public static Integer Result(int result1, int result2, String spl) {
        int result;

        switch (spl) {
            case "-":
                result = result1 - result2;
                break;
            case "+":
                result = result1 + result2;
                break;
            case "*":
                result = result1 * result2;
                break;
            case "/":
                result = result1 / result2;
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор");
        }
        ;
        return result;

    }
}
