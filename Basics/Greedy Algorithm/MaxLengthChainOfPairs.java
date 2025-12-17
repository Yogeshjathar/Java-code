import java.util.*;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        ArrayList<Integer> ans = new ArrayList<>();

        int newPairs[][] = new int[pairs.length][3];
        for(int i=0; i<pairs.length; i++){
            newPairs[i][0] = i;
            newPairs[i][1] = pairs[i][0];
            newPairs[i][2] = pairs[i][1];
        }

        // sort based on 2nd number
        Arrays.sort(newPairs, Comparator.comparingDouble(O -> O[2]));

        // 1st pair
        int chainLen = 1;
        int chainEnd = newPairs[0][2];
        ans.add(newPairs[0][0]);
        for(int i=1; i<pairs.length; i++){
            if(newPairs[i][1] >= chainEnd){
                chainLen++;
                ans.add(newPairs[i][0]);
                chainEnd = newPairs[i][2];
            }
        }
        System.out.println("Max length of chain : "+chainLen);
        for(int i=0; i<ans.size(); i++){
            System.out.print("("+pairs[ans.get(i)][0]+","+pairs[ans.get(i)][1]+")");
        }
        System.out.println();
    }
}