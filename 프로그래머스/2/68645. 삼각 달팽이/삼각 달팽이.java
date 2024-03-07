class Solution {
    public int[] solution(int n) {
        
        int[][] array = new int[n][];

        for (int i = 0; i < n; i++) {
            array[i] = new int[i + 1];
        }

        boolean left = true;
        boolean bottom = false;
        boolean right = false;
        boolean turned = false;

        int max = (1 + n) * n / 2;
        int number = 1;

        int i = 0;
        int j = 0;

        snail:
        while (number <= max) {

            if(turned){
                turned = false;
            }
            else if (i >= n || j >= n || array[i][j] != 0) {//다음 인덱스가 배열 밖이 되는지,이미 숫자가 있는지 체크

                if (left) {
                    left = false;
                    bottom = true;

                    i--;
                    number--;
                    turned = true;
                    continue;

                } else if (bottom) {
                    bottom = false;
                    right = true;

                    j--;
                    number--;
                    turned = true;
                    continue;

                } else if (right) {
                    right = false;
                    left = true;

                    i = i + 2;
                    j = j+1;

                    turned = true;
                    continue;

                }
            }

            if (left) {
                array[i++][j] = number++;
            } else if (bottom) {
                array[i][j++] = number++;
            } else if (right) {
                array[i--][j--] = number++;
            }
        }
        
         int index = 0;
         int [] answer = new int[max];
        //출력
        for(int i1=0;i1<n;i1++){
            for(int j1=0;j1<array[i1].length;j1++){
                answer[index++] = array[i1][j1];
            }
        }
        
         return answer;
    }
}