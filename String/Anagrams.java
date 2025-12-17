import java.util.*;

public class Anagrams {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter first string : ");
        String str1 = sc.next();    // str1 = "earth";          str1 = "race";
        System.out.print("Enter second string : ");
        String str2 = sc.next();    // str2 = "heart";          str2 = "care";

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() == str2.length()){
            char ch1[] = str1.toCharArray();
            char ch2[] = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);

            boolean result = Arrays.equals(ch1,ch2);
            if(result){
                System.out.println(str1+ " and " +str2+ " are an anagrams strings");
            }
            else{
                System.out.println(str1+ " and " +str2+ " are not an anagrams strings");
            }
        }
        else{
            System.out.println(str1+ " and " +str2+ " are not an anagrams strings");
        }
    }

    // Approach 2
    boolean isAnagramLowercase(String a, String b) {
    if (a.length() != b.length()) return false;
    int[] cnt = new int[26];
    for (int i = 0; i < a.length(); i++) {
        cnt[a.charAt(i) - 'a']++;
        cnt[b.charAt(i) - 'a']--;
    }
    for (int c : cnt) if (c != 0) return false;
    return true;
}
}