package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	
	private Lance lance;
	private Leilao leilao;
	private ArrayList<Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
		System.out.println("before");
	}
	
	@After
	public void tearDown() {
		System.out.println("after");
	}
	
	@Dado("um lance valido")
	public void dadum_um_lance_valido() {
		Usuario usuario = new Usuario("Fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propoe lance ao leilao")
	public void quando_propoe_o_lance() {
		leilao = new Leilao("Tablet XPTO");
		leilao.propoe(lance);
	}
	
	@Então("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
		Assertions.assertEquals(1, leilao.getLances().size());
		Assertions.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario(Double valor, String nomeUsuario) {
	   lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
	   lista.add(lance);
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		this.lista.forEach(lance -> leilao.propoe(lance));
	}
	
	@Então("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assertions.assertEquals(this.lista.size(), leilao.getLances().size());
		Assertions.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assertions.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}

}
