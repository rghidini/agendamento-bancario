package br.com.ghidini.banco.business;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghidini.banco.business.interfaces.ICalculoTaxaService;
import br.com.ghidini.banco.model.TransacaoBancaria;

@Service
public class CalculoTaxaService implements ICalculoTaxaService{

	private static final Logger logger = Logger.getLogger(CalculoTaxaService.class);

	@Autowired
	private CalculadoraTaxaService calculadoraTaxa;

	@Override
	public BigDecimal calcularTaxa(TransacaoBancaria transacaoBancaria) {

		BigDecimal taxa = BigDecimal.ZERO;

		try {

			//veirifica se o valor é maior que zero e menor ou igual a mil
			if(transacaoBancaria.getValorTransferencia().compareTo(BigDecimal.ZERO) == 1
					&& (transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(1000)) == -1
					|| transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(1000)) == 0)){

				taxa = calculadoraTaxa.calcular(new CalculoTaxaAService(transacaoBancaria.getDataAgendamento(), 
						transacaoBancaria.getDataTransferencia(), transacaoBancaria.getValorTransferencia()));

				//verifica se o valor é maior que mil e menor ou igual a dois mil 
			} else if(transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(1000)) == 1
					&& (transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(2000))== -1
					|| transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(2000))== 0)){

				taxa = calculadoraTaxa.calcular(new CalculoTaxaBService(transacaoBancaria.getDataAgendamento(), 
						transacaoBancaria.getDataTransferencia()));

				//veirifica se o valor é maior que dois mil
			} else if(transacaoBancaria.getValorTransferencia().compareTo(new BigDecimal(2000)) == 1){

				taxa = calculadoraTaxa.calcular(new CalculoTaxaCService(transacaoBancaria.getDataAgendamento(), 
						transacaoBancaria.getDataTransferencia(), transacaoBancaria.getValorTransferencia()));

			}

		} catch(Exception ex) {
			logger.error("Ocorreu um erro ao calcular a taxa " + ex.getMessage());
		}


		return taxa;

	}

}
