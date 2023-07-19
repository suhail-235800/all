const rgbButton = document.getElementById('rgbbtn');
const hexButton = document.getElementById('hexbtn');


const rgbrandom =()=>{
    return `rgb(
        ${Math.floor(Math.random()*256)},
        ${Math.floor(Math.random()*256)},
        ${Math.floor(Math.random()*256)})`
}

const rgb = (event)=>{
    document.body.style.backgroundColor =rgbrandom();
    rgbButton.style.backgroundColor =rgbrandom();
    rgbButton.style.color=rgbrandom();      
    
}

const hexrandom=()=>{

    let list = '0123456789abcdef';
    let color = '#';
    for(let i=0; i<6; i++){
        color = color + list[Math.floor(Math.random()*list.length)];
    }
    return color;
}

const hex = (event)=>{

    document.body.style.backgroundColor = hexrandom();
    hexButton.style.backgroundColor = hexrandom();
    hexButton.style.color=hexrandom();
}


rgbButton.addEventListener('click',rgb);

hexButton.addEventListener('click',hex);

document.addEventListener("DOMContentLoaded",hex);