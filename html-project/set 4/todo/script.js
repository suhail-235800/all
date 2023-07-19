const checkcontainer= document.querySelector('.check-container');
const input = document.getElementById('input');
const addButton = document.getElementById('add-btn');


const add = (event) =>{
    if (input.value !== '') {

    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.className = 'checkbox-input'
    
    const label = document.createElement('label');
    label.innerText = input.value;
    label.className = 'checkbox-label';

    let div = document.createElement('div');
    div.className = 'checkbox';

    div.appendChild(checkbox);
    div.appendChild(label);

    checkcontainer.appendChild(div);}
}

const remove = (event) => {

    event.target.parentNode.remove();

}


addButton.addEventListener('click', add);
checkcontainer.addEventListener('change', remove);



