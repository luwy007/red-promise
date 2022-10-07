import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SQLParser {
    public static final String goodRewardInfo = "\n" +
            "{\n" +
            "    \"title\": \"Hi，%s！玩家薯承诺的流量奖励，来咯~\",\n" +
            "    \"content\": \"感谢您热诚的参与到玩家薯组织的活动中来，也恭喜您的分享被广大的小红薯们认可。基于游戏的规则，我们特此奉上约定好的流量奖励。还希望您能继续在小红书分享哦~\",\n" +
            "    \"button1title\": \"点击领取奖励\",\n" +
            "    \"button1link\": \"https://www.xiaohongshu.com/picasso_pages/author-center/official-boost?fullscreen=true\",\n" +
            "    \"button2title\": \"\",\n" +
            "    \"button2link\": \"\",\n" +
            "    \"token\": \"\"\n" +
            "}";

    String messageTemplate = "{\n" +
            "    \"title\": \"Hi，%S。小红书千万流量助推“飞盘”分享啦，快到群里来~\",\n" +
            "    \"content\": \"春来了，万物复苏~ 潮流薯诚邀大家来小红书分享自己的飞盘生活，亲近自然，感受盎然生机与活力。进群发现与你有同好的朋友，更有流量助力分享飞盘生活，飞盘装备、线下活动、盘友飒爽英姿统统都可以。快快加入群聊，下一位飞盘达人就是你\",\n" +
            "    \"button1title\": \"先进群\",\n" +
            "    \"button1link\": \"xhsdiscover://message/groupChatMiddlePage?id=788289258506792960&is_batch_id=true\",\n" +
            "    \"button2title\": \"再领券\",\n" +
            "    \"button2link\": \"https://www.xiaohongshu.com/picasso_pages/author-center/official-boost?fullscreen=true\",\n" +
            "    \"token\": \"\"\n" +
            "}";

    private static final String path = "/Users/luwenyang/Downloads/运营增长归档/";


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



    private static String constructGroupInfoSql(String dateFilter) throws Exception {
        String messageFile = "message template.xlsx";
        String insertSqlHead = "INSERT INTO TABLE redalgo.algo_op_group_info partition(dtm={{ds_nodash}})\n" +
                "SELECT start_date,\n" +
                "       end_date,\n" +
                "       group_id,\n" +
                "       group_name,\n" +
                "       op_tag\n" +
                "FROM\n" +
                "  ( {sqlList} ) a";
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
                if (!"message template".equals(sheet.getSheetName())) {
                    continue;
                }
                int firstRowIndex = sheet.getFirstRowNum();
                int lastRowIndex = sheet.getLastRowNum();
                if (lastRowIndex < 1) {
                    throw new Exception("message value is wrong");
                }

                // 读取首行 即,表头

//                "0 群主id	1群主昵称	2群名	3进群标题（20个字）	4进群正文（140字）	5主话题	6负责人	7相关话题	8群跳转链接	9群id	10开始日期	11结束日期"
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    String sqlFormatter = " select \"{group_name}\" as group_name, \"{group_id}\" as group_id, \"{begin_date}\" as start_date, \"{end_date}\" as end_date, \"{op_name}\" as op_tag ";

                    Row valueRow = sheet.getRow(i);
                    String groupId = getCellValue(valueRow.getCell(9), true);
                    String groupName = getCellValue(valueRow.getCell(2), true);
                    String beginDate = getCellValue(valueRow.getCell(10), true);
                    String endDate = getCellValue(valueRow.getCell(11), true);
                    String opName = getCellValue(valueRow.getCell(5), true);
                    if(beginDate.compareTo(dateFilter)<0)
                        continue;
                    sqlFormatter = sqlFormatter.replace("{group_id}", groupId);
                    sqlFormatter = sqlFormatter.replace("{group_name}", opName);
                    sqlFormatter = sqlFormatter.replace("{begin_date}", beginDate);
                    sqlFormatter = sqlFormatter.replace("{end_date}", endDate);
                    sqlFormatter = sqlFormatter.replace("{op_name}", opName);


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
        insertSqlHead = insertSqlHead.replace("{sqlList}", StringUtils.join(sqlList, " union all "));
        return insertSqlHead;
    }


    public static void main(String[] args) {

        try {
            System.out.println(constructGroupInfoSql("20220421"));
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
