public class pritntAllSubSequencesSTR {
    public static void main(String[] args) {
        String str = "abc";
        StringBuilder ans = new StringBuilder("");
        printAllSubsequences(str, ans, 0);
    }

    private static void printAllSubsequences(String str, StringBuilder curr, int index) {
        // BASE CASE 
        if(index == str.length()){
            System.out.println(curr.toString());
            return;
        }

        curr.append(str.charAt(index));
        // pick 
        printAllSubsequences(str, curr, index+1);

        curr.deleteCharAt(curr.length()-1);
        // not pick
        printAllSubsequences(str, curr, index+1);

    }
}
