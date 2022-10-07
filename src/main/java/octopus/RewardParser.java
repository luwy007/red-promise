package octopus;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RewardParser {


    private static final Map<String, String> TAX_OPEATOR = new HashMap<>();
    private static final Map<Integer, String> RANDOM_HOUR = new HashMap<>();

    private static final String START_TIME = "supportStartTime";
    private static final String END_TIME = "supportEndTime";
    private static final String QUOTA = "quota";
    private static final String CREATE_BY = "createBy";
    private static final String NOTE_ID = "noteId";
    private static final String TYPE = "type";
    private static final String NOTE_ID_LIST = "noteIdList";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    private static final String FILE_PATH = "/Users/yang/Downloads/";


    static {
        TAX_OPEATOR.put("体育运动", "武庚（钟方亮）");
        TAX_OPEATOR.put("科技数码", "考森（）");
        RANDOM_HOUR.put(0, "08:00:00");
        RANDOM_HOUR.put(1, "09:00:00");
        RANDOM_HOUR.put(2, "10:00:00");
        RANDOM_HOUR.put(3, "11:00:00");
    }

    static class GDPlan {
        String startTime;
        String endTime;
        String noteId;
        int quota;
        String createBy;


        GDPlan(String noteId, String startTime, String endTime, int quota, String createBy) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.createBy = createBy;
            this.quota = quota;
            this.noteId = noteId;
        }

        GDPlan(String noteId, String startTime, float days, int quota, String createBy) {
            this.startTime = startTime;
            try {
                this.endTime = sdf.format(new Date(sdf.parse(startTime).getTime() + (long) (days * 24 * 3600 * 1000L)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.createBy = createBy;
            this.quota = quota;
            this.noteId = noteId;
        }

        String toJson() {
            JSONObject json = new JSONObject();
            json.put(START_TIME, startTime);
            json.put(END_TIME, endTime);
            json.put(NOTE_ID, noteId);
            json.put(QUOTA, quota);
            json.put(CREATE_BY, createBy);
            return json.toJSONString();
        }

        @Override
        public String toString() {
            return toJson();
        }
    }


    static class SoftPlan {
        int impression;
        String line;
        List<String> noteIds;
        String purpose;
        String team;
        String topic;


        SoftPlan(String line, List<String> noteIds, String team) {
            this.line = line;
            this.noteIds = noteIds;
            this.team = team;
            this.purpose = "推笔记";
            this.impression = 300000;
            this.topic = "业务扶持";
        }

        String toJson() {
            JSONObject json = new JSONObject();
            json.put("impression", impression);
            json.put("line", line);
            json.put("noteIds", noteIds);
            json.put("purpose", purpose);
            json.put("team", team);
            json.put("topic", topic);
            json.put("fromRpc", true);
            return json.toJSONString();
        }

        @Override
        public String toString() {
            return toJson();
        }
    }

    static class GDSuggestion {
        List<String> noteIdList;
        String createBy;
        String type;


        GDSuggestion(List<String> noteIdList, String createBy, String type) {
            this.noteIdList = noteIdList;
            this.createBy = createBy;
            this.type = type;
        }

        String toJson() {
            JSONObject json = new JSONObject();
            json.put(CREATE_BY, createBy);
            json.put(NOTE_ID_LIST, noteIdList);
            json.put(TYPE, type);
            return json.toJSONString();
        }

        @Override
        public String toString() {
            return toJson();
        }
    }

    private static List<Object> generateCurlOrders(List<Object> objs) {

        List<Object> curlOrders = objs.stream().map(obj -> generateCurlOrder(obj.toString()))
                .collect(Collectors.toList());
        return curlOrders;

    }

    private static String generateCurlOrder(String jsonParameter) {
        String curlOrder = "curl -X POST -H \"Content-type: application/json\" -H \"Accept: application/json\" -d '{json}' \"http://172.25.80.133:8088/api/rocket/launch/gd/create\"";
//        curlOrder = "curl -X POST -H \"Content-type: application/json\" -H \"Accept: application/json\" -d '{json}' \"http://172.20.70.42:8088/api/rocket/launch/gd/suggest\"";
//        curlOrder = "curl -X POST -H \"Content-type: application/json\" -H \"Accept: application/json\" -d '{json}' \"http://172.20.57.8:8088/api/rocket/launch/project\"";
        curlOrder = curlOrder.replace("{json}", jsonParameter);
        return curlOrder;
    }

    private static List<Object> generateGdPlans(String rewardFile, String defaultTax) {
        File csv = new File(FILE_PATH + rewardFile);
        List<Object> gdPlans = new ArrayList<>();

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            // first line
            String line = textFile.readLine();
            textFile.readLine();
            while ((line = textFile.readLine()) != null) {
                String[] elements = line.replace("\"", "").split(",");
                String userId = elements[0];
                String noteId = elements[1];
                int quota = Integer.parseInt(elements[2]);
                String tax = null;
                if (elements.length > 4)
                    tax = elements[3];
                float days = 1.0f;
                if (quota < 10000) {
                    days = 0.1f;
                } else if (quota < 20000) {
                    days = 0.2f;
                } else if (quota < 30000) {
                    days = 0.3f;
                }

                gdPlans.add(new GDPlan(noteId, getRandomStartTs(), days, quota,
                        StringUtils.isEmpty(defaultTax) ? TAX_OPEATOR.get(tax) : TAX_OPEATOR.get(defaultTax)));

            }

        } catch (Exception e) {
            System.out.println("文件读写出错");
        }


        return gdPlans;


    }

    private static String getRandomStartTs() {
        Long nowTime = (new Date()).getTime();
        String nextDateStr = sdfDate.format(new Date(((new Date()).getTime() + 24 * 3600 * 1000L)));
        int random = (int) (Math.random() * 4);
        return nextDateStr + " " + RANDOM_HOUR.getOrDefault(random, "08:00:00");
    }

    private static List<Object> generateGdSuggestions() {

        List<Object> gdSuggestions = new ArrayList<>();

        gdSuggestions.add(new GDSuggestion(Arrays.asList(), "八戒（卢文羊）", "SMALL"));
        gdSuggestions.add(new GDSuggestion(Arrays.asList(), "八戒（卢文羊）", "SMALL"));


        return gdSuggestions;


    }

    private static List<Object> generateSoftPlan() {

        List<Object> softPlans = new ArrayList<>();

        softPlans.add(new SoftPlan("江阳（方炜嵩）", Arrays.asList("62791f9f000000002103f041"), "发布组"));

        return softPlans;


    }

    public static void main(String[] args) {


        List<Object> objs = generateCurlOrders(generateGdPlans("sports_bonus_0928.csv", "体育运动"));
//        List<Object> objs = generateCurlOrders(generateGdSuggestions());
//        List<Object> objs = generateCurlOrders(generateSoftPlan());
        objs.stream().forEach(order -> System.out.println(order));
    }
}
