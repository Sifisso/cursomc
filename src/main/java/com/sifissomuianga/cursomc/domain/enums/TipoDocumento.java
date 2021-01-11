package com.sifissomuianga.cursomc.domain.enums;

public enum TipoDocumento {

	BILHETEDEINDENTIDADE(1, "Bilhete de Identidade"),
	TALAODEBILHETEDEIDENTIDADE(2, "Talão de Bilhete de Identidade"),
	CARTADECONDUCAO (3, "Cartao de Condu"),
	CARTAODEELEITOR(4, "Cartão de Eleitor"),
	PASSAPORTE (5, "Passaporte"),
	DIRE (6, "DIRE");
	
	
	private int cod;
	private String descricao;
	
	private TipoDocumento(int cod, String descricao) {
		this.cod=cod;
		this.descricao=descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoDocumento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoDocumento x: TipoDocumento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
