import java.util.*;

class Solution {
    
    PriorityQueue<Course> possible; 
    ArrayList<Map.Entry<Character,List<Integer>>> menuList;
    
    public String[] solution(String[] orders, int[] course) {
        
        Map<Character,List<Integer>> menus = new HashMap<>();
        List<Integer> people = new ArrayList<>();
        PriorityQueue<String> result = new PriorityQueue<>(
        (o1,o2) -> o1.compareTo(o2));
        
        //menus에 등록
        for(int i=0; i<orders.length; i++){
            String s = orders[i];
            people.add(i);
            
            for(int j=0; j<s.length(); j++){
                char c = s.charAt(j);
                List<Integer> customers = menus.getOrDefault(c, new ArrayList<>());
                customers.add(i);
                menus.put(c,customers);
            }
        }
        
        menuList = new ArrayList<>( menus.entrySet());
        
        //size별로 제일 높은 빈도의 코스 저장
        for(int size : course){
            possible = new PriorityQueue<>();
            char [] arr = new char[size];
            combination(arr,0,-1,new ArrayList<>(people));
            
            if(possible.peek()!=null){
                int count = possible.peek().count;
                while(possible.peek()!=null && count == possible.peek().count){
                    result.add(possible.poll().course);
                }
            }
            
        }
          
         String [] answer = new String[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.poll();
        }
         return answer;
    }
    
    //조합해봄 배가 고프다
    void combination(char [] arr, int depth, int max, List<Integer> people){
        
        if(people.size()<2){
            return;
        }
        
        if(arr.length==depth){
            String s = charArrToString(arr);
            possible.add(new Course(people.size(),s));
            return;
        }
        
        for(int i=max+1; i<menuList.size(); i++){
            Map.Entry<Character,List<Integer>> entry  = menuList.get(i);
            
            List<Integer> newPeople = entry.getValue();
            List<Integer> people2 = new ArrayList<>(people);
            
            removePeople(newPeople, people2);
            
            arr[depth] = entry.getKey();
            combination(arr,depth+1,i,people2);
        }
    }
    
    void removePeople(List<Integer> newPeople, List<Integer> people){
        for(int i=0; i<people.size(); i++){
            int person = people.get(i);
            boolean exist = false;
            for(int t : newPeople){
                if(t==person){
                    exist = true;
                    break;
                }
            }
            if(!exist){
                people.remove(i);
                i--;
            }
        }
    }
    
    String charArrToString(char [] arr){
        StringBuilder sb = new StringBuilder();
        for(char c : arr){
            sb.append(c);
        }
        return sb.toString();
    }
    
}

class Course implements Comparable<Course>{
    public int count;
    public String course;
    public Course(int c, String s){
        count = c;
        course = s;
    }
    
    public int compareTo(Course o2){

       return o2.count-this.count;
        
    }
}