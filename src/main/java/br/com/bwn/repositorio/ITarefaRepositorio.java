package br.com.bwn.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bwn.modelo.Tarefa;

@Repository
public interface ITarefaRepositorio extends JpaRepository<Tarefa, Long> {

}
