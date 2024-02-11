class Solution {
    public int[] solution(String[] wallpaper) {
        
        int luy=0;
        int rdy=0;
        int lux=0;
        int rdx=0;
        
        luy:
        for(int i = 0; i<wallpaper.length;i++){
            for(int j = 0; j<wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j)=='#'){
                    luy = i;
                    break luy;
                }
            }
        }
        rdy:
        for(int i = wallpaper.length-1; i>=0;i--){
            for(int j = wallpaper[i].length()-1; j>=0;j--){
                if(wallpaper[i].charAt(j)=='#'){
                    rdy = i+1;
                    break rdy;
                }
            }
        }
        
        lux:
        for(int j = 0; j<wallpaper[0].length();j++){
            for(int i = 0;i<wallpaper.length;i++){
                if(wallpaper[i].charAt(j)=='#'){
                    lux = j;
                    break lux;
                }    
            }
        }
        
        rdx:
        for(int j = wallpaper[0].length()-1; j>=0;j--){
            for(int i=wallpaper.length-1;i>=0;i--){
                if(wallpaper[i].charAt(j)=='#'){
                    rdx = j+1;
                    break rdx;
                }    
            }
        }
        int[] answer = {luy, lux, rdy, rdx};
        return answer;
    }
}