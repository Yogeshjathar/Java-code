import java.util.*;

public class validParenthesis {

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            // for opening brackts
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            // for closing brackts
            else
            {
                if(s.isEmpty()){
                    return false;   // '))))))'
                }

                // valid pair
                if(s.peek() == '(' && ch == ')' ||
                    s.peek() == '{' && ch == '}' ||
                    s.peek()== '[' && ch == ']')
                {
                    s.pop();
                }
                // Invalid pair
                else{
                    return false;
                }
            }
        }

        // at the end check if stack is empty or not
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String args[]){
        String str = "{[()]}"; // input string
        System.out.println(isValid(str));
    }
}