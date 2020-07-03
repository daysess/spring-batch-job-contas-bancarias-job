package br.com.daysesoares.contasbancariasjob.dominio;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.daysesoares.contasbancariasjob.enums.Tipo;

public class Conta {
	
	@NotNull
	private Integer id;
	@NotNull
	private Tipo tipo;
	@NotNull
	private Double limite;
	@NotNull
	private Cliente cliente;
	
	public Conta() {
		
	}

	public Conta(@NotNull Integer id, @NotNull Tipo tipo, @NotNull Double limite, @NotNull Cliente cliente) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.limite = limite;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", tipo=" + tipo + ", limite=" + limite + ", cliente=" + cliente + "]";
	}
		
}
