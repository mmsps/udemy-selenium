package br.gov.cursoSelenium.tests;

import org.junit.Assert;
import org.junit.Test;

import br.gov.cursoSelenium.core.BaseTest;
import br.gov.cursoSelenium.core.Propriedades;
import br.gov.cursoSelenium.pages.ContasPage;
import br.gov.cursoSelenium.pages.MenuPage;
import br.gov.cursoSelenium.pages.MovimentacaoPage;

public class RemoverMovimentacao extends BaseTest {
	 private MenuPage pageMenu = new MenuPage();
	    private MovimentacaoPage movPage = new  MovimentacaoPage();
	    private ContasPage contasPage = new ContasPage();
				
	
	
	@Test
	public void excluirMovimentacaoUtilizadaNaConta(){
		pageMenu.Listar();
		contasPage.excluirConta(Propriedades.NOME_CONTA_ALTERADA);		
		Assert.assertEquals("Conta em uso na movimentações",contasPage.obterMensagemErro());
		
		
		
		
		
		
	}
	
}
