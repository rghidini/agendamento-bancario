package br.com.ghidini.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACAO_BANCARIA")
public class TransacaoBancaria implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_TRANSACAO", allocationSize = 1, sequenceName = "SEQ_TRANSACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACAO")
	@Column(name = "ID_TRANSACAO")
	private Long codigoTransacao;
	
	@Column(name = "CONTA_ORIGEM")
	private Integer contaOrigem;
	
	@Column(name = "CONTA_DESTINO")
	private Integer contaDestino;
	
	@Column(name = "VALOR_TRANSF")
	private BigDecimal valorTransferencia;
	
	@Column(name = "TAXA")
	private BigDecimal taxa;
	
	@Column(name = "DT_AGENDAMENTO", columnDefinition = "DATE")
	private LocalDate dataAgendamento;
	
	@Column(name = "DT_TRANSF", columnDefinition = "DATE")
	private LocalDate dataTransferencia;
	
	public TransacaoBancaria(){}

	public TransacaoBancaria(Long codigoTransacao, Integer contaOrigem, Integer contaDestino, BigDecimal valorTransferencia,
			BigDecimal taxa, LocalDate dataAgendamento, LocalDate dataTransferencia) {
		this.codigoTransacao = codigoTransacao;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.taxa = taxa;
		this.dataAgendamento = dataAgendamento;
		this.dataTransferencia = dataTransferencia;
	}

	public Long getCodigoTransacao() {
		return codigoTransacao;
	}

	public void setCodigoTransacao(Long codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
	}

	public Integer getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Integer contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Integer getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Integer contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}

	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}

	@Override
	public String toString() {
		return "TransacaoBancaria [codigoTransacao=" + codigoTransacao + ", contaOrigem=" + contaOrigem + ", contaDestino="
				+ contaDestino + ", valorTransferencia=" + valorTransferencia + ", taxa=" + taxa + ", dataAgendamento="
				+ dataAgendamento + ", dataTransferencia=" + dataTransferencia + "]";
	}


}
