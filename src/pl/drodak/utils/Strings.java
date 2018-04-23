package pl.drodak.utils;

public enum Strings {
    STARS("****************************************"),
    NEXT_LINE("\n"),
    INCORRECT_CHOICE("Nieprawidłowy wybór. Wybierz jedną z opcji dostępnych w menu."),
    CHOOSE_OPTION("Wybierz opcję:"),
    INPUT_TWO_NUMBERS("Podaj dwie liczby do "),
    OUTCOME(" liczb wynosi ");

    private final String text;

    Strings(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}