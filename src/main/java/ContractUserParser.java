import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ContractUserParser {
    private static final List<String> allFirstTaxList = Arrays.asList("宠物", "出行", "搞笑", "婚嫁", "家居家装", "减肥", "教育", "科技数码",
            "美食", "美妆", "萌娃", "民生资讯", "母婴", "其他", "汽车", "情感", "日常片段", "摄影", "时尚", "素材", "体育赛事", "文化",
            "文化娱乐", "星座命理", "兴趣爱好", "医疗健康", "婴童", "影视", "游戏", "娱乐", "运动健身");

    private static final String SQL_INSERT_CONTRACT="SELECT \"{user_id}\", map(\"type\", \"{type}\", \"quota\", \"{quota}\", \"end_date\", \"{end_date}\")";
    @Data
    private static class Contract {
        private enum EndDate {
            AUG("2021-08-31"),
            SEP("2021-09-30"),
            OCT("2021-10-31"),
            NOV("2021-11-30"),
            DEC("2021-12-31"),
            JAN("2022-01-31"),
            FEB("2022-02-28"),
            MAR("2022-03-31"),
            APR("2022-04-30"),
            MAY("2022-05-31"),
            JUN("2022-06-30"),
            JUL("2022-07-31"),
            ;
            @Getter
            String date;

            EndDate(String endDate) {
                this.date = endDate;
            }
        }


        private enum QuotaLevel {
            DEFAULT("9E15", "-1"),
            HEAD("8E6", "0"),
            SHOULDER("4E6", "1"),
            WAIST("2E6", "2"),
            ;
            @Getter
            String quota;
            @Getter
            String level;

            QuotaLevel(String quota, String level) {
                this.quota = quota;
                this.level = level;
            }
        }

        private String userId;
        private EndDate endDate;
        private QuotaLevel quotaLevel;

        public Contract(String userId, EndDate endDate, QuotaLevel quotaLevel) {
            this.userId = userId;
            this.endDate = endDate;
            this.quotaLevel = quotaLevel;
        }

    }


    //生成运营 & 偏好品类map
    private static String whiteUserTaxMap() {
        JSONObject result = new JSONObject();
        Map<String, List<String>> userIdFirstTaxListMap = new HashMap<>();
        result.put("userIdFirstTaxListMap", userIdFirstTaxListMap);
        userIdFirstTaxListMap.put("all", allFirstTaxList);
        userIdFirstTaxListMap.put("5c24ede9000000000703bd59", Arrays.asList("卯月", "教育", "民生资讯", "文化", "情感"));
        userIdFirstTaxListMap.put("5b21d87a11be101c1e38773b", Arrays.asList("扉间", "游戏"));
        userIdFirstTaxListMap.put("5f227912000000000101c4dc", Arrays.asList("大春", "出行"));
        userIdFirstTaxListMap.put("581049347fc5b86bb89b23ea", Arrays.asList("三顺", "民生资讯", "文化", "教育"));
        userIdFirstTaxListMap.put("5594a6665894464be38ce6ed", Arrays.asList("无脸男", "美妆"));
        userIdFirstTaxListMap.put("5c4a79c60000000011021126", Arrays.asList("莫蒂", "家居家装", "科技数码", "时尚"));
        userIdFirstTaxListMap.put("5548da92b203d96dac6672ff", Arrays.asList("无双", "时尚"));
        userIdFirstTaxListMap.put("5571951e9eb5786f2c46eb68", Arrays.asList("苗翠花", "美食"));
        userIdFirstTaxListMap.put("56081451c2bdeb3296bb9fd0", Arrays.asList("洛枳", "美食"));
        userIdFirstTaxListMap.put("5b1736dcb1da141b11b59546", Arrays.asList("美兰", "出行"));
        userIdFirstTaxListMap.put("5bff42520000000005003b71", Arrays.asList("泰菲", "影视"));
        userIdFirstTaxListMap.put("553608064fac637021b57fd6", Arrays.asList("妮诺", "母婴", "萌娃"));
        userIdFirstTaxListMap.put("5c5be5910000000018023132", Arrays.asList("志浩", "美食"));
        userIdFirstTaxListMap.put("5eda35ec0000000001003c9a", Arrays.asList("芸汐", "美妆", "时尚"));
        userIdFirstTaxListMap.put("5ca215c6000000001600597e", Arrays.asList("米咔", "娱乐"));
        userIdFirstTaxListMap.put("56502a8d484fb65bd3b95b2a", Arrays.asList("名雪", "游戏"));
        userIdFirstTaxListMap.put("5ebd67a60000000001005e0c", Arrays.asList("心夜", "教育", "科技数码", "民生资讯", "母婴", "情感", "文化"));
        userIdFirstTaxListMap.put("58589ba882ec3936de34304d", Arrays.asList("戴望洋", "美妆"));
        userIdFirstTaxListMap.put("5b3c14dfe8ac2b51c8d8b23b", Arrays.asList("李朵", "兴趣爱好"));
        userIdFirstTaxListMap.put("567bb5cf6a6a6946a7ee30fb", Arrays.asList("刘雅煊", "时尚"));
        userIdFirstTaxListMap.put("5a152ef8e8ac2b5c7a805197", Arrays.asList("宋静文", "美食"));
        userIdFirstTaxListMap.put("52b81c0bb4c4d640b8cf5c42", Arrays.asList("八戒", "美妆", "时尚"));
        userIdFirstTaxListMap.put("565a9a71b8ce1a1be634272f", Arrays.asList("美兰", "出行"));
        userIdFirstTaxListMap.put("5615e6d662a60c4fa59cbfbc", Arrays.asList("roger", "出行", "美食", "美妆", "民生资讯", "母婴", "情感", "日常片段", "时尚", "兴趣爱好", "影视", "娱乐"));
        userIdFirstTaxListMap.put("55e6d1a462a60c5a95de3f19", Arrays.asList("赛文", "出行", "美食", "美妆", "民生资讯", "母婴", "情感", "日常片段", "时尚", "兴趣爱好", "影视", "娱乐"));
        userIdFirstTaxListMap.put("5587da1fe4b1cf08683e77dc", Arrays.asList("季蒋磊", "出行"));
        userIdFirstTaxListMap.put("5a7f23714eacab5fd26856e3", Arrays.asList("巴斯", "出行", "美食"));
        userIdFirstTaxListMap.put("5ed887140000000001005786", Arrays.asList("胡安", "影视"));
        userIdFirstTaxListMap.put("5e81f191000000000100400e", Arrays.asList("王也", "时尚"));
        userIdFirstTaxListMap.put("58cc7eab50c4b40cad7d808a", Arrays.asList("王也", "时尚"));
        userIdFirstTaxListMap.put("5f4ce4ef0000000001003205", Arrays.asList("王也", "美妆"));
        userIdFirstTaxListMap.put("5f4ce57b000000000100b9ba", Arrays.asList("王也", "出行"));
        userIdFirstTaxListMap.put("5f4ce5ed0000000001003687", Arrays.asList("王也", "美食"));
        userIdFirstTaxListMap.put("5f4ce6440000000001007f79", Arrays.asList("王也", "教育"));
        userIdFirstTaxListMap.put("5f4ce6b600000000010039ef", Arrays.asList("王也", "运动健身"));
        userIdFirstTaxListMap.put("5f4ce71700000000010042f1", Arrays.asList("王也", "游戏"));
        userIdFirstTaxListMap.put("5f4ce7740000000001003c97", Arrays.asList("王也", "文化"));
        userIdFirstTaxListMap.put("5df301f40000000001002aa6", Arrays.asList("李晓晨", "娱乐", "影视", "文化娱乐", "兴趣爱好"));
        userIdFirstTaxListMap.put("5e4067680000000001000a7a", Arrays.asList("赤司", "游戏"));
        return result.toJSONString();

    }

    //生成运营 & 收藏夹map
    private static String whiteUserBoardMap() {
        JSONObject result = new JSONObject();
        Map<String, String> whiteUserIdBoardIdMap = new HashMap<>();
        Map<String, List<String>> boostUserContractMap = new HashMap<>();
        result.put("whiteUserIdBoardIdMap", whiteUserIdBoardIdMap);
        result.put("boostUserContractMap", boostUserContractMap);

        whiteUserIdBoardIdMap.put("三顺", "5ca1de7a000000000e034216");
        whiteUserIdBoardIdMap.put("大春", "5f2e68f80000000001009470");
        whiteUserIdBoardIdMap.put("扉间", "5f2e6a02000000000100979a");
        whiteUserIdBoardIdMap.put("名雪", "5f2e6df3000000000101df14");
        whiteUserIdBoardIdMap.put("美兰", "5f28c2010000000001000421");
        whiteUserIdBoardIdMap.put("苗翠花", "5f2e9127000000000100208e");
        whiteUserIdBoardIdMap.put("无双", "5f2ea3ad0000000001000856");
        whiteUserIdBoardIdMap.put("无双2", "5f34f0f00000000001000a62");
        whiteUserIdBoardIdMap.put("米咔", "5f2e6dee0000000001009ffd");
        whiteUserIdBoardIdMap.put("李朵", "5f3230da0000000001006cc1");
        whiteUserIdBoardIdMap.put("美兰2", "5f335d9f00000000010069da");
        whiteUserIdBoardIdMap.put("戴望洋", "5f3228820000000001002ed5");
        whiteUserIdBoardIdMap.put("无脸男", "5f3403d600000000010020bc");
        whiteUserIdBoardIdMap.put("卯月", "5f34b333000000000100111d");
        whiteUserIdBoardIdMap.put("季蒋磊", "5f36003800000000010009c8");
        whiteUserIdBoardIdMap.put("宋静文", "5f3b9914000000000100a9eb");
        whiteUserIdBoardIdMap.put("泰菲", "5f3ba3cf0000000001006aa5");

        loadContractedUsers(boostUserContractMap, loadContractList());


        return result.toJSONString();

    }


    /**
     * 只对最新加入的几个博主进行insert操作
     *
     * @param lastN
     * @return
     */
    private static String parseForUpdateSql(int lastN, List<Contract> contractList) {
        if (lastN < 1) {
            return "no data for sql";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO redalgo.algo_super_reder_user_info partition(dtm=xxxx)\n");

        int cnt = 0;
        for (Contract contract : contractList.subList(contractList.size() - lastN, contractList.size())) {
            String subSql = SQL_INSERT_CONTRACT.replace("{user_id}", contract.getUserId())
                    .replace("{type}", contract.getQuotaLevel().level)
                    .replace("{quota}", String.valueOf((int)Double.parseDouble(contract.getQuotaLevel().quota)))
                    .replace("{end_date}", contract.getEndDate().date)
                    ;

            sb.append(cnt++ > 0 ? " union all " : "").append(subSql);
        }


        return sb.toString();
    }


    private static List<Contract> loadContractList() {
        List<Contract> contractList = new ArrayList<>();
        contractList.add(new Contract("default_user", Contract.EndDate.AUG, Contract.QuotaLevel.DEFAULT));
        contractList.add(new Contract("5a52cc7111be1053a77bb537", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("543a03c4d6e4a9068205bed9", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("57a0cbe05e87e75371fcdb12", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("5b62fbcd4eacab4754d780ac", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5a7ef5db4eacab544e374f2c", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5732bdf582ec390aff193608", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("5adb307b4eacab5fb1348974", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("58e045255e87e75c40e7d9a1", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5623efc9f53ee075d272bcaa", Contract.EndDate.AUG, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5a9cf56c4eacab1ba7348613", Contract.EndDate.AUG, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5b1c349c11be10068c2919be", Contract.EndDate.AUG, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5555f82862a60c1f3c591a01", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("5ba70ac7b7329a00013fb5ee", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("57c010d982ec3929da6c0c86", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("595a119a82ec390499b5d0da", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("57303a5382ec392b0d932536", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("562b89930bf90c096f8fc5a4", Contract.EndDate.AUG, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("585f243c6a6a6975e96d5712", Contract.EndDate.AUG, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5b691ef96223e8000108e73e", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("5a2c7b3a11be106ed742f00a", Contract.EndDate.AUG, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("53154482b4c4d64f5296aecd", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        // 2021.1.7
//        contractList.add(new Contract("5b8a0eb883234400017f1a30", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("58873be66a6a696bf91ef87f", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        //20200909
        contractList.add(new Contract("5a93fba44eacab18ccaebff8", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5b7176d70534150001da6470", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("565a6304f53ee0117eaaecac", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
//        contractList.add(new Contract("5d57b7ca0000000001007da8", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5881a69f3460945db3d3de65", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        //20200912
        contractList.add(new Contract("5686b3b85e87e70e5dff2981", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("59c25b3a44363b437753ac94", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("55840220e4b1cf4ee29ae114", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("56b0152082ec3920b191d137", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5a48a6ace8ac2b43cc8c0079", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5600fb99a75c953a4670fa16", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5825ab465e87e75b13960668", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("55e96f24a75c950acd3358b8", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5a4d85cd11be1017de457fc8", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("589884c450c4b47d39a710ec", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5b134f7011be10055272e9b1", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("582a22cb82ec3928b46bf382", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("57f331cf50c4b4798aa73e71", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("59683f415e87e776a98957d7", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("5570ec7f5894465eb632ddc4", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5b6299474eacab15a04d3f4c", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
//        contractList.add(new Contract("566b95eca40e185506b254e6", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5b2dc0444eacab24d7c893ab", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        //20200914
        contractList.add(new Contract("5a014dd711be100655291062", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        //20200916
        // 11.19号移除
//        contractList.add(new Contract("5aed3d724eacab31d35121d0", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5a9d4bde4eacab4a1e69b3c4", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5a64aab811be106cfd490ce1", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        //20200917
        contractList.add(new Contract("55d18c56c2bdeb026a2828c1", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        //20200922
        contractList.add(new Contract("5cf5dcd60000000025015edd", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5e8986ca0000000001009a1c", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5da941ac0000000001002eac", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("575e71e35e87e71b9c162c62", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("58b003e882ec393f0e92ea52", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5754db6250c4b410104d6d48", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("558b8670484fb67efbb98ad4", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("5ab0fe8411be1049acf5a7dc", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("55263b88b203d93617b793e2", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("55658f1ba75c957db825b62e", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("55f2462a589446756d99b3dc", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("59659bfc6a6a69050b475969", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5a5eb0be11be105e04c4219c", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("5aeafe47e8ac2b1705f28619", Contract.EndDate.SEP, Contract.QuotaLevel.WAIST));
        contractList.add(new Contract("56bed0096a6a691b923ef748", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("572731ca82ec392d73de39ef", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        //0928
        contractList.add(new Contract("5a87abd6e8ac2b3ca6ab82ce", Contract.EndDate.SEP, Contract.QuotaLevel.HEAD));
        //1009
        contractList.add(new Contract("565f83a40cdc2b0d52360892", Contract.EndDate.OCT, Contract.QuotaLevel.SHOULDER));
        //1009
        contractList.add(new Contract("5cf1fd44000000001602c2bb", Contract.EndDate.OCT, Contract.QuotaLevel.HEAD));
        // 1019
        contractList.add(new Contract("5970495050c4b440fab52a1e", Contract.EndDate.OCT, Contract.QuotaLevel.SHOULDER));
        contractList.add(new Contract("55aed89c62a60c596e626148", Contract.EndDate.OCT, Contract.QuotaLevel.WAIST));

        // 1102
        contractList.add(new Contract("5af529c14eacab4dad70a133", Contract.EndDate.NOV, Contract.QuotaLevel.HEAD));
        contractList.add(new Contract("5c7a824e000000001102df80", Contract.EndDate.NOV, Contract.QuotaLevel.SHOULDER));
        //11.8不录
        contractList.add(new Contract("598cb9e45e87e703113a4b42", Contract.EndDate.SEP, Contract.QuotaLevel.SHOULDER));



        return contractList;
    }

    /**
     * 装填签约作者信息，for apollo配置
     *
     * @param boostUserContractMap
     */
    private static void loadContractedUsers(Map<String, List<String>> boostUserContractMap, List<Contract> contractList) {

        for (Contract contract : contractList) {
            boostUserContractMap.put(contract.getUserId(), Arrays.asList(contract.getQuotaLevel().getQuota(), contract.getEndDate().getDate()));
        }
    }

    public static void main(String[] args) {

        System.out.println("\n\n\n\ntax\n");
        System.out.println(whiteUserTaxMap());
        System.out.println("\n\n\n\nboard\n");
        System.out.println(whiteUserBoardMap());
        System.out.println("\n\n\n\ninsert sql\n");
        System.out.println(parseForUpdateSql(0, loadContractList()));
    }






}
