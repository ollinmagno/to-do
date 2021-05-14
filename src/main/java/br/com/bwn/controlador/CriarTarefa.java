package br.com.bwn.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/tarefas")
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
		System.out.println(tarefas.get().getDescricao());
		if (tarefas.isPresent()) {
			return new ResponseEntity<Tarefa>(tarefas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Tarefa>(new Tarefa(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> marcarTarefaComoRealizada(@PathVariable("id") long id,
			@RequestBody Tarefa realizarTarefa) {
		Optional<Tarefa> tarefaAntiga = repositorio.findById(id);
		if (tarefaAntiga.isPresent()) {
			tarefaAntiga.get().setRealizado(realizarTarefa.isRealizado());
			repositorio.save(tarefaAntiga.get());
			return new ResponseEntity<Tarefa>(tarefaAntiga.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Tarefa>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Tarefa> deletarTarefa(@PathVariable("id") long id) {
		Optional<Tarefa> tarefa = repositorio.findById(id);
		if (tarefa.isPresent()) {
			repositorio.deleteById(id);;
			return new ResponseEntity<Tarefa>(tarefa.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Tarefa>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public List<Tarefa> encontrarTodasAsTarefas() {
		return repositorio.findAll();
	}

}