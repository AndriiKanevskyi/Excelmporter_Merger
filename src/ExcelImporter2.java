//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelImporter2 {
//    public static void main(String[] args) throws IOException {
//        // Создаем новый файл Excel
//        XSSFWorkbook workbook = new XSSFWorkbook();
//
//        // Перебираем все файлы Excel в папке
//        File folder = new File("C:\\Users\\andrii.kanevski\\Desktop\\testyexccell");
//        for (File file : folder.listFiles()) {
//            if (file.isFile() && file.getName().endsWith(".xlsm")) {
//                // Читаем данные из файла Excel
//                FileInputStream fis = new FileInputStream(file);
//                XSSFWorkbook sourceWorkbook = new XSSFWorkbook(fis);
//                Sheet sourceSheet = sourceWorkbook.getSheetAt(0);
//
//                // Создаем новый лист в выходном файле Excel и копируем данные
//                Sheet destSheet = workbook.createSheet(file.getName());
//                copySheet(sourceSheet, destSheet);
//
//                sourceWorkbook.close();
//            }
//        }
//
//        // Сохраняем файл Excel
//        FileOutputStream fos = new FileOutputStream("output_file.xlsx");
//        workbook.write(fos);
//        fos.close();
//    }
//
//    private static void copySheet(Sheet sourceSheet, Sheet destSheet) {
//        int rowNum = 0;
//        for (Row sourceRow : sourceSheet) {
//            Row destRow = destSheet.createRow(rowNum++);
//            for (Cell sourceCell : sourceRow) {
//                Cell destCell = destRow.createCell(sourceCell.getColumnIndex(), sourceCell.getCellType());
//                switch (sourceCell.getCellType()) {
//                    case NUMERIC:
//                        destCell.setCellValue(sourceCell.getNumericCellValue());
//                        break;
//                    case STRING:
//                        destCell.setCellValue(sourceCell.getStringCellValue());
//                        break;
//                    case BOOLEAN:
//                        destCell.setCellValue(sourceCell.getBooleanCellValue());
//                        break;
//                    case FORMULA:
//                        destCell.setCellFormula(sourceCell.getCellFormula());
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
//    }
//}
