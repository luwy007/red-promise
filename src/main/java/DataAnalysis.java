import lombok.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAnalysis {

    List<String> indexesList = Arrays.asList("SUM(impression)", "SUM(click)", "SUM(liked)", "SUM(follow)", "SUM(collect)", "SUM(share)", "SUM(comment)", "SUM(hide)");

    enum ACTION {
        IMPRESSION,
        CLICK_IMPRESSION,
        FOLLOW_CLICK,
        FOLLOW_IMPRESSION,
        LIKE_CLICK,
        COLLECT_CLICK,
        SHARE_CLICK,
        COMMENT_CLICK,
        CES_CLICK,
        CES_IMPRESSION,
        HIDE_CLICK;
    }

    enum REASON {
        ROCKET("rocket"),
        ORGANIC("organic"),
        FOLLOW("follow");

        REASON(String name) {
            this.name = name;
        }

        String name;
    }


    @Data
    class Performance {
        String reason;
        double impression;
        double click;
        double follow;
        double like;
        double collect;
        double share;
        double comment;
        double hide;

        public Performance() {
        }

        public Performance(String reason) {
            this.reason = reason;
        }

        double calCtr() {
            return calRatio(click, impression);
        }


        double calRatio(ACTION action) {
            double ratio = 0;
            switch (action) {
                case CLICK_IMPRESSION:
                    ratio = calRatio(click, impression);
                    break;
                case LIKE_CLICK:
                    ratio = calRatio(like, click);
                    break;
                case FOLLOW_CLICK:
                    ratio = calRatio(follow, click);
                    break;
                case FOLLOW_IMPRESSION:
                    ratio = calRatio(follow, impression);
                    break;
                case COLLECT_CLICK:
                    ratio = calRatio(collect, click);
                    break;
                case COMMENT_CLICK:
                    ratio = calRatio(comment, click);
                    break;
                case SHARE_CLICK:
                    ratio = calRatio(share, click);
                    break;
                case HIDE_CLICK:
                    ratio = calRatio(hide, click);
                    break;
                case CES_IMPRESSION:
                    ratio = calRatio(calCes(), impression);
                    break;
                case CES_CLICK:
                    ratio = calRatio(calCes(), click);
                    break;
                default:
                    break;
            }
            return ratio;
        }


        double calCes() {
            return 4 * follow + like + collect + 4 * share + 4 * comment;
        }

        double calCesPerImp() {
            return calRatio(calCes(), impression);
        }

        double calRatio(double numerator, double denominator) {
            if (numerator >= denominator || denominator == 0) {
                return 1.0;
            }
            return numerator / denominator;
        }

    }


    private Map<String, Performance> convertToReasonPerformanceMap(String filePath) {
        List<Performance> performanceList = new ArrayList<>();
        Map<String, Performance> reasonPerformanceMap = new HashMap<>();

        File csv = new File(filePath);

        try {
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            // first line
            String line = textFile.readLine();
            Map<String, Integer> colIndexMap = new HashMap<>();
            int index = 0;
            for (String name : line.split(",")) {
                colIndexMap.put(name, index);
                index++;
            }
            // 第二行略过
            textFile.readLine();
            while ((line = textFile.readLine()) != null) {
                String[] elements = line.split(",");
                Performance performance = new Performance();
                performance.setReason(elements[0]);
                performance.setImpression(parseDoubleValue(elements[1]));
                performance.setClick(parseDoubleValue(elements[2]));
                performance.setLike(parseDoubleValue(elements[3]));
                performance.setFollow(parseDoubleValue(elements[4]));
                performance.setCollect(parseDoubleValue(elements[5]));
                performance.setShare(parseDoubleValue(elements[6]));
                performance.setComment(parseDoubleValue(elements[7]));
                performance.setHide(parseDoubleValue(elements[8]));
                performanceList.add(performance);
                reasonPerformanceMap.put(performance.getReason(), performance);
            }

        } catch (Exception e) {
            System.out.println("文件读写出错");
        }
        return reasonPerformanceMap;
    }

    private double parseDoubleValue(String valueStr) {
        double value = 0;
        try {
            value = Double.parseDouble(valueStr);
        } catch (Exception e) {

        }
        return value;
    }

    private void addPerformance(Performance a, Performance b) {
        a.setImpression(a.getImpression() + b.getImpression());
        a.setClick(a.getClick() + b.getClick());
        a.setFollow(a.getFollow() + b.getFollow());
        a.setLike(a.getLike() + b.getLike());
        a.setCollect(a.getCollect() + b.getCollect());
        a.setShare(a.getShare() + b.getShare());
        a.setComment(a.getComment() + b.getComment());
        a.setHide(a.getHide() + b.getHide());
    }

    private Map<REASON, Performance> mergePerformance(Map<String, Performance> performanceMap) {
        Map<REASON, Performance> mergedPermanceMap = new HashMap<>();
        Performance performance = null;
        for (String reason : performanceMap.keySet()) {
            switch (reason) {
                case "boost":
                case "tselected":
                    performance = mergedPermanceMap.getOrDefault(REASON.ROCKET, new Performance(REASON.ROCKET.name));
                    mergedPermanceMap.put(REASON.ROCKET, performance);
                    break;
                case "follow":
                    performance = mergedPermanceMap.getOrDefault(REASON.FOLLOW, new Performance(REASON.FOLLOW.name));
                    mergedPermanceMap.put(REASON.FOLLOW, performance);

                    break;
                default:
                    performance = mergedPermanceMap.getOrDefault(REASON.ORGANIC, new Performance(REASON.ORGANIC.name));
                    mergedPermanceMap.put(REASON.ORGANIC, performance);
                    break;

            }
            addPerformance(performance, performanceMap.get(reason));
        }


        return mergedPermanceMap;
    }

    public static void main(String[] args) {
        DataAnalysis da = new DataAnalysis();
        Map<String, Performance> specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/data.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/data2.csv");
        Map<String, Performance> globalNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/global.csv");
//        globalNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/data.csv");


        Map<REASON, Performance> mergedSpecNotePref = da.mergePerformance(specNotePerf);
        Map<REASON, Performance> mergedGlobalNotePref = da.mergePerformance(globalNotePerf);

        List<ACTION> actionList = new ArrayList<>();
        actionList.add(ACTION.CES_IMPRESSION);
        actionList.add(ACTION.CES_CLICK);
        actionList.add(ACTION.CLICK_IMPRESSION);
        actionList.add(ACTION.FOLLOW_CLICK);
        actionList.add(ACTION.FOLLOW_IMPRESSION);
        for(ACTION action: actionList){
            System.out.println(String.format("\n\n===================    %s    ===================", action));
            for (REASON reason : mergedSpecNotePref.keySet()) {
                Performance notePerf = mergedSpecNotePref.get(reason);
                Performance globalPerf = mergedGlobalNotePref.get(reason);
//                System.out.println(String.format("reason : %s, \tnote %.0f %f, \tglobal %f", reason, notePerf.getImpression(), notePerf.calRatio(action), globalPerf.calRatio(action)));
                System.out.println(String.format("reason : %s, \tnote %f, \tglobal %f", reason, notePerf.calRatio(action), globalPerf.calRatio(action)));
            }
        }

    }
}
