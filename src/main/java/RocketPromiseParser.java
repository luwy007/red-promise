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
    //    private static final String RECALL_BOOST_KEY = "rboost";
    private static final String BOOST_KEY = "boost";
    private static final String END_DATE_KEY = "endDate";
    private static final String BEGIN_DATE_KEY = "beginDate";

    @Data
    private static class RocketPromise {
        String noteId = "123note";
        Map<String, String> info = new HashMap<>();

        public RocketPromise(String noteId, float impGoal, float boost, String beginDate, String endDate) {
            this.noteId = noteId;
            info.put(IMP_KEY, String.valueOf((int) impGoal));
            info.put(BEGIN_DATE_KEY, beginDate);
            info.put(END_DATE_KEY, endDate);
//            info.put(RECALL_BOOST_KEY, String.valueOf(boost > 30 ? 30 : boost));
            info.put(BOOST_KEY, String.valueOf(boost > 10 ? 10 : String.format("%.1f", boost > 0 ? boost : -1.0)));
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
//        promiseList.add(new RocketPromise("600a6b7300000000010028bf", 5000000, 20.0f, "2021-01-27", "2021-02-10"));

        // 小艾大叔新增3篇
//        promiseList.add(new RocketPromise("6040b7600000000001006d5d", 400000, -1.0f, "2021-03-05", "2021-03-07"));
        promiseList.add(new RocketPromise("604328ea0000000001004038", 10000000, -1.0f, "2021-03-08", "2021-03-19"));
        promiseList.add(new RocketPromise("604c925c0000000001000d51", 1000000, -1.0f, "2021-03-15", "2021-03-17"));

        // vlog博主
        promiseList.add(new RocketPromise("6048a52a000000002103835b", 500000, -1.0f, "2021-03-12", "2021-03-20"));
        promiseList.add(new RocketPromise("6048a63d0000000021038826", 500000, -1.0f, "2021-03-12", "2021-03-20"));

        promiseList.add(new RocketPromise("6039f9e2000000000102a80f", 500000, -1.0f, "2021-03-12", "2021-03-20"));
        promiseList.add(new RocketPromise("602fc56c000000000102b0eb", 500000, -1.0f, "2021-03-12", "2021-03-20"));

        promiseList.add(new RocketPromise("60406198000000000100675f", 500000, -1.0f, "2021-03-12", "2021-03-20"));
        promiseList.add(new RocketPromise("6034a1cd0000000001009569", 500000, -1.0f, "2021-03-12", "2021-03-20"));
        promiseList.add(new RocketPromise("604850760000000001002b10", 500000, -1.0f, "2021-03-12", "2021-03-20"));

        promiseList.add(new RocketPromise("604706f3000000000100a8f9", 500000, -1.0f, "2021-03-12", "2021-03-20"));
        promiseList.add(new RocketPromise("60482a07000000002103bfd9", 500000, -1.0f, "2021-03-12", "2021-03-20"));
        promiseList.add(new RocketPromise("604990ba0000000021035ae3", 500000, -1.0f, "2021-03-12", "2021-03-20"));


        // 新知bad case
        promiseList.add(new RocketPromise("6048b818000000000102e5da", 100000, 2.0f, "2021-03-12", "2021-03-16"));

        // 美食
        promiseList.add(new RocketPromise("604c338e000000000100447b", 500000, -1.0f, "2021-03-15", "2021-03-17"));


        JSONObject json = new JSONObject();
        for (RocketPromise promise : promiseList) {
            if (promise.selfCheck() && !json.containsKey(promise.getNoteId())) {
                json.put(promise.getNoteId(), promise.getInfo());
                System.out.println(promise.getNoteId());

            } else {
//                System.out.println("wrong info for note " + promise.getNoteId());
            }
        }
        System.out.println(json.toJSONString());

    }

}
