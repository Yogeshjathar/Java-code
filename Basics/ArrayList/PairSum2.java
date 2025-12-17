import java.util.*;

public class PairSum2 {

    public static boolean findPairTarget(ArrayList<Integer> list, int target){
        // findPairTarget for sorted and rotated ArrayList
        
        // Brute Force 
        // for(int i=0; i<list.size(); i++){
        //     for(int j=0; j<list.size(); j++){
        //         if(list.get(i) + list.get(j) == target){
        //             return true;
        //         }
        //     }
        // }

        // return false;


        //  2 pointer approach
        // find break point to know what is lp and rp
        int bp = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) > list.get(i+1)){
                bp = i;
                break;
            }
        }

        int lp = bp+1;
        int rp = bp;
        int n = list.size();
        while(lp != rp){
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }

            if(list.get(lp) + list.get(rp) < target){
                lp = (lp+1) % n; // modular arithematic to +/- the lp and rp
                // because the ArrayList here is Soretd and Rotated
            }
            else{
                rp = (n+rp-1) % n;
            }
        }

        return false;
    }

    public static void main(String str[]){
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(findPairTarget(list,target));
    }
}