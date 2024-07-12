import java.util.*;

public class ReverseString {

    public static String reverse(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        return sb.toString();
    }

    public static void main(String args[]){
        String str = "Yogesh";
        String result = reverse(str);
        System.out.println(result);
    }
}