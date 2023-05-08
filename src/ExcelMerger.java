import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelMerger {
    public static void main(String[] args) {
        // Открываем файл Excel
        File excelFile = new File("C:\\Users\\andrii.kanevski\\IdeaProjects\\Vova\\output_file.xlsx");
        try (Workbook workbook = WorkbookFactory.create(excelFile)) {
            // Создаем новый файл Excel
            XSSFWorkbook mergedWorkbook = new XSSFWorkbook();
            // Создаем лист в новом файле
            XSSFSheet mergedSheet = mergedWorkbook.createSheet("MergedSheet");

            int rowIndex = 0;
            // Проходимся по всем листам входного файла
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                // Пропускаем первые 3 строки
                for (int j = 7; j <= sheet.getLastRowNum()-3; j++) {
                    Row row = sheet.getRow(j);
                    if (row != null) {
                        // Создаем новую строку в выходном файле и копируем в нее содержимое строки текущего листа
                        Row mergedRow = mergedSheet.createRow(rowIndex++);
                        for (int k = 0; k < row.getLastCellNum(); k++) {
                            Cell cell = row.getCell(k);
                            if (cell != null) {
                                Cell mergedCell = mergedRow.createCell(k);
                                switch (cell.getCellType()) {
                                    case BOOLEAN:
                                        mergedCell.setCellValue(cell.getBooleanCellValue());
                                        break;
                                    case NUMERIC:
                                        mergedCell.setCellValue(cell.getNumericCellValue());
                                        break;
                                    case STRING:
                                        mergedCell.setCellValue(cell.getStringCellValue());
                                        break;
                                    case FORMULA:
                                        mergedCell.setCellFormula(cell.getCellFormula());
                                        break;
                                    case BLANK:
                                        // Ничего не делаем
                                        break;
                                    default:
                                        mergedCell.setCellValue(cell.toString());
                                }
                            }
                        }
                    }
                }
            }

            // Записываем выходной файл
            try (FileOutputStream fos = new FileOutputStream("C:\\Users\\andrii.kanevski\\IdeaProjects\\Vova\\output_file_merged.xlsx")) {
                mergedWorkbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
