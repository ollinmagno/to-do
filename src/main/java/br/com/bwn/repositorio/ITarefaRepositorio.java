package br.com.bwn.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bwn.modelo.Tarefa;

public interface ITarefaRepositorio extends JpaRepository<Tarefa, Long> {

}
