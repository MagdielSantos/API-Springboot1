package br.com.aula.api.trabalho.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.aula.api.trabalho.model.Person;

@Repository
public interface PersonRepositorio extends CrudRepository<Person, Integer> {
    
    List<Person> findAll();

    List<Person> findByNome(String nome);

    List<Person> findByProfissao(String profissao);

    Person findByid(int id);

    int countByid(int cod);
}
