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
    private static double firstNumber, secondNumber, outcome;
    private static double expression[];
    private static DateFormat df = new SimpleDateFormat("hh:mm:ss");
    private static Date date = new Date();
    private static String hour = df.format(date);
    static Scanner reader = new Scanner(System.in);

    static void calculatorMenu() throws ScriptException, IOException, WriteException {
        switch (UserInterface.checkCalculatorOption()) {
            case ("1"):
                addition();
                UserInterface.endOrNot();
                break;
            case ("2"):
                subtraction();
                UserInterface.endOrNot();
                break;
            case ("3"):
                product();
                break;
            case ("4"):
                quotient();
                break;
            case ("5"):
                root();
                break;
            case ("6"):
                exponentiation();
                break;
            case ("7"):
                userInputOperations();
                break;
            case ("8"):
                operationsReadFromExcel();
                break;
            default:
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INCORRECT_CHOICE.toString());
                calculatorMenu();
        }
    }

    private static void addition() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "zsumowania");
        expression = UserInterface.calculatorInputs();
        outcome = expression[0] + expression[1];
        outcome = Utils.roundUp(outcome);
        System.out.println(Strings.NEXT_LINE.toString() + "Suma" + Strings.OUTCOME.toString() + outcome);
        UserInterface.operations.add(expression[0] + " + " + expression[1] + " = " + outcome + "    " + hour);
        UserInterface.endOrNot();
    }

    private static void subtraction() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "odjęcia");
        expression = UserInterface.calculatorInputs();
        outcome = expression[0] - expression[1];
        outcome = Utils.roundUp(outcome);
        System.out.println(Strings.NEXT_LINE.toString() + "Różnica" + Strings.OUTCOME.toString() + outcome);
        UserInterface.operations.add(expression[0] + " - " + expression[1] + " = " + outcome + "    " + hour);
        UserInterface.endOrNot();
    }

    private static void product() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "pomnożenia");
        expression = UserInterface.calculatorInputs();
        outcome = expression[0] * expression[1];
        outcome = Utils.roundUp(outcome);
        System.out.println(Strings.NEXT_LINE.toString() + "Iloczyn" + Strings.OUTCOME.toString() + outcome);
        UserInterface.operations.add(expression[0] + " * " + expression[1] + " = " + outcome + "    " + hour);
        UserInterface.endOrNot();
    }

    private static void quotient() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "podzielenia");
        expression = UserInterface.calculatorInputs();
        if (expression[1] == 0) {
            System.out.println(Strings.NEXT_LINE.toString() + "!!!Nie dzielimy przez 0!!!");
            calculatorMenu();
        } else {
            outcome = expression[0] / expression[1];
            outcome = Utils.roundUp(outcome);
            System.out.println(Strings.NEXT_LINE.toString() + "Iloraz" + Strings.OUTCOME.toString() + outcome);
            UserInterface.operations.add(expression[0] + " / " + expression[1] + " = " + outcome + "    " + hour);
            UserInterface.endOrNot();
        }
    }

    private static void root() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + "Podaj liczbę z której chcesz policzyć pierwiastek.");
        firstNumber = Utils.tryFirstNumber();
        System.out.println("Podaj stopień pierwiastka.");
        secondNumber = Utils.trySecondNumber();
        if (secondNumber == 0) {
            System.out.println("Stopień nie może być 0!");
            calculatorMenu();
        }
        double constant = 1.0;
        double root = constant / secondNumber;
        outcome = Math.pow(firstNumber, root);
        outcome = Utils.roundUp(outcome);
        System.out.println(Strings.NEXT_LINE.toString() + "Pierwiatek " + secondNumber + "-ego stopnia z liczby " + firstNumber + " to " + outcome);
        UserInterface.operations.add("sqrt[" + secondNumber + "](" + firstNumber + ") = " + outcome + "  " + hour);
        UserInterface.endOrNot();
    }

    private static void exponentiation() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + "Podaj liczbę którą chcesz podnieść do potęgi.");
        firstNumber = Utils.tryFirstNumber();
        System.out.println("Podaj potęgę.");
        secondNumber = Utils.trySecondNumber();
        outcome = Math.pow(firstNumber, secondNumber);
        outcome = Utils.roundUp(outcome);
        System.out.println(Strings.NEXT_LINE.toString() + "Liczba " + firstNumber + " podniesiona do potegi " + secondNumber + " to " + outcome);
        UserInterface.operations.add(firstNumber + "^" + secondNumber + " = " + outcome + "  " + hour);
        UserInterface.endOrNot();
    }

    private static void userInputOperations() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + "Wpisz działanie.");
        ScriptEngineManager scriptEngine = new ScriptEngineManager();
        ScriptEngine calculatorEngine = scriptEngine.getEngineByName("JavaScript");
        String operation;
        operation = reader.nextLine();
        System.out.println(Strings.NEXT_LINE.toString() + "Wynik działania to: " + calculatorEngine.eval(operation));
        String advancedOutcome;
        advancedOutcome = String.valueOf(calculatorEngine.eval(operation));
        UserInterface.operations.add(operation + "=" + advancedOutcome + "  " + hour);
        UserInterface.endOrNot();
    }

    private static void operationsReadFromExcel() throws ScriptException, IOException, WriteException {
        ReadExcel readExcel = new ReadExcel();
        readExcel.setInputFile("input.xls");
        readExcel.read();
        UserInterface.endOrNot();
    }
}
