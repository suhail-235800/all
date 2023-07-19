const oddOrEvenNumber = function(x){
        
    if(x%2==0)
        return "Even"
    else
        return "Odd"

}



const oddOrEvenArray = function(arr){

    let result = [];

    for(i=0;i<arr.length;i++){
        result.push(oddOrEvenNumber(arr[i]))
    }

    return result
    
}

console.log(oddOrEvenArray([1, 2, 3, 4, 5])); 
console.log(oddOrEvenArray([10, 20, 30, 40, 50])); 
