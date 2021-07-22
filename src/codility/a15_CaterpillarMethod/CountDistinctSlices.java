package codility.a15_CaterpillarMethod;
//    An integer M and a non-empty array A consisting of N non-negative integers are given. All integers in array A
//    are less than or equal to M.
//    A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the
//    elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers.
//    That is, no individual number occurs more than once in the slice.
//    For example, consider integer M = 6 and array A such that:
//    A[0] = 3      0, 1, 2     3
//    A[1] = 4      1, 2        2
//    A[2] = 5      2           4
//    A[3] = 5      3, 4        2
//    A[4] = 2      4           1
//    There are exactly nine distinct slices:
//    (0, 0), (0, 1), (0, 2), (1, 1), (1, 2),
//    (2, 2), (3, 3), (3, 4) and (4, 4).
//    The goal is to calculate the number of distinct slices.
//    Write a function:
//    class Solution { public int solution(int M, int[] A); }
//    that, given an integer M and a non-empty array A consisting of N integers, returns the number of distinct slices.
//    If the number of distinct slices is greater than 1,000,000,000, the function should return 1,000,000,000.
//    For example, given integer M = 6 and array A such that:
//    A[0] = 3
//    A[1] = 4
//    A[2] = 5
//    A[3] = 5
//    A[4] = 2
//    the function should return 9, as explained above.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [1..100,000];
//    M is an integer within the range [0..100,000];
//    each element of array A is an integer within the range [0..M].
public class CountDistinctSlices {
    public static void main(String[] args) {
        int[] A = {3, 4, 5, 5, 2};
        System.out.println(solution(6, A));
    }
//    A[0] = 3      0, 1, 2     3
//    A[1] = 4      1, 2        2
//    A[2] = 5      2           4
//    A[3] = 5      3, 4        2
//    A[4] = 2      4           1
    public static int solution(int M, int[] A){
        int rs = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] <= M) rs++;
            for(int j = i+1; j < A.length-1 && j <= A[i]; j++){
                if(A[j] <= M) rs++;
                if(j+1 < A.length && A[j+1] == A[j]) break;
            }
        }
        if(rs > 1000000000) return 1000000000;
        return rs;
    }
}