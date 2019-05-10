package br.gov.cursoSelenium.core;


import static br.gov.cursoSelenium.core.DriverFactory.getDriver;
import static br.gov.cursoSelenium.core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.gov.cursoSelenium.pages.LoginPage;

public class BaseTest {

	
	@Rule
	public TestName testName = new  TestName();
	
	private LoginPage pageLogin = new LoginPage();
	
	@Before
	public void inicializa() {
		
		pageLogin.acessarPaginaInicial();
		pageLogin.setEmail("mauricio.paiva@gmail.com");
		pageLogin.setSenha("10013543");
		pageLogin.entrar();
		
	}
	
	@After
	public void end() {
		TakesScreenshot foto = (TakesScreenshot) getDriver();
		File arquivo = foto.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(arquivo, new File("target"+ File.separator + "screenshot" + File.separator + testName.getMethodName()+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		if (Propriedades.FECHAR_BROWSER){
			killDriver();
		}
	}
}
