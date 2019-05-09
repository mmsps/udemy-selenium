package br.gov.cursoSelenium.pages;

import org.openqa.selenium.By;

import br.gov.cursoSelenium.core.BasePage;

public class MenuPage extends BasePage {

	public void home(){
        clicar(By.xpath("//a[contains(.,'Home')]"));
	}

	public void contas(){
		clicar(By.xpath("//a[contains(.,'Contas')]"));
	}

	
	public void resumoMensal(){

	}

	public void sair(){

	}
	
	public void acessarTelaInserirContas(){
		contas();
		clicar(By.xpath("//a[contains(.,'Adicionar')]"));
		
	}
	
	public void acessarTelaInserirMovimentacao (){
		clicarLink("Criar Movimentação");
	}
	
	public void acessarResumo(){
		clicarLink("Resumo Mensal");
	}
		
	public void Listar(){
		contas();
		clicar(By.xpath("//a[contains(.,'Listar')]"));
	}


}
