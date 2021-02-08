import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RocketPromiseParser {

    private static final String IMP_KEY = "imp";
    private static final String RECALL_BOOST_KEY = "rboost";
    private static final String END_DATE_KEY = "endDate";
    private static final String BEGIN_DATE_KEY = "beginDate";

    @Data
    private static class RocketPromise {
        String noteId = "123note";
        Map<String, String> info = new HashMap<>();
        public RocketPromise(String noteId, float impGoal, float rBoost, String beginDate, String endDate) {
            this.noteId = noteId;
            info.put(IMP_KEY, String.valueOf((int)impGoal));
            info.put(BEGIN_DATE_KEY, beginDate);
            info.put(END_DATE_KEY, endDate);
            info.put(RECALL_BOOST_KEY, String.valueOf(rBoost));
        }

        public boolean selfCheck() throws Exception {
            boolean isOk = true;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            if (sdf.parse(this.info.get(BEGIN_DATE_KEY)).getTime() > now.getTime()
                    || sdf.parse(this.info.get(END_DATE_KEY)).getTime() < now.getTime()) {
                isOk = false;
            }
            return isOk;
        }
    }

    public static void main(String[] args) throws Exception {
        List<RocketPromise> promiseList = new ArrayList<>();
        // 巫师第5篇笔记
        promiseList.add(new RocketPromise("600a6b7300000000010028bf", 5000000, 20.0f, "2021-01-27","2021-02-10"));

        // 1.28 美妆活动 测试
        promiseList.add(new RocketPromise("5ff2f61e00000000010074f9", 1000000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("60059d43000000000101d4cd", 1000000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600e974b000000000101d22b", 1000000, 10.0f, "2021-01-27","2021-02-10"));

        // 1.28 vlog品类
        promiseList.add(new RocketPromise("600d39f8000000000100b9a0", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600d3bb000000000010049e2", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("60091b0a000000000100221b", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("5fe6e2550000000001002ccb", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600d073f000000000100873a", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("6007953a0000000001009adf", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("6002d4df000000000101f6b4", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("5ffaa9a80000000001002e70", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("5ff5378c000000000100aa7d", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("5fe36063000000000101d99b", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("5fdf61fe000000000100b4bb", 100000, 10.0f, "2021-01-27","2021-02-10"));


        // 1.29巫师小推第6篇
        promiseList.add(new RocketPromise("60113284000000000100ae57", 5000000, 20.0f, "2021-01-27","2021-02-10"));

        // 1.30 游戏
//        promiseList.add(new RocketPromise("60138ab800000000010071f4", 1000000, 10.0f, "2021-01-27","2021-02-10"));

        // 1.30 长板与建鹏
        promiseList.add(new RocketPromise("60112dbc0000000001006cc0", 1000000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600fc590000000000101d73e", 1000000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600e1ad3000000000101cfd0", 1000000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("6007a0520000000001008545", 1000000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("6006ce280000000001002de3", 1000000, 10.0f, "2021-01-27","2021-02-10"));


        // 2.3 巫师
        promiseList.add(new RocketPromise("6018d17c000000000100b0f9", 3000000, 20.0f, "2021-02-03","2021-02-10"));

        // 2.3 美妆博主andy，前期一直被审核ban
        promiseList.add(new RocketPromise("6017ca0400000000010012a0", 1000000, 20.0f, "2021-02-03","2021-02-10"));


        // 2.4 游戏新作
//        promiseList.add(new RocketPromise("6017a059000000000100a91c", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("6017a247000000000100b392", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("6017a71300000000010059c1", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("6018cfc9000000000101c154", 2000000, 15.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("601a2a96000000000100b151", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("601b6a06000000000100911b", 2000000, 10.0f, "2021-02-03","2021-02-10"));

        // 静姐case，查漏斗
        promiseList.add(new RocketPromise("601bd63a000000000101d061", 10000, 10.0f, "2021-02-03","2021-02-10"));

        // 2.8 泛兴趣 小马哥
        promiseList.add(new RocketPromise("601f8f540000000001001668", 1000000, 10.0f, "2021-02-08","2021-02-15"));



        // 2.8 游戏陈二狗
        promiseList.add(new RocketPromise("600d4773000000000100bedb", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6013e475000000000101e43c", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6012850e000000000101f4ce", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6015305a000000000101ed1f", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("601fa8e3000000002103f6c6", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("601d1f260000000001002c95", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("601bbc530000000001006fc8", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("601a7ddf0000000001000f8f", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6017e63500000000010032f4", 10000, 5.0f, "2021-02-08","2021-02-15"));

        // 2.8 游戏奶牛
        promiseList.add(new RocketPromise("601a3467000000000101dc29", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("60168b52000000000101eb01", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6013e50a00000000010076e1", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("601181d400000000010035ac", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("600e9ab300000000010003cf", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("600aa7700000000001007453", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6006e89f000000000101fbad", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("6020025e00000000010047a5", 10000, 5.0f, "2021-02-08","2021-02-15"));
        promiseList.add(new RocketPromise("601d02d2000000000101d1b8", 10000, 5.0f, "2021-02-08","2021-02-15"));



        JSONObject json = new JSONObject();
        for (RocketPromise promise : promiseList) {
            if (promise.selfCheck() && !json.containsKey(promise.getNoteId())) {
                json.put(promise.getNoteId(), promise.getInfo());
            } else {
                System.out.println("wrong info for note " + promise.getNoteId());
            }
        }
        System.out.println(json.toJSONString());

    }

}
