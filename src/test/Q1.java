package test;
//    1. 편의점 알바를 하던 죠르디는 알파벳 문자로 이루어진 상품코드가 너무 길어 별도의 규칙을 만들어 인코딩하려고 합니다.
//    죠르디는 문자열 안에 연속적으로 반복되는 문자를 "반복되는횟수 [문자]"형태로 인코딩할 계획입니다.
//    예를들어 aaaz는 3[a]z로 인코딩되고 accccaccccacccc는 a4[c]a4[c]a4[c]로 1회 인코딩 되고 다시3[a4[c]]로 인코딩 됩니다.
//    인코딩에 너무 집중한 죠르디는 인코딩한 문자열을 다시 원래 문자열로 만드는 디코딩 프로그램 작성을 깜빡했습니다.
//    죠르디 대신 인코딩된 문자열이 들어왔을 때, 디코딩된 문자열을 반환하는 프로그램을 작성해 주세요.
//
//    규칙
//    - 입력되는 문자열은 숫자, 문자, 괄호로만 이루어져 있습니다.
//    - 숫자는 양의 정수이며, 문자에는 숫자가 포함되지 않습니다. 예를 들어 3a, 2[4]와 같은 입력은 존재하지 않습니다.
//    - 입력되는 문자열의 길이는 L은 0 < L < 128 입니다.
//
//    예제 입출력
//    입력 : 3[a]z
//    출력 : aaaz
//
//    입력 : 3[a4[c]]
//    출력 : accccaccccacccc
import java.util.*;
public class Q1 {
    public static void main(String[] args) {
        System.out.println(decode("3[a4[c]]"));
    }
    public static String decode(String str){
        List<Integer> rp = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            String st = String.valueOf(str.charAt(i));
            list.add(st);
            if(st.equals("[") || st.equals("]")) rp.add(i);
        }
        while(!rp.isEmpty()){
            int st = rp.size()/2-1;
            int end = rp.size()/2;
            int no = Integer.parseInt(list.get(rp.get(st)-1));
            String test = "";
            for(int i = rp.get(st)+1; i < rp.get(end);){
                if(list.get(i).equals("[") || list.get(i).equals("]")) break;
                test += list.get(i);
                list.remove(i);
            }
            list.add(rp.get(st)+1, test.repeat(no));
            if(rp.get(end) < list.size()) list.remove((int)rp.get(end));
            list.remove((int)rp.get(st));
            list.remove(rp.get(st)-1);
            rp.remove(st);
            rp.remove(st);
        }
        list.removeIf(s -> s.equals("]"));
        return String.join("", list);
    }
}
