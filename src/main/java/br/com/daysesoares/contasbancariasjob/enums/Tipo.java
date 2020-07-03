package br.com.daysesoares.contasbancariasjob.enums;

public enum Tipo {
	
	PRATA(1, "PRATA"),
	OURO(2, "OURO"),
	PLATINA(3, "PLATINA"),
	DIAMANTE(4, "DIAMANTE");

	private Integer id;
	private String tipo;
	
	private Tipo(Integer id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
