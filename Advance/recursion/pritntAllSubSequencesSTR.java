public class pritntAllSubSequencesSTR {
    public static void main(String[] args) {
        String str = "abc";
        String ans = "";
        printAllSubsequences(str, ans, 0);
    }

    private static void printAllSubsequences(String str, String ans, int index) {
        // Base case
        if(index == str.length()){
            System.out.println(ans);
            return;
        }

        // pick element 
        ans += str.charAt(index);
        printAllSubsequences(str, ans, index+1);

        // Don't pick element 
        ans = ans.substring(0, ans.length()-1);
        printAllSubsequences(str, ans, index+1);
    }
}
