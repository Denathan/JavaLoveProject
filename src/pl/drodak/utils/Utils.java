package pl.drodak.utils;

import pl.drodak.user.experience.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public static double tryFirstNumber() {
        Scanner input = new Scanner(System.in);
        double firstNumber = 0;
        try {
            firstNumber = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Musisz podać liczbę!");
            UserInterface.calculatorInputs();
        }
        return firstNumber;
    }

    public static double trySecondNumber() {
        Scanner input = new Scanner(System.in);
        double secondNumber = 0;
        try {
            secondNumber = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Musisz podać liczbę!");
            UserInterface.calculatorInputs();
        }
        return secondNumber;
    }

    public static double roundUp(double outcome) {
        double rounding = outcome;
        rounding *= 100;
        rounding = Math.round(rounding);
        rounding /= 100;
        return rounding;
    }
}
