package br.com.ghidini.banco.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghidini.banco.business.interfaces.ICalculoTaxaService;
import br.com.ghidini.banco.model.TransacaoBancaria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value = "/taxa", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Calcular Taxa", tags = { "CALCULAR TAXA" })
public class TaxaController {
	
	@Autowired
	private ICalculoTaxaService calculador;
	
	@CrossOrigin
	@ApiOperation(value = "Calcular a taxa da transacao", response = BigDecimal.class)
	@PostMapping("/calculo")
	public ResponseEntity<BigDecimal> calcularTaxa(@RequestBody TransacaoBancaria transacaoBancaria){
		BigDecimal calcularTaxa = calculador.calcularTaxa(transacaoBancaria);
		return new ResponseEntity<BigDecimal>(calcularTaxa, !ObjectUtils.isEmpty(calcularTaxa)? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
