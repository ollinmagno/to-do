package br.com.bwn.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bwn.modelo.Tarefa;
import br.com.bwn.repositorio.ITarefaRepositorio;

@RestController
@RequestMapping({ "/tarefas" })
public class CriarTarefa {

	private ITarefaRepositorio repositorio;

	CriarTarefa(ITarefaRepositorio tarefaRepositorio) {
		this.repositorio = tarefaRepositorio;
	}

	@PostMapping
	public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
		return repositorio.save(tarefa);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Tarefa> encontrarPorID(@PathVariable long id) {
		Optional<Tarefa> tarefas = repositorio.findById(id);
		
		if (tarefas.isPresent()) {
			return new ResponseEntity<Tarefa>(tarefas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Tarefa>(new Tarefa(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@GetMapping
	public List<Tarefa> findAll() {
		return repositorio.findAll();
	}

}