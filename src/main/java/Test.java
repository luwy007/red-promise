import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
import com.xiaohongshu.sns.enums.IdType;
import com.xiaohongshu.sns.util.IdMapping;
import javafx.util.Pair;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Test {


    private static final Integer CACHE_EXPIRE_TIME = 10;
    private static final Integer CACHE_SIZE = 1000;

    public static LoadingCache<NoteIndex, String> cache = CacheBuilder.newBuilder()
            .maximumSize(CACHE_SIZE)
            .refreshAfterWrite(CACHE_EXPIRE_TIME, TimeUnit.SECONDS)
            .build(new CacheLoader<NoteIndex, String>() {
                @Override
                public String load(NoteIndex noteId) {
                    return getBoostNote(noteId);
                }

                private String getBoostNote(NoteIndex noteId) {
                    return String.valueOf(System.currentTimeMillis());
                }
            });


    public static double wilsonUpperBoundary(double click, double imp) {
        if (click > imp) {
            return 1;
        }
        imp += 0.01;
        click += 0.01;
        double ratio = click / imp;
        double numerator = ratio + 0.5 * 3.84 / imp + 1.96 * Math.sqrt(ratio * (1 - ratio) / imp + 0.96 / imp / imp);
        double denominator = 1 + 3.84 / imp;
        return numerator / denominator;
    }

    private static String fillSqlQuery(String sqlPrefix, List<String> boardIdList) {
        String sql = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //限定时间
        sqlPrefix = sqlPrefix.replace("{ds}", df.format(new Date((new Date()).getTime() - 10l * 60 * 60 * 24 * 1000)));
        System.out.println(sqlPrefix);
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(sqlPrefix);
        sqlSb.append("(" + String.join(",", boardIdList) + ")");
        sql = sqlSb.toString();
        return sql;
    }


    private static double wilsonUpper(int num_pv, int num_click) {
        if (num_pv * num_click == 0 || num_pv < num_click) {
            return 0.f;
        }
        double score = 0.f;
        double z = 0.96f;
        int n = num_pv;
        double p = 1.0f * num_click / num_pv;
        score = (p + z * z / (2.f * n) + z * Math.sqrt((p * (1.0f - p) + z * z / (4.f * n)) / n)) / (1.f + z * z / n);
        return score;
    }

    private static double wilsonLower(int num_pv, int num_click) {
        if (num_pv * num_click == 0 || num_pv < num_click) {
            return 0.f;
        }
        double score = 0.f;
        double z = 0.96f;
        int n = num_pv;
        double p = 1.0f * num_click / num_pv;
        score = (p + z * z / (2.f * n) - z * Math.sqrt((p * (1.0f - p) + z * z / (4.f * n)) / n)) / (1.f + z * z / n);
        return score;
    }


    private static List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);


    private static void func1() {
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Service service = new Service(latch, i);
            Runnable task = () -> service.exec();
            Thread thread = new Thread(task);
            thread.start();
        }

        System.out.println("main thread await. ");
        try {
            latch.await(10, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main thread finishes await. ");
        int sum = l.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }

    private static void func2() {
        System.out.println("func2 start");
    }

    @Data
    public static class NoteIndex {
        String noteId;
        String authorId;

        @Override
        public int hashCode() {
            return this.noteId.hashCode();
        }
    }


    private static int seed(int maxSeed) {
        double rand = Math.random();
        int i = 0;
        for (; i <= maxSeed; i++) {
            if (i * (1.0 / maxSeed) > rand) {
                break;
            }
        }
        return i;
    }

    private static void assureMinInterval(List<Integer> newChipPosList, Integer minInterval) {
        if (newChipPosList.size() <= 1 || minInterval < 1) {
            return;
        }
        int lastIndex = newChipPosList.get(0);
        for (int i = 1; i < newChipPosList.size(); i++) {
            int thisIndex = newChipPosList.get(i);
            if (thisIndex - lastIndex - 1 < minInterval) {
                newChipPosList.set(i, lastIndex + minInterval + 1);
            }
            lastIndex = newChipPosList.get(i);
        }
    }

    private static class RetrievalItem {
    }

    private static Double calMergeScore(RetrievalItem retrievalItem, double cesPower) {
        return 0.0;
    }


    private static Comparator mergeScoreCompartor = new Comparator<Double>() {
        @Override
        public int compare(Double o1, Double o2) {
            return o1 - o2 > 0 ? -1 : 1;
        }
    };

    public enum Status {
        CLOSED, BOOST, FOLLOW_PREFER, ULTRA_BOOST, RE_TARGETING
    }

    private static enum Type {
        A, B, C;
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

    /**
     * 计算wilson_boundary/ctr
     */
    private static float calBoostRatio(float impression, float click, boolean isUpper, double z) {
        if (impression == 0 || impression < click) {
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

    private static int getPartitionId(final String pk) {
        return Math.abs(pk.hashCode() % 9);
    }

    public static void main(String[] args) throws Exception {

        System.out.println(getPartitionId("600a6b7300000000010028bf"));


        System.out.println("60094b7a0000000001001107 :" + getPartitionId("60094b7a0000000001001107f"));
        System.out.println("601101610000000001000122 :" + getPartitionId("601101610000000001000122f"));
        System.out.println("600a6b7300000000010028bf :" + getPartitionId("600a6b7300000000010028bff"));
        System.out.println("601132f6000000000100b0f7 :" + getPartitionId("601132f6000000000100b0f7f"));
        System.out.println("601265ec000000000100a155 :" + getPartitionId("601265ec000000000100a155f"));
        System.out.println("5ff2f61e00000000010074f9 :" + getPartitionId("5ff2f61e00000000010074f9f"));
        System.out.println("60059d43000000000101d4cd :" + getPartitionId("60059d43000000000101d4cdf"));
        System.out.println("600e974b000000000101d22b :" + getPartitionId("600e974b000000000101d22bf"));
        System.out.println("600d39f8000000000100b9a0 :" + getPartitionId("600d39f8000000000100b9a0f"));
        System.out.println("600d3bb000000000010049e2 :" + getPartitionId("600d3bb000000000010049e2f"));
        System.out.println("60091b0a000000000100221b :" + getPartitionId("60091b0a000000000100221bf"));
        System.out.println("5fe6e2550000000001002ccb :" + getPartitionId("5fe6e2550000000001002ccbf"));
        System.out.println("600d073f000000000100873a :" + getPartitionId("600d073f000000000100873af"));
        System.out.println("6007953a0000000001009adf :" + getPartitionId("6007953a0000000001009adff"));
        System.out.println("6002d4df000000000101f6b4 :" + getPartitionId("6002d4df000000000101f6b4f"));
        System.out.println("5ffaa9a80000000001002e70 :" + getPartitionId("5ffaa9a80000000001002e70f"));
        System.out.println("5ff5378c000000000100aa7d :" + getPartitionId("5ff5378c000000000100aa7df"));
        System.out.println("5fe36063000000000101d99b :" + getPartitionId("5fe36063000000000101d99bf"));
        System.out.println("5fdf61fe000000000100b4bb :" + getPartitionId("5fdf61fe000000000100b4bbf"));
        System.out.println("60113284000000000100ae57 :" + getPartitionId("60113284000000000100ae57f"));
        System.out.println("60138ab800000000010071f4 :" + getPartitionId("60138ab800000000010071f4f"));
        System.out.println("60112dbc0000000001006cc0 :" + getPartitionId("60112dbc0000000001006cc0f"));
        System.out.println("600fc590000000000101d73e :" + getPartitionId("600fc590000000000101d73ef"));
        System.out.println("600e1ad3000000000101cfd0 :" + getPartitionId("600e1ad3000000000101cfd0f"));
        System.out.println("6007a0520000000001008545 :" + getPartitionId("6007a0520000000001008545f"));
        System.out.println("6006ce280000000001002de3 :" + getPartitionId("6006ce280000000001002de3f"));
    }

    private static void smoothScoreList(List<Double> scoreList, int pos) {
        scoreList.set(pos, Math.max((scoreList.get(pos - 1) + scoreList.get(pos + 1)) / 2, scoreList.get(pos)));
    }


    private static float calNewBoostRatio(Date begindate, Date endDate, float oldBoost, float newBoost) {
        float boost = 1.0f;
        try {
            Date now = new Date();
            boost = (oldBoost * (endDate.getTime() - now.getTime())
                    + newBoost * (now.getTime() - begindate.getTime()))
                    / (endDate.getTime() - begindate.getTime() + 1);
        } catch (Exception e) {
        }
        boost = Math.max(oldBoost, boost);
        return boost;
    }


    private static void updatePos() {

        List<Integer> chipsSortedScoreList = Arrays.asList(100, 80, 50, 30);
        List<Integer> normalSortedScoreList = Arrays.asList(500, 200, 90, 60, 10, 5);


        //合并feed序列 & 薯条序列，获得薯条的浮动固定位
        int indexNormal = 0;
        int indexChips = 0;
        List<Integer> newPositionForChips = new ArrayList<>();
        while (indexChips < chipsSortedScoreList.size()
                && indexNormal < 100) {
            if (chipsSortedScoreList.get(indexChips) >= normalSortedScoreList.get(indexNormal)) {
                newPositionForChips.add(indexNormal + indexChips);
                indexChips++;
            } else {
                indexNormal++;
            }
        }
        while (indexChips++ < chipsSortedScoreList.size()) {
            newPositionForChips.add(Integer.MAX_VALUE);
        }

        // 插入非薯条广告，更新浮动固定位
        int indexAd = 0;
        List<Integer> notChipsPos = Arrays.asList(2, 5);
        indexChips = 0;
        while (indexAd < notChipsPos.size()) {
            int adPos = notChipsPos.get(indexAd);
            while (adPos > newPositionForChips.get(indexChips)
                    && indexChips < newPositionForChips.size()) {
                indexChips++;
            }
            if (newPositionForChips.size() <= indexChips) {
                break;
            }
            //在indexChips位置的薯条，位置向后顺移indexAd + 1
            if (adPos <= newPositionForChips.get(indexChips)) {
                newPositionForChips.set(indexChips, newPositionForChips.get(indexChips) + indexAd + 1);
                indexAd++;
            }
        }

        System.out.println(newPositionForChips);


//
//        //结合薯广初始固定位，更新浮动固定位
//        indexChips = 0;
//        for (Pair<Integer, RetrievalItem> pair : orderedAdsItems) {
//            if (pair.second.isChips) {
//                pair.first = Math.min(pair.first, newPositionForChips.get(indexChips));
//                indexChips += 1;
//            }
//            if (newPositionForChips.get(indexChips) > startIndex + 80) {
//                break;
//            }
//        }
    }


    public static class Service {
        private CountDownLatch latch;
        private Integer index;

        public Service(CountDownLatch latch, int index) {
            this.latch = latch;
            this.index = index;
        }

        public void exec() {
            try {
                System.out.println(Thread.currentThread().getName() + " execute task. ");
                sleep(2);
                l.set(index, l.get(index) + 1);
                System.out.println(Thread.currentThread().getName() + " finished task. " + l.get(index));
            } finally {
                latch.countDown();
            }
        }

        private void sleep(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}




