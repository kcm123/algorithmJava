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
        int[] truck_weight = {7,4,5,6};
        System.out.println(solution(2, 10, truck_weight));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 마지막 트럭을 제외한 모든 트럭이 다리를 통과하는 데 걸린 시간.
        int answer = 0;
        // 2. 현재 다리의 트럭 무게 총합, 트럭들의 무게를 참조 할 변수.
        int temp_weight = 0, idx=0;
        // 3. 다리, 큐로 구현.
        Queue<Integer> queue = new LinkedList<>();

        // 4. 마지막 트럭을 제외한 모든 트럭을 통과시키기 위한 무한 반복.
        while(true){
            // 5. 마지막 트럭이 다리에 올라갔을 때, 벗어난다.
            if(idx == truck_weights.length)break;
            // 6. 다리에 있는 트럭이 끝에 도달하면, 도달한 트럭의 무게를 현재 다리의 트럭 무게 총합에서 빼준다.
            if(queue.size() == bridge_length){
                temp_weight-=queue.poll();
            // 7. 현재 다리의 트럭 무게 총합 + 다리에 올라가야 하는 트럭의 무게 > 다리의 하중인 경우.
            }else if(temp_weight+truck_weights[idx]>weight){
                // 7-1. 다리의 길이를 고려하기 위해 0인 값을 넣어 자리를 채우고, 1초 증가.
                queue.offer(0);
                answer++;
            // 8. 위를 제외하고는 다리에 트럭이 올라간다.
            }else{
                queue.offer(truck_weights[idx]);
                temp_weight+=truck_weights[idx];
                answer++;
                idx++;
            }
        }

        // 9. 마지막 트럭이 다리에 올라간 상태에서 다리의 길이를 더해주면, 모든 트럭이 통과하는데 걸린 시간.
        return answer + bridge_length;
    }
}
