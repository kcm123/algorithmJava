package test;
//    가로가 x, 세로가 y이고 각 칸에는 숫자 s가 적혀 있는 말판이 있습니다. 네오와 프로도는 자기 말을 각각
//    왼쪽 상단과 오른쪽 상단에 두고 게임을 시작하려고 합니다.
//    말은 자기의 위치에서 아래 3칸(왼쪽아래, 아래, 오른쪽아래)중에 한곳으로만 이동할 수 있고,
//    두 말이 이동한 위치에 적힌 숫자의 총합이 게임의 점수가 됩니다. 각 칸에 점수가 적힌 말판이 주어질 때, 네오와 프로도가
//    얻을 수 있는 가장 높은 점수를 구하는 코드를 작성해주세요.
//    규칙
//    - 말판의 가로 x, 세로 y의 범위는 3 < x, y < 50,
//    - 각 칸의 점수 s의 범위는 -100 < s < 100
//    - 입력은 2차원 배열로 주어집니다.
//    - 말은 말판 밖으로 나갈 수 없습니다.
//    - 두 말이 같은 칸으로 이동할 수 있지만, 점수는 한명에게만 주어집니다.
//    - 입력처리
//    	첫번째 입력 : 가로 x 값
//    	두번째 입력 : 세로 y 값
//    	세번째 입력 : 맵 데이터 , 로 구분
//    예제 입출력
//    입력 :
//    3
//    4
//    3,1,1,
//    2,5,1,
//    1,5,5,
//    2,1,1
//    출력 : 24
//
//    입력 :
//    7
//    5
//    1,0,0,0,0,0,1,
//    2,0,0,0,0,3,0,
//    2,0,9,0,0,0,0,
//    0,3,0,5,4,0,0,
//    1,0,2,3,0,0,6
//    출력 : 28
//      1	0	9	5	2
//      1	3	0	4	3
import java.util.*;
public class Q2 {
    public static void main(String[] args) {
        solution();
    }
    public static int solution(){
        int rs = 0;
//        Scanner sc = new Scanner(System.in);
//        System.out.print("x값: ");
//        int col = sc.nextInt();
//        System.out.print("y값: ");
//        int row = sc.nextInt();
//        int[][] val = new int[row][col];
//        int[][] visited = new int[row][col];
//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                System.out.print("map[" + i + "][" + j + "] 값 입력 : ");
//                val[i][j] = sc.nextInt();
//            }
//            System.out.println("");
//        }
        // DFS...
        int col = 3; int row = 4;
        int[][] val = {{3, 1, 1},
                       {2, 5, 1},
                       {1, 5, 5},
                       {2, 1, 1}};
        int[][] visited = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Map<String, Integer> a = new HashMap<>();
        a.put("row", 0); a.put("col", 0);
        Map<String, Integer> b = new HashMap<>();
        b.put("row", 0); b.put("col", col-1);
        while(a.get("row") != row && b.get("row") != row){
            rs += val[a.get("row")][a.get("col")];
            rs += val[b.get("row")][b.get("col")];
            a.put("row", row);b.put("row", row);
            a.put("col", col);b.put("col", col);
        }
        return rs;
    }
}
