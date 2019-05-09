package br.gov.cursoSelenium.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;

import static br.gov.cursoSelenium.core.DriverFactory.getDriver;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.gov.cursoSelenium.core.BaseTest;
import br.gov.cursoSelenium.pages.MenuPage;
import br.gov.cursoSelenium.pages.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	
		private MenuPage pageMenu = new MenuPage();
		private ResumoPage pageResumo = new ResumoPage();
	
	@Test
	public void test1_excluirMovimentacao(){
		pageMenu.acessarResumo();
		pageResumo.selMes("Abril");
		pageResumo.selAno("2019");
		pageResumo.buscar();
		pageResumo.excluirMovimentacao("Movimentacao da conta alterada 2");
		Assert.assertEquals("Movimentação removida com sucesso!", pageResumo.obterMensagemSucesso());
		
		
	}
	
	@Test
	public void test2_verificaTituloTela() {
		pageMenu.acessarResumo();
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
	}

}
