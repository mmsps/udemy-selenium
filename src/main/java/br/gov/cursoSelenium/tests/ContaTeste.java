package br.gov.cursoSelenium.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.gov.cursoSelenium.core.BaseTest;
import br.gov.cursoSelenium.core.Propriedades;
import br.gov.cursoSelenium.pages.ContasPage;
import br.gov.cursoSelenium.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTeste extends BaseTest {
    MenuPage pageMenu = new MenuPage();
	ContasPage pageContas = new ContasPage();
    
	@Test
	public void test1_InserirConta(){
		pageMenu.acessarTelaInserirContas();
		pageContas.setNome("Conta Maurício");
		pageContas.salvar();
	    Assert.assertEquals(pageContas.obterMensagemSucesso(),"Conta adicionada com sucesso!");
		
	}
	
	@Test
	public void test2_AlterarConta(){		
		pageMenu.Listar();
		pageContas.alterarConta("Conta Maurício");
		pageContas.setNome(Propriedades.NOME_CONTA_ALTERADA);
		pageContas.salvar();
	    Assert.assertEquals(pageContas.obterMensagemSucesso(),"Conta alterada com sucesso!");
		
	}
	
	@Test
	public void test3_InserirContaRepetida(){
		pageMenu.acessarTelaInserirContas();
		pageContas.setNome(Propriedades.NOME_CONTA_ALTERADA);
		pageContas.salvar();
	    Assert.assertEquals(pageContas.obterMensagemErro(),"Já existe uma conta com esse nome!");
	}

}
