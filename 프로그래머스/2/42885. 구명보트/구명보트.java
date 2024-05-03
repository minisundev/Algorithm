import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0;

        int left = 0;  // 제일 가벼운 사람부터
        int right = people.length - 1;  // 제일 무거운 사람부터

        while (left <= right) {
            int sum = 0;
            sum += people[right--];//무거운 사람 일단 태움
            
            if(sum + people[left]<=limit){//가벼운 사람 태울 수 있으면 태움
                sum += people[left];
                left++;
            }
            count++;//보트 증가시킴
        }

        return count;
    }
}