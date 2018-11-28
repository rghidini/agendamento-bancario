package br.com.ghidini.banco.business;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.ghidini.banco.strategy.ICalculoTaxa;
import br.com.ghidini.banco.utils.Utils;


public class CalculoTaxaCService implements ICalculoTaxa {

	private LocalDate dataAgendamento;
	private LocalDate dataTransferencia;
	private BigDecimal valorTransferencia;



	public CalculoTaxaCService(LocalDate dataAgendamento, LocalDate dataTransferencia, BigDecimal valorTransferencia) {
		this.dataAgendamento = dataAgendamento;
		this.dataTransferencia = dataTransferencia;
		this.valorTransferencia = valorTransferencia;
	}


	@Override
	public BigDecimal calculoTaxa() {

		BigDecimal taxa = BigDecimal.ZERO;
		Long difference = Utils.differenceInDays(this.dataAgendamento, this.dataTransferencia);

		//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 10 e menor que 20 dias
		if(difference > 10 && difference <= 20){
			taxa = this.valorTransferencia.multiply(new BigDecimal("0.082"));

			//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 20 e menor que 30 dias
		}else if(difference > 20 && difference <= 30){
			taxa = this.valorTransferencia.multiply(new BigDecimal("0.069"));

			//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 30 e menor que 40 dias
		}else if(difference > 30 && difference <= 40){
			taxa = this.valorTransferencia.multiply(new BigDecimal("0.047"));

			//verifica se a diferença entre a data de agendamento e a de transferencia é maior que 40 dias
		}else if(difference > 40){
			taxa = this.valorTransferencia.multiply(new BigDecimal("0.017"));
		}

		return taxa;
	}

}
