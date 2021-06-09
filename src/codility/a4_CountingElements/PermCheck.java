package codility.a4_CountingElements;
//    A non-empty array A consisting of N integers is given.
//    A permutation is a sequence containing each element from 1 to N once, and only once.
//    For example, array A such that:
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    A[3] = 2
//    is a permutation, but array A such that:
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    is not a permutation, because value 2 is missing.
//    The goal is to check whether array A is a permutation.
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
//    For example, given array A such that:
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    A[3] = 2
//    the function should return 1.
//    Given array A such that:
//    A[0] = 4
//    A[1] = 1
//    A[2] = 3
//    the function should return 0.
import java.util.*;
public class PermCheck {

    public static void main(String[] args){
        int[] A = {2, 2, 2};
        System.out.println(solution(A));
    }
    public static int solution(int[] A){
        int rs = 1;
        if(A.length == 1) return (A[0] == 1) ? 1 : 0;
        Arrays.sort(A);
        if(A[0] != 1) return 0;
        int next = 1;
        for(int i = 0; i < A.length; i++){
            if(i < A.length -1 && A[i] == A[i+1]) continue;
            next ++;
            if(A[i] != next-1){
                return 0;
            }
        }
        if(next == 2) rs = 0;
        return rs;
    }

}
