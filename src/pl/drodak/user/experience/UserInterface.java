package pl.drodak.user.experience;

import jxl.write.WriteException;
import pl.drodak.utils.Strings;
import pl.drodak.utils.Utils;
import pl.drodak.excel.actions.PrintToExcel;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static String userChoice;
    private static Scanner reader = new Scanner(System.in);
    public static List<String> operations = new ArrayList<>();

    static void mainMenu() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.STARS.toString());
        System.out.println("*             I LOVE JAVA              *");
        System.out.println(Strings.STARS.toString());
        System.out.println("1. Hello World");
        System.out.println("2. Kalkulator");
        userInput();
        checkUserInput();
    }

    private static void userInput() {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.CHOOSE_OPTION.toString());
        userChoice = reader.nextLine();
    }

    private static void checkUserInput() throws ScriptException, IOException, WriteException {
        switch (userChoice) {
            case ("1"):
                System.out.println(Strings.NEXT_LINE.toString() + Strings.STARS.toString());
                System.out.println("*             Hello World              *");
                System.out.println(Strings.STARS.toString() + Strings.NEXT_LINE.toString());
                System.out.println("Wpisz quit aby powrócić do menu.");
                userChoice = reader.nextLine();
                if (userChoice.equals("quit")) {
                    mainMenu();
                } else {
                    System.out.println(Strings.NEXT_LINE.toString() + Strings.INCORRECT_CHOICE.toString() +"Wpisz quit.");
                    checkUserInput();
                }
                break;
            case ("2"):
                calculatorMenu();
                break;
            case ("end"):
                System.exit(0);
                break;
            default:
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INCORRECT_CHOICE.toString() + "Wybierz 1 lub 2.");
                mainMenu();
        }
    }

    private static void calculatorMenu() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.STARS.toString());
        System.out.println("*                 MENU                 *");
        System.out.println(Strings.STARS.toString());
        System.out.println("1. Suma");
        System.out.println("2. Różnica");
        System.out.println("3. Iloczyn");
        System.out.println("4. Iloraz");
        System.out.println("5. Pierwiastek n-tego stopnia");
        System.out.println("6. Potęga");
        System.out.println("7. Proste działanie wpisane przez Ciebie");
        System.out.println("8. Wczytaj z pliku");
        Calculator.calculatorMenu();
    }

    static String checkCalculatorOption() {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.CHOOSE_OPTION.toString());
        userChoice = reader.nextLine();
        return userChoice;
    }

    public static double[] calculatorInputs() {
        double firstNumber, secondNumber;
        System.out.println("Podaj pierwszą liczbę");
        firstNumber = Utils.tryFirstNumber();
        System.out.println("Podaj drugą liczbę");
        secondNumber = Utils.trySecondNumber();
        return new double[]{firstNumber, secondNumber};
    }

    static void endOrNot() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.STARS.toString());
        System.out.println("*                 MENU                 *");
        System.out.println(Strings.STARS.toString());
        System.out.println("1. Powrót do początku");
        System.out.println("2. Uzyskaj historię wykonanych operacji");
        System.out.println("3. Eksportuj działania do pliku");
        System.out.println("4. Zakończ działanie programu");
        userChoice = reader.nextLine();
        switch (userChoice) {
            case ("1"):
                mainMenu();
                break;
            case ("2"):
                System.out.println(operations);
                endOrNot();
                break;
            case ("3"):
                PrintToExcel.print();
                endOrNot();
                break;
            case ("4"):
                System.exit(0);
                break;
            default:
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INCORRECT_CHOICE.toString());
                endOrNot();
        }
    }
}
