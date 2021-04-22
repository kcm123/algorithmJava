import java.util.*;

public class Main {
    public static void main(String[] arg){
        int[][] needs = { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1} };
//        int[] gift_cards = {4, 5, 3, 2, 1};
//        int[] wants = {2, 4, 4, 5, 1};
        int[] passenger = {};
        int[][] train =  {{1,2},{1,3},{1,4},{3,5},{3,6}};
        System.out.println(solution(6, passenger, train));
    }
    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {};
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < train.length; i++){
            List list2 = new ArrayList<>();
            list2.add(train[i][0]);
            list2.add((int)train[i][1]);
            list.add(list2);
        }
        return answer;
    }
    public void dfs(int x, boolean[] visited, List<List<Integer>> list){
        visited[x] = true;
        for(int i = 0; i < list.get(x).size(); i++){
            int y = list.get(x).get(i);
            if(!visited[y]) dfs(y, visited, list);
        }
    }
//    public static int solution(int[] gift_cards, int[] wants){
//        List<Integer> want = new ArrayList<>();
//        List<Integer> real = new ArrayList<>();
//        for(int i : wants) want.add(i);
//        for(int i : gift_cards) real.add(i);
//        for(int i = 0; i < real.size(); i++){
//            if(want.get(i) != real.get(i)){
//                int idx = real.indexOf(want.get(i))-1;
//                if(idx == -2) continue;
//                int temp = real.get(i);
//                real.remove(i);
//                want.remove(i);
//                idx = idx == -1 ? 0 : idx;
//                real.remove(idx);
//                real.add(idx, temp);
//                i--;
//            }else{
//                want.remove(i);
//                real.remove(i);
//                i--;
//            }
//        }
//        return real.size();
//    }
}