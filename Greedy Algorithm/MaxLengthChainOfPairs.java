import java.util.*;

public class MaxLengthChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        // sort based on 2nd number
        Arrays.sort(pairs, Comparator.comparingDouble(O -> O[1]));

        // 1st pair
        int chainLen = 1;
        int chainEnd = pairs[0][1];
        for(int i=1; i<pairs.length; i++){
            if(pairs[i][0] >= chainEnd){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }
        System.out.println("Max length of chain : "+chainLen);
    }
}