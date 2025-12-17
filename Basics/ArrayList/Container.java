import java.util.*;

public class Container {

    // Brute force - O(n*2)
    public static int containWater(ArrayList<Integer> height){
        int maxLevel = 0;

        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
            // calculate current level of water
                int hi = Math.min(height.get(i),height.get(j)); // height
                int wi = j-i;   // weight
                int currentlevel = wi*hi;
                maxLevel = Math.max(maxLevel,currentlevel);
            }
        }

        return maxLevel;
    }

    // 2 point approach - O(n)
    public static int waterLevel(ArrayList<Integer> height){
        int maxLevel = 0;

        int lp = 0; // Left pointer
        int rp = height.size()-1; // Right pointer
        
        while(lp<rp){
            // calculate current level of water
            int hi = Math.min(height.get(lp),height.get(rp));   // height
            int wi = rp-lp;     // width
            int currentlevel = wi*hi;   // area of water

            maxLevel = Math.max(maxLevel, currentlevel); // update the max level

            // we will change the small height
            // according to condition lp and rp will be increase and decrease
            if(height.get(lp) < height.get(rp)){
                lp++;
            }
            else{
                rp--;
            }
        }
        
        return maxLevel;
    }
    
    public static void main(String str[]){
        ArrayList<Integer> height = new ArrayList<>();

        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(containWater(height)); // Brute force 
        System.out.println(waterLevel(height)); //2 point approach
    }
}