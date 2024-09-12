import java.util.*;

public class IndianCoins {
    public static void main(String[] args) {
        // if array is int type that is of primtive type then you are not able to use reverseOreder()
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};

        // Sort - Decsending order
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins=0;
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<coins.length; i++){
            if(coins[i] <= amount){
                while(coins[i] <= amount){
                    countOfCoins++;
                    amount-= coins[i];
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("No. of coins needed : "+countOfCoins);
        for(int i=0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println();
    }
}
