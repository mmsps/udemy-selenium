package br.gov.cursoSelenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.gov.cursoSelenium.core.BasePage;

public class ContasPage extends BasePage {

	public void setNome(String nome){
		escreve("nome", nome);
	}
	
	public void salvar(){
		clicarBotaoPorTexto("Salvar");
	}

	public void alterarConta(String conta) {
		WebElement element = obterCelula("Conta",conta, "Ações","tabelaContas");
		element.findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
	
	public void excluirConta(String conta) {
		WebElement element = obterCelula("Conta",conta, "Ações","tabelaContas");
		element.findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
		
	}
}
