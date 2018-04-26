package pl.drodak.utils;

import pl.drodak.user.experience.CalculatorInterface;
import pl.drodak.user.experience.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public double tryNumberInput() {
        CalculatorInterface calculatorInterface = new CalculatorInterface();
        Scanner input = new Scanner(System.in);
        double number = 0;
        try {
            number = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(Strings.TRY_NUMBER_ERROR);
            calculatorInterface.calculatorInputs();
        }
        return number;
    }

    public double roundUp(double outcome) {
        double rounding = outcome;
        rounding *= 100;
        rounding = Math.round(rounding);
        rounding /= 100;
        return rounding;
    }

    public String userInput(){
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
