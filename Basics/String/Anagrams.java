import java.util.*;

public class Anagrams {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter first string : ");
        String str1 = sc.next();    // str1 = "earth";          str1 = "race";
        System.out.print("Enter second string : ");
        String str2 = sc.next();    // str2 = "heart";          str2 = "care";

        System.out.println(isAnagram2(str1, str2));
    }

    // Approach 2
    public static boolean isAnagram1(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.length() == str2.length()){
            char ch1[] = str1.toCharArray();
            char ch2[] = str2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);

            return Arrays.equals(ch1,ch2);
        }

        return false;
    }

    // Approach 2
    public static boolean isAnagram2(String a, String b) {
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