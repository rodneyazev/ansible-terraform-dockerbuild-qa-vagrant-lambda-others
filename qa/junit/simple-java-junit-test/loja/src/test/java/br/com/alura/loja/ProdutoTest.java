package br.com.alura.loja;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class ProdutoTest {

	@Test
	public void test() {
		Produto produto = new Produto("teste", BigDecimal.TEN);
		Assert.assertEquals("teste", produto.getNome());
		Assert.assertEquals(BigDecimal.TEN, produto.getPreco());
	}

}
