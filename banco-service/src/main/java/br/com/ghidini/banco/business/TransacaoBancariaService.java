package br.com.ghidini.banco.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghidini.banco.business.interfaces.ITransacaoBancariaService;
import br.com.ghidini.banco.model.TransacaoBancaria;
import br.com.ghidini.banco.repository.TransacaoBancariaRepository;

@Service
public class TransacaoBancariaService implements ITransacaoBancariaService{
	
	private static final Logger logger = Logger.getLogger(TransacaoBancariaService.class);
	
	@Autowired
	private TransacaoBancariaRepository repository;
	
	@Override
	public TransacaoBancaria inserirTransacao(TransacaoBancaria transacaoBancaria) {
		
		TransacaoBancaria transacao = new TransacaoBancaria();
		
		try {
			
			transacao = repository.save(transacaoBancaria);
			
		} catch(Exception ex) {
			logger.error("Ocorreu um erro ao gravar a transacao " + ex.getMessage());
		}
		
		return transacao;
	}

	@Override
	public List<TransacaoBancaria> listarTransacoes() {
		
		List<TransacaoBancaria> listTransacao = new ArrayList<TransacaoBancaria>();
		
		try {
			
			listTransacao = repository.findAll();
			
		} catch(Exception ex) {
			logger.error("Ocorreu um erro ao listar as transacoes " + ex.getMessage());
		}
		
		return listTransacao;
	}

}
