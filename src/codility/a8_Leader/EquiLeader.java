package codility.a8_Leader;
//    A non-empty array A consisting of N integers is given.
//    The leader of this array is the value that occurs in more than half of the elements of A.
//    An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1],
//    A[S + 2], ..., A[N − 1] have leaders of the same value.
//    For example, given array A such that:
//    A[0] = 4      4                   3, 4, 4, 4, 2       4
//    A[1] = 3      4, 3                4, 4, 4, 2          4
//    A[2] = 4      4, 3, 4             4, 4, 2             4
//    A[3] = 4      4, 3, 4, 4          4, 2
//    A[4] = 4      4, 3, 4, 4, 4       2
//    A[5] = 2
//    we can find two equi leaders:
//    0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
//    2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
//    The goal is to count the number of equi leaders.
//    Write a function:
//    class Solution { public int solution(int[] A); }
//    that, given a non-empty array A consisting of N integers, returns the number of equi leaders.
//    For example, given:
//    A[0] = 4
//    A[1] = 3
//    A[2] = 4
//    A[3] = 4
//    A[4] = 4
//    A[5] = 2
//    the function should return 2, as explained above.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [1..100,000];
//    each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
// https://lipcoder.tistory.com/entry/EquiLeader-Codility
import java.util.*;
public class EquiLeader {
    public static void main(String[] args) {
        int[] A = {4, 3, 4, 4, 4, 2};
        System.out.println(solution(A));
    }
    public static int solution(int[] A){
        int result = 0;
        int leader = 0, leaderCount = 0;
        // 숫자 빈도 카운트 값 기록을 위해 해시맵 컨테이너를 선언한다.
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // 카운트 값을 기록한다
        for(int i = 0 ; i < A.length; ++i) {
            if(hm.containsKey(A[i])) {
                int count = hm.get(A[i]);
                hm.replace(A[i], count + 1);
            } else {
                hm.put(A[i], 1);
            }
            // 가장 많이 나온 수 (Leader)를 기록한다.
            if(leaderCount < hm.get(A[i])) {
                leaderCount = hm.get(A[i]);
                leader = A[i];
            }
        }
        // Leader 숫자를 구했으니 Leader 숫자가 각 인덱스에서 몇 개 정도 나왔는지 기록할 벡터 컨테이너를 만든다.
        Vector<Integer> record = new Vector<Integer>();
        int currentCount = 0;
        // 각 인덱스위치에서 Leader의 빈도수를 기록한다.
        for(int i = 0 ; i < A.length; ++i) {
            if(A[i] == leader) {
                ++currentCount;
            }
            record.add(currentCount);
        }
        for(int i = 0; i < A.length - 1; ++i) {
            int LeftCount = record.elementAt(i); // 둘로 쪼갰을때 왼쪽 부분 Leader 빈도수
            int RightCount = record.lastElement() - LeftCount; // 오른쪽 부분 Leader 빈도수

            int limitEquiLeft = ((i + 1) / 2) + 1;
            int limitEquiRight = ((A.length - (i + 1)) / 2) + 1;
            // EquiLeader 조건을 왼쪽과 오른쪽 부분 모두 만족한다면 갯수를 증가 시킨다.
            if((LeftCount >= limitEquiLeft) && (RightCount >= limitEquiRight)) {
                ++result;
            }
        }
        return result;
//        int rs = 0;
//        int n = A.length-3;
//        if(n < 1){
//            return rs;
//        }
//        List list = new ArrayList<>();
//        List list2 = new ArrayList<>();
//        for(int no : A){
//            list.add(no);
//        }
//        for(int i = 0; i < n; i++){
//            list2.add(A[i]);
//            list.remove(0);
//            if(A[i] == getDominator(list2) && A[i] == getDominator(list)){
//                rs++;
//            }
//        }
//        return rs;
    }
//    public static int getDominator(List<Integer> list){
//        int rs = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < list.size(); i++){
//            map.put(list.get(i), map.getOrDefault(list.get(i), 0) +1);
//        }
//        if(map.size() > 0){
//            List<Map.Entry<Integer, Integer>> domlist = new ArrayList<>(map.entrySet());
//            if(domlist.size() == 1) return domlist.get(0).getKey();
//            domlist.sort(Map.Entry.comparingByValue());
//            int idx = domlist.size()-1;
//            int max = domlist.get(idx).getValue();
//            if(max > list.size()/2){
//                for(int i = 0; i < list.size(); i++){
//                    if(list.get(i) == domlist.get(idx).getKey()){
//                        rs = domlist.get(idx).getKey();
//                        break;
//                    }
//                }
//            }
//        }
//        return rs;
//    }
}
