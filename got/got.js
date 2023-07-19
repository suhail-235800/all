let characters;
let currentCharacterId = 0;

initialize();

function initialize() {
  fetchCharacterDetails(currentCharacterId);
}

function fetchCharacterDetails() {
  fetch(`https://thronesapi.com/api/v2/Characters/${currentCharacterId}`)
    .then(response => response.json())
    .then(data => {
      characters = data;
      populateCharacterDetails();
    })
    .catch(err => console.log(err));
}

function populateCharacterDetails() {
  document.getElementById('cardtitle').innerHTML = characters.fullName;
  document.querySelector('img').src = characters.imageUrl;
  document.querySelector('.id').innerHTML = `ID: ${currentCharacterId}`;
  document.querySelector('.title').innerHTML = `Title: ${characters.title}`;
  document.querySelector('.first-name').innerHTML = `First Name: ${characters.firstName}`;
  document.querySelector('.last-name').innerHTML = `Last Name: ${characters.lastName}`;
  document.querySelector('.family').innerHTML = `Family: ${characters.family}`;
  document.querySelector('.image').innerHTML = `image: ${characters.image}`;
  document.querySelector('.image-url').innerHTML = `Image URL: ${characters.imageUrl}`;
}

document.querySelector('#button-2').addEventListener('click', () => {
  currentCharacterId++;

  if (currentCharacterId > 2137) {
    currentCharacterId = 1;
    fetchCharacterDetails();
  }
  else{
    fetchCharacterDetails();
  }

  
});

document.querySelector('#button-1').addEventListener('click', () => {
  

  if (currentCharacterId == 0 ) {
    currentCharacterId = 0

  fetchCharacterDetails();}

  else {
    currentCharacterId--;
    fetchCharacterDetails();
  }

});