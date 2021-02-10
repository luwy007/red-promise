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
            info.put(IMP_KEY, String.valueOf((int) impGoal));
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
        promiseList.add(new RocketPromise("600a6b7300000000010028bf", 5000000, 20.0f, "2021-01-27", "2021-02-10"));

        // 1.28 美妆活动 测试
        promiseList.add(new RocketPromise("5ff2f61e00000000010074f9", 1000000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("60059d43000000000101d4cd", 1000000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("600e974b000000000101d22b", 1000000, 10.0f, "2021-01-27", "2021-02-10"));

        // 1.28 vlog品类
        promiseList.add(new RocketPromise("600d39f8000000000100b9a0", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("600d3bb000000000010049e2", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("60091b0a000000000100221b", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("5fe6e2550000000001002ccb", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("600d073f000000000100873a", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("6007953a0000000001009adf", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("6002d4df000000000101f6b4", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("5ffaa9a80000000001002e70", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("5ff5378c000000000100aa7d", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("5fe36063000000000101d99b", 100000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("5fdf61fe000000000100b4bb", 100000, 10.0f, "2021-01-27", "2021-02-10"));


        // 1.29巫师小推第6篇
        promiseList.add(new RocketPromise("60113284000000000100ae57", 5000000, 20.0f, "2021-01-27", "2021-02-10"));

        // 1.30 游戏
//        promiseList.add(new RocketPromise("60138ab800000000010071f4", 1000000, 10.0f, "2021-01-27","2021-02-10"));

        // 1.30 长板与建鹏
        promiseList.add(new RocketPromise("60112dbc0000000001006cc0", 1000000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("600fc590000000000101d73e", 1000000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("600e1ad3000000000101cfd0", 1000000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("6007a0520000000001008545", 1000000, 10.0f, "2021-01-27", "2021-02-10"));
        promiseList.add(new RocketPromise("6006ce280000000001002de3", 1000000, 10.0f, "2021-01-27", "2021-02-10"));


        // 2.3 巫师
        promiseList.add(new RocketPromise("6018d17c000000000100b0f9", 3000000, 20.0f, "2021-02-03", "2021-02-10"));

        // 2.3 美妆博主andy，前期一直被审核ban
        promiseList.add(new RocketPromise("6017ca0400000000010012a0", 1000000, 20.0f, "2021-02-03", "2021-02-10"));


        // 2.4 游戏新作
//        promiseList.add(new RocketPromise("6017a059000000000100a91c", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("6017a247000000000100b392", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("6017a71300000000010059c1", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("6018cfc9000000000101c154", 2000000, 15.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("601a2a96000000000100b151", 2000000, 10.0f, "2021-02-03","2021-02-10"));
//        promiseList.add(new RocketPromise("601b6a06000000000100911b", 2000000, 10.0f, "2021-02-03","2021-02-10"));

        // 静姐case，查漏斗
        promiseList.add(new RocketPromise("601bd63a000000000101d061", 10000, 10.0f, "2021-02-03", "2021-02-18"));

        // 2.8 泛兴趣 小马哥
        promiseList.add(new RocketPromise("601f8f540000000001001668", 4000000, 15.0f, "2021-02-08", "2021-02-15"));


        // 2.8 游戏陈二狗
        promiseList.add(new RocketPromise("600d4773000000000100bedb", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6013e475000000000101e43c", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6012850e000000000101f4ce", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6015305a000000000101ed1f", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("601fa8e3000000002103f6c6", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("601d1f260000000001002c95", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("601bbc530000000001006fc8", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("601a7ddf0000000001000f8f", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6017e63500000000010032f4", 100000, 10.0f, "2021-02-08", "2021-02-15"));

        // 2.8 游戏奶牛
        promiseList.add(new RocketPromise("601a3467000000000101dc29", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("60168b52000000000101eb01", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6013e50a00000000010076e1", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("601181d400000000010035ac", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("600e9ab300000000010003cf", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("600aa7700000000001007453", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6006e89f000000000101fbad", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6020025e00000000010047a5", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("601d02d2000000000101d1b8", 100000, 10.0f, "2021-02-08", "2021-02-15"));

        // 测试召回效率
        promiseList.add(new RocketPromise("60127db90000000001000dae", 1000, 5.0f, "2021-02-08", "2021-02-15"));

        // 知识组活动
        promiseList.add(new RocketPromise("601a8f2a0000000001009b9f", 500000, 10.0f, "2021-02-08", "2021-02-15"));

        // pr笔记
        promiseList.add(new RocketPromise("601fd89a000000002103ca93", 1000000, 25.0f, "2021-02-08", "2021-02-15"));

        // 2.9 小马哥 第二篇
        promiseList.add(new RocketPromise("6020e89900000000010098cc", 4000000, 15.0f, "2021-02-08", "2021-02-15"));

        // pr 3篇内容 还为了测试，博主内容，是在作者维度被限流，or怎样
        promiseList.add(new RocketPromise("6020d39f000000002103cbb7", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("6020e88b00000000010291a7", 100000, 10.0f, "2021-02-08", "2021-02-15"));
        promiseList.add(new RocketPromise("602133490000000021036aae", 100000, 10.0f, "2021-02-08", "2021-02-15"));

        // 出行三位博主
        // 2.10 皮皮
        promiseList.add(new RocketPromise("60041339000000000101ff59", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("6009581100000000010011fc", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600d6b040000000001000fbe", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("60129a4b0000000001002807", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("6013ef1f0000000001009a71", 200000, 10.0f, "2021-02-10", "2021-02-15"));

        // 2.10 圆眼君
        promiseList.add(new RocketPromise("6007f51d00000000010029d7", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600ac9da000000000100bf0a", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600d43120000000001000b22", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600ff101000000000100b666", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("60113ecc00000000010005d6", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("601297560000000001001722", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("6013ea930000000001003dee", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("601d028d000000000100a536", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("601fc7890000000001009214", 200000, 10.0f, "2021-02-10", "2021-02-15"));

        // 2.10 一只蓝鲸
        promiseList.add(new RocketPromise("601e6115000000000101cdf8", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("6014ce5e00000000010070e5", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("6013aceb000000000100850b", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600fdc2c0000000001001c6e", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600e6e8b000000000101fc47", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("600d012e000000000100768a", 200000, 10.0f, "2021-02-10", "2021-02-15"));
        promiseList.add(new RocketPromise("60053315000000000100a336", 200000, 10.0f, "2021-02-10", "2021-02-15"));

        // 2.10 小马哥第三篇
        promiseList.add(new RocketPromise("60222b57000000000100544c", 4000000, 15.0f, "2021-02-10", "2021-02-15"));


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
