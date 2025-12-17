public class Largest_String {
    public static void main(String arg[]){
        String str[] = {"apple","mango","banana"};
        System.out.println(l_string(str));
    }

    public static String l_string(String str[]){
        String largest = str[0];
        for(int i=1; i<str.length; i++){
            if(largest.compareToIgnoreCase(str[i]) < 0){
                largest = str[i];
            }
        }

        return largest;
    }
}