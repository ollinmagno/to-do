package br.com.bwn.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   
   @PostMapping
   public Tarefa criarTarefa(@RequestBody Tarefa tarefa){
      return repositorio.save(tarefa);
   }
   
   @GetMapping
   public List<Tarefa> findAll(){
      return repositorio.findAll();
   }
   
   
}