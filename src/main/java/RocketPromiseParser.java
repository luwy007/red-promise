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
    private static final String TYPE = "type";

    enum GuaranteeType {
        ROCKET(0), // rocket 日常保量
        WRITER(1), // 保量某位作者笔记
        NOTE(2);   // 保量某篇笔记

        GuaranteeType(int value) {
            this.value = value;
        }

        int value;
    }

    @Data
    private static class RocketPromise {
        String noteId = "123note";
        Map<String, String> info = new HashMap<>();

        public RocketPromise(String noteId, float impGoal, float boost, String beginDate, String endDate) {
            this(noteId, impGoal, boost, beginDate, endDate, GuaranteeType.NOTE.value);
            System.out.println(noteId+"\t"+impGoal+"\t"+beginDate);
        }

        public RocketPromise(String noteId, float impGoal, float boost, String beginDate, String endDate, int type) {
            this.noteId = noteId;
            info.put(IMP_KEY, String.valueOf((int) impGoal));
            info.put(BEGIN_DATE_KEY, beginDate);
            info.put(END_DATE_KEY, endDate);
            info.put(BOOST_KEY, String.valueOf(boost));
//            if (-1.0 != boost) {
//                info.put(BOOST_KEY, String.valueOf(boost > 10 ? 10 : String.format("%.1f", boost > 0 ? boost : -1.0)));
//            }
//            if (2 != type) {
//                info.put(TYPE, String.valueOf(type));
//            }
        }

        public boolean selfCheck() throws Exception {
            boolean isOk = true;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date now = new Date();
            if (
//                    sdf.parse(this.info.get(BEGIN_DATE_KEY)).getTime() > now.getTime()
//                            ||
                    sdf.parse(this.info.get(END_DATE_KEY)).getTime() < now.getTime()) {
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
//        promiseList.add(new RocketPromise("604328ea0000000001004038", 13000000, -1.0f, "2021-03-08", "2021-03-21"));
//        promiseList.add(new RocketPromise("604c925c0000000001000d51", 2000000, -1.0f, "2021-03-15", "2021-03-22"));
//        promiseList.add(new RocketPromise("60508816000000000100b03d", 4000000, -1.0f, "2021-03-17", "2021-03-21"));
//        promiseList.add(new RocketPromise("60532dc100000000010086b6", 1000000, -1.0f, "2021-03-20", "2021-03-22"));
//        promiseList.add(new RocketPromise("6055d6720000000001004f50", 2000000, -1.0f, "2021-03-22", "2021-03-25"));
//        promiseList.add(new RocketPromise("605879a6000000000100adc1", 2000000, -1.0f, "2021-03-29", "2021-04-02"));
//        promiseList.add(new RocketPromise("605b24c90000000001008566", 2000000, -1.0f, "2021-03-30", "2021-04-03"));
//        promiseList.add(new RocketPromise("605dc0e9000000000100508a", 2000000, -1.0f, "2021-03-31", "2021-04-04"));
//        promiseList.add(new RocketPromise("606072b30000000001006135", 2000000, -1.0f, "2021-04-01", "2021-04-05"));

        // 美食
//        promiseList.add(new RocketPromise("604c338e000000000100447b", 500000, -1.0f, "2021-03-15", "2021-03-17"));
//        promiseList.add(new RocketPromise("604f04aa0000000001029c18", 500000, -1.0f, "2021-03-17", "2021-03-20"));
//        promiseList.add(new RocketPromise("603a0e50000000000102d12a", 500000, -1.0f, "2021-03-17", "2021-03-20"));
        promiseList.add(new RocketPromise("60385cd1000000002103bef0", 3000000, -1.0f, "2021-03-18", "2021-03-26"));
        promiseList.add(new RocketPromise("60519f2a00000000010069be", 500000, -1.0f, "2021-03-22", "2021-03-25"));
        promiseList.add(new RocketPromise("605709c0000000002103fbaf", 1000000, -1.0f, "2021-03-24", "2021-03-27"));
        promiseList.add(new RocketPromise("604f1637000000002103419e", 500000, -1.0f, "2021-03-26", "2021-03-29"));
        promiseList.add(new RocketPromise("60558d5e0000000001004b1b", 1000000, -1.0f, "2021-03-26", "2021-03-29"));
        promiseList.add(new RocketPromise("605a80890000000021037fe1", 1000000, -1.0f, "2021-03-29", "2021-04-01"));
        promiseList.add(new RocketPromise("606068d30000000001026dfb", 1000000, -1.0f, "2021-03-30", "2021-04-02"));
        promiseList.add(new RocketPromise("606051f8000000000100add1", 1000000, -1.0f, "2021-03-30", "2021-04-02"));
        promiseList.add(new RocketPromise("606419b2000000002103b997", 1000000, -1.0f, "2021-04-07", "2021-04-10"));
        promiseList.add(new RocketPromise("60699fb1000000002103ee60", 500000, -1.0f, "2021-04-07", "2021-04-10"));
        promiseList.add(new RocketPromise("606bd9130000000001008643", 1000000, -1.0f, "2021-04-08", "2021-04-11"));
        promiseList.add(new RocketPromise("6066ed57000000000102dc21", 1000000, -1.0f, "2021-04-10", "2021-04-13"));

        // 新媒体
        promiseList.add(new RocketPromise("6050591c00000000010264a9", 1500000, -1.0f, "2021-03-16", "2021-03-23"));
        promiseList.add(new RocketPromise("60531a390000000021034a7a", 1000000, -1.0f, "2021-03-19", "2021-03-24"));
        promiseList.add(new RocketPromise("605b05e8000000002103df72", 2000000, -1.0f, "2021-03-25", "2021-04-01"));


        // 新知内容 三顺
        promiseList.add(new RocketPromise("604c94c3000000002103cb66", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("6036668e0000000001027c72", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("60360c790000000001025465", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("6050b91b000000002103e719", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("6050bacc000000002103f240", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("604f0f9b000000000102732b", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("604af8d80000000001027736", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("604b5b4d00000000010288d7", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("6048b818000000000102e5da", 500000, -1.0f, "2021-03-17", "2021-03-26"));
        promiseList.add(new RocketPromise("604a02e0000000002103491b", 500000, -1.0f, "2021-03-17", "2021-03-26"));

        promiseList.add(new RocketPromise("606d8756000000000102af89", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60682a9e000000002103f2d1", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606c4dc10000000001026638", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6065b630000000000102d8f0", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606ec98b00000000010059a6", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d90d80000000021035aa5", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606bf3f6000000002103cf0f", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6061bf13000000000102fc78", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6066f7e6000000000101f843", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60644f9000000000010092e4", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606af52b0000000021037cef", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6069a30200000000010241d4", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606a4aff0000000021036464", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606dacd9000000000102d3bd", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606c5d4a0000000021037ec4", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606ec715000000000101f168", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d7536000000000100983d", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606edb29000000002103b908", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606860520000000001024854", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6065ab59000000000102f08f", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606ed0dc000000000100218c", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606c6f2400000000010043f0", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606eddf7000000000101f3b7", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d8f13000000000101e6b5", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60656880000000000102b5bd", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60670c490000000001002761", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60658062000000000101e879", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6062e52b00000000010076b1", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6062e59700000000010076b9", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606580100000000001004f42", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6067dfb0000000000102724c", 500000, -1.0f, "2021-04-09", "2021-04-16"));

        promiseList.add(new RocketPromise("605f2515000000000102afc7", 500000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("606c2cc2000000002103a191", 500000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("606c3349000000002103669d", 500000, -1.0f, "2021-04-10", "2021-04-17"));

        //明星组
        promiseList.add(new RocketPromise("6050a133000000002103cba6", 5000000, -1.0f, "2021-03-22", "2021-03-28"));
        promiseList.add(new RocketPromise("6051e2aa00000000010249d0", 5000000, -1.0f, "2021-03-22", "2021-03-28"));
        promiseList.add(new RocketPromise("6050775b0000000021038a51", 5000000, -1.0f, "2021-03-22", "2021-03-28"));
        promiseList.add(new RocketPromise("60533a47000000000102f487", 5000000, -1.0f, "2021-03-22", "2021-03-28"));


        // 潮流 无脸男活动
        promiseList.add(new RocketPromise("604e03ed000000000102d392", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604512fe0000000021035bc1", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60544ecd000000002103c243", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6040713d000000002103d68c", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60537a180000000021038411", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6042166c000000000102ed7b", 300000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604cb39a000000002103f623", 300000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604b66df0000000001025dcf", 300000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60508da80000000001025204", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("603df28b000000002103effe", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604ce5fa000000000102a72f", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6049ca2b00000000210397fd", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6055ec390000000021036fbd", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("605779cb000000000102eb81", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("605816ff00000000210394c6", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6043076a000000002103fe7d", 120000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6057580400000000210344f1", 300000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6051a71e0000000001029848", 300000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6054425b000000000102654f", 300000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604e0ae4000000000102b485", 160000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604f7473000000000102cead", 160000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60457f9a0000000001027a3f", 160000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60586dda0000000001028faf", 160000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60506249000000002103904b", 160000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("605556fa0000000001028306", 160000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058c230000000000102d2dd", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058ae53000000002103947f", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058ace20000000021039192", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058b51b00000000010266ac", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058b03a000000000102bb91", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058b63d0000000021037baa", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058abd6000000002103e2cd", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058b8f900000000210345b3", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058c17300000000210357c0", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058b1f20000000001025909", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058c0da000000000102cf60", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058bec5000000000102a6d9", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6054bc4400000000010248c0", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058aae7000000002103dfc3", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058c34e000000002103e364", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058c01a0000000001024282", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6058b3680000000021036da8", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604f4c33000000002103a638", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60423a62000000000102a526", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604d8169000000000102ac28", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("603cd922000000000102ecce", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6049f5bb000000002103d581", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604dad8e000000000102e2f8", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60464cf50000000001029e13", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604869ce000000002103ca3a", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6051aecd000000002103c5df", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("605854640000000021038cff", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60536f9e000000000102cc5e", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6049919d0000000021035f19", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("603bb4ad000000002103cfee", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6041b1440000000001024eaf", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604af68200000000010271fd", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60549eb40000000021036ae6", 60000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6052da97000000002103d8b4", 330000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("605196a1000000002103809a", 330000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("605449f8000000000102b348", 330000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604a038b0000000021034cf4", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60421076000000002103a7a4", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("60548f53000000000102edbd", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("604b5e4d00000000010292f5", 200000, -1.0f, "2021-03-23", "2021-03-25"));
        promiseList.add(new RocketPromise("6051f2270000000001024996", 200000, -1.0f, "2021-03-23", "2021-03-25"));

        // 潮流 递补
        promiseList.add(new RocketPromise("6059b82d000000002103563e", 100000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("6059fd88000000000102818b", 200000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("6059f2db000000000102deaa", 200000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("60598e030000000021034ea5", 60000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("6059f805000000000102a467", 200000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("6058ba3a000000002103af38", 100000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("6058b18e0000000021036b39", 100000, -1.0f, "2021-03-24", "2021-03-26"));
        promiseList.add(new RocketPromise("6058b9cc000000002103cb0a", 100000, -1.0f, "2021-03-24", "2021-03-26"));


        // 游戏&数码提报
        promiseList.add(new RocketPromise("6056f6c40000000021038143", 1000000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("604ae0ca000000000101d291", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("60584867000000002103fe23", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("6052bd8e000000000101cbad", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("604dbbc40000000001025752", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("60557db40000000001000fca", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("60541ecf0000000021035fec", 500000, -1.0f, "2021-03-23", "2021-03-30"));

        promiseList.add(new RocketPromise("605dd208000000000101ead2", 500000, -1.0f, "2021-03-29", "2021-04-05"));
        promiseList.add(new RocketPromise("605d77690000000001004a7d", 1000000, -1.0f, "2021-03-29", "2021-04-05"));
        promiseList.add(new RocketPromise("605af0320000000001003a89", 500000, -1.0f, "2021-03-29", "2021-04-05"));
        promiseList.add(new RocketPromise("60617ade0000000001006762", 500000, -1.0f, "2021-03-29", "2021-04-05"));
        promiseList.add(new RocketPromise("605d9466000000000101e602", 500000, -1.0f, "2021-03-29", "2021-04-05"));
        promiseList.add(new RocketPromise("605f37c4000000000102d889", 500000, -1.0f, "2021-03-29", "2021-04-05"));

        promiseList.add(new RocketPromise("60687a60000000000101c159", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("606446ed000000000101de6e", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("6069ab07000000000100ba23", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("606c1eb00000000001007e8b", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("60631a120000000001024602", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("6067c3a8000000000100291f", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("606c2f690000000001000785", 500000, -1.0f, "2021-04-06", "2021-04-13"));

        promiseList.add(new RocketPromise("606d5d2e0000000001004a21", 1000000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60698e03000000000101c543", 1000000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d77f6000000000101e43d", 1000000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606f07ad00000000010024d3", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6073cd3b0000000001000b08", 1000000, -1.0f, "2021-04-12", "2021-04-16"));



        // vlog新增
        promiseList.add(new RocketPromise("6055ef72000000002103c0aa", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("6056cecf000000000102d5a6", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("6058783e0000000021037a0d", 500000, -1.0f, "2021-03-23", "2021-03-30"));
        promiseList.add(new RocketPromise("605b295e000000002103d1a7", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("60573585000000000101eedb", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("605b2ce00000000001003f15", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("60573978000000000101eefe", 500000, -1.0f, "2021-03-25", "2021-04-01"));

        promiseList.add(new RocketPromise("605f19690000000021038231", 1000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("6059c610000000002103e58e", 1000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("606801f60000000021035bd8", 1000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("6067d3d3000000000101fb8e", 1000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("6067d4e30000000001002998", 1000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("6067d6cb000000000100afbe", 1000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("605f22cd000000002103e496", 1500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("60695c96000000000100b7d8", 5000000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("605b2ce00000000001003f15", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("60671176000000000100278a", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("606712910000000001006069", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("605c21e3000000000100044c", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("605d86230000000001001279", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("605f19e6000000000101f41c", 500000, -1.0f, "2021-04-06", "2021-04-13"));
        promiseList.add(new RocketPromise("605efcbf000000002103936b", 1000000, -1.0f, "2021-04-06", "2021-04-13"));

        // 运动健身 阿修
        promiseList.add(new RocketPromise("60498ba8000000002103a2aa", 1000000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("6049eefb0000000001026652", 1000000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("60486dc20000000001002c5d", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("6051d1af000000000101c6ad", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("605986b700000000010066c3", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("605a08d1000000000100bb92", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("6054b1330000000001009495", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("6040e2f700000000010034b9", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("605a8e50000000000102b03c", 500000, -1.0f, "2021-03-25", "2021-04-01"));
        promiseList.add(new RocketPromise("60560778000000002103f729", 500000, -1.0f, "2021-03-25", "2021-04-01"));

        promiseList.add(new RocketPromise("6066de41000000000102eefb", 1000000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("606ec958000000000102cb4f", 1000000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("6062ecde00000000010084b3", 800000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("606173cb00000000010066cb", 800000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("6065781e00000000010275f3", 800000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("606d32e0000000002103ec5a", 800000, -1.0f, "2021-04-10", "2021-04-17"));
        promiseList.add(new RocketPromise("606191e6000000000102adf4", 800000, -1.0f, "2021-04-10", "2021-04-17"));
        // 运动赵丽娜
        promiseList.add(new RocketPromise("60608ea7000000000102a332", 100000, -1.0f, "2021-03-29", "2021-04-03"));
        promiseList.add(new RocketPromise("6062a923000000002103aa44", 100000, -1.0f, "2021-03-31", "2021-04-02"));
        promiseList.add(new RocketPromise("6063ff5700000000010271e7", 100000, -1.0f, "2021-04-01", "2021-04-03"));
        promiseList.add(new RocketPromise("606441a30000000001028e28", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6065422e00000000010293a3", 500000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("60700d46000000002103e193", 500000, -1.0f, "2021-04-10", "2021-04-13"));

        // 签约博主定保
        promiseList.add(new RocketPromise("604a2a84000000000102d595", 1379602, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603905d20000000021038118", 1379602, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604b705f000000000102c881", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6038ca8200000000010292ae", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604f150700000000010246a0", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605728090000000021035805", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605892ab000000000102eb21", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603b8ffc0000000021037c11", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603a2ca7000000002103b156", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603662080000000001026953", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60422246000000000102e444", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6034eca50000000021035e62", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603f986d000000000102779c", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60543206000000000102442f", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6049ecf90000000021037980", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6052e9bd000000000102ed42", 24533, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605883ec000000002103b71b", 71241, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604c9d5c0000000021039d2d", 71241, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6051e2f40000000001024bba", 71241, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6037811d000000002103b0ed", 71241, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60363213000000000102aec6", 71241, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604360cc000000000102844e", 71241, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60422344000000002103f732", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60559f5b000000002103bd6c", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604097f8000000002103bbf1", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605851590000000001026d12", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60474ae8000000002103bedb", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603b1692000000000102932b", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604c5fb2000000002103aa53", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6043079100000000010272a7", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603e0b0a000000000102d893", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6039c6d9000000000102815f", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6051cde1000000002103ab6a", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605474df000000000102ba22", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603cb53d000000000102be6c", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604490af0000000021036a18", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60338c4d000000000102cf0b", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6049df930000000001028ba2", 379325, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60389380000000000102a10b", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6033a347000000000102aa8c", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60449a75000000000102e5b8", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60599bef000000002103d7f3", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603f1da900000000010282fa", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60533163000000002103fc05", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603a0223000000000102e9d0", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603e03ba0000000021035588", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6033794e000000002103a702", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60433b6d000000002103ffe4", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6037762500000000010243a7", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6035d567000000002103d576", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6051d33f0000000001025c13", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605875be000000000102ab25", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604dce7c0000000001024f05", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6049ea71000000002103f0f2", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6044ad3f0000000021034394", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603bab620000000021035b0c", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6048511d00000000210354d7", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60408a36000000000102d2fc", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6034c967000000000102d45b", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6056f97800000000010275f2", 65295, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605564cc000000000100969f", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60331b43000000000100b2f1", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60516f13000000000101c075", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603b16a0000000000101d5cf", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6046e25e0000000001001f37", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60419d850000000001008038", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603f1f68000000000100aaf1", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6038613c000000000100afa7", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6058153b000000000101f2f6", 129174, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60377bcf000000000102e67a", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604c4c970000000021034323", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6041a987000000002103cae7", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60473f58000000000102c8c8", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60530c2600000000210368b4", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6034af080000000021039723", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603f6b58000000002103c79e", 254026, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603b96e2000000000102ce61", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60498fb5000000002103b299", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603cbda90000000001029bf4", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605311950000000001029431", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("605b07a00000000021034959", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603f892b000000002103a65e", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603b0b34000000002103d7a9", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60339de0000000000102ca44", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6042f1d9000000000102ad87", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6034d8e10000000001026e51", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604ef346000000000102d390", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604598750000000021035738", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604aece4000000000102ef9a", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604442d00000000021036332", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("604c4f4a000000000102cd9e", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60585f9c0000000001029903", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60502ff8000000002103ae2d", 13392, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6034e60b000000000102af00", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6059d4b70000000001026205", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60548d40000000000102e6a6", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6055e0730000000001026fc8", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("603ccf9c000000002103e900", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6050964f0000000001029e64", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("60572eb7000000000102658b", 157075, -1.0f, "2021-03-25", "2021-03-28"));
        promiseList.add(new RocketPromise("6040c4d8000000000102d42c", 157075, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60339c5d000000002103461e", 157075, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603f74a800000000210399d2", 157075, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6044be640000000001025cad", 157075, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6049fa44000000002103e5ec", 157075, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603cb9f00000000001028eab", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604b3918000000002103f206", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60506d510000000001025cd2", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6033754d000000000102f7b3", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60408dbc0000000001024832", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605af3fd0000000021038ca8", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60545c9e00000000210397f1", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6051c0510000000001029b8f", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604366f7000000002103a7ee", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6049d461000000002103f7db", 574470, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6033850200000000210348db", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60508bae000000002103edce", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60531732000000002103a772", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6055d112000000000102e59d", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60361e360000000001024b64", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60586d99000000000102dd54", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605b0c450000000021039ca2", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603b564e0000000001026ecd", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6045d9010000000001027955", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60435da0000000000102b907", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603e2608000000000102b5c1", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604dd9880000000021038eaa", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6038f6190000000021037cf6", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6040c1f0000000002103c731", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60489387000000000102ee7a", 500767, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605adf3400000000210389ea", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603c4ae2000000000102471a", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604ef4cb000000000102da8e", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6046f8b7000000000102f826", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603605ae000000000102ff90", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6054370d00000000210361a2", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6037e8d6000000002103c3b8", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60599c04000000000102fe5c", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60497700000000002103d73f", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6051d52e0000000021037211", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604af6b8000000002103f76e", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60583ce3000000002103753f", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6050547c00000000010285e1", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60484f860000000021034df5", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603f34ea00000000210348db", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60334a91000000000102d3f7", 393300, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604f5d0000000000010253d3", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60351601000000000102c11d", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60534b6b000000002103dab4", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6047702b000000000102aa94", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604a0def000000000102e509", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605b3ab0000000002103e55c", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6048cfb5000000000102b0bd", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603b9375000000002103cb68", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603e423d000000000102e21f", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60587fbd000000000102eb3e", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6059e7370000000001026cd7", 20766, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6038ad350000000021039bb5", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604c2494000000002103b324", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6041c954000000000102b356", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603a45f3000000002103882f", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6055995d0000000001029bdb", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6052060a0000000001028162", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605942f800000000010265be", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604b3e53000000000102a932", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6050be9e000000002103c5b3", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6034ff8c000000000102804f", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6040a9e10000000021034f14", 66848, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604739e3000000000102bfd6", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6038cf4f000000002103c78e", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6034fddd0000000001026ee9", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6049f03d0000000021034187", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60545db20000000021039de1", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60370c17000000000102b246", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6051b0fa0000000021038dd4", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60506b48000000002103c953", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603e3e720000000001028da2", 79246, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603994fb000000000102f856", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604efb4e000000000102ec47", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6047145c00000000010286f4", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6035dc13000000000102f642", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604971bc000000002103cc3c", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6046168700000000210387da", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6051b590000000002103a25d", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605943850000000021039d7a", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603efce9000000002103d29a", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605830260000000021034f5b", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605ad48b000000000102d1b6", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60507285000000002103dd43", 201271, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6044a66b000000000102d996", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("605b1c39000000000102637a", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6034e654000000000102fb12", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60339529000000002103d3e5", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603b6e070000000021038b9e", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("603630d3000000002103dac3", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6050843d000000002103cd33", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("6053288200000000210341e4", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("604adf530000000021034c63", 803649, -1.0f, "2021-03-28", "2021-04-01"));
        promiseList.add(new RocketPromise("60548399000000002103f25e", 803649, -1.0f, "2021-03-28", "2021-04-01"));

        //游戏定保特殊case
        promiseList.add(new RocketPromise("6062b35000000000010039a7", 100000, -1.0f, "2021-03-31", "2021-04-02"));
        promiseList.add(new RocketPromise("6066f7c60000000001005f43", 100000, -1.0f, "2021-04-03", "2021-04-05"));
        promiseList.add(new RocketPromise("60656a5d000000000101e6ac", 100000, -1.0f, "2021-04-03", "2021-04-05"));
        promiseList.add(new RocketPromise("606877d60000000021037528", 100000, -1.0f, "2021-04-04", "2021-04-06"));

        // 奥特曼扶持
        promiseList.add(new RocketPromise("606529230000000021036310", 1000000, -1.0f, "2021-03-31", "2021-04-04"));
        promiseList.add(new RocketPromise("6065394e0000000001027cd4", 500000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("60653a790000000021035a7a", 500000, -1.0f, "2021-04-02", "2021-04-04"));


        // 无脸男 潮流艺术展
        promiseList.add(new RocketPromise("60656756000000000102c124", 100000, -1.0f, "2021-04-02", "2021-04-03"));
        promiseList.add(new RocketPromise("6065c36a000000002103853a", 100000, -1.0f, "2021-04-02", "2021-04-03"));
        promiseList.add(new RocketPromise("6065c5650000000021038d3a", 100000, -1.0f, "2021-04-02", "2021-04-03"));
        promiseList.add(new RocketPromise("6065a75d0000000021039e8e", 100000, -1.0f, "2021-04-02", "2021-04-03"));
        promiseList.add(new RocketPromise("6066f62b000000000102fbef", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6066827b000000002103f783", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6066945d00000000010248a8", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6066bb620000000001026d83", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6064c1bc000000002103912b", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6066fcb20000000001025eb6", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6067045b0000000001027569", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("6066e7a20000000021036f1d", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("60669fcd0000000001025e13", 100000, -1.0f, "2021-04-02", "2021-04-04"));
        promiseList.add(new RocketPromise("60683da900000000210361e1", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("60681a950000000001025516", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("6067fa8e000000000102fe4d", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("60682a6b0000000001028a09", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("606730920000000021039d5b", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("60672664000000000102687a", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("60672ff70000000021034f76", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("6067c2f8000000002103849b", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("6066fae2000000002103b05e", 100000, -1.0f, "2021-04-04", "2021-04-05"));
        promiseList.add(new RocketPromise("606986fd00000000210372ff", 100000, -1.0f, "2021-04-05", "2021-04-06"));
        promiseList.add(new RocketPromise("6069194e0000000001027d90", 100000, -1.0f, "2021-04-05", "2021-04-06"));
        promiseList.add(new RocketPromise("6069c34a0000000001029520", 100000, -1.0f, "2021-04-05", "2021-04-06"));
        promiseList.add(new RocketPromise("606870ca000000002103950e", 100000, -1.0f, "2021-04-05", "2021-04-06"));
        promiseList.add(new RocketPromise("60699d32000000000102bfdc", 100000, -1.0f, "2021-04-05", "2021-04-06"));
        promiseList.add(new RocketPromise("606c1416000000000102d0ba", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("606c22c2000000002103f94a", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("606c238b000000002103fa1d", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("606add860000000021035f3e", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("606adb3000000000210354d9", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("606bf8d0000000000102f1f6", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("60672360000000002103bec8", 100000, -1.0f, "2021-04-07", "2021-04-09"));
        promiseList.add(new RocketPromise("606c238b000000002103fa1d", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("606ec828000000000102c7d8", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("6065a1b6000000002103d0cc", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("606a846c000000002103cf31", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("606aab9f000000002103410d", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("6069a13d0000000001028f0b", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("606842060000000021037094", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("60697dc8000000002103c3cd", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("6066c09500000000210376aa", 100000, -1.0f, "2021-04-08", "2021-04-10"));
        promiseList.add(new RocketPromise("606a8545000000002103d399", 100000, -1.0f, "2021-04-08", "2021-04-10"));

        promiseList.add(new RocketPromise("60732be900000000210343d9", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6071dc6c000000002103ef53", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6073183d000000000102d944", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6072f218000000000102e518", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("607189a0000000000102439f", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("60718169000000002103d03b", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("60708dc20000000001028b70", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6073c86f0000000021034c97", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6073c86f0000000021034c97", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6073f2f4000000002103fd37", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("607262a30000000001029cf7", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("607434de00000000010293a9", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("6074352f00000000010293ff", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("607189a0000000000102439f", 100000, -1.0f, "2021-04-12", "2021-04-14"));
        promiseList.add(new RocketPromise("606edf1c00000000210344a3", 100000, -1.0f, "2021-04-12", "2021-04-14"));

        //出行 昆明旅游
        promiseList.add(new RocketPromise("604c2ece0000000021037a5b", 50000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("60530677000000000102c9a7", 1200000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("60606082000000002103cbba", 2000000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("604b779a0000000021038b26", 300000, -1.0f, "2021-04-02", "2021-4-05"));
        promiseList.add(new RocketPromise("6055690a0000000021034496", 60000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("6052b8f000000000010299c1", 150000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("60530f680000000001003c00", 10000, -1.0f, "2021-04-02", "2021-04-05"));
        promiseList.add(new RocketPromise("6045a037000000002103ebae", 1000000, -1.0f, "2021-04-02", "2021-04-05"));

        // 健身 哈那
        promiseList.add(new RocketPromise("60630eda00000000210350c1", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("606464ff000000000102e61f", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6066a13f000000000102c9e0", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6066d0ea00000000010243f7", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("60519c80000000000102bb63", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("60608e8b00000000010241ad", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("60618f62000000002103b749", 400000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6060396d00000000010246f8", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6051ed7f000000000102a841", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6051c0a90000000021035984", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6052de04000000000102ff8e", 500000, -1.0f, "2021-04-02", "2021-04-09"));
        promiseList.add(new RocketPromise("6066dec2000000002103e608", 250000, -1.0f, "2021-04-02", "2021-04-09"));

        // 新知超级冷启动
        promiseList.add(new RocketPromise("606c32c500000000210364c8", 50000, -1.0f, "2021-04-06", "2021-04-08"));
        promiseList.add(new RocketPromise("6069a5c100000000010255da", 50000, -1.0f, "2021-04-06", "2021-04-08"));
        promiseList.add(new RocketPromise("606853df000000000102caf4", 50000, -1.0f, "2021-04-06", "2021-04-08"));

        // 哈那
        promiseList.add(new RocketPromise("606ea7fe0000000001029e9d", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606ec04b0000000021034b26", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606dae1b0000000021034897", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60648bc5000000000102f436", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606edfb3000000002103c15d", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d460f0000000001024ba2", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606eac22000000002103f152", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d460f0000000001024ba2", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606eae140000000021039c89", 500000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6058a8e4000000002103cf78", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606c1da20000000001026f05", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606e910d000000002103bb81", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606e94f0000000000102a944", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606e49d300000000210368fe", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6063b777000000002103d641", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606870f10000000021035f19", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("605d6e89000000000102e992", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606710e2000000002103dc08", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606e9625000000002103e87b", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606eaea00000000021035fda", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d7595000000002103f6e6", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60058c6300000000010071fe", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6069a46c0000000021035e83", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606bfd930000000021038fcd", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("605d9798000000002103d721", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606d86070000000001025419", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606b1990000000002103b156", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606c7ee20000000001029615", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606e64260000000001029148", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606c708d000000000102f3ed", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("606bd80c000000000102d6ab", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("60667438000000002103c504", 250000, -1.0f, "2021-04-09", "2021-04-16"));
        promiseList.add(new RocketPromise("6063ca19000000002103f21f", 250000, -1.0f, "2021-04-09", "2021-04-16"));




// 4月底 签约博主定保
        promiseList.add(new RocketPromise("6066adf8000000002103fe02", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606edd70000000002103f36d", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60726e3f000000000102f096", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6084e216000000002103977a", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6073bbaa000000000102d73c", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607fdca60000000001024e30", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607bf6e1000000002103f6dc", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60792387000000000102ab3e", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083ce06000000000102795c", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d559c0000000001027d0e", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607517dd000000002103e15a", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6067eb170000000001025e2c", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606e7e47000000000102dfea", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6077e0b50000000021038a9f", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6076b19f000000002103c559", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607ab897000000000102d1be", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606aad3a00000000210381b5", 11911, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60699a6f000000002103d9c7", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6084ffe20000000021037826", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606d3dc20000000001027860", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60703b3600000000010258ca", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6073d4f400000000010241f3", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607792f700000000010266b0", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606e90eb0000000001029bb6", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("608252430000000001029864", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606853d000000000010257cd", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60863f24000000000102714d", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c4b93000000000102a1f6", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d1f01000000002103aca3", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607a62e60000000001029459", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6076722c0000000021038aa6", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607c0aa10000000021038e9a", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6065b665000000000102d9ee", 63377, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ecc3f000000000102d9bf", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("608149d300000000210371ae", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c305a000000002103b009", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607c0b6f00000000210391fd", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60718b2c0000000001024e95", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6075ba30000000002103ff13", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60741cb2000000000102e2d7", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607909580000000021034d3f", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60683d520000000001024f6c", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083c8790000000001029f45", 743733, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6082ad340000000001028a4f", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606aac6f000000000102e366", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d10110000000001024996", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607fb94d0000000021036223", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6073db7d000000000102534d", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6086439400000000210359cb", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083caa4000000002103faeb", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607a5b30000000000102b6f1", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607136140000000021038310", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6081095b0000000001026cf6", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60851de9000000000102d38d", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60693ffa0000000021035177", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606d5e37000000000102524a", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6066992e0000000021038195", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6077c4040000000021037466", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6067e712000000000102c5cb", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60757987000000002103fd46", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606bdc0e000000000102e55f", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60659b3300000000210379e5", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606fd6930000000021039866", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606e8891000000000102b714", 21157, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607199d20000000021036f25", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60816b3e000000000102c70a", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6076d2b6000000000102728f", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6069ba2a00000000210379ef", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607ed3c1000000002103a1d5", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c4a1d00000000210375bf", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6075a79a000000000102aa83", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6080145f000000000102791b", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6082bbed000000002103f84e", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606daa94000000002103fc5e", 24717, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6071028b000000002103662c", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6072cc08000000002103f21b", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607e8c64000000002103b90b", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6073d735000000002103e1bb", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ff8b0000000000102a932", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6076c1f9000000000102792a", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083b3d4000000000102f81d", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607f8a0200000000010290c3", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6075277f000000000102e06c", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d48080000000021037021", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60791127000000000102ebea", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607f8fab000000002103f337", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60818510000000002103e3dd", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606e6f6500000000210394f6", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c6aac000000002103df53", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6086548a0000000001027151", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6065586c0000000001028caf", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6084d9a80000000021037572", 336192, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6069846e000000002103acf6", 336192, -1.0f, "2021-04-27", "2021-05-01"));

        promiseList.add(new RocketPromise("6073cd90000000002103c38e", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6066985f000000000102518e", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c34e6000000002103f380", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("608401c000000000210389ab", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6075b90a000000002103bfdf", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607ed93b0000000001028d5b", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607c5d090000000001024087", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6069b501000000000102934a", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606d6ced000000002103d995", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60863ec7000000000102cae5", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6072de450000000021035ef3", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("608004a500000000210369f5", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d0b19000000002103b147", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6077a641000000002103c28c", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607ac76d000000000102ca2e", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60704c9f0000000001025ea6", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606b04860000000021039d09", 41791, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ecbfe00000000210375fe", 41791, -1.0f, "2021-04-27", "2021-05-01"));

        promiseList.add(new RocketPromise("60701438000000000102825e", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60812b32000000002103b6bb", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60754fea000000000102a2ea", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606eb3790000000001025485", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083ae7b000000000102e6bc", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607920070000000001026eb7", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607154cd000000002103bd0e", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60867e53000000002103c74b", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ae25000000000210372a9", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60699a39000000000102f31b", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6067f87a000000002103f885", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60658d5f000000000102fc01", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607a733a000000000102be2f", 452330, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60829614000000000102e296", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607696d10000000021036bd6", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("608164dc000000000102ae6a", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d42e6000000000102945d", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6066d6b1000000002103ffc9", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ef23b0000000021038f86", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607fd2b50000000001026838", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c1a5d000000000102e741", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6072a829000000002103ff90", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60868725000000000102a919", 559509, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606d700700000000010012ab", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606fd99c000000002103ff4a", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6077a8f40000000001006c02", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d96af0000000001002f83", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60667f5d000000000101ef92", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6076ba2a0000000001002d0f", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606a87b6000000002103da09", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607a4ce7000000000100934a", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6084c977000000000100b633", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6080ef3e000000000100910f", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6073b31f00000000010040e7", 136734, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607821d5000000002103fd20", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("608009480000000001024510", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6066fe92000000002103cd5e", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606c65680000000001027a12", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60718b110000000001024e28", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60869e53000000002103a9ff", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083fdfc00000000010282a1", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6069a862000000000102a29d", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607eba8e000000002103e789", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60757ca6000000000102e9d3", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606eeff90000000001026c43", 78369, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ab9c1000000002103ff39", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6073e9df0000000001027b64", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60852fbe0000000021035f61", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d2ebd00000000210399d0", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6066b80d0000000021035c78", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60713566000000000102d31d", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6086d21f0000000001028d54", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60792a1500000000010286ed", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607fe959000000000102fd74", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60754ee4000000000102c87b", 36447, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ef430000000000102a608", 36447, -1.0f, "2021-04-27", "2021-05-01"));

        promiseList.add(new RocketPromise("606ee4d90000000021039be8", 1613784, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d56610000000021038f56", 1613784, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607573f6000000000102a89d", 1613784, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606708c7000000000102fe21", 1613784, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6083e0a70000000001027c93", 1613784, -1.0f, "2021-04-27", "2021-05-01"));

        promiseList.add(new RocketPromise("6076b1d60000000001028332", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607812d400000000210348b8", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607fe994000000002103892c", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60683df600000000210364ba", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607403c90000000001025c86", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d5b72000000002103e768", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606feb15000000000102e418", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6066fbc1000000000102b4e0", 252541, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606ac6650000000021034b0a", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60698c6a000000002103f5be", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6076b8d4000000000102c742", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("606d904100000000010271f4", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60869883000000000102e559", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6072c139000000000102ee99", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607a89610000000021037739", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("60828ba7000000002103d897", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607d50130000000001026523", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6067021200000000210388bb", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6080175a0000000021036f6f", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("6070043100000000010297dc", 135141, -1.0f, "2021-04-27", "2021-05-01"));
        promiseList.add(new RocketPromise("607807930000000001029dfa", 135141, -1.0f, "2021-04-27", "2021-05-01"));
//        promiseList.add(new RocketPromise("6089506d0000000001026113", 50000, 5.0f, "2021-05-06", "2021-05-10"));
        // 游戏若风，诡异case
        promiseList.add(new RocketPromise("608bc5a6000000000100754f", 50000, 4.0f, "2021-05-07", "2021-05-08"));
        promiseList.add(new RocketPromise("608bcf820000000001000110", 50000, 4.0f, "2021-05-07", "2021-05-08"));
        promiseList.add(new RocketPromise("608bd0a700000000010076a8", 50000, 4.0f, "2021-05-07", "2021-05-08"));
        // 测试
        promiseList.add(new RocketPromise("60c2fb8f000000000100265b", 10000, -1.0f, "2021-06-15", "2021-06-20"));


        // 新媒体debug
//        promiseList.add(new RocketPromise("607693bf000000002103ae9c", 1000000, 5.0f, "2021-04-16", "2021-04-18"));
//        promiseList.add(new RocketPromise("606805e70000000001025da6", 250000, -1.0f, "2021-04-09", "2021-04-16"));

//
//
//        // 奥运支持
//        // 25金
//        promiseList.add(new RocketPromise("6107adcd0000000001003902", 5000000, 30.0f, "2021-07-24", "2021-08-26"));
//        // 26金
//        promiseList.add(new RocketPromise("6107af3e00000000210385cd", 5000000, 30.0f, "2021-07-24", "2021-08-26"));
//        // 27金
//        promiseList.add(new RocketPromise("6107b1f3000000000101d610", 5000000, 30.0f, "2021-07-24", "2021-08-26"));
//        // 28金
//        promiseList.add(new RocketPromise("6107b9030000000001003ac1", 5000000, 30.0f, "2021-07-24", "2021-08-26"));
//        // 女篮全胜晋级八强
//        promiseList.add(new RocketPromise("6107c341000000000100957a", 1000000, 10.0f, "2021-07-24", "2021-08-26"));
//        // 直播
//        promiseList.add(new RocketPromise("61061de900000000010295e5", 1000000, 20.0f, "2021-08-02 20:00:00", "2021-08-26"));
//        // 郎平
//        promiseList.add(new RocketPromise("6107c8e60000000021038316", 2000000, 20.0f, "2021-08-02", "2021-08-26"));
//        // 29金
//        promiseList.add(new RocketPromise("6107e9380000000001009913", 5000000, 30.0f, "2021-08-02", "2021-08-26"));
//        // 30金
//        promiseList.add(new RocketPromise("6108ef16000000002103c73c", 5000000, 30.0f, "2021-08-02", "2021-08-26"));
//        // 31金
//        promiseList.add(new RocketPromise("610901c30000000021034cfd", 5000000, 30.0f, "2021-08-02", "2021-08-26"));
//        // 直播
//        promiseList.add(new RocketPromise("610913780000000021038524", 1500000, 15.0f, "2021-08-02", "2021-08-26"));
//        // 32金
//        promiseList.add(new RocketPromise("610913a30000000001028603", 5000000, 30.0f, "2021-08-02", "2021-08-26"));
//        // 直播
//        promiseList.add(new RocketPromise("610a4c88000000000101c7ef", 1000000, 15.0f, "2021-08-02", "2021-08-26"));
//        // 男子4*100进决赛
//        promiseList.add(new RocketPromise("610b53e5000000000102aa00", 5000000, 25.0f, "2021-08-02", "2021-08-26"));
//        // 33金
//        promiseList.add(new RocketPromise("610b92570000000021036c4f", 5000000, 30.0f, "2021-08-02", "2021-08-26"));
//        // 33金周边
//        promiseList.add(new RocketPromise("610149280000000021034329", 1000000, 20.0f, "2021-08-02", "2021-08-26"));
//        // 直播
//        promiseList.add(new RocketPromise("610b97d1000000000102c837", 1000000, 25.0f, "2021-08-02", "2021-08-26"));
//        // 33金周边
//        promiseList.add(new RocketPromise("610bbbfc00000000210395b8", 3000000, 15.0f, "2021-08-02", "2021-08-26"));
//        // 34金
//        promiseList.add(new RocketPromise("610bdb5b0000000001005a4b", 5000000, 15.0f, "2021-08-02", "2021-08-26"));
//        // 34金周边
//        promiseList.add(new RocketPromise("610bd417000000000102db14", 5000000, 15.0f, "2021-08-02", "2021-08-26"));
//        // 张继科 乒乓男团赛前玩儿梗
//        promiseList.add(new RocketPromise("610c9756000000002103cc6f", 5000000, 15.0f, "2021-08-02", "2021-08-26"));
//        // 35金
//        promiseList.add(new RocketPromise("610d2d270000000001001f6d", 5000000, 25.0f, "2021-08-02", "2021-08-26"));
//        // 36金
//        promiseList.add(new RocketPromise("610d33fd0000000001028618", 5000000, 25.0f, "2021-08-02", "2021-08-26"));
//        // 37金
//        promiseList.add(new RocketPromise("610df493000000000101fda4", 5000000, 25.0f, "2021-08-02", "2021-08-26"));
//        // 38金
//        promiseList.add(new RocketPromise("610e36370000000021034d91", 5000000, 25.0f, "2021-08-02", "2021-08-26"));
//        // 直播
//        promiseList.add(new RocketPromise("610e2015000000002103b848", 1000000, 20.0f, "2021-08-02", "2021-08-26"));

        // 美食直播
//        promiseList.add(new RocketPromise("6117391e000000002103987a", 1000000, 1.0f, "2021-08-02", "2021-08-26"));
//        promiseList.add(new RocketPromise("61166711000000000102ff1c", 1000000, 1.0f, "2021-08-02", "2021-08-26"));
//        promiseList.add(new RocketPromise("611806ac000000000102ae06", 1000000, 1.0f, "2021-08-02", "2021-08-26"));
//        promiseList.add(new RocketPromise("6115c25e000000000102c0bc", 1000000, 1.0f, "2021-08-02", "2021-08-26"));
//        promiseList.add(new RocketPromise("611742bb000000000102bf68", 1000000, 1.0f, "2021-08-02", "2021-08-26"));

//        promiseList.add(new RocketPromise("611a3652000000000102e103", 300000, 1.0f, "2021-08-02", "2021-08-26"));
        promiseList.add(new RocketPromise("611e3f06000000000102b87d", 300000, 1.0f, "2021-08-02", "2021-08-26"));
        promiseList.add(new RocketPromise("611f25ae000000000101dd60", 300000, 1.0f, "2021-08-02", "2021-08-26"));

        promiseList.add(new RocketPromise("614a8e6a000000000102f1e7", 1000000, 1.0f, "2021-09-22", "2021-09-23"));
        promiseList.add(new RocketPromise("6147eb21000000000102ef4a", 1000000, 1.0f, "2021-09-22", "2021-09-23"));



        JSONObject json = new JSONObject();
        for (RocketPromise promise : promiseList) {
            if (promise.selfCheck() && !json.containsKey(promise.getNoteId())) {
                json.put(promise.getNoteId(), promise.getInfo());
//                System.out.println(promise.getNoteId());

            } else {
//                System.out.println("wrong info for note " + promise.getNoteId());
            }
        }
        System.out.println(json.toJSONString());

    }

}
