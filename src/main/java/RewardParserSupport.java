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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Objects.hash;

public class RewardParserSupport {

    public static final String goodRewardInfo = "\n" +
            "{\n" +
            "    \"title\": \"Hi，%s！官方薯承诺的流量奖励，来咯~\",\n" +
            "    \"content\": \"感谢您热诚的参与到官方薯组织的活动中来，也恭喜您的分享被广大的小红薯们认可。基于游戏的规则，我们特此奉上约定好的流量奖励。还希望您能继续在小红书分享哦~\",\n" +
            "    \"button1title\": \"点击领取奖励\",\n" +
            "    \"button1link\": \"https://www.xiaohongshu.com/picasso_pages/author-center/official-boost?fullscreen=true\",\n" +
            "    \"button2title\": \"\",\n" +
            "    \"button2link\": \"\",\n" +
            "    \"token\": \"\"\n" +
            "}";

    public static final String virusExpansionInfo = "{\n" +
            "    \"title\": \"Hi，%s！官方薯承诺的流量奖励，来咯~\",\n" +
            "    \"content\": \"感谢您或您的朋友，参与官方薯组织的邀好友分享活动。官方薯期待您与您的好友，继续在小红书分享您的生活哦~\",\n" +
            "    \"button1title\": \"点击领取奖励\",\n" +
            "    \"button1link\": \"https://www.xiaohongshu.com/picasso_pages/author-center/official-boost?fullscreen=true\",\n" +
            "    \"button2title\": \"\",\n" +
            "    \"button2link\": \"\",\n" +
            "    \"token\": \"\"\n" +
            "}";


    private static final String path = "/Users/luwenyang/Downloads/自动化促产/";

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

    private static String constructSenderInfo(String messageFile, String tagName) throws Exception {
        String senderInfo = "";
        String senderId = "";
        String title = "";
        String content = "";
        String button1title = "";
        String button1link = "";
        String button2title = "";
        String button2link = "";
        JSONObject messageJson = new JSONObject();
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

//              0 活动名	1垂类	2负责人	3标题	4消息正文	5按钮1标题	6按钮1链接	7按钮2标题	8按钮2链接	9促产数据链接	10官方号（默认薯队长）	11开始日期	12结束日期
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    Row valueRow = sheet.getRow(i);
                    if (!getCellValue(valueRow.getCell(0), true).contains(tagName)) {
                        continue;
                    }
                    senderId = getCellValue(valueRow.getCell(10), true);
                    title = getCellValue(valueRow.getCell(3), true);
                    content = getCellValue(valueRow.getCell(4), true);
                    button1title = getCellValue(valueRow.getCell(5), true);
                    button1link = getCellValue(valueRow.getCell(6), true);
                    button2title = getCellValue(valueRow.getCell(7), true);
                    button2link = getCellValue(valueRow.getCell(8), true);


                    messageJson.put("title", title);
                    messageJson.put("content", content);
                    messageJson.put("button1title", button1title);
                    messageJson.put("button1link", button1link);
                    messageJson.put("button2title", button2title);
                    messageJson.put("button2link", button2link);
                    messageJson.put("token", "");
                    break;
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

        messageJson.put("title", title);
        messageJson.put("content", content);
        messageJson.put("button1title", button1title);
        messageJson.put("button1link", button1link);
        messageJson.put("button2title", button2title);
        messageJson.put("button2link", button2link);
        messageJson.put("token", "");

        senderInfo = "male___" + senderId + "___" + messageJson.toJSONString();
        return senderInfo;
    }


    public static void main(String[] args) {

        int threshold = 0;
        int stepsize = 3000;
        String userRewardFile = "活动名单/brompton081602";
        Set<String> opNames = new HashSet<>(Arrays.asList(
                "brompton"
        ));
        String messageFile = "活动文案.xlsx";
        String senderInfoStr = "";
        for (String opName : opNames) {
            threshold = 0;
            try {
                senderInfoStr = constructSenderInfo(messageFile, opName);
//                senderInfoStr = "male___62b2c862000000001501cbb5___"+goodRewardInfo;
                String[] senderInfo = senderInfoStr.split("___");
                String senderId = senderInfo[1];
                String opInfoStr = senderInfo[2];
                JSONObject opInfo = JSON.parseObject(opInfoStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Set<String> userIdSet = new HashSet<>();
            while (threshold < 100000) {
                JSONObject request = new JSONObject();
                String activityId = "8";
                try {

                    JSONObject requestBody = new JSONObject();
                    request.put("request", requestBody);

                    requestBody.put("senderId", senderInfoStr);
                    requestBody.put("activityId", activityId);
                    List<JSONObject> rewardUserInfos = new ArrayList<>();
                    requestBody.put("rewardUserInfos", rewardUserInfos);

                    BufferedReader reader = new BufferedReader(new FileReader(path + userRewardFile + ".csv"));//换成你的文件名
//                reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
                    String line = null;
                    int cnt = 0;
                    while ((line = reader.readLine()) != null) {
                        try {
                            if (cnt < threshold) {
                                cnt++;
                                continue;
                            }
                            line = line.replace("\"", "");
                            String items[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                            JSONObject rewardUserInfo = new JSONObject();
                            if (userIdSet.contains(items[0]) || Constants.bossIdSet.contains(items[0])) {
                                continue;
                            }
                            if (items.length > 1 && !opName.equals(items[1])) {
                                continue;
                            }

                            cnt++;
                            userIdSet.add(items[0]);
                            rewardUserInfo.put("userId", items[0]);
                            rewardUserInfo.put("reward", 0);
                            rewardUserInfos.add(rewardUserInfo);
                            if (cnt >= threshold + stepsize - 1) {
                                break;
                            }
                        } catch (Exception e) {
                            continue;
                        }
                    }

                    if(rewardUserInfos.size()>0){
                        System.out.println(request.toJSONString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                threshold += stepsize;
            }

        }

    }

}

