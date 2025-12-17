
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int value[] = {60,100,120};
        int weight[] = {10,20,30};
        int capacity = 50;
        int finalValue = 0;

        
        double ratio[][] = new double[value.length][2];
        for(int i=0; i<value.length; i++){
            ratio[i][0] = i; // index
            ratio[i][1] = value[i]/(double)weight[i];
        }

        // Sort - it sorts the array in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for(int i=ratio.length-1; i>=0; i--){   /* reverse loop because it sorts in ascending order
        and we need to start eith greater value*/
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
                // include full item
                capacity -= weight[idx];
                finalValue += value[idx];
            }else{
                // include fractional value
                finalValue += ratio[i][1]*capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum total value : " +finalValue);
    }
}