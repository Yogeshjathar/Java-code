import java.util.*;
public class FirstNonRepeatingLetter {

    public static void printNonRepeatingLetter(String str){
        // Created a frequency array to track the frequency of each charcater
        int freq[] = new int[26];
        // created a queue to insert each character in queue 
        // queue id interface in jcf where LinkedList and PriorityQueue classes implement it
        Queue<Character> q = new PriorityQueue<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
        
    }

    public static void main(String args[]){
        String str = "aabccxb";
        printNonRepeatingLetter(str);
    }
}