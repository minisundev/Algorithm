import java.util.*;
class Solution {
    int count = 0;
    List<Map<String,List<Integer>>> list = new ArrayList<>();
    Map<Integer,Integer> index = new HashMap<>();
    List<Integer> can = new ArrayList<>();
    String[][] arr;
    Set<Set<Integer>> usedKeys = new HashSet<>();
    
    public int solution(String[][] relation) {
        arr = relation;
        //하나로써 유일한 것들 count에 미리 등록, 아닌 것들만 추려서 List에 등록 후 복합키로 쓸 수 있는지 본다
        for(int i=0; i<relation[0].length; i++){  // 여기 length -> [0].length
            Set<String> set = new HashSet<>();
            for(int j=0; j<relation.length; j++){  // 행 루프
                set.add(relation[j][i]);
            }
            if(set.size()==relation.length){  // 여기도 relation.length
                count++;
                Set<Integer> key = new HashSet<>();
                key.add(i);
                usedKeys.add(key);
            }else{
                can.add(i);
            }
        }
        
        //복합키 체크
        //dfs?
        List<String> init = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            init.add("");
        }
        dfs(0, init, arr.length, new HashSet<>());
        
        return count;
    }
    
    void dfs(int idx, List<String> l, int size, Set<Integer> used){
        if(idx==arr[0].length){
            if(size==arr.length && used.size()>0){
                // 최소성 체크
                for(Set<Integer> key : usedKeys){
                    if(used.containsAll(key)){
                        return;
                    }
                }
                count++;
                usedKeys.add(new HashSet<>(used));
            }
            return;
        }
        
        if(!can.contains(idx)){
            dfs(idx+1,l,size,used);
            return;
        }
        
        //안포함
        dfs(idx+1,l,size,used);
        
        //포함
        List<String> temp = new ArrayList<>();
        Set<String> set = new HashSet<>();
            
        for(int j=0; j<arr.length; j++){
            String o = l.get(j);
            String add = arr[j][idx];
            temp.add(o+'_'+add);
            set.add(o+'_'+add);
        }
        Set<Integer> newUsed = new HashSet<>(used);
        newUsed.add(idx);
        dfs(idx+1,temp,set.size(),newUsed);
    }
}