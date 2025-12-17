public class palindrome {
    public static void main(String args[]){
        String str = "racecar";
        System.out.println(isPaindrome(str));
    }

    public static boolean isPaindrome(String str1){
        for(int i=0; i<str1.length()/2; i++){
            if(str1.charAt(i) != str1.charAt(str1.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}