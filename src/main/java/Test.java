import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.xiaohongshu.sns.enums.IdType;
import com.xiaohongshu.sns.exception.IdMappingException;
import com.xiaohongshu.sns.util.IdMapping;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.hash;

public class Test {


    public static List<Double> generateVec(int len, double avg, double var) {
        Random r = new Random();
        List<Double> vec = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            vec.add(r.nextGaussian() * var + avg);
        }
        return vec;
    }

    public static double dot(List<Double> vec1, List<Double> vec2) {
        if (vec1 == null || vec2 == null || vec1.size() != vec2.size()) {
            return -10000000000.0;
        }
        double result = 0;
        for (int i = 0; i < vec1.size(); i++) {
            result += vec1.get(i) * vec2.get(i);
        }
        return result;
    }

    public static double cos(List<Double> vec1, List<Double> vec2) {
        return dot(vec1, vec2) / Math.sqrt(dot(vec1, vec1) * dot(vec2, vec2));
    }

    public static double guassianNum() {
        Random r = new Random();
        double num = r.nextGaussian();
        return num;
    }

    @lombok.Data
    public static class Data {
        int a;
    }

    public static long oidToLong(String oid) {
        long result = 0;
        try {
            result = IdMapping.oidToLong(oid, IdType.NOTE);
        } catch (IdMappingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String longToOid(long id) {
        String result = "";
        try {
            result = IdMapping.longToOid(id);
        } catch (IdMappingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 保量计划
     */
    @lombok.Data
    public static class ImpGuaranteePlan {
        /**
         * 以下参数，是从mysql or apollo中默认读取的
         */
        String noteId;
        // 计划起始时间
        Date beginDate = new Date();
        // 计划结束时间
        Date endDate = new Date();
        // 此次定保的目标曝光量
        float quota = 0;
        // 累积历史所有定保流量，得出的目标曝光量。
        // 譬如历史累积投放100w，此次新定保流量是10w，则defaultImpGoal是110w
        float defaultImpGoal = 1000;
        // 自调节投放目标量，<0时，表示不生效
        float selfAdjustableImpGoal = -1;
        // 人为指定boost系数，覆盖自动化计算结果
        float defaultBoost = -1.0f;

        // 记录上一次更新plan的boost系数时，已经有的曝光次数
        int lastUpdatedImp = 0;
        // 记录此plan被更新次数
        int updateCnt = 0;

    }


    private static final Map<String, Float> hourImpRatio = new HashMap<>();


    static {
        hourImpRatio.put("00", 4.44f);
        hourImpRatio.put("01", 2.40f);
        hourImpRatio.put("02", 1.31f);
        hourImpRatio.put("03", 0.83f);
        hourImpRatio.put("04", 0.64f);
        hourImpRatio.put("05", 0.67f);
        hourImpRatio.put("06", 1.21f);
        hourImpRatio.put("07", 2.16f);
        hourImpRatio.put("08", 3.04f);
        hourImpRatio.put("09", 3.78f);
        hourImpRatio.put("10", 4.24f);
        hourImpRatio.put("11", 4.52f);
        hourImpRatio.put("12", 5.33f);
        hourImpRatio.put("13", 5.24f);
        hourImpRatio.put("14", 4.92f);
        hourImpRatio.put("15", 5.16f);
        hourImpRatio.put("16", 5.33f);
        hourImpRatio.put("17", 5.17f);
        hourImpRatio.put("18", 5.11f);
        hourImpRatio.put("19", 5.93f);
        hourImpRatio.put("20", 6.50f);
        hourImpRatio.put("21", 7.30f);
        hourImpRatio.put("22", 8.04f);
        hourImpRatio.put("23", 6.73f);
    }


    /**
     * 计算投放时间进度
     *
     * @return
     */
    private static float calTimePace(ImpGuaranteePlan plan) {
        SimpleDateFormat hhFormatter = new SimpleDateFormat("HH");
        float total = 0.0f;
        float tillNow = 0.0f;
        Long time = plan.getBeginDate().getTime();
        Long nowTime = (new Date()).getTime();
        while (time < plan.getEndDate().getTime()) {
            float timePeriod = hourImpRatio.get(hhFormatter.format(new Date(time)));
            total += timePeriod;
            tillNow += time < nowTime ? timePeriod : 0;
            time += 60 * 60 * 1000L;
        }

        if (total <= 0) {
            return 1000;
        }

        return tillNow / total;
    }


    public static String function2(String str) {
        int n = str.length();
        String res = "";
        boolean[][] f = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) f[i][j] = true;
                if (j > 0 && str.charAt(i) == str.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                }
                if (f[i][j]) {
                    if (res.length() < (j - i + 1)) {
                        res = str.substring(i, j + 1);
                    }
                }
            }
        }
        return res;

    }


    public static String function(String str) {
        int n = str.length();
        String res = "";
        boolean[][] f = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) f[i][j] = true;
                if (j > 0 && i + 1 < j && str.charAt(i) == str.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1];
                }
                if (i + 1 == j && j > 0) {
                    f[i][j] = str.charAt(i) == str.charAt(j);
                }
                if (f[i][j]) {
                    if (res.length() < (j - i + 1)) {
                        res = str.substring(i, j + 1);
                    }
                }
            }
        }
        return res;

    }

    /**
     * 计算wilson_boundary/ctr
     */
    private static float calBoostRatio(float impression, float click, boolean isUpper, double z) {
        if (impression * click == 0 || impression < click) {
            return 2.0f;
        }
        float ctr = (click + 0.01f) / (impression + 0.1f);
        float ratio = wilsonBoundary(impression, click, isUpper, z) / ctr;

        // 对部分ctr较好的笔记，进行boost。
        if (isUpper) {
            double ctrBase = 0.15;
            ratio *= Math.max(click / (impression + 1) / ctrBase, 1.0);
        }
        return ratio;
    }


    /**
     * 计算wilson边界
     */
    private static float wilsonBoundary(float impression, float click, boolean isUpper, double z) {
        if (impression * click == 0 || impression < click) {
            return 0.f;
        }
        double n = impression;
        double p = click / impression;
        double signal = isUpper ? 1.0 : -1.0;
        float score = (float) ((p + z * z / (2.f * n) + signal * z * Math.sqrt((p * (1.0f - p) + z * z / (4.f * n)) / n)) / (1.f + z * z / n));
        return score;
    }

    private static double calWilsonVauleModel(float p, float n) {
        return (p + (2.0 / n) - (1.0 / n) * Math.sqrt(4.0 * n * (1.0 - p) * p + 4.0)) / (1.0 + 4.0 / n);
    }


    private static Map<String, String> parseForMap() {
        if (false) {
            return new HashMap<>();
        }
        try {
            return new HashMap<>();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static int calImpGoal(int predImp, List<Double> mags, List<Integer> impSegs) {
        //加一个最大边界
        List<Integer> tmpImpSegs = new ArrayList<>();
        List<Double> tmpMags = new ArrayList<>();
        tmpImpSegs.addAll(impSegs);
        tmpMags.addAll(mags);
        mags = tmpMags;
        impSegs = tmpImpSegs;
        impSegs.add(1000000000);

        for (int i = mags.size(); i < impSegs.size(); i++) {
            mags.add(1.0);
        }
        double impGoal = 0;

        if (predImp < impSegs.get(0)) {
            impGoal = predImp * mags.get(0);
            return (int) impGoal;
        } else {
            impGoal = impSegs.get(0) * mags.get(0);

        }

        int i = 1;
        for (; i < impSegs.size(); i++) {
            if (predImp < impSegs.get(i)) {
                break;
            }
            impGoal += calImpGoal(impSegs.get(i - 1), impSegs.get(i), impSegs.get(i) - impSegs.get(i - 1), mags.get(i - 1), mags.get(i));
        }

        impGoal += calImpGoal(impSegs.get(i - 1), impSegs.get(i), predImp - impSegs.get(i - 1), mags.get(i - 1), mags.get(i));


        return (int) impGoal;
    }

    private static int calImpGoal(int smallImpBorder, int bigImpBorder, int impSeg, double lastMag, double thisMag) {
        double avgMag = (2 * lastMag - (lastMag - thisMag) * impSeg / (bigImpBorder - smallImpBorder)) / 2;
        int impGoal = (int) (impSeg * avgMag);
        return impGoal;
    }


    private static void generateLeftSql(String sql, Map<String, String> feaMap) {
        for (String feaKey : feaMap.keySet()) {
            System.out.println(sql.replace("{fea}", feaMap.get(feaKey)).replace("{sub_fea}", feaKey));
        }
    }

    private static void generateSql(String sql, List<String> feaList) {
        for (String feaKey : feaList) {
            System.out.println(sql.replace("{sub_fea}", feaKey));
        }
    }

    @lombok.Data
    static class NoteInfo {
        double score;

        public NoteInfo(double score) {
            this.score = score;
        }
    }

    public static String getNDaysBeforeDs(int nDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nDaysBefore = new Date((new Date()).getTime() + nDays * 24 * 3600 * 1000L);
        return sdf.format(nDaysBefore);
    }

    private static final double EARTH_RADIUS = 6378137;//赤道半径


    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }

    public static double getDistance(double lon1, double lat1, double lon2, double lat2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lon1) - rad(lon2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        return s;//单位米
    }

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public static float evaluate(List<String> dateNumList, String date, float cnt, int days) {
        float ratio = 1.0f;
        String daysBeforeDate = "2000-01-01";
        try {
            daysBeforeDate = sdf.format(new Date((sdf.parse(date)).getTime() - days * 24 * 3600 * 1000L));
        } catch (Exception e) {

        }
        dateNumList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        boolean found = false;
        for (String dateNum : dateNumList) {
            String[] dateNumStr = dateNum.split("_");
            if (daysBeforeDate.compareTo(dateNumStr[0]) > 0) {
                continue;
            }

            found = true;
            if (daysBeforeDate.compareTo(dateNumStr[0]) == 0) {
                ratio = cnt / Integer.parseInt(dateNumStr[1]);
                break;
            } else {
                ratio = cnt;
                break;
            }
        }
        return found ? ratio : cnt;
    }


    public static Double evaluate(Double click, Double imp) {
        Double result = -1.0;
        if (click == null || imp == null) {
            return result;
        } else if (click > imp) {
            result = 1.0;
        } else {
            double ratio = click / imp;
            double numerator = ratio + 0.5 * 3.84 / imp - 1.96 * Math.sqrt(ratio * (1 - ratio) / imp + 0.96 / imp / imp);
            double denominator = 1 + 3.84 / imp;
            result = numerator / denominator;
        }

        return result;
    }

    @lombok.Data
    public static class Query {
        int num = 0;

        public Query(int num) {
            this.num = num;
        }
    }

    private void test(int n) {
        cnt += n;
    }

    private void test2() {
        test(20);
    }

    private static int cnt = 0;


    public static String join(List<String> strList, String joiner) {
        StringBuilder sb = new StringBuilder();
        if (strList == null || strList.size() < 1) {
            return "";
        }
        for (int i = 0; i < strList.size() - 1; i++) {
            sb.append(strList.get(i)).append(joiner);
        }
        sb.append(strList.get(strList.size() - 1));
        return sb.toString();
    }

    private static void filterTop20() {

        String line = "";
        String splitBy = ",";
        Map<String, Integer> mainTagCounter = new HashMap<>();
        Set<String> opNames = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/yang/Downloads/data.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/yang/Downloads/data_filtered.csv"));


//            line = br.readLine();
            while ((line = br.readLine()) != null) {
                line = line.replace("\"", "");
                String[] items = line.split(splitBy);
                opNames.add(items[0]);
                mainTagCounter.put(items[0], mainTagCounter.getOrDefault(items[0], 0) + 1);
                if (mainTagCounter.get(items[0]) > 20) {
                    continue;
                } else {
                    bw.write(line + "\n");
                }
            }
            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {


        filterTop20();
        if (true) {
            return;
        }

        List<String> noteIdList = Arrays.asList();
        System.out.println(new HashSet(noteIdList).size());


        try {
            System.out.println(String.valueOf(IdMapping.oidToLong("62579dd9000000000101fe5e", IdType.ALBUM)));
            System.out.println(String.valueOf(IdMapping.oidToLong("5628cbb182718c5e15f371cb", IdType.USER)));
            System.out.println(String.valueOf(IdMapping.oidToLong("62988a35000000002103fd48", IdType.NOTE)));


            System.out.println(String.valueOf(IdMapping.longToOid(279944196772028195L)));
            System.out.println(String.valueOf(IdMapping.longToOid(279944600784190238L)));


            System.out.println(String.valueOf(IdMapping.longToOid(2305844687369329682L)));
            Set<String> userIdSet = new HashSet<>(Arrays.asList());
            String stmt = "SELECT noteId, " +
                    "       ((realQuota- historyQuota)/incQuota) AS imp_pace, " +
                    "       (TIMESTAMPDIFF(MINUTE, startTime, now())/ TIMESTAMPDIFF(MINUTE, startTime, endTime)) AS time_pace, " +
                    "       (realQuota- historyQuota) AS imp, " +
                    "       incQuota, " +
                    "       startTime, " +
                    "       endTime " +
                    "FROM note_push " +
                    "WHERE endTime>now() " +
                    "  AND line='gdb'" +
                    "  AND historyQuota>=0 " +
                    "  AND (TIMESTAMPDIFF(MINUTE, startTime, now())/ TIMESTAMPDIFF(MINUTE, startTime, endTime))>0.1 " +
                    "  AND ((realQuota- historyQuota)/incQuota)/(TIMESTAMPDIFF(MINUTE, startTime, now())/ TIMESTAMPDIFF(MINUTE, startTime, endTime))<{paceThreshold}" +
                    "  AND status=1;";
            stmt = stmt.replace("{paceThreshold}", String.valueOf(0.1f));
            System.out.println(stmt);
            System.out.println(stmt);

//            Set<Long> userSet = new HashSet<>(Arrays.asList(144119555772416955L,
//                    144133942305598221L,
//                    207815530839950585L));
//            for (String s : userIdSet) {
//
//                if(!userSet.contains(IdMapping.oidToLong(s, IdType.USER))){
//                    System.out.println(s);
//                }
////                System.out.println(String.valueOf(IdMapping.oidToLong(s, IdType.USER)));
//            }

//            List<Long> ids = Arrays.asList();
//            for (Long id : ids) {
//                System.out.println(String.valueOf(IdMapping.longToOid(id)));
//            }

        } catch (IdMappingException e) {
            e.printStackTrace();
        }
    }
}