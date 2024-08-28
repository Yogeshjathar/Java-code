
import java.util.*;

public class ActivitySelection{

    public static void activitySelection_02(int start[],int end[]){
        // Solution when end is not sorted
        // Sort the end array using 2d array
        int activities[][] = new int[start.length][3]; // 3 coloumns - index, start, end

        // Sorting
        for(int i=0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function - comaparatpr is an interface for sorting java objects
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basic sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]); // index
        int lastEnd = activities[0][2];
        for(int i=1; i<end.length; i++){
            if(activities[i][1] >= lastEnd){ // Compare start >= lastEnd
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Max Avtivity : " + maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }        

    public static void activitySelection_01(int start[],int end[]){
        // Solution when end is already sorted
        // end time basic sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++){
            if(start[i] >= lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max Avtivity : " + maxAct);
        for(int i=0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[]= {2,4,6,7,9,9};
        activitySelection_01(start, end); // When activities are sorted according to the end time
        activitySelection_02(start, end); // When activities are not sorted 
    }
}