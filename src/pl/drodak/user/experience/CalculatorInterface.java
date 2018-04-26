package pl.drodak.user.experience;

import jxl.write.WriteException;
import pl.drodak.utils.Strings;
import pl.drodak.utils.Utils;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Scanner;

public class CalculatorInterface {

    private UserInterface userInterface = new UserInterface();
    private Calculator calculator = new Calculator();

    void calculatorMenuOutprint() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.CALCULATOR_MENU);
        calculatorMenu();
    }

    void calculatorMenu() throws ScriptException, IOException, WriteException {
        switch (checkCalculatorOption()) {
            case ("1"):
                calculator.addition();
                break;
            case ("2"):
                calculator.subtraction();
                break;
            case ("3"):
                calculator.product();
                break;
            case ("4"):
                calculator.quotient();
                break;
            case ("5"):
                calculator.root();
                break;
            case ("6"):
                calculator.exponentiation();
                break;
            case ("7"):
                calculator.userInputOperations();
                break;
            case ("8"):
                calculator.operationsReadFromExcel();
                break;
            default:
                System.out.println(Strings.IC_CALCULATOR_MENU);
                calculatorMenu();
        }
        userInterface.endOrNot();
    }

    public double[] calculatorInputs() {
        Utils utils = new Utils();
        System.out.println(Strings.INPUT_FIRST_NUMBER);
        double firstNumber = utils.tryNumberInput();
        System.out.println(Strings.INPUT_SECOND_NUMBER);
        double secondNumber = utils.tryNumberInput();
        return new double[]{firstNumber, secondNumber};
    }

    private String checkCalculatorOption() {
        Utils utils = new Utils();
        System.out.println(Strings.CHOOSE_OPTION);
        return utils.userInput();
    }

}
