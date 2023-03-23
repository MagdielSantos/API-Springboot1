const  CarregarUsuarios = async () => {

    const response = await fetch('http://localhost:8080/api')
    const dados = await response.json()
    console.log(dados);
  
    dados.forEach(item => {
        
        const containterUsuarioElement = document.getElementById('container-usuarios')

        const template = document.getElementById('Usuario-template')

        const UsuarioElement = document.importNode(template.content, true)

        const itensUsuario = UsuarioElement.querySelectorAll('span')

        itensUsuario[0].innerText = " " + item.nome 
        itensUsuario[1].innerText = " " + item.email
        itensUsuario[2].innerText = " " + item.numero
        itensUsuario[3].innerText = " " + item.profissao 

        containterUsuarioElement.append(UsuarioElement)



    });

}

  
  
  
  
  
  
  
  
  window.onload = () => {
    CarregarUsuarios()
  }