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
    private String userChoice;
    private Scanner reader = new Scanner(System.in);
    public List<String> operations = new ArrayList<>();
    private Utils utils = new Utils();

    void mainMenu() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.MAIN_MENU);
        userInput();
        checkUserInput();
    }

    private void userInput() {
        System.out.println(Strings.CHOOSE_OPTION);
        userChoice = reader.nextLine();
    }

    private void checkUserInput() throws ScriptException, IOException, WriteException {
        switch (userChoice) {
            case ("1"):
                System.out.println(Strings.HELLO_WORLD_MENU);
                userChoice = reader.nextLine();
                if ("quit".equals(userChoice)) {
                    mainMenu();
                } else {
                    System.out.println(Strings.IC_HELLO_WORLD);
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
                System.out.println(Strings.IC_MAIN_MENU);
                mainMenu();
        }
    }

    private void calculatorMenu() throws ScriptException, IOException, WriteException {
        Calculator calculator = new Calculator();
        System.out.println(Strings.CALCULATOR_MENU);
        calculator.calculatorMenu();
    }

    String checkCalculatorOption() {
        System.out.println(Strings.CHOOSE_OPTION);
        userChoice = reader.nextLine();
        return userChoice;
    }

    public double[] calculatorInputs() {
        System.out.println(Strings.INPUT_FIRST_NUMBER);
        double firstNumber = utils.tryNumberInput();
        System.out.println(Strings.INPUT_SECOND_NUMBER);
        double secondNumber = utils.tryNumberInput();
        return new double[]{firstNumber, secondNumber};
    }

    void endOrNot() throws ScriptException, IOException, WriteException {
        PrintToExcel printToExcel = new PrintToExcel();
        System.out.println(Strings.END_MENU);
        userChoice = reader.nextLine();
        switch (userChoice) {
            case ("1"):
                mainMenu();
                break;
            case ("2"):
                System.out.println(operations);
                break;
            case ("3"):
                printToExcel.print();
                break;
            case ("4"):
                System.exit(0);
                break;
            default:
                System.out.println(Strings.IC_END);

        }
        endOrNot();
    }
}
