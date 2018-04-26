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
        CalculatorInterface calculator = new CalculatorInterface();
        HelloWorld helloWorld = new HelloWorld();
        switch (userChoice) {
            case ("1"):
                helloWorld.printOutHelloWorld();
                helloWorld.userInputHelloWorld();
                if ("quit".equals(userChoice)) {
                    mainMenu();
                } else {
                    System.out.println(Strings.IC_HELLO_WORLD);
                    checkUserInput();
                }
                break;
            case ("2"):
                calculator.calculatorMenuOutprint();
                break;
            case ("end"):
                System.exit(0);
                break;
            default:
                System.out.println(Strings.IC_MAIN_MENU);
                mainMenu();
        }
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
