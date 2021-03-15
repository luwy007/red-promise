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


        double calWilsonRatio(double numerator, double denominator) {
            if (numerator * denominator == 0 || denominator < numerator) {
                return 0.f;
            }
            double z = 1.96;
            boolean isUpper = false;
            double n = denominator;
            double p = numerator / denominator;
            double signal = isUpper ? 1.0 : -1.0;
            float score = (float) ((p + z * z / (2.f * n) + signal * z * Math.sqrt((p * (1.0f - p) + z * z / (4.f * n)) / n)) / (1.f + z * z / n));
            return score;
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

    enum ANA_LEVEL {
        BAD(0),
        NOT_BAD(1),
        GOOD(2);

        ANA_LEVEL(int level) {
            this.level = level;
        }

        int level;
    }

    private String analysis(Map<REASON, Performance> test, Map<REASON, Performance> control) {
        StringBuilder sb = new StringBuilder();
        // 粉丝群体判定
        Performance testP = test.get(REASON.FOLLOW);
        Performance controlP = control.get(REASON.FOLLOW);
        sb.append(String.format("\n\n================ %s ===================\n\n", "粉丝流量"));
        ANA_LEVEL cesImpLevel = analysis("follow", sb, testP, controlP, ACTION.CES_IMPRESSION);
        sb.append("\n\n");
        switch (cesImpLevel) {
            case BAD:
            case NOT_BAD:
            case GOOD:
                ANA_LEVEL clickImpLevel = analysis("follow", sb, testP, controlP, ACTION.CLICK_IMPRESSION);
                ANA_LEVEL cesClickLevel = analysis("follow", sb, testP, controlP, ACTION.CES_CLICK);
                sb.append("\n\n");
                ANA_LEVEL collectClickLevel = analysis("follow", sb, testP, controlP, ACTION.COLLECT_CLICK);
                ANA_LEVEL commentClickLevel = analysis("follow", sb, testP, controlP, ACTION.COMMENT_CLICK);
                ANA_LEVEL likeClickLevel = analysis("follow", sb, testP, controlP, ACTION.LIKE_CLICK);
                ANA_LEVEL shareClickLevel = analysis("follow", sb, testP, controlP, ACTION.SHARE_CLICK);
//                ANA_LEVEL followClickLevel = analysis("follow", sb, testP, controlP, ACTION.FOLLOW_CLICK);
            default:
                break;
        }
        // 扶持流量
//         testP = test.get(REASON.ROCKET);
//         controlP = control.get(REASON.ROCKET);
//        cesImpLevel = analysis("rocket", sb, testP, controlP, ACTION.CES_IMPRESSION);
//        sb.append("\n\n");
//        switch (cesImpLevel){
//            case BAD:
//            case NOT_BAD:
//            case GOOD:
//                ANA_LEVEL clickImpLevel = analysis("rocket", sb, testP, controlP, ACTION.CLICK_IMPRESSION);
//                ANA_LEVEL cesClickLevel = analysis("rocket", sb, testP, controlP, ACTION.CES_CLICK);
//                sb.append("\n\n");
//                ANA_LEVEL collectClickLevel = analysis("rocket", sb, testP, controlP, ACTION.COLLECT_CLICK);
//                ANA_LEVEL commentClickLevel = analysis("rocket", sb, testP, controlP, ACTION.COMMENT_CLICK);
//                ANA_LEVEL likeClickLevel = analysis("rocket", sb, testP, controlP, ACTION.LIKE_CLICK);
//                ANA_LEVEL shareClickLevel = analysis("rocket", sb, testP, controlP, ACTION.SHARE_CLICK);
//                ANA_LEVEL followClickLevel = analysis("rocket", sb, testP, controlP, ACTION.FOLLOW_CLICK);
//            default:break;
//        }

        // 自然流量
        sb.append(String.format("\n\n================ %s ===================\n\n", "自然流量"));
        testP = test.get(REASON.ORGANIC);
        controlP = control.get(REASON.ORGANIC);
        cesImpLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.CES_IMPRESSION);
        sb.append("\n\n");
        switch (cesImpLevel) {
            case BAD:
            case NOT_BAD:
            case GOOD:
                ANA_LEVEL clickImpLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.CLICK_IMPRESSION);
                switch (clickImpLevel) {
                    case BAD:
                        sb.append(" 非粉丝点击率差，可以尝试优化封面、标题、选题\n");
                        break;
                    case NOT_BAD:
//                        sb.append(" 非粉丝点击率差，可以尝试优化封面、标题、选题");
                        break;
                    case GOOD:
//                        sb.append(" 非粉丝点击率差，可以尝试优化封面、标题、选题");
                        break;
                    default:
                }
                ANA_LEVEL cesClickLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.CES_CLICK);
                switch (cesClickLevel) {
                    case BAD:
                        sb.append(" ces/click表现不佳，进一步拆分看是哪一项ces行为表现较差\n");
                        break;
                    case NOT_BAD:
                        sb.append(" ces/click表现一般，进一步拆分看，哪一项ces行为还有比较大优化空间\n");
                        break;
                    case GOOD:
                        sb.append(" ces/click表现不错，再接再厉。进一步拆分看，哪一项ces行为还有比较大优化空间\n");
                        break;
                    default:
                }
                sb.append("\n\n");
                ANA_LEVEL collectClickLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.COLLECT_CLICK);
                analysis(collectClickLevel, sb);
                ANA_LEVEL commentClickLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.COMMENT_CLICK);
                analysis(commentClickLevel, sb);

                ANA_LEVEL likeClickLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.LIKE_CLICK);
                analysis(likeClickLevel, sb);

                ANA_LEVEL shareClickLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.SHARE_CLICK);
                analysis(shareClickLevel, sb);

                ANA_LEVEL followClickLevel = analysis("ORGANIC", sb, testP, controlP, ACTION.FOLLOW_CLICK);
                analysis(followClickLevel, sb);

            default:
                break;
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    private void analysis(ANA_LEVEL level, StringBuilder sb) {
        switch (level) {
            case BAD:
                sb.append("存在较大优化空间 \n");
                break;
            case NOT_BAD:
                break;
            case GOOD:
                break;
        }
    }

    //
    private ANA_LEVEL analysis(String source, StringBuilder sb, Performance testP, Performance controlP, ACTION action) {

        double testRatio = testP.calRatio(action);
        double controlRatio = controlP.calRatio(action);
        if (testRatio < 0.8 * controlRatio) {
            sb.append(String.format("%s 表现较差， %.3f, %.3f\n", action, testRatio, controlRatio));
            return ANA_LEVEL.BAD;
        } else if (testRatio >= 0.8 * controlRatio && testRatio <= 1.2 * controlRatio) {
            sb.append(String.format("%s 表现中规中矩， %.3f, %.3f\n", action, testRatio, controlRatio));
            return ANA_LEVEL.NOT_BAD;
        } else {
            sb.append(String.format("%s 表现很好， %.3f, %.3f\n", action, testRatio, controlRatio));
            return ANA_LEVEL.GOOD;
        }
    }


    public static void main(String[] args) {
        DataAnalysis da = new DataAnalysis();
        Map<String, Performance> specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/data.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/data2.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/wushi.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/wushi economics.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/suozhang.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/fupeng.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/fupeng2.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/wushi japan.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/tuba first.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/tuba third.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/yangling.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/yangling2.csv");
        specNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/jingyue.csv");
        Map<String, Performance> globalNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/global.csv");
//        globalNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/wushi.csv");
//        globalNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/wushi eco.csv");
//        globalNotePerf = da.convertToReasonPerformanceMap("/Users/luwenyang/Downloads/tuba2.csv");


        Map<REASON, Performance> mergedSpecNotePref = da.mergePerformance(specNotePerf);
        Map<REASON, Performance> mergedGlobalNotePref = da.mergePerformance(globalNotePerf);

        List<ACTION> actionList = new ArrayList<>();
        actionList.add(ACTION.CES_IMPRESSION);
        actionList.add(ACTION.CLICK_IMPRESSION);
        actionList.add(ACTION.FOLLOW_IMPRESSION);
        actionList.add(ACTION.CES_CLICK);
        actionList.add(ACTION.FOLLOW_CLICK);
        actionList.add(ACTION.SHARE_CLICK);
        actionList.add(ACTION.COMMENT_CLICK);
        actionList.add(ACTION.COLLECT_CLICK);
        actionList.add(ACTION.LIKE_CLICK);

        da.analysis(mergedSpecNotePref, mergedGlobalNotePref);


        for (ACTION action : actionList) {
            System.out.println(String.format("\n\n===================    %s    ===================", action));
            for (REASON reason : mergedSpecNotePref.keySet()) {
                Performance notePerf = mergedSpecNotePref.get(reason);
                Performance globalPerf = mergedGlobalNotePref.get(reason);
//                System.out.println(String.format("reason : %s, \tnote %.0f %f, \tglobal %f", reason, notePerf.getImpression(), notePerf.calRatio(action), globalPerf.calRatio(action)));
                System.out.println(String.format("%s, \ttest %f, \tcontrol %f", reason, notePerf.calRatio(action), globalPerf.calRatio(action)));
            }
        }


    }
}
