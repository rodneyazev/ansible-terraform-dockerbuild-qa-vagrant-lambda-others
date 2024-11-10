package br.com.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void reajustarSalario(BigDecimal percentual) {
		BigDecimal aumento = calcularValorDoAumento(percentual);
		this.salario = this.salario.add(aumento).setScale(2, RoundingMode.HALF_UP);
	}
	
	private BigDecimal calcularValorDoAumento(BigDecimal percentual) {
		return salario.multiply(percentual);
	}

}
