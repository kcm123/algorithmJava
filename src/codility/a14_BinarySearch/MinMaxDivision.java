package codility.a14_BinarySearch;
//    You are given integers K, M and a non-empty array A consisting of N integers.
//    Every element of the array is not greater than M.
//    You should divide this array into K blocks of consecutive elements. The size of the block is
//    any integer between 0 and N. Every element of the array should belong to some block.
//    The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.
//    The large sum is the maximal sum of any block.
//    For example, you are given integers K = 3, M = 5 and array A such that:
//    A[0] = 2
//    A[1] = 1
//    A[2] = 5
//    A[3] = 1
//    A[4] = 2
//    A[5] = 2
//    A[6] = 2
//    The array can be divided, for example, into the following blocks:
//    [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
//    [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
//    [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
//    [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
//    The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
//    Write a function:
//    class Solution { public int solution(int K, int M, int[] A); }
//    that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.
//    For example, given K = 3, M = 5 and array A such that:
//    A[0] = 2
//    A[1] = 1
//    A[2] = 5
//    A[3] = 1
//    A[4] = 2
//    A[5] = 2
//    A[6] = 2
//    the function should return 6, as explained above.
//    Write an efficient algorithm for the following assumptions:
//    N and K are integers within the range [1..100,000];
//    M is an integer within the range [0..10,000];
//    each element of array A is an integer within the range [0..M].
public class MinMaxDivision {
    public static void main(String[] args) {
        int[] A = {2, 1, 5, 1, 2, 2, 2};
        System.out.println(solution(3, 5, A));
    }
//최대값이 M인 배열 A가 인풋으로 들어온다.
//우리는 K개의 배열 A를 K개의 그룹으로 나누고 각 그룹의 합의 최대값을 최소로하도록 만드는 문제이다.
//카테고리가 Binary Search이기 때문에, 이분 탐색을 써서 풀 수 있는 문제라는 것을 알 수 있다.
//각 그룹의 최대값을 이분탐색을 통해서 찾아주면 된다. l = 0, r = M * A.length 로 설정해준다.
// r을 M * A.length로 설정한 이유는 배열의 각 원소의 최대값이 M이기 때문이다.
//sum이라는 변수를 만들어 각 그룹의 합을 저장하고, sum이 mid값보다 커질 때는 새로운 그룹을 만드는 것으로 코드를 작성한다.
// mid값은 새로운 그룹을 만드는 구분자로 사용되며, 정답과는 다른 값이다.
//그룹의 개수가 K보다 크게 된다면, mid값이 너무 작아 많은 그룹이 생겼다는 뜻이므로 l = mid + 1 로 설정하여 우측에서 탐색을 해준다.
//K보다 작거나 같은 그룹의 개수가 나온다면, mid보다 더 작은 값을 기준에서 정답이 나올 수 있다는 뜻이므로 r = mid - 1로 설정해준다.
//mid가 정답이 아니므로, maxSum이라는 변수를 만들어 각 그룹의 최대값을 저장하고, 이 값이 최소값을 return 해준다.
    public static int solution(int K, int M, int[] A){
        int l = 0;
        int r = M * A.length; // 각 원소의 최대값이 M
        int ans = M * A.length;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int sum = 0; // 각 그룹의 합
            int numGroup = 1;
            int maxSum = 0;
            for(int i = 0; i < A.length; i++){
                if (sum + A[i] > mid) { // sum이 mid값보다 커질 때는 새로운 그룹을 만드는 것
                    maxSum = Math.max(sum, maxSum);
                    sum = A[i];
                    numGroup++;
                } else {
                    sum += A[i];
                }
            }
            maxSum = Math.max(sum, maxSum);
            if(numGroup > K){
                l = mid + 1;
            }else{
                ans = Math.min(maxSum, ans);
                r = mid - 1;
            }
        }
        return ans;
    }
}