package pl.drodak;

import java.util.Scanner;

public class Main {
    static String pierwszyWybor, kalkulatorWybor;
    static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
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

    private static void checkOption() {
        String n;
        switch (pierwszyWybor) {
            case ("1"):
                System.out.println("Hello World");
                System.out.println("Wpisz quit aby powrócić do menu.");
                n = reader.nextLine();
                if (n.equals("quit")) {
                    menu();
                } else {
                    System.out.println("Nieprzewidziany wybór.");
                }
                break;
            case ("2"):
                calculatorMenu();
                break;
            case ("end"):
                System.exit(0);
                break;
            default:
                System.out.println("Nieprzewidziany wybór.");
                menu();
        }
    }

    private static void checkCalculatorOption() {
        System.out.println("Wybierz opcję: ");
        kalkulatorWybor = reader.nextLine();
    }

    private static void calculatorMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("****************************************");
        System.out.println("*                 MENU                 *");
        System.out.println("****************************************");
        System.out.println("1. Suma");
        System.out.println("2. Różnica");
        System.out.println("3. Iloczyn");
        System.out.println("4. Iloraz");

        checkCalculatorOption();
        int a, b, wynik;

        switch (kalkulatorWybor) {
            case ("1"):
                System.out.println("Podaj dwie liczby do zsumowania");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextInt();
                System.out.println("Podaj drugą liczbę");
                b = input.nextInt();
                wynik = a + b;
                System.out.println("Suma liczb wynosi " + wynik);
                endOrNot();
                break;
            case ("2"):
                System.out.println("Podaj dwie liczby do odjęcia");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextInt();
                System.out.println("Podaj drugą liczbę");
                b = input.nextInt();
                wynik = a - b;
                System.out.println("Różnica liczb wynosi " + wynik);
                endOrNot();
                break;
            case ("3"):
                System.out.println("Podaj dwie liczby do pomnożenia");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextInt();
                System.out.println("Podaj drugą liczbę");
                b = input.nextInt();
                wynik = a * b;
                System.out.println("Iloczyn liczb wynosi " + wynik);
                endOrNot();
                break;
            case ("4"):
                System.out.println("Podaj dwie liczby do podzielenia");
                System.out.println("Podaj pierwszą liczbę");
                a = input.nextInt();
                System.out.println("Podaj drugą liczbę");
                b = input.nextInt();
                wynik = a / b;
                System.out.println("Iloraz liczb wynosi " + wynik);
                endOrNot();
                break;
            default:
                System.out.println("Nieprzewidziany wybór.");
        }
    }

    private static void endOrNot() {
        String n;
        System.out.println("Wpisz start, aby powrócić do początku lub end, aby zakończyć działanie programu.");
        n = reader.nextLine();
        switch (n) {
            case ("start"):
                menu();
                break;
            case ("end"):
                System.exit(0);
                break;
            default:
                System.out.println("Nieprzewidziany wybór.");
        }
    }
}
