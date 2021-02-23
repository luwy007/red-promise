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
//        promiseList.add(new RocketPromise("600a6b7300000000010028bf", 5000000, 20.0f, "2021-01-27", "2021-02-10"));


        promiseList.add(new RocketPromise("6027a204000000002103797b", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6028ea0f000000000102b0ee", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e46270000000001007ed2", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e19e10000000001024ef0", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601a661d00000000010013ea", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60338c4d000000000102cf0b", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6023a78b0000000001029245", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60260646000000002103f70f", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6014d727000000000100b521", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602111640000000021034540", 723138, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60168c6d000000000100a528", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e150c0000000001005eb2", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601d1c19000000000100abd3", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e71bf0000000001026e81", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602739610000000001024a30", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601fb79c000000000102e8f3", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60325ad50000000001028ff3", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6010053d0000000001003c51", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60191da3000000000100495a", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602117d7000000002103bcb3", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60235d0a0000000021037c52", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600eaed8000000000101c493", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bc5970000000001001280", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601a41ee0000000001001603", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6031079c0000000001027d35", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6028fc540000000021038620", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602267e0000000002103e562", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60128dab000000000101e605", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60140d23000000000101f83b", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60152e09000000000101e02c", 81039, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601a7b9c000000000100b032", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6033754d000000000102f7b3", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bd18e000000000101f17d", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60166b960000000001008682", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6012660d0000000001007bde", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e84d9000000000101edd5", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6013c3d2000000000101f64b", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6020f56700000000210392d6", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60239f5d0000000001025ad6", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601d0b270000000001003915", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e253500000000210362e7", 309350, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601fe9e7000000002103f945", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e25e2000000002103639e", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60192bc7000000000101e970", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6029e846000000002103e983", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6017edba000000000101c67b", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601cb769000000000100615f", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024b6c9000000000102b72e", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6031e6640000000001028b3e", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60222f6c00000000010272d9", 87578, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e64760000000001005006", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6021fcdb000000002103956d", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601ccada00000000010046c0", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bbc58000000000101f2b5", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6029ff2a00000000010276c8", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6018f49a000000000100a56f", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024e2e70000000001026382", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602de83d000000002103f6c7", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6010edd80000000001008e65", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60264aa60000000001026b72", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6031e0be0000000021035da9", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e65a800000000010075bf", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601a6aba000000000101cdbe", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601fc1ea000000000102cd10", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("603372490000000001027d85", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6023b6810000000001025d63", 14060, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6015534d00000000010089eb", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6026631a000000000102b757", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600ff45a0000000001008783", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60150ca9000000000100a955", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60129c3f00000000010030ed", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602fa7cb0000000021038b54", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6027ad27000000000102518f", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601d22a2000000000101c22f", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e4c58000000000102c151", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e6c240000000001000703", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60339529000000002103d3e5", 817266, 42.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("603072df00000000010247b8", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e72d7000000000102932a", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6013fc4b000000000101dcad", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602495430000000001029fa0", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e28ac000000000101c080", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601aae2200000000010023fa", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602f812e000000000102557c", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601d25ea0000000001009e73", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601c08bc0000000001006c19", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6021300c000000000102cae1", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602deb0a0000000021037176", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6022631d000000002103ce01", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601fd6290000000001028703", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602bbb11000000000102c1fe", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60160b450000000001000c0f", 95397, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60122fc50000000001009bed", 81703, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bf235000000000100b6ee", 81703, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024b6b90000000021037522", 81703, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e3ba00000000001006fb4", 81703, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601fbb24000000000102f5db", 81703, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600ff6fd0000000001009386", 81703, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60113e7300000000010003d7", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6033850200000000210348db", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60193432000000000100b449", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bdc54000000000101ff2f", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e9b26000000000100a320", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602356f800000000210382f5", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60142f15000000000101d806", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601682c1000000000101c17e", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e36220000000021035993", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60289e910000000021037384", 929622, 54.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60211b5e000000000102c988", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60113e440000000001004a24", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e92d7000000000100b8cd", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602fbaa60000000001025070", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6030f7e700000000210380d3", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601aa61f000000000100312a", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602bc9890000000021038ea6", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600fff1b000000000100ba2e", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6022861b000000000102b3b8", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601568cf000000000100818d", 327328, 8.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601d130e000000000101ef02", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024dbf4000000002103af88", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600ff18d00000000010013e0", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60325199000000000102ac2e", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6030e1ab0000000021034412", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6033a347000000000102aa8c", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60192ad2000000000100bed5", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602cec48000000000102c41c", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6031ef4c00000000210345f7", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602b81740000000021035a0e", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60168f1e00000000010031a2", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6012525000000000010081c8", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602f7fdc000000000102e2a0", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602fac950000000001026704", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6013d8f6000000000100a96a", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601b9235000000000100955b", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602a21cc0000000021034c64", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e330e000000002103e0e3", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601fc900000000002103d9cb", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6033794e000000002103a702", 43666, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6029d4f00000000021034438", 221513, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6021fa52000000000102a552", 221513, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60169af6000000000100b0aa", 221513, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601f580b0000000001009d9b", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6030ef6c000000000102cce6", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6018c09f000000000100968b", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6010d855000000000100a6b2", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6014cc2c00000000010065c4", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6021fb23000000002103e20a", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60273805000000000102ad40", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602b2b560000000021036a56", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600f863e000000000101e8cb", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601cb6140000000001008a2c", 57716, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602359cd00000000010261f6", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6028aeb0000000000102a4be", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bbe61000000000100271e", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024cea70000000021037996", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602ca6020000000021036232", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602a330b000000002103ed81", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e8a0e0000000001001eef", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60334a91000000000102d3f7", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60124de20000000001001598", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e6793000000000100010a", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6018dff0000000000100b928", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602f55ec0000000001024a1a", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601d19820000000001001038", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6020e669000000000102e458", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601a64f4000000000100ac65", 273613, 9.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602128c8000000000102578f", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602fad73000000002103f8de", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60261ba30000000021036e05", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602a64300000000021034b25", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60339c5d000000002103461e", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6012a63a000000000101e9db", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601be0480000000001000143", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602badb5000000002103b448", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6013f68400000000010082ca", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601696ce000000000100195a", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601002220000000001006284", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e80a8000000000101f064", 32605, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601633ad0000000001005cd4", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6014d265000000000101f63c", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601a1d1c000000000100a9de", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601f6fca00000000010079a2", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602cd9950000000001028c51", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60339de0000000000102ca44", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e246000000000010035f6", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024a51e000000002103c678", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602df0150000000001024c22", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60227f7a000000000102f502", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6031f6f4000000002103bca2", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602768d30000000021039f58", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602b3a85000000000102788f", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6018c0ef0000000001001f46", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601cd36b000000000100a76a", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601381570000000001004436", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602e64f2000000002103d80e", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60265de8000000002103ad33", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601b6f39000000000101db9b", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6024a628000000002103ca89", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600f963c000000000100b05c", 5682, 6.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6014c1b8000000000101e9f2", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601376120000000001004b5f", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60121b20000000000100bf90", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601bc6ef000000000101f1d0", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e1408000000000100bac2", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60325fac000000002103b2e4", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601f7c0100000000010086ca", 154376, 10.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6016152c000000000100b921", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60331b43000000000100b2f1", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60288ef9000000000101d803", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601cae14000000000101d179", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6020aa11000000000101e073", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602f1d94000000000101ea96", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("600e3bbe000000000101d7aa", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60121e3200000000010029d8", 89686, 7.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601e0936000000000101e0f1", 261099, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602de34d000000002103630b", 261099, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("601017b000000000010082e1", 261099, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6017c7c0000000000101f401", 261099, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("602b6372000000002103dbc3", 261099, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("60278afc000000002103ac0b", 261099, 19.0f, "2021-02-23", "2021-02-28"));
        promiseList.add(new RocketPromise("6030c509000000002103eedb", 261099, 19.0f, "2021-02-23", "2021-02-28"));

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
