package c_greedy;

import java.util.*;

//    점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어,
//    바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
//    예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//    전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost
//    , 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때
//    , 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
//
//    제한사항
//    전체 학생의 수는 2명 이상 30명 이하입니다.
//    체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//    여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//    여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//    여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//    입출력 예
//    n	    lost	reserve	    return
//    5	    [2, 4]	[1, 3, 5]	5
//    5	    [2, 4]	[3]	        4
//    3	    [3]	    [1]	        2
//    입출력 예 설명
//    예제 #1
//    1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면
//    학생 5명이 체육수업을 들을 수 있습니다.
//
//    예제 #2
//    3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다
//    1. 전체 학생 수와 동일한 int 배열을 만든다.
//    2. 0 / 1 / -1 로 체육복 상태를 나타낸다.
//       0 : 기본 상태(체육복이 있고, 도난 당하지 않은 상태)
//       1 : 여부의 체육복이 있는 상태
//       -1 : 체육복을 도난 당한 상태
//       전체 학생 배열 all에서 lost에 해당하는 학생의 인덱스는 -1 처리 reserve에 해당하는 학생은 +1로 처리한다.
//    3. 상태를 다 나타낸 후에 0번부터 체육복 여부를 확인하고 체육복이 없다면 앞 번호나 뒷 번호에게 체육복을 빌리는 처리를 한다.
//       단, 1번은 앞 번호가 존재하지 않으므로 뒷 번호에게만 빌릴 수 있고, 마지막 번호는 앞 번호만 빌릴 수 있다.
//        1 2 3 4 5
//        2   4 	잃어버림
//        1	3	5	여분
//        ------------5	5-2+3(앞뒤에서만) (n보다 크면 n)
//        1 2 3 4 5
//        2   4 	잃어버림
//        3		여분
//        ------------4	 5-2+1(앞뒤에서만)
//        1 2 3
//        3	잃어버림
//        1		여분
//        ------------2 3-2+1(앞뒤에서만)
public class Q1_GymSuit { // Level1_체육복
    public static void main(String[] arg){
        int n = 3;
        int[] lost = {3};
        int[] reverse = {1};
        System.out.println(solution(n, lost, reverse));
    }
    public static int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;
        for (int l : lost) people[l-1]--;
        for (int r : reserve) people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else {
                    answer--;
                }
            }
        }
        return answer;
        // myCode 75_실패
//        int remain = n - lost.length + reserve.length;
//        List<Integer> lostArr = new ArrayList<>();
//        List<Integer> reserveArr = new ArrayList<>();
//        for(int i : lost){ lostArr.add(i); }
//        for(int i : reserve){ reserveArr.add(i); }
//        lostArr.removeIf(l -> {
//            if(reserveArr.indexOf(l-1) > -1 || reserveArr.indexOf(l+1) > -1){
//                reserveArr.remove(reserveArr.indexOf(l-1) > -1 ? reserveArr.indexOf(l-1) : reserveArr.indexOf(l+1));
//                return true;
//            }
//            return false;
//        });
//        remain -= reserveArr.size();
//        if(remain > n) return n;
//        return remain;
        // myCode 75점_실패
//        int remain = n - lost.length;
//        List<Integer> list = new ArrayList<>();
//        for(int i : reserve){ list.add(i); }
//        for(int i = 0; i < lost.length; i++){
//            int minus = lost[i];
//            int before = list.indexOf(minus-1);
//            int after = list.indexOf(minus+1);
//            if(before > -1 || after > -1){
//                remain += 1;
//                list.remove(before > -1 ? before : after);
//            }
//        }
//        if(remain > n) remain = n;
//        return remain;
    }
}
