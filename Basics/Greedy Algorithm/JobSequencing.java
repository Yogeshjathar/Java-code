
import java.util.*;

public class JobSequencing {
    static class Job{ 
        int id;
        int deadline;
        int profit;

        public Job(int i,int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][] = {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for(int i=0; i<jobInfo.length; i++){
            jobs.add(new Job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        
        // Sort in Descending order
        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit);

        // if we want it to be Sort in Descending order then use this
        // Collections.sort(jobs, (obj1,obj2) -> obj1.profit-obj2.profit);

        ArrayList<Integer> seq= new ArrayList<>();
        int time = 0;
        for(int i=0; i<jobs.size(); i++){
            Job curr = jobs.get(i);
            if(curr.deadline > time){
                seq.add(curr.id);
                time++;
            }
        }

        // print sequence
        for(int i=0; i<seq.size(); i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
