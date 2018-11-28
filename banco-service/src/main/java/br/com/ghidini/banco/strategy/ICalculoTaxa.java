package br.com.ghidini.banco.strategy;

import java.math.BigDecimal;
import java.time.LocalDate;

@FunctionalInterface
public interface ICalculoTaxa {
	
	public BigDecimal calculoTaxa();

}
