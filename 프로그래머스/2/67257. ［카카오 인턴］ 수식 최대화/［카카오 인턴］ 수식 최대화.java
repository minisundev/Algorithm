import java.util.*;
import java.lang.Math;

class Solution {

    long [] operators = {-1,-2,-3};//{"*","+","-"};
    long [] arr = new long[3];
    boolean [] visit = {false,false,false};
    long max = 0;
    
    List <Long> exp = new ArrayList<>();
    
    public long solution(String expression) {
        
        StringBuilder number = new StringBuilder();
        
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            
            if(c=='*'||c=='+'||c=='-'){
                exp.add(Long.parseLong(number.toString()));
                number = new StringBuilder();
                
                if(c=='*'){
                    exp.add(-1L);
                }
                else if(c=='+'){
                    exp.add(-2L);
                }
                else if(c=='-'){
                    exp.add(-3L);
                }
                continue;
            }
            
            number.append(c);
            
            if(i==expression.length()-1){
                exp.add(Long.parseLong(number.toString()));
            }
        }
        setOperator(0);
        
        return max;
    }

    void setOperator(int depth){
        if(depth == operators.length){
            long result = calculate();
            max = Math.max(max,Math.abs(result));
            return;
        }
        
        for(int i = 0; i<operators.length ; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = operators[i];
                setOperator(depth+1);
                visit[i] = false;
            } 
        }
    }
    
    long calculate(){
        List<Long> expression = new ArrayList(exp);

        for(long op : arr){
            int index = 0;
            while(0<=index && index<expression.size()&&expression.size()>1){//여기 인덱스 관련해서 런타임 에러가 날것같은데..
                long s = expression.get(index);
                
                if(s==op){
                    long left = s;
                    if(index-1>=0){
                        left = expression.get(index-1);
                    }
                    
                    long right = s;
                    if(index+1<expression.size()){
                        right = expression.get(index+1);
                    }
                    
                    long result = operate(left, op, right);
                   
                    if(index+1<expression.size()){
                        expression.remove(index+1);
                    }
                    
                    if(index-1>=0){
                        expression.set(index-1, result);
                    }
                    
                    expression.remove(index);
                    index--;
                }
                index++;
            }
        }
        return expression.get(0);
    }
    
    long operate(long left, long op, long right){
        long result = 0;
        if(op==-1L){
            result =  left*right;
        }else if(op==-2L){
            result =  left+right;
        }else if(op==-3L){
            result =  left-right;
        }
        return result;
    }
}