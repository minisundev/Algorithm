function solution(numbers) {
    var mid = parseInt(numbers.length/2);
    if(numbers.length%2===0){
        return (numbers[mid-1]+numbers[mid])/2;
    }else{
        return numbers[mid];
    }
}