import java.util.*;

public class PushInStack {

    // Push at bottom in stack
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        
        int top = s.pop(); // Remove data from stack
        pushAtBottom(s,data); // recursive call until stack become empty
        s.push(top);
    }

    // Reverse a stack
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        reverse(s);
        pushAtBottom(s,top);
    }

    public static void main(String str[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverse(s);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}