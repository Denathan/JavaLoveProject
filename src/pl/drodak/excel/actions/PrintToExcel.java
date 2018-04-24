package pl.drodak.excel.actions;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import pl.drodak.user.experience.UserInterface;
import pl.drodak.utils.Strings;

import java.io.File;
import java.io.IOException;

public class PrintToExcel {
    public void print() throws IOException, WriteException {
        UserInterface userInterface = new UserInterface();
        File file = new File("output.xls");
        WritableWorkbook workbook;
        workbook = Workbook.createWorkbook(file);
        WritableSheet wsheet = workbook.createSheet("First Sheet", 0);
        int row = 0;
        for (String str : userInterface.operations) {
            wsheet.addCell(new Label(0, row, str));
            row++;
        }
        workbook.write();
        workbook.close();
        System.out.println(Strings.PRINT_SUCCESS);
    }
}
