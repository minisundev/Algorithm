import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sets = new HashSet<Integer>();
        for(int size = 1; size<=elements.length; size++){
            for(int i=0;i<elements.length; i++){
                
                int sum = 0;
                for(int j=0;j<size;j++){
                    int index = (i+j)%elements.length;
                    sum += elements[index];
                }
                sets.add(sum);
            }
        }
        
        return sets.size();
    }
}