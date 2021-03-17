package a_hash;

import java.util.*;

//    스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
//    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
//    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
//    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
//    노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때
//    , 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
//    제한사항
//    genres[i]는 고유번호가 i인 노래의 장르입니다.
//    plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
//    genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
//    장르 종류는 100개 미만입니다.
//    장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
//    모든 장르는 재생된 횟수가 다릅니다.
//    입출력 예
//    genres	plays	return
//    ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
//    입출력 예 설명
//    classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
//    고유 번호 3: 800회 재생
//    고유 번호 0: 500회 재생
//    고유 번호 2: 150회 재생
//    pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
//    고유 번호 4: 2,500회 재생
//    고유 번호 1: 600회 재생
//    따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
public class Q4_BestAlbum { // 베스트 앨범
    public static void main(String[] args){
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solution(genres, plays);
    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;

        List<Integer> answerlist = new ArrayList<Integer>();
        HashMap<String, Integer> genrePlayHashMap = new HashMap<String, Integer>();

        for(int i =0; i<genres.length; i++) {
            genrePlayHashMap.put(genres[i], genrePlayHashMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        Set<String> key = genrePlayHashMap.keySet();
        //플레이수 : 장르 를 담을 해쉬맵
        HashMap<Integer, String> playGenreHashMap = new HashMap<Integer, String>();
        for(String k : key) {
            playGenreHashMap.put(genrePlayHashMap.get(k), k);
        }

        //플레이수 : 장르  오름차순
        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(playGenreHashMap);

        int treeMapSize = treeMap.size();
        for(int i =0; i<treeMapSize; i++) {
            String genre = treeMap.lastEntry().getValue();
            int deleteKey = treeMap.lastEntry().getKey(); // TreeMap 지울때 사용.
            int max = -1, nextmax = -1;
            int maxIndex = -1, nextmaxIndex = -1;

            //해당 장르에서 가장 큰놈. 둘째놈 list에 넣기
            for(int g =0; g<genres.length; g++) {
                if(genres[g].equals(genre)) {
                    //check 는 1,2 번째 수가 같은 경우.
                    // 같지 않아야 true
                    boolean check = max != plays[g];
                    max = Math.max(max, plays[g]);
                    if(plays[g] == max && check) {
                        maxIndex = g;
                    }
                }
            }
            plays[maxIndex] = -1;
            genres[maxIndex] = "-1";
            answerlist.add(maxIndex);

            for(int g =0; g<genres.length; g++) {
                if(genres[g].equals(genre)) {
                    nextmax = Math.max(nextmax, plays[g]);
                    if(plays[g] == nextmax) {
                        nextmaxIndex = g;
                    }
                }
            }
            // 곡이 하나인 경우 -1 로 계속남게됨
            if(nextmaxIndex != -1) {
                plays[nextmaxIndex] = -1;
                genres[nextmaxIndex] = "-1";
                answerlist.add(nextmaxIndex);
            }
            //삭제해주어야 lastEntry 할때 차수의 장르가 나오게 됨.
            treeMap.remove(deleteKey);
        }
        answer = new int[answerlist.size()];
        for(int i = 0; i<answerlist.size(); i++) {
            answer[i]= answerlist.get(i);
        }

        return answer;
//        int[] answer = {};
//        Map<String, Object> map = new HashMap<>();
//        for(int i=0; i < genres.length; i++){
//            if(!map.containsKey(genres[i])){
//                map.put(genres[i], plays[i]);
//            }else{
//                int val = (int)map.get(genres[i]) + plays[i];
//                map.put(genres[i], val);
//            }
//        }
//        int max = 0;
//        map.keySet().forEach(k -> {
//            if(max < (int)map.get(k)){
//
//            }
//        });
//        return answer;
    }
}
