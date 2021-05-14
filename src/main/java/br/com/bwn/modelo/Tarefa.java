package br.com.bwn.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String descricao;
	private boolean ativo;
	private boolean realizado;
	private LocalDateTime dataDeCriacao = LocalDateTime.now();
	private LocalDateTime dataDeModificacao = LocalDateTime.now();
	private long tempoDeDuracaoEmHoras;

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", ativo=" + ativo + ", realizado=" + realizado + ", dataDeCriacao=" + dataDeCriacao
				+ ", dataDeModificacao=" + dataDeModificacao + ", tempoDeDuracaoEmHoras=" + tempoDeDuracaoEmHoras + "]";
	}

	public Tarefa() {

	}

	public Tarefa(Long id, String nome, String descricao, boolean ativo, boolean realizado) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ativo = ativo;
		this.realizado = realizado;
	}

	public long getTempoDeDuracaoEmHoras() {
		return tempoDeDuracaoEmHoras;
	}

	public void setTempoDeDuracaoEmHoras(long tempoDeDuracaoEmHoras) {
		this.tempoDeDuracaoEmHoras = tempoDeDuracaoEmHoras;
	}

	public LocalDateTime getDataDeModificacao() {
		return dataDeModificacao;
	}

	public void setDataDeModificacao(LocalDateTime dataDeModificacao) {
		this.dataDeModificacao = dataDeModificacao;
	}

	public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

}