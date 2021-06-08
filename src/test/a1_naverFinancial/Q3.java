package test.a1_naverFinancial;

import java.util.*;
public class Q3 {
    public static void main(String[] args){
        String[] A = {"co","dil","ity"};
        solution(A);
    }
    public static int solution(String[] A){
        int rs = 0;
        HashSet<String> set = new HashSet<>();
        permutation(0, A, set);
        return rs;
    }
    public static void permutation(int no, String[] str, HashSet<String> set) {
        int n = str.length;
        set.add(str[no]);

        for(int i = no+1; i < n; i++) {
            permutation(i, str, set);
        }
    }
}
