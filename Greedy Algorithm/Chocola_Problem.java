import java.util.*;

public class Chocola_Problem {
    public static void main(String[] args) {
        int n=4, m=6;
        Integer verCost[] = {2,1,3,1,4}; // m-1
        Integer horCost[] = {4,1,2}; // n-1

        // sort it in descending order
        Arrays.sort(verCost,Collections.reverseOrder());
        Arrays.sort(horCost,Collections.reverseOrder());

        int v=0, h=0;
        int vp=1, hp=1; // vertical pieces and horizontal pieces
        int cost=0;

        while(h<horCost.length && v<verCost.length){
            if(verCost[v] <= horCost[h]){// horizontal cut
                cost += (horCost[h] * vp);
                hp++;
                h++; 
            }else{
                // vertical cut
                cost += (verCost[v] * hp);
                vp++;
                v++;
            }
        }

        while(h<horCost.length){
            cost += (horCost[h] * vp);
            hp++;
            h++; 
        }

        while(v<verCost.length){
            cost += (verCost[v] * hp);
            vp++;
            v++;
        }

        System.out.println("minimal cost of cuts : "+cost);
    }
}