package codility.a5_PrefixSums;
//    Write a function:
//    class Solution { public int solution(int A, int B, int K); }
//    that, given three integers A, B and K, returns the number of integers within the range [A..B]
//    that are divisible by K, i.e.:
//    { i : A ≤ i ≤ B, i mod K = 0 }
//    For example, for A = 6, B = 11 and K = 2, your function should return 3,
//    because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
//    Write an efficient algorithm for the following assumptions:
//    A and B are integers within the range [0..2,000,000,000];
//    K is an integer within the range [1..2,000,000,000];
//    A ≤ B.
public class CountDiv {
    public static void main(String[] args){
        System.out.println(solution(11 ,14, 2)); //7
    }
//    For example, for the input [0, 14, 2] the solution returned a wrong answer (got 7 expected 8).
    public static int solution(int A, int B, int K){
        // 87점
        if(B == 0) return 1;
        if(A != 0 && A < K) return B/K + (B != 0 && B % K == 0 ? 1 : 0);
        return (B-A)/K + (A % K == 0 ? 1 : 0);
        // 37점
//        int rs = 0;
//        int n = 1;
//        for(int i = A; i <= B; i+=n){
//            if(i == 0) continue;
//            if(i%K == 0){
//                rs++;
//                if(n == 1) n = K;
//            }
//        }
//        return rs;
    }
}
