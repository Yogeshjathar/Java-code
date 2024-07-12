import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            int count=0;
            if(ch == ')'){

                while(s.peek() != '('){
                    count++;
                    s.pop();
                }

                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }

        return false;
    }

    public static void main(String args[]){
        String str1 = "(((a+(b)))+(c+d))"; // true
        String str2 = "((a+b)+(c+d))"; // false
        
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
    }
}