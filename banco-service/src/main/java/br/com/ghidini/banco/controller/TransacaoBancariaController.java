package br.com.ghidini.banco.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghidini.banco.business.interfaces.ITransacaoBancariaService;
import br.com.ghidini.banco.model.TransacaoBancaria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin
@RequestMapping(value = "/transacoes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Transacao Bancaria", tags = { "TRANSACAO BANCARIA" })
public class TransacaoBancariaController {

	@Autowired
	private ITransacaoBancariaService transacaoBancariaService;
	
	@CrossOrigin
	@ApiOperation(value = "Listar todas as transacoes", response = TransacaoBancaria.class)
	@GetMapping
	public ResponseEntity<List<TransacaoBancaria>> listAll(){
		List<TransacaoBancaria> listarTransacoes = transacaoBancariaService.listarTransacoes();
		return new ResponseEntity<List<TransacaoBancaria>>(listarTransacoes, CollectionUtils.isNotEmpty(listarTransacoes)? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@ApiOperation(value = "Cadastrar novas transacoes", response = TransacaoBancaria.class)
	@PostMapping("/cadastro")
	public ResponseEntity<TransacaoBancaria> insert(@RequestBody TransacaoBancaria transacaoBancaria){
		TransacaoBancaria inserirTransacao = transacaoBancariaService.inserirTransacao(transacaoBancaria);
		return new ResponseEntity<TransacaoBancaria>(inserirTransacao, !ObjectUtils.isEmpty(inserirTransacao)? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR);
	}



}
