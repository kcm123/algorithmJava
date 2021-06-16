package codility.a7_StacksNQueues;
//    A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
//    S is empty;
//    S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
//    S has the form "VW" where V and W are properly nested strings.
//    For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//    Write a function:
//    class Solution { public int solution(String S); }
//    that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//    For example, given S = "{[()()]}", the function should return 1
//    and given S = "([)()]", the function should return 0, as explained above.
//    Write an efficient algorithm for the following assumptions:
//    N is an integer within the range [0..200,000];
//    string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
import java.util.*;
public class Brackets {
    public static void main(String[] args){
        System.out.println(solution(")("));
    }

    public static int solution(String S){
        int rs = 0;
        Stack<String> queue = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            String str = S.substring(i, i+1);
            if(queue.size() == 0 && (str.equals(")") || str.equals("]") || str.equals("}"))) return 0;
            if(str.equals(")")){
                if(!queue.peek().equals("(")){
                    return 0;
                }else{
                    queue.pop();
                }
            }else if(str.equals("]")){
                if(!queue.peek().equals("[")){
                    return 0;
                }else{
                    queue.pop();
                }
            }else if(str.equals("}")){
                if(!queue.peek().equals("{")){
                    return 0;
                }else{
                    queue.pop();
                }
            }else{
                queue.add(str);
            }
        }
        if(queue.size() == 0) rs = 1;
        return rs;
    }
}
