package br.com.ghidini.banco.business;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.com.ghidini.banco.strategy.ICalculoTaxa;

@Service
public class CalculadoraTaxaService{

	public BigDecimal calcular(ICalculoTaxa calculo) { 
		return calculo.calculoTaxa(); 
	} 

}
