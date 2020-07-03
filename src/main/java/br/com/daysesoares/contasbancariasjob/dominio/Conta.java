package br.com.daysesoares.contasbancariasjob.dominio;

import javax.validation.constraints.NotNull;

import br.com.daysesoares.contasbancariasjob.enums.Tipo;

public class Conta {


	private Integer id;
	private Tipo tipo;
	private Double limite;
	private String clienteId;
	
	public Conta() {
		
	}

	public Conta(@NotNull Integer id, @NotNull Tipo tipo, @NotNull Double limite, @NotNull String clienteId) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.limite = limite;
		this.clienteId = clienteId;
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

	public String getCliente() {
		return clienteId;
	}

	public void setCliente(String cliente) {
		this.clienteId = cliente;
	}

	@Override
	public String toString() {
		return " Conta [tipo=" + tipo + ", limite=" + limite +"]";
	}
		
}
