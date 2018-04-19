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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String pierwszyWybor, kalkulatorWybor;
    private static Scanner reader = new Scanner(System.in);
    static List<String> operacje = new ArrayList<>();

    public static void main(String[] args) throws ScriptException, IOException, WriteException {
        menu();
    }

    private static void menu() throws ScriptException, IOException, WriteException {
        System.out.println("****************************************");
        System.out.println("*             I LOVE JAVA              *");
        System.out.println("****************************************");
        System.out.println("1. Hello World");
        System.out.println("2. Kalkulator");
        userInput();
        checkOption();
    }

    private static void userInput() {
        System.out.println("\nWybierz opcję: ");
        pierwszyWybor = reader.nextLine();
    }

    private static void checkOption() throws ScriptException, IOException, WriteException {
        String n;
        switch (pierwszyWybor) {
            case ("1"):
                System.out.println("\n****************************************");
                System.out.println("*             Hello World              *");
                System.out.println("****************************************\n");
                System.out.println("Wpisz quit aby powrócić do menu.");
                n = reader.nextLine();
                if (n.equals("quit")) {
                    menu();
                } else {
                    System.out.println("\nNieprawidłowy wybór. Wpisz quit.");
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
                System.out.println("\nNieprawidłowy wybór. Wybierz 1 lub 2.");
                menu();
        }
    }

    private static void checkCalculatorOption() {
        System.out.println("\nWybierz opcję: ");
        kalkulatorWybor = reader.nextLine();
    }

    private static double[] prosteOperacje() {
        double a, b;
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę");
        a = input.nextDouble();
        System.out.println("Podaj drugą liczbę");
        b = input.nextDouble();
        return new double[]{a, b};
    }

    private static double zaokraglij(double wynik) {
        double zaokraglenie = wynik;
        zaokraglenie *= 100;
        zaokraglenie = Math.round(zaokraglenie);
        zaokraglenie /= 100;
        return zaokraglenie;
    }


    private static void calculatorMenu() throws ScriptException, IOException, WriteException {
        Scanner input = new Scanner(System.in);
        System.out.println("\n****************************************");
        System.out.println("*                 MENU                 *");
        System.out.println("****************************************");
        System.out.println("1. Suma");
        System.out.println("2. Różnica");
        System.out.println("3. Iloczyn");
        System.out.println("4. Iloraz");
        System.out.println("5. Pierwiastek n-tego stopnia");
        System.out.println("6. Potęga");
        System.out.println("7. Proste działanie wpisane przez Ciebie");
        System.out.println("8. Wczytaj z pliku");

        checkCalculatorOption();
        double a, b, wynik;
        double wyrazenie[];
        String aSt, bSt, wynikSt;
        DateFormat df = new SimpleDateFormat("hh:mm:ss");
        Date date = new Date();
        String hour = df.format(date);

        switch (kalkulatorWybor) {
            case ("1"):
                System.out.println("\nPodaj dwie liczby do zsumowania");
                wyrazenie = prosteOperacje();
                wynik = wyrazenie[0] + wyrazenie[1];
                wynik = zaokraglij(wynik);
                System.out.println("\nSuma liczb wynosi " + wynik);
                aSt = String.valueOf(wyrazenie[0]);
                bSt = String.valueOf(wyrazenie[1]);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + " + " + bSt + " = " + wynikSt + "    " + hour);
                endOrNot();
                break;
            case ("2"):
                System.out.println("\nPodaj dwie liczby do odjęcia");
                wyrazenie = prosteOperacje();
                wynik = wyrazenie[0] - wyrazenie[1];
                wynik = zaokraglij(wynik);
                System.out.println("\nRóżnica liczb wynosi " + wynik);
                aSt = String.valueOf(wyrazenie[0]);
                bSt = String.valueOf(wyrazenie[1]);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + " - " + bSt + " = " + wynikSt + "    " + hour);
                endOrNot();
                break;
            case ("3"):
                System.out.println("\nPodaj dwie liczby do pomnożenia");
                wyrazenie = prosteOperacje();
                wynik = wyrazenie[0] * wyrazenie[1];
                wynik = zaokraglij(wynik);
                System.out.println("\nIloczyn liczb wynosi " + wynik);
                aSt = String.valueOf(wyrazenie[0]);
                bSt = String.valueOf(wyrazenie[1]);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + " * " + bSt + " = " + wynikSt + "    " + hour);
                endOrNot();
                break;
            case ("4"):
                System.out.println("\nPodaj dwie liczby do podzielenia");
                wyrazenie = prosteOperacje();
                if (wyrazenie[1] == 0) {
                    System.out.println("\n!!!Nie dzielimy przez 0!!!");
                    calculatorMenu();
                } else {
                    wynik = wyrazenie[0] / wyrazenie[1];
                    wynik = zaokraglij(wynik);
                    System.out.println("\nIloraz liczb wynosi " + wynik);
                    aSt = String.valueOf(wyrazenie[0]);
                    bSt = String.valueOf(wyrazenie[1]);
                    wynikSt = String.valueOf(wynik);
                    operacje.add(aSt + " / " + bSt + " = " + wynikSt + "    " + hour);
                    endOrNot();
                }
                break;
            case ("5"):
                System.out.println("\nPodaj liczbę z której chcesz policzyć pierwiastek.");
                a = input.nextDouble();
                System.out.println("Podaj stopień pierwiastka.");
                b = input.nextDouble();
                double c = 1.0;
                double stopien = c / b;
                wynik = Math.pow(a, stopien);
                wynik = zaokraglij(wynik);
                System.out.println("\nPierwiatek " + b + "-ego stopnia z liczby " + a + " to " + wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add("sqrt[" + bSt + "](" + aSt + ") = " + wynikSt + "  " + hour);
                endOrNot();
                break;
            case ("6"):
                System.out.println("\nPodaj liczbę którą chcesz podnieść do potęgi.");
                a = input.nextDouble();
                System.out.println("Podaj potęgę.");
                b = input.nextDouble();
                wynik = Math.pow(a, b);
                wynik = zaokraglij(wynik);
                System.out.println("\nLiczba " + a + " podniesiona do potegi " + b + " to " + wynik);
                aSt = String.valueOf(a);
                bSt = String.valueOf(b);
                wynikSt = String.valueOf(wynik);
                operacje.add(aSt + "^" + bSt + " = " + wynikSt + "  " + hour);
                endOrNot();
                break;
            case ("7"):
                System.out.println("\nWpisz działanie.");
                ScriptEngineManager mgr = new ScriptEngineManager();
                ScriptEngine engine = mgr.getEngineByName("JavaScript");
                String foo;
                foo = reader.nextLine();
                System.out.println("\nWynik działania to: " + engine.eval(foo));
                aSt = String.valueOf(foo);
                wynikSt = String.valueOf(engine.eval(foo));
                operacje.add(aSt + "=" + wynikSt + "  " + hour);
                endOrNot();
                break;
            case ("8"):
                ReadExcel excel = new ReadExcel();
                excel.setInputFile("input.xls");
                excel.read();
                endOrNot();
                break;
            default:
                System.out.println("\nNieprawidłowy wybór. Wybierz 1, 2, 3, 4, 5, 6 lub 7.");
                calculatorMenu();
        }
    }

    private static void print() throws IOException, WriteException {
        File file = new File("output.xls");
        WritableWorkbook wworkbook;
        wworkbook = Workbook.createWorkbook(file);
        WritableSheet wsheet = wworkbook.createSheet("First Sheet", 0);
        int row = 0;
        for (String str : operacje) {
            wsheet.addCell(new Label(0, row, str));
            row++;
        }
        wworkbook.write();
        wworkbook.close();
        System.out.println("Wydrukowano do pliku.\n");
    }

    private static void endOrNot() throws ScriptException, IOException, WriteException {
        String n;
        System.out.println("\nWpisz start, aby powrócić do początku, historia aby uzyskać historię wykonanych operacji, drukuj by eksportować działania do pliku lub end, aby zakończyć działanie programu.");
        n = reader.nextLine();
        switch (n) {
            case ("start"):
                menu();
                break;
            case ("end"):
                System.exit(0);
                break;
            case ("historia"):
                System.out.println(operacje);
                endOrNot();
                break;
            case ("drukuj"):
                print();
                endOrNot();
                break;
            default:
                System.out.println("\nNieprawidłowy wybór. Wpisz start lub end.");
                endOrNot();
        }
    }
}
