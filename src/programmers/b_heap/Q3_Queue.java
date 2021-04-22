package programmers.b_heap;
import java.util.*;
//    이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
//
//    명령어	수신 탑(높이)
//    I     숫자	큐에 주어진 숫자를 삽입합니다.
//    D 1	큐에서 최댓값을 삭제합니다.
//    D -1	큐에서 최솟값을 삭제합니다.
//    이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
//
//    제한사항
//    operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
//    operations의 원소는 큐가 수행할 연산을 나타냅니다.
//    원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
//    빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
//    입출력 예
//    operations	                return
//    ["I 16","D 1"]	            [0,0]
//    ["I 7","I 5","I -5","D -1"]	[7,5]
//    입출력 예 설명
//    16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
//    7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.
public class Q3_Queue { // Level3_이중 우선순위 큐
    public static void main(String[] arg){
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        solution(operations);
    }
    public static int[] solution(String[] operations) {
        // myCode 100_성공
        int[] answer = new int[2];
        List<Integer> que = new ArrayList<>();
        for(int i = 0; i < operations.length; i++){
            String str = operations[i];
            String[] arr = str.split(" ");
            if(arr[0].equals("I")){
                que.add(Integer.parseInt(arr[1]));
                que.sort(null);
            }else{ // D
                if(arr[1].equals("1")){ // 1 최대값 삭제
                    que.remove(que.size()-1);
                }else{ // -1 최소값 삭제
                    que.remove(0);
                }
            }
        }
        if(que.size() > 0){
            answer[0] = que.get(que.size()-1);
            answer[1] = que.get(0);
        }
        return answer;
        // myCode 50점_실패
//        int[] answer = new int[2];
//        List list = Arrays.asList(operations);
//        List<Integer> que = new LinkedList<>();
//        for(int i = 0; i < list.size(); i++){
//            String str = (String)list.get(i);
//            String[] arr = str.split(" ");
//            if(arr[0].equals("I")){
//                que.add(Integer.parseInt(arr[1]));
//            }else{ // D
//                if(arr[1].equals("1")){ // 1 최대값 삭제
//                    que.removeIf(val-> val == que.stream().mapToInt(Integer::intValue).max().getAsInt());
//                }else{ // -1 최소값 삭제
//                    que.removeIf(val-> val == que.stream().mapToInt(Integer::intValue).min().getAsInt());
//                }
//            }
//        }
//        if(que.size() > 0){
//            answer[0] = que.stream().mapToInt(Integer::intValue).max().getAsInt();
//            answer[1] = que.stream().mapToInt(Integer::intValue).min().getAsInt();
//        }
//        return answer;
//        int max = que.stream().mapToInt(Integer::intValue).max().getAsInt();
//        int idx = que.indexOf(max);
//        if(idx > -1){
//            que.remove(idx);
//        }
    }
}
