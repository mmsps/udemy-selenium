package br.gov.cursoSelenium.pages;

import static br.gov.cursoSelenium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.gov.cursoSelenium.core.BasePage;
import br.gov.cursoSelenium.core.DriverFactory;;

public class LoginPage extends BasePage {

	public void acessarPaginaInicial(){
		WebDriver driver = getDriver();
		driver.get("https://seubarriga.wcaquino.me");		
		
	}
	
	public void setEmail(String email){
		escreve("email", email);
	}
	
	public void setSenha(String senha){
		escreve("senha", senha);
	}
	
	public void entrar(){
		clicarBotaoPorTexto("Entrar");	
	}
	
	public void logar(String email, String senha){
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	
}
