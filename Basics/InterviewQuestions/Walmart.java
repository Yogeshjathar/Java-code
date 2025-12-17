// walmart interview 
// Convert string input: str="WALMART" output: str="LAWMTRA", get mid and reverse left and right half
class Walmart {
    public static void main(String[] args) {
        String str = "WALMART"; // lawMtra
        
        char ch[] = str.toCharArray();
        int mid = str.length()/2;
        
        reverse(ch, 0, mid-1);
        reverse(ch, mid+1, str.length()-1);
        
        System.out.println(new String(ch));
    }
    
    private static void reverse(char ch[],int left,int right){
        char temp = ch[left];
        ch[left] = ch[right];
        ch[right] = temp;
    }
}


// Theory
// Interview - Yogesh - 1.8 years of experience 
// Interviewer - Pranay Jaiswal

// 1. Explain Architecture of project
// 2. How will you managed pods in Kubernetes and configuration
// 3. How you used Prometheus and Grafana for monitoring 
// 4. How you used Jenkins
// 5. Do you have worked on cloud
// 6. Suppose you have your code on GitHub then how will be the flow from push to deployment 
// 7. How you performed testing in your application
// 8. Convert string input: str="WALMART" output: str="LAWMTRA", get mid and reverse left and right half
// 9. Mostly asked questions on real time project and deployment parts.
// 10.Have You used scripting
// 11. How much cpu and memory required per pod.
