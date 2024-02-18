class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings;
        quickSort(answer,0,answer.length-1,n);
        return answer;
    }
    public void quickSort(String[] arr, int left, int right , int n) {
        if (left >= right) {
            return;
        }
        String pivot = arr[right];
    
        int sortedIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i].charAt(n) < pivot.charAt(n)) {
                swap(arr, i, sortedIndex);
                sortedIndex++;
            }else if (arr[i].charAt(n) == pivot.charAt(n)) {
                if(arr[i].compareTo(pivot)<0){
                    swap(arr, i, sortedIndex);
                    sortedIndex++;
                }
            }
        }
        swap(arr, sortedIndex, right);
        quickSort(arr, left, sortedIndex - 1, n);
        quickSort(arr, sortedIndex + 1, right, n);
    }

    private void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}