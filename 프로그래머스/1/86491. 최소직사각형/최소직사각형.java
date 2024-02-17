class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        
        for(int i = 0; i < sizes.length ; i++){
            int w = Math.max(sizes[i][0],sizes[i][1]);
            int h = Math.min(sizes[i][1],sizes[i][0]);
            if(w>width){
                width = w;
            }
            if(h>height){
                height = h;
            }
        }
        return height*width;
    }
}