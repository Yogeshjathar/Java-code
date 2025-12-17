public class SubString {
    public static void main(String args[]){
        String s1 = "HelloWorld";
        // System.out.println(s1.substring(0,5)); // Inbuild function
        System.out.println(sub_string(s1,0,5));
    }

    public static String sub_string(String str,int si,int ei){
        String sub_str = "";
        for(int i=si; i<ei; i++){
            sub_str += str.charAt(i);
        }

        return sub_str;
    }
}