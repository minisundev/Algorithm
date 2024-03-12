import java.util.*;
class Solution {
    
    ArrayList<Integer> arr;
    
    public int solution(int[] numbers, int target) {
        arr = new ArrayList<Integer>();
        int sum = 0;
        int cnt = 0;
        for(int x : numbers) {
            arr.add(x);
            sum+= x;
        }
        cnt = getTarget(arr, 0, sum, target, cnt);

        return cnt;
    }
    
    public int getTarget(ArrayList<Integer> numbers, int from, int sum, int target, int cnt){

        for(int i = from; i<numbers.size(); i++){
            //새로 i 시작할 때마다 sum을 저장하고 list를 새로 복제해 옴
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.addAll(numbers);
            
            int nextSum = sum-(list.get(i) * 2);//지금 sum에서 이번 원소 빼봄
            
            if(nextSum < target)
                continue;//작으면 더 빼도 같아질 일이 없으니까 넘김
            else if(nextSum == target)//같으면 count
                cnt+= 1;
            else {//nextSum > target //크면 나중 인덱스에서 더 빼기를 시켜봄
                list.remove(i);//list에서 빼버려도 괜찮음 i가 시작할때마다 새걸 list에서 복사할테니까
                if(list.size() == 1)//size가 1이면 이것도 더 빼봤자 같아질 일이 없으니까 pass
                    continue;
                cnt += getTarget(list, i, nextSum, target, 0);
            }
        }
        return cnt;
    }
}