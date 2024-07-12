public class BitManipulation {
    public static void main(String args[]){
        // OddEven(3);
        // OddEven(115);
        // OddEven(10);
        // System.out.println(getIthBit(10,2));
        // System.out.println(setIthBit(10,2));
        // System.out.println(clearIthBit(10,1));
        // System.out.println(updateIthBit(10,2,1));
        // System.out.println(clearRangeIthBit(10,2,7));
        // System.out.println(isPowerOf2(8));
        // System.out.println(isPowerOf2(11));
        // System.out.println(countSetOfBit(11));
        System.out.println(fastExpo(3,5));
    }

    public static void OddEven(int num){
        int bitmask = 1;

        if((num & bitmask) == 0){
            System.out.println("Even number");
        }else{
            System.out.println("Odd number");
        }
    }

    public static int getIthBit(int n,int i){
        int bitmask = 1<<i;

        if((n & bitmask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public static int setIthBit(int n,int i){
        int bitmask = 1 << i;
        return n | bitmask ;
    }

    public static int clearIthBit(int n,int i){
        int bitmask = ~(1<<i);
        return n & bitmask;
    }

    public static int updateIthBit(int n,int i,int newBit){

        n = clearIthBit(n,i);
        int bitmask = newBit << i ;
        return n | bitmask;
    }

    public static int clearLastIthBit(int n,int i){
        int bitmask = (-1) << i;    // or int bitmask = (~0) << i;
        return n & bitmask;
    }

    public static int clearRangeIthBit(int n,int i,int j){
        int a = (-1) << (j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        return n & bitmask;
    }

    public static boolean isPowerOf2(int n){
        // while((n & (n-1)) == 0){
        //     return true;
        // }

        // return false;
        return (n&(n-1)) == 0;
    }

    public static int countSetOfBit(int n){

        int count = 0;
        while(n > 0){
            if((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }

        return count;
    }

    public static int fastExpo(int a,int n){
        int ans = 1;

        while(n>0){
            if((n&1) != 0){
                ans = ans*a;
            }
            a = a*a;
            n = n>>1;
        }

        return ans;
    }
}