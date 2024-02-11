import java.util.HashMap;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
         HashMap<String, String> keymaps = new HashMap<String, String>();
        
        for(int i=0; i<keymap.length;i++){
            for(int j=0;j<keymap[i].length();j++){
                if(keymaps.containsKey(""+keymap[i].charAt(j))){
                    int count = Integer.parseInt(keymaps.get(""+keymap[i].charAt(j)));
                    if(count>j+1){
                        keymaps.put(""+keymap[i].charAt(j),Integer.toString(j+1));
                    }
                }else{
                    keymaps.put(""+keymap[i].charAt(j),Integer.toString(j+1));
                }
            }
        }
        
        Loop:
        for(int i=0;i<targets.length;i++)
        {
            int count =0;
            for(int j=0;j<targets[i].length();j++){
                if(keymaps.containsKey(""+targets[i].charAt(j))){
                    count += Integer.parseInt(keymaps.get(""+targets[i].charAt(j)));
                }
                else{
                    answer[i]=-1;
                    continue Loop;
                }
            }
            answer[i]=count;
        }
        
        return answer;
    }
}