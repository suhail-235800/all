const add = document.querySelector('#add');
const todo = document.querySelector('#todo');
const unordered = document.querySelector('#unordered');

let todos = [];

add.addEventListener('click', () => {

    const todoText = todo.value.trim();    
    const listItem = createTodo(todoText);
    unordered.appendChild(listItem);
    todos.push(todoText);
    localStorage.setItem('todos', JSON.stringify(todos));
    
    todo.value = '';
});

const createTodo = (todoText) => {
  let listItem = document.createElement('li');
  listItem.classList.add('list-group-item', 'list-group-item-action', 'd-flex', 'justify-content-between');

  let span = document.createElement('span');
  span.innerText = todoText;

  let button = document.createElement('button');
  button.classList.add('btn', 'btn-danger');

  let i = document.createElement('i');
  i.classList.add('bi', 'bi-trash3');

  button.appendChild(i);

  button.addEventListener('click', () => {
  
    listItem.remove();

    todos = todos.filter(item => item !== todoText);

    localStorage.setItem('todos', JSON.stringify(todos));
  });

  listItem.appendChild(span);
  listItem.appendChild(button);

  return listItem;
}

document.addEventListener('DOMContentLoaded', () => {
  const savedTodos = JSON.parse(localStorage.getItem('todos')) || [];

  savedTodos.forEach((todoText) => {
    const listItem = createTodo(todoText);
    unordered.appendChild(listItem);
    todos.push(todoText);
  });
});
