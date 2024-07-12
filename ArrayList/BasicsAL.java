// import java.util.ArrayList;
import java.util.*;

public class BasicsAL {
    public static void main(String str[]){
        ArrayList<ArrayList<Integer>> Mainlist = new ArrayList<>();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(7);

        // list.remove(1);      pass index as a prameter 
        // list.removeAll(list);
        // list.add(5)
        // list.get(1);
        // list.set(0,10);
        // list.contains(2);   return true or false
        // list.containsAll(list2);
        
        /* The .containsAll() method in Java is used
        to check whether a collection contains all the elements of another collection.
        */
        
        Mainlist.add(list);
        Mainlist.add(list2);

        System.out.println(Mainlist);

        for(int i=0; i<Mainlist.size(); i++){
            ArrayList<Integer> currList = Mainlist.get(i);
            // ArrayList<Integer> currList = new ArrayList<>();
            // currList = Mainlist.get(i);
            for(int j=0; j<currList.size(); j++){
                System.out.print(currList.get(j) + " ");
            }
        }

        System.out.println();
    }
}