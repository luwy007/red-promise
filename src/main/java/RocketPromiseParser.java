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
            info.put(RECALL_BOOST_KEY, String.valueOf(rBoost>30?30:rBoost));
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

        // 巫师第10篇
        promiseList.add(new RocketPromise("6030e8fe0000000001007ccb", 1000000, 10.0f, "2021-02-23", "2021-02-28"));
        // 小艾大叔第一篇
        promiseList.add(new RocketPromise("603628c90000000001007c9a", 100000, 20.0f, "2021-02-23", "2021-02-28"));

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
