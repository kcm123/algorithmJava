package list;

import java.util.Arrays;

public class Question3 {
    public static void main(String[] arg){
        int[] numbers = {3, 0, 6, 1, 5};
        System.out.println(solution(numbers));
    }
    public static int solution(int[] citations) { // 3
        Arrays.sort(citations); // 0, 1, 3, 5, 6
        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            // 6, 1(1)     5, 2(2)    3, 3(3)     1, 4(1)       0, 5(0)
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }
        return max;
    }
}
