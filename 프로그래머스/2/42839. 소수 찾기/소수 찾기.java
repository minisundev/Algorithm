import java.util.*;
import java.lang.Math;
import java.util.Collections;

class Solution {
        
    public int solution(String numbers) {
        int answer = 0;
        //HashMap에 등록함
        char [] characters = new char[numbers.length()];
        HashMap<Character,Integer> counts = new HashMap<>();
        for(int i=0; i<numbers.length(); i++){
            char c = numbers.charAt(i);
            int count = counts.getOrDefault(c,0);
            count++;
            counts.put(c,count);
            characters[i] = c;
            
        }
        
        //조합 시작
        HashSet<Integer> primes = new HashSet<>();
        HashSet<String> queue = new HashSet<>();
        HashSet<String> next = null;
        queue.add("");
        
        while(!queue.isEmpty()){
            
            next = new HashSet<>();
            
            for(String s : queue){
                for(char c : characters){
                    int possible = counts.get(c);
                    int actual = contains(c,s);
                    if(actual<possible){
                        String added = s+c;
                        next.add(added);
                        int addedInt = Integer.parseInt(added);
                        if(!primes.contains(addedInt)){
                            if(isPrime(addedInt)){
                            primes.add(addedInt);
                            }
                        }
                    }
                }
            }
            queue = next;
        }
        return primes.size();
    }
    
    public int contains(char c, String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}