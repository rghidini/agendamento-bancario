package br.com.ghidini.banco.business;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.ghidini.banco.strategy.ICalculoTaxa;


public class CalculoTaxaAService implements ICalculoTaxa {
	
	private LocalDate dataAgendamento;
	private LocalDate dataTransferencia;
	private BigDecimal valorTransferencia;
	
	

	public CalculoTaxaAService(LocalDate dataAgendamento, LocalDate dataTransferencia, BigDecimal valorTransferencia) {
		this.dataAgendamento = dataAgendamento;
		this.dataTransferencia = dataTransferencia;
		this.valorTransferencia = valorTransferencia;
	}

	@Override
	public BigDecimal calculoTaxa() {

		BigDecimal taxa = BigDecimal.ZERO;

		if(this.dataAgendamento.equals(this.dataTransferencia)){
			taxa = ((this.valorTransferencia.multiply(new BigDecimal("0.03"))).add(new BigDecimal("3"))); 
		}
		
		return taxa;
	}
	
	
}
