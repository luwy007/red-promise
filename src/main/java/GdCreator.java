import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class GdCreator {

    private static final String START_TIME = "supportStartTime";
    private static final String END_TIME = "supportEndTime";
    private static final String QUOTA = "quota";
    private static final String CREATE_BY = "createBy";
    private static final String NOTE_ID = "noteId";
    private static final String TYPE = "type";
    private static final String NOTE_ID_LIST = "noteIdList";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

        GDPlan(String noteId, String startTime, int days, int quota, String createBy) {
            this.startTime = startTime;
            try {
                this.endTime = sdf.format(new Date(sdf.parse(startTime).getTime() + days * 24 * 3600 * 1000L));
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
        String curlOrder = "curl -X POST -H \"Content-type: application/json\" -H \"Accept: application/json\" -d '{json}' \"http://172.25.17.105:8088/api/rocket/launch/gd/create\"";
//        curlOrder = "curl -X POST -H \"Content-type: application/json\" -H \"Accept: application/json\" -d '{json}' \"http://172.20.70.42:8088/api/rocket/launch/gd/suggest\"";
//        curlOrder = "curl -X POST -H \"Content-type: application/json\" -H \"Accept: application/json\" -d '{json}' \"http://172.20.57.8:8088/api/rocket/launch/project\"";
        curlOrder = curlOrder.replace("{json}", jsonParameter);
        return curlOrder;
    }


    private static List<Object> generateGdPlans() {

        List<Object> gdPlans = new ArrayList<>();
        gdPlans.add(new GDPlan("625fa47a000000000102b8c2", "2022-05-19 15:00:00", 1, 25034, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62676dd2000000000102b008", "2022-05-19 15:00:00", 1, 26036, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6256ad27000000000102c6ad", "2022-05-19 15:00:00", 1, 26464, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6271384d0000000021039f86", "2022-05-19 15:00:00", 1, 26915, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dd893000000000102fab6", "2022-05-19 15:00:00", 1, 27179, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626c985b00000000210383a7", "2022-05-19 15:00:00", 1, 28861, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62635a2e0000000021039967", "2022-05-19 15:00:00", 1, 29964, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627fb066000000002103ea0f", "2022-05-19 15:00:00", 1, 31069, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dde26000000002103a8a5", "2022-05-19 15:00:00", 1, 31319, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62738dc40000000021036717", "2022-05-19 15:00:00", 1, 31541, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dbf7c000000000102d8a6", "2022-05-19 15:00:00", 1, 32157, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62596c1e000000000102fe81", "2022-05-19 15:00:00", 1, 32522, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62735cf6000000002103b55d", "2022-05-19 15:00:00", 1, 32522, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626bfb03000000000102d187", "2022-05-19 15:00:00", 1, 32948, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6273804d000000000102c049", "2022-05-19 15:00:00", 1, 33032, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6273873e000000000102980d", "2022-05-19 15:00:00", 1, 33444, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("628497320000000001028587", "2022-05-19 15:00:00", 1, 34271, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626216a7000000000102af0d", "2022-05-19 15:00:00", 1, 34525, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62663cea0000000001027a20", "2022-05-19 15:00:00", 1, 34638, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626bc1ef00000000010292ac", "2022-05-19 15:00:00", 1, 34832, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6273177b0000000001027364", "2022-05-19 15:00:00", 1, 35448, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626a23de0000000001028121", "2022-05-19 15:00:00", 1, 35536, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625e74930000000001024be7", "2022-05-19 15:00:00", 1, 36198, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626f33a50000000021035da4", "2022-05-19 15:00:00", 1, 36550, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626f53760000000001028461", "2022-05-19 15:00:00", 1, 36763, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62674ec80000000001027cf4", "2022-05-19 15:00:00", 1, 37217, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6262749a0000000001026415", "2022-05-19 15:00:00", 1, 38692, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6268e1670000000021036929", "2022-05-19 15:00:00", 1, 39259, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627272430000000021034331", "2022-05-19 15:00:00", 1, 39295, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62660b7b000000000102c915", "2022-05-19 15:00:00", 1, 39413, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62749219000000000102ec4b", "2022-05-19 15:00:00", 1, 39718, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dba9c000000002103a143", "2022-05-19 15:00:00", 1, 40176, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626b9a6c0000000021039000", "2022-05-19 15:00:00", 1, 40254, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284a4d5000000000102df87", "2022-05-19 15:00:00", 1, 41770, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627df6880000000021036d99", "2022-05-19 15:00:00", 1, 42385, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284b52400000000010251eb", "2022-05-19 15:00:00", 1, 42581, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6271dcff000000000102ed42", "2022-05-19 15:00:00", 1, 43280, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6269437f000000002103ebcd", "2022-05-19 15:00:00", 1, 43705, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6280ee6c000000000102ccc7", "2022-05-19 15:00:00", 1, 43786, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284e1d5000000002103ee38", "2022-05-19 15:00:00", 1, 44736, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62674a2d000000002103ea33", "2022-05-19 15:00:00", 1, 45189, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6267ac18000000002103d2b2", "2022-05-19 15:00:00", 1, 45587, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6285afd20000000021036a36", "2022-05-19 15:00:00", 1, 45666, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625e1122000000000102f6e2", "2022-05-19 15:00:00", 1, 46085, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627466490000000001029079", "2022-05-19 15:00:00", 1, 46304, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6263576700000000210350e2", "2022-05-19 15:00:00", 1, 46586, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6279ea570000000021037af4", "2022-05-19 15:00:00", 1, 46771, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dce86000000002103e54a", "2022-05-19 15:00:00", 1, 46969, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62712fea0000000021038d67", "2022-05-19 15:00:00", 1, 47351, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625fcdbb0000000001027a78", "2022-05-19 15:00:00", 1, 47604, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6264fe5a000000000102e033", "2022-05-19 15:00:00", 1, 47670, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284ad5c000000002103ca02", "2022-05-19 15:00:00", 1, 47729, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625fdc13000000000102ec76", "2022-05-19 15:00:00", 1, 47928, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62708d560000000021034d1f", "2022-05-19 15:00:00", 1, 48021, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6264c89d000000000102d047", "2022-05-19 15:00:00", 1, 48238, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6268ab4e00000000010273e7", "2022-05-19 15:00:00", 1, 48340, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62849f0f000000000102615f", "2022-05-19 15:00:00", 1, 48608, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6262376b000000000102ccd5", "2022-05-19 15:00:00", 1, 48656, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284b8d8000000000102fc27", "2022-05-19 15:00:00", 1, 48840, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62625010000000002103dfda", "2022-05-19 15:00:00", 1, 48881, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284b68b000000002103d595", "2022-05-19 15:00:00", 1, 48989, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626f9470000000002103aff2", "2022-05-19 15:00:00", 1, 49273, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6261220c0000000021036d4a", "2022-05-19 15:00:00", 1, 49406, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284bcff000000000102e163", "2022-05-19 15:00:00", 1, 49438, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62734c44000000002103eb9f", "2022-05-19 15:00:00", 1, 49633, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6265f279000000000102ba32", "2022-05-19 15:00:00", 1, 49922, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625d34b80000000001027550", "2022-05-19 15:00:00", 1, 49979, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627490c10000000001029345", "2022-05-19 15:00:00", 1, 49979, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627123e600000000210399ba", "2022-05-19 15:00:00", 1, 49982, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6257dea7000000002103a880", "2022-05-19 15:00:00", 1, 49999, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6265441a0000000001025656", "2022-05-19 15:00:00", 1, 54804, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627fc3c40000000021038b74", "2022-05-19 15:00:00", 1, 55913, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626453b2000000002103f1ab", "2022-05-19 15:00:00", 1, 57490, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625c0464000000000102703a", "2022-05-19 15:00:00", 1, 59009, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62596b93000000002103b859", "2022-05-19 15:00:00", 1, 59495, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627532c3000000000102dbad", "2022-05-19 15:00:00", 1, 62009, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f11fc0000000001028023", "2022-05-19 15:00:00", 1, 62533, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6268b39f000000000102658d", "2022-05-19 15:00:00", 1, 66668, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626bad22000000002103fc78", "2022-05-19 15:00:00", 1, 67171, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627e5044000000002103f12e", "2022-05-19 15:00:00", 1, 69070, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625cefb10000000021039e4c", "2022-05-19 15:00:00", 1, 69443, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62615f30000000000102cc9f", "2022-05-19 15:00:00", 1, 69679, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6257c522000000002103a9df", "2022-05-19 15:00:00", 1, 70304, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f6c940000000021038f22", "2022-05-19 15:00:00", 1, 71019, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626cbe4c00000000210346a7", "2022-05-19 15:00:00", 1, 71058, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626b6df0000000002103d4d2", "2022-05-19 15:00:00", 1, 74577, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626234460000000001025869", "2022-05-19 15:00:00", 1, 77749, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6263f338000000000102bef9", "2022-05-19 15:00:00", 1, 78846, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6257805a0000000021036183", "2022-05-19 15:00:00", 1, 78858, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6265a8e1000000000102fffd", "2022-05-19 15:00:00", 1, 79403, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626788dc000000002103f401", "2022-05-19 15:00:00", 1, 80308, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625e6a9a0000000021039739", "2022-05-19 15:00:00", 1, 81455, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626a17c8000000002103515f", "2022-05-19 15:00:00", 1, 81704, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626f9e6a000000000102498e", "2022-05-19 15:00:00", 1, 84107, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625a9a8c000000000102c64f", "2022-05-19 15:00:00", 1, 84182, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627a139c0000000021034a6d", "2022-05-19 15:00:00", 1, 86222, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f4f770000000021039f0b", "2022-05-19 15:00:00", 1, 86466, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f3c330000000001029b7c", "2022-05-19 15:00:00", 1, 86875, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62708e810000000001025551", "2022-05-19 15:00:00", 1, 89351, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626266710000000001027708", "2022-05-19 15:00:00", 1, 89653, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62641b00000000002103a19d", "2022-05-19 15:00:00", 1, 90382, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625d53c4000000000102a41b", "2022-05-19 15:00:00", 1, 90740, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("620a08ba0000000001028f4f", "2022-05-19 15:00:00", 1, 90825, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284dabf000000002103b370", "2022-05-19 15:00:00", 1, 90964, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627e05ab000000000102ce71", "2022-05-19 15:00:00", 1, 91481, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6270e89d000000000102b391", "2022-05-19 15:00:00", 1, 91841, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626a786c0000000021036593", "2022-05-19 15:00:00", 1, 91843, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626a4bfb0000000021034682", "2022-05-19 15:00:00", 1, 92015, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62695a960000000001024c5a", "2022-05-19 15:00:00", 1, 92665, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625cfc2a0000000001027f07", "2022-05-19 15:00:00", 1, 93373, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f8dfb000000000102fea9", "2022-05-19 15:00:00", 1, 94332, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626359c500000000010241f0", "2022-05-19 15:00:00", 1, 94363, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6263f262000000000102d6da", "2022-05-19 15:00:00", 1, 94438, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62624831000000000102d7c7", "2022-05-19 15:00:00", 1, 94648, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f50b9000000002103c68d", "2022-05-19 15:00:00", 1, 95061, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625d03a900000000210341f8", "2022-05-19 15:00:00", 1, 95107, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6264b873000000002103e985", "2022-05-19 15:00:00", 1, 95717, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284df43000000002103d41a", "2022-05-19 15:00:00", 1, 95959, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284b45b000000002103ff42", "2022-05-19 15:00:00", 1, 96740, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6257cc4d000000002103aa19", "2022-05-19 15:00:00", 1, 96818, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625e26f6000000002103a6b7", "2022-05-19 15:00:00", 1, 97531, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626524ae000000000102d10e", "2022-05-19 15:00:00", 1, 97643, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625543b9000000000102e102", "2022-05-19 15:00:00", 1, 97652, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627cbfed0000000001028623", "2022-05-19 15:00:00", 1, 97884, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284e75200000000210359ca", "2022-05-19 15:00:00", 1, 98103, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625b94f20000000001029ae7", "2022-05-19 15:00:00", 1, 98241, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62581488000000000102e513", "2022-05-19 15:00:00", 1, 98304, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284e123000000002103e713", "2022-05-19 15:00:00", 1, 99062, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6257dfae000000000c032215", "2022-05-19 15:00:00", 1, 99125, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625d09690000000021036caa", "2022-05-19 15:00:00", 1, 99190, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626ccfc8000000000102b518", "2022-05-19 15:00:00", 1, 99489, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62650355000000000102aec2", "2022-05-19 15:00:00", 1, 99749, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626ce7d2000000002103d871", "2022-05-19 15:00:00", 1, 99781, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626b469d000000002103e2cf", "2022-05-19 15:00:00", 1, 99789, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6279d217000000002103cf14", "2022-05-19 15:00:00", 1, 99852, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b3bda0000000021035945", "2022-05-19 15:00:00", 1, 99870, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f43c100000000010299e1", "2022-05-19 15:00:00", 1, 99887, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6258095a000000000102c38f", "2022-05-19 15:00:00", 1, 99974, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625d33c5000000000102675d", "2022-05-19 15:00:00", 1, 99993, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6283bea2000000002103c3e1", "2022-05-19 15:00:00", 1, 99996, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284b45d000000000102a403", "2022-05-19 15:00:00", 1, 156694, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6278d00a00000000010254fb", "2022-05-19 15:00:00", 1, 157976, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62849f8b000000000102655d", "2022-05-19 15:00:00", 1, 164619, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627c9822000000000102ba05", "2022-05-19 15:00:00", 1, 165934, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6274c9f3000000002103c96d", "2022-05-19 15:00:00", 1, 169398, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625fda25000000002103bcbe", "2022-05-19 15:00:00", 1, 181851, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6278df29000000002103b5c0", "2022-05-19 15:00:00", 1, 190015, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625f86120000000001029d6c", "2022-05-19 15:00:00", 1, 203029, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6275c71a00000000010277ea", "2022-05-19 15:00:00", 1, 204858, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626533ea0000000001028097", "2022-05-19 15:00:00", 1, 216367, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6278fce9000000000102e63d", "2022-05-19 15:00:00", 1, 218321, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627bb6de0000000001029043", "2022-05-19 15:00:00", 1, 220355, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b377b0000000021037100", "2022-05-19 15:00:00", 1, 229356, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284d641000000002103dcb9", "2022-05-19 15:00:00", 1, 234843, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627488f100000000010295b2", "2022-05-19 15:00:00", 1, 236236, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6274d1cc000000000102e749", "2022-05-19 15:00:00", 1, 236806, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62788b9f000000000102cc19", "2022-05-19 15:00:00", 1, 238810, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dfadc0000000021038c00", "2022-05-19 15:00:00", 1, 243011, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62580d7b000000002103503a", "2022-05-19 15:00:00", 1, 244400, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627642d7000000002103b61a", "2022-05-19 15:00:00", 1, 248174, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284d886000000000102da0b", "2022-05-19 15:00:00", 1, 249779, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625f9db50000000001024b18", "2022-05-19 15:00:00", 1, 254064, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("628316600000000021036db5", "2022-05-19 15:00:00", 1, 257039, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284bbae000000002103b2fa", "2022-05-19 15:00:00", 1, 258121, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62774d56000000000102a959", "2022-05-19 15:00:00", 1, 259822, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6273765800000000010283f0", "2022-05-19 15:00:00", 1, 259847, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627dd0700000000021038200", "2022-05-19 15:00:00", 1, 261952, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b5d24000000000102813b", "2022-05-19 15:00:00", 1, 266722, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625bc1520000000001025e67", "2022-05-19 15:00:00", 1, 266952, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b6053000000000102d407", "2022-05-19 15:00:00", 1, 269072, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b74a8000000002103a806", "2022-05-19 15:00:00", 1, 269268, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b7c7d000000002103ae5b", "2022-05-19 15:00:00", 1, 269718, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626bb9310000000001026184", "2022-05-19 15:00:00", 1, 269891, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627e2171000000000102c572", "2022-05-19 15:00:00", 2, 280358, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6270eb94000000002103b8af", "2022-05-19 15:00:00", 2, 280386, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b7d5f000000000102e109", "2022-05-19 15:00:00", 2, 282999, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626a5e3000000000210395f7", "2022-05-19 15:00:00", 2, 284129, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625d6c2e000000000102bebd", "2022-05-19 15:00:00", 2, 287709, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62761538000000002103acd8", "2022-05-19 15:00:00", 2, 287911, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6277c16e000000000102949d", "2022-05-19 15:00:00", 2, 287970, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b661f0000000001028dcf", "2022-05-19 15:00:00", 2, 288830, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6279d86a0000000001029fd3", "2022-05-19 15:00:00", 2, 289350, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6277bd78000000000102b0e3", "2022-05-19 15:00:00", 2, 290490, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626df62c0000000001028a08", "2022-05-19 15:00:00", 2, 291361, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62777edd0000000001028bb8", "2022-05-19 15:00:00", 2, 291658, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62767b4e000000002103838b", "2022-05-19 15:00:00", 2, 292209, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6277494d000000002103bc38", "2022-05-19 15:00:00", 2, 292506, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6268d65f000000000102849d", "2022-05-19 15:00:00", 2, 292659, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62849d0c000000002103e1f4", "2022-05-19 15:00:00", 2, 292723, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6279c05e000000002103c8a0", "2022-05-19 15:00:00", 2, 292821, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284a0a300000000010288de", "2022-05-19 15:00:00", 2, 294507, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b8af400000000010250fa", "2022-05-19 15:00:00", 2, 294508, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62849a100000000001029565", "2022-05-19 15:00:00", 2, 295017, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626768510000000021038e83", "2022-05-19 15:00:00", 2, 295072, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6281f97d00000000010240b7", "2022-05-19 15:00:00", 2, 295300, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62751c8c000000000102c848", "2022-05-19 15:00:00", 2, 295913, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("625a717b0000000001024730", "2022-05-19 15:00:00", 2, 298008, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6274e56a000000000102f84a", "2022-05-19 15:00:00", 2, 298231, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6274daff000000002103b1b8", "2022-05-19 15:00:00", 2, 298287, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284ab59000000000102969f", "2022-05-19 15:00:00", 2, 298891, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b81190000000001025c4f", "2022-05-19 15:00:00", 2, 298953, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62610d1e00000000010297a0", "2022-05-19 15:00:00", 2, 298999, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6270ed9e000000002103c8e3", "2022-05-19 15:00:00", 2, 299858, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62773f8e000000002103d39a", "2022-05-19 15:00:00", 2, 317012, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62578a53000000000102600d", "2022-05-19 15:00:00", 2, 330948, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b27ef0000000001025cab", "2022-05-19 15:00:00", 2, 331619, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627b2d4e000000002103ada5", "2022-05-19 15:00:00", 2, 361010, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f131c000000002103ebee", "2022-05-19 15:00:00", 2, 383643, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("62763d8d000000000102cb26", "2022-05-19 15:00:00", 2, 387044, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6279c9160000000021039b06", "2022-05-19 15:00:00", 2, 398598, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6278c526000000000102af58", "2022-05-19 15:00:00", 2, 407178, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6275c1470000000021036da9", "2022-05-19 15:00:00", 2, 437883, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626a5b0f000000000102588c", "2022-05-19 15:00:00", 2, 439066, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6278fcdb000000000102b947", "2022-05-19 15:00:00", 2, 442343, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6279d908000000000102c38d", "2022-05-19 15:00:00", 2, 468396, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("626bd78e000000000102e89d", "2022-05-19 15:00:00", 2, 482088, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6284c6fe0000000021035eff", "2022-05-19 15:00:00", 2, 488296, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6270bbde000000000102a149", "2022-05-19 15:00:00", 2, 489878, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627f2fd50000000001024b6e", "2022-05-19 15:00:00", 2, 492314, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6274fdeb00000000010244c7", "2022-05-19 15:00:00", 2, 494078, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("627653e6000000002103c453", "2022-05-19 15:00:00", 2, 495028, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6268ed5e000000000102a678", "2022-05-19 15:00:00", 2, 497659, "青鸾(刘洋)"));
        gdPlans.add(new GDPlan("6278ccda000000000102b0c2", "2022-05-19 15:00:00", 2, 497943, "青鸾(刘洋)"));
        return gdPlans;


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


        List<Object> objs = generateCurlOrders(generateGdPlans());
//        List<Object> objs = generateCurlOrders(generateGdSuggestions());
//        List<Object> objs = generateCurlOrders(generateSoftPlan());
        objs.stream().forEach(order -> System.out.println(order));
    }
}
