package br.gov.cursoSelenium.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.gov.cursoSelenium.core.DriverFactory;
import br.gov.cursoSelenium.pages.LoginPage;
import br.gov.cursoSelenium.tests.ContaTeste;
import br.gov.cursoSelenium.tests.MovimentacaoTeste;
import br.gov.cursoSelenium.tests.RemoverMovimentacao;
import br.gov.cursoSelenium.tests.ResumoTest;
import br.gov.cursoSelenium.tests.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTeste.class,
	MovimentacaoTeste.class,
	SaldoTest.class,
	RemoverMovimentacao.class,
	ResumoTest.class

})
public class SuiteGeral {
	private static LoginPage loginPage = new LoginPage();

	@BeforeClass
	public static void inicializa(){
		loginPage.acessarPaginaInicial();
		loginPage.setEmail("mauricio.paiva@gmail.com");
		loginPage.setSenha("10013543");
		loginPage.entrar();
	}

	@AfterClass
	public static void kill(){
		DriverFactory.killDriver();	
	}

}