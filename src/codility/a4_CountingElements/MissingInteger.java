package codility.a4_CountingElements;
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//    Given A = [1, 2, 3], the function should return 4.
//    Given A = [−1, −3], the function should return 1.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000..1,000,000].

import java.util.*;

public class MissingInteger { // Level2_Respectable
    public static void main(String[] args){
        int[] A = {-1, -3};
        System.out.println(solution(A));
    }
    public static int solution(int[] A){
        int rs = 1;
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(A[i] < 1) continue;
            if(A[i] == rs) rs++;
        }
        return rs;
        // 66점
//        Arrays.sort(A);
//        if(A[A.length-1] < 1) return 1;
//        if(A.length == 1) return A[0] <= 1 ? A[0]+1 : 1;
//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i < A.length; i++){
//            if(A[i] < 1) continue;
//            if(list.indexOf(1) < 0 && A[i] != 1) return 1;
//            if(list.indexOf(A[i]) < 0) list.add(A[i]);
//            if(i == A.length-1 || A[i] != A[i+1] && A[i] + 1 != A[i+1]) return A[i]+1;
//        }
//        return A[A.length-1]+1;
    }
}
