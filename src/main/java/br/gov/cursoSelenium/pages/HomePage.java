package br.gov.cursoSelenium.pages;

import org.openqa.selenium.WebElement;

import br.gov.cursoSelenium.core.BasePage;

public class HomePage extends BasePage {
	
     public String retornaSaldo(String conta) {
    	 WebElement element = obterCelula("Conta",conta, "Saldo","tabelaSaldo");
    	 return element.getText();
    	 
    	 
     }
}
