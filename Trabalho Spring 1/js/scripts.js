
//conexão API


const formulario = document.querySelector("form");
const inome = document.querySelector(".nome");
const iemail = document.querySelector(".email");
const iprofissao = document.querySelector(".profissao");
const inumero = document.querySelector(".telefone");

formulario.addEventListener('submit', function (event) {
  event.preventDefault();

  const dados = {
    nome: inome.value,
    email: iemail.value,
    numero: inumero.value,
    profissao: iprofissao.value
  }
  cadastrar();
  limpar();
  irLista();
});


function limpar() { 
  
   inome.value = "",
  iemail.value = "",  
  iprofissao.value = "",
  inumero.value = ""

}




function cadastrar() {
  fetch("http://localhost:8080/api/cadastro",
  {
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json"
    },  
    method: "POST",
    body: JSON.stringify({
        
        nome: inome.value,
        email: iemail.value,  
        profissao: iprofissao.value,
        numero: inumero.value
    })
  })

  .then(function (res) {console.log(res) })
  .catch(function (res) {console.log (res) })

}

function irLista() {

  window.location = "Lista.html";
}

 

  



