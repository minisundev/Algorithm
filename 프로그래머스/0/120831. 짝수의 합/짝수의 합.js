function solution(n) {
    var answer = 0;
    if(n%2==0){
        answer = n;
    }else{
        answer = n-1;   
    }
    for(var i = answer-2; i>0; i = i-2){
        answer += i;
    }
    return answer;
}