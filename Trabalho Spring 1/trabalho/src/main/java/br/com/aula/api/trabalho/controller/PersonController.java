package br.com.aula.api.trabalho.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.aula.api.trabalho.model.Person;
import br.com.aula.api.trabalho.repository.PersonRepositorio;
import br.com.aula.api.trabalho.servico.Servico;

@RestController
@CrossOrigin("*")
public class PersonController {
    
    @Autowired
    private PersonRepositorio acao;

    @Autowired
    private Servico servico;

    //Cadastrar no banco de dados
    @PostMapping("/api/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody Person obj){
        return servico.Cadastrar(obj);
    }

    //Listar todos os cadastrados
    @GetMapping("/api")
    public ResponseEntity<?> lista() {
        return servico.selecionar();
    }

    //GET Achar pelo id
    @GetMapping("/api/id/{id}")
    public ResponseEntity<?> AcharId(@PathVariable Integer id) {
        return servico.Listarid(id);
    }

    //GET achar por nome
    @GetMapping("/api/{nome}")
    public List<Person> AcharNome(@PathVariable String nome) {
        return acao.findByNome(nome);
    }

    //GET achar pela profissão                
    @GetMapping("/api/prof/{profissao}")
    public List<Person> AcharProfissao(@PathVariable String profissao) {
        return acao.findByProfissao(profissao);
    }

    //Editar informações do usuario
    @PutMapping("/api/editar")
    public ResponseEntity<?> editar(@RequestBody Person obj){
        return servico.Editar(obj);
    }
  
    //Deletar pelo id
    @DeleteMapping("/api/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable int id){
        return servico.Excluir(id);
        
        
    }

    //Contador de registros
    @GetMapping("/api/contador")
    public long Contador(){
        return acao.count();
    }

}  

