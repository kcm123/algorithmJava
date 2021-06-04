package codility.a3_TimeComplexity;

import java.util.Arrays;

//    An array A consisting of N different integers is given.
//    The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
//    Your goal is to find that missing element.
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given an array A, returns the value of the missing element.
//    For example, given array A such that:
//    A[0] = 2
//    A[1] = 3
//    A[2] = 1
//    A[3] = 5
//    the function should return 4, as it is the missing element.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [0..100,000];
//    the elements of A are all distinct;
//    each element of array A is an integer within the range [1..(N + 1)].
public class PermMissingElem {
    public static void main(String[] args){
        int[] A = {};
        System.out.println(solution(A));
    }

    public static int solution(int[] A){
        int rs = 0;
        if(A.length == 0) return 1; // 1. Array 빈값
        Arrays.sort(A);
        if(A[0] != 1) return 1; // 2. 첫번째 값이 비었을 때
        for(int i = 1; i < A.length; i++){
            if(A[i-1] + 1 != A[i]){
                rs = A[i-1] + 1;
                break;
            }
        }
        if(rs == 0) rs = A[A.length - 1] + 1; // 2. 마지막 값이 비었을 때
        return rs;
    }
}
