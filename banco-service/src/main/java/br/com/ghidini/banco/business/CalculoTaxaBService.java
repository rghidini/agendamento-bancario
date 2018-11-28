package br.com.ghidini.banco.business;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.ghidini.banco.strategy.ICalculoTaxa;
import br.com.ghidini.banco.utils.Utils;


public class CalculoTaxaBService implements ICalculoTaxa{
	
	private LocalDate dataAgendamento;
	private LocalDate dataTransferencia;
	

	public CalculoTaxaBService(LocalDate dataAgendamento, LocalDate dataTransferencia) {
		this.dataAgendamento = dataAgendamento;
		this.dataTransferencia = dataTransferencia;
	}

	@Override
	public BigDecimal calculoTaxa() {
		
		BigDecimal taxa = BigDecimal.ZERO;
		Long difference = Utils.differenceInDays(this.dataAgendamento, this.dataTransferencia);
		
		if( difference > 0 && difference <= 10){
			taxa = new BigDecimal("12");
		}
		
		return taxa;
	}
}
