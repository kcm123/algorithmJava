package codility.a6_Sorting;

import java.util.*;
public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] A = {10};
        System.out.println(solution(A));
    }

    public static int solution(int[] A){
        int N = A.length;
        long[] lower = new long[N];
        long[] upper = new long[N];

        for (int i = 0; i < N; i++) {
            lower[i] = i - (long) A[i];
            upper[i] = i + (long) A[i];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int intersection = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && upper[i] >= lower[j]) {
                intersection += j;
                intersection -= i;
                j++;
            }
        }

        if (intersection > 10000000) return -1;
        return intersection;
//        int N = A.length;
//        int[] lower = new int[N];
//        int[] upper = new int[N];
//        for(int i = 0; i < N; i++){
//            lower[i] = i-A[i];
//            upper[i] = i+A[i];
//        }
//        List<Integer> list = new ArrayList<>();
//        for(int i = 0; i < lower.length; i++){
//            if(lower[i] != upper[i]){
//                list.add(lower[i]);
//                list.add(upper[i]);
//            }else{
//                list.add(upper[i]);
//            }
//
//        }
//        if (list.size() > 10000000) return -1;
//        return list.size();
    }
}
