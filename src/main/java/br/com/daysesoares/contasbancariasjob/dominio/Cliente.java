package br.com.daysesoares.contasbancariasjob.dominio;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Cliente {

	@NotNull
	@Size(min=1, max=100)
	@Pattern(regexp="[a-zA-Z\\s]+", message="Nome deve ser alfabético")
	private String nome;
	
	@NotNull
	private Integer idade;
	
	@NotNull
	@Size(min=1, max=50)
	@Pattern(regexp="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message="Email inválido")
	private String email;
	
	@NotNull
	private Double faixaSalarial;
	
	private Conta conta;
	
	public Cliente ()
	{
		
	}

	public Cliente(
			@NotNull @Size(min = 1, max = 100) @Pattern(regexp = "[a-zA-Z\\s]+", message = "Nome deve ser alfabético") String nome,
			@NotNull Integer idade,
			@NotNull @Size(min = 1, max = 50) @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email inválido") String email,
			@NotNull Double faixaSalarial, Conta conta) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.faixaSalarial = faixaSalarial;
		this.conta = conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getFaixaSalarial() {
		return faixaSalarial;
	}

	public void setFaixaSalarial(Double faixaSalarial) {
		this.faixaSalarial = faixaSalarial;
	}
	

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + ", email=" + email + ", faixaSalarial=" 
				+ faixaSalarial
				+ conta.toString()
				+ "]";
	}
	
}
