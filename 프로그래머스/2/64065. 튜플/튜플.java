import java.util.*;
import java.lang.Math;

class Solution {
    public int[] solution(String s) {
        
        Stack<String> stack = new Stack<>();
        List<Integer> elements;
        Map<Integer,Integer> map = new HashMap(){};
        
        StringBuilder sb = new StringBuilder();//number cache
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c=='}'){//꺼낸다
                //number flush
                if(sb.length()>0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                
                elements = new ArrayList<>();
                while(!stack.peek().equals("{")){
                    elements.add(Integer.parseInt(stack.pop()));
                }
                stack.pop();//{ 뽑아줌
                
                for(int element : elements){//해당 Key가 소속된 가장 작은 튜플길이로 해당 Key의 Value를 업데이트
                    int length = map.getOrDefault(element,Integer.MAX_VALUE);
                    length = Math.min(length,elements.size());
                    map.put(element,length);
                }
                
            }else if(c==','){
                //number flush
                if(sb.length()>0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                
            }else if(c=='{'){
                stack.push("{");
                
            }else{//숫자라면 넣는다
                sb.append(c);
            }
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1,o2) -> o1.getValue()-o2.getValue());//value 기준 오름차순 정렬
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i).getKey();
        }
        
        return answer;
    }
}