package programmers.a_bruteforceSearch;

import java.util.HashSet;

//    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//    제한사항
//    numbers는 길이 1 이상 7 이하인 문자열입니다.
//    numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//    "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//    입출력 예
//    numbers	return
//    "17"	3
//    "011"	2
//    입출력 예 설명
//    예제 #1
//    [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//    예제 #2
//    [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//    11과 011은 같은 숫자로 취급합니다.
public class Q2_PrimeNo { // 소수 찾기_HashSet, 재귀, 소수
    public static void main(String[] args){
        Q2_PrimeNo s = new Q2_PrimeNo();
        System.out.println(s.solution("17"));
    }
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }
        return count;
    }
    // 소수여부
    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){ // root 17 -> 4
            if(n%i==0) return false;
        }
        return true;
    }
    // 순열
    public void permutation(String prefix, String str, HashSet<Integer> set) { // 17
        int n = str.length();
        if(!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for(int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }
//        i = 3, n = 8
//        0 1234 56 78
//        아롱이는이쁜이다
//        prefix = prefix + str.charAt(3)		아롱이 + 는
//        str = str.substring(0, i) + str.substring(i + 1, n)		아롱이는 + 이쁜이다
//                        prefix	str.charAt(i)	str.substring(0, i)	str.substring(i + 1, n)
//        ("", "17", 0);	 		1	 								7
//        ("1", "7", 1);	1		7
//        ("17", "", 2);			7				1
//        ("7", "1", 3);	7		1
//        ("71", "", 4);
}
