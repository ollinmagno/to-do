package br.com.bwn.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bwn.modelo.Tarefa;
import br.com.bwn.repositorio.ITarefaRepositorio;

@RestController
@RequestMapping({"/tarefas"})
public class CriarTarefa {

   private ITarefaRepositorio repositorio;

   CriarTarefa(ITarefaRepositorio tarefaRepositorio) {
       this.repositorio = tarefaRepositorio;
   }
   
   @GetMapping
   public List<Tarefa> findAll(){
      return repositorio.findAll();
   }
   
}