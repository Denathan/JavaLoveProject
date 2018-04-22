package pl.drodak;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static String userChoice;
    private static Scanner reader = new Scanner(System.in);
    static List<String> operations = new ArrayList<>();

    public static void main(String[] args) throws ScriptException, IOException, WriteException {
        mainMenu();
    }

    private static void mainMenu() throws ScriptException, IOException, WriteException {
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

    private static void checkCalculatorOption() {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.CHOOSE_OPTION.toString());
        userChoice = reader.nextLine();
    }

    private static double tryFirstNumber() {
        Scanner input = new Scanner(System.in);
        double firstNumber = 0;
        try {
            firstNumber = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Musisz podać liczbę!");
            calculatorInputs();
        }
        return firstNumber;
    }

    private static double trySecondNumber() {
        Scanner input = new Scanner(System.in);
        double secondNumber = 0;
        try {
            secondNumber = input.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Musisz podać liczbę!");
            calculatorInputs();
        }
        return secondNumber;
    }

    private static double[] calculatorInputs() {
        double firstNumber, secondNumber;
        System.out.println("Podaj pierwszą liczbę");
        firstNumber = tryFirstNumber();
        System.out.println("Podaj drugą liczbę");
        secondNumber = trySecondNumber();
        return new double[]{firstNumber, secondNumber};
    }

    private static double roundUp(double outcome) {
        double rounding = outcome;
        rounding *= 100;
        rounding = Math.round(rounding);
        rounding /= 100;
        return rounding;
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

        checkCalculatorOption();
        double firstNumber, secondNumber, outcome;
        double expression[];
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        String hour = df.format(date);

        switch (userChoice) {
            case ("1"):
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "zsumowania");
                expression = calculatorInputs();
                outcome = expression[0] + expression[1];
                outcome = roundUp(outcome);
                System.out.println(Strings.NEXT_LINE.toString() + "Suma" + Strings.OUTCOME.toString() + outcome);
                operations.add(expression[0] + " + " + expression[1] + " = " + outcome + "    " + hour);
                endOrNot();
                break;
            case ("2"):
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "odjęcia");
                expression = calculatorInputs();
                outcome = expression[0] - expression[1];
                outcome = roundUp(outcome);
                System.out.println(Strings.NEXT_LINE.toString() + "Różnica" + Strings.OUTCOME.toString() + outcome);
                operations.add(expression[0] + " - " + expression[1] + " = " + outcome + "    " + hour);
                endOrNot();
                break;
            case ("3"):
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "pomnożenia");
                expression = calculatorInputs();
                outcome = expression[0] * expression[1];
                outcome = roundUp(outcome);
                System.out.println(Strings.NEXT_LINE.toString() + "Iloczyn" + Strings.OUTCOME.toString() + outcome);
                operations.add(expression[0] + " * " + expression[1] + " = " + outcome + "    " + hour);
                endOrNot();
                break;
            case ("4"):
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INPUT_TWO_NUMBERS.toString() + "podzielenia");
                expression = calculatorInputs();
                if (expression[1] == 0) {
                    System.out.println(Strings.NEXT_LINE.toString() + "!!!Nie dzielimy przez 0!!!");
                    calculatorMenu();
                } else {
                    outcome = expression[0] / expression[1];
                    outcome = roundUp(outcome);
                    System.out.println(Strings.NEXT_LINE.toString() + "Iloraz" + Strings.OUTCOME.toString() + outcome);
                    operations.add(expression[0] + " / " + expression[1] + " = " + outcome + "    " + hour);
                    endOrNot();
                }
                break;
            case ("5"):
                System.out.println(Strings.NEXT_LINE.toString() + "Podaj liczbę z której chcesz policzyć pierwiastek.");
                firstNumber = tryFirstNumber();
                System.out.println("Podaj stopień pierwiastka.");
                secondNumber = trySecondNumber();
                if (secondNumber == 0) {
                    System.out.println("Stopień nie może być 0!");
                    calculatorMenu();
                }
                double constant = 1.0;
                double root = constant / secondNumber;
                outcome = Math.pow(firstNumber, root);
                outcome = roundUp(outcome);
                System.out.println(Strings.NEXT_LINE.toString() + "Pierwiatek " + secondNumber + "-ego stopnia z liczby " + firstNumber + " to " + outcome);
                operations.add("sqrt[" + secondNumber + "](" + firstNumber + ") = " + outcome + "  " + hour);
                endOrNot();
                break;
            case ("6"):
                System.out.println(Strings.NEXT_LINE.toString() + "Podaj liczbę którą chcesz podnieść do potęgi.");
                firstNumber = tryFirstNumber();
                System.out.println("Podaj potęgę.");
                secondNumber = trySecondNumber();
                outcome = Math.pow(firstNumber, secondNumber);
                outcome = roundUp(outcome);
                System.out.println(Strings.NEXT_LINE.toString() + "Liczba " + firstNumber + " podniesiona do potegi " + secondNumber + " to " + outcome);
                operations.add(firstNumber + "^" + secondNumber + " = " + outcome + "  " + hour);
                endOrNot();
                break;
            case ("7"):
                System.out.println(Strings.NEXT_LINE.toString() + "Wpisz działanie.");
                ScriptEngineManager scriptEngine = new ScriptEngineManager();
                ScriptEngine calculatorEngine = scriptEngine.getEngineByName("JavaScript");
                String operation;
                operation = reader.nextLine();
                System.out.println(Strings.NEXT_LINE.toString() + "Wynik działania to: " + calculatorEngine.eval(operation));
                String advancedOutcome;
                advancedOutcome = String.valueOf(calculatorEngine.eval(operation));
                operations.add(operation + "=" + advancedOutcome + "  " + hour);
                endOrNot();
                break;
            case ("8"):
                ReadExcel readExcel = new ReadExcel();
                readExcel.setInputFile("input.xls");
                readExcel.read();
                endOrNot();
                break;
            default:
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INCORRECT_CHOICE.toString());
                calculatorMenu();
        }
    }

    private static void print() throws IOException, WriteException {
        File file = new File("output.xls");
        WritableWorkbook workbook;
        workbook = Workbook.createWorkbook(file);
        WritableSheet wsheet = workbook.createSheet("First Sheet", 0);
        int row = 0;
        for (String str : operations) {
            wsheet.addCell(new Label(0, row, str));
            row++;
        }
        workbook.write();
        workbook.close();
        System.out.println("Wydrukowano do pliku." + Strings.NEXT_LINE.toString());
    }

    private static void endOrNot() throws ScriptException, IOException, WriteException {
        System.out.println(Strings.NEXT_LINE.toString() + Strings.STARS.toString());
        System.out.println("*                 MENU                 *");
        System.out.println(Strings.STARS.toString());
        System.out.println("1. Powrót do początku");
        System.out.println("2. Uzyskaj historię wykonanych operacji");
        System.out.println("3. Eksportuj działania do pliku");
        System.out.println("4. Zakończyć działanie programu");
        userChoice = reader.nextLine();
        switch (userChoice) {
            case ("1"):
                mainMenu();
                break;
            case ("2"):
                System.exit(0);
                break;
            case ("3"):
                System.out.println(operations);
                endOrNot();
                break;
            case ("4"):
                print();
                endOrNot();
                break;
            default:
                System.out.println(Strings.NEXT_LINE.toString() + Strings.INCORRECT_CHOICE.toString());
                endOrNot();
        }
    }
}