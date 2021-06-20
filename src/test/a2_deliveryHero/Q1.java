package test.a2_deliveryHero;
import java.text.SimpleDateFormat;
import java.util.*;
public class Q1 {
    public static void main(String[] args){
        String S = "\n" +
                "\"\"\"\n" +
                "1988-08-29        956 system.zip\n" +
                "1976-09-16     126976 old-photos.tgz\n" +
                "1987-02-03     118784 logs.rar\n" +
                "1961-12-04  703594496 very-long-filename.rar\n" +
                "1980-08-03          2 DELETE-THIS.TXT\n" +
                "2014-08-23        138 important.rar\n" +
                "2001-08-26     595968 MOONLIGHT-SONATA.FLAC\n" +
                "1967-11-30     245760 archive.rar\n" +
                "1995-10-13        731 file.tgz\n" +
                "\"\"\"";
        System.out.println(solution(S));
    }
    public static String solution(String S){
        int rs = 0;
        String[] arr = S.split("\n");
        String type = "zip,tgz,rar";

        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("-")){
                String[] str = arr[i].replaceAll("\\s+", " ").split(" ");
                int size = Integer.parseInt(str[1]);
                String format = str[2].substring(str[2].length()-3, str[2].length());
                int date = Integer.parseInt(str[0].replaceAll("-", ""));
                if(size < 245760 && type.contains(format) && date < 19951013){
                    rs++;
                }
            }
        }
        return rs == 0 ? "NO FILES" : String.valueOf(rs);
    }
}
