// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class FindNthRootOfNum {
    public static void main(String[] args) {
        int n = 3, m = -27;
        System.out.println(getNthRootOfNum(n, m));
    }
    
    public static int getNthRootOfNum(int n, int m){
        if(m == 0 || m == 1 || n == 1) return m;
        
        // Handles negative numbers
        if(m < 0){
            // even root of negative not possible
            if(m % 2 == 0) return -1;
            return -getNthRootOfNum(n, -m);
        }
        
        int left = 1;
        int right = m;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            long power = 1;
            for(int i=1; i<=n; i++){
                power *= mid;
                if(power > m) break;
            }
            
            if(power == m) return mid;
            else if(power < m) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1;
    }
}