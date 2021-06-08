package test.a1_naverFinancial;

import java.util.*;
public class Q1 {
    public static void main(String[] args){
        solution(1000000);
    }
    public static int solution(int N){
        int enable_print = N % 10;
        if(enable_print == 0){
            enable_print = 1;
        }
        int rs = 0;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
        return rs;
    }
}
