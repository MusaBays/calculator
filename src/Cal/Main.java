package Cal;

import java.util.*;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static List<String> arabic = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    static List<String> roman = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

    static List<String> romanTens = Arrays.asList("X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String vvod = s.nextLine();

        calc(vvod);


    }

    public static void calc(String input) {
        exceptions(input);
        arabicMath(input);
        convertRoman(input);
    }

    public static void exceptions(String input) {
        String[] spl = input.split(" ");
        if (spl.length != 3) {
            throw new IllegalArgumentException("Введено некорректное выражение.");
        } else if (spl[2].equals("0")) {
            throw new ArithmeticException("Ты дурак?");
        }
        if ((!roman.contains(spl[0])) && !arabic.contains(spl[0])) {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
        if ((!roman.contains(spl[2])) && !arabic.contains(spl[2])) {
            throw new IllegalArgumentException("Введены некорректные данные");
        }
        if ((roman.contains(spl[0])) && arabic.contains(spl[2]) || (roman.contains(spl[2])) && arabic.contains(spl[0])) {
            throw new IllegalArgumentException("Введены некорректные данные");
        }


    }


    private static void arabicMath(String input) {
        String[] spl = input.split(" ");
        for (int i = 0; i < arabic.size(); i++) {
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

    private static void convertRoman(String input) {
        String[] spl = input.split(" ");
        for (int j = 0; j < roman.size(); j++) {
            for (int i = 0; i < roman.size(); i++) {
                if (spl[0].equals(roman.get(i))) {
                    spl[0] = arabic.get(i);
                }

                if (spl[2].equals(roman.get(j))) {
                    spl[2] = arabic.get(j);


                    int spl0 = Integer.parseInt(spl[0]);
                    int spl2 = Integer.parseInt(spl[2]);
                    String math = spl[1];
                    int calculation = Result(spl0, spl2, math);
                    if (calculation <= 0) {
                        throw new ArithmeticException("Ошибка: результат вычисления римскими цифрами не может быть равен 0 или меньше 0");
                    }

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
