package br.gov.cursoSelenium.pages;

import org.openqa.selenium.By;

import br.gov.cursoSelenium.core.BasePage;

public class ResumoPage extends BasePage {
	
	public void selMes(String mes){
		selecionaItem("mes", mes);
		
	}
	
	public void selAno(String ano){
		selecionaItem("ano", ano);
		
	}
	
	public void excluirMovimentacao(String mov){
		clicarAcao("Descrição", mov, "Ações", "tabelaExtrato");		
	}
	
	public void buscar(){
		clicar(By.xpath("//input[@value='Buscar']"));		
	}

}
