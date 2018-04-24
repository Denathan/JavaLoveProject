package pl.drodak.utils;

import pl.drodak.user.experience.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public double tryNumberInput() {
        UserInterface userInterface = new UserInterface();
        Scanner input = new Scanner(System.in);
        double number = 0;
        try {
            number = input.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(Strings.TRY_NUMBER_ERROR);
            userInterface.calculatorInputs();
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
}
