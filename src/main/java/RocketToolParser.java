import lombok.Data;

public class RocketToolParser {

    private static String ChangeOwnerSql = "INSERT overwrite TABLE redalgo.algo_rocket_support_user_info\n" +
            "SELECT user_id,\n" +
            "       extra_info\n" +
            "FROM redalgo.algo_rocket_support_user_info\n" +
            "WHERE extra_info[\"operator_name\"] NOT IN (\"三顺（浦玲丽）\",\n" +
            "                                          \"荀攸（曹海鹏）\")\n" +
            "UNION ALL\n" +
            "SELECT user_id,\n" +
            "       map(\"type\", cate, \"operator_name\", \"卯月（王梓）\", \"create_time\", create_time) AS extra_info\n" +
            "FROM\n" +
            "  (SELECT user_id,\n" +
            "          extra_info[\"create_time\"] AS create_time,\n" +
            "          extra_info[\"type\"] AS cate\n" +
            "   FROM redalgo.algo_rocket_support_user_info\n" +
            "   WHERE extra_info[\"operator_name\"] IN (\"三顺（浦玲丽）\",\n" +
            "                                         \"荀攸（曹海鹏）\"))a";



    @Data
    private static class ToolUser {
        private String userId;
        private String userName;
        private String email;
        private String albumId;

        public ToolUser(String userId, String userName, String email, String albumId) {
            this.userId = userId;
            this.userName = userName;
            this.email = email;
            this.albumId = albumId;
        }

    }

    private static String curlParser(ToolUser toolUser) {

        String result = "curl -i -X POST -H 'Content-Type: application/json' -d '{\"userId\": \"{user_id}\", \"albumId\":\"{album_id}\", \"email\":\"{email}\", \"displayName\":\"{name}\"}' https://rocket.devops.xiaohongshu.com/api/rocket/note/collect/mapping";
        return result.replace("{user_id}", toolUser.getUserId())
                .replace("{album_id}", toolUser.getAlbumId())
                .replace("{email}", toolUser.getEmail())
                .replace("{name}", toolUser.getUserName());
    }



    public static void main(String[] args) {

        // rec-dev05执行
        String result = curlParser(new ToolUser("5e4a5755000000000100437c", "孙博（实习）", "bosun@xiaohongshu.com", "5f5f504d0000000001005a5e"));
        result = curlParser(new ToolUser("5e4067680000000001000a7a", "赤司（张文骏）", "akashi@xiaohongshu.com", "5f6179ec0000000001006cfb"));
        result = curlParser(new ToolUser("564fd3d80bf90c608177dd14", "傅明（谷然）", "fuming@xiaohongshu.com", "5f6488c0000000000101c3f6"));
        result = curlParser(new ToolUser("5bb0debdf2407b00019780af", "王珂懿（实习）", "keyiwang@xiaohongshu.com", "5f8fc9d400000000010063cf"));
        result = curlParser(new ToolUser("59ea2f0ee8ac2b2f9719f075", "顾唯钰（实习）", "weiyugu@xiaohongshu.com", "5f963e370000000001008dd5"));
        result = curlParser(new ToolUser("5aab3ff9e8ac2b21f4d69321", "王拓西（实习）", "tuoxiwang@xiaohongshu.com", "5fa5092300000000010073f7"));
        result = curlParser(new ToolUser("5b4b3e4f11be105be8d3467b", "兰雨婷（实习）", "yutinglan@xiaohongshu.com", "5fbb3aca000000000100a0dd"));
//        result = curlParser(new ToolUser("5688b3c950c4b43adf32a44a", "王伊卿（实习）", "yiqingwang@xiaohongshu.com", "5fbe1bc20000000001007d9e"));
//        result = curlParser(new ToolUser("5cd6f72b0000000010035a6e", "向贤杰（实习）", "xianjiexiang@xiaohongshu.com", "5f4f5e7900000000010056b6"));
        result = curlParser(new ToolUser("52b81c0bb4c4d640b8cf5c42", "八戒（卢文羊）", "bajie@xiaohongshu.com", "5f87f78b0000000001007b4d"));
        result = curlParser(new ToolUser("56a3247f50c4b44f140ba2a7", "王琬琪（实习）", "wanqiwang@xiaohongshu.com", "5ff5679c00000000010039d4"));
        result = curlParser(new ToolUser("55d4bd8167bc654423b7ed3f", "可达鸭（薛伟欣）", "psyduck@xiaohongshu.com", "5ffd88c6000000000101ec9b"));

        System.out.println(result);

    }
}
