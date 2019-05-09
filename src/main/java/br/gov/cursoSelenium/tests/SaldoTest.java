package br.gov.cursoSelenium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cursoSelenium.core.BaseTest;
import br.gov.cursoSelenium.core.Propriedades;
import br.gov.cursoSelenium.pages.HomePage;
import br.gov.cursoSelenium.pages.MenuPage;

public class SaldoTest extends BaseTest {
    private HomePage pageHome = new HomePage();
    private MenuPage pageMenu = new MenuPage();
	
	@Test
	public void testSaldoConta() {
		pageMenu.home();
		Assert.assertEquals("45.00", pageHome.retornaSaldo(Propriedades.NOME_CONTA_ALTERADA));
	}
	
}
