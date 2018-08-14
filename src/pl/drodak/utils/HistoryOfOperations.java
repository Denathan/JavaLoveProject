package pl.drodak.utils;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfOperations {

    private List<String> operations = new ArrayList<String>();

    public HistoryOfOperations(List<String> operations) {
        this.operations = operations;
    }

    public String getOperations() {
        return String.join(", ", this.operations);
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }
}
