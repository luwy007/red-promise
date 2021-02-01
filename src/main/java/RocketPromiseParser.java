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
//        promiseList.add(new RocketPromise("123Note", 1000, 1, "2021-01-01", "2021-01-31"));
        // 1.15
        // 1.27停止扶持
//        promiseList.add(new RocketPromise("600154660000000001004e6b", 50000000, 30, "2021-01-14", "2021-01-31"));
//        promiseList.add(new RocketPromise("6002da48000000000101d435", 50000000, 30, "2021-01-14", "2021-01-31"));
//        promiseList.add(new RocketPromise("6003bf300000000001001840", 50000000, 30, "2021-01-14", "2021-01-31"));
//        promiseList.add(new RocketPromise("6006a6bc000000000100a403", 50000000, 30, "2021-01-14", "2021-01-31"));

        // 1.19 签约保量
        // 1.22 保量完成 55f2462a589446756d99b3dc kiki_zhu
//         promiseList.add(new RocketPromise("5fe875c90000000001000e3f", 2000000, 10, "2021-01-14", "2021-01-31"));
//         promiseList.add(new RocketPromise("5ff446f3000000000101d846", 2000000, 10, "2021-01-14", "2021-01-31"));
//         promiseList.add(new RocketPromise("5ff974fa0000000001000e80", 2000000, 10, "2021-01-14", "2021-01-31"));
//         promiseList.add(new RocketPromise("5ffec0560000000001008dc5", 2000000, 10, "2021-01-14", "2021-01-31"));

        // 1.21 保量
//        保量完成 1.21 5b2dc0444eacab24d7c893ab 汪七月
//        promiseList.add(new RocketPromise("5ffc222e000000000100845d", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff7d8560000000001001956", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe32c4e000000000100bf76", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe1b95b000000000101c356", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6007ff900000000001002548", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffebd070000000001007083", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb02b9000000000100b3fe", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff46094000000000100a4bd", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe6f56d0000000001005eb0", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec3e830000000001000ac5", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff18a750000000001000a75", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec4171000000000100a9d8", 2000000, 8, "2021-01-20","2021-01-31"));


        // 56bed0096a6a691b923ef748 小玛丽
//        promiseList.add(new RocketPromise("5ffe69ee000000000101d104", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed9ef50000000001006efd", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff4428b000000000101c52f", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6e5cf000000000100b0c7", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff185950000000001003570", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff985080000000001001b2e", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6000181c0000000001009a59", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6002cbf8000000000101c93d", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6008059d0000000001006e42", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb0407000000000100b9b6", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe869e5000000000101e327", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60056e880000000001008ac6", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffc29fb000000000100414d", 2000000, 7, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd7b730000000001001466", 2000000, 7, "2021-01-20","2021-01-31"));;

        //        保量完成 1.21 589884c450c4b47d39a710ec 彭小仙
//        promiseList.add(new RocketPromise("5ff9625f00000000010095f4", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe1862a0000000001005fb5", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feed8780000000001002667", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60080d55000000000100227b", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe1899d0000000001000fc2", 2000000, 6, "2021-01-20","2021-01-31"));

//        保量完成 1.21 5825ab465e87e75b13960668 kikibabyii
//        promiseList.add(new RocketPromise("6007f13f0000000001009dbe", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2c2600000000001005230", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe7362d00000000010022eb", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe4883b0000000001003ed2", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fedc87b000000000100587f", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed54fd000000000100bdef", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6e14f00000000010015d9", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe8a246000000000101d9a3", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe3494500000000010081b7", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffef07d000000000100bceb", 2000000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff9d3500000000001007b85", 2000000, 6, "2021-01-20","2021-01-31"));


        // 乔卡 55263b88b203d93617b793e2
        // 1.22保量结束

//        promiseList.add(new RocketPromise("5fe6de04000000000100be73", 2000000, 10, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed70000000000001003bc3", 2000000, 10, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff468ac000000000100882e", 2000000, 10, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6000145600000000010037ba", 2000000, 10, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff433f200000000010068ad", 2000000, 10, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60026592000000000100a6b6", 2000000, 10, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600142fa0000000001000bc9", 2000000, 10, "2021-01-20","2021-01-31"));


//        保量完成 1.21 5b6299474eacab15a04d3f4c 一个ki
//        promiseList.add(new RocketPromise("6006d0660000000001003c90", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec635d00000000010071c8", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2dc85000000000101e112", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe1e4a50000000001003ddf", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2db80000000000100ab73", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe46d6e00000000010063fc", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffab86e000000000100898c", 2000000, 5, "2021-01-20","2021-01-31"));


//        保量完成 1.21 55e96f24a75c950acd3358b8 球大王
//        promiseList.add(new RocketPromise("6003b46300000000010082f9", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feec9100000000001009a77", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6cb99000000000101da9c", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff3e89f000000000101dd13", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff13f080000000001001a35", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2d629000000000100936b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffbe84500000000010029a6", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff92db10000000001007a6d", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff53c60000000000101da70", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffe754d0000000001001156", 2000000, 5, "2021-01-20","2021-01-31"));


//        保量完成 1.21  59683f415e87e776a98957d7 桐桐桐掌柜
//        promiseList.add(new RocketPromise("5fe33d4b0000000001005227", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe9463d000000000101f077", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6725e000000000101c3ed", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60051c710000000001006a97", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec28bd0000000001004258", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe174150000000001005f37", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feffe080000000001003fd9", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe4558e0000000001001d43", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2d68d000000000100351f", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fffc45200000000010065e8", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feff6aa000000000101c405", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60067b1d0000000001009951", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffae0f100000000010057ea", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd7ab800000000010010ae", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6001359000000000010095d6", 2000000, 5, "2021-01-20","2021-01-31"));

        // susan苏
//        promiseList.add(new RocketPromise("5ffe368e0000000001004524", 2000000, 8, "2021-01-20","2021-01-31"));


//        保量完成 1.21 56b0152082ec3920b191d137 萱婶儿
//        promiseList.add(new RocketPromise("600578f9000000000101e30b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff5966a000000000100b250", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6c8030000000001002a02", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec38c900000000010034f9", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6007a57800000000010099ad", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd78a20000000001009a33", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5bd86000000000100a49c", 2000000, 5, "2021-01-20","2021-01-31"));

        //55658f1ba75c957db825b62e didiya_
//        promiseList.add(new RocketPromise("5ffd6dc3000000000100a553", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600172d4000000000100aa47", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffc1a71000000000101c8b5", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff42985000000000101d384", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600546b7000000000101f8e9", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec362a000000000101f87b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5b9870000000001003bd1", 2000000, 5, "2021-01-20","2021-01-31"));

        // 欧尼 5c7a824e000000001102df80
        // 1.23 保量完成
//        promiseList.add(new RocketPromise("5feda5de00000000010003c0", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fedc14b00000000010079d8", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb01b8000000000100594d", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff82efe000000000101eef0", 2000000, 8, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec567c0000000001007d2d", 2000000, 8, "2021-01-20","2021-01-31"));

        // 眼仔 5a93fba44eacab18ccaebff8
        // 1.22保量结束

//        promiseList.add(new RocketPromise("5ff4027d0000000001008678", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffe652f0000000001004402", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff99cc40000000001000666", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff549ed000000000101cd6f", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed4438000000000101c008", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff156220000000001009ddd", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe702cd00000000010036ab", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff03e9a000000000100770f", 2000000, 4, "2021-01-20","2021-01-31"));

//        保量完成 1.21 5570ec7f5894465eb632ddc4 两只仙女
//        promiseList.add(new RocketPromise("5ff194c600000000010036b6", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2e0600000000001008189", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe46274000000000100ad23", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5b41d000000000100ba3f", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed47c100000000010036bc", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6002c58f000000000101f0c5", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6d2380000000001009b14", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe9ad57000000000100852a", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff5321900000000010094fc", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feedbfb000000000101d91e", 2000000, 3, "2021-01-20","2021-01-31"));

//        保量完成 1.21 57c010d982ec3929da6c0c86 无敌小小刘
//        promiseList.add(new RocketPromise("5fe97536000000000100ad26", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffaba7600000000010090e6", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec48a700000000010036cc", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed807b00000000010034aa", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff19e1e0000000001001ceb", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5b5f40000000001008297", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5cee90000000001007009", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe440a00000000001000dd4", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe474830000000001002381", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe713d300000000010064fe", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff82ae80000000001001984", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffe804600000000010080ae", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff95d060000000001002389", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6007dde70000000001008b78", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe851270000000001003140", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff40245000000000101f91a", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60017122000000000100541c", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600564810000000001007d07", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6002c2990000000001001db1", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe72e810000000001003da1", 2000000, 3, "2021-01-20","2021-01-31"));

        // 1.22 保量完成 5a48a6ace8ac2b43cc8c0079 馥蕾杨
//        promiseList.add(new RocketPromise("5ff6c25d000000000100993b", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60003566000000000100501e", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6007d0d60000000001007396", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600054da000000000100b17e", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff829ba000000000100a7ce", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec9f23000000000101e8bd", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffaebc10000000001004ce0", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6002b730000000000101eede", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed9a17000000000100b369", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff443530000000001003aca", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe9f5770000000001008420", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6003ff820000000001003222", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffe6e4e0000000001003531", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd12c8000000000100b5a4", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5590d0000000001005c24", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe6f5f70000000001003b97", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff9896f000000000100851f", 2000000, 3, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb0a75000000000101c666", 2000000, 3, "2021-01-20","2021-01-31"));

//        1.22 保量
//        小双双Jodie  58e045255e87e75c40e7d9a1
//        promiseList.add(new RocketPromise("5ff5283a000000000100afe0", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fea9c090000000001000d2b", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd1134000000000100278e", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffa6e590000000001000310", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff133d00000000001002e63", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff7cb540000000001007fd8", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff52c09000000000101dec9", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6004fa8d000000000100ba00", 2000000, 4, "2021-01-20","2021-01-31"));

//        5b1c349c11be10068c2919be	茜卡Sika
//        promiseList.add(new RocketPromise("600170570000000001001dc8", 200000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff827a6000000000101cb59", 200000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff94eae0000000001008000", 200000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60055c3d0000000001002a84", 200000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd79500000000001009c75", 200000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feda28b0000000001007e62", 200000, 6, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6006ae38000000000101eaf1", 200000, 6, "2021-01-20","2021-01-31"));

//        572731ca82ec392d73de39ef	一匹野马
//        promiseList.add(new RocketPromise("5fedc23e0000000001002e8a", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb34a60000000001007ed0", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60000af60000000001000e5f", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600566f50000000001001abb", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe72c89000000000100569d", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe9d9620000000001006517", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff440660000000001002f83", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6008414d0000000001006092", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe8801d0000000001005e78", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec9dd8000000000100107c", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffbf296000000000100b8f1", 2000000, 4, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5e06900000000010085f5", 2000000, 4, "2021-01-20","2021-01-31"));


//        5623efc9f53ee075d272bcaa	赖小小
//        promiseList.add(new RocketPromise("5ff3075700000000010014be", 200000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff1b16f0000000001006e5d", 200000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6002c07400000000010087d5", 200000, 5, "2021-01-20","2021-01-31"));

//        5a9d4bde4eacab4a1e69b3c4	黎子雾
        // 1.22保量结束

//        promiseList.add(new RocketPromise("5fe9c1440000000001009e4d", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6006baf50000000001001299", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6ef300000000001000eaf", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb1247000000000101eb23", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5bf68000000000101e82f", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6000204d0000000001003447", 2000000, 5, "2021-01-20","2021-01-31"));

//        55840220e4b1cf4ee29ae114	是徐老师呀
        // 1.22保量结束

//        promiseList.add(new RocketPromise("5fede732000000000101e6ac", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6007ed9f0000000001000561", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feb0c8b000000000100489b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6001547c00000000010019b6", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6003c07d00000000010076d2", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2e6050000000001006bb9", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fedef380000000001009176", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6006c456000000000100bef5", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fedf2620000000001004912", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff0731a000000000100541b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd8ddd0000000001006aca", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff85f4a0000000001005d86", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff1c0160000000001006f6b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fffbde10000000001001c1a", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffaee7700000000010059d0", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff57e14000000000101de3b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feddd1d00000000010070e2", 2000000, 5, "2021-01-20","2021-01-31"));

//        5555f82862a60c1f3c591a01	缺点钙
        // 1.22保量结束
//        promiseList.add(new RocketPromise("5fed9d1f0000000001006698", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("6006a939000000000101d25a", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fef2322000000000101f17d", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff864c0000000000100babf", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff2e0490000000001002104", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff0474200000000010059e4", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60012f6f000000000100bb9b", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff9c3fa00000000010043ff", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5feaf9c80000000001008b63", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600808480000000001007c62", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffefa9f000000000101d146", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe8893d000000000101ec5d", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("60003fd30000000001004175", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe5b23d00000000010070ce", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd89e8000000000100a8f6", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff44f6b0000000001002fa4", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fec457c000000000100290d", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff6da67000000000100baca", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("600541f8000000000101e296", 2000000, 5, "2021-01-20","2021-01-31"));


//        5a9cf56c4eacab1ba7348613	-whispersun
        // 1.22保量结束

//        promiseList.add(new RocketPromise("6005904500000000010048da", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd9d6300000000010075e2", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe88998000000000101edf3", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fe888c20000000001002266", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff59eba0000000001000fcf", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5fed9e6c00000000010026b3", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ff5ae8600000000010015cf", 2000000, 5, "2021-01-20","2021-01-31"));
//        promiseList.add(new RocketPromise("5ffd9e2e0000000001008c0b", 2000000, 5, "2021-01-20","2021-01-31"));

        // 1.23 测试
        promiseList.add(new RocketPromise("6008fa5e00000000010089c1", 2000000, 6.0f, "2021-01-20","2021-01-31"));

        // 1.27 游戏测试 四篇，给一样的扶持系数，预跑一段时间，看数据效果
//        promiseList.add(new RocketPromise("60085666000000000101d19f", 100000, 10.0f, "2021-01-27","2021-02-01"));
//        promiseList.add(new RocketPromise("6008570d0000000001003fc8", 100000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("60094b7a0000000001001107", 100000, 20.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("601101610000000001000122", 100000, 20.0f, "2021-01-27","2021-02-01"));

        // 巫师第5篇笔记
        promiseList.add(new RocketPromise("600a6b7300000000010028bf", 5000000, 20.0f, "2021-01-27","2021-02-10"));

        // 1.28 游戏测试 第5篇，给一样的扶持系数，预跑一段时间，看数据效果
        promiseList.add(new RocketPromise("601132f6000000000100b0f7", 100000, 20.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("601265ec000000000100a155", 100000, 20.0f, "2021-01-27","2021-02-01"));

        // 1.28 美妆活动 测试
        promiseList.add(new RocketPromise("5ff2f61e00000000010074f9", 1000000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("60059d43000000000101d4cd", 1000000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("600e974b000000000101d22b", 1000000, 10.0f, "2021-01-27","2021-02-01"));

        // 1.28 vlog品类
        promiseList.add(new RocketPromise("600d39f8000000000100b9a0", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("600d3bb000000000010049e2", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("60091b0a000000000100221b", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("5fe6e2550000000001002ccb", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("600d073f000000000100873a", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("6007953a0000000001009adf", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("6002d4df000000000101f6b4", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("5ffaa9a80000000001002e70", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("5ff5378c000000000100aa7d", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("5fe36063000000000101d99b", 10000, 10.0f, "2021-01-27","2021-02-01"));
        promiseList.add(new RocketPromise("5fdf61fe000000000100b4bb", 10000, 10.0f, "2021-01-27","2021-02-01"));


        // 1.29巫师小推第6篇
        promiseList.add(new RocketPromise("60113284000000000100ae57", 3000000, 20.0f, "2021-01-27","2021-02-10"));

        // 1.30 游戏
        promiseList.add(new RocketPromise("60138ab800000000010071f4", 100000, 10.0f, "2021-01-27","2021-02-10"));

        // 1.30 长板与建鹏
        promiseList.add(new RocketPromise("60112dbc0000000001006cc0", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600fc590000000000101d73e", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("600e1ad3000000000101cfd0", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("6007a0520000000001008545", 100000, 10.0f, "2021-01-27","2021-02-10"));
        promiseList.add(new RocketPromise("6006ce280000000001002de3", 100000, 10.0f, "2021-01-27","2021-02-10"));





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
