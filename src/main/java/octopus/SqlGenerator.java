package octopus;

import com.sun.deploy.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SqlGenerator {

    private static final String INSERT_INTO_OP = "INSERT INTO TABLE redalgo.algo_op_tag partition(dtm = {{ds_nodash}})\n";
    private static final String UNION_ALL = " union all ";
    private static final String SELECT_MAIN_SUB_TAGS = "select \"{first_tag}\" as first_tag, \"{second_tags}\" as second_tags\n";
    private static final String FIRST_TAG = "{first_tag}";
    private static final String SECOND_TAGS = "{second_tags}";

    private static final String generateUpdateOpInfo() {
        StringBuilder sqlBuilder = new StringBuilder();

        return sqlBuilder.toString();
    }

    private static final String path = "/Users/yang/Downloads/";


    private static final String EXTENSION_XLS = "xls";
    private static final String EXTENSION_XLSX = "xlsx";

    /***
     * <pre>
     * 取得Workbook对象(xls和xlsx对象不同,不过都是Workbook的实现类)
     *   xls:HSSFWorkbook
     *   xlsx：XSSFWorkbook
     * @param filePath
     * @return
     * @throws IOException
     * </pre>
     */
    private static Workbook getWorkbook(String filePath) throws IOException {
        Workbook workbook = null;
        InputStream is = new FileInputStream(filePath);
        if (filePath.endsWith(EXTENSION_XLS)) {
            workbook = new HSSFWorkbook(is);
        } else if (filePath.endsWith(EXTENSION_XLSX)) {
            workbook = new XSSFWorkbook(is);
        }
        return workbook;
    }

    /**
     * 文件检查
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws FileFormatException
     */
    private static void preReadCheck(String filePath) throws FileNotFoundException, FileFormatException {
        // 常规检查
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("传入的文件不存在：" + filePath);
        }

        if (!(filePath.endsWith(EXTENSION_XLS) || filePath.endsWith(EXTENSION_XLSX))) {
            throw new FileFormatException("传入的文件不是excel");
        }
    }

    /**
     * 读取excel文件内容
     *
     * @param filePath
     * @throws FileNotFoundException
     * @throws FileFormatException
     */
    public static void readExcel(String filePath) throws FileNotFoundException, FileFormatException {
        // 检查
        preReadCheck(filePath);
        // 获取workbook对象
        Workbook workbook = null;

        try {
            workbook = getWorkbook(filePath);
            // 读文件 一个sheet一个sheet地读取
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                System.out.println("=======================" + sheet.getSheetName() + "=========================");

                int firstRowIndex = sheet.getFirstRowNum();
                int lastRowIndex = sheet.getLastRowNum();

                // 读取首行 即,表头
                Row firstRow = sheet.getRow(firstRowIndex);
                for (int i = firstRow.getFirstCellNum(); i <= firstRow.getLastCellNum(); i++) {
                    Cell cell = firstRow.getCell(i);
                    String cellValue = getCellValue(cell, true);
                    System.out.print(" " + cellValue + "\t");
                }
                System.out.println("");

                // 读取数据行
                for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
                    Row currentRow = sheet.getRow(rowIndex);// 当前行
                    int firstColumnIndex = currentRow.getFirstCellNum(); // 首列
                    int lastColumnIndex = currentRow.getLastCellNum();// 最后一列
                    for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) {
                        Cell currentCell = currentRow.getCell(columnIndex);// 当前单元格
                        String currentCellValue = getCellValue(currentCell, true);// 当前单元格的值
                        System.out.print(currentCellValue + "\t");
                    }
                    System.out.println("");
                }
                System.out.println("======================================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 取单元格的值
     *
     * @param cell       单元格对象
     * @param treatAsStr 为true时，当做文本来取值 (取到的是文本，不会把“1”取成“1.0”)
     * @return
     */
    private static String getCellValue(Cell cell, boolean treatAsStr) {
        if (cell == null) {
            return "";
        }

        if (treatAsStr) {
            // 虽然excel中设置的都是文本，但是数字文本还被读错，如“1”取成“1.0”
            // 加上下面这句，临时把它当做文本来读取
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }

        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return String.valueOf(cell.getStringCellValue());
        }
    }


    private static String generateUpdateOpSql(String dateFilter, boolean isProfessionalOp) throws Exception {
        String messageFile = "八爪鱼促产活动信息.xlsx";
        String insertSqlHead = INSERT_INTO_OP + " {sqlList}";
        List<String> sqlList = new ArrayList<>();
        String filePath = path + messageFile;
        preReadCheck(filePath);
        // 获取workbook对象
        Workbook workbook = null;

        try {
            workbook = getWorkbook(filePath);
            // 读文件 一个sheet一个sheet地读取
            for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
                Sheet sheet = workbook.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                // 限制月份
                if (!("sep_oct".equals(sheet.getSheetName()) ^ isProfessionalOp)) {
                    continue;
                }
                int firstRowIndex = sheet.getFirstRowNum();
                int lastRowIndex = sheet.getLastRowNum();
                if (lastRowIndex < 1) {
                    throw new Exception("message value is wrong");
                }

                // 读取首行 即,表头

//                "0一级类目	1主话题名	2副话题名	3负责人	4开始日期	5结束日期	6私信标题	7私信正文	8按钮1标题	9按钮1链接	10按钮2标题	11按钮2链接"
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    String sqlFormatter = SELECT_MAIN_SUB_TAGS;

                    Row valueRow = sheet.getRow(i);
                    String firstTag = getCellValue(valueRow.getCell(1), true);
                    String secondTags = getCellValue(valueRow.getCell(2), true);
                    String beginDate = getCellValue(valueRow.getCell(4), true);
                    if (beginDate.compareTo(dateFilter) < 0)
                        continue;
                    sqlFormatter = sqlFormatter.replace(FIRST_TAG, firstTag);
                    sqlFormatter = sqlFormatter.replace(SECOND_TAGS, secondTags);
                    sqlList.add(sqlFormatter);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        insertSqlHead = insertSqlHead.replace("{sqlList}", StringUtils.join(sqlList, UNION_ALL));
        return insertSqlHead;
    }


    public static void main(String[] args) {
        System.out.println("\n\n\n\n\n");
        try {
            System.out.println(generateUpdateOpSql("20220929", true));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
