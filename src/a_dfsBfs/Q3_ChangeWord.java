package a_dfsBfs;
//    두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
//    아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
//    1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
//    2. words에 있는 단어로만 변환할 수 있습니다.
//    예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
//    "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.
//    두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
//    제한사항
//    각 단어는 알파벳 소문자로만 이루어져 있습니다.
//    각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
//    words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
//    begin과 target은 같지 않습니다.
//    변환할 수 없는 경우에는 0를 return 합니다.
//    입출력 예
//    begin	target	words	return
//    "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
//    "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
//    입출력 예 설명
//    예제 #1
//    문제에 나온 예와 같습니다.
//    예제 #2
//    target인 "cog"는 words 안에 없기 때문에 변환할 수 없습니다.

//1. 첫 번째 조건인 한 번에 한 개의 알파벳만 바꿀 수 있다고 하여 words에 있는 단어 중 조건에 부합하는 단어를 찾는 메서드 check를 만들어 주었다.
//2. DFS을 사용하여 바뀐 단어와 target단어가 같으면 answer값을 업데이트시켜주고 사용한 단어를 체크하기 위한 used 배열과 count 매개변수를 사용하여 DFS를 재귀로 구현했다.
public class Q3_ChangeWord { // Level3_단어변환
    int answer;                        //최소 단계
    boolean[] used;                    //단어를 사용 중인지를 판단하는 visited와 같은 역할을 하는 배열
    public static void main(String[] arg){
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Q3_ChangeWord q3 = new Q3_ChangeWord();
        System.out.println(q3.solution("hit", "cog", words));
    }

    public int solution(String begin, String target, String[] words) {
        answer = 51;                //단어 최대값이 50이므로
        used = new boolean[words.length];
        dfs(begin, target, 0, words);
        return answer == 51 ? 0 : answer;    //answer이 51이면 target과 같은 단어가 없는 것으로 판단.
    }
    public void dfs(String presentWord, String target, int count,String[] words) {
        if(presentWord.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }
        for(int i = 0; i < words.length; i++) {                        //탐색한 글자중 하나만 차이나고 탐색되지 않은 글자이 있다면. dfs 수행
            if(!used[i] && check(presentWord, words[i])) {
                used[i] = true;
                dfs(words[i],target,count+1, words);
                used[i] = false;
            }
        }
    }
    public boolean check(String presentWord, String nextWord) {        //현재의 단어와 다음 단어가 바뀔 조건에 일치하는가를 체크
        int count = 0;
        for(int i = 0; i < presentWord.length(); i++) {
            if(presentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}
