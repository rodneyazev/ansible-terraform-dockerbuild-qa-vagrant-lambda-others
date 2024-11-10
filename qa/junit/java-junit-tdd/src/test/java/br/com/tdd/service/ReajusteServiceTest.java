package br.com.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.tdd.modelo.Desempenho;
import br.com.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	private ReajusteService service;
	private Funcionario funcionario;
	
	// Chamado antes de cada método, de cada teste
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2000.00"));
	}
	
	// Chamado depois de cada método, cada teste
	@AfterEach
	public void finalizar() {
		System.out.println("fim");
	}
	
	// o que roda uma única vez tem que ser static
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	// o que roda uma única vez tem que ser static
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}
	
	
	@Test
	void reajusteDeveSerDeTresPorcentoQuandoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		Assertions.assertEquals(new BigDecimal("2060.00"), funcionario.getSalario());
		
	}

	@Test
	void reajusteDeveSerDeTresPorcentoQuandoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		Assertions.assertEquals(new BigDecimal("2300.00"), funcionario.getSalario());
	}

	@Test
	void reajusteDeveSerDeTresPorcentoQuandoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		Assertions.assertEquals(new BigDecimal("2400.00"), funcionario.getSalario());
	}
	
}
