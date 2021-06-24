package codility.a9_MaximumSlice;
//    A non-empty array A consisting of N integers is given.
//    A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.
//    The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ...
//    + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].
//    For example, array A such that:
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//    contains the following example double slices:
//    double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
//    double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
//    double slice (3, 4, 5), sum is 0.
//    The goal is to find the maximal sum of any double slice.
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given a non-empty array A consisting of N integers, returns the maximal sum of any double slice.
//    For example, given:
//    A[0] = 3
//    A[1] = 2
//    A[2] = 6
//    A[3] = -1
//    A[4] = 4
//    A[5] = 5
//    A[6] = -1
//    A[7] = 2
//    the function should return 17, because no double slice of array A has a sum of greater than 17.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [3..100,000];
//    each element of array A is an integer within the range [−10,000..10,000].
public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
        System.out.println(maxDoubleSliceSum.solution(A)); // 17
    }
    public int solution(int[] A){
        if (A == null || A.length == 3) {
            return 0;
        }
        Info[] infos = new Info[A.length];
        for(int i = 0; i < infos.length; ++i) {
            infos[i] = new Info();
        }
        infos[1].sum_from_front = A[1];
        infos[A.length - 2].sum_from_back = A[A.length - 2];
        for (int i = 2; i < infos.length - 2; ++i) {
            infos[i].sum_from_front = Math.max(A[i], infos[i - 1].sum_from_front + A[i]);
            int backIndex = A.length - i - 1;
            infos[backIndex].sum_from_back = Math.max(A[backIndex], infos[backIndex + 1].sum_from_back + A[backIndex]);
        }
        int maxSlice = 0;
        for(int i = 0 ; i < A.length - 2; ++i) {
            int partSumFromFront = Math.max(0, infos[i].sum_from_front);
            int partSumFromBack = Math.max(0, infos[i + 2].sum_from_back);
            int sum = partSumFromFront + partSumFromBack;
            maxSlice = Math.max(maxSlice, sum);
        }

        return maxSlice;
    }
    class Info{
        int sum_from_front = 0;
        int sum_from_back = 0;
    }
//    번째 : 0  1  2   3  4  5   6  7
//    숫자 : 3  2  6  -1  4  5  -1  2
//
//    우선 덧셈에 포함되지 않을 0번째 3과 N-1번째 2는 제외 시킨다.
//    번째 : 0  1  2   3  4  5   6  7
//    숫자 : X  2  6  -1  4  5  -1  X
//
//    X의 범위 : 0 ~ 5
//    Y의 범위 : 1 ~ 6
//    Z의 범위 : 2 ~ 7
//
//    부분합 기록을 위한 배열 M, N을 선언한다.
//    X~Y의 부분합 : M[0 ~ 7] (0으로 초기화)
//    Y~Z의 부분합 : N[0 ~ 7] (0으로 초기화)
//
//    M[1] = 2
//    N[7 - 1] = -1
//
//    이제 2부터 5까지 순회를 돌며 부분합을 구한다.
//    음수값이 더해져 부분합이 기존 위치 값보다 더 작아지는 경우를 max로 검사한다.
//            * 2일때
//    M[2] = max((M[1] + A[2]), A[2])
//    N[(7 - 1) - 2] = max((N[(7 - 1) - 1] + A[[(7 - 1) - 2]), A[[(7 - 1) - 2])
//
//            * 3일때
//    M[3] = max((M[2] + A[3]), A[3])
//    N[(7 - 1) - 3] = max((N[(7 - 1) - 2] + A[[(7 - 1) - 3]), A[[(7 - 1) - 3])
//            ...
//            * 5일때
//    M[5] = max((M[4] + A[5]) or A[5])
//    N[(7 - 1) - 5] = max((N[(7 - 1) - 4] + A[[(7 - 1) - 5]), A[[(7 - 1) - 5])
//
//    이제 M, N 부분합 정보를 바탕으로 Y를 이동시키면서 그 상황에서의 최대 부분합을 구한다.
//    하지만 최대 부분합이 음수일 경우는 max 검사를 통해 0으로 만들어 준다.
//            (가장 근접하게 인덱스 위치를 정해주면 그 부분합은 무조건 0이기 때문이다.)
//
//    Y -> 1일 경우
//    max(0, M[1 - 1]) + max(0, N[1 + 1])
//
//    Y -> 2일 경우
//    max(0, M[2 - 1]) + max(0, N[2 + 1])
//
//...
//
//    Y -> 6일 경우
//    max(0, M[6 - 1]) + max(0, N[6 + 1])
//
//    이 값들중 가장 큰 값이 정답이 된다.
//
//            출처: https://lipcoder.tistory.com/entry/MaxDoubleSliceSum-Codility [기록공간]
}