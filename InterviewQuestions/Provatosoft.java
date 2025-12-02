// Coding Problem: Find Anagram
class Provatosoft {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        for(char ch : t.toCharArray()){
            if(!hm.containsKey(ch)){
                return false;
            }
            
            if(hm.get(ch) == 1){
               hm.remove(ch);
            }else{
               hm.put(ch,hm.get(ch)-1);
            }
        }
        return hm.isEmpty();
    }

  public static void main(String[] args) {
        Provatosoft obj = new Provatosoft();

        String s1 = "listen";
        String s2 = "silent";

        boolean result = obj.isAnagram(s1, s2);

        System.out.println("Are \"" + s1 + "\" and \"" + s2 + "\" anagrams? " + result);
    }
}

/* Approach 1: Sorting
Sort both strings and compare.
Time complexity: O(n log n).

Approach 2: Frequency Count (Best Approach)
Used HashMap to count frequencies of characters.
Compare the frequency maps.
Time complexity: O(n). */


// Theory
// Interviewer - Prashant Jannu

// Java Concepts: JVM, Multithreading, Exception Handling
// OOP Concepts with Examples
// Spring Boot Concepts: How Auto-Configuration Works, Different Annotations
// Common Linux Commands
// Benefits of Microservices over Monolithic Architecture
// Do You Work on Front-End Technologies?
