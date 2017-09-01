package br.com.ghidini.banco.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghidini.banco.factory.CalculadorDeTaxasFactory;
import br.com.ghidini.banco.model.TransacaoBancaria;

/**
 * @author raghidin
 *
 */
@RestController
public class TransacaoBancariaController {

	private List<TransacaoBancaria> transacao = new ArrayList<TransacaoBancaria>();
	
	@Autowired
	CalculadorDeTaxasFactory calculador;

	@CrossOrigin
	@GetMapping("/transacoes")
	public List<TransacaoBancaria> listAll(){
		return transacao;
	}

	@CrossOrigin
	@PostMapping("/cadastro-transacoes")
	public TransacaoBancaria insert(@RequestBody TransacaoBancaria transacaoBancaria){
		transacao.add(transacaoBancaria);
		return transacao.get(transacao.size()-1);
	}

	@CrossOrigin
	@PostMapping("/taxa")
	public TransacaoBancaria calcularTaxa(@RequestBody TransacaoBancaria transacaoBancaria){
		BigDecimal taxa = calculador.calculadorDeTaxas(transacaoBancaria);
		transacaoBancaria.setTaxa(taxa);
		return transacaoBancaria;
	}

}
