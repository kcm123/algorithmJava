package test.a2_deliveryHero;
import java.util.*;
public class Q3 {
    public static void main(String[] args) {
        int[] A = {0, 5, 4, 4, 5, 12};
        solution(A);
    }
    public static int solution(int[] A){
        int rs = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            map.put(String.valueOf(A[i]), map.getOrDefault(String.valueOf(A[i]), 0) +1);
        }
        List keyList = new ArrayList<>(map.keySet()); // 오름차순 정렬 방법
        Collections.sort(keyList, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        Iterator<String> keys = map.keySet().iterator();
        while(keys.hasNext()){
            System.out.println(keys.next());
        }
        return rs;
    }
}
