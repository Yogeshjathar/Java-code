import java.util.*;

public class subArraySum {
    public static void main(String str[]){
        int arr[] = {10,2,-2,-20,10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); //  empty sub array <sum, frequency>
        int ans = 0;
        int sum = 0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j]; // calculate sum of subarrays A

            if(map.containsKey(sum-k)){ // Check if sum=k exit in map
                ans += map.get(sum-k);  // if exist then add in ans 
            }

            if(map.containsKey(sum)){  // add sum in map
                map.put(sum, map.get(sum) + 1); // if already exist then increase frequency
            }
            else{
                map.put(sum,1); // if not exist thgen add sum with frequency 1
            }
        }

        System.out.println(ans);
        System.out.println(map);
    }
}