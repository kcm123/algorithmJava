package test.a2_deliveryHero;
import java.util.*;
public class Q2 {
    public static void main(String[] args){
        System.out.println(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "example"));
    }
    public static String solution(String S, String C){
        String rs = "";
        C = C.toLowerCase();
        String[] arr = S.split("; ");
        StringBuffer sb = new StringBuffer();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            String[] str = arr[i].split(" ");
            String last = str[str.length-1].toLowerCase().replaceAll("-", "");
            String first = str[0].toLowerCase();
            String email = "<" + last + "_" + first + "@" + C +".com>";
            int val = map.getOrDefault(email, 0)+1;
            map.put(email, val);
            if(val != 0 && map.get(email) > 1){
                email = "<" + last + "_" + first + map.get(email)+ "@" + C +".com>";
            }
            sb.append(arr[i] + " " + email + ( i == arr.length-1 ? "" : "; "));
        }
        return sb.toString();
    }
}
