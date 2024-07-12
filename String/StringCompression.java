public class StringCompression {
    public static void main(String args[]){
        String str = "aaabbcccc";
        System.out.println(compress(str));
    }

    public static String compress(String str){
        // String new_str = "";

        // for(int i=0; i<str.length(); i++)
        // {
        //     Integer count = 1;
        //     while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
        //         count++;
        //         i++;
        //     }
        //     new_str += str.charAt(i);

        //     if(count > 1){
        //         new_str += count.toString();
        //     }
        // }

        // return new_str;

        StringBuilder sb = new StringBuilder("");       // Using string builder

        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));

            if(count > 1){
                sb.append(count.toString());
            }
        }

        return sb.toString();
    }
}