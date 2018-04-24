package pl.drodak.utils;

public class Strings {
    public static final String MAIN_MENU = "****************************************\n*             I LOVE JAVA              *" +
            "\n****************************************\n1. Hello World\n2. Kalkulator";
    public static final String CHOOSE_OPTION = "\nWybierz opcję:";
    public static final String HELLO_WORLD_MENU = "\n****************************************\n" +
            "*             Hello World              *\n****************************************\nWpisz quit aby powrócić do menu.";
    public static final String IC_HELLO_WORLD = "\nNieprawidłowy wybór. Wybierz jedną z opcji dostępnych w menu. Wpisz quit.";
    public static final String IC_MAIN_MENU = "\nNieprawidłowy wybór. Wybierz jedną z opcji dostępnych w menu. Wpisz quit. Wybierz 1 lub 2.";
    public static final String CALCULATOR_MENU = "\n****************************************\n" +
            "*                 MENU                 *\n****************************************\n1. Suma\n2. Różnica\n3. Iloczyn" +
            "\n4. Iloraz\n5. Pierwiastek n-tego stopnia\n6. Potęga\n7. Proste działanie wpisane przez Ciebie\n8. Wczytaj z pliku";
    public static final String INPUT_FIRST_NUMBER = "Podaj pierwszą liczbę:";
    public static final String INPUT_SECOND_NUMBER = "Podaj pierwszą liczbę:";
    public static final String END_MENU = "\n****************************************\n" +
            "*                 MENU                 *\n****************************************\n1. Powrót do początku\n" +
            "2. Uzyskaj historię wykonanych operacji\n3. Eksportuj działania do pliku\n4. Zakończ działanie programu";
    public static final String IC_END = "\nNieprawidłowy wybór. Wybierz jedną z opcji dostępnych w menu.";
    public static final String PRINT_SUCCESS = "Wydrukowano do pliku.\n";
    public static final String IC_CALCULATOR_MENU = "\nNieprawidłowy wybór. Wybierz jedną z opcji dostępnych w menu.";
    public static final String INPUT_TWO_NUMBERS = "\nPodaj dwie liczby do ";
    public static final String SUM_UP = "zsumowania";
    public static final String SUBSTRACTION = "odjęcia";
    public static final String PRODUCT = "pomnożenia";
    public static final String QUOTIENT = "podzielenia";
    public static final String OUTCOME = "\nWynik to: ";
    public static final String QUOTIENT_ZERO = "\n!!!Nie dzielimy przez 0!!!";
    public static final String INPUT_ROOT = "\nPodaj liczbę z której chcesz policzyć pierwiastek.";
    public static final String ROOT_LEVEL = "Podaj stopień pierwiastka.";
    public static final String ROOT_ZERO = "Podaj stopień pierwiastka.";
    public static final String INPUT_EXPONENTATION = "\nPodaj liczbę którą chcesz podnieść do potęgi.";
    public static final String EXPONENTATION_LEVEL = "Wpisz działanie.";
    public static final String TRY_NUMBER_ERROR = "Musisz podać liczbę!";



    private final String text;

    Strings(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}