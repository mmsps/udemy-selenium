package br.gov.cursoSelenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.gov.cursoSelenium.core.BasePage;

public class MovimentacaoPage extends BasePage {
	
	public void setDataMovimentacao(String data){
		escreve("data_transacao", data);
		
	}
	
	public void setDataPagamento(String data){
		escreve("data_pagamento", data);
		
	}
	
	public void setDescricao(String desc){
		escreve("descricao", desc);
		
	}
	
	public void setInteressado(String interessado){
		escreve("interessado", interessado);
		
	}
	
	public void setValor(String valor){
		escreve("valor", valor);
		
	}
	
	public void selConta(String conta){
		selecionaItem("conta", conta);
		
	}
	
	public void setSituacao (String sit){
		clicar(By.xpath("//input[contains(@id,'"+sit+"')]"));
				
	}
	
	public void salvar(){
		clicarBotaoPorTexto("Salvar");
	}
	
	
	
	
	

}
