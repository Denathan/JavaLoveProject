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

    private static void calculatorMenu() {
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

        checkCalculatorOption();
        double a, b, wynik;

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
                endOrNot();
                break;
            case ("6"):
                System.out.println("Podaj liczbę którą chcesz podnieść do potęgi.");
                a = input.nextDouble();
                System.out.println("Podaj potęgę.");
                b = input.nextDouble();
                wynik = Math.pow(a, b);
                System.out.println("Liczba "+ a +" podniesiona do potegi "+ b +" to "+ wynik);
                endOrNot();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Wybierz 1, 2, 3, 4, 5 lub 6.");
                calculatorMenu();
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
                System.out.println("Nieprawidłowy wybór. Wpisz start lub end.");
                endOrNot();
        }
    }
}
