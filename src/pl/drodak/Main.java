package pl.drodak;

import java.util.Scanner;
import java.util.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
//import  java.io.*;
//import  org.apache.poi.hssf.usermodel.HSSFSheet;
//import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import  org.apache.poi.hssf.usermodel.HSSFRow;

public class Main {
    static String pierwszyWybor, kalkulatorWybor;
    static Scanner reader = new Scanner(System.in);
    static private List<String> operacje = new ArrayList<>();


    public static void main(String[] args) throws ScriptException {
        menu();
    }

    private static void menu() throws ScriptException {
        System.out.println("****************************************");
        System.out.println("*             I LOVE JAVA              *");
        System.out.println("****************************************");
        System.out.println("1. Hello World");
        System.out.println("2. Kalkulator");
        userInput();
        checkOption();
    }

    private static void userInput() {
        System.out.println("Wybierz opcję: ");
        pierwszyWybor = reader.nextLine();
    }

    private static void checkOption() throws ScriptException {
        String n;
        switch (pierwszyWybor) {
            case ("1"):
                System.out.println("Hello World");
                System.out.println("Wpisz quit aby powrócić do menu.");
                n = reader.nextLine();
                if (n.equals("quit")) {
                    menu();
                } else {
                    System.out.println("Nieprawidłowy wybór. Wpisz quit.");
                    checkOption();
                }
                break;
            case ("2"):
                calculatorMenu();
                break;
            case ("end"):
                System.exit(0);
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybierz 1 lub 2.");
                menu();
        }
    }

    private static void checkCalculatorOption() {
        System.out.println("Wybierz opcję: ");
        kalkulatorWybor = reader.nextLine();
    }

    private static void calculatorMenu() throws ScriptException {
        Scanner input = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("*                 MENU                 *");
        System.out.println("****************************************");
        System.out.println("1. Suma");
        System.out.println("2. Różnica");
        System.out.println("3. Iloczyn");
        System.out.println("4. Iloraz");
        System.out.println("5. Pierwiastek n-tego stopnia");
        System.out.println("6. Potęga");
        System.out.println("7. Proste działanie wpisane przez Ciebie");

        checkCalculatorOption();
        double a, b, wynik;
        String aSt, bSt, wynikSt;

        switch (kalkulatorWybor) {
            case ("1"):
                System.out.println("Podaj dwie liczby do zsumowania");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextDouble();
                System.out.println("Podaj drugą liczbę");
                b = input.nextDouble();
                wynik = a + b;
                wynik *= 100;
                wynik = Math.round(wynik);
                wynik /= 100;
                System.out.println("Suma liczb wynosi " + wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + " + " + bSt + " = " + wynikSt);
                endOrNot();
                break;
            case ("2"):
                System.out.println("Podaj dwie liczby do odjęcia");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextDouble();
                System.out.println("Podaj drugą liczbę");
                b = input.nextDouble();
                wynik = a - b;
                wynik *= 100;
                wynik = Math.round(wynik);
                wynik /= 100;
                System.out.println("Różnica liczb wynosi " + wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + " - " + bSt + " = " + wynikSt);
                endOrNot();
                break;
            case ("3"):
                System.out.println("Podaj dwie liczby do pomnożenia");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextDouble();
                System.out.println("Podaj drugą liczbę");
                b = input.nextDouble();
                wynik = a * b;
                wynik *= 100;
                wynik = Math.round(wynik);
                wynik /= 100;
                System.out.println("Iloczyn liczb wynosi " + wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + " * " + bSt + " = " + wynikSt);
                endOrNot();
                break;
            case ("4"):
                System.out.println("Podaj dwie liczby do podzielenia");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextDouble();
                System.out.println("Podaj drugą liczbę");
                b = input.nextDouble();
                if (b == 0) {
                    System.out.println("Nie dzielimy przez 0!");
                    calculatorMenu();
                } else {
                    wynik = a / b;
                    wynik *= 100;
                    wynik = Math.round(wynik);
                    wynik /= 100;
                    System.out.println("Iloraz liczb wynosi " + wynik);
                    aSt = String.valueOf(a);
                    bSt = String.valueOf(b);
                    wynikSt = String.valueOf(wynik);
                    operacje.add(aSt + " / " + bSt + " = " + wynikSt);
                    endOrNot();
                }
                break;
            case ("5"):
                System.out.println("Podaj liczbę z której chcesz policzyć pierwiastek.");
                a = input.nextDouble();
                System.out.println("Podaj stopień pierwiastka.");
                b = input.nextDouble();
                double c = 1.0;
                double stopien = c / b;
                wynik = Math.pow(a, stopien);
                System.out.println("Pierwiatek "+ b +"-ego stopnia z liczby "+ a +" to "+ wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add("sqrt[" + bSt + "](" + aSt + ") = " + wynikSt);
                endOrNot();
                break;
            case ("6"):
                System.out.println("Podaj liczbę którą chcesz podnieść do potęgi.");
                a = input.nextDouble();
                System.out.println("Podaj potęgę.");
                b = input.nextDouble();
                wynik = Math.pow(a, b);
                System.out.println("Liczba "+ a +" podniesiona do potegi "+ b +" to "+ wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + "^" + bSt + " = " + wynikSt);
                endOrNot();
                break;
            case ("7"):
                System.out.println("Wpisz działanie.");
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                String foo;
                foo = reader.nextLine();
                System.out.println("Wynik działania to: " + engine.eval(foo));
                aSt = String.valueOf(foo);
                wynikSt = String.valueOf(engine.eval(foo));
                operacje.add(aSt + " = " + wynikSt);
                endOrNot();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybierz 1, 2, 3, 4, 5, 6 lub 7.");
                calculatorMenu();


        }
    }

    private static void endOrNot() throws ScriptException {
        String n;
        System.out.println("Wpisz start, aby powrócić do początku, historia aby uzyskać historię wykonanych operacji lub end, aby zakończyć działanie programu.");
        n = reader.nextLine();
        switch (n) {
            case ("start"):
                menu();
                break;
            case ("end"):
                System.exit(0);
                break;
            case ("historia"):
                System.out.println(operacje );
                endOrNot();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wpisz start lub end.");
                endOrNot();
        }
    }
}
