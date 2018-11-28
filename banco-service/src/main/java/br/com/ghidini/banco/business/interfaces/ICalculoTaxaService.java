package br.com.ghidini.banco.business.interfaces;

import java.math.BigDecimal;

import br.com.ghidini.banco.model.TransacaoBancaria;

@FunctionalInterface
public interface ICalculoTaxaService {
	
	public BigDecimal calcularTaxa(TransacaoBancaria transacaoBancaria);

}
