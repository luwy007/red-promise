package octopus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class OpUserSpliter {
    private static void splitUserGroup(){
        String line = "";
        String splitBy = ",";
        Set<String> opNames = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/yang/Downloads/0930.csv"));
            line = br.readLine();
//            0 opName, 1 userId
            while ((line = br.readLine()) != null) {
                line = line.replace("\"", "");
                String[] items = line.split(splitBy);
                opNames.add(items[0]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            for (String opName : opNames) {
                System.out.println(opName);
                BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/yang/Downloads/" + opName + "0930.txt"));
                BufferedReader br = new BufferedReader(new FileReader("/Users/yang/Downloads/0930.csv"));
                line = br.readLine();
                while ((line = br.readLine()) != null) {
                    line = line.replace("\"", "");
                    String[] items = line.split(splitBy);
                    if(items[0].equals(opName)){
                        bw.write(items[1]+"\n");
                    }
                }
                br.close();
                bw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        splitUserGroup();

    }
}

