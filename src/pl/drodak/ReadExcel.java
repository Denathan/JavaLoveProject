package pl.drodak;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ReadExcel {
    private String inputFile, wynik;
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");
    private Date date = new Date();
    private String hour = df.format(date);

    void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    void read() throws IOException {
        File inputWorkbook = new File(inputFile);
        Workbook wb;
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            wb = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet = wb.getSheet(0);
            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    String FirstRowFirstColumn = cell.getContents();
                    wynik = String.valueOf(engine.eval(FirstRowFirstColumn));
                    System.out.println("Wynik " + FirstRowFirstColumn + " to: " + wynik);
                    Main.operations.add(FirstRowFirstColumn + "=" + wynik + "  " + hour);
                }
            }
        } catch (BiffException | ScriptException e) {
            e.printStackTrace();
        }
    }
}
