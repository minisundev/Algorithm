import java.util.Arrays;
import java.lang.Math;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        int allpicks = 0;
        for(int i: picks){
            allpicks += i;
        }
        
        int number = Math.min(allpicks,(int)Math.ceil(minerals.length/5)+1);

        Group [] groups = new Group[number];
        
        for(int i=0;i<groups.length;i++){
            groups[i] = new Group(0,0,0);
        }

        for(int i=0;i<minerals.length;i++){
            if(i/5>=groups.length){
                break;
            }
            String element = minerals[i];
            if(element.equals("diamond")){
                groups[i/5].diamond++;
            }
            if(element.equals("iron")){
                groups[i/5].iron++;
            }
            if(element.equals("stone")){
                groups[i/5].stone++;
            }            
        }
        //정렬 후 계산
        
        Arrays.sort(groups);
        
        int [] toolcost = {25,5,1};
        
        int index = 0;
        int sum = 0;
        for(int i=0; i<groups.length; i++){
            
            if(index >= picks.length) {
                break;
            }

            while(picks[index] <= 0) {
                index++;
            } 
            
            picks[index]--;
            int mined = 0;
            mined = mine(groups[i].diamond, toolcost[index], 25);
            sum += mined;
            
            mined = mine(groups[i].iron, toolcost[index], 5);
            sum += mined;
            
            mined = mine(groups[i].stone, toolcost[index], 1);
            sum += mined;

        }   
            
        return sum;
    }
    
    public int mine(int number, int tool, int cost){
        int i = Math.max(cost/tool,1);
        return i*number;
    }
}

class Group implements Comparable<Group>{
    int diamond;
    int iron;
    int stone;
    
    public int compareTo(Group o){
        if(this.diamond>o.diamond){
            return -1;
        }else if(this.diamond==o.diamond){
            if(this.iron>o.iron){
                return -1;
            }else if(this.iron==o.iron){
                return 0;
            }
        }
        return 1;
    }
    
    public Group(int d, int i, int s){
        diamond = d;
        iron = i;
        stone = s;
    }
}