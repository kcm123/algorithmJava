package a_hash;

import java.util.*;

//    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
//    제한사항
//    마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//    completion의 길이는 participant의 길이보다 1 작습니다.
//    참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//    참가자 중에는 동명이인이 있을 수 있습니다.
//    입출력 예
//    participant	completion	return
//    ["leo", "kiki", "eden"]	["eden", "kiki"]	"leo"
//    ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
//    ["mislav", "stanko", "mislav", "ana"]	["stanko", "ana", "mislav"]	"mislav"
//    입출력 예 설명
//    예제 #1
//    "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
//    예제 #2
//    "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
//    예제 #3
//    "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
public class Q1_Athlete { // Level1_완주하지 못한 선수
    public static void main(String[] arg){
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion) {
        // code
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
        // myCode
//        String answer = "";
//        Arrays.sort(participant);
//        Arrays.sort(completion);
//        for(int i = 0; i < participant.length; i++){
//            if(i >= completion.length){
//                return participant[i];
//            }
//            if(!participant[i].equals(completion[i])){
//                return participant[i];
//            }
//        }
//        return answer;
    }
}
