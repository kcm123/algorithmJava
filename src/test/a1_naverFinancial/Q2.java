package test.a1_naverFinancial;

import java.io.InputStream;
import java.util.*;
public class Q2 {
    public static void main(String[] args){
        int[] A = {};
        System.out.println(solution(A));
    }
    public static int solution(int[] A){
//        int max = 0;
//        if(A.length == 0) return max;
//        Arrays.sort(A);
//        for(int i = A.length / 2; i < A.length; i++){
//            if(A[i] > 10) break;
//            if(A[i] >= 0){
//                max = Math.max(A[i], max);
//            }else{
//
//            }
//        }
//        return max;
        // 2.
//        int[] arr = Arrays.stream(A).filter(i -> i >= 0 && i < 10).toArray();
//        if(arr.length == 0) return 0;
//        Arrays.sort(arr);
//        return arr[arr.length-1];
        A = Arrays.stream(A).filter(i -> i >= 0 && i < 10).toArray();

        if(A.length == 0) return 0;
        Arrays.sort(A);
        return A[A.length-1];
    }
}
