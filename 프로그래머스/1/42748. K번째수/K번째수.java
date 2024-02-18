class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int [] arr = array.clone();
            quickSort(arr,commands[i][0]-1,commands[i][1]-1);
            answer[i] = arr[commands[i][0]-1+commands[i][2]-1];
        }
        return answer;
    }
    public void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[right];
    
        int sortedIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, sortedIndex);
                sortedIndex++;
            }
        }
        swap(arr, sortedIndex, right);
        quickSort(arr, left, sortedIndex - 1);
        quickSort(arr, sortedIndex + 1, right);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}