const isStrPresent=(str1,str2)=>{

    if(str1.includes(str2))
        return true;
    else
    return false;

}


console.log(isStrPresent("hello","world"))
console.log(isStrPresent("hello","hello"))
console.log(isStrPresent("hello","Hello"))

