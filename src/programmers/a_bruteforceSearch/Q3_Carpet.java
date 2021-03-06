package programmers.a_bruteforceSearch;
//    Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
//    Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
//    Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
// https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b1ebb809-f333-4df2-bc81-02682900dc2d/carpet.png
//    제한사항
//    갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
//    노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
//    카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
//    입출력 예
//    brown	yellow	return
//    10	2	    [4, 3] 2    1.5 2
//    8	    1	    [3, 3] 1.5  1.5 1
//    24	24	    [8, 6] 4    3   24
public class Q3_Carpet { // 카펫
    public static void main(String[] args){
        int[] answer = solution(24, 24);
        System.out.println(answer);
    }

    public static int[] solution(int brown, int yellow) {
//        brown의 갯수는 "2x + 2y - 4"
//        answer1
//    수학적으로 생각해보면 변수가 2개이고 수식이 2개가 있는 형태이다.
//    brown+yellow = 상수, brown*yellow = 상수 이렇게 수식을 놓을 수 있다.
//    그러면 2차 방정식의 해를 구하는 문제와 똑같아진다.
//    brown = 상수/yellow 이므로 대입하면 상수+yellow^2 = 상수*yellow가 된다.
//        int a = (brown + 4) / 2;
//        int b = yellow + 2 * a - 4;
//        int test = a * a - 4 * b;
//        int sqrt = (int) Math.sqrt(test);
//        int width = (a + sqrt) / 2;
//        int height = (a - sqrt) / 2;
//        int[] answer = {(int)(a + Math.sqrt(a * a - 4 * b)) / 2, (int)(a - Math.sqrt(a * a - 4 * b)) / 2};
//        return answer;

//        answer1.1
//        int edge = (brown / 2) + 2;
//        int difference = (int) Math.sqrt(edge * edge - (brown + yellow) * 4);
//        edge = (edge - difference) / 2;
//        return new int[] { edge+ difference, edge };

//        answer2
//        int height = 0;
//        int width = 0;
//        for (height = 3; height <= (int) (brown + 4) / 2; height++) {
//            width = ((brown + 4) / 2) - height;
//            if (width < height) {
//                break;
//            }
//            int redCount = (width - 2) * (height - 2);
//            if (yellow == redCount) {
//                break;
//            }
//        }
//        int[] answer = new int[] { width, height };
//        return answer;

//        answer3
        int[] answer = {};
        int size = (brown - 4) / 2;
        int w = size % 2 == 0 ? size / 2 : size / 2 + 1, h = size - w;
        while(h >= 1) {
            if(w * h == yellow) {
                answer = new int[]{w + 2, h + 2};
                break;
            }
            w++;
            h--;

        }
        return answer;
        // TODO myCode 76.9/100
//        int[] answer = new int[2];
//        int test = brown + yellow;
//        // (8 6)    12 4    16 3    24 2    48 1    <24 24>
//        // (3 3)    9 1     <8 1>
//        // (4 3)    6 2     12 1    <10 2>
//        for(int i = 1; i <= test; i++){
//            int width = i;
//            if(test % width == 0){ // 24
//                int height = test / width;
//                if(width >= height){ // Math.round((double)width/2 + (double)height/2) == width
//                    answer[0] = width; answer[1] = height;
//                    return answer;
//                }
//            }
//        }
//        return answer;
    }
}
