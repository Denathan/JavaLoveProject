package pl.drodak.user.experience;

import jxl.write.WriteException;
import pl.drodak.excel.actions.ReadExcel;
import pl.drodak.utils.Strings;
import pl.drodak.utils.Utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Calculator {
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");
    private Date date = new Date();
    private String hour = df.format(date);
    private Scanner reader = new Scanner(System.in);
    private UserInterface userInterface = new UserInterface();
    private Utils utils = new Utils();
    private CalculatorInterface calculatorInterface = new CalculatorInterface();

    void addition() {
        System.out.println(Strings.INPUT_TWO_NUMBERS + Strings.SUM_UP);
        double expression[] = calculatorInterface.calculatorInputs();
        double outcome = expression[0] + expression[1];
        outcome = utils.roundUp(outcome);
        System.out.println(Strings.OUTCOME + outcome);
        userInterface.operations.add(expression[0] + " + " + expression[1] + " = " + outcome + "    " + hour);
    }

    void subtraction(){
        System.out.println(Strings.INPUT_TWO_NUMBERS + Strings.SUBSTRACTION);
        double expression[] = calculatorInterface.calculatorInputs();
        double outcome = expression[0] - expression[1];
        outcome = utils.roundUp(outcome);
        System.out.println(Strings.OUTCOME + outcome);
        userInterface.operations.add(expression[0] + " - " + expression[1] + " = " + outcome + "    " + hour);
    }

    void product() {
        System.out.println(Strings.INPUT_TWO_NUMBERS + Strings.PRODUCT);
        double expression[] = calculatorInterface.calculatorInputs();
        double outcome = expression[0] * expression[1];
        outcome = utils.roundUp(outcome);
        System.out.println(Strings.OUTCOME + outcome);
        userInterface.operations.add(expression[0] + " * " + expression[1] + " = " + outcome + "    " + hour);
    }

    void quotient() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.INPUT_TWO_NUMBERS + Strings.QUOTIENT);
        double expression[] = calculatorInterface.calculatorInputs();
        if (expression[1] == 0) {
            System.out.println(Strings.QUOTIENT_ZERO);
            calculatorInterface.calculatorMenu();
        } else {
            double outcome = expression[0] / expression[1];
            outcome = utils.roundUp(outcome);
            System.out.println(Strings.OUTCOME + outcome);
            userInterface.operations.add(expression[0] + " / " + expression[1] + " = " + outcome + "    " + hour);
        }
    }

    void root() throws ScriptException, IOException, WriteException {
        CalculatorInterface calculatorInterface = new CalculatorInterface();
        System.out.println(Strings.INPUT_ROOT);
        double firstNumber = utils.tryNumberInput();
        System.out.println(Strings.ROOT_LEVEL);
        double secondNumber = utils.tryNumberInput();
        if (secondNumber == 0) {
            System.out.println(Strings.ROOT_ZERO);
            calculatorInterface.calculatorMenu();
        }
        double constant = 1.0;
        double root = constant / secondNumber;
        double outcome = Math.pow(firstNumber, root);
        outcome = utils.roundUp(outcome);
        System.out.println(Strings.OUTCOME + outcome);
        userInterface.operations.add("sqrt[" + secondNumber + "](" + firstNumber + ") = " + outcome + "  " + hour);
    }

    void exponentiation() {
        System.out.println(Strings.INPUT_EXPONENTATION);
        double firstNumber = utils.tryNumberInput();
        System.out.println(Strings.EXPONENTATION_LEVEL);
        double secondNumber = utils.tryNumberInput();
        double outcome = Math.pow(firstNumber, secondNumber);
        outcome = utils.roundUp(outcome);
        System.out.println(Strings.OUTCOME + outcome);
        userInterface.operations.add(firstNumber + "^" + secondNumber + " = " + outcome + "  " + hour);
    }

    void userInputOperations() throws ScriptException {
        System.out.println(Strings.EXPONENTATION_LEVEL);
        ScriptEngineManager scriptEngine = new ScriptEngineManager();
        ScriptEngine calculatorEngine = scriptEngine.getEngineByName("JavaScript");
        String operation;
        operation = reader.nextLine();
        System.out.println(Strings.OUTCOME + calculatorEngine.eval(operation));
        String advancedOutcome;
        advancedOutcome = String.valueOf(calculatorEngine.eval(operation));
        userInterface.operations.add(operation + "=" + advancedOutcome + "  " + hour);
    }

    void operationsReadFromExcel() throws IOException {
        ReadExcel readExcel = new ReadExcel();
        readExcel.setInputFile("input.xls");
        readExcel.read();
    }
}
