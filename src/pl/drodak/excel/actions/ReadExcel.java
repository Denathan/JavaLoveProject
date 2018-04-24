package pl.drodak.excel.actions;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pl.drodak.user.experience.UserInterface;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadExcel {
    private String inputFile;
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");
    private Date date = new Date();
    private String hour = df.format(date);

    public ReadExcel() {
        this.inputFile = inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void read() throws IOException {
        UserInterface userInterface = new UserInterface();
        File inputWorkbook = new File(inputFile);
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            Workbook wb = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = wb.getSheet(0);
            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    String FirstRowFirstColumn = cell.getContents();
                    String wynik = String.valueOf(engine.eval(FirstRowFirstColumn));
                    System.out.println("Wynik " + FirstRowFirstColumn + " to: " + wynik);
                    userInterface.operations.add(FirstRowFirstColumn + "=" + wynik + "  " + hour);
                }
            }
        } catch (BiffException | ScriptException e) {
            e.printStackTrace();
        }
    }
}
