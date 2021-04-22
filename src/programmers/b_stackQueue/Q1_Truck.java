package programmers.b_stackQueue;

import java.util.*;

//    트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
//    모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
//    트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
//    ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
//
//    예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
//
//    경과 시간	다리를 지난 트럭	다리를 건너는 트럭	    대기 트럭
//    0	        []	            []	                [7,4,5,6]
//    1~2	    []	            [7]	                [4,5,6]
//    3	        [7]	            [4]	                [5,6]
//    4	        [7]	            [4,5]	            [6]
//    5	        [7,4]	        [5]	                [6]
//    6~7	    [7,4,5]	        [6]	                []
//    8	        [7,4,5,6]	    []	                []
//    따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
//    solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
//    제한 조건
//    bridge_length는 1 이상 10,000 이하입니다.weight는 1 이상 10,000 이하입니다.truck_weights의 길이는 1 이상 10,000 이하입니다.모든 트럭의 무게는 1 이상 weight 이하입니다.
//    입출력 예
//    bridge_length	weight	truck_weights	return
//    2	10	[7,4,5,6]	8
//    100	100	[10]	101
//    100	100	[10,10,10,10,10,10,10,10,10,10]	110
public class Q1_Truck { // Level2_다리를 지나는 트럭
    public static void main(String[] arg){
        int[] truck_weight = {100};
        System.out.println(solution(100, 100, truck_weight));
    }
// |	7	|
// |	4	|
// |	5	|
// |	6	|
// ㅡㅡㅡㅡㅡㅡ
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> truckStack = new Stack<>();
        Map<Integer, Integer> bridgeMap = new HashMap<>();
        for (int i = truck_weights.length-1; i >= 0; i--){
            truckStack.push(truck_weights[i]);
        }
        int answer = 0;
        int sum = 0;
        while(true) {
            answer++;
            if (bridgeMap.containsKey(answer)){
                bridgeMap.remove(answer);
            }
            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();
            if (!truckStack.isEmpty()) { // 트럭이 비어있지 않을떄
                if (sum + truckStack.peek() <= weight){ //
                    bridgeMap.put(answer + bridge_length, truckStack.pop());
                }
            }
            if (bridgeMap.isEmpty() && truckStack.isEmpty()){ // 맨마지막
                break;
            }
        }
        return answer;
        // myCode_1번만 성공_실패
//        int answer = 0; boolean flag = true;
//        Queue<Integer> truck = new LinkedList<>();Queue<Integer> passing = new LinkedList<>();Queue<Integer> passed = new LinkedList<>();
//        for(int i : truck_weights){ truck.add(i); }
//        while(flag){
//            if(passed.size() != truck_weights.length){
//                if(truck.size() != 0){
//                    int sum = passing.stream().mapToInt(Integer::intValue).sum() + truck.peek();
//                    if(sum <= weight){
//                        passing.add(truck.peek());
//                        truck.poll();
//                    }else{
//                        passing.add(truck.peek());
//                        truck.poll();
//                        passed.add(passing.peek());
//                        passing.poll();
//                        answer++;
//                    }
//                    answer++;
//                }else{
//                    passed.add(passing.peek());
//                    passing.poll();
//                    answer++;
//                }
//            }else{
//                flag = false;
//            }
//        }
//        return answer;
    }
}
