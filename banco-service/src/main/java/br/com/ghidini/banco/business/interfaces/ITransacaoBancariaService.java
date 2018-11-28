package br.com.ghidini.banco.business.interfaces;

import java.util.List;

import br.com.ghidini.banco.model.TransacaoBancaria;

public interface ITransacaoBancariaService {
	
	public TransacaoBancaria inserirTransacao(TransacaoBancaria transacaoBancaria);
	public List<TransacaoBancaria> listarTransacoes();

}
