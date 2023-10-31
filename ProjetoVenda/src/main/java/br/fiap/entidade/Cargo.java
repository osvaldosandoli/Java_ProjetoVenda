package br.fiap.entidade;

public enum Cargo implements Comissao {
	ATENDENTE(1, "Atendente") {
		public double calcularComissao(Double valor) {
			return valor * 0.10;
		}
	}, 
	
	VENDEDOR(2, "Vendedor") {
		public double calcularComissao(Double valor) {
			return valor * 0.15 + 50;
		}
	},
	
	GERENTE(3, "Gerente") {
		public double calcularComissao(Double valor) {
			return valor * 0.20 + 100;
		}
	};
		
	private Integer id;
	private String cargo;
	
	private Cargo(Integer id, String cargo) {
		this.id = id;
		this.cargo = cargo;
	}

	public Integer getId() {
		return id;
	}

	public String getCargo() {
		return cargo;
	}	
}
