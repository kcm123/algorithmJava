package programmers.c_greedy;
//    어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//
//    예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
//    이 중 가장 큰 숫자는 94 입니다.
//
//    문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
//    number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
//
//    제한 조건
//    number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
//    k는 1 이상 number의 자릿수 미만인 자연수입니다.
//    입출력 예
//    number	k	return
//    "1924"	2	"94"
//    "1231234"	3	"3234"
//    "4177252841"	4	"775841"
import java.util.*;
public class Q3_LargestNo { // Level2_큰 수 만들기
    public static void main(String[] arg){
        solution("1924", 2);
    }
    public static String solution(String number, int k) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        dfs("", number, list, k);
//        set.removeIf(n -> n.length() != number.length() - k);
//        List<Integer> no = new ArrayList<>();
//        set.stream().forEach(x -> no.add(Integer.valueOf(x)));
        list.sort(null);
        //set.stream().mapToInt(x->Integer.valueOf(x)).sorted();
        return answer;
    }
    public static void dfs(String prefix, String str, List<Integer> list, int k){
        int n = str.length();
        if(!prefix.equals("")){
            if(prefix.length() == prefix.length() + str.length() - k){
                list.add(Integer.parseInt(prefix));
            }
        }
        for(int i=0; i < n; i++){
            dfs(prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1, n), list, k);
        }
    }
}
